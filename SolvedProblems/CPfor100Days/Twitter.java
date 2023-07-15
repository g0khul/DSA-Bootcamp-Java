package SolvedProblems.CPfor100Days;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
    List<Integer> tweets;

    public Twitter() {
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        
        int numberOfTweets = 10;
        if(tweets.size() < 10){
            numberOfTweets = tweets.size();
        }

        for(int tweetCount = tweets.size(); tweetCount > numberOfTweets; tweetCount--){
            feed.add(tweetCount);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        
    }
}
