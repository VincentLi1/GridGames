import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import info.gridworld.actor.Actor;
import java.util.ArrayList;


public class NearsightedChameleon extends LonelyChameleon{
    // The NearsightedChameleon is like a LonelyChameleon (changes colors when alone) 
    // except it also can only look directly in front/behind itself as it changes colors.
    // Therefore, we will override getActors() in the Critter superclass to only look in those directions.
    // Everything else remains the same.

    // Use the same constructor as the superclass.

    /** getLocationsInDirections() and the corresponding comment is copied from the CrabCritter code.
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }    

    // Override getActors() to look just in the directions directly in front and behind itself.
    public ArrayList<Actor> getActors(){
        // Location location = getLocation();
        int[] dirs =
            { Location.AHEAD, Location.HALF_CIRCLE };
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Location loc : getLocationsInDirections(dirs)){
            actors.add(getGrid().get(loc));
        }
        
        return actors; // return the directions that are directly in front and behind the chameleon
    } 
    
}
