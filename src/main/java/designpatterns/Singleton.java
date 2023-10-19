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
