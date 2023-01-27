package pl.dmk0001.chatmanager.manager;

import org.bukkit.configuration.file.FileConfiguration;
import pl.dmk0001.chatmanager.ChatManager;
import java.util.List;

public class ConfigManager {

    private static boolean bStats;
    private static boolean updatePluginNotification;
    private static boolean alertMessage;

    private static boolean chatStatus;
    private static String chatNoPerm;
    private static String chatEnabled;
    private static String chatDisabled;
    private static String chatCleared;
    private static String chatCurrentlyDisabled;
    private static String chatCurrentlyEnabled;
    private static String chatEnabledAlert;
    private static String chatDisabledAlert;
    private static String chatClearedAlert;
    private static String chatIsDisabled;
    private static List<String> chatCommandUsage;
    private static String chatConfigReload;

    private static boolean chatSlowModeStatus;
    private static int chatSlowModeTime;
    private static String chatSlowModeEnabled;
    private static String chatSlowModeDisabled;
    private static String chatSlowMode;
    private static String chatSlowModeEnabledAlert;
    private static String chatSlowModeDisabledAlert;

    private static boolean chatPlayedTimeModeStatus;
    private static int chatPlayedTimeModeTime;
    private static String chatPlayedTimeModeEnabled;
    private static String chatPlayedTimeModeDisabled;
    private static String chatPlayedTimeMode;
    private static String chatPlayedTimeModeEnabledAlert;
    private static String chatPlayedTimeModeDisabledAlert;

    private static boolean chatAutoMessagesStatus;
    private static int chatAutoMessagesTime;
    private static String chatAutoMessagesEnabled;
    private static String chatAutoMessagesDisabled;
    private static String chatAutoMessagesEnabledAlert;
    private static String chatAutoMessagesDisabledAlert;
    private static List<String> chatAutoMessagesList;

    private static boolean customJoinMessageStatus;
    private static String customJoinMessage;

    private static boolean customQuitMessageStatus;
    private static String customQuitMessage;

    private static String newPlayerJoinMessage;

    private static boolean welcomeMessageStatus;
    private static List<String> welcomeMessage;

