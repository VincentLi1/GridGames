/**
 * `RockHound` loves to eat `Rock`s (i.e. removes rocks from the world), 
 * and can reach any rock that is adjcaent to it. If it cannot reach a 
 * rock, it will turn toward a rock in the world and move in that direction. 
 * If there are no rocks in the world, then it will sit and wait until there
 * is one. `RockHound` cannot eat and move in the same turn.
 */

/**
 * Summary pseudocode:
 * 
 * Override getActors():
 *      Get adjacent rocks
 * 
 * Override processActors():
 *      Eat an adjacent rock
 * 
 * Override getMoveLocations():
 *      Get the move locations that are adjacent to the current location in the direction
 *      of all of the rocks
 * 
 * Override act():
 *      if there are adjacent rocks:
 *          processActors()
 *      else if there are rocks on the grid:
 *          getMoveLocations()
 *          makeMove()
 *      else 
 *          do nothing
 */

import java.util.*;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class RockHound extends Critter { 
    
    public RockHound(){
        setColor(null); // I don't like blue RockHounds
    }

    // Get the neighboring locations that are those with rocks
    @Override
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = getGrid().getNeighbors(getLocation());
        ArrayList<Actor> rocks = new ArrayList<>();
        for (Actor a: actors){
            if (a instanceof Rock){
                rocks.add(a);
            }
        }
        return rocks;
    }

    // Eat a random adjacent rock.
    // We assume that there are >= 1 adjacent rocks to the RockHound.
    // This condition is taken care of in act().
    @Override
    public void processActors(ArrayList<Actor> rocks) {
        Random rand = new Random();
        int rockIndex = rand.nextInt(rocks.size());
        
        Actor rock = rocks.get(rockIndex); // And we also know that rock is a Rock
        rock.removeSelfFromGrid();
    }

    // Return an ArrayList of all of the adjacent locations that move the 
    // RockHound closer to a rock.
    @Override
    public ArrayList<Location> getMoveLocations() {
        // allRocks is an ArrayList containing the locations of 
        // all of the rocks on the grid
        ArrayList<Location> allActors = getGrid().getOccupiedLocations(); 
        ArrayList<Location> allRocks = new ArrayList<>();
        ArrayList<Location> moveLocs = new ArrayList<>();
        for (Location l : allActors){
            // If the actor at that location is a Rock 
            if (getGrid().get(l) instanceof Rock){
                allRocks.add(l);
             }
        }
        for (Location rockLoc : allRocks){
            // Specify the change in position due to moving towards the rock
            int dx, dy;
            // The coordinates of the current position
            int row = getLocation().getRow(), col = getLocation().getCol();
            // The coordinates of the rock
            int rockRow = rockLoc.getRow(), rockCol = rockLoc.getCol();
            // This gets the sign of the direction to move in, so that it will move correctly
            dx = (int) java.lang.Math.signum(rockRow - row);
            dy = (int) java.lang.Math.signum(rockCol - col);
            Location newLoc = new Location(row + dx, col + dy);
            moveLocs.add(newLoc);
        }
        return moveLocs;
    }

    // Check whether a given ArrayList<Location> contains at least one location with a rock
    public boolean checkRock(ArrayList<Location> locs){
        boolean hasRock = false;
        for (Location loc : locs){
            if (getGrid().get(loc) instanceof Rock){
                hasRock = true;
            }
        }
        return hasRock;
    }

    // Act. (see summary pseudocode for act())
    @Override
    public void act() {
        ArrayList<Location> neighbors = getGrid().getOccupiedAdjacentLocations(getLocation());
        ArrayList<Location> actorLocs = getGrid().getOccupiedLocations(); // The occupied locations
        if (checkRock(neighbors)){
            processActors(getActors());
        }
        else if (checkRock(actorLocs)){
            // Make a move (i.e. move towards a random rock)
            makeMove(selectMoveLocation(getMoveLocations()));
        }
        else{
            // do nothing
        }
    }
}
