
import java.util.Scanner;

class ATM {

    private double balance;
    private final int PIN = 1240;

    public ATM() {
        this.balance = 1000.0;
    }

    public boolean checkPin(int enterdPin) {
        return enterdPin == PIN;
    }

    public void checkBalance() {
        System.out.println("Your Current Balance : " + balance);
    }

    // Function to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
        } else {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        }
    }

    // Function to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash: ₹" + amount);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter your ATM PIN: ");
        int pin = sc.nextInt();

        if (atm.checkPin(pin)) {
            int choice;
            do {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ₹ ");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ₹ ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            } while (choice != 4);
        } else {
            System.out.println("Incorrect PIN. Access Denied.");
        }

        sc.close();
    }
}
