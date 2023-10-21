package designpatterns;

public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public Singleton getInstance() {
        if(instance == null)
            return new Singleton();
        return instance;
    }
}

// double checked lock
class Singleton1 {
    private static Singleton1 instance1;
    private Singleton1(){}
    public Singleton1 getInstance1() {
        if(instance1 == null) {
            synchronized (Singleton1.class) {
                return new Singleton1();
            }
        }
        return instance1;
    }
}