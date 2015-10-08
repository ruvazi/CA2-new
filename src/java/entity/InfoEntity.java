/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rune
 */
@Entity
@Table(name = "infoentity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoEntity.findAll", query = "SELECT i FROM InfoEntity i"),
    @NamedQuery(name = "InfoEntity.findById", query = "SELECT i FROM InfoEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InfoEntity.findByEmail", query = "SELECT i FROM InfoEntity i WHERE i.email = :email")})
public class InfoEntity implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idA")
    private Collection<Address> addressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idP")
    private Collection<Phone> phoneCollection;
    

    public InfoEntity() {
    }

    public InfoEntity( String email) {
        this.email = email;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @XmlTransient
    public Collection<Phone> getPhoneCollection() {
        return phoneCollection;
    }

    public void setPhoneCollection(Collection<Phone> phoneCollection) {
        this.phoneCollection = phoneCollection;
    }

    @Override
    public String toString() {
        return "InfoEntity{" + "id=" + id + ", email=" + email + ", addressCollection=" + addressCollection + ", phoneCollection=" + phoneCollection + '}';
    }

    
    
}
