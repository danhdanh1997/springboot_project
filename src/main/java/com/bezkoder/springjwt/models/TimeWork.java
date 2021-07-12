package com.bezkoder.springjwt.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "time_work")
public class TimeWork {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)", name = "shiftId")
    @Id
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_work")
    private Date dateOfWork;

    @Column(name = "category_shift")
    private String categoryShift;

    public TimeWork() {
    }

    public TimeWork(String id, Date dateOfWork, String categoryShift) {
        this.id = id;
        this.dateOfWork = dateOfWork;
        this.categoryShift = categoryShift;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public String getCategoryShift() {
        return categoryShift;
    }

    public void setCategoryShift(String categoryShift) {
        this.categoryShift = categoryShift;
    }
}
