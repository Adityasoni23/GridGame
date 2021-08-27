Game of Grid

RULES:
Imagine an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, live or dead. Every cell interacts with its eight neighbors, which are the cells that are directly horizontally, vertically, or diagonally adjacent. 
At each step in time (tick), the following transitions occur: 
1. Any live cell with fewer than two live neighbors dies, as if by loneliness. 
2. Any live cell with more than three live neighbors dies, as if by overcrowding. 
3. Any live cell with two or three live neighbors lives, unchanged, to the next generation. 
4. Any dead cell with exactly three live neighbors comes to life. 

BASIC GUIDELINES:
1.	Accept a user input of new cells (max 100 at every step/tick) to be placed; each cell should have a unique name which is to be accepted by the user. This input can be accepted through a CLI or HTML element or any other form of user interface
2.	 Acceptance of the user input represents a tick and the program is expected to calculate the state of every cell 
3.	The program should output the state of the cells and changes - representation (UI/CLI et al.) of the state of the cells can be decided by the developer 
4.	The program should provide a way to search by the name of the cell and show the current state of the cell 
5.	The program should end on termination through appropriate OS specific signals.

IDE USED: VScode
LANGUAGE USED: Java
DESIGN: Object Oriented
USER INTERFACE: VScode Console

BUILDING AND RUNNING INSTRUCTIONS:
1.	Basic requirements include VScode,Java extensions,GCC/or any other compiler.
2.	Build the project first from the options.
3.	Click Run Java.
4.	Provide the basic inputs to the compiler.
5.	Final output is shown.

ADDITIONAL FEATURES:
1.	Dynamic Input from the User.
2.	Asks for no. of ticks and runs for those many times.Thus no chance to land into an infinite loop.
3.	Clean Code with comments.
4.	Clean Output.
5.	Searching for the state of a cell by providing the position.
6.	The program shows the output of the state of the cells and the changes.
