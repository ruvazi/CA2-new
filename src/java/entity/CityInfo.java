/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rune
 */
@Entity
@Table(name = "cityinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CityInfo.findAll", query = "SELECT c FROM CityInfo c"),
    @NamedQuery(name = "CityInfo.findByZipcode", query = "SELECT c FROM CityInfo c WHERE c.zipcode = :zipcode"),
    @NamedQuery(name = "CityInfo.findByCity", query = "SELECT c FROM CityInfo c WHERE c.city = :city")})
public class CityInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @OneToMany(mappedBy = "zipcodeA")
    private Collection<Address> addressCollection;

    public CityInfo() {
    }

    public CityInfo(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipcode != null ? zipcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityInfo)) {
            return false;
        }
        CityInfo other = (CityInfo) object;
        if ((this.zipcode == null && other.zipcode != null) || (this.zipcode != null && !this.zipcode.equals(other.zipcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CityInfo[ zipcode=" + zipcode + " ]";
    }
    
}
