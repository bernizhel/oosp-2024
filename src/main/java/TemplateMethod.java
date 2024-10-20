abstract class MobileApp {
    public final void runApp() {
        initialize();
        displayUI();
        handleEvents();
        cleanup();
    }

    protected abstract void initialize();
    protected abstract void displayUI();
    protected abstract void handleEvents();
    protected abstract void cleanup();
}

class iOSApp extends MobileApp {
    @Override
    protected void initialize() {
        System.out.println("Initializing iOS app");
    }

    @Override
    protected void displayUI() {
        System.out.println("Displaying iOS UI");
    }

    @Override
    protected void handleEvents() {
        System.out.println("Handling iOS events");
    }

    @Override
    protected void cleanup() {
        System.out.println("Cleaning up iOS app");
    }
}

class AndroidApp extends MobileApp {
    @Override
    protected void initialize() {
        System.out.println("Initializing Android app");
    }

    @Override
    protected void displayUI() {
        System.out.println("Displaying Android UI");
    }

    @Override
    protected void handleEvents() {
        System.out.println("Handling Android events");
    }

    @Override
    protected void cleanup() {
        System.out.println("Cleaning up Android app");
    }
}

class WindowsApp extends MobileApp {
    @Override
    protected void initialize() {
        System.out.println("Initializing Windows app");
    }

    @Override
    protected void displayUI() {
        System.out.println("Displaying Windows UI");
    }

    @Override
    protected void handleEvents() {
        System.out.println("Handling Windows events");
    }

    @Override
    protected void cleanup() {
        System.out.println("Cleaning up Windows app");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        MobileApp[] apps = {
                new iOSApp(),
                new AndroidApp(),
                new WindowsApp()
        };

        for (MobileApp app : apps) {
            System.out.println("Running " + app.getClass().getSimpleName());
            app.runApp();
            System.out.println();
        }
    }
}