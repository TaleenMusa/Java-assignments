import java.util.ArrayList;

public class CafeUtil {
    public static int getStreakGoal(){
        int sum=0;
        for(int i=1;i<=10;i++){
            sum=sum+i;
        }
        return sum;
    }
    public static double getOrderTotal(double[] prices){
        double total=0;
        for(Double item : prices){
            total=total+item;
        }
        return total;
    }
    public static void displayMenu(ArrayList<String> menuItems){
        int i=0;
        for(String item : menuItems){
            System.out.println(i+" "+item);
            i++;
        }
    }
    public static void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, "+userName);
        int num = customers.size();
        System.out.println(String.format("There are %d people in front of you", num));
        customers.add(userName);
    }

}
