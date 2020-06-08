import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/** Test class for IcosahedronList2. **/
public class IcosahedronList2Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test of getters. **/
   @Test public void gettersTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium", "orange", 12.3);
      dArray[2] = new Icosahedron("Large", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("getName Test", "Test List", dList.getName());
      Assert.assertArrayEquals("getList test", dArray, dList.getList());
   }
   
   /** A test of numberOfIcosahedrons(). **/
   @Test public void numberOfIcosahedronsTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("numberOfIcosahedrons Test", 
                           3, dList.numberOfIcosahedrons());
   }
   
   /** A test of totalSurfaceArea(). **/
   @Test public void totalSurfaceAreaTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium", "orange", 12.3);
      dArray[2] = new Icosahedron("Large", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("totalSurfaceArea Test", 
                           133184.74867, dList.totalSurfaceArea(), .001);
   }
   
   /** A test of totalVolume(). **/
   @Test public void totalVolumeTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium", "orange", 12.3);
      dArray[2] = new Icosahedron("Large", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("totalVolume Test", 
                           4103641.24, dList.totalVolume(), .001);
   }
   
   /** A test of averageSurfaceArea(). **/
   @Test public void averageSurfaceAreaTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium", "orange", 12.3);
      dArray[2] = new Icosahedron("Large", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("averageSurfaceArea Test", 
                           44394.91622, dList.averageSurfaceArea(), .001);
   }
   
   /** A test of averageVolume(). **/
   @Test public void averageVolumeTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("averageVolume Test", 
                           1367880.41315, dList.averageVolume(), .001);
   }
   
   /** A test of averageSurfaceToVolumeRatio(). **/
   @Test public void averageSurfaceToVolumeRatioTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("averageSurfaceToVolumeRatio Test", 
                           132.4352049, 
                           dList.averageSurfaceToVolumeRatio(), .001);
   }
   
   /** A test of toString(). **/
   @Test public void toStringTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("toString Test", 
                           false, 
                           dList.toString().
                              contains("Icosahedron \"Small \""));
   }
   
   /** A test of summaryInfo(). **/
   @Test public void summaryInfoTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("summaryInfo Test", 
                           true, 
                           dList.summaryInfo().
                              contains("Number of Icosahedrons: 3"));
   }
   
   /** A test of readFile().
    * @throws IOException for reading a file.
    */
   @Test public void readFileTest() throws IOException {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      dList = dList.readFile("icosahedron_data_1.txt");
      Assert.assertEquals("readFile Test", "Icosahedron Test List", 
                           dList.getName());
   }
   
   /** A test of addIcosahedron(). **/
   @Test public void addIcosahedronTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Icosahedron d = new Icosahedron("Humongous", "black", 1000);
      dList.addIcosahedron("Humongous", "black", 1000);
      Icosahedron[] dA = dList.getList();
      Assert.assertEquals("addIcosahedron Test", d, dA[3]);
   }
   
   /** A test of findIcosahedron(). **/
   @Test public void findIcosahedronTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("findIcosahedron Test", dArray[0], 
                           dList.findIcosahedron("small"));
   }
   
   /** A test of findIcosahedron() when false. **/
   @Test public void findIcosahedronFalseTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("findIcosahedron Test", null, 
                           dList.findIcosahedron("nope"));
   }

   /** A test of deleteIcosahedron(). **/
   @Test public void deleteIcosahedronTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      dList.deleteIcosahedron("small");
      Assert.assertEquals("deleteIcosahedron Test", dArray[2], dArray[2]);
   }
   
    /** A test of deleteIcosahedron() when false. **/
   @Test public void deleteIcosahedronFalseTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      dList.deleteIcosahedron("nope");
      Assert.assertEquals("deleteIcosahedron Test", dArray[2], dArray[2]);
   }
   
   /** A test of editIcosahedron(). **/
   @Test public void editIcosahedronTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      dList.editIcosahedron("small", "gold", 0.21);
      Assert.assertEquals("editIcosahedron Test", "gold", 
                           dArray[0].getColor());
   }
   
   /** A test of editIcosahedron() when false. **/
   @Test public void editIcosahedronFalseTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      dList.editIcosahedron("nope", "gold", 0.21);
      Assert.assertEquals("editIcosahedron Test", "blue", 
                           dArray[0].getColor());
   }

   /** A test of findIcosahedronWithShortestEdge(). **/
   @Test public void findIcosahedronWithShortestEdgeTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("findIcosahedronWithShortestEdge Test", 
                           dArray[0], 
                           dList.findIcosahedronWithShortestEdge());
   }
   
   /** A test of findIcosahedronWithShortestEdge() when false. **/
   @Test public void findIcosahedronWithShortestEdgeFalseTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 0);
      Assert.assertEquals("findIcosahedronWithShortestEdge Test", 
                           null, 
                           dList.findIcosahedronWithShortestEdge());
   }

   /** A test of findIcosahedronWithLongestEdge(). **/
   @Test public void findIcosahedronWithLongestEdgeTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("findIcosahedronWithlongestEdge Test", 
                           dArray[2], 
                           dList.findIcosahedronWithLongestEdge());
   }
   
   /** A test of findIcosahedronWithLongestEdge() when false. **/
   @Test public void findIcosahedronWithLongestEdgeFalseTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 0);
      Assert.assertEquals("findIcosahedronWithlongestEdge Test", 
                           null, 
                           dList.findIcosahedronWithLongestEdge());
   }

   /** A test of findIcosahedronWithSmallestVolume(). **/
   @Test public void findIcosahedronWithSmallestVolumeTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("findIcosahedronWithSmallestVolume Test", 
                           dArray[0], 
                           dList.findIcosahedronWithSmallestVolume());
   }
   
   /** A test of findIcosahedronWithSmallestVolume() when false. **/
   @Test public void findIcosahedronWithSmallestVolumeFalseTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small ", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium ", "orange", 12.3);
      dArray[2] = new Icosahedron("Large ", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 0);
      Assert.assertEquals("findIcosahedronWithSmallestVolume Test", 
                           null, 
                           dList.findIcosahedronWithSmallestVolume());
   }

   /** A test of findIcosahedronWithLargestVolume(). **/
   @Test public void findIcosahedronWithLargestVolumeTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium", "orange", 12.3);
      dArray[2] = new Icosahedron("Large", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 3);
      Assert.assertEquals("findIcosahedronWithLargestVolume Test", 
                           dArray[2], 
                           dList.findIcosahedronWithLargestVolume());
   }
   
   /** A test of findIcosahedronWithLargestVolume() when false. **/
   @Test public void findIcosahedronWithLargestVolumeFalseTest() {
      Icosahedron[] dArray = new Icosahedron[20];
      dArray[0] = new Icosahedron("Small", "blue",  0.01);
      dArray[1] = new Icosahedron("Medium", "orange", 12.3);
      dArray[2] = new Icosahedron("Large", "silver", 123.4);
      IcosahedronList2 dList = new IcosahedronList2("Test List", dArray, 0);
      Assert.assertEquals("findIcosahedronWithLargestVolume Test", 
                           null, 
                           dList.findIcosahedronWithLargestVolume());
   }
}
