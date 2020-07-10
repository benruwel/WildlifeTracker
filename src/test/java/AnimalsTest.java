import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {

    public Animals setupObject() {
        return new Animals("Elephant");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animals_instantiatesCorrectly_true() {
        assertEquals(true, setupObject() instanceof Animals);
    }
    @Test
    public void getName_animalsInstantiatesWithName_Elephant() {
        assertEquals("Elephant", setupObject().getName());
    }
    @Test
    public void equals_returnsTrueIfNameIsSame_true() {
        Animals firstAnimal = new Animals("Elephant");
        Animals anotherAnimal = new Animals("Elephant");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Person() {
        setupObject().save();
        assertTrue(Animals.all().get(0).equals(setupObject()));
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animals firstAnimal = new Animals("Elephant");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Rhinos");
        secondAnimal.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimal));
        assertEquals(true, Animals.all().get(1).equals(secondAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        Animals testAnimal = new Animals("Elephant");
        testAnimal.save();
        Animals savedAnimal = Animals.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
    @Test
    public void find_returnsAnimalWithSameId_secondPerson() {
        Animals firstAnimal = new Animals("Elephant");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Rhinos");
        secondAnimal.save();
        assertEquals(Animals.find(secondAnimal.getId()), secondAnimal);
    }
}