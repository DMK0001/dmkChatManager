package pl.dmk0001.chatmanager.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.dmk0001.chatmanager.manager.ConfigManager;
import pl.dmk0001.chatmanager.utils.Utils;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void playerQuit(PlayerQuitEvent e){
        //CustomQuitMessage
        if (ConfigManager.isCustomQuitMessageStatus())
            e.setQuitMessage(Utils.fixColor(ConfigManager.getCustomQuitMessage().replace("{PLAYER}", e.getPlayer().getName())));
    }
}
