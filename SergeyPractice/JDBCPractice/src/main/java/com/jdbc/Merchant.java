package com.jdbc;

/**
 * Created by c263 on 10.07.2015.
 */
public class Merchant {
    private int id;
    private String name;
    private double charge;
    private int period;
    private double total;

    public Merchant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStringForPrint() {
        //String txt = "id = " + id + ";   name = '" + name + "';   charge = ";
        //txt += "" + charge + ";   period = " + period + ";   total = " + total;
        String txt = String.format("id =%1$2d;  name = %2$25s;   charge = %3$5.2f;   period = %4$3d;   total = %5$7.2f", id, name, charge, period, total);
        return txt;
    }
}
