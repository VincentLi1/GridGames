/**
 * `RockMason` will try to spawn up to 2 `Rock`s 
 * in an empty adjacent location. If it is surrounded, 
 * then it will dig underground and emerge at a random
 * unoccupied location in the world. If there are no 
 * unoccupied locations, then it will sit and wait until
 * there is one. `RockMason` cannot build and move in
 * the same turn.
 */

/** 
 * Summary pseudocode: 
 * if not surrounded:
 *      spawn_2_rocks(). Do not move.
 * else if there are unoccupied locations: 
 *      dig underground, emerge at random location
 * else: 
 *      sit and wait until there's an unoccupied location
 */

import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;

public class RockMason extends Critter {
    
    // Use the same constructor as the superclass.
    public RockMason(){
        setColor(null);
    }

    // We will check if the RockMason is surrounded by looking at each of the neighboring tiles.
    // If it is surrounded, then there will be 0 valid empty adjacent locations.
    // This will automatically only get the valid locations.
    public boolean checkIsSurrounded(){
        return (getGrid().getEmptyAdjacentLocations(getLocation()).size() == 0);
    }

    // Process the actors by choosing the neighboring locations without actors
    // to place rocks in. Place up to 2 rocks in the empty locations.
    @Override
    public void processActors(ArrayList<Actor> actors) {
        // Get an ArrayList<> of the empty neighboring/adjacent locations
        ArrayList<Location> emptyLocs = getGrid().getEmptyAdjacentLocations(getLocation());
        // Note that getEmptyAdjacentLocations() will only return the VALID adjacent locations.
        if (emptyLocs.size() == 1 || emptyLocs.size() == 2){
            // If there are 1 or 2 empty locations, 
            // then fill them with rocks.
            for (Location emptyLoc : emptyLocs){
                // Put a rock in the empty location.
                Rock r = new Rock();
                r.putSelfInGrid(getGrid(),emptyLoc);
            }
        }
        // Otherwise, there are more than 2 empty locations. 
        // We will have to randomly choose 2 in which to put the rocks.
        else{
            // Shuffle the ArrayList of empty locations and then pick the first two
            // to put the rocks into.
            Collections.shuffle(emptyLocs); 
            Location loc0 = emptyLocs.get(0), loc1 = emptyLocs.get(1);
            Rock r0 = new Rock();
            Rock r1 = new Rock();
            r0.putSelfInGrid(getGrid(),loc0);
            r1.putSelfInGrid(getGrid(),loc1);
            }
        }
        
        // Get all of the unoccupied locations in the grid. This is a slight
        // modification from getOccupiedLocations() in Grid.
        @Override
        public ArrayList<Location> getMoveLocations() {

            ArrayList<Location> theLocations = new ArrayList<Location>();
    
            // Look at all grid locations.
            for (int r = 0; r < getGrid().getNumRows(); r++)
            {
                for (int c = 0; c < getGrid().getNumCols(); c++)
                {
                    // If there's no object at this location, put it in the array.
                    Location loc = new Location(r, c);
                    if (getGrid().get(loc) == null)
                        theLocations.add(loc);
                }
            }
            return theLocations;
        }

        @Override
        public void act()
        {
            if (getGrid() == null)
                return;
            ArrayList<Actor> actors = getActors();
            // If it is not surrounded, then make up to 2 rocks.
            if (!checkIsSurrounded()){
                processActors(actors);
            }
            // Otherwise, make a move. 
            // makeMove() will not move if there are not available places to 
            // move in.
            else{
                ArrayList<Location> moveLocs = getMoveLocations();
                Location loc = selectMoveLocation(moveLocs);
                makeMove(loc);
            }
            
        }  
    }
    
    




