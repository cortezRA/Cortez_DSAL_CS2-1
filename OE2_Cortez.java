import java.util.Scanner;
import java.util.Arrays;

public class OE2_Cortez {
    
    static void bubbleSort(int[] array) {
        int ctr = array.length;
        int temp_array = 0;
        
        for(int x = 0; x < ctr; x++) {            
            for(int y = 1; y < (ctr-x); y++) {
                if(array[y-1] > array[y]) {   
                    System.out.println();
                    System.out.println("-- Elements " + array[y-1] + " and " + array[y] + " have been swapped --"); 
                    //swap
                    temp_array = array[y-1];
                    array[y-1] = array[y];
                    array[y] = temp_array;
                    System.out.println("Current Array Element Assorment: " + Arrays.toString(array));
                }
            }
        }
    }

    static void insertionSort(int array[]) {
        int ctr = array.length;

        for (int x = 1; x < ctr; x++) {

            int k = array[x]; //value to insert
            int y = x - 1; //hole position
            int chance = 0;

            while (y > -1 && array[y] > k) {

                if (chance == 0) { 
                    System.out.println();
                    System.out.println("-- " + array[y+1] + " moved to the left, " + array[y] + " moved to the right --");
                }
                else if (chance > 0) {
                    System.out.println();
                    System.out.println("--  \t *\t  , " + array[y] + " moved to the right --");
                }

                array[y+1] = array[y];
                y--;
                chance++;
            }

            array[y+1] = k;
            if (chance != 0) {
                System.out.println();
                System.out.println("Array Assortment via Insertion Sort: " + Arrays.toString(array));
            }
        }
    }


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int operation, size = 0;
        
        System.out.println ();
        System.out.println ("-- PLEASE CREATE YOUR ARRAY --");
        System.out.println ("Enter desired Array Size: ");
        size = in.nextInt();

        int user_array[] = new int[size];

        System.out.println ();
        for (int element = 0; element < size; element++) {
            System.out.println ();
            System.out.println ("Enter Array Element " + (element+1) + ": ");
            user_array[element] = in.nextInt();
        }

        System.out.println ();
        System.out.println ("-- YOU HAVE SUCCESSFULLY CREATED YOUR ARRAY --");

        int exit = 0;
        while (exit == 0) {

            System.out.println ();
            System.out.println ("-- Welcome to Array Sorting Program --");
            System.out.println ();
            System.out.println ("Current Array List: ");
            System.out.println (Arrays.toString(user_array));
            System.out.println ();
            System.out.println ("How would you like to sort your array?");
            System.out.println ("[1] - Bubble Sort");
            System.out.println ("[2] - Insertion Sort");
            System.out.println ("[3] - Exit Program");
            System.out.println ();
            operation = in.nextInt();

            switch(operation) {
                case 1: {
                    System.out.println();
                    System.out.println("Unsorted Array: ");
                    System.out.println (Arrays.toString(user_array));

                    bubbleSort(user_array);
                    System.out.println();
                    System.out.println("Sorted Array after Bubble Sort: ");
                    System.out.println (Arrays.toString(user_array));
                    break;
                }
                case 2: {
                    System.out.println();
                    System.out.println("Unsorted Array: ");
                    System.out.println (Arrays.toString(user_array));

                    insertionSort(user_array);
                    System.out.println();
                    System.out.println("Sorted Array after Insertion Sort: ");
                    System.out.println (Arrays.toString(user_array));
                    break;
                }
                case 3: {
                    exit = 1;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}