package com.Hiadlovsky;

import java.util.ArrayList;

public class MonsterList {

    private ArrayList<Monster> monsters;

    public MonsterList() {
        this.monsters = new ArrayList<Monster>();
    }

    public void addMonsters() {
        Monster fallen = new Monster("Fallen", 2, 2, 3, 2);
        Monster goat = new Monster("Goat Man", 3, 2, 5, 5);
        Monster skeleton = new Monster("Skeleton", 3, 2, 2, 7);
        Monster hornedDemon = new Monster("Horned Demon", 6, 2, 5, 10);
        Monster magmaDemon = new Monster("Magma Demon", 5, 2, 5, 12);
        Monster overlord = new Monster("Overlord", 7, 2, 6, 15);
        Monster knight = new Monster("Knight", 8, 7, 7, 20);
        Monster spittingTerror = new Monster("Spitting Terror", 7, 2, 7, 22);
        Monster diablo = new Monster("Diablo", 8, 8, 8, 50);

        this.monsters.add(fallen);
        this.monsters.add(goat);
        this.monsters.add(skeleton);
        this.monsters.add(hornedDemon);
        this.monsters.add(magmaDemon);
        this.monsters.add(overlord);
        this.monsters.add(knight);
        this.monsters.add(spittingTerror);
        this.monsters.add(diablo);
    }

    public Monster monsterSpawn (int playerLevel){
        int diceRoll = ((int) (Math.random() * 54 + 1));
        Monster spawn;
        if (diceRoll==54) {
            spawn = this.monsters.get(8);
        }else if (diceRoll>=53){
            spawn = monsters.get(7);
        }else if (diceRoll>=50){
            spawn = monsters.get(6);
        }else if (diceRoll>=46){
            spawn = monsters.get(5);
        }else if (diceRoll>=41){
            spawn = monsters.get(4);
        }else if (diceRoll>=35){
            spawn = monsters.get(3);
        }else if (diceRoll>=28){
            spawn = monsters.get(2);
        }else if (diceRoll>=18){
            spawn = monsters.get(1);
        }else
            spawn = monsters.get(0);

        spawn.levelSet(playerLevel);
        return spawn;

    }








}
