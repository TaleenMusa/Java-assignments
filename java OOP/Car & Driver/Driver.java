
public class Driver extends Car {
    private String name;
    public Driver(String name){
        this.name= name;
    }
	public void drive() {
		decreaseGas(1);
	}
    public void refuel() {
		increaseGas(2);
	}
	
	public void boost() {
		this.gas-=3;
		System.out.println("You used boosters");
		System.out.println("Remaining gas :" +this.getGas() +"/10");
	}
	if(gas<=0){
            System.out.println("Game Over");
        }

}
