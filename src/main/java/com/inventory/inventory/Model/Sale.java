package com.inventory.inventory.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    private int saleid;
    private int salepid;
    private int salecid;
    private String name;
    private  String cname;
    private int sqauntity;
    private double csaleprice;
    private double stotal;

    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
    }

    public int getSalepid() {
        return salepid;
    }

    public void setSalepid(int salepid) {
        this.salepid = salepid;
    }

    public int getSalecid() {
        return salecid;
    }

    public void setSalecid(int salecid) {
        this.salecid = salecid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getSqauntity() {
        return sqauntity;
    }

    public void setSqauntity(int sqauntity) {
        this.sqauntity = sqauntity;
    }

    public double getCsaleprice() {
        return csaleprice;
    }

    public void setCsaleprice(double csaleprice) {
        this.csaleprice = csaleprice;
    }

    public double getStotal() {
        return stotal;
    }

    public void setStotal(double stotal) {
        this.stotal = stotal;
    }

    public Sale(int saleid, int salepid, int salecid, String name, String cname, int sqauntity, double csaleprice, double stotal) {
        this.saleid = saleid;
        this.salepid = salepid;
        this.salecid = salecid;
        this.name = name;
        this.cname = cname;
        this.sqauntity = sqauntity;
        this.csaleprice = csaleprice;
        this.stotal = stotal;
    }

    public Sale() {
        super();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleid=" + saleid +
                ", salepid=" + salepid +
                ", salecid=" + salecid +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", sqauntity=" + sqauntity +
                ", csaleprice=" + csaleprice +
                ", stotal=" + stotal +
                '}';
    }
}
