package net.ngoar;

import org.apache.commons.lang3.StringUtils;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

class TwitterAggregator {
    private static final String TWITTER_DEFAULT_API = "https://api.twitter.com/1.1/";
    private String consumerKey = "r5Vfq3lLGUkx5UbaV72MCqkk8";
    private String consumerSecret = "wQVHgABD76wbRYDAxtxrVHNBnfA19pQAOS4F5YJ5ziZL6eWjIE";
    private String oAuthKey = "598472313-Qn2JCoZFhsZAG0OF09GZPWez9rhTZ7nMx8ZSJYyZ";
    private String oAuthSecret = "WvPGMZ3X26Y0IJUgQ1Oego6GnvIdIrrNg5lvQcXOa0zAj";
    private Twitter twitter;

    void init() {
        if (StringUtils.isBlank(consumerKey) ||
                StringUtils.isBlank(consumerSecret) ||
                StringUtils.isBlank(oAuthKey) ||
                StringUtils.isBlank(oAuthSecret)) {
            LOGGER.info("Some twitter service parameters not set. TwitterService disabled.");
        } else {
            try {
                Configuration twitterConfig = new ConfigurationBuilder().setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret).setOAuthAccessToken(oAuthKey).setOAuthAccessTokenSecret(oAuthSecret).setRestBaseURL(TWITTER_DEFAULT_API).build();
                twitter = new TwitterFactory(twitterConfig).getInstance();
            } catch (Exception e) {
                twitter = null;
            }
        }
    }

    List<SocialEntity> load(int size) {
        List<SocialEntity> result = new ArrayList<SocialEntity>();
        try {
            ResponseList<Status> userTimeline = twitter.getUserTimeline();
            for (int i = 0; i < size; i++) {
                String text = userTimeline.get(i).getText();
                Date created = userTimeline.get(i).getCreatedAt();
                SocialEntity socialEntity = new SocialEntity(text, created);
                result.add(socialEntity);
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return result;
    }
}
