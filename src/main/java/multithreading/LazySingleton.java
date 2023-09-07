package multithreading;

public class LazySingleton {
    //make as private and static to use this variable without creating the object
    private static LazySingleton instance;

    // no one create the object
    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
