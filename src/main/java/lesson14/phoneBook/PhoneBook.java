package lesson14.phoneBook;

import lesson14.Contact;

import java.util.List;

public abstract class PhoneBook {

    protected abstract void fillUp(int phoneBookSize);

    public abstract Contact getContact(String phoneNumber);

    public abstract int length();

    public abstract List<Contact> getAllContacts();

}
