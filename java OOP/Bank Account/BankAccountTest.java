public class BankAccountTest{
    public static void main(String[] args){

        BankAccount account1 = new BankAccount(2000, 500);

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());

        account1.depositChecking(1000);
        account1.depositChecking(500);

        account1.depositSavings(500);
        account1.depositSavings(500);

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());

        account1.withdrawChecking(200);
        account1.withdrawChecking(400);
        account1.withdrawSavings(1000);

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());

        System.out.println(account1.totalMoney());
    }
}


