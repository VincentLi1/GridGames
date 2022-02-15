import java.awt.Color;
import java.util.ArrayList;

import javax.lang.model.type.NullType;

import info.gridworld.actor.Critter;

public class LonelyChameleon extends ChameleonCritter{

    public boolean isLonely = false;

    public LonelyChameleon(){

        //setColor(null);
    }

    // Darken if there are no other actors around it.
    public void darken(){
        if (getActors().size() == 0){ // Need to get this to get a null/empty list somehow. HW = 1 and 2. (also do 3)
            isLonely = true;

            double DARKENING_FACTOR = 0.05;
            
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
    
            setColor(new Color(red, green, blue));
        }
    }

    public boolean getIsLonely(){
        return isLonely;
    }

    // Act the same way that a ChameleonCritter does, except it also uses darken().
    public void act(){
        super.act();
        darken();
    }

}