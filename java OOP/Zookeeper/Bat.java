public class Bat extends Mammal {
    public Bat(){
        this.energyLevel = 300;
    }
    public void attackTown(){
        this.energyLevel -= 100;
        System.out.println("The bat's energy level after attacking the town is: " + this.energyLevel);
    }
    public void eatHumans(){
        this.energyLevel += 25;
        System.out.println("The bat's energy level after eating humans is: "+ this.energyLevel);
    }

    public void fly(){
        this.energyLevel -= 50;
        System.out.println("The bat's energy level after flying is " + this.energyLevel);
    }
}
