import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s! Welcome to the party.", name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        return String.format("It is currently %s.", new Date());
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        // return "for snarky response return string";
        if (conversation.indexOf("Alexis")>-1){
            return("Right away, sir. She certainly isn't sophisticated enough for that");
        }
        else if (conversation.indexOf("Alfred")>-1){
            return("At your service. As you wish, naturally");
        }
        else {
            return("Right. And with that I shall retire");
        }
        
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}

