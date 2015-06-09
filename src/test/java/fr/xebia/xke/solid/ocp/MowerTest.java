package fr.xebia.xke.solid.ocp;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class MowerTest {

    @Test public void
    should_mow() {
        Mower mower = new Mower("ADAAAGADA");

        mower.mow();

        assertEquals(4, mower.getPosition().x);
        assertEquals(2, mower.getPosition().y);
    }

}
