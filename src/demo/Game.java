package demo;

import java.util.Scanner;

import logic.logicGrid;

/* BASIC RULES
1. Any live cell with fewer than two live neighbors dies, as if by loneliness.
2. Any live cell with more than three live neighbors dies, as if by overcrowding.
3. Any live cell with two or three live neighbors lives, unchanged, to the next generation.
4. Any dead cell with exactly three live neighbors comes to life.
 */
public class Game {
   
    public final static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the no. of new ticks:");
        logicGrid logic=new logicGrid();
        
        int n=sc.nextInt();
        logic.test(n);
        
        sc.close();
    }
        
}
