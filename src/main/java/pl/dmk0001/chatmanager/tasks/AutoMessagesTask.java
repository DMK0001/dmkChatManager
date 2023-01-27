package pl.dmk0001.chatmanager.tasks;

import pl.dmk0001.chatmanager.manager.ConfigManager;
import pl.dmk0001.chatmanager.utils.Utils;
import java.util.List;

public class AutoMessagesTask implements Runnable{

    private static int i = 0;

    @Override
    public void run(){
        if (!ConfigManager.isChatAutoMessagesStatus()) return;

        List<String> list = ConfigManager.getChatAutoMessagesList();
        if (i >= list.size()){
            i = 0;
        }
        Utils.sendBroadcast(list.get(i));
        i++;
    }
}