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
@Table(name = "customer")
public class Customer {
    @Id
    private int cid;
    @NotBlank(message = "Name Must Not Be Blank")
    @Size(min = 3,message = "Name Must be atleast 3 letters")
    private String cname;
    @NotBlank(message = "Address Must Not Be Blank")
    @Size(min = 5,message = "Name Must be atleast 5 letters")
    private String caddress;

    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String cphone;
    private double cbal;


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public double getCbal() {
        return cbal;
    }



    public void setCbal(double cbal) {
        this.cbal = cbal;
    }

    public Customer(int cid, String cname, String caddress, String cphone, double cbal) {
        this.cid = cid;
        this.cname = cname;
        this.caddress = caddress;
        this.cphone = cphone;
        this.cbal = cbal;
    }


    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", caddress='" + caddress + '\'' +
                ", cphone=" + cphone +
                ", cbal=" + cbal +
                '}';
    }
}
