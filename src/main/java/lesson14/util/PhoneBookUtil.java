package lesson14.util;

import lesson14.Contact;
import lesson14.phoneBook.PhoneBook;
import lesson14.phoneBook.PhoneBookMassive2;

import java.util.Iterator;
import java.util.Set;

public class PhoneBookUtil {

    public static void findRelatedContacts(Set<Contact> firstBookContact, Set<Contact> SecondBookContact) {
        for (Iterator<Contact> iterator1 = firstBookContact.iterator(); iterator1.hasNext(); ) {
            Contact contact1 = iterator1.next();
            for (Iterator<Contact> iterator2 = SecondBookContact.iterator(); iterator2.hasNext(); ) {
                Contact contact2 = iterator2.next();
                if (contact1.equals(contact2)) {
                    contact1.getRelatedPhoneNumbers().add(contact2.getNumber());
                    contact2.getRelatedPhoneNumbers().add(contact1.getNumber());
                }
            }
        }
    }

    public static void findRelatedContacts(Contact[] firstBookContact, Contact[] secondBookContact) {
        for (int i = 0; i < firstBookContact.length; i++) {
            for (int j = 0; j < secondBookContact.length; j++) {
                if (firstBookContact[i].equals(secondBookContact[j])) {
                    Contact contact1 = firstBookContact[i];
                    Contact contact2 = secondBookContact[j];
                    contact1.getRelatedPhoneNumbers().add(contact2.getNumber());
                    contact2.getRelatedPhoneNumbers().add(contact1.getNumber());
                }
            }
        }
    }

    public static void printRelatedContacts(PhoneBook book1, PhoneBook book2) {
        Contact withRelated = null;
        for (Contact c : book1.getAllContacts()) {
            if (c.getRelatedPhoneNumbers().size() > 0) {
                withRelated = c;
                break;
            }
        }
        System.out.println(withRelated + " бук 1");
        System.out.println("--------------------------------------------");
        for (String number : withRelated.getRelatedPhoneNumbers()) {
            System.out.println(book2.getContact(number) + " из бук2 связанные контактны с бук1");
        }
        System.out.println("\n");

    }


}
