/**
* Perform calculations based on the input user information.
* based on the two coordinates output midpoint
*
/**
* @author Xi Rao
* @version 9/17/2018
*/
public class UserInfoDriver {
/**
* Allows the user to input two endpoints
* an output of midpoint,
* based off coordinate, prints to midpoint coordinate.
*
* @param args Command line arguments (not used)
*/

   public static void main(String[] args) {
     
      UserInfo user1 = new UserInfo("Pat", "Doe");
      System.out.println("\n" + user1);
      user1.setLocation("Auburn");
      user1.setAge(19);
      user1.logOn();
      System.out.println("\n" + user1);
      
      UserInfo user2 = new UserInfo("Sam", "Jones");
      System.out.println("\n" + user2);
      user2.setLocation("Atlanta");
      user2.setAge(21);
      user2.logOn();
      System.out.println("\n" + user2);
   }
}
