abstract class Auth {
    public abstract void authenticate();
}

class PasswordAuth extends Auth {
    private final String login;
    private final String password;

    public PasswordAuth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void authenticate() {
        System.out.println("Авторизация по паролю для пользователя " + login + " с паролем " + password);
    }
}

class FingerprintAuth extends Auth {
    private final String fingerprint;

    public FingerprintAuth(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    @Override
    public void authenticate() {
        System.out.println("Авторизация по отпечатку пальца " + fingerprint);
    }
}

class SocialNetworkAuth extends Auth {
    private final String socialNetwork;
    private final String token;

    public SocialNetworkAuth(String socialNetwork, String token) {
        this.socialNetwork = socialNetwork;
        this.token = token;
    }

    @Override
    public void authenticate() {
        System.out.println("Авторизация через социальную сеть " + socialNetwork + " с токеном " + token);
    }
}

enum AuthenticationType {
    PASSWORD,
    FINGERPRINT,
    SOCIAL
}

class AuthFactory {
    public static Auth createAuth(AuthenticationType type, String... args) {
        return switch (type) {
            case AuthenticationType.PASSWORD -> new PasswordAuth(args[0], args[1]);
            case AuthenticationType.FINGERPRINT -> new FingerprintAuth(args[0]);
            case AuthenticationType.SOCIAL -> new SocialNetworkAuth(args[0], args[1]);
            default -> throw new UnsupportedOperationException("Неподдерживаемый тип авторизации");
        };
    }
}

public class Factory {
    public static void main(String[] args) {
        Auth passwordAuth = AuthFactory.createAuth(AuthenticationType.PASSWORD, "user123", "password123");
        Auth fingerprintAuth = AuthFactory.createAuth(AuthenticationType.FINGERPRINT, "fingerprint123");
        Auth socialNetworkAuth = AuthFactory.createAuth(AuthenticationType.SOCIAL, "Facebook", "token123");

        passwordAuth.authenticate();
        fingerprintAuth.authenticate();
        socialNetworkAuth.authenticate();
    }
}