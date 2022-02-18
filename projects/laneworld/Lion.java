/**
 * Construct a Lion with 3 HP and 5 attack.
 * The special ability of the Lion is to increase
 * its attack (from 5 to 7) after it takes damage 
 * (i.e.) if its health is less than 3
 */


public class Lion extends Pet {
    
    public Lion(int id, int direction, Team team) {
        super(id, "Lion", 5, 3, direction, team);
    }

    public void doAbility() {
        if (this.getHp() < 3){
            this.attack = 7;
        }
    }
}