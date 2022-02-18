import info.gridworld.grid.Location;

/**
 * Team Lee consists of 3 Pandas, 2 RedPandas.
 */

public class TeamBrandon extends Team {

  public TeamBrandon(boolean isLeft) {
    super(isLeft);
    int direction = isLeft ? Location.EAST : Location.WEST;
    for (int i = 0; i < 3; i++){
      addPet(new Panda(i, direction, this));
    }
    for (int i = 0; i < 2; i++){
      addPet(new RedPanda(i, direction, this));
    }
  }
  
}
