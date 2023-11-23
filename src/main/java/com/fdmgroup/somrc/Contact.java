package com.fdmgroup.somrc;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_ID_GEN")
    @SequenceGenerator(name="CONTACT_ID_GEN", sequenceName = "CONTACT_ID_GEN")
    private long id;
    private String name;
    @OneToMany(mappedBy = "contact", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ContactInfo> info;

    public Contact() {
    }

    public Contact(long id, String name, List<ContactInfo> info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public Contact(String name, List<ContactInfo> info) {
        this.name = name;
        this.info = info;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactInfo> getInfo() {
        return this.info;
    }

    public void setInfo(List<ContactInfo> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", info='" + getInfo() + "'" +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        return id == other.id && Objects.equals(info, other.info) && Objects.equals(name, other.name);
    }
}
