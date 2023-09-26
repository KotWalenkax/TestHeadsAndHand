package creature;

public abstract class Creature {

    //attack
    private int atk;
    //defense
    private int def;
    //health points
    private int hP;
    //heal counter
    private int healCount;
    //max damage
    private int maxDmg;
    //min damage
    private int minDmg;
    //max health points
    private int maxHP;
    //Status for disable creature if it is dead
    private boolean lifeStatus;

    Creature() {
        this.healCount = 4;
    }

    public boolean hit(Creature creature) {
        //attack modifier
        int atkMod = this.getAtk() - creature.getDef();
        if (atkMod < 0) {
            atkMod = 1;
        } else {
            atkMod = atkMod + 1;
        }

        if (rollDice(atkMod)) {
            creature.getHit(getAtkDmg());
            this.getHitVoice();

            if (creature.getHP() == 0 || creature.hP < 0) {
                creature.setLifeStatus(false);
            } else {
                System.out.println(creature + " HP left: " + creature.getHP());
            }

            return true;
        } else {
            this.getMissVoice();
            return false;
        }
    }

    private boolean rollDice(int atkMod) {
        boolean success = false;
        int min = 1;
        int max = 6;

        while (atkMod != 0) {
            atkMod--;
            int chance = (int) ((Math.random() *  max) + min);
            if (chance == 5 || chance == 6) {
                success = true;
            }
        }

        return success;
    }

    private int getAtkDmg() {
        return (int) ((Math.random() *  maxDmg) + minDmg);
    }

    private void getHit(int incomingDmg) {
        hP = hP - incomingDmg;
        if (hP < 0 || hP == 0) {
            lifeStatus = false;
        }
    }

    public boolean healYourself() {
        if (healCount != 0 ) {
            hP = hP + Math.round(maxHP*0.3f);
            if (hP > maxHP) {
                hP = maxHP;
            }
            healCount--;
            this.getHealingVoice();
            return true;
        } else {
            System.out.println("Heal potions were out");
            return false;
        }
    }

    public int getAtk() {
        return atk;
    }

    public boolean setAtk(int atk) {
        if (atk >= 1 && atk <= 30) {
            this.atk = atk;
            return true;
        } else {
            System.out.println("Attack must be in 1 to 30 points");
            return false;
        }
    }

    public int getDef() {
        return def;
    }

    public boolean setDef(int def) {
        if (def >= 1 && def <= 30) {
            this.def = def;
            return true;
        } else {
            System.out.println("Defense must be in 1 to 30 points");
            return false;
        }
    }

    public int getHP() {
        return hP;
    }

    public boolean setHP(int hp) {
        if (hp > 0 && hp <= maxHP) {
            this.hP = hp;
            lifeStatus = true;
            return true;
        } else {
            System.out.println("Health must be more 0 and less or equal max hp");
            return false;
        }
    }

    public int getHealCount() {
        return healCount;
    }

    public void setHealCount(int healCount) {
        this.healCount = healCount;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public boolean setMaxDmg(int maxDmg) {
        if (maxDmg > 0 && maxDmg > minDmg) {
            this.maxDmg = maxDmg;
            return true;
        } else {
            System.out.println("Max mdg must be more 0 and more min dmg");
            return false;
        }
    }

    public int getMinDmg() {
        return minDmg;
    }

    public boolean setMinDmg(int minDmg) {
        if (minDmg > 0) {
            this.minDmg = minDmg;
            return true;
        } else {
            System.out.println("Min mdg must be more 0");
            return false;
        }
    }

    public int getMaxHP() {
        return maxHP;
    }

    public boolean setMaxHP(int maxHP) {
        if (maxHP > 0) {
            this.maxHP = maxHP;
            return true;
        } else {
            System.out.println("Max hp must be more 0");
            return false;
        }
    }

    public boolean isAlive() {
        return lifeStatus;
    }

    public void setLifeStatus(boolean lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public abstract void getHitVoice();
    public abstract void getHealingVoice();
    public abstract void getMissVoice();
}
