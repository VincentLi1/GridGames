/**
 * Bee has 2 HP and 3 Atk/
 * It deals damage to opponent when it takes damage
 */

public class Bee extends Pet {
    
    private int damageAmount;
    private int stingAmount;

    public Bee(){
        super("Bee",2,3);
    }

    @Override 
    // Careful! If two bees fight, then they'll just continue doing damage to each other
    // indefinitely
    public void changeHp(int dHp) {
        super.changeHp(dHp);
        if (dHp < 0){
            getOpponent().changeHp(-stingAmount);
        }
        
    }
}
