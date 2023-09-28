public class SavingsAccount extends BankAccount{
    private double interestRate;
    public SavingsAccount(double initialAmount, double rate) {
        super(initialAmount);
        this.interestRate = rate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void calculateInterest() {
        double balance = this.getBalance();
        double interest = balance * interestRate;
        deposit(interest);
    }

    public String toString() {
        return "SavingsAccount: Balance $" +  this.getBalance() + ", interest rate " + interestRate;
    }

    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount(100.0,0.15);
        myAccount.calculateInterest();
        System.out.println(myAccount.toString());
    }
}


