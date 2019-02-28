package com.Hiadlovsky;

public class Monster {

    private String name;
    private int str;
    private int dex;
    private int vit;
    private int hP;
    private int xP;
    private int level;


    public Monster(String name, int str, int dex, int vit, int xP) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.vit = vit;
        this.hP = vit*100;
        this.xP= xP;

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

    public int gethP() {
        return hP;
    }

    public int getxP() {
        return xP;
    }

    public int getLevel() {
        return level;
    }

    public void levelSet (int playerLevel){
        this.level = playerLevel+1;
        if (this.level>1){
            this.str=this.str+1;
            this.dex =this.dex+1;
            this.vit =this.vit+1;
            this.hP = this.hP*2;
            this.xP = this.xP*playerLevel;  // po level 5 potom problem

        }

    }

    public String evaluateEnemy (){
        return this.name+"\n---------\nSTR: "+this.str+"\nDEX: "+this.dex+"\nVIT: "+this.vit+"\nHP: "+this.hP+"\n=========";
    }

}
