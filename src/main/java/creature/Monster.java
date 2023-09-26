package creature;

public class Monster extends Creature {


    @Override
    public void getHitVoice() {
        System.out.println("Monster hit the Player!");
    }

    @Override
    public void getHealingVoice() {
        System.out.println("Monster healed!");
        System.out.println("Heal potions left: " + this.getHealCount());
    }

    @Override
    public void getMissVoice() {
        System.out.println("Monster missed!");
    }

    @Override
    public String toString() {
        return "Monster";
    }
}
