import java.util.ArrayList;

/**
 * Hedgehog is a 3/2 pet
 * Faint: Deal 2 damage to all
 */
public class Hedgehog extends Pet {

  public Hedgehog(int id, String name, int attack, int hp, int direction, Team team){
    super(id, "Hedgehog", 3, 2, direction, team);
  }
  
  public void onFaint(Team opponents) {
      ArrayList<Pet> Enemies = opponents.getPets();
      for(Pet Enemy : Enemies){
        Enemy.changeHp(-2);
      }
  }

}
