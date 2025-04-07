package LoggingProxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Greeting original = new GreetingImpl();

        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new LoggingInvocationHandler(original)
        );

        proxyInstance.sayHello();
        proxyInstance.sayBye();
    }
}

