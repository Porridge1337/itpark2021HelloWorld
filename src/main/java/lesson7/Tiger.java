package lesson7;

public class Tiger {

    private int distanceRun;
    private int distanceSwim;

    public Tiger(int distanceRun, int distanceSwim) {
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
    }

    public void run() {
        if (distanceRun < 800) {
            System.out.println("Тигр бегает: " + distanceRun);
        } else {
            System.out.println("Тигр не может бежать больше: " + distanceRun + " м");
        }
    }

    public void swim() {
        if (distanceSwim < 50){
            System.out.println("Тигр плавает: " + distanceSwim);
        }else {
            System.out.println("Тигр не может плыть больше: " + distanceSwim + " м");
        }
    }

}
