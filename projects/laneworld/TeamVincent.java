/**
 * TeamVincent consists of 3 Lions, 1 Beaver, and 1 Bluebird 
 */

import info.gridworld.grid.Location;

public class TeamVincent extends Team {
    
    public TeamVincent(boolean isLeft){
        super(isLeft);
        int direction = isLeft ? Location.EAST : Location.WEST;
        for (int i = 1; i <= 3; i++){
            addPet(new Lion(i, direction, this));
          }
          for (int i = 4; i < 4; i++){
            addPet(new Beaver(i, direction, this));
          }
          for (int i = 5; i <= 5; i++){
            addPet(new Bluebird(i, direction, this));
          }
    }
}
