import java.util.ArrayList;
import java.util.List;

interface IObserver {
    void update(String message);
}

class Reader implements IObserver {
    private final String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получил уведомление: " + message);
    }
}

class Blog {
    private final List<IObserver> observers;
    private final String name;

    public Blog(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public void subscribe(IObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (IObserver observer : observers) {
            observer.update(message);
        }
    }

    public void publishPost(String postName) {
        String message = "Новая запись в блоге '" + name + "': " + postName;
        notifyObservers(message);
    }
}

public class Observer {
    public static void main(String[] args) {
        Blog blog = new Blog("Мой блог");

        Reader reader1 = new Reader("Иван");
        Reader reader2 = new Reader("Петр");
        blog.subscribe(reader1);
        blog.subscribe(reader2);

        blog.publishPost("Новости дня");

        blog.unsubscribe(reader2);

        blog.publishPost("События недели");
    }
}