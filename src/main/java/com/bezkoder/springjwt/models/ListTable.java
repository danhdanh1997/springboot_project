package com.bezkoder.springjwt.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "list_table")
public class ListTable {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)", name = "listTBId")
    @Id
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booking_table_date")
    private Date bookingTableDate;

    @Column(name = "number_of_guest")
    private long numberOfGuest;

    @Column(name = "more_information")
    private String moreInfo;

    @OneToMany(mappedBy = "listTable",cascade = CascadeType.ALL)
    private List<Bill> billList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "food_table",
            joinColumns = @JoinColumn(name = "listTBId"),
            inverseJoinColumns = @JoinColumn(name = "foodId"))
    private List<Food> foods = new ArrayList<>();

    public ListTable() {
    }

    public ListTable(String id, Date bookingTableDate, long numberOfGuest, String moreInfo) {
        this.id = id;
        this.bookingTableDate = bookingTableDate;
        this.numberOfGuest = numberOfGuest;
        this.moreInfo = moreInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBookingTableDate() {
        return bookingTableDate;
    }

    public void setBookingTableDate(Date bookingTableDate) {
        this.bookingTableDate = bookingTableDate;
    }

    public long getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(long numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
