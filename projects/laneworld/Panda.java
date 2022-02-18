/**
 * Panda is a 2/5 pet
 * it  heals 50% of the damage it receives
 */
public class Panda extends Pet {
  
    public Panda(int id, int direction, Team team) {
      super(id, "Panda", 2, 5, direction, team);
    }

    public void onHurt(int dmg) { // called when the panda is hurt, so it can heal
        int healAmt = dmg / 2;
        changeHp(healAmt);

        LaneWorldLogger.log(String.format("Panda heals +%d.", healAmt));
    }
}