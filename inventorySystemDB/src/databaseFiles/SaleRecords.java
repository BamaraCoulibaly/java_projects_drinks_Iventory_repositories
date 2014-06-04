/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseFiles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "SALE_RECORDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleRecords.findAll", query = "SELECT s FROM SaleRecords s"),
    @NamedQuery(name = "SaleRecords.findById", query = "SELECT s FROM SaleRecords s WHERE s.saleRecordsPK.id = :id"),
    @NamedQuery(name = "SaleRecords.findByTime", query = "SELECT s FROM SaleRecords s WHERE s.saleRecordsPK.time = :time"),
    @NamedQuery(name = "SaleRecords.findByQuantity", query = "SELECT s FROM SaleRecords s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SaleRecords.findByTotalSaleCfa", query = "SELECT s FROM SaleRecords s WHERE s.totalSaleCfa = :totalSaleCfa")})
public class SaleRecords implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SaleRecordsPK saleRecordsPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "TOTAL_SALE_CFA")
    private Integer totalSaleCfa;
    @JoinColumn(name = "BOISSON_ID", referencedColumnName = "ID")
    @ManyToOne
    private Boisson boissonId;
    @JoinColumn(name = "CLIENTS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Clients clientsId;

    public SaleRecords() {
    }

    public SaleRecords(SaleRecordsPK saleRecordsPK) {
        this.saleRecordsPK = saleRecordsPK;
    }

    public SaleRecords(int id, Date time) {
        this.saleRecordsPK = new SaleRecordsPK(id, time);
    }

    public SaleRecordsPK getSaleRecordsPK() {
        return saleRecordsPK;
    }

    public void setSaleRecordsPK(SaleRecordsPK saleRecordsPK) {
        this.saleRecordsPK = saleRecordsPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalSaleCfa() {
        return totalSaleCfa;
    }

    public void setTotalSaleCfa(Integer totalSaleCfa) {
        this.totalSaleCfa = totalSaleCfa;
    }

    public Boisson getBoissonId() {
        return boissonId;
    }

    public void setBoissonId(Boisson boissonId) {
        this.boissonId = boissonId;
    }

    public Clients getClientsId() {
        return clientsId;
    }

    public void setClientsId(Clients clientsId) {
        this.clientsId = clientsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleRecordsPK != null ? saleRecordsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleRecords)) {
            return false;
        }
        SaleRecords other = (SaleRecords) object;
        if ((this.saleRecordsPK == null && other.saleRecordsPK != null) || (this.saleRecordsPK != null && !this.saleRecordsPK.equals(other.saleRecordsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseFiles.SaleRecords[ saleRecordsPK=" + saleRecordsPK + " ]";
    }
    
}
