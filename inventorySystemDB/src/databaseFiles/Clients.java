/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseFiles;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bamaragcoulibaly
 */
@Entity
@Table(name = "CLIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByCompanyName", query = "SELECT c FROM Clients c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Clients.findByTelephone", query = "SELECT c FROM Clients c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Clients.findByBusinessType", query = "SELECT c FROM Clients c WHERE c.businessType = :businessType")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Lob
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Lob
    @Column(name = "CONTACT_NAME_DETAILS")
    private String contactNameDetails;
    @Column(name = "BUSINESS_TYPE")
    private String businessType;
    @OneToMany(mappedBy = "clientsId")
    private Collection<SaleRecords> saleRecordsCollection;
    @OneToMany(mappedBy = "clientsId")
    private Collection<ReservationTable> reservationTableCollection;

    public Clients() {
    }

    public Clients(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContactNameDetails() {
        return contactNameDetails;
    }

    public void setContactNameDetails(String contactNameDetails) {
        this.contactNameDetails = contactNameDetails;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @XmlTransient
    public Collection<SaleRecords> getSaleRecordsCollection() {
        return saleRecordsCollection;
    }

    public void setSaleRecordsCollection(Collection<SaleRecords> saleRecordsCollection) {
        this.saleRecordsCollection = saleRecordsCollection;
    }

    @XmlTransient
    public Collection<ReservationTable> getReservationTableCollection() {
        return reservationTableCollection;
    }

    public void setReservationTableCollection(Collection<ReservationTable> reservationTableCollection) {
        this.reservationTableCollection = reservationTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseFiles.Clients[ id=" + id + " ]";
    }
    
}
