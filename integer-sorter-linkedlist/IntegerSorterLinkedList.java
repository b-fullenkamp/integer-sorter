import java.util.LinkedList;
import java.util.Scanner;

/** A program that reads a list of integers from user input, sorts them in ascending order,
 * and displays the sorted list.
 * <p>
 * This implementation uses the {@code LinkedList} class from the Java Collections Framework.
 *
 * @author Ben Fullenkamp
 * @version 1.0.0
 * @since 1.0.0
 */
public class IntegerSorterLinkedList {

    /** Private constructor to suppress it from the Javadoc documentation
     * as this class is not meant to be instantiated.
     *
     * @since 1.0.0
     */
    private IntegerSorterLinkedList() {}

    /** Parses a string of integers separated by spaces and/commas,
     * stores them in a LinkedList, and sorts the list.
     *
     * @param userInput a string containing integers separated by spaces and/or commas
     * @return a {@code LinkedList<Integer>} sorted in ascending order
     * @since 1.0.0
     */
    public static LinkedList<Integer> parseAndSortInput(String userInput) {
        // Splits the input by any combination of commas and/or spaces to allow for input flexibility
        String[] userInputSplit = userInput.split("\\s*,+\\s*|\\s+");

        // Stores the integers after parsing into a LinkedList data structures
        LinkedList<Integer> integerList = new LinkedList<Integer>();

        // Add error handling for non-integers by skipping them and printing an error
        for (String num : userInputSplit) {
            try {
                integerList.add(Integer.valueOf(num));
            } catch (NumberFormatException e) {
                System.err.println("Invalid input: '" + num + "' is not an integer. Skipping.");
            }
        }

        // Sort method from List interface
        integerList.sort(null);

        return integerList;
    }

    /** Prompts the user for a list of integers and prints the sorted list to the
     *  console after calling {@code parseAndSortInput}
     *
     * @param args command line arguments (not used)
     * @since 1.0.0
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a list of integers separated by commas: ");

        // Convert the user input into a LinkedList holding integers
        LinkedList<Integer> integerList = parseAndSortInput(scan.nextLine());

        // Display the sorted List
        if (integerList.isEmpty()) {
            System.out.println("No valid integers were provided.");
        } else {
            System.out.print("Sorted List: " + integerList);
        }
    }

}
