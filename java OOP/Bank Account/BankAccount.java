public class BankAccount {
    private double checking_balance;
    private double savings_balance;
    private static int numberOfAccounts;
    private static double totalamount;
    
    public BankAccount(double checking_balance, double savings_balance){
        this.checking_balance = checking_balance;
        this.savings_balance = savings_balance;
        BankAccount.numberOfAccounts++;
        BankAccount.totalamount+=checking_balance+savings_balance;
    }

    public double getCheckingBalance(){
        return this.checking_balance;
    }

    public double getSavingsBalance(){
        return this.savings_balance;
    }

    public void depositChecking(double deposit){
        this.checking_balance+=deposit;
    } 

    public void depositSavings(double deposit){
        this.savings_balance+=deposit;
    } 

    public void withdrawChecking(double withdraw){
        if (this.checking_balance > withdraw){
            this.checking_balance -= withdraw;
        }
    }

    public void withdrawSavings(double withdraw){
        if (this.savings_balance > withdraw){
            this.savings_balance -= withdraw;
        }
    }

    public double totalMoney (){
        double totalMoney = this.checking_balance + this.savings_balance;
        return totalMoney;
    }
}
