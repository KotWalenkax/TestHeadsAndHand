package creature;

public class Player extends Creature {

    @Override
    public void getHitVoice() {
        System.out.println("Player hit the Monster!");
    }

    @Override
    public void getHealingVoice() {
        System.out.println("Player healed!");
        System.out.println("Heal potions left: " + this.getHealCount());
    }

    @Override
    public void getMissVoice() {
        System.out.println("Player missed!");
    }

    @Override
    public String toString() {
        return "Player";
    }
}
