//Name: Jorge Sirias
//Class: COP 3337 Programing II
//Professor: Greg Shaw
//Section: U07
//Date: 10/9/17
//
//I affirm that this program is entirely my own work and none of it is the work of any other person.
//  _Jorge Siras__________________
//	(your signature)


public class MagicSquare 
{
    
    int [][] magicSquare;
    //int column; ******MIGHT DELETE IF UNNECESSARY********
    //int rows;    ******MIGHT DELETE IF UNNECESSARY********
    boolean squareIsMagic = false;
    
    //Maybe create another MagicSqaure with no parameters or argumnets to pass
    //This will be used within the main MagicSquare class constructer with parameters and arguments
    public MagicSquare(int rowsAndColumns)
    {
        
        //int userAssignedRows = rows;          ******MIGHT DELETE IF UNNECESSARY********
        //int userAssignedColumns = columns;     ******MIGHT DELETE IF UNNECESSARY********
        //Creating a new square of N by N 
        magicSquare = new int [rowsAndColumns][rowsAndColumns];
        
        
        this.populateMagicSquare(rowsAndColumns);//call method here to populate magic square
        
    }
    
    /**
     * Populates a magic square by making a copy of  a magic square and doubling 
     * its size. When a a value occupies a space in the original 2d array the copy of it 
     * also makes note of that position in its own array and fills boolean values to indicate 
     * it is occupied. This helps to establish out of bounds area which are not found in the original 2D array.
     * @param columnsAndRows integer that will be used to make copy of the original square but doubled. 
     */
    private void populateMagicSquare(int columnsAndRows)
    {
        //Makes a copy of a magic square that is double the size 
        boolean magicSquareCopy [][] = new boolean [columnsAndRows + 2][columnsAndRows + 2];
        
        int nextRow = 0;
        int nextColumn = 0;
        
        //loop that fills a magic square copy with false values
        for(int i = 0; i < magicSquareCopy.length; i++)
        {
            for(int j = 0; j < magicSquareCopy[0].length; j++)
            {
                
                 magicSquareCopy[i][j] = false;
                
            }
            
        }
        
        //loop to fill in an N by N square from 1 to N squared
        for(int i = 1; i <= Math.pow(3,2); i++)
        {
            // The first number is always placed at the bottom row and middle column
            if(i == 1)
         {
             
             int startingColumn = magicSquare[0].length / 2;
             int startingRow = magicSquare.length - 1;
         
             magicSquare[startingRow][startingColumn] = i;
             magicSquareCopy[startingRow][startingColumn] = true;
             
             nextRow = startingRow + 1;
             nextColumn = startingColumn + 1;
             
         
         }
         
         else if( i != 1)
         {
            
            //Non-Existent Row
            if((!magicSquareCopy[nextRow + 1][nextColumn + 1]) && (nextRow > magicSquare.length - 1 ) && (nextColumn <= magicSquare[0].length - 1))
            {
                nextRow = 0;
             
                magicSquare[nextRow][nextColumn] = i;
                magicSquareCopy[nextRow + 1][nextColumn + 1] = true;
             
                nextRow = nextRow = 1; 
                nextColumn = nextColumn + 1;
            }
         
            //Non existent column
            else if((!magicSquareCopy[nextRow + 1][nextColumn + 1]) && (nextRow <= magicSquare.length - 1) && (nextColumn >= magicSquare[0].length - 1))
            {
             
                nextColumn = 0;
             
                magicSquare[nextRow][nextColumn] = i;
                magicSquareCopy[nextRow + 1][nextColumn + 1] = true;
         
                nextRow = nextRow + 1;
                nextColumn = nextColumn +1;
             
            }
         
            //Still within the board but position is occupied
            else if( (!(!magicSquareCopy[nextRow + 1][nextColumn + 1])) && (nextRow <= magicSquare.length) && (nextColumn <= magicSquare[0].length))
            {
             
                nextRow = nextRow - 2;
                nextColumn = nextColumn - 1;
             
                magicSquare[nextRow][nextColumn] = i;
                magicSquareCopy[nextRow + 1][nextColumn + 1] = true;
             
                nextRow = nextRow + 1;
                nextColumn = nextColumn +1;
            }
         
            //If non-existent row and column
            else if((nextRow > magicSquare.length - 1) && (nextColumn > magicSquare[0].length -1))
            {
             
                nextRow = nextRow -2;
                nextColumn = nextColumn -1;
             
                magicSquare[nextRow][nextColumn] = i;
                magicSquareCopy[nextRow + 1][nextColumn + 1] = true;
         
                nextRow = nextRow + 1;
                nextColumn = nextColumn + 1;
            }
         
            //Position is empty and on the board
            else if((!magicSquareCopy[nextRow + 1][nextColumn + 1]) && (nextRow <= magicSquare.length - 1) && (nextColumn <= magicSquare[0].length - 1))
            {
             
                magicSquare[nextRow][nextColumn] = i;
                magicSquareCopy[nextRow + 1][nextColumn + 1] = true;
             
                nextRow = nextRow +1;
                nextColumn = nextColumn + 1;
             
             
            }
         
         
         }// end of else if( i != 1 ) statement 
        
        }// end of for loop
        
    } //End of populateMagicSquare() method
    
