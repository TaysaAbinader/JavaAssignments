package Chapter_3_3;

public class BankAccount {
    private int accountNumber = 0;
    private long accountBalance = 0;
    private static int totalAccounts = 0;

    public BankAccount (long accountBalance) {
        totalAccounts++;
        this.accountNumber += totalAccounts;
        this.accountBalance = accountBalance;
       
    }

    public long deposit (long addedSum) {
        accountBalance += addedSum;
        return accountBalance;
    }

    public long withdraw (long subtractedSum) {
        if (subtractedSum > accountBalance) {
            System.err.println("Not enough funds");
        }
        accountBalance -= subtractedSum;
        return accountBalance;
    }

    public int getAccountNumber () {
        return this.accountNumber;
    }

    public long getBalance () {
        return this.accountBalance;
    }

    public static int getTotalAccounts () {
        return BankAccount.totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
