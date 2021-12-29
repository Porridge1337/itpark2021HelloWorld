package lesson14.phoneBook;

import lesson14.Contact;
import lesson14.MobileOperator;
import lesson14.enums.Names;
import lesson14.enums.Surnames;

import java.util.Random;

public class ContactFactory {

    public Contact generateRandomContact() {
        MobileOperator mobileOperator = MobileOperator.values()[new Random().nextInt(MobileOperator.values().length - 1)];
        String number = String.valueOf(mobileOperator.getOperatorCode()) +
                (1000000 + new Random().nextInt(9000000));
        String name = Names.values()[new Random().nextInt(Names.values().length - 1)].toString();
        String surname = Surnames.values()[new Random().nextInt(Surnames.values().length - 1)].toString();
        return new Contact(name, surname, number, mobileOperator, new Random().nextBoolean());
    }

}
