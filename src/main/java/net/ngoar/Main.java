package net.ngoar;

public class Main {
    public static void main(String[] args) {
        TwitterAggregator twitterAggregator = new TwitterAggregator();
        twitterAggregator.init();
        Storage storage = new Storage();
        Scheduler scheduler = new Scheduler();
        scheduler.exec(twitterAggregator, storage);
    }
}