    public void load(){
        ChatManager.getInstance().saveDefaultConfig();
        FileConfiguration fileConfiguration = ChatManager.getInstance().getConfig();
        bStats = fileConfiguration.getBoolean("config.bStats");
        updatePluginNotification = fileConfiguration.getBoolean("config.updatePluginNotification");
        alertMessage = fileConfiguration.getBoolean("config.alertMessage");

        chatStatus = fileConfiguration.getBoolean("config.chat.status");
        chatNoPerm = fileConfiguration.getString("config.chat.messages.chatNoPerm");
        chatEnabled = fileConfiguration.getString("config.chat.messages.chatEnabled");
        chatDisabled = fileConfiguration.getString("config.chat.messages.chatDisabled");
        chatCleared = fileConfiguration.getString("config.chat.messages.chatCleared");
        chatCurrentlyDisabled = fileConfiguration.getString("config.chat.messages.chatCurrentlyDisabled");
        chatCurrentlyEnabled = fileConfiguration.getString("config.chat.messages.chatCurrentlyEnabled");
        chatEnabledAlert = fileConfiguration.getString("config.chat.messages.chatEnabledAlert");
        chatDisabledAlert = fileConfiguration.getString("config.chat.messages.chatDisabledAlert");
        chatClearedAlert = fileConfiguration.getString("config.chat.messages.chatClearedAlert");
        chatIsDisabled = fileConfiguration.getString("config.chat.messages.chatIsDisabled");
        chatCommandUsage = fileConfiguration.getStringList("config.chat.chatCommandUsage");
        chatConfigReload = fileConfiguration.getString("config.chat.messages.chatConfigReload");

        chatSlowModeStatus = fileConfiguration.getBoolean("config.chatSlowMode.status");
        chatSlowModeTime = fileConfiguration.getInt("config.chatSlowMode.time");
        chatSlowModeEnabled = fileConfiguration.getString("config.chatSlowMode.messages.chatSlowModeEnabled");
        chatSlowModeDisabled = fileConfiguration.getString("config.chatSlowMode.messages.chatSlowModeDisabled");
        chatSlowMode = fileConfiguration.getString("config.chatSlowMode.messages.chatSlowMode");
        chatSlowModeEnabledAlert = fileConfiguration.getString("config.chatSlowMode.messages.chatSlowModeEnabledAlert");
        chatSlowModeDisabledAlert = fileConfiguration.getString("config.chatSlowMode.messages.chatSlowModeDisabledAlert");

        chatPlayedTimeModeStatus = fileConfiguration.getBoolean("config.chatPlayedTimeMode.status");
        chatPlayedTimeModeTime = fileConfiguration.getInt("config.chatPlayedTimeMode.time");
        chatPlayedTimeModeEnabled = fileConfiguration.getString("config.chatPlayedTimeMode.messages.chatPlayedTimeModeEnabled");
        chatPlayedTimeModeDisabled = fileConfiguration.getString("config.chatPlayedTimeMode.messages.chatPlayedTimeModeDisabled");
        chatPlayedTimeMode = fileConfiguration.getString("config.chatPlayedTimeMode.messages.chatPlayedTimeMode");
        chatPlayedTimeModeEnabledAlert = fileConfiguration.getString("config.chatPlayedTimeMode.messages.chatPlayedTimeModeEnabledAlert");
        chatPlayedTimeModeDisabledAlert = fileConfiguration.getString("config.chatPlayedTimeMode.messages.chatPlayedTimeModeDisabledAlert");

        chatAutoMessagesStatus = fileConfiguration.getBoolean("config.chatAutoMessages.status");
        chatAutoMessagesTime = fileConfiguration.getInt("config.chatAutoMessages.time");
        chatAutoMessagesEnabled = fileConfiguration.getString("config.chatAutoMessages.messages.chatAutoMessagesEnabled");
        chatAutoMessagesDisabled = fileConfiguration.getString("config.chatAutoMessages.messages.chatAutoMessagesDisabled");
        chatAutoMessagesEnabledAlert = fileConfiguration.getString("config.chatAutoMessages.messages.chatAutoMessagesEnabledAlert");
        chatAutoMessagesDisabledAlert = fileConfiguration.getString("config.chatAutoMessages.messages.chatAutoMessagesDisabledAlert");
        chatAutoMessagesList = fileConfiguration.getStringList("config.chatAutoMessages.autoMessages");

        customJoinMessageStatus = fileConfiguration.getBoolean("config.customJoinMessage.status");
        customJoinMessage = fileConfiguration.getString("config.customJoinMessage.message");

        customQuitMessageStatus = fileConfiguration.getBoolean("config.customQuitMessage.status");
        customQuitMessage = fileConfiguration.getString("config.customQuitMessage.message");

        newPlayerJoinMessage = fileConfiguration.getString("config.newPlayerJoinMessage");

        welcomeMessageStatus = fileConfiguration.getBoolean("config.welcomeMessage.status");
        welcomeMessage = fileConfiguration.getStringList("config.welcomeMessage.message");
    }

    //Getters
    public static boolean isbStats() {
        return bStats;
    }

    public static boolean isUpdatePluginNotification() {
        return updatePluginNotification;
    }

    public static boolean isChatStatus() {
        return chatStatus;
    }

    public static boolean isAlertMessage() {
        return alertMessage;
    }

    public static String getChatNoPerm() {
        return chatNoPerm;
    }

    public static String getChatEnabled() {
        return chatEnabled;
    }

    public static String getChatDisabled() {
        return chatDisabled;
    }

    public static String getChatCleared() {
        return chatCleared;
    }

    public static String getChatSlowModeEnabledAlert() {
        return chatSlowModeEnabledAlert;
    }

    public static String getChatSlowModeDisabledAlert() {
        return chatSlowModeDisabledAlert;
    }

    public static String getChatPlayedTimeModeEnabledAlert() {
        return chatPlayedTimeModeEnabledAlert;
    }

    public static String getChatPlayedTimeModeDisabledAlert() {
        return chatPlayedTimeModeDisabledAlert;
    }

    public static String getChatAutoMessagesEnabledAlert() {
        return chatAutoMessagesEnabledAlert;
    }

    public static String getChatAutoMessagesDisabledAlert() {
        return chatAutoMessagesDisabledAlert;
    }

    public static String getChatCurrentlyDisabled() {
        return chatCurrentlyDisabled;
    }

    public static String getChatCurrentlyEnabled() {
        return chatCurrentlyEnabled;
    }

    public static String getChatEnabledAlert() {
        return chatEnabledAlert;
    }

    public static String getChatDisabledAlert() {
        return chatDisabledAlert;
    }

    public static String getChatClearedAlert() {
        return chatClearedAlert;
    }

    public static String getChatIsDisabled() {
        return chatIsDisabled;
    }

    public static List<String> getChatCommandUsage() {
        return chatCommandUsage;
    }

    public static boolean isChatSlowModeStatus() {
        return chatSlowModeStatus;
    }

    public static int getChatSlowModeTime() {
        return chatSlowModeTime;
    }

    public static String getChatSlowModeEnabled() {
        return chatSlowModeEnabled;
    }

    public static String getChatSlowModeDisabled() {
        return chatSlowModeDisabled;
    }

    public static String getChatSlowMode() {
        return chatSlowMode;
    }

    public static boolean isChatPlayedTimeModeStatus() {
        return chatPlayedTimeModeStatus;
    }

    public static int getChatPlayedTimeModeTime() {
        return chatPlayedTimeModeTime;
    }

    public static String getChatPlayedTimeModeEnabled() {
        return chatPlayedTimeModeEnabled;
    }

    public static String getChatPlayedTimeModeDisabled() {
        return chatPlayedTimeModeDisabled;
    }

    public static String getChatPlayedTimeMode() {
        return chatPlayedTimeMode;
    }

    public static boolean isChatAutoMessagesStatus() {
        return chatAutoMessagesStatus;
    }

    public static int getChatAutoMessagesTime() {
        return chatAutoMessagesTime;
    }

    public static String getChatAutoMessagesEnabled() {
        return chatAutoMessagesEnabled;
    }

    public static String getChatAutoMessagesDisabled() {
        return chatAutoMessagesDisabled;
    }

    public static List<String> getChatAutoMessagesList() {
        return chatAutoMessagesList;
    }

    public static String getChatConfigReload() {
        return chatConfigReload;
    }

    public static String getCustomJoinMessage() {
        return customJoinMessage;
    }

    public static String getCustomQuitMessage() {
        return customQuitMessage;
    }

    public static String getNewPlayerJoinMessage() {
        return newPlayerJoinMessage;
    }

    public static boolean isWelcomeMessageStatus() {
        return welcomeMessageStatus;
    }

    public static List<String> getWelcomeMessage() {
        return welcomeMessage;
    }

    public static boolean isCustomJoinMessageStatus() {
        return customJoinMessageStatus;
    }

    public static boolean isCustomQuitMessageStatus() {
        return customQuitMessageStatus;
    }

    //Setters
    public void setChatStatus(boolean chatStatus) {
        ChatManager.getInstance().getConfig().set("config.chat.status", chatStatus);
        ChatManager.getInstance().saveConfig();
        load();
    }

    public void setChatSlowModeStatus(boolean chatSlowModeStatus) {
        ChatManager.getInstance().getConfig().set("config.chatSlowMode.status", chatSlowModeStatus);
        ChatManager.getInstance().saveConfig();
        load();
    }

    public void setChatPlayedTimeModeStatus(boolean chatPlayedTimeModeStatus){
        ChatManager.getInstance().getConfig().set("config.chatPlayedTimeMode.status", chatPlayedTimeModeStatus);
        ChatManager.getInstance().saveConfig();
        load();
    }

    public void setChatAutoMessagesStatus(boolean autoMessagesStatus){
        ChatManager.getInstance().getConfig().set("config.chatAutoMessages.status", autoMessagesStatus);
        ChatManager.getInstance().saveConfig();
        load();
    }
}