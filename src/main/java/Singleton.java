import java.util.LinkedList;
import java.util.Queue;

class PrintService {
    private static PrintService instance;
    private final Queue<String> printQueue;

    private PrintService() {
        printQueue = new LinkedList<>();
    }

    public static PrintService getInstance() {
        if (instance == null) {
            instance = new PrintService();
        }
        return instance;
    }

    public void addJob(String job) {
        printQueue.offer(job);
        System.out.println("Задание добавлено в очередь печати: " + job);
    }

    public void printNextJob() {
        String job = printQueue.poll();
        if (job != null) {
            System.out.println("Печать задания: " + job);
        } else {
            System.out.println("Очередь пуста.");
        }
    }
}

public class Singleton {
    public static void main(String[] args) {
        PrintService printService1 = PrintService.getInstance();
        printService1.addJob("Документ 1");

        PrintService printService2 = PrintService.getInstance();
        printService2.addJob("Документ 2");

        printService1.printNextJob();
        printService2.printNextJob();

        System.out.println(printService1 == printService2);
    }
}