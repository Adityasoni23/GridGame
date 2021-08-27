package logic;

import java.util.Scanner;


public class logicGrid {
	 //initializing a dead cell
	 public final static int DEAD    = 0x00;

	 //initializing a live cell
	 public final static int LIVE    = 0x01;
	    
	 public void test(int iterations) {

	    	Scanner sc = new Scanner(System.in);
	    	
	    	//Dynamic input for the grid from the user
	    	
	    	System.out.println("Enter the number of input cells");
	    	
	    	System.out.println("Rows:");
	    	int rows=sc.nextInt();
	    	
	    	System.out.println("Columns:");
	    	int columns = sc.nextInt();
	    	
	    	//Accepting user input values for the cells in the grid
	    	System.out.println("\nEnter the values: 1 if alive 0 if dead");
	    	int[][] grid=new int[rows][columns];
	    	for(int i=0;i<rows;i++)
	    	{
	    		for(int j=0;j<columns;j++)
	    		{
	    			grid[i][j]=sc.nextInt();
	    		}
	    	}
	        
	        System.out.println("Game Begins");
	        printGrid(grid);

	        for (int i = 0 ; i < iterations ; i++) {
	            System.out.println();
	            grid = nextGrid(grid);
	            printGrid(grid);
	        }
	        
	        //Search the state of a cell by position
	        System.out.println("\nSearch using row and column no");
	        System.out.println("Row no:");
	        int search_row=sc.nextInt();
	        System.out.println("Column no:");
	        int search_column= sc.nextInt();
	        
	        System.out.println("\nState of the cell:"+grid[search_row-1][search_column-1]);
            sc.close();
	    }

	 
	    private void printGrid(int[][] board) {

	        for (int i = 0, e = board.length ; i < e ; i++) {

	            for (int j = 0, f = board[i].length ; j < f ; j++) {
	                System.out.print(Integer.toString(board[i][j]) + ",");
	            } 
	            System.out.println();
	        }
	    }

	    /*
	     * nextGrid will calculate if cells should live or die or new
	     * ones should be created.
	     */
	    public int[][] nextGrid(int[][] grid) {

	      
	        if (grid.length == 0 || grid[0].length == 0) {
	            throw new IllegalArgumentException("Grid should have a positive number of rows or columns");
	        }

	        int noRows = grid.length;
	        int noColumns = grid[0].length;

	     // temporary grid to store new states
	        int[][] tempGrid = new int[noRows][noColumns];

	        for (int gridrow = 0 ; gridrow < noRows ; gridrow++) {
		
	            for (int gridCol = 0 ; gridCol < noColumns ; gridCol++) {
	                tempGrid[gridrow][gridCol] = newCellState(grid[gridrow][gridCol], liveNeighbours(gridrow, gridCol, grid));
	            }
	        }   
	        return tempGrid;
	    }

	   //Function to get the number of live neighbors given the position of the cell
	    private int liveNeighbours(int cellr, int cellc, int[][] grid) {

	        int liveNeighbours = 0;
	        int endRow = Math.min(grid.length , cellr + 2);
	        int endCol = Math.min(grid[0].length, cellc + 2);

	        for (int row = Math.max(0, cellr - 1) ; row < endRow ; row++) {
	            
	            for (int col = Math.max(0, cellc - 1) ; col < endCol ; col++) {
	              
	                if ((row != cellr || col != cellc) && grid[row][col] == LIVE) {
	                    liveNeighbours++;
	                }
	            }
	        }
	        return liveNeighbours;
	    }


	    //get the new cell state by applying the conditions and the rules
	    private int newCellState(int currentState, int liveNeigbours) {

	        int newState = currentState;

	        switch (currentState) {
	        case DEAD:
	          
	            if (liveNeigbours == 3) {
	                newState = LIVE;
	            }
	            break;

	        case LIVE:

	        	//Any live cell with fewer than two live neighbors dies, as if by loneliness.
	            if (liveNeigbours < 2) {
	                newState = DEAD;
	            }

	            //Any live cell with two or three live neighbors lives, unchanged, to the next generation.
	            if (liveNeigbours == 2 || liveNeigbours == 3) {
	                newState = LIVE;
	            }

	            //Any live cell with more than three live neighbors dies, as if by overcrowding.
	            if (liveNeigbours > 3) {
	                newState = DEAD;
	            }
	            break;

	        
	        default:
	            throw new IllegalArgumentException("State should be either LIVE or DEAD");
	        }			
	        return newState;
	    }
	}


       
