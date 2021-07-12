package com.bezkoder.springjwt.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)", name = "billId")
    @Id
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "export_date")
    private Date exportDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id",referencedColumnName = "listTBId")
    private ListTable listTable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id",referencedColumnName = "staffId")
    private Staff staff;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "bill_details",
            joinColumns = @JoinColumn(name = "billId"),
            inverseJoinColumns = @JoinColumn(name = "foodId"))
    private Set<Food> foods = new HashSet<>();

    public Bill() {
    }

    public Bill(String id, Date exportDate, ListTable listTable, Customer customer, Staff staff) {
        this.id = id;
        this.exportDate = exportDate;
        this.listTable = listTable;
        this.customer = customer;
        this.staff = staff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public ListTable getListTable() {
        return listTable;
    }

    public void setListTable(ListTable listTable) {
        this.listTable = listTable;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
