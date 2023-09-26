import creature.Creature;
import creature.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreatureTest {

    @Test
    public void init_creature() {
        Creature creature = new Player();

        Assertions.assertEquals(0, creature.getAtk());
        Assertions.assertEquals(0, creature.getDef());
        Assertions.assertEquals(0, creature.getHP());
        Assertions.assertEquals(4, creature.getHealCount());
        Assertions.assertEquals(0, creature.getMinDmg());
        Assertions.assertEquals(0, creature.getMaxDmg());
        Assertions.assertEquals(0, creature.getMaxHP());
        Assertions.assertFalse(creature.isAlive());

    }

    @Test
    public void add_correct_atk() {
        Creature creature = new Player();

        Assertions.assertTrue(creature.setAtk(1));
        Assertions.assertEquals(1, creature.getAtk());

        Assertions.assertTrue(creature.setAtk(30));
        Assertions.assertEquals(30, creature.getAtk());
    }

    @Test
    public void add_incorrect_atk() {
        Creature creature = new Player();

        Assertions.assertFalse(creature.setAtk(0));
        Assertions.assertEquals(0, creature.getAtk());

        Assertions.assertFalse(creature.setAtk(31));
        Assertions.assertEquals(0, creature.getAtk());
    }

    @Test
    public void add_correct_def() {
        Creature creature = new Player();

        Assertions.assertTrue(creature.setDef(1));
        Assertions.assertEquals(1, creature.getDef());

        Assertions.assertTrue(creature.setDef(30));
        Assertions.assertEquals(30, creature.getDef());
    }

    @Test
    public void add_incorrect_def() {
        Creature creature = new Player();

        Assertions.assertFalse(creature.setDef(-1));
        Assertions.assertEquals(0, creature.getDef());

        Assertions.assertFalse(creature.setDef(31));
        Assertions.assertEquals(0, creature.getDef());
    }

    @Test
    public void set_correct_hp_less_maxHP() {
        Creature creature = new Player();
        creature.setMaxHP(5);

        Assertions.assertTrue(creature.setHP(1));
        Assertions.assertEquals(1, creature.getHP());
    }

    @Test
    public void set_correct_hp_equals_maxHP() {
        Creature creature = new Player();
        creature.setMaxHP(5);

        Assertions.assertTrue(creature.setHP(5));
        Assertions.assertEquals(5, creature.getHP());
    }

    @Test
    public void set_incorrect_hp_less_zero() {
        Creature creature = new Player();

        Assertions.assertFalse(creature.setHP(-1));
        Assertions.assertEquals(0, creature.getHP());
    }

    @Test
    public void set_incorrect_hp_more_maxHP() {
        Creature creature = new Player();
        creature.setMaxHP(3);

        Assertions.assertFalse(creature.setHP(4));
        Assertions.assertEquals(0, creature.getHP());
    }

    @Test
    public void set_correct_minDmg() {
        Creature creature = new Player();

        Assertions.assertTrue(creature.setMinDmg(1));
        Assertions.assertEquals(1, creature.getMinDmg());
    }

    @Test
    public void set_incorrect_minDmg() {
        Creature creature = new Player();

        Assertions.assertFalse(creature.setMinDmg(-1));
        Assertions.assertEquals(0, creature.getMinDmg());
    }

    @Test
    public void set_correct_maxDmg() {
        Creature creature = new Player();
        creature.setMinDmg(1);

        Assertions.assertTrue(creature.setMaxDmg(2));
        Assertions.assertEquals(2, creature.getMaxDmg());
    }

    @Test
    public void set_incorrect_maxDmg_less_zero() {
        Creature creature = new Player();

        Assertions.assertFalse(creature.setMaxDmg(-1));
        Assertions.assertEquals(0, creature.getMaxDmg());
    }

    @Test
    public void set_incorrect_maxDmg_less_minDmg() {
        Creature creature = new Player();
        creature.setMinDmg(2);

        Assertions.assertFalse(creature.setMaxDmg(1));
        Assertions.assertEquals(0, creature.getMaxDmg());
    }

    @Test
    public void set_correct_maxHP() {
        Creature creature = new Player();

        Assertions.assertTrue(creature.setMaxHP(1));
        Assertions.assertEquals(1, creature.getMaxHP());
    }

    @Test
    public void set_incorrect_maxHP() {
        Creature creature = new Player();

        Assertions.assertFalse(creature.setMaxHP(-1));
        Assertions.assertEquals(0, creature.getMaxHP());
    }

    @Test
    public void heal_yourself_test() {
        Creature creature = new Player();
        creature.setMaxHP(50);
        creature.setHP(10);

        Assertions.assertTrue(creature.healYourself());
        Assertions.assertEquals(25, creature.getHP());
        Assertions.assertEquals(3, creature.getHealCount());

        Assertions.assertTrue(creature.healYourself());
        Assertions.assertEquals(40, creature.getHP());
        Assertions.assertEquals(2, creature.getHealCount());

        Assertions.assertTrue(creature.healYourself());
        Assertions.assertEquals(50, creature.getHP());
        Assertions.assertEquals(1, creature.getHealCount());

        Assertions.assertTrue(creature.healYourself());
        Assertions.assertEquals(50, creature.getHP());
        Assertions.assertEquals(0, creature.getHealCount());

        Assertions.assertFalse(creature.healYourself());
        Assertions.assertEquals(50, creature.getHP());
        Assertions.assertEquals(0, creature.getHealCount());
    }
}
