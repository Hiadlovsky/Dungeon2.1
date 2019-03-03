package com.Hiadlovsky;

public class Item {

    private String name;
    private int str;
    private int dex;
    private int vit;
    private String equip;


    public Item() {
    }

    public Item(String name, int str, int dex, int vit, String equip) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.vit = vit;
        this.equip = equip;
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getVit() {
        return vit;
    }

    public String getEquip() {
        return equip;
    }


    public void levelSet(int playerLevel) {
        if (playerLevel > 0) {
            if (this.str > 0) {
                this.str = this.str + 3*playerLevel;
            }
            if (this.dex > 0) {
                this.dex = this.dex + 3*playerLevel;

            }
            if (this.vit > 0) {
                this.vit = this.vit + 3*playerLevel;
            }


        }
    }

    public String evaluateItem (){
        return this.name+"\nSTR: "+this.str+"\nDEX: "+this.dex+"\nVIT: "+this.vit;
    }


}