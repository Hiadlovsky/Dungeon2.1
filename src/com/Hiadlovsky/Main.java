package com.Hiadlovsky;

import java.util.Scanner;

public class Main {


    public static MonsterList monsterList = new MonsterList();
    public static ItemList itemsList = new ItemList();
    public static Character player = new Character();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        monsterList.addMonsters();
        itemsList.addItems();

     /*   Item a = itemsList.lootSpawn(1);
        player.setRight(itemsList.getEmpty());
        player.setLeft(itemsList.getEmpty());
        player.setChest(itemsList.getEmpty());

        itemSwap(a);
         a = itemsList.lootSpawn(1);
        itemSwap(a);*/

        System.out.println("Enter the DOOM dungeon");
         doom();


    }



    public static void createCharacter() {
        boolean quit = false;
        player.inventoryStart(itemsList.getEmpty());

        System.out.println("Your character name:");
        String name = scanner.nextLine();
        while (!quit) {
            System.out.println("Name is: " + name + " are you sure ?\nY/N");
            if (yesNO()) {
                player.setName(name);
                quit = true;
            } else {
                System.out.println("New name:");
                name = scanner.nextLine();
            }

        }
        levelUP();

        character();

    }


    public static void levelUP() {
        boolean quit = false;
        int stat;
        int pointsToAdd;
        String statName;
        int strTemp = player.getStr();
        int dexTemp = player.getDex();
        int vitTemp = player.getVit();
        int statTemp = player.getLevelUpPoints();

        while (!quit) {
            boolean quitStat = false;
            System.out.println(player.getLevelUpPoints() + ", points to distribute:\n" +
                    player.getStr() + " STR to edit press 1\n" +
                    player.getDex() + " DEX to edit press 2\n" +
                    player.getVit() + " VIT to edit press 3\n" +
                    "----------------------------------\n" +
                    "Choice:");
            while (!intCheck()) {
                intCheck();
            }
            stat = scanner.nextInt();
            scanner.nextLine();
            while ((stat > 3) || (stat < 1)) {
                System.out.println("choose from 1 - 3.");
                while (!intCheck()) {
                    intCheck();
                }
                stat = scanner.nextInt();
                scanner.nextLine();
            }
            if (stat == 1) {
                statName = "STR";
            } else if (stat == 2) {
                statName = "DEX";
            } else {
                statName = "VIT";
            }
            while (!quitStat) {
                System.out.println("How manny points add to " + statName + ":");
                while (!intCheck()) {
                    intCheck();
                }
                pointsToAdd = scanner.nextInt();
                scanner.nextLine();

                if (player.levelDistribution(stat, pointsToAdd)) {
                    System.out.println("Added.");
                    quitStat = true;
                } else {
                    System.out.println("You can add max " + player.getLevelUpPoints() + " points.");
                }

            }

            if (player.getLevelUpPoints() > 0) {
                System.out.println("You have still " + player.getLevelUpPoints() + " not distributed");
            }
            if (player.getLevelUpPoints() == 0) {
                System.out.println(
                        player.getStr() + " STR\n" +
                                player.getDex() + " DEX\n" +
                                player.getVit() + " VIT\n" +
                                "Are you happy with point distribution, or you want to redo it?\nY (its ok)/N (reset)");
                if (yesNO()) {
                    quit = true;
                } else {
                    player.redo(strTemp, dexTemp, vitTemp, statTemp);
                }

            }
            if (!quit) {
                System.out.println("Quit distributing points?\n Y/N");
                if (yesNO()) {
                    quit = true;
                }
            }

        }
    }



    public static boolean run(Monster monster) {


        monster.evaluateEnemy();
        System.out.println("Run?\n Y/N");
        if (yesNO()) {
            if ((player.getDex() + player.dexBonus() + player.getLevel()) > (monster.getDex())) {
                System.out.println("Successful escape.");
                return true;
            }

            System.out.println(monster.getName() + " caught you. ");
        }
        return false;

    }

    public static void itemSwap(Item found) {

        Item empty = itemsList.getEmpty();
        String placement = found.getEquip();   // R
        Item current;
        boolean tH = false;
        Item ifTH;

        System.out.println("You found:\n " + found.evaluateItem() + "\nCurrently equip:");

        switch (placement) {
            case ("R"):
                current = player.getRight();
                break;
            case ("L"):
                current = player.getLeft();
                break;
            case ("C"):
                current = player.getChest();
                break;
            default:
                current = player.getRight();
                tH = true;
                break;

        }
        System.out.println(current.evaluateItem());
        if (tH) {
            ifTH = player.getLeft();
            System.out.println(ifTH.evaluateItem());

        }
        System.out.println("========================\n" +
                "Swap ?\nY/N");
        if (yesNO()) {
            player.equipItem(found, empty);
        }

        character();
    }


    public static boolean intCheck() {
        boolean isNumber = scanner.hasNextInt();
        if (isNumber) {
            return true;

        } else
            System.out.println("Not number");
        scanner.nextLine();
        return false;

    }

    public static boolean yesNO() {

        String choice = scanner.nextLine();
        switch (choice.toUpperCase()) {
            case ("Y"):
                return true;
            case ("N"):
                return false;
            default:
                return false;
        }
    }

    public static void character() {

        System.out.println("Name: " + player.getName() + "\n" +
                "____________________________\n" +
                "LEVEL:" + player.getLevel() + "\n" +
                "XP:"+player.getxP()+"/"+50*(player.getLevel()+1) + "\n" +
                "STR:" + player.getStr() + "(" + player.strBonus() + ")\n" +
                "DEX:" + player.getDex() + "(" + player.dexBonus() + ")\n" +
                "VIT:" + player.getVit() + "(" + player.vitBonus() + ")\n" +
                "HP:" + player.gethP() + "\n" +
                "Right:" + player.getRight().getName() + "\n" +
                "Chest:" + player.getChest().getName() + "\n" +
                "Left:" + player.getLeft().getName() + "\n" +
                "=============================");


    }

    public static void monsterTurn(Monster monster, int fullHp) {


        int health = player.monsterTurn(monster.getStr());
        if (health == -1) {
            System.out.println(player.getName() + " successfully blocked.");
        } else {
            System.out.println(player.getName() + " health: " + player.gethP() + "/" + fullHp + " HP.");

        }
    }


    public static int playerTurn(int monsterHp, int monsterVIT, int monsterFullHP, String name) {


        int health = player.myTurn(monsterHp, monsterVIT);
        if (health == -1) {
            System.out.println(name + " successfully blocked.");
            return monsterHp;
        } else {
            monsterHp = health;
            System.out.println(name + " health: " + monsterHp + "/" + monsterFullHP + " HP.");
            return monsterHp;
        }

    }

    public static void fight2() {

        Monster monster = monsterList.monsterSpawn(player.getLevel());
        int fullHp = (player.getVit()+player.vitBonus())*100;// opravit po boji s prehrou sa urci zostatok ako full HP
        int monsterHp = monster.gethP();
        int monsterVIT = monster.getVit();
        int monsterFullHP = monster.gethP();
        String monsterName = monster.getName();
        boolean dead = false;

        System.out.println("Yo found:\n" + monster.evaluateEnemy());
        boolean run = run(monster);
        if (!run) {
            while (!dead) {

                if (monster.getDex() >= player.getDex()) {
                    monsterTurn(monster, fullHp);
                    if (player.gethP() == 0) {
                        System.out.println("You are dead.");
                        dead = true;
                    } else {
                        System.out.println("========================================");
                        int result = playerTurn(monsterHp, monsterVIT, monsterFullHP, monsterName);
                        monsterHp = result;
                        if (monsterHp == 0) {
                            System.out.println(monster.getName() + " slain.");
                            dead = true;
                        }
                    }

                } else {
                    int result = playerTurn(monsterHp, monsterVIT, monsterFullHP, monsterName);
                    monsterHp = result;
                    if (monsterHp == 0) {
                        System.out.println(monster.getName() + " slain.");
                        dead = true;
                    } else {
                        System.out.println("========================================");
                        monsterTurn(monster, fullHp);
                        if (player.gethP() == 0) {
                            System.out.println("You are dead.");
                            dead = true;
                        }

                    }
                }
            }

          if (monsterHp==0){
              if (player.levelUP(monster.getxP())) {
                  levelUP();
              }
              System.out.println("Loot " + monster.getName() + " corps.\nY/N.");
              if (yesNO()) {
                  int roll = ((int) (Math.random() * 56 + 1));  // problem ? was 3
                  if (roll  >3) {   // was == 3
                      Item found = itemsList.lootSpawn(player.getLevel());
                      itemSwap(found);
                  }else {
                      System.out.println("Nothing.");
                  }
              }

              System.out.println(player.getName()+" Level:"+ player.getLevel()+", "+player.getxP()+"/"+50*(player.getLevel()+1)+"XP.");
          }
        }

    }

    public static void printMenu1() {
        System.out.println("1 - go forward \n" +
                "2 - go back\n" +
                "3 - heal\n" +
                "4 - character\n" +
                "5 - quit");

    }
    public static void doom() {
        createCharacter();
        boolean quit = false;
        int choice;


        while (!quit) {
            printMenu1();
            while (!intCheck()){
                intCheck();
            }


            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    forward();
                    break;
                case 2:
                    back();
                    break;
                case 3:
                    player.heal();
                    System.out.println("Fully heal "+ player.gethP()+" HP.");
                    break;
                case 4:
                    character();
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }

    }

    public static void forward() {
        int fight = ((int) (Math.random() * 6 + 1));
        if (fight<3) {
            System.out.println("Nothing in the darkness.");
        }else {
            fight2();

        }
    }

    public static void back() {
        int fight = ((int) (Math.random() * 6 + 1));
        System.out.println("dice roll is " + fight);
        if (fight<5) {
            System.out.println("Nothing in the darkness.");
        }else {
            fight2();
        }

    }


}













