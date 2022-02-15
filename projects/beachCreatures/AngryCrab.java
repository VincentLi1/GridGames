/**
 * `AngryCrab` extends `CrabCritter` and causes all 
 * adjacent `Actor`s to move one step further away 
 * from the `AngryCrab`. If the actor cannot move away, 
 * the `AngryCrab` removes it from the grid. Once `AngryCrab` 
 * has completed processing the actors, it moves like a 
 * `CrabCritter`.
 */

import java.util.*;
import info.gridworld.grid.Location;

import info.gridworld.actor.Actor;

public class AngryCrab extends CrabCritter {
    // Resuse the superclass constructor

    // We'll have to override getActors() for CrabCritter (to use the Critter method instead). 

    @Override
    public ArrayList<Actor> getActors() {
        return getGrid().getNeighbors(getLocation());
    }

    @Override // Based on the method the Brandon shared in class
    public void processActors(ArrayList<Actor> actors) {
        Location l = getLocation();
        int x = l.getRow(), y = l.getCol();
        
        // Check the direction that a can move
        for (Actor a : actors){
            Location actorLoc = a.getLocation();
            int dx = actorLoc.getRow() - l.getRow(), dy = actorLoc.getCol() - l.getCol();
            Location newLoc = new Location(x + dx, y + dy); 
            if (getGrid().isValid(newLoc)){
                a.moveTo(newLoc);
            }
            else{
                a.removeSelfFromGrid();
            }

        } // newLoc is where the actor moves. If it can't move there (not isValid(newLoc)), 
          //then a.removeSelfFromGrid().
    }
}
