package com.nadimmahmud.fuelmatrix.Model;

import java.util.List;

public class tankList {
    private List<Tank> tanks;

    public tankList(List<Tank> tanks) {
        this.tanks = tanks;
    }

    public tankList() {
    }

    public List<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(List<Tank> tanks) {
        this.tanks = tanks;
    }
}
