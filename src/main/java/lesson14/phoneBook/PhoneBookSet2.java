package lesson14.phoneBook;

import lesson14.Contact;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneBookSet2 extends PhoneBook {

    private Set<Contact> contacts;
    private ContactFactory factory;


    public PhoneBookSet2(int setSize) {
        fillUp(setSize);
    }

    @Override
    protected void fillUp(int phoneBookSize) {
        factory = new ContactFactory();
        contacts = new HashSet<>();
        for (int i = 0; i < phoneBookSize; i++) {
            contacts.add(factory.generateRandomContact());
        }
    }

    @Override
    public Contact getContact(String phoneNumber) {
        return contacts.stream().filter(contact -> contact.getNumber() == phoneNumber).findFirst().orElse(null);
    }

    @Override
    public int length() {
        return contacts.size();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts.stream().collect(Collectors.toList());
    }
}
