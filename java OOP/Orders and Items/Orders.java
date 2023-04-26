import java.util.ArrayList;

public class Orders {
    public String name;
    public Double total;
    public Boolean ready;
    public ArrayList<Items> items;

    public Orders(String name){
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<Items>();


    }
}