package fr.xebia.xke.solid.ocp;

public class App {

    public static void main( String[] args ) {
        Mower mower = new Mower("ADAAAGADA");
        mower.mow();
        System.out.println("Final position is [" + mower.getPosition().x + ", " + mower.getPosition().y + "]");
    }
}
