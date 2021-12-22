package lesson14;

import lesson14.enums.Names;
import lesson14.enums.Surnames;

import java.util.*;

public class PhoneBookMap {

    private Map<Integer, Contact> phoneBookMap;
    private Map<Integer, Contact> relatedСontactsMap = new HashMap();

    public PhoneBookMap() {
        this(new HashMap<Integer, Contact>());
    }

    public PhoneBookMap(Map<Integer, Contact> phoneBookMap) {
        this.phoneBookMap = phoneBookMap;
        fillUp();
    }

    private void fillUp() {
        for (Integer i = 0; i < 100; i++) {
            MobileOperator mobileOperator = MobileOperator.values()[new Random().nextInt(MobileOperator.values().length - 1)];
            String number = String.valueOf(mobileOperator.getOperatorCode()) +
                    (1000000 + new Random().nextInt(9000000));
            String name = Names.values()[new Random().nextInt(Names.values().length - 1)].toString();
            String surname = Surnames.values()[new Random().nextInt(Surnames.values().length - 1)].toString();

            this.phoneBookMap.put(i, new Contact(name, surname, number, mobileOperator, new Random().nextBoolean()));
        }
    }

    public void findRelatedСontacts(Map<Integer, Contact> relatedСontMap) {
        for (Map.Entry<Integer, Contact> thisEntry : this.phoneBookMap.entrySet()) {
            for (Map.Entry<Integer, Contact> relatedСontMapEntry : relatedСontMap.entrySet()) {
                if (thisEntry.getValue().equals(relatedСontMapEntry.getValue())) {
                    relatedСontactsMap.put(relatedСontMapEntry.getKey(), relatedСontMapEntry.getValue());
                }
            }
        }
    }

    public void printRelatedСontactsMap() {
        for (Map.Entry<Integer, Contact> entry : this.relatedСontactsMap.entrySet()) {
            System.out.println(entry);
        }
    }

    public String popularOperatorRelatedConactsMap() {
        MobileOperator[] mobileOperator = MobileOperator.values();
        String op = "";
        int repetition = 0;
        for (int i = 0; i <= mobileOperator.length - 1; i++) {
            int repetationTemp = 0;
            for (Map.Entry<Integer, Contact> entry : this.relatedСontactsMap.entrySet()) {
                if (mobileOperator[i].equals(entry.getValue().getOperator())) {
                    repetationTemp++;
                }
            }
            if (repetationTemp > repetition) {
                repetition = repetationTemp;
                op = mobileOperator[i].toString();
            }
        }
        return "Наиболее популярны у связанных абонентов операторы " + op;
    }


    public Map<Integer, Contact> getPhoneBookMap() {
        return phoneBookMap;
    }

    public Map<Integer, Contact> getRelatedСontactsMap() {
        return relatedСontactsMap;
    }
}
