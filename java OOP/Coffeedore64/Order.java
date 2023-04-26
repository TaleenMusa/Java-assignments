import java.util.ArrayList;

public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        this.name="Guest";
        ArrayList<Item> newitems = new ArrayList<Item>();
        this.items =newitems;
    }

    public Order(String name){
        this.name=name;
        ArrayList<Item> newitems = new ArrayList<Item>();
        this.items =newitems;
    }

    // Getters and Setters
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public boolean isReady(){
        return this.ready;
    }

    public void setReadyStatus(boolean ready){
        this.ready=ready;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getStatusMessage(){
        if (this.ready){
            return "Your order is ready";
        }
        else {
            return "Your order will be ready soon";
        }
    }

    public double getOrderTotal(){
        double total=0;
        for(Item item : this.items){
            total+=item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.println("Order name: " + name);
        System.out.println("Order total: " + getOrderTotal());
        System.out.println("Order status: " + getStatusMessage());
    }

    public void display(ArrayList<Item> items) { // Removed duplicate method name and added parameter
        System.out.println("Customer Name: " + this.name);
        for(Item item : this.items){
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }
}
