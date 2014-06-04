/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseFiles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bamaragcoulibaly
 */
@Entity
@Table(name = "RESERVATION_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservationTable.findAll", query = "SELECT r FROM ReservationTable r"),
    @NamedQuery(name = "ReservationTable.findById", query = "SELECT r FROM ReservationTable r WHERE r.id = :id"),
    @NamedQuery(name = "ReservationTable.findByQuantity", query = "SELECT r FROM ReservationTable r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "ReservationTable.findByTotalCfa", query = "SELECT r FROM ReservationTable r WHERE r.totalCfa = :totalCfa"),
    @NamedQuery(name = "ReservationTable.findByReservationDate", query = "SELECT r FROM ReservationTable r WHERE r.reservationDate = :reservationDate"),
    @NamedQuery(name = "ReservationTable.findByStatus", query = "SELECT r FROM ReservationTable r WHERE r.status = :status")})
public class ReservationTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "TOTAL_CFA")
    private Integer totalCfa;
    @Column(name = "RESERVATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date reservationDate;
    @Column(name = "STATUS")
    private String status;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reservationTable")
    private ReservationHistory reservationHistory;
    @JoinColumn(name = "BOISSON_ID", referencedColumnName = "ID")
    @ManyToOne
    private Boisson boissonId;
    @JoinColumn(name = "CLIENTS_ID", referencedColumnName = "ID")
    @ManyToOne
    private Clients clientsId;

    public ReservationTable() {
    }

    public ReservationTable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalCfa() {
        return totalCfa;
    }

    public void setTotalCfa(Integer totalCfa) {
        this.totalCfa = totalCfa;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReservationHistory getReservationHistory() {
        return reservationHistory;
    }

    public void setReservationHistory(ReservationHistory reservationHistory) {
        this.reservationHistory = reservationHistory;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationTable)) {
            return false;
        }
        ReservationTable other = (ReservationTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseFiles.ReservationTable[ id=" + id + " ]";
    }
    
}
