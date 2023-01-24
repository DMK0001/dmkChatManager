package pl.dmk0001.chatmanager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.dmk0001.chatmanager.commands.ChatCommand;
import pl.dmk0001.chatmanager.listeners.AsyncPlayerChatListener;
import pl.dmk0001.chatmanager.manager.ConfigManager;
import pl.dmk0001.chatmanager.metrics.bStats;
import pl.dmk0001.chatmanager.tasks.AutoMessagesTask;
import pl.dmk0001.chatmanager.utils.Utils;

public final class ChatManager extends JavaPlugin {

    private static ChatManager instance;

    @Override
    public void onEnable() {
        instance = this;

        new ConfigManager().load();

        if (ConfigManager.isbStats())
            new bStats(this, 17507);

        getServer().getCommandMap().register("chat", new ChatCommand());

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new AsyncPlayerChatListener(), this);

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, new AutoMessagesTask(), ((20 * 60) * ConfigManager.getChatAutoMessagesTime()), ((20 * 60) * ConfigManager.getChatAutoMessagesTime()));
        Utils.sendConsole("&6> &eSuccessfully loaded &6dmkChatManager&e!");
    }

    @Override
    public void onDisable() {
        Utils.sendConsole("&6> &eSuccessfully unloaded &6dmkChatManager&e!");
    }

    public static ChatManager getInstance() {
        return instance;
    }
}