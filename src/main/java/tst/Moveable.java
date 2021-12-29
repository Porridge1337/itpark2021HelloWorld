package tst;

public interface Moveable {

    void move();

    default void moveAndPrint(){
        print("начало движения");
        move();
        print("конец движения");
    }

    static void print(String str){
        System.out.println(str);
    }
}
