package lesson7;

public class Cat {

    private int distanceRun;

    public Cat(int distanceRun) {
        this.distanceRun = distanceRun;
    }

    public void run() {
        if (distanceRun < 200) {
            System.out.println("Кот бегает: " + distanceRun);
        } else {
            System.out.println("Кот не может бежать больше: " + distanceRun + " м");
        }
    }

    public void swim() {
        System.out.println("Кот не умеет плавать");
    }
}
