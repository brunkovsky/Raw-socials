package net.ngoar;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scheduler {
    private final static int BUFFER = 4;

    public void exec(TwitterAggregator twitterAggregator, Storage storage) {
        List<SocialEntity> load = twitterAggregator.load(BUFFER);
        final Map<Date, SocialEntity> loadMap = new HashMap<>();
        for (int i = 0; i < BUFFER - 1; i++) {
            loadMap.put(load.get(i).getDateOfPost(), load.get(i));
        }
        final Map<Date, SocialEntity> storage1 = storage.getStorage();
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                do {
                    storage1.putAll(loadMap);
                    System.out.println("storage = " + storage1);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (true);
            }
        };
        thread.start();
    }
}
