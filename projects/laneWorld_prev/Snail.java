/**
 * Snail has 3 HP and 2 atk.
 * Ability: it heals 2 HP every time it attacks
 */

public class Snail extends Pet{
    
    private int healAmount = 2;

    public Snail(){
        super("Snail",3,2);
    }

    @Override // Attack its opponent normally and then use the ability of healing
    public void attack(Pet target) {
        super.attack(target);
        this.changeHp(healAmount);
    }
}
