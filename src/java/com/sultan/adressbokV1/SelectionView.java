/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sultan.adressbokV1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;


/**
 *
 * @author Sultan
 */

@ManagedBean(name = "dtSelectionView")
@javax.faces.bean.ViewScoped
public class SelectionView implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    ArrayList<Contacts> contactsList;
    ArrayList<Contacts> filteredContacts;
    private Contacts selectedContact;

    @ManagedProperty("#{contactsService}")
    private ContactsService service;

    @PostConstruct
    public void init() {
        contactsList = service.createContacts();

    }

    public ArrayList<Contacts> getContactsList() {
        return contactsList;
    }

    public void setContactsList(ArrayList<Contacts> contactsList) {
        this.contactsList = contactsList;
    }

    public ArrayList<Contacts> getFilteredContacts() {
        return filteredContacts;
    }

    public void setFilteredContacts(ArrayList<Contacts> filteredContacts) {
        this.filteredContacts = filteredContacts;
    }

    public ContactsService getService() {
        return service;
    }

    public void setService(ContactsService service) {
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contacts getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(Contacts selectedContact) {
        this.selectedContact = selectedContact;
    }

    public void addContact() {

        contactsList.add(new Contacts(service.getRandomId(), firstName, lastName, email, phone));
    }

    public void removeContact() {
        contactsList.remove(selectedContact);
        selectedContact = null;
    }
    
     public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Contact Edited", ((Contacts) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Contacts) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
