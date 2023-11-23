package com.fdmgroup.somrc;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ContactInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_INFO_ID_GEN")
    @SequenceGenerator(name="CONTACT_INFO_ID_GEN", sequenceName = "CONTACT_INFO_ID_GEN")
    private long id;
    @Column(name = "INFO_VALUE")
    private String infoValue;
    private InfoType infoType;
    @ManyToOne
    @JoinColumn(name = "FK_CONTACT_ID")
    private Contact contact;

    public ContactInfo(long id, String infoValue, InfoType infoType, Contact contact) {
        this.id = id;
        this.infoValue = infoValue;
        this.infoType = infoType;
        this.contact = contact;
    }

    public ContactInfo(String infoValue, InfoType infoType, Contact contact) {
        this.infoValue = infoValue;
        this.infoType = infoType;
        this.contact = contact;
    }

    public ContactInfo() {
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfoValue() {
        return this.infoValue;
    }

    public void setInfoValue(String infoValue) {
        this.infoValue = infoValue;
    }

    public InfoType getInfoType() {
        return this.infoType;
    }

    public void setInfoType(InfoType infoType) {
        this.infoType = infoType;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", infoValue='" + getInfoValue() + "'" +
                ", infoType='" + getInfoType() + "'" +
                "}";
    }

	@Override
	public int hashCode() {
		return Objects.hash(contact, id, infoType, infoValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactInfo other = (ContactInfo) obj;
		return Objects.equals(contact, other.contact) && id == other.id && infoType == other.infoType
				&& Objects.equals(infoValue, other.infoValue);
	}
}
