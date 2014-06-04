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
@Table(name = "BOISSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boisson.findAll", query = "SELECT b FROM Boisson b"),
    @NamedQuery(name = "Boisson.findById", query = "SELECT b FROM Boisson b WHERE b.id = :id"),
    @NamedQuery(name = "Boisson.findByBoissonName", query = "SELECT b FROM Boisson b WHERE b.boissonName = :boissonName"),
    @NamedQuery(name = "Boisson.findByPriceCfa", query = "SELECT b FROM Boisson b WHERE b.priceCfa = :priceCfa"),
    @NamedQuery(name = "Boisson.findByBouteilleTailleCl", query = "SELECT b FROM Boisson b WHERE b.bouteilleTailleCl = :bouteilleTailleCl"),
    @NamedQuery(name = "Boisson.findByNbreCaisse", query = "SELECT b FROM Boisson b WHERE b.nbreCaisse = :nbreCaisse")})
public class Boisson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "BOISSON_NAME")
    private String boissonName;
    @Column(name = "PRICE_CFA")
    private Integer priceCfa;
    @Column(name = "BOUTEILLE_TAILLE_CL")
    private Integer bouteilleTailleCl;
    @Column(name = "NBRE_CAISSE")
    private Integer nbreCaisse;
    @OneToMany(mappedBy = "boissonId")
    private Collection<SaleRecords> saleRecordsCollection;
    @OneToMany(mappedBy = "boissonId")
    private Collection<ReservationTable> reservationTableCollection;
    @OneToMany(mappedBy = "boissonId")
    private Collection<InventoryTable> inventoryTableCollection;

    public Boisson() {
    }

    public Boisson(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoissonName() {
        return boissonName;
    }

    public void setBoissonName(String boissonName) {
        this.boissonName = boissonName;
    }

    public Integer getPriceCfa() {
        return priceCfa;
    }

    public void setPriceCfa(Integer priceCfa) {
        this.priceCfa = priceCfa;
    }

    public Integer getBouteilleTailleCl() {
        return bouteilleTailleCl;
    }

    public void setBouteilleTailleCl(Integer bouteilleTailleCl) {
        this.bouteilleTailleCl = bouteilleTailleCl;
    }

    public Integer getNbreCaisse() {
        return nbreCaisse;
    }

    public void setNbreCaisse(Integer nbreCaisse) {
        this.nbreCaisse = nbreCaisse;
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

    @XmlTransient
    public Collection<InventoryTable> getInventoryTableCollection() {
        return inventoryTableCollection;
    }

    public void setInventoryTableCollection(Collection<InventoryTable> inventoryTableCollection) {
        this.inventoryTableCollection = inventoryTableCollection;
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
        if (!(object instanceof Boisson)) {
            return false;
        }
        Boisson other = (Boisson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseFiles.Boisson[ id=" + id + " ]";
    }
    
}
