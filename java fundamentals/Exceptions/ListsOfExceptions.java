import java.util.Random;
import java.util.*;

public class ListsOfExceptions {
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        try {
            for(int i = 0; i < myList.size(); i++) {
                Integer castedValue2 = (Integer) myList.get(12);

            }
        }
        catch(ClassCastException e){
            System.out.println("Class Cast Exception error");

        }
        catch(IndexOutOfBoundsException e){
            System.out.println("this index not in list");

        }
        catch (Exception e){
            System.out.println("Unkow error");

        }



}
}