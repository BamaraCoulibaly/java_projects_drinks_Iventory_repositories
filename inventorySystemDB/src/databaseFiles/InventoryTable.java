/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseFiles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bamaragcoulibaly
 */
@Entity
@Table(name = "INVENTORY_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryTable.findAll", query = "SELECT i FROM InventoryTable i"),
    @NamedQuery(name = "InventoryTable.findById", query = "SELECT i FROM InventoryTable i WHERE i.id = :id"),
    @NamedQuery(name = "InventoryTable.findByQuantityInstore", query = "SELECT i FROM InventoryTable i WHERE i.quantityInstore = :quantityInstore")})
public class InventoryTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY_INSTORE")
    private Integer quantityInstore;
    @JoinColumn(name = "BOISSON_ID", referencedColumnName = "ID")
    @ManyToOne
    private Boisson boissonId;

    public InventoryTable() {
    }

    public InventoryTable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityInstore() {
        return quantityInstore;
    }

    public void setQuantityInstore(Integer quantityInstore) {
        this.quantityInstore = quantityInstore;
    }

    public Boisson getBoissonId() {
        return boissonId;
    }

    public void setBoissonId(Boisson boissonId) {
        this.boissonId = boissonId;
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
        if (!(object instanceof InventoryTable)) {
            return false;
        }
        InventoryTable other = (InventoryTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseFiles.InventoryTable[ id=" + id + " ]";
    }
    
}
