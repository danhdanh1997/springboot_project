package com.bezkoder.springjwt.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resources")
public class Resources {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)", name = "resourcesId")
    @Id
    private String id;

    @Column(name = "resources_name")
    private String resourcesName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "input_date")
    private Date inputDate;

    @Column(name = "expiry_date")
    private int expiryDate;

    @Column(name = "inventory_number")
    private Long inventoryNumber;

    @Column(name = "unit")
    private String unit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id",referencedColumnName = "supplier_id")
    private Supplier supplier;

    public Resources() {
    }

    public Resources(String id, String resourcesName, Date inputDate, int expiryDate, Long inventoryNumber, String unit, Supplier supplier) {
        this.id = id;
        this.resourcesName = resourcesName;
        this.inputDate = inputDate;
        this.expiryDate = expiryDate;
        this.inventoryNumber = inventoryNumber;
        this.unit = unit;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Long inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
