package lesson7;

public class Bear {

    private int distanceRun;
    private int distanceSwim;

    public Bear(int distanceRun, int distanceSwim) {
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
    }

    public void run() {
        if (distanceRun < 350) {
            System.out.println("Медведь бегает: " + distanceRun);
        } else {
            System.out.println("Медведь не может бежать больше: " + distanceRun + " м");
        }

    }

    public void swim() {
        if (distanceSwim < 75){
            System.out.println("Медведь плавает: " + distanceSwim);
        }else {
            System.out.println("Медведь не может плыть больше: " + distanceSwim + " м");
        }

    }
}
