import java.util.HashMap;
import java.util.Set;

class Hashmatique{
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Believer","I was broken from a young age Taking my sulking to the masses Writing my poems for the few That look at me, took to me, shook to me, feeling me Singing from heartache from the pain Taking my message from the veins Speaking my lesson from the brain Seeing the beauty through the...");
        trackList.put("Freedom","Don't let me go, Who cares what they see? Who cares what they know?Your first name is Free,Last name is Dom ,Cause you still believe in where we're from");
        trackList.put("Enemy","Tell you you're the greatest But once you turn, they hate us");
        trackList.put("Someone Like You","Nevermind, I'll find someone like you,I wish nothing but the best for you,Don't forget me, I beg, I remember you said");
        System.out.println(trackList.get("Enemy"));
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(trackList.get(key));    
        }
    }
}