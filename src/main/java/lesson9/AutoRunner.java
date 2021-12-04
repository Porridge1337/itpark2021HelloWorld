package lesson9;

public class AutoRunner {

    public static void main(String[] args) {
        Automobile[] automobiles = fillAutomobile();

        for (Automobile auto : automobiles) {
            auto.move();
        }

    }

    private static Automobile[] fillAutomobile() {
        Automobile[] automobiles = new Automobile[10];
        for (int i = 0; i <= automobiles.length - 1; i++) {
            if (i < 5) {
                automobiles[i] = new Car((int) Math.round((Math.random() * 1001)), CarBrands.as(i).toString());
            } else {
                automobiles[i] = new Truck((int) Math.round((Math.random() * 1001)), CarBrands.as(i).toString());
            }
        }
        return automobiles;
    }


}