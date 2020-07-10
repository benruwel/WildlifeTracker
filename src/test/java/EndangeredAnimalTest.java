import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    public EndangeredAnimal setupObject() {
        return new EndangeredAnimal("Elephant", "okay", "newborn");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        assertEquals(true, setupObject() instanceof Animal);
    }
    @Test
    public void getName_endangeredAnimalInstantiatesWithName_Elephant() {
        assertEquals("Elephant", setupObject().getName());
    }
    @Test
    public void getHealth_endangeredAnimalInstantiatesWithHealth_okay() {
        assertEquals("okay", setupObject().getHealth());
    }
    @Test
    public void getAge_endangeredAnimalInstantiatesWithAge_newborn() {
        assertEquals("newborn", setupObject().getAge());
    }
    @Test
    public void equals_returnsTrueIfNameIsSame_true() {
        Animal firstEndangeredAnimal = new EndangeredAnimal("Elephant", "okay", "newborn");
        Animal anotherEndangeredAnimal = new EndangeredAnimal("Elephant", "okay", "newborn");
        assertTrue(firstEndangeredAnimal.equals(anotherEndangeredAnimal));
    }
    @Test
    public void save_insertsObjectIntoDatabase_EndangeredAnimal() {
        setupObject().save();
        assertTrue(EndangeredAnimal.all().get(0).equals(setupObject()));
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        Animal firstEndangerdAnimal = new EndangeredAnimal("Elephant", "okay", "newborn");
        firstEndangerdAnimal.save();
        Animal secondEndangeredAnimal = new EndangeredAnimal("Elephant", "okay", "newborn");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangerdAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        Animal testEndangeredAnimal = new EndangeredAnimal("Elephant", "okay", "newborn");
        testEndangeredAnimal.save();
        Animal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }
    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        Animal firstEndangeredAnimal = new EndangeredAnimal("Elephant", "okay", "newborn");
        firstEndangeredAnimal.save();
        Animal secondEndangeredAnimal = new EndangeredAnimal("Elephant", "okay", "newborn");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }

    @Test
    public void endangeredAnimal_instantiatesWithEndangeredTrue_true() {
        EndangeredAnimal testEndangeredAnimal = setupObject();
        assertEquals(testEndangeredAnimal.isEndangered(), true);
    }
}