package pl.dmk0001.chatmanager.manager;

import pl.dmk0001.chatmanager.ChatManager;
import pl.dmk0001.chatmanager.utils.Utils;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateCheckerManager {

    public void checkUpdate(){
        try {
            String pluginVersion = ChatManager.getInstance().getDescription().getVersion();

            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=107584").openConnection();
            httpsURLConnection.setRequestMethod("GET");

            String latestVersion = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream())).readLine();

            if (pluginVersion.equals(latestVersion))
                Utils.sendConsole("&eYou are using the latest version of the plugin!");
            else
                Utils.sendConsole("&eYou are using an outdated version of the plugin!" +
                        "\n                   &eDownload the latest plugin version:" +
                        "\n                   &6https://www.spigotmc.org/resources/dmkchatmanager.107584/");
        }
        catch (Exception ignored){}
    }
}