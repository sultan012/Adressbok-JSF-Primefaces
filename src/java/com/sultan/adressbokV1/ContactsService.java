/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sultan.adressbokV1;

import java.util.ArrayList;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Sultan
 */
@ManagedBean(name = "contactsService")
@ApplicationScoped
public class ContactsService {

    ArrayList<Contacts>contactsList = new ArrayList<>();

    public ArrayList<Contacts> getContactsList() {
        return contactsList;
    }

    public void setContactsList(ArrayList<Contacts> contactsList) {
        this.contactsList = contactsList;
    }
    
    public  ArrayList<Contacts> createContacts() {
        ArrayList<Contacts> temp = new ArrayList<>();
        temp.add(new Contacts(getRandomId(), "Abed", "Sultan", "abod@yahoo.com","0767738848"));
        temp.add(new Contacts(getRandomId(), "Ola", "Karlson", "ola@yahoo.com","0700000008"));
        temp.add(new Contacts(getRandomId(), "Sara", "Larson", "sara@man.com","0711111111"));
        temp.add(new Contacts(getRandomId(), "Lars", "Kalrberg", "lars@gmail.com","0876777677"));
        temp.add(new Contacts(getRandomId(), "Tanja", "Svensonn", "tanja.s@gmail.com","01876654774"));
        temp.add(new Contacts(getRandomId(), "Linus", "Ola", "linus@gmail.com","07646266263"));
       
        return temp;
    }
    public String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    
}
