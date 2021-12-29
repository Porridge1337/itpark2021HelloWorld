package lesson14.phoneBook;

import lesson14.Contact;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PhoneBookMassive2 extends PhoneBook {

    private Contact[] contacts;
    private ContactFactory factory;

    public PhoneBookMassive2(int massiveSize) {
        fillUp(massiveSize);
    }

    @Override
    protected void fillUp(int phoneBookSize) {
        factory = new ContactFactory();
        contacts = new Contact[phoneBookSize];
        for (int i = 0; i < phoneBookSize; i++) {
            contacts[i] = factory.generateRandomContact();
        }
    }

    @Override
    public Contact getContact(String phoneNumber) {
        Optional<Contact> optionalContact = Arrays.stream(contacts)
                .filter(contact -> contact.getNumber() == phoneNumber)
                .findFirst();

        return optionalContact.isPresent() ? optionalContact.get() : null;
    }

    @Override
    public int length() {
        return this.contacts.length;
    }

    @Override
    public List<Contact> getAllContacts() {
        return Arrays.asList(contacts);
    }
}
