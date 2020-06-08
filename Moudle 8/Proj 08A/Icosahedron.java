import java.text.DecimalFormat;
/**
 * Stores the label, color, and edge.
 * Project_08A
 * @author Xi Rao
 * @version 10/26/2018
 */
public class Icosahedron {
/**
 * Icosahedron.
 * @param args Commandline arguments - not usei.
 */
   private String label = "";
   private String color = "";
   private double edge = 0;
   private static int count = 0;
   /**
    * @param labelIn the input label.
    * @param colorIn the input color.
    * @param edgeIn the input edge.
    */
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
      count++;
   }
   /**
    * @param labelIn the label.
    * @return true if applied, otherwise false.
    */
   public boolean setLabel(String labelIn) {
      if (labelIn == null) {
         return false;
      }
      else {
         label = labelIn.trim();
         return true;
      }
   }
   /**
    * @param colorIn the color.
    * @return true if applied, otherwise false.
    */
   public boolean setColor(String colorIn) {
      if (colorIn == null) {
         return false;
      }
      else {
         color = colorIn.trim();
         return true;
      }
   }
   /**
    * @param edgeIn the edge.
    * @return true if appled, otherwise false.
    */   
   public boolean setEdge(double edgeIn) {
      if (edgeIn <= 0) {
         return false;
      }
      else {
         edge = edgeIn;
         return true;
      }
   }
   /**
    * @return label.
    */
   public String getLabel() {
      return label;
   }
   /**
    * @return color.
    */
   public String getColor() {
      return color;
   }
   /**
    * @return edge.
    */
   public double getEdge() {
      return edge;
   }
   /**
    * @return the value of the surface area.
    */
   public double surfaceArea() {
      return 5 * Math.sqrt(3) * Math.pow(edge, 2);
   }
   /**
   * @return returns the value of the volume for the doIcosahedron.
   */
   public double volume() {
      return 5 * ((3 + Math.sqrt(5)) / (12)) * Math.pow(edge, 3);
   }
   /**
    * @return the surface to volume ratio.
    */
   public double surfaceToVolumeRatio() {
      double surfaceToVolumeRatio = surfaceArea() / volume();
      return surfaceToVolumeRatio;
   }
   /**
    * @return the string.
    */
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0#####");
      return "Icosahedron \"" + label + "\" is \"" + color
         + "\" with 30 edges of length " + edge + " units.\n\t"
         + "surface area = " + fmt.format(surfaceArea()) + " square units\n\t"
         + "volume = " + fmt.format(volume()) + " cubic units\n\t"
         + "surface/volume ratio = " + fmt.format(surfaceToVolumeRatio());
   }
   /**
    * @return count.
    */
   public static int getCount() {
      return count;
   }
   /**
    * Reset the count.
    */
   public static void resetCount() {
      count = 0;
   }
   /**
    * @param obj the object.
    * @return true if it is a dodecahedron.
    */
   public boolean equals(Object obj) {
      if (!(obj instanceof Icosahedron)) { 
         return false;
      } 
      else {
         Icosahedron d = (Icosahedron) obj;
         return (label.equalsIgnoreCase(d.getLabel())
            && color.equalsIgnoreCase(d.getColor())
            && Math.abs(edge - d.getEdge()) < .000001);
      } 
   }      /**
    * @return hashCode.
    */
   public int hashCode() {
      int hash = 0;
      return hash;
   }
}