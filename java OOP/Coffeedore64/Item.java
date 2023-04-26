public class Item{
    private String name;
    private double price;
    private int index;

    public Item(String name, double price,int index){
        this.name=name;
        this.price=price;
        this.index=index;
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price=price;
    }

    public int getIndex() {
        return this.index;
    }
    public void setIndex(int index) {
        this.index=index;
    }
}
