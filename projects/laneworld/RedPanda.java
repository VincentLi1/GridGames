import java.util.Random;

/**
 * Red Panda is a 5/6 pet
 * On Attack: 10% chance to instant kill enemy,
 * 30% chance eat bamboo - gain 4 health, 
 * 60% give random friend 3 hp
 */


public class RedPanda extends Pet {

    Random rand = new Random();
    private int x;
    private int instkill;
    private int bonusFriendHp;
    private int bonusSelfHp;
    
     public RedPanda(int id, int direction, Team team){
        super(id, "Red Panda", 2, 2, direction, team);
     }

     public void onAttack(Team opponents){
        opponent = opponents.getRandomPet(this);
        x = rand.nextInt(11);
        if (x >= 1 && x <= 6){
            Pet friend = team.getRandomPet(this);
            if (friend != null) {
                LaneWorldLogger.log(String.format("%s gains +%d.", friend, bonusFriendHp));
                friend.changeHp(bonusFriendHp);
        }else if (x >= 7 && x <=9){
            this.hp += 4;
        }else if (x == 10){
            instkill = opponent.getHp();
            opponent.take_Damage(instkill);
        }
     }
}
