import java.util.ArrayList;

public class CoffeeKiosk{
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    private int itemCount; // Added itemCount field to keep track of item index

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
        this.itemCount = 0; // Initialize itemCount to 0
    }

    // Methods:
    public void addMenuItem(String name,double price){

        Item item1 = new Item(name, price, itemCount); 
        menu.add(item1);
        itemCount++; 
    }

    public void displayMenu(){
        for (Item item : this.menu){
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }

    public void newOrder() {
    

        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();


        Order order1=new Order(name);

        this.displayMenu();

        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        while(!itemNumber.equals("q")) {
            order1.addItem(this.menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();

        }
        
        this.orders.add(order1);

        order1.display();

    }
}
