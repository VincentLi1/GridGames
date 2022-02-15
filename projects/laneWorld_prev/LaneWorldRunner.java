// import info.projects.laneWorld.Lion;
// import projects.laneWorld.Ladybug;


public class LaneWorldRunner {
    
    public static void main(String[] args){
        // Pet lion = new Lion();
        // Pet ladybug = new Ladybug();

        // System.out.println(lion);
        // System.out.println(ladybug);

        // lion.attack(ladybug);
        // ladybug.attack(lion);

        // System.out.println(lion);
        // System.out.println(ladybug);

        Pet snail = new Snail();
        Pet bee = new Bee();

        System.out.println(snail);
        System.out.println(bee);

        bee.attack(snail);
        snail.attack(bee);

        System.out.println(snail);
        System.out.println(bee);
    }
}

/**
 * Side effect = a variable changes in the middle of the code
 * Flip side: functional programming
 * Functional programming doesn't have side effects 
 * (working only with constants)
 * 
 * Ex: Haskell, ML, Lisp (finance, data analytics; need to know if a number changes)
 *  More for mathy fields
 * Python, Scala, JavaScript
 * Java, C++
 *  Game development
 * 
 * It's difficult to work in different styles of languages. 
 */