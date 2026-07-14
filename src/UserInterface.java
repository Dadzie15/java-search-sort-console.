import java.util.Scanner;


public class UserInterface {

   
    private static Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) {

        
        boolean keepRunning = true;

        System.out.println("===========");
        System.out.println(" Welcome to the Search & Sort Program");
        System.out.println("=============");

        // MAIN LOOP: keeps repeating until the user chooses to exit
        while (keepRunning) {

            // Step 1: show the menu
            System.out.println("\nMain Menu:");
            System.out.println("1. Perform Searching");
            System.out.println("2. Perform Sorting");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            // Step 2: read what number the user typed
            int choice = readMenuNumber();

            // Step 3: decide what to do based on the choice
            if (choice == 1) {
                doSearching();
            } else if (choice == 2) {
                doSorting();
            } else if (choice == 3) {
                keepRunning = false; // this turns the switch off, so the loop stops
                System.out.println("Exiting program. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close(); // we are done listening, so we close the microphone
    }

    // ===========================================================
    // SEARCHING WORKFLOW
    // ===========================================================
   
    private static void doSearching() {

        int[] list = readListOfNumbers();

        System.out.println("\nChoose a search algorithm:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter your choice (1-2): ");
        int searchType = readMenuNumber();

        System.out.print("Enter the target value to search for: ");
        int target = readMenuNumber();

        if (searchType == 1) {
            // ---- LINEAR SEARCH ----
            
            int position = SearchAlgorithms.linearSearch(list, target);
            showSearchResult(target, position);

        } else if (searchType == 2) {
            // ---- BINARY SEARCH ----
           
            int[] sortedCopy = list.clone();
            SortingAlgorithms.quickSort(sortedCopy);

            System.out.println("List sorted for binary search: " + toText(sortedCopy));

            int position = SearchAlgorithms.binarySearch(sortedCopy, target);
            showSearchResult(target, position);

        } else {
            System.out.println("Invalid search choice.");
        }
    }

    // Prints a friendly message depending on whether the target was found
    private static void showSearchResult(int target, int position) {
        if (position == -1) {
            System.out.println("Result: " + target + " was NOT found in the list.");
        } else {
            System.out.println("Result: " + target + " was found at index " + position + ".");
        }
    }

    // ===========================================================
    // SORTING WORKFLOW
    // ===========================================================
   
    private static void doSorting() {

        int[] list = readListOfNumbers();

        System.out.println("\nChoose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.print("Enter your choice (1-5): ");
        int sortType = readMenuNumber();

       
        
        int[] result = list.clone();

        if (sortType == 1) {
            SortingAlgorithms.bubbleSort(result);
        } else if (sortType == 2) {
            SortingAlgorithms.selectionSort(result);
        } else if (sortType == 3) {
            SortingAlgorithms.insertionSort(result);
        } else if (sortType == 4) {
            SortingAlgorithms.mergeSort(result);
        } else if (sortType == 5) {
            SortingAlgorithms.quickSort(result);
        } else {
            System.out.println("Invalid sorting choice.");
            return; // stop here, nothing more to print
        }

        System.out.println("Sorted list: " + toText(result));
    }

    // ===========================================================
    // HELPER METHODS (small reusable tools used above)
    // ===========================================================

   
    private static int[] readListOfNumbers() {
    
        scanner.nextLine();

        while (true) { // keep looping until we get a valid list
            System.out.print("\nEnter a list of integers separated by spaces or commas (e.g. 5 3 8 1 or 5, 3, 8, 1): ");
            String line = scanner.nextLine().trim();

            // Keep asking again if the user typed nothing
            if (line.isEmpty()) {
                System.out.println("List cannot be empty. Please try again.");
                continue;
            }

            // Split the text at every space AND/OR comma.
            // "[\\s,]+" means "one or more spaces or commas in a row".
            // This turns "5 , 3 , 8, 1" into ["5","3","8","1"] correctly.
            String[] pieces = line.split("[\\s,]+");

            
            try {
                int[] numbers = new int[pieces.length];
                for (int i = 0; i < pieces.length; i++) {
                    numbers[i] = Integer.parseInt(pieces[i]);
                }
                return numbers; // success - hand the numbers back
            } catch (NumberFormatException e) {
                System.out.println("One of the values you entered is not a valid whole number. Please try again.");
                // loop repeats automatically since we're inside while(true)
            }
        }
    }

   
    private static int readMenuNumber() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next(); // throw away the bad input
        }
        return scanner.nextInt();
    }

    // Turns an array like [1, 3, 5, 8] into the text "[1, 3, 5, 8]" for printing
    private static String toText(int[] arr) {
        StringBuilder text = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            text.append(arr[i]);
            if (i < arr.length - 1) {
                text.append(", ");
            }
        }
        text.append("]");
        return text.toString();
    }
}
