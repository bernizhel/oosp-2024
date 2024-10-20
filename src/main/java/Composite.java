import java.util.ArrayList;
import java.util.List;

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void display();
}

class SimpleAccount implements Account {
    private final String name;
    private double balance;

    public SimpleAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void display() {
        System.out.println("Аккаунт: " + name + ", Баланс: " + balance);
    }
}

class CompositeAccount implements Account {
    private final String name;
    private final List<Account> accounts;

    public CompositeAccount(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public void deposit(double amount) {
        for (Account account : accounts) {
            account.deposit(amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        for (Account account : accounts) {
            account.withdraw(amount);
        }
    }

    @Override
    public void display() {
        System.out.println("Композитный аккаунт: " + name);
        for (Account account : accounts) {
            account.display();
        }
    }
}

class Transaction {
    private final double amount;
    private final String description;

    public Transaction(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public void process(Account account) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Транзакция: " + description + ", Сумма: " + amount);
        } else {
            account.withdraw(-amount);
            System.out.println("Транзакция: " + description + ", Сумма: -" + amount);
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        SimpleAccount account1 = new SimpleAccount("Аккаунт 1", 1000);
        SimpleAccount account2 = new SimpleAccount("Аккаунт 2", 2000);

        CompositeAccount compositeAccount = new CompositeAccount("Композитный аккаунт");
        compositeAccount.addAccount(account1);
        compositeAccount.addAccount(account2);

        Transaction transaction1 = new Transaction(500, "Пополнение счета");
        Transaction transaction2 = new Transaction(-200, "Снятие денег");

        transaction1.process(compositeAccount);
        transaction2.process(compositeAccount);

        compositeAccount.display();
    }
}