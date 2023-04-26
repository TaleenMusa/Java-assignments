import java.lang.reflect.Array;
import java.util.Random;
import java.util.stream.Stream;
import java.util.ArrayList;

public class PuzzleJava {
    public static ArrayList<Integer> getTenRolls(){
        Random randMachine = new Random();
        
        ArrayList<Integer> arr = new ArrayList<Integer>(0);
        for(int i = 1; i<=10;i++){
            arr.add(randMachine.nextInt(20)+1);
            }
        return arr;
    }
    public static char getRandomLetter(){
        char[] chars=new char[26];
        int i=0;
        for (char c = 'a'; c <= 'z'; c++) {
            chars[i]=c;
            i++;
        }
        Random randMachine = new Random();
            i=randMachine.nextInt(25);
        return chars[i];
    }
    public static String generatePassword(){

        String pass = new String();

            for(int i=0;i<8;i++){
                char temp = getRandomLetter();
                String t= new String(String.valueOf(temp));
                pass = pass.concat(t);
            }

        return pass;
    }
    public static ArrayList<String> getNewPasswordSet(int num){
        ArrayList<String> passwords = new ArrayList<String>();
        for(int i=0;i<num;i++){
            String temp=new String(generatePassword());
            passwords.add(temp);
        }
        return passwords;
    }

}