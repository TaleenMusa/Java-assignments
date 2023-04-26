import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

// Menu items
        Items item1 = new Items("mocha",5.5);
        Items item2 = new Items("latte",7.5);
        Items item3 = new Items("drip coffee",6.5);
        Items item4 = new Items("capuccino",8.5);

//Create 2 orders for unspecified guests (without specifying a name);
        // Orders order1 = new Orders();
        // Orders order2 = new Orders();
        Orders order1 = new Orders("Order 1"); 
        Orders order2 = new Orders("Order 2");

//Create 3 orders using the overloaded constructor to give each a name for the order.
        Orders order3 = new Orders("Taleen");
        Orders order4= new Orders("Ibrahim");
        Orders order5 = new Orders("Sam");


//adding items to orders 
		order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item4);
        order2.addItem(item3);

        order3.addItem(item1);
        order3.addItem(item4);

        order4.addItem(item3);
        order4.addItem(item1);

        order5.addItem(item2);
        order5.addItem(item4);
		

        order1.getStatusMessage();
        order2.getStatusMessage();
        order3.getStatusMessage();

//setting some orders to ready
        order5.setReady(true);
        order4.setReady(true);
        order2.setReady(true);

//Status messages 
		System.out.println(order1.getStatusMessage());
		System.out.println(order2.getStatusMessage());
		System.out.println(order3.getStatusMessage());
		System.out.println(order4.getStatusMessage());
		System.out.println(order5.getStatusMessage());

// order total 
		System.out.println(order1.getOrderTotal());
		System.out.println(order2.getOrderTotal());
		System.out.println(order3.getOrderTotal());
		System.out.println(order4.getOrderTotal());
		System.out.println(order5.getOrderTotal());

// display method
		order1.display();
		order2.display();
		order3.display();
		order4.display();
		order5.display();


        }
}
