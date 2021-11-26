package lesson7;

public class Deer {

    private int distanceRun;
    private int distanceSwim;

    public Deer(int distanceRun, int distanceSwim) {
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
    }

    public void run() {
        if (distanceRun < 370) {
            System.out.println("Олень бегает: " + distanceRun);
        } else {
            System.out.println("Олень не может бежать больше: " + distanceRun + " м");
        }

    }

    public void swim() {
        if (distanceSwim < 60){
            System.out.println("Олень плавает: " + distanceSwim);
        }else {
            System.out.println("Олень не может плыть больше: " + distanceSwim + " м");
        }

    }
}
