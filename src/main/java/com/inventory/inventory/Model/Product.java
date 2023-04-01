package com.inventory.inventory.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    private int pid;
@NotBlank(message = "Name Must Not be Blank")
@Size(min = 3,message = "Name Must contain atleast 3 Letters")
    private String name;
@NotBlank(message = "Color Must Not be Blank")
@Size(min = 3,message = "Color Must contain atleast 3 Letters")
    private String color;


    private int qauntity;

    private double cost;

    private double sellprice;
    private double total;


    private int num;

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }



    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSellprice() {
        return sellprice;
    }

    public void setSellprice(double sellprice) {
        this.sellprice = sellprice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public Product(int pid, String name, String color, int quantity, double cost, double sellprice, double total, int num,
                   int qauntity) {
        this.pid = pid;
        this.name = name;
        this.color = color;
        this.cost = cost;
        this.sellprice = sellprice;
        this.total = total;
        this.qauntity=qauntity;
        this.num=num;
    }

    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                ", sellprice=" + sellprice +
                ",qauntity="+qauntity+
                ", total=" + total +
                ", num="+num+
                '}';
    }

}
