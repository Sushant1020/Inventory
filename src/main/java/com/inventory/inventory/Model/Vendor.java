package com.inventory.inventory.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "vendor")
public class Vendor {
    @Id
    private int vid;
    @NotBlank(message = "Name Must Not Be Blank")
    @Size(min = 3,message = "Name Must be atleast 3 letters")
    private String vname;
    @NotBlank(message = "Address Must Not Be Blank")
    @Size(min = 5,message = "Name Must be atleast 5 letters")
    private String vaddress;


    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String vphone;

    private double vbal;
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }

    public double getVbal() {
        return vbal;
    }

    public void setVbal(double vbal) {
        this.vbal = vbal;
    }

    public Vendor(int vid, String vname, String vaddress, String vphone, double vbal) {
        this.vid = vid;
        this.vname = vname;
        this.vaddress = vaddress;
        this.vphone = vphone;
        this.vbal = vbal;
    }

    public Vendor() {
        super();
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vid=" + vid +
                ", vname='" + vname + '\'' +
                ", vaddress='" + vaddress + '\'' +
                ", vphone=" + vphone +
                ", vbal=" + vbal +
                '}';
    }
}
