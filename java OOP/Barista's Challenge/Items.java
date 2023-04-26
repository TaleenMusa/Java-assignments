public class Items {
    private String name;
    private Double price;
    
    public Items(String name,Double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

}