class ScriptManagementSystem {
    public void selectScript(String script) {
        System.out.println("Сценарий \"" + script + "\" выбран для производства.");
    }
}

class CastingSystem {
    public void hireActors(String... actors) {
        System.out.print("Актеры ");
        for (String actor : actors) {
            System.out.print(actor + " ");
        }
        System.out.println("наняты.");
    }
}

class ShootingManagementSystem {
    public void manageShooting(String location) {
        System.out.println("Съемки начались в локации: " + location);
    }
}

class StudioFacade {
    private final ScriptManagementSystem scriptManagement = new ScriptManagementSystem();
    private final CastingSystem castingSystem = new CastingSystem();
    private final ShootingManagementSystem shootingManagement = new ShootingManagementSystem();

    public void produceFilm(String script, String[] actors, String location) {
        scriptManagement.selectScript(script);
        castingSystem.hireActors(actors);
        shootingManagement.manageShooting(location);
        System.out.println("Производство фильма началось!");
    }
}

public class Facade {
    public static void main(String[] args) {
        StudioFacade studioFacade = new StudioFacade();
        String script = "Удивительное приключение";
        String[] actors = {"Актер 1", "Актер 2", "Актер 3"};
        String location = "Париж";

        studioFacade.produceFilm(script, actors, location);
    }
}