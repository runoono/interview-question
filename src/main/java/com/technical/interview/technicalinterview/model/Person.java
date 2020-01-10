package com.technical.interview.technicalinterview.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name= "PERSON")
@EntityListeners(AuditingEntityListener.class)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "capitalWorth")
    private BigDecimal capitalWorth;

    @CreationTimestamp
    @Column(name = "creationDate")
    private java.sql.Timestamp creationDate;

    @UpdateTimestamp
    @Column(name = "lastUpdatedDate")
    private java.sql.Timestamp lastUpdatedDate;

    //ID method
    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    //firstName Methods
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String Name) {
        this.firstName = Name;
    }

    //lastName methods
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String Name) {
        this.lastName = Name;
    }

    //capitalWorth methods
    public BigDecimal getCapitalWorth() {
        return  this.capitalWorth;
    }

    public void setCapitalWorth(BigDecimal worth) {
        this.capitalWorth = worth;
    }

    //creationDate methods
    public Date getCreateDate(){
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = new Timestamp(creationDate.getTime());
    }

    //lastUpdateMethods

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = new Timestamp(lastUpdatedDate.getTime());
    }
}
