package fr.xebia.xke.solid.ocp;

public class App {

    public static void main( String[] args ) {
        Hoover hoover = new Hoover("ADAAAGADA");
        hoover.clean();
        System.out.println("Final position is [" + hoover.getPosition().x + ", " + hoover.getPosition().y + "]");
    }
}
