import java.lang.Math;

/**
 * Panda is a 2/5 pet
 * it heals 50% of the damage it receives
 * and this healing percentage increases each time (by 5%)
 * caps at 100% healing
 */

public class Panda extends Pet {

    private double healing_percentage = 0.5;

    public Panda(int id, int direction, Team team) {
      super(id, "Panda", 10, 30, direction, team);
    }

    public void onHurt(int dmg) { // called when the panda is hurt, so it can heal
        int healAmt = (int) (dmg * healing_percentage);
        changeHp(healAmt);
        healing_percentage += 0.05; // increase the healing factor
        healing_percentage = Math.max(healing_percentage,1.0); // cap at 100%

        LaneWorldLogger.log(String.format("Panda heals +%d.", healAmt));
    }
}