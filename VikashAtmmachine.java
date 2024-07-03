import java.util.*;

class Atm {
    private float balance;
    private int PIN = 5674;
    private List<String> transactionHistory = new ArrayList<>();

    public void checkPin() {
        System.out.println("Enter your pin:");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Invalid pin. Try again.");
            checkPin();
        }
    }

    public void menu() {
        System.out.println("Enter Your Choice:");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Change PIN");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                changePin();
                break;
            case 5:
                transactionHistory();
                break;
            case 6:
                System.out.println("Thank you for using the ATM. Goodbye!");
                return;
            default:
                System.out.println("Enter a valid choice.");
                menu();
                break;
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            System.out.println("Money withdrawn successfully.");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the amount: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        System.out.println("Money deposited successfully.");
        menu();
    }

    public void changePin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new PIN:");
        int newPin = sc.nextInt();
        int PIN = newPin;
        System.out.println("PIN changed successfully.");
        menu();
    }

    public void transactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        menu();
    }
}

public class VikashAtmmachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}


