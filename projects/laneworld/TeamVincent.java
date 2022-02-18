/**
 * TeamVincent consists of 5 Lions
 */

import info.gridworld.grid.Location;

public class TeamVincent extends Team {
    
    public TeamVincent(boolean isLeft){
        super(isLeft);
        int direction = isLeft ? Location.EAST : Location.WEST;
        for (int i = 1; i <= 5; i++){
            addPet(new Lion(i, direction, this));
          }

    }
}
