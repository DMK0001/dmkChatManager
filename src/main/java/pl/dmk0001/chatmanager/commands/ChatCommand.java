package pl.dmk0001.chatmanager.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;
import pl.dmk0001.chatmanager.ChatManager;
import pl.dmk0001.chatmanager.manager.ConfigManager;
import pl.dmk0001.chatmanager.utils.ChatUtils;
import pl.dmk0001.chatmanager.utils.Utils;

public class ChatCommand extends BukkitCommand {

    public ChatCommand(){
        super("chat");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (!sender.hasPermission("dmkChatManager.settings")){
            Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings"));
            return true;
        }

        if (args.length != 1){
            for (String string : ConfigManager.getChatCommandUsage())
                Utils.sendMessage(sender, string);
            return true;
        }

        boolean chatStatus = ConfigManager.isChatStatus();
        boolean chatSlowModeStatus = ConfigManager.isChatSlowModeStatus();
        boolean chatPlayedTimeModeStatus = ConfigManager.isChatPlayedTimeModeStatus();
        boolean chatAutoMessagesStatus = ConfigManager.isChatAutoMessagesStatus();

        switch (args[0].toLowerCase()){
            case "off":
                if (!sender.hasPermission("dmkChatManager.settings.chat.off")){
                    Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings.chat.off"));
                    break;
                }
                new ChatUtils().setStatus(false, sender, chatStatus);
                break;
            case "on":
                if (!sender.hasPermission("dmkChatManager.settings.chat.on")){
                    Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings.chat.on"));
                    break;
                }
                new ChatUtils().setStatus(true, sender, chatStatus);
                break;
            case "clear":
                if (!sender.hasPermission("dmkChatManager.settings.chat.clear")){
                    Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings.chat.clear"));
                    break;
                }
                new ChatUtils().clearChat(sender);
                break;
            case "slowmode":
                if (!sender.hasPermission("dmkChatManager.settings.slowmode")){
                    Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings.slowmode"));
                    break;
                }
                new ConfigManager().setChatSlowModeStatus(!ConfigManager.isChatSlowModeStatus());
                if (chatSlowModeStatus) {
                    Utils.sendMessage(sender, ConfigManager.getChatSlowModeDisabled());
                    Utils.sendAlert(ConfigManager.getChatSlowModeDisabledAlert().replace("{PLAYER}", sender.getName()));
                }
                else {
                    Utils.sendMessage(sender, ConfigManager.getChatSlowModeEnabled());
                    Utils.sendAlert(ConfigManager.getChatSlowModeEnabledAlert().replace("{PLAYER}", sender.getName()));
                }
                break;
            case "playedtimemode":
                if (!sender.hasPermission("dmkChatManager.settings.playedtimemode")){
                    Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings.playedtimemode"));
                    break;
                }
                new ConfigManager().setChatPlayedTimeModeStatus(!chatPlayedTimeModeStatus);
                if (chatPlayedTimeModeStatus) {
                    Utils.sendMessage(sender, ConfigManager.getChatPlayedTimeModeDisabled());
                    Utils.sendAlert(ConfigManager.getChatPlayedTimeModeDisabledAlert().replace("{PLAYER}", sender.getName()));
                }
                else {
                    Utils.sendMessage(sender, ConfigManager.getChatPlayedTimeModeEnabled());
                    Utils.sendAlert(ConfigManager.getChatPlayedTimeModeEnabledAlert().replace("{PLAYER}", sender.getName()));
                }
                break;
            case "automessages":
                if (!sender.hasPermission("dmkChatManager.settings.automessages")){
                    Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings.automessages"));
                    break;
                }
                new ConfigManager().setChatAutoMessagesStatus(!chatAutoMessagesStatus);
                if (chatAutoMessagesStatus) {
                    Utils.sendMessage(sender, ConfigManager.getChatAutoMessagesDisabled());
                    Utils.sendAlert(ConfigManager.getChatAutoMessagesDisabledAlert().replace("{PLAYER}", sender.getName()));
                }
                else {
                    Utils.sendMessage(sender, ConfigManager.getChatAutoMessagesEnabled());
                    Utils.sendAlert(ConfigManager.getChatAutoMessagesEnabledAlert().replace("{PLAYER}", sender.getName()));
                }
                break;
            case "reload":
                if (!sender.hasPermission("dmkChatManager.settings.reload")){
                    Utils.sendMessage(sender, ConfigManager.getChatNoPerm().replace("{PERM}", "dmkChatManager.settings.reload"));
                    break;
                }
                ChatManager.getInstance().reloadConfig();
                new ConfigManager().load();
                Utils.sendMessage(sender, ConfigManager.getChatConfigReload());
                break;
            default:
                for (String string : ConfigManager.getChatCommandUsage())
                    Utils.sendMessage(sender, string);
                break;
        }
        return true;
    }
}