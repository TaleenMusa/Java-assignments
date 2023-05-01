public class Gorilla extends Mammal {
    public void throwSomething() {
    this.energyLevel -= 5;
    System.out.println("The Gorilla has thrown something,Energy Level : "+ this.energyLevel);
    }

    public void eatBananas(){
    this.energyLevel += 10;
    System.out.println("Gorilla's Satisfaction Level:"+this.energyLevel);
    }

    public void climb(){
    this.energyLevel -= 10;
    System.out.println("The Gorilla is Climbing a tree!, Energy level "+ this.energyLevel);
    }
}