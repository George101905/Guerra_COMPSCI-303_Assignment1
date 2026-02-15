import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr1 = loadArray();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do { 
            try {
                menu();
                choice = scanner.nextInt();
                switch (choice) {
                    // Search for Array
                    case 0:
                        System.out.println();
                        System.out.println("----- Current Array -----");
                        printArray(arr1);
                        System.out.println();
                        break;
                    case 1:
                        System.out.println();
                        try {
                            System.out.print("Please enter the number you are looking for: ");
                            choice = scanner.nextInt();
                            searchElement(choice, arr1);
                        } catch (Exception e) {
                            System.out.println();
                            System.out.println("Error: Invalid entry.");
                            System.out.println("Returning to menu...");
                            System.out.println();
                        }
                        scanner.nextLine();
                        break;
                    // Update Array
                    case 2:
                        System.out.println();
                        try{
                            System.out.print("Please enter the index you wish to update: ");
                            int index = scanner.nextInt();
                            System.out.print("\nPlease enter the value you'd like to put at this index: ");
                            int update = scanner.nextInt();
                            System.out.println();
                            updateElement(index,update,arr1);
                            System.out.println("----- Updated Array -----");

                            printArray(arr1);
                        } catch (Exception e){
                            System.out.println();
                            System.out.println("Error: Invalid entry.");
                            System.out.println("Returning to menu...");
                            System.out.println();
                        }
                        System.out.println();
                        scanner.nextLine();
                        break;
                    // Add Number to End
                    case 3:
                        System.out.println();
                        try{
                            System.out.print("Please enter the number you wish to add: ");
                            int element = scanner.nextInt();
                            System.out.println();
                            arr1 = addToEnd(element, arr1);
                            System.out.println("----- Updated Array -----");
                            printArray(arr1);
                        } catch (Exception e){
                            System.out.println();
                            System.out.println("Error: Invalid entry.");
                            System.out.println("Returning to menu...");
                            System.out.println();
                        }
                        System.out.println();
                        scanner.nextLine();
                        break;
                    // Delete from Array
                    case 4:
                        System.out.println();
                        try{
                            System.out.print("Please enter the index you wish to delete: ");
                            int index = scanner.nextInt();
                            System.out.println();
                            arr1 = deleteElement(index, arr1);
                            System.out.println("----- Updated Array -----");
                            printArray(arr1);
                        } catch (Exception e){
                            System.out.println();
                            System.out.println("Error: Invalid entry.");
                            System.out.println("Returning to menu...");
                            System.out.println();
                        }
                        System.out.println();
                        scanner.nextLine();
                        break;
                    // Exit
                    case 5:
                        System.out.println();
                        System.out.println("----- Final Array -----");
                        printArray(arr1);
                        System.out.println("Ending program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine();
                choice = 0;
            }
            catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 5);
        scanner.close();

    }
    // This function prints the options for manipulating the array
    public static void menu(){
        System.out.println("----- Array Menu -----");
        System.out.println("0) Print Array");
        System.out.println("1) Search for Array");
        System.out.println("2) Update Array");
        System.out.println("3) Add Number to End");
        System.out.println("4) Delete from Array");
        System.out.println("5) Exit");
        System.out.print("Enter your choice: ");
    }

    //Reads the information from the input file and puts the values into an array
    public static int[] loadArray(){
        int[] inputArray = new int[100];
        try{
            Scanner inputFile = new Scanner(new File("A1input.txt"));
            
            for(int i = 0; i < inputArray.length; i++){
                inputArray[i] = inputFile.nextInt();
            }
            inputFile.close();
    
        } catch(Exception e){
            System.out.println("Error loading array - " + e.getMessage());
        }
        return inputArray;
    }
    // Searches the array for an element and prints it's index if found
    public static void searchElement(int search, int[] array){
        System.out.println();
        int indexFound = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == search){
                indexFound = i;
                break;
            }
        }
        if (indexFound == -1){
            System.out.println("The element " + search + " was not found in the array.");
        } else {
            System.out.println("The element " + search + " was found at index " + indexFound);
        }
        System.out.println();
    }
    // Updates the element at the given index of the array
    public static void updateElement(int index, int update, int[] array){
        System.out.println();
        System.out.println("Element replaced: " + array[index]);
        System.out.println("New element: " + update);
        System.out.println();
        array[index] = update;
    }
    // Adds given element to the end of the array
    public static int[] addToEnd(int element, int[] array){
        int[] updated = new int[array.length + 1];
        for(int i = 0; i < array.length; i++){
            updated[i] = array[i];
        }
        updated[updated.length - 1] = element;
        return updated;
    }
    // Deletes the element at the given index of the array
    public static int[] deleteElement(int index, int[] array){
        if(index < 0 || index >= array.length) {
            System.out.println("Invalid index.");
            return array;
        }
        int[] updated = new int[array.length - 1];
        int deleted = array[index];
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if (i != index){
                updated[j] = array[i];
                j++;
            }
        }
        System.out.println("Element removed from array: " + deleted);
        return updated;
    }
    // Prints out a formated array
    public static void printArray(int[] array){
        int beforeLast = array.length - 1;
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            if(i == beforeLast) {System.out.print(array[i]);}
            else {System.out.print(array[i] + ", ");}
        } 
        System.out.println("]");
    }
}
