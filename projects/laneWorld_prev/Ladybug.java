/**
 * Construct a Ladybug that has 6 HP
 * and 3 atk. The special ability is to
 * take 1/2 damage every other turn
 * (starting with the first turn)
 */

public class Ladybug extends Pet{
    
    // Keep track of the turn number so that we can see which turns it should
    // take 1/2 damage for
    private int turnNum = 0;

    public Ladybug(){
        super("Ladybug",6,3);
    }

    // We will take 1/2 damage by healing an amount equal to 1/2 the opponent's attack.
    public void doAbility(){
        if (turnNum%2 == 0){
            heal(getOpponent().getAtk()/2);
        }
        turnNum ++;
    }
}
