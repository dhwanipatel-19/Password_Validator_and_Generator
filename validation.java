import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class validation {
    private String password ;
    public String validate()
    { 
        Scanner input = new Scanner(System.in);
        System.out.println("Enter password to validate: ");
        password = input.next();
        int n = password.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                          '*', '(', ')', '-', '+'));
        for (char i : password.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }
       
        // Strength of password
        System.out.print("Strength of password:- ");
        if (hasDigit && hasLower && hasUpper && specialChar
            && (n >= 8))
            return " Strong";
        else if ((hasLower || hasUpper || specialChar)
                 && (n >= 6))
            return " Moderate";
        else
            return " Weak";
    }
} 

class generation extends validation
{
    public void generatestrng(int length)
    {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];
  
        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));
     
        for(int i = 4; i< length ; i++) {
           password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
           
        }
        System.out.println("Suggested password: ");
        System.out.println(password);
    }

    public void generatemed(int length)
    {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters;
        Random random = new Random();
        char[] password = new char[length];
  
        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
     
        for(int i = 3; i< length ; i++) {
           password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
           
        }
        System.out.println("Suggested password: ");
        System.out.println(password);
    }

    public void generateweak(int length)
    {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String combinedChars =  lowerCaseLetters + specialCharacters;
        Random random = new Random();
        char[] password = new char[length];
  
        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
     
        for(int i = 2; i< length ; i++) {
           password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
           
        }
        System.out.println("Suggested password: ");
        System.out.println(password);
    }


    public static void main(String[] args) {
       validation v= new validation();
       generation g= new generation();
       char ask = 'y';
       while(ask =='y')
       {
             System.out.println("Enter 1 to Validate.");
            System.out.println("Enter 2 to Generate."); 
            System.out.println("Enter 3 for criteria.");
            System.out.println("Enter 4 to Exit.");
            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch(choice) {
                    case 1:
                    {
                  
                      /*  System.out.println("1.Validate the Password.");
                        System.out.println("2.Exit.");
                        System.out.println("Enter your choice: ");
                        int ch = input.nextInt();
                    
                        switch(ch) {
                            case 1:
                            { */
                                char ans = 'y';
                                while(ans=='y')
                                {
                                     String level = new String();
                                    level= v.validate();
                                    System.out.println("Your password is" + level);
                                    System.out.println("Want to check more passwords? ");
                                    ans =input.next().charAt(0);
                                }
                                //break;
                         /*   }
                            case 2:
                                 break;
                        } */
                    
                        break; 

                    }

                    case 2:
                    {
                        char ans = 'y';
                        while(ans == 'y')
                        {
                            System.out.println("1.Generate a Weak password.");
                            System.out.println("2.Generate a Normal password.");
                            System.out.println("3.Generate a Strong password.");
                            System.out.println("4.Exit.");
                            System.out.println("Enter your choice: ");
                            int c = input.nextInt();

                            switch(c) {
                                case 1: 
                                {
                                    System.out.println("How long your password should be?: ");
                                    int length = input.nextInt();
                                    if (length <= 6)
                                        g.generatemed(length);
                                    else
                                        System.out.println("Weak passwords have less than 6 characters.");
                                
                                    break;  
                                }
                                case 2:
                                {
                                    System.out.println("How long your password should be?: ");
                                    int length = input.nextInt();
                                    if (length >= 6)
                                        g.generatemed(length);
                                    else
                                        System.out.println("Normal passwords must have atleast 6 characters.");
                                
                                    break;   

                                }
                                case 3:
                                {
                                    System.out.println("How long your password should be?: ");
                                    int length = input.nextInt();
                                    if (length >= 8)
                                        g.generatestrng(length);
                                    else
                                        System.out.println("Strong passwords must have more than 8 characters.");
                                
                                    break;
                                }
                                case 4:
                                {
                                    break;
                                }
                            }

                            System.out.println("Want to generate more password(y or n): ");
                            ans = input.next().charAt(0);
                        }
                        break;
                    }

                    case 3:
                    {
                        System.out.println("We are going to check the strength of a password that a user enters based on the following rules:");
                        System.out.println("- The password is at least 8 characters long.");
                        System.out.println("- The password has at least one uppercase letter.");
                        System.out.println("- The password has at least one lowercase letter.");
                        System.out.println("- The password has at least one digit.");
                        System.out.println("- The password has at least one special character.\n");

                        System.out.println("We are going to have three levels to denote how secure a password is. They are:");
                        System.out.println("Strong: The password has to meet all the requirements.");
                        System.out.println("Medium: If the password is at least six characters long and meets all the other requirements, or has no digit but meets the rest of the requirements.");
                        System.out.println("Weak: If the password entered does not meet the strong or medium-level requirements, then it is deemed weak.");
                    }

                    case 4:
                    {
                        break;
                    }
                }
            
            System.out.println("Want to spend more time?(y or n): ");
                ask = input.next().charAt(0);
        }
    }        
}
