package pl.dmk0001.chatmanager.utils;

import org.bukkit.command.CommandSender;
import pl.dmk0001.chatmanager.manager.ConfigManager;
import java.util.ArrayList;

public class ChatUtils {

    private static final ArrayList<String> slowMode = new ArrayList<>();

    public void setStatus(boolean status, CommandSender sender, boolean chatStatus){
        if (chatStatus == status){
            if (chatStatus)
                Utils.sendMessage(sender, ConfigManager.getChatCurrentlyEnabled());
            else
                Utils.sendMessage(sender, ConfigManager.getChatCurrentlyDisabled());
            return;
        }
        new ConfigManager().setChatStatus(status);
        if (chatStatus) {
            Utils.sendMessage(sender, ConfigManager.getChatDisabled());
            Utils.sendAlert(ConfigManager.getChatDisabledAlert().replace("{PLAYER}", sender.getName()));
        }
        else {
            Utils.sendMessage(sender, ConfigManager.getChatEnabled());
            Utils.sendAlert(ConfigManager.getChatEnabledAlert().replace("{PLAYER}", sender.getName()));
        }
    }

    public void clearChat(CommandSender sender){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= 100; i++)
            stringBuilder.append(" \n");

        Utils.sendBroadcast(stringBuilder.toString());
        Utils.sendMessage(sender, ConfigManager.getChatCleared());
        Utils.sendAlert(ConfigManager.getChatClearedAlert().replace("{PLAYER}", sender.getName()));
    }

    public static ArrayList<String> getSlowMode() {
        return slowMode;
    }
}