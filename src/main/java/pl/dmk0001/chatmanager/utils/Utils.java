package pl.dmk0001.chatmanager.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.dmk0001.chatmanager.manager.ConfigManager;

public class Utils {

    public static String fixColor(String string){
        return ChatColor.translateAlternateColorCodes('&', string.replace("&", "§").replace(">>", "»").replace("<<", "«"));
    }

    public static void sendConsole(String string){
        Bukkit.getConsoleSender().sendMessage(fixColor("&6[dmkChatManager] > " + string));
    }

    public static void sendMessage(CommandSender commandSender, String string){
        commandSender.sendMessage(fixColor(string));
    }

    public static void sendBroadcast(String string){
        for (Player player : Bukkit.getOnlinePlayers())
            player.sendMessage(fixColor(string));
    }

    public static void sendAlert(String string){
        if (ConfigManager.isAlertMessage())
            sendBroadcast(string);
    }
}