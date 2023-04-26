import java.util.ArrayList;

public class TestOrders {
        public static void main(String[] args) {

        // Menu items

        // Order variables -- order1, order2 etc.

        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);


        Items item1 = new Items("mocha",5.5);
        Items item2 = new Items("latte",7.5);
        Items item3 = new Items("drip coffee",6.5);
        Items item4 = new Items("capuccino",8.5);

        Orders order1 = new Orders("Cindhuri");
        Orders order2 = new Orders("Jimmy");
        Orders order3 = new Orders("Noah");
        Orders order4 = new Orders("Sam");

//Print the order1 variable to the console to see what happens.
        System.out.println(order1.name);
        System.out.println(order1.total);

//Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
		order2.total += item1.price;
		System.out.println("Hi, "+ order2.name +" Your total is "+ order2.total);

//order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.items.add(item4);
		order3.total += item4.price;
		System.out.println("Hi, "+ order3.name +" You oredred a "+ item4.name+",  Your total is "+ order3.total);

//order4 added a latte. Update accordingly.
        order4.items.add(item2);
        order4.total += item2.price;
        System.out.println("Hi, " + order4.name + " You ordered a " + item2.name + ", Your total is: " + order4.total);

//Cindhuri’s order is now ready. Update her status.
        order1.ready = true;
        if (order1.ready){
			System.out.println("Hi, " +order1.name+ " Your order is Ready!");
		}else{
			System.out.println("Sorry, Your order is not ready yet");
        }

//Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.total = (item2.price*2);
        System.out.println("Hi, " + order4.name + " You ordered a " + item2.name + ", Your total is: " + order4.total);

//Jimmy’s order is now ready. Update his status.
        order2.ready = true;
        if (order2.ready){
			System.out.println("Hi, " +order2.name+ " Your order is Ready!");
		}else{
			System.out.println("Sorry, Your order is not ready yet");
        }
        }
}
