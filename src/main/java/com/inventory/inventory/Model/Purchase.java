package com.inventory.inventory.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    private int purid;
    private int purpid;
    private int purvid;

    private String name;
    private  String vname;

    private int pqauntity;

    private double pcostprice;

    private  double ptotal;
    public int getPurid() {
        return purid;
    }

    public void setPurid(int purid) {
        this.purid = purid;
    }

    public int getPurpid() {
        return purpid;
    }

    public void setPurpid(int purpid) {
        this.purpid = purpid;
    }

    public int getPurvid() {
        return purvid;
    }

    public void setPurvid(int purvid) {
        this.purvid = purvid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public int getPqauntity() {
        return pqauntity;
    }

    public void setPqauntity(int pqauntity) {
        this.pqauntity = pqauntity;
    }

    public double getPcostprice() {
        return pcostprice;
    }

    public void setPcostprice(double pcostprice) {
        this.pcostprice = pcostprice;
    }

    public double getPtotal() {
        return ptotal;
    }

    public void setPtotal(double ptotal) {
        this.ptotal = ptotal;
    }

    public Purchase(int purid, int purpid, int purvid, String name, String vname, int pqauntity, double pcostprice, double ptotal) {
        this.purid = purid;
        this.purpid = purpid;
        this.purvid = purvid;
        this.name = name;
        this.vname = vname;
        this.pqauntity = pqauntity;
        this.pcostprice = pcostprice;
        this.ptotal = ptotal;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purid=" + purid +
                ", purpid=" + purpid +
                ", purvid=" + purvid +
                ", name='" + name + '\'' +
                ", vname='" + vname + '\'' +
                ", pqauntity=" + pqauntity +
                ", pcostprice=" + pcostprice +
                ", ptotal=" + ptotal +
                '}';
    }

    public Purchase() {
        super();
    }



}
