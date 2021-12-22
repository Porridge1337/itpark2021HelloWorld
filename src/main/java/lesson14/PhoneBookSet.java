package lesson14;

import lesson14.enums.Names;
import lesson14.enums.Surnames;

import java.util.*;

public class PhoneBookSet {

    private Set<Contact> phoneBook;
    private Set<Contact> relatedСontacts = new HashSet<>();

    public PhoneBookSet() {
        this(new HashSet<>());
    }

    public PhoneBookSet(Set<Contact> phoneBook) {
        this.phoneBook = phoneBook;
        fillUp();
    }

    private void fillUp() {
        for (int i = 0; i < 100; i++) {
            MobileOperator mobileOperator = MobileOperator.values()[new Random().nextInt(MobileOperator.values().length - 1)];
            String number = String.valueOf(mobileOperator.getOperatorCode()) +
                    (1000000 + new Random().nextInt(9000000));
            String name = Names.values()[new Random().nextInt(Names.values().length - 1)].toString();
            String surname = Surnames.values()[new Random().nextInt(Surnames.values().length - 1)].toString();

            this.phoneBook.add(new Contact(name, surname, number, mobileOperator, new Random().nextBoolean()));
        }
    }

    public void findRelatedСontacts(Set<Contact> relatedСont) {
        for (Iterator<Contact> iteratorPhoneBook = this.phoneBook.iterator(); iteratorPhoneBook.hasNext(); ) {
            Contact contact = iteratorPhoneBook.next();
            for (Iterator<Contact> relatedContact = relatedСont.iterator(); relatedContact.hasNext(); ) {
                Contact contact1 = relatedContact.next();
                if (contact.equals(contact1)) {
                    relatedСontacts.add(contact1);
                }
            }
        }
    }

    public void printRelatedСontacts() {
        for (Iterator<Contact> relatedContact = this.relatedСontacts.iterator(); relatedContact.hasNext(); ) {
            Contact contact = relatedContact.next();
            System.out.println(contact);
        }
    }

    public String popularOperatorRelatedConacts() {
        MobileOperator[] mobileOperator = MobileOperator.values();
        String op = "";
        int repetition = 0;
        for (int i = 0; i <= mobileOperator.length - 1; i++) {
            int repetationTemp = 0;
            for (Iterator<Contact> iterator = this.relatedСontacts.iterator(); iterator.hasNext(); ) {
                Contact contact = iterator.next();
                if (mobileOperator[i].equals(contact.getOperator())) {
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

    public Set<Contact> getRelatedСontacts() {
        return relatedСontacts;
    }

    public Set<Contact> getPhoneBook() {
        return phoneBook;
    }
}
