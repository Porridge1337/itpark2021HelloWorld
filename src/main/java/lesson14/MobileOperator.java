package lesson14;

public enum MobileOperator {
    MEGAFON(921), MTC(911), TELE2(950), BEELINE(960);

    private int operatorCode;

    MobileOperator(int operatorCode) {
        this.operatorCode = operatorCode;
    }

    public int getOperatorCode() {
        return operatorCode;
    }
}
