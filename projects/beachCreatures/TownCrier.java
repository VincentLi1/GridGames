import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

import java.awt.Color;
import java.util.*;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

/**
 * `TownCrier` extends `Critter` and thrives off attention. 
 * It looks at all neighbors within 2 tiles away and counts 
 * the number of `Critters`. If that number is greater than 
 * some threshold @param t , it will turn green. Otherwise, it will
 *  turn red. `t` is a parameter in the constructor. _Hint:_ 
 * use its `Location` to find all Critters in its range. Use 
 * `instanceof` to check if an actor is a `Critter`.
 */

public class TownCrier extends Critter {
    
    public int t;
    public int numCritters;

    // Construct a TownCrier with a given threshold.
    public TownCrier(int threshold){
        t = threshold;
    }

    // It looks at all neighbors within 2 tiles away; we must override getActors().
    @Override
    public ArrayList<Actor> getActors() {
        numCritters = -1; // Start at -1 because we have to subtract 1 for the TownCrier itself
        ArrayList<Actor> actors = new ArrayList<Actor>();

        int[] nums = {-2,-1,0,1,2};
        for (int x : nums){
            for (int y : nums){
                // we need to add in the x and y. 
                Location loc = getLocation();
                int row = loc.getRow(), col = loc.getCol();
                Location newLoc = new Location(row + x, col + y);
                if (getGrid().isValid(newLoc)){
                    Actor actor = getGrid().get(newLoc);
                    if (actor instanceof Critter){
                        numCritters++;
                        actors.add(actor);
                    }
                }
            } 
        }
        return actors; 

    } 

    // Override processActors() so that it will change colors if numCritters > t.
    @Override
    public void processActors(ArrayList<Actor> actors){
        if (numCritters > t){
            setColor(Color.GREEN);
        }
        else{setColor(Color.RED);}
    }
    }
    

