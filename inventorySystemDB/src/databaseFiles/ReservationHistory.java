/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databaseFiles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "RESERVATION_HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservationHistory.findAll", query = "SELECT r FROM ReservationHistory r"),
    @NamedQuery(name = "ReservationHistory.findById", query = "SELECT r FROM ReservationHistory r WHERE r.id = :id"),
    @NamedQuery(name = "ReservationHistory.findByClientsId", query = "SELECT r FROM ReservationHistory r WHERE r.clientsId = :clientsId"),
    @NamedQuery(name = "ReservationHistory.findByBoissonId", query = "SELECT r FROM ReservationHistory r WHERE r.boissonId = :boissonId"),
    @NamedQuery(name = "ReservationHistory.findByTotalCfa", query = "SELECT r FROM ReservationHistory r WHERE r.totalCfa = :totalCfa"),
    @NamedQuery(name = "ReservationHistory.findByTransactionTime", query = "SELECT r FROM ReservationHistory r WHERE r.transactionTime = :transactionTime"),
    @NamedQuery(name = "ReservationHistory.findByReservationDate", query = "SELECT r FROM ReservationHistory r WHERE r.reservationDate = :reservationDate")})
public class ReservationHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CLIENTS_ID")
    private Integer clientsId;
    @Column(name = "BOISSON_ID")
    private Integer boissonId;
    @Column(name = "TOTAL_CFA")
    private Integer totalCfa;
    @Column(name = "TRANSACTION_TIME")
    @Temporal(TemporalType.DATE)
    private Date transactionTime;
    @Column(name = "RESERVATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date reservationDate;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ReservationTable reservationTable;

    public ReservationHistory() {
    }

    public ReservationHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientsId() {
        return clientsId;
    }

    public void setClientsId(Integer clientsId) {
        this.clientsId = clientsId;
    }

    public Integer getBoissonId() {
        return boissonId;
    }

    public void setBoissonId(Integer boissonId) {
        this.boissonId = boissonId;
    }

    public Integer getTotalCfa() {
        return totalCfa;
    }

    public void setTotalCfa(Integer totalCfa) {
        this.totalCfa = totalCfa;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationTable getReservationTable() {
        return reservationTable;
    }

    public void setReservationTable(ReservationTable reservationTable) {
        this.reservationTable = reservationTable;
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
        if (!(object instanceof ReservationHistory)) {
            return false;
        }
        ReservationHistory other = (ReservationHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databaseFiles.ReservationHistory[ id=" + id + " ]";
    }
    
}
