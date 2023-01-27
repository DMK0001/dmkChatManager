package pl.dmk0001.chatmanager.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.dmk0001.chatmanager.manager.ConfigManager;
import pl.dmk0001.chatmanager.utils.Utils;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        //CustomJoinMessage
        if (ConfigManager.isCustomJoinMessageStatus())
            e.setJoinMessage(Utils.fixColor(ConfigManager.getCustomJoinMessage().replace("{PLAYER}", player.getName())));

        //FirstJoinMessage
        if (!player.hasPlayedBefore())
            Utils.sendBroadcast(ConfigManager.getNewPlayerJoinMessage().replace("{PLAYER}", player.getName()));

        //WelcomeMessage
        if (ConfigManager.isWelcomeMessageStatus()){
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : ConfigManager.getWelcomeMessage()){
                stringBuilder.append(string).append("\n");
            }
            Utils.sendMessage(player, stringBuilder.toString()
                    .replace("{PLAYER}", player.getName())
                    .replace("{PLAYERS}", String.valueOf(Bukkit.getOnlinePlayers().size()))
                    .replace("{MAX-PLAYERS}", String.valueOf(Bukkit.getMaxPlayers())));
        }
    }
}