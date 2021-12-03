package lesson9;

public enum CarBrands {
    SHKODA(0), KIA(1), RENO(2), LADA(3), BMW(4), BelAZ(5),
    SCANIA(6), VOLVO(7), MAN(8), MERCEDES(9);

    private int index;

    CarBrands(int index) {
        this.index = index;
    }

    public static CarBrands as(int index) {
        for (CarBrands carsBrand : values()) {
            if (carsBrand.index == index) {
                return carsBrand;
            }
        }
        return CarBrands.VOLVO;
    }

}
