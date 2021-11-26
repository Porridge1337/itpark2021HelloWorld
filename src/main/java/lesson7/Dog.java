package lesson7;

public class Dog {

    private int distanceRun;
    private int distanceSwim;

    public Dog(int distanceRun, int distanceSwim) {
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
    }

    public void run() {
        if (distanceRun < 500) {
            System.out.println("Собака бегает: " + distanceRun);
        } else {
            System.out.println("Собака не может бежать больше: " + distanceRun + " м");
        }

    }

    public void swim() {
        if (distanceSwim < 10){
            System.out.println("Собака плавает: " + distanceSwim);
        }else {
            System.out.println("Собака не может плыть больше: " + distanceSwim + " м");
        }

    }
}
