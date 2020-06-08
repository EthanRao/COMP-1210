import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 *
 * Project 06
 * @author Xi Rao
 * @version 10/08/2018
 */
public class IcosahedronListMenuApp {
   /**
    * @param args - is not used.
    * @throws FileNotFoundException from scanning input file.
    */
   public static void main(String[] args) throws FileNotFoundException {
      String iListName = "*** no list name assigned ***";
      ArrayList<Icosahedron> myList = new ArrayList<Icosahedron>();
      IcosahedronList myIList = new IcosahedronList(iListName, myList);
      String fileName = "no file name";
      String labelIn = "";
      String colorIn = "";
      double edgeIn = 0;
      String code = "";
      Scanner scan = new Scanner(System.in);
      System.out.println("Icosahedron List System Menu\n"
                       + "R - Read File and Create Icosahedron List\n"
                       + "P - Print Icosahedron List\n"
                       + "S - Print Summary\n"
                       + "A - Add Icosahedron\n"
                       + "D - Delete Icosahedron\n"
                       + "F - Find Icosahedron\n"
                       + "E - Edit Icosahedron\n"
                       + "Q - Quit");
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch (codeChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
               myIList = myIList.readFile(fileName);
               System.out.println("\tFile read in and "
                              + "Icosahedron List created\n");
               break;                     
            case 'P':
               System.out.println(myIList);
               break;
            case 'S':
               System.out.println("\n" + myIList.summaryInfo() + "\n");
               break;    
            case 'A':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
               System.out.print("\tColor: ");
               colorIn = scan.nextLine();
               System.out.print("\tEdge: ");
               edgeIn = Double.parseDouble(scan.nextLine());
               myIList.addIcosahedron(labelIn, colorIn, edgeIn);
               System.out.println("\t*** Icosahedron added ***\n");
               break;
            case 'D':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine(); 
               if (myIList.deleteIcosahedron(labelIn) != null) {
                  myIList.deleteIcosahedron(labelIn);
                  System.out.println("\t\"" + labelIn + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + labelIn + "\" not found\n");
               }
               break;
            case 'F':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
               if (myIList.findIcosahedron(labelIn) == null) {
                  System.out.println("\t\"" + labelIn + "\" not found");
                  System.out.println("");
               }
               else {
                  System.out.println(myIList.findIcosahedron(labelIn).
                     toString());
                  System.out.println("");
               }
               break;
            case 'E':System.out.print("\tLabel: ");
               labelIn = scan.nextLine();       
               System.out.print("\tColor: ");
               colorIn = scan.nextLine();               
               System.out.print("\tEdge: ");
               edgeIn = Double.parseDouble(scan.nextLine());
               if (myIList.findIcosahedron(labelIn) == null) {
                  System.out.println("\t\"" + labelIn + "\" not found");
                  System.out.println("");
               }
               else {
                  myIList.editIcosahedron(labelIn, colorIn, edgeIn);
                  System.out.println("\t\""
                     + labelIn + "\" successfully edited");
                  System.out.println("");
               }
               break;
            case 'Q':
               break;
            default:
               System.out.println("\t*** invalid code ***");
               System.out.println("");
         }
      }
      while (!code.equalsIgnoreCase("Q"));      
   }
}