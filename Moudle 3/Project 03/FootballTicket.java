import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Will read game ticket data and then interpret 
 * and print the formatted ticket information.
 *
 * @author Xi Rao
 * @version 9/12/2016
 */
public class FootballTicket 
{
   static final double STUDENT_DISCOUNT = .67;
   static final double FACULTY_DISCOUNT = .20;
   /**
    * Main Method.
    * @param args (not used)
    */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      DecimalFormat fmt = new DecimalFormat("$##0.00"); 
      DecimalFormat fmt2 = new DecimalFormat("0000000"); 
      System.out.print("Enter your ticket code: ");
      String ticket = userInput.nextLine().trim();
      
      if (ticket.length() < 25) { // invalid ticket
         System.out.println("\nInvalid Ticket Code." 
                    + "\nTicket code must have at least 25 characters.");
      }
      
      else {
      
      // Price
         String value = ticket.substring(1, 6);
         double price = Double.parseDouble(value) / 100;
         char category = ticket.charAt(0);
         double cost = 0;
      
         if (category == 's') { // student discount
            cost = price - (price * STUDENT_DISCOUNT);
         }
         
         else if (category == 'f') { // faculty discount
            cost = price - (price * FACULTY_DISCOUNT);
         }
         
         else {
            cost = price; // no discount
         }
      
      
      // Time
         String hour = ticket.substring(6, 8);
         String minute = ticket.substring(8, 10);
      
      // Date
         String month = ticket.substring(10, 12);
         String day = "/" + ticket.substring(12, 14) + "/";
         String year = ticket.substring(14, 18);
         String date = month + day + year;
      
      // Seating
         int seat = Integer.parseInt(ticket.substring(18, 20));
         int row = Integer.parseInt(ticket.substring(20, 22));
         int section = Integer.parseInt(ticket.substring(22, 24));
      
      // Game
         String game = ticket.substring(24, ticket.length());
         
      // Prize Number
         Random generator = new Random();
         int prize = generator.nextInt(9999999) + 1;
      
      // Output
         System.out.println("\nGame: " + game + "   Date: " + date 
                           +  "   Time: " + hour + ':' + minute);
                           
         System.out.println("Section: " + section + "   Row: " + row 
                           + "   Seat: " + seat);
         
         System.out.println("Price: " + fmt.format(price) 
                           + "   Category: " + category
                           + "   Cost: " + fmt.format(cost));
         
         System.out.println("Prize Number: " + fmt2.format(prize));
      }
   }
}