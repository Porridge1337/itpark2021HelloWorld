package lesson14.phoneBook;

import lesson14.Contact;
import lesson14.util.PhoneBookUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PhoneBookRunner2 {

    public static void main(String[] args) {
        PhoneBookMassive2 book1 = new PhoneBookMassive2(1000);
        PhoneBookMassive2 book2 = new PhoneBookMassive2(1000);
        Contact[] list1 = book1.getAllContacts().toArray(new Contact[0]);
        Contact[] list2 = book2.getAllContacts().toArray(new Contact[0]);
        PhoneBookUtil.findRelatedContacts(list1, list2);

        PhoneBookSet2 bookSet1 = new PhoneBookSet2(1000);
        PhoneBookSet2 bookSet2 = new PhoneBookSet2(1000);
        Set<Contact> listSet1 = bookSet1.getAllContacts().stream().collect(Collectors.toSet());
        Set<Contact> listSet2 = bookSet2.getAllContacts().stream().collect(Collectors.toSet());
        PhoneBookUtil.findRelatedContacts(listSet1, listSet2);

        PhoneBookMap2 bookMap1 = new PhoneBookMap2(1000);
        PhoneBookMap2 bookMap2 = new PhoneBookMap2(1000);
        Map<String, Contact> listMap1 = bookMap1.getAllContacts().stream().
                collect(Collectors.toMap(contact -> contact.getNumber(), Function.identity()));
        Map<String, Contact> listMap2 = bookMap2.getAllContacts().stream().
                collect(Collectors.toMap(contact -> contact.getNumber(), Function.identity()));
        PhoneBookUtil.findRelatedContacts(listMap1,listMap2);


        PhoneBookUtil.printRelatedContacts(book1, book2);
        PhoneBookUtil.printRelatedContacts(bookSet1, bookSet2);
        PhoneBookUtil.printRelatedContacts(bookMap1, bookMap2);


        // System.out.println(book1.getAllContacts());

    }


}
