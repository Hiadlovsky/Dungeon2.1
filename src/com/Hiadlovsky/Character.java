package com.Hiadlovsky;

public class Character {

    private String name;
    private int str;
    private int dex;
    private int vit;
    private Item left;
    private Item right;
    private Item chest;
    private int level;
    private int hP;
    private int levelUpPoints;
    private int xP;
/*//                                       test-------------------
    public void setLeft(Item left) {
        this.left = left;
    }

    public void setRight(Item right) {
        this.right = right;
    }

    public void setChest(Item chest) {
        this.chest = chest;
    }
//                                        test -----------------*/
    public Character() {
        this.levelUpPoints = 15;
        this.level = 0;
        this.xP = 0;
        this.left = new Item();
        this.right = new Item();
        this.chest = new Item();











    }
    public void inventoryStart (Item item){
        this.right =item;
        this.left = item;
        this.chest = item;

    }


     public boolean levelUP (int xP){
        this.xP = this.xP+xP;


        if (this.xP>nexLevelXP()){
            this.level =this.level+1;
            levelUP();
            return true;
        }
        return false;
     }
    private void levelUP (){
        this.levelUpPoints = this.levelUpPoints+15;
    }


    public int nexLevelXP(){
        int temp = this.level+1;
        int nextLevel;
         if (this.level>12){
             nextLevel = (1000*temp);
         } else if (this.level>8){
            nextLevel= (500*temp);
        }else if(this.level>5){
            nextLevel= (100*temp);
        }else {
               nextLevel = (50 * temp);
           }

          return nextLevel;
    }



    private void distributeStats(int statChoice, int statsToAdd) {

        switch (statChoice) {
            case 1:
                this.str = this.str + statsToAdd;
                break;
            case 2:
                this.dex = this.dex + statsToAdd;
                break;
            case 3:
                this.vit = this.vit + statsToAdd;
                this.hP = (this.vit+vitBonus()) * 100;
                break;
            default:
                break;
        }

    }


    public boolean levelDistribution(int statChoice, int statsToAdd) {

        if (statsToAdd>this.levelUpPoints){
            return false;
        }
        if (this.levelUpPoints>0){
            distributeStats(statChoice,statsToAdd);
            this.levelUpPoints= this.levelUpPoints-statsToAdd;
            return true;
        }
         return false;

    }

    public void redo(int str, int dex, int vit, int levelUpPoints){
        this.str = str;
        this.dex = dex;
        this.vit = vit;
        this.levelUpPoints = levelUpPoints;

     }


    public void equipItem (Item equipItem,Item empty){
         int currentVitBonus = vitBonus()*100;

        if (equipItem.getEquip().equals("R")){
            this.right = equipItem;
        }else if (equipItem.getEquip().equals("L")) {
            this.left = equipItem;
        } else if (equipItem.getEquip().equals("C")) {
            this.chest = equipItem;
        }else {
            this.right = equipItem;
            this.left = empty;

        }

        this.hP = this.hP+((vitBonus()*100)-currentVitBonus);

    }


    public int myTurn (int monsterHp, int monsterVIT){
        int attack =  (this.str+strBonus())*diceRoll8();
        int defend = monsterVIT*2;
        System.out.println("Your attack "+attack+" DMG.");
        if (attack>=defend){
             monsterHp = monsterHp- (attack-defend);
             if (monsterHp<0){
                 monsterHp =0;
             }
             return monsterHp;
         }else
             return -1;
    }

    public int monsterTurn (int monsterSTR){
        int attack = monsterSTR*diceRoll8();
        int defend = this.vit+vitBonus();
        System.out.println("Monster attack "+attack+" DMG.");
        if (attack>=defend){
            this.hP= this.hP- (attack-defend);
            if (this.hP<0){
                this.hP=0;
            }
            return 1;
        }else
            return -1;
    }



    public int strBonus (){

        int strBonus = this.left.getStr()+this.right.getStr()+this.chest.getStr();
        return strBonus;
    }

    public int dexBonus (){
        int dexBonus = this.left.getDex()+this.right.getDex()+this.chest.getDex();
        return dexBonus;
    }

    public  int vitBonus (){
        int vitBonus = this.left.getVit()+this.right.getVit()+this.chest.getVit();
        return vitBonus;
    }


    public void heal (){
        this.hP = (this.vit+vitBonus()) * 100;
    }


    private int diceRoll8 (){
       int roll =  ((int) (Math.random() * 8 + 1));
         return roll;
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

    public String getName() {
        return name;
    }

    public Item getLeft() {
        return left;
    }

    public Item getRight() {
        return right;
    }

    public Item getChest() {
        return chest;
    }

    public int getLevel() {
        return level;
    }

    public int gethP() {
        return hP;
    }

    public int getLevelUpPoints() {
        return levelUpPoints;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxP() {
        return xP;
    }
}
