package pl.dmk0001.chatmanager.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.dmk0001.chatmanager.ChatManager;
import pl.dmk0001.chatmanager.manager.ConfigManager;
import pl.dmk0001.chatmanager.utils.ChatUtils;
import pl.dmk0001.chatmanager.utils.Utils;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void asyncPlayerChat(AsyncPlayerChatEvent e){
        if (e.isCancelled()) return;
        Player player = e.getPlayer();

        //Chat disabled
        if (!ConfigManager.isChatStatus() && !player.hasPermission("dmkChatManager.bypass")){
            e.setCancelled(true);
            Utils.sendMessage(player, ConfigManager.getChatIsDisabled());
            return;
        }

        //ChatSlowMode
        if (ConfigManager.isChatSlowModeStatus() && !player.hasPermission("dmkChatManager.bypass")) {
            if (ChatUtils.getSlowMode().contains(player.getName())) {
                e.setCancelled(true);
                Utils.sendMessage(player, ConfigManager.getChatSlowMode());
                return;
            }
            ChatUtils.getSlowMode().add(player.getName());
            Bukkit.getScheduler().runTaskLaterAsynchronously(ChatManager.getInstance(), () -> ChatUtils.getSlowMode().remove(player.getName()), ConfigManager.getChatSlowModeTime() * 20L);
        }

        //ChatPlayedTimeMode
        if (ConfigManager.isChatPlayedTimeModeStatus() && !player.hasPermission("dmkChatManager.bypass")){
            int playerPlayedTime = (player.getStatistic(Statistic.TOTAL_WORLD_TIME) / 20) / 60;
            if (playerPlayedTime < ConfigManager.getChatPlayedTimeModeTime()){
                e.setCancelled(true);
                Utils.sendMessage(player, ConfigManager.getChatPlayedTimeMode().replace("{TIME}", String.valueOf(ConfigManager.getChatPlayedTimeModeTime())).replace("{YTIME}", String.valueOf(playerPlayedTime)));
            }
        }
    }
}