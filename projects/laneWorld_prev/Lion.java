/**
 * Construct a Lion with 3 HP and 8 atk.
 * The special ability of the Lion is to increase
 * its atk (from 8 to 12) after it takes damage 
 * (i.e.) if its health is less than 3
 */

public class Lion extends Pet {
    
    public Lion(){
        super("Lion",3,8);
    }

    public void doAbility(){
        if (getHp() < 3){
            atk = 12;
        }
    }
}
