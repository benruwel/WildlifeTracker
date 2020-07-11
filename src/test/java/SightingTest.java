import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    public Sighting setupObject() {
        return new Sighting(1, "Pembeni", "Douglas Onzima");
    }
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true() {
        assertEquals(true, setupObject() instanceof Sighting);
    }
    @Test
    public void getAnimalId_sightingInstantiatesWithAnimalId_int() {
        assertEquals(1, setupObject().getAnimalId());
    }
    @Test
    public void getLocation_sightingInstantiatesWithLocation_string() {
        assertEquals("Pembeni", setupObject().getLocation());
    }
    @Test
    public void getRangerName_sightingInstantiatesWithRangerName_string() {
        assertEquals("Douglas Onzima", setupObject().getRangerName());
    }
    

}