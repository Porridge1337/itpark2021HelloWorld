package lesson14.phoneBook;

import lesson14.Contact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBookMap2 extends PhoneBook {

    private Map<String, Contact> contact;
    private ContactFactory factory;

    public PhoneBookMap2(int mapSize) {
        fillUp(mapSize);
    }

    @Override
    protected void fillUp(int phoneBookSize) {
        factory = new ContactFactory();
        contact = new HashMap<>();
        for (int i = 0; i < phoneBookSize; i++) {
            Contact createdContact = factory.generateRandomContact();
            contact.put(createdContact.getNumber(), createdContact);
        }
    }

    @Override
    public Contact getContact(String phoneNumber) {
        return contact.entrySet().stream().filter(contact -> contact.getKey().equals(phoneNumber))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);

    }

    @Override
    public int length() {
        return contact.size();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contact.values().stream().collect(Collectors.toList());
    }
}
