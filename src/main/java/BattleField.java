import creature.Creature;
import creature.Monster;
import creature.Player;

import java.util.Scanner;

public class BattleField {

    private Creature player;

    private Creature monster;

    public BattleField() {}

    public void initFighters(Scanner sc) {
        player = new Player();
        fillCreatureFields(player, sc);

        monster = new Monster();
        fillCreatureFields(monster, sc);
    }

    public void putPredefinedCharacteristic() {
        player = new Player();
        player.setAtk(20);
        player.setDef(10);
        player.setMaxHP(150);
        player.setHP(150);
        player.setMinDmg(5);
        player.setMaxDmg(20);

        monster = new Monster();
        monster.setAtk(20);
        monster.setDef(10);
        monster.setMaxHP(150);
        monster.setHP(150);
        monster.setMinDmg(5);
        monster.setMaxDmg(20);
    }

    public void fight() {
        while(player.isAlive() && monster.isAlive()) {
            System.out.println("==============");

            System.out.println("Player turn: ");
            if (player.hit(monster)) {
                monster.healYourself();
                if (!monster.isAlive()) {
                    break;
                }
            }

            System.out.println("==============");

            System.out.println("Monster turn: ");
            if (monster.hit(player)) {
                player.healYourself();
                if (!player.isAlive()) {
                    break;
                }
            }
        }

        if (player.isAlive()) {
            System.out.println("PLAYER WIN!!!");
        } else {
            System.out.println("MONSTER WIN!!!");
        }
    }

    public void fillCreatureFields(Creature creature, Scanner sc) {
        System.out.println("\n===========");
        boolean success = false;

        System.out.println(creature + " characteristics: \n");

        do {
            System.out.println("Add attack points (in 1 to 30): ");
            if (sc.hasNextInt()) {
                int atk = sc.nextInt();
                success = creature.setAtk(atk);
            } else {
                System.out.println("Input must be INTEGER");
                sc.next();
            }
        } while (!success);


        do {
            System.out.println("Add defense points (in 1 to 30): ");
            if (sc.hasNextInt()) {
                int def = sc.nextInt();
                success = creature.setDef(def);
            } else {
                success = false;
                System.out.println("Input must be INTEGER");
                sc.next();
            }
        } while (!success);

        do {
            System.out.println("Add max health points points (must be more 0): ");
            if (sc.hasNextInt()) {
                int maxHP = sc.nextInt();
                success = creature.setMaxHP(maxHP);
            } else {
                success = false;
                System.out.println("Input must be INTEGER");
                sc.next();
            }
        } while (!success);

        do {
            System.out.println("Add health points points (must be more 0 and equal or less max hp): ");
            if (sc.hasNextInt()) {
                int hP = sc.nextInt();
                success = creature.setHP(hP);
            } else {
                success = false;
                System.out.println("Input must be INTEGER");
                sc.next();
            }
        } while (!success);

        do {
            System.out.println("Add min damage points (must be more 0): ");
            if (sc.hasNextInt()) {
                int minDmg = sc.nextInt();
                success = creature.setMinDmg(minDmg);
            } else {
                success = false;
                System.out.println("Input must be INTEGER");
                sc.next();

            }
        } while (!success);

        do {
            System.out.println("Add max damage points (must more 0 and more min dmg): ");
            if (sc.hasNextInt()) {
                int maxDmg = sc.nextInt();
                success = creature.setMaxDmg(maxDmg);
            } else {
                success = false;
                System.out.println("Input must be INTEGER");
                sc.next();
            }
        } while (!success);

    }
}