    public boolean isSquareMagic()
    {
        
        int totalRowsAndColumnsSum = 0; //
        int totalDiagonalSum1 = 0;  //
        int totalDiagonalSum2 = 0;  //
        
        //For loop used to traverse the array and summing the values in each position of the magic square.
        //This is the same method used to collect the sum of each value row-by-row and column-by-column. 
        //This is especially prevalent and true in a N by N square. 
        for(int i = 0; i < magicSquare.length; i++)
        {
            for(int j = 0; j < magicSquare[0].length; j++)
            {
                
                int sum = 0;
                totalRowsAndColumnsSum = totalRowsAndColumnsSum + sum;
                
            }
        
        }
        
        //Dividing the sum from the previous for loop by N.
        //The value represents the sum for each row and column for any N by N square
        totalRowsAndColumnsSum = totalRowsAndColumnsSum/magicSquare.length;
        
        //Collects sum diagonally for a N by N square from top left corner to bottom right corner.
        for(int i = 0; i<magicSquare.length; i++)
        {
            
            int j = 0;
            while(j < magicSquare[0].length)
            {
                
                int sum = magicSquare[i][j];
                totalDiagonalSum1 = totalDiagonalSum1 + sum;
            
                i++;
                j++;
                
            }
            
            
        }
        
        //Collects sum diagonally for a N by N square from bottom right corner to top left corner. 
        for(int i = magicSquare.length - 1; i >= 0; i--)
        {
            
            int j = 0;
            while(j < magicSquare[0].length)
            {
                
                int sum = magicSquare[i][j];
                totalDiagonalSum2 = totalDiagonalSum2 + sum;
                
                i--;
                j++;
                
            }
            
        }
        
        //If statement to verify if sums are equal for diagonal and columns and rows.
        //If evaluation is true then sets boolean variable to true otherwise it keeps its default value of false.
        if((totalRowsAndColumnsSum == totalDiagonalSum1) && (totalDiagonalSum1 == totalDiagonalSum2))
        {
            
            squareIsMagic = true;
            
        }
        
        
        return squareIsMagic;
    
    }//End of isSquareMagic() Method
    
    //Prints to the console the representation of an N by N square
    public String toString()
    {
        
        for(int i = 0; i < magicSquare.length; i++)
        {
            int count = 0;
            for(int j = 0; j < magicSquare[0].length; j++)
            {
                
                System.out.print(magicSquare[i][j] + " ");
                
                if(count == 2)
                {
                    
                    System.out.println("");
                    
                }
                
                count ++;
                
            }
            
        }
        
       return null;
        
    }
    
}//End of public MagicSquare class
