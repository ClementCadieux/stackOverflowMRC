package com.fdmgroup.somrc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public Optional<Contact> readById(long id) {
        Contact contact = new Contact(id, "John Doe", null);
        List<ContactInfo> info = new ArrayList<>();
        ContactInfo ci = new ContactInfo(1, "aaaa", InfoType.ADDRESS, contact);
        info.add(ci);
        contact.setInfo(info);
        return Optional.of(contact);
    }

    public void updateContact(long id, Contact contact) {
        System.out.println(contact);
    }

}
