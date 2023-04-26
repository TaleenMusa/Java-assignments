// import java.util.ArrayList;

// public class Orders {
//     private String name;
//     private boolean ready;
//     private ArrayList<Items> items;

//     public Orders(String name) {
//         this.name = name;
//         this.ready = false;
//         this.items = new ArrayList<Items>(); // initializes the items array to an empty ArrayList
//     }

//     // Getters and Setters for name
//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     // Getters and Setters for ready
//     public boolean isReady() {
//         return ready;
//     }

//     public void setReady(boolean ready) {
//         this.ready = ready;
//     }

//     public void addItem(Items item) {
//         this.items.add(item);
//     }

//     public String getStatusMessage() {
//         if (this.ready) {
//             return "The order is ready";
//         } else {
//             return "Have a nice day";
//         }
//     }

//     public double getOrderTotal() {
//         double total = 0;
//         for (Items item : items) {
//             total += item.getPrice();
//         }
//         return total;
//     }

//     public void display() {
//         System.out.println("Order name: " + name);
//         System.out.println("Order total: " + getOrderTotal());
//         System.out.println("Order status: " + getStatusMessage());
//     }

//     public static void displayMenu(ArrayList<Items> items) {
//         int i = 0;
//         for (Items item : items) {
//             System.out.println(i + " " + item);
//             i++;
//         }
//     }
// }
import java.util.ArrayList;

public class Orders {
    private String name;
    private boolean ready;
    private ArrayList<Items> items;

    public Orders(String name) {
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<Items>(); // initializes the items array to an empty ArrayList
    }

    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for ready
    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void addItem(Items item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        if (this.ready) {
            return "The order is ready";
        } else {
            return "Your order will be ready soon";
        }
    }

    public double getOrderTotal() {
        double total = 0;
        for (Items item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.println("Order name: " + name);
        System.out.println("Order total: " + getOrderTotal());
        System.out.println("Order status: " + getStatusMessage());
    }

    public static void displayMenu(ArrayList<Items> items) {
        int i = 0;
        for (Items item : items) {
            System.out.println(i + " " + item);
            i++;
        }
    }
}
