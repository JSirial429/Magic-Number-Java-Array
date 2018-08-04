import java.util.Scanner;

//Name: Jorge Sirias
//Class: COP 3337 Programing II
//Professor: Greg Shaw
//Section: U07
//Date: 10/9/17
//
//I affirm that this program is entirely my own work and none of it is the work of any other person.
//  _Jorge Siras__________________
//	(your signature)


public class MagicSquareTester 
{

  public static void main(String [] args)
  {
      
      System.out.print("Hello user and welcome to the Magic Square.\n"
                       + "I will ask you for a positive odd integer that I will use"
                       + " to create a square!\n");
      
      boolean isOddPositive = false; 
      boolean isItMagical;
              
      Scanner intInput = new Scanner(System.in);
      
      /**
       * While loop that asks the user for positive integer values. Otherwise it keeps looping.
       */
      while((!isOddPositive))
      {
          
          System.out.print("Please pick a number that is odd and positive for the number of rows.\n");
          int numRowsAndColumns = intInput.nextInt(); //Int variable that stores the value given by the user
          
            if(numRowsAndColumns > 0)
            {
                
                int isPositive = (numRowsAndColumns - 1)%2; // Computation to determine whether given value by the user is odd
              
                    if(isPositive == 0)
                    {
                        
                        isOddPositive = true;
                        
                        //Creating a new object of the Magic Square class
                        MagicSquare newSquare = new MagicSquare(numRowsAndColumns);
                        isItMagical = newSquare.isSquareMagic();//*******Create Magic Square object here and call upon the isSquareMagic() Method*************8
                    
                        if(isItMagical)
                        {
                            
                            newSquare.toString();
                            System.out.println("This square is magical!");
                            
                        }
                        else
                        {
                            newSquare.toString();
                            System.out.println("This square is not magical.");
                            
                        }
                    
                    }
                    else if(isPositive != 0)
                    {
              
                        System.out.println(numRowsAndColumns + " is not an odd integer.");
              
                    }
            
            }//End of outer if statement
            else if(numRowsAndColumns < 0)
            {
                
                System.out.println(numRowsAndColumns + " is not a positive integer.\n Please choose again.");
                
            }
            
      }//End of while loop
      
  }
    
    
}
