import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



/** Test class for Icosahedron. **/
public class IcosahedronTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /** A test of getters. **/
   @Test public void gettersTest() {
      Icosahedron i = new Icosahedron("Small", "blue", 0.01);
      Assert.assertEquals("Small", i.getLabel());
      Assert.assertEquals("blue", i.getColor());
      Assert.assertEquals(0.01, i.getEdge(), 0.01);
   }
   
   /** A test of setters. **/
   @Test public void settersTest() {
      Icosahedron i = new Icosahedron("Small", "blue", 0.01);
      i.setLabel("Small");
      i.setColor("blue");
      i.setEdge(0.01);
      Assert.assertEquals("Small", i.getLabel());
      Assert.assertEquals("blue", i.getColor());
      Assert.assertEquals(0.01, i.getEdge(), 0.01);
   }
   
   /** A test of setters when false. **/
   @Test public void settersFalseTest() {
      Icosahedron i = new Icosahedron(null, null, -1);
      i.setLabel(null);
      i.setColor(null);
      i.setEdge(-1);
      Assert.assertEquals("", i.getLabel());
      Assert.assertEquals("", i.getColor());
      Assert.assertEquals(0.0, i.getEdge(), 0.01);
   }
   
   /** A test of surface area. **/
   @Test public void areaTest() {
      Icosahedron i = new Icosahedron("Small", "blue", 0.01);
      Assert.assertEquals(0.000866, i.surfaceArea(), 0.01);
   }
   
   /** A test of volume. **/
   @Test public void volumeTest() {
      Icosahedron i = new Icosahedron("Small Example", "blue", 0.01);
      Assert.assertEquals(0.000002, i.volume(), 0.01);
   }
   
   /** A test of surface to volume ratio. **/
   @Test public void ratioTest() {
      Icosahedron i = new Icosahedron("Small", "blue", 0.01);
      Assert.assertEquals(396.950, i.surfaceToVolumeRatio(), 0.001);
   }
   
   /** A test of resetCount() and getCount(). **/
   @Test public void countTest() {
      Icosahedron i = new Icosahedron("Small", "blue", 0.01);
      i.resetCount();
      Icosahedron i1 = new Icosahedron("Small", "blue", 0.01);
      Assert.assertEquals(1, i1.getCount());
   }
   
   /** A test of hashCode(). **/
   @Test public void hashCodeTest() {
      Icosahedron i = new Icosahedron("Small", "blue", 0.01);
      Assert.assertEquals(0, i.hashCode());
   }
   
   /** A test of equals(). **/
   @Test public void equalsTest() {
      Icosahedron i1 = new Icosahedron("Small", "blue", 0.01);
      Icosahedron i2 = new Icosahedron("Small", "blue", 0.01);
      Assert.assertEquals("equals test", true, i1.equals(i2));
      i2 = new Icosahedron("Example", "blue", 0.01);
      Assert.assertEquals("equals false test", false, i1.equals(i2));
      i2 = new Icosahedron("Small", "grey", 0.01);
      Assert.assertEquals("equals false test", false, i1.equals(i2));
      i2 = new Icosahedron("Small", "blue", 0.15);
      Assert.assertEquals("equals false test", false, i1.equals(i2));
      
      Assert.assertEquals("equals false test", false, i1.equals("obj"));
      Assert.assertEquals("equals false test", false, i1.equals("obj"));
      Assert.assertEquals("equals false test", false, i1.equals("obj"));
      
      Assert.assertEquals("equals false test", 0, i1.hashCode());
   }
   
   /** A test of toString(). **/
   @Test public void toStringTest() {
      Icosahedron i = new Icosahedron("Small", "blue", 0.01);
      Assert.assertEquals("toString test", true,
         i.toString().contains("Icosahedron \"Small\""));
   }
}
