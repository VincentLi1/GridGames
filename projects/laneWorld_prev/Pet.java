// Tomorrow: go over snail/slug (battling)

// The class is abstract, so we can't actually make a generic pet. It allows us to 
// make pets with methods that are undefined.
import info.gridworld.actor.Actor;


public abstract class Pet extends Actor {
    
    // Fields
    protected int hp;
    protected int atk;
    protected int position; // 1 = left, 5 = right.
    protected String name;
    protected boolean isDead;
    protected Pet opponent;

    // Constructor
    public Pet(String name, int hp, int atk){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.isDead = false;
    }

    // We need ways to get and change each field in a way that's "balanced" (i.e. heal() instead of setHp())
    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.hp <= 0){
            this.isDead = true;
        }
    }
    
    public int getAtk(){
        return this.atk;
    }
    
    public int getHp(){
        return hp;
    }

    public Pet getOpponent(){
        return opponent;
    }

    // Override if different pets heal differently.
    public void heal(int healAmount){
        this.hp += healAmount; 
    }

    // public int getDef(){
    //     return def;
    // }
    
    public int calculateDamage(Pet opponent){
        return atk;
    }

    public void changeHp(int dHp){
        hp += dHp;
        if (dHp > 0){
            // heal ability
        }
    }

    public void battle(Pet opponent){
        this.opponent = opponent;
        int damage = opponent.calculateDamage(this);
        this.changeHp(-damage);
        // doAbility();
    }

    // public Pet findTarget(){
    //     return  ; // add more later. 
    // }

    public void attack(Pet target){
        this.opponent = target;
        target.changeHp(-target.getAtk());
    }

    public void die(){
        this.removeSelfFromGrid();
    }

    public String toString(){
        return String.format("Name: %s\tHP: %d Attack: \t%d",name,hp,atk);
    }

    // Using the ability. It's abstract, so it's not generically defined.
    // abstract void doAbility();

    public void act(){
        // add more
        
        // Let's use battle() instead
        // attack(findTarget());
        if (this.isDead){
            die();
        }
    }
}
