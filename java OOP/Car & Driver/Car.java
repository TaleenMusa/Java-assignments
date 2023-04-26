public class Car {
	public int gas;

	public Car() {
		this.gas=10;
	}
	
	public int getGas() {
		return this.gas;
	}

    public void decreaseGas( int amount){
    this.gas-=amount;
    System.out.println("You drive the car");
	System.out.println("Remaining gas :" +this.getGas() +"/10");
    }
    public void increaseGas(int amount){
    this.gas+=amount;
        System.out.println("You refueled the car");
		System.out.println("Remaining gas :" +this.getGas() +"/10");
    }
}