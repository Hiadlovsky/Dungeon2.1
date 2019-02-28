package com.Hiadlovsky;

import java.util.ArrayList;

public class ItemList {


    private ArrayList<Item> weapons;
    private ArrayList<Item> shields;
    private ArrayList<Item> armors;
    private Item empty;

    public ItemList() {
        this.weapons = new ArrayList<Item>();
        this.shields = new ArrayList<Item>();
        this.armors = new ArrayList<Item>();
        this.empty = new Item("empty", 0, 0, 0, "A");
    }


    public void addItems() {

        //Weapons
        Item axe = new Item("Axe", 2, 0, -1, "R");
        Item largeAxe = new Item("Large Axe", 4, 0, 0, "R");
        Item battleAxe = new Item("Battle Axe", 7, 1, 0, "R");
        Item flail = new Item("Flail", 7, -1, -1, "R");
        Item sabre = new Item("Sabre", 5, 2, 0, "R");
        Item longSword = new Item("Long Sword", 8, 2, 2, "R");
        Item bastardSword = new Item("Bastard Sword", 10, 4, 4, "R");
        Item theGrizzly = new Item("The Grizzly", 40, 12, -2, "RL");
        Item doomBringer = new Item("Doom Bringer", 25, 10, 5, "R");
        weapons.add(axe);
        weapons.add(largeAxe);
        weapons.add(battleAxe);
        weapons.add(flail);
        weapons.add(sabre);
        weapons.add(longSword);
        weapons.add(bastardSword);
        weapons.add(theGrizzly);
        weapons.add(doomBringer);

        // Shields
        Item buckler = new Item("Buckler", -1, 0, 2, "L");
        Item smallShield = new Item("Small Shield", 0, 0, 5, "L");
        Item largeShield = new Item("Large Shield", 1, 0, 8, "L");
        Item towerShield = new Item("Tower Shield", 3, 2, 15, "L");
        Item gothicShield = new Item("Gothic Shield", 5, 4, 20, "L");
        Item holyDefender = new Item("Holy Defender", 10, 10, 25, "L");
        shields.add(buckler);
        shields.add(smallShield);
        shields.add(largeShield);
        shields.add(towerShield);
        shields.add(gothicShield);
        shields.add(holyDefender);

        // Armors
        Item rags = new Item("Rags", 0, 0, 1, "C");
        Item robe = new Item("Robe", 0, 1, 1, "C");
        Item leatherArmor = new Item("Leather Armor", 0, 1, 6, "C");
        Item chainMail = new Item("Chain Mail", 2, 0, 10, "C");
        Item gothicPlate = new Item("Gothic Plate", 8, 8, 8, "C");
        Item demonSpikeCoat = new Item("Demon Spike Coat", 15, 15, 25, "C");
        armors.add(rags);
        armors.add(robe);
        armors.add(leatherArmor);
        armors.add(chainMail);
        armors.add(gothicPlate);
        armors.add(demonSpikeCoat);


    }


    public Item lootSpawn(int playerLevel) {
        Item temp;
        int diceRoll = ((int) (Math.random() * 9 + 1));
        if (diceRoll > 6) {
            diceRoll = ((int) (Math.random() * 55 + 1));
            if (diceRoll > 53) {
                temp = this.weapons.get(8);
            } else if (diceRoll > 50) {
                temp = this.weapons.get(7);
            } else if (diceRoll > 46) {
                temp = this.weapons.get(6);
            } else if (diceRoll > 41) {
                temp = this.weapons.get(5);
            } else if (diceRoll > 35) {
                temp = this.weapons.get(4);
            } else if (diceRoll > 28) {
                temp = this.weapons.get(3);
            } else if (diceRoll > 18) {
                temp = this.weapons.get(2);
            } else if (diceRoll > 9) {
                temp = this.weapons.get(1);
            } else {
                temp = this.weapons.get(0);
            }

        } else if (diceRoll > 3) {
            diceRoll = ((int) (Math.random() * 19 + 1));
            if (diceRoll > 16) {
                temp = this.shields.get(4);
            } else if (diceRoll > 13) {
                temp = this.shields.get(3);
            } else if (diceRoll > 10) {
                temp = this.shields.get(2);
            } else if (diceRoll > 5) {
                temp = this.shields.get(1);
            } else {
                temp = this.shields.get(0);
            }
        } else {
            diceRoll = ((int) (Math.random() * 19 + 1));
            if (diceRoll > 16) {
                temp = this.armors.get(4);
            } else if (diceRoll > 13) {
                temp = this.armors.get(3);
            } else if (diceRoll > 10) {
                temp = this.armors.get(2);
            } else if (diceRoll > 5) {
                temp = this.armors.get(1);
            } else {
                temp = this.armors.get(0);
            }


        }
        temp.levelSet(playerLevel);
        return temp;
    }


    public Item getEmpty() {
        return empty;
    }



}
