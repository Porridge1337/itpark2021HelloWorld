package lesson14;

import lesson14.enums.Names;
import lesson14.enums.Surnames;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class PhoneBookMassive {

    private Contact[] phoneBook;
    private Contact[] relatedСontacts = new Contact[5];

    public PhoneBookMassive() {
        this(new Contact[100]);
    }

    public PhoneBookMassive(Contact[] phoneBook) {
        this.phoneBook = phoneBook;
        fillUp();
    }

    private void fillUp() {
        for (int i = 0; i <= phoneBook.length - 1; i++) {
            MobileOperator mobileOperator = MobileOperator.values()[new Random().nextInt(MobileOperator.values().length - 1)];
            String number = String.valueOf(mobileOperator.getOperatorCode()) +
                    (1000000 + new Random().nextInt(9000000));
            String name = Names.values()[new Random().nextInt(Names.values().length - 1)].toString();
            String surname = Surnames.values()[new Random().nextInt(Surnames.values().length - 1)].toString();

            phoneBook[i] = (new Contact(name, surname, number, mobileOperator, new Random().nextBoolean()));
        }
    }

    public void printPhoneBookMassive() {
        for (Contact contact : phoneBook) {
            System.out.println(contact);
        }
    }

    public void printRelatedСontactsMassvie() {
        for (Contact contact : relatedСontacts) {
            System.out.println(contact);
        }
    }

    public void findRelatedContactMassive(Contact[] phoneBookMassive) {
        for (int i = 0, n = 0; i <= this.phoneBook.length - 1; i++) {
            for (int j = 0; j <= phoneBookMassive.length - 1; j++) {
                if (this.phoneBook[i].equals(phoneBookMassive[j])) {
                    if (relatedСontacts.length <= n) {
                        relatedСontacts = Arrays.copyOf(relatedСontacts, relatedСontacts.length + 1);
                    }
                    this.relatedСontacts[n++] = phoneBookMassive[j];
                }
            }
        }
    }

    public String popularOperatorRelatedConacts() {
        MobileOperator[] mobileOperator = MobileOperator.values();
        String op = "";
        int repetition = 0;
        for (int i = 0; i <= mobileOperator.length - 1; i++) {
            int repetationTemp = 0;
            for (int j = 0; j <= this.relatedСontacts.length - 1; j++) {
                if (mobileOperator[i].equals(this.relatedСontacts[j].getOperator())) {
                    repetationTemp++;
                }
            }
            if (repetationTemp > repetition) {
                repetition = repetationTemp;
                op = mobileOperator[i].toString();
            }
        }
        return "Наиболее популярны у связанных абонентов операторы" + op;
    }

    public Contact[] getPhoneBook() {
        return phoneBook;
    }

    public Contact[] getRelatedСontacts() {
        return relatedСontacts;
    }
}
