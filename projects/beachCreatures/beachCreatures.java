import info.gridworld.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Rock;

public class beachCreatures { 
    public static void main(String[] args){

        BoundedGrid grid = new BoundedGrid<>(10, 10);
        ActorWorld world = new ActorWorld(grid);
        
        // world.add(new LonelyChameleon());
        // world.add(new NearsightedChameleon());
        // world.add(new Rock());
        // world.add(new TownCrier(3));
        // world.add(new AngryCrab());
        world.add(new RockMason());
        world.add(new RockHound());

        world.show();
    }    
}
