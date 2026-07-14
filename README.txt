Java Console-Based Searching and Sorting Program
=================================================

Files (in src/):
- UserInterface.java     -> Main class. Displays the menu and handles user input.
- SearchAlgorithms.java  -> Linear Search and Binary Search.
- SortingAlgorithms.java -> Bubble, Selection, Insertion, Merge, and Quick Sort.

HOW TO COMPILE AND RUN
-----------------------
1. Open a terminal in the "src" folder.
2. Compile all files:
     javac *.java
3. Run the program:
     java UserInterface

USING THE PROGRAM
------------------
1. Choose "1" to search or "2" to sort (or "3" to exit).
2. Enter your list of integers separated by spaces, e.g.:
     5 3 8 1 9 2
3. For searching:
   - Choose Linear Search (works on the list as-is) or Binary Search
     (the program automatically sorts a copy of the list first, since
     Binary Search requires sorted data).
   - Enter the target value you want to find.
4. For sorting:
   - Choose one of the five algorithms.
   - The sorted list is printed to the screen.
5. The program loops back to the main menu after every operation and
   only exits when you choose option 3.

NOTES
-----
- Input validation is included: non-numeric menu choices are rejected
  and re-prompted; an empty list of numbers is also rejected.
- All sorting methods sort in ascending order, in place.
