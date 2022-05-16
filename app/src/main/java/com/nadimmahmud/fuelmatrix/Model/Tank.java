package com.nadimmahmud.fuelmatrix.Model;

public class Tank {
   private int tank_id;
   private String tank_name;
   private String date;
   private double height;
   private double volume;
   private String height_unit;
   private String volume_unit;

    public Tank() {
    }

    public Tank(int tank_id, String tank_name, String date, double height, double volume, String height_unit, String volume_unit) {
        this.tank_id = tank_id;
        this.tank_name = tank_name;
        this.date = date;
        this.height = height;
        this.volume = volume;
        this.height_unit = height_unit;
        this.volume_unit = volume_unit;
    }

    public int getTank_id() {
        return tank_id;
    }

    public void setTank_id(int tank_id) {
        this.tank_id = tank_id;
    }

    public String getTank_name() {
        return tank_name;
    }

    public void setTank_name(String tank_name) {
        this.tank_name = tank_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getHeight_unit() {
        return height_unit;
    }

    public void setHeight_unit(String height_unit) {
        this.height_unit = height_unit;
    }

    public String getVolume_unit() {
        return volume_unit;
    }

    public void setVolume_unit(String volume_unit) {
        this.volume_unit = volume_unit;
    }
}
