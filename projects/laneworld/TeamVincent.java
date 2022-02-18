/**
 * TeamVincent consists of 5 Lions
 */

import info.gridworld.grid.Location;

public class TeamVincent extends Team {
    
    public TeamVincent(boolean isLeft){
        super(isLeft);
        int direction = isLeft ? Location.EAST : Location.WEST;
        for (int i = 0; i <= 4; i++){
            addPet(new Lion(i, direction, this));
          }
          

    }
}
