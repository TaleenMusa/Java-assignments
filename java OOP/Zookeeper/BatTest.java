public class BatTest{

    public static void main(String[] args) {

        Bat bat = new Bat();

        //Attack three towns
        bat.attackTown();
        bat.attackTown();
        bat.attackTown();

        //Eat two humans
        bat.eatHumans();
        bat.eatHumans();

        //Fly twice
        bat.fly();
        bat.fly();
    }
}