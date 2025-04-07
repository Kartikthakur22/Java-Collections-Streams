package Injection;

public class App {

    static class UserService {
        void register() {
            System.out.println("User registered.");
        }
    }

    static class Controller {
        @Inject
        UserService userService;

        void run() {
            userService.register();
        }
    }

    public static void main(String[] args) throws Exception {
        Controller controller = DIContainer.createInstance(Controller.class);
        controller.run();
    }
}

