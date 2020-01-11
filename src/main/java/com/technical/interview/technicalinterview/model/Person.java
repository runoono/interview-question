package com.technical.interview.technicalinterview.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name= "PERSON")
@EntityListeners(AuditingEntityListener.class)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

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

    /**
     * Get person's ID
     * @return Returns ID as Long
     */
    public Long getId(){
        return this.id;
    }

    /**
     * Set person's ID
     * @param id Person's ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get person's first name
     * @return Person's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Set person's first name
     * @param Name Person's first name
     */
    public void setFirstName(String Name) {
        this.firstName = Name;
    }

    /**
     * Get person's last name
     * @return Person's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Set person's last name
     * @param Name Person's last name
     */
    public void setLastName(String Name) {
        this.lastName = Name;
    }

    /**
     * Get person's capital worth
     * @return Returns Person's capital worth
     */
    public BigDecimal getCapitalWorth() {
        return  this.capitalWorth;
    }

    /**
     * Set person's capital worth
     * @param capitalWorth Person's capital worth
     */
    public void setCapitalWorth(BigDecimal capitalWorth) {
        this.capitalWorth = capitalWorth;
    }

    /**
     * Get person's creation date
     * @return Person's creation date
     */
    public Date getCreateDate(){
        return this.creationDate;
    }

    /**
     * Set person's creation date
     * @param creationDate Person's creation date, takes java.util.date, converted to java.sql.timestamp
     */
    public void setCreationDate(Date creationDate){
        this.creationDate = new Timestamp(creationDate.getTime());
    }

    /**
     * Get person's last update date
     * @return Person's last update date
     */
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /**
     * Set person's last update date
     * @param lastUpdatedDate Person's last update date, takes java.util.date, converted to java.sql.timestamp
     */
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = new Timestamp(lastUpdatedDate.getTime());
    }
}
