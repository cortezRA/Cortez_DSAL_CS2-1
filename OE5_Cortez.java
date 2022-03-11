import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OE5_Cortez {

     // Total number of elements to be sorted
     private static final int N = 10000;
 
     // Total number of sorting runs
     private static final int NUM = 10;

    public static void insertionSort2(int[] arr, int low, int n) {
        for(int i = low+1; i <= n;i++) {

            int value = arr[i];
            int j = i;

            while (j > low && arr[j-1] > value) {
                arr[j]= arr[j-1] ;
                j--;
            }
            arr[j]= value;
        }
    }

    public static int partition2(int[] a, int low, int high) {
        int pivot = a[high];
        int pIndex = low;
 
        for (int i = low; i < high; i++) {
            if(a[i] <= pivot) {
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                
                pIndex++;
            }
        }
   
        int temp = a[high];
        a[high] = a[pIndex];
        a[pIndex] = temp;
 
        return pIndex;
    }

    public static void quicksort2(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition2(a, low, high);
        quicksort2(a, low, pivot-1);
        quicksort2(a, pivot+1, high);
    }

    public static void optimizedQuicksort2(int[] A, int low, int high) {
        while (low < high) {
 
            // switch to insertion sort if the size is 10 or smaller
            if (high - low < 10) {
                insertionSort2(A, low, high);
                break;
            } else {
                int pivot = partition2(A, low, high) ;
 
                // tail call optimizations – recur on the smaller subarray
 
                if (pivot-low < high-pivot) {
                    optimizedQuicksort2(A, low, pivot - 1);
                    low = pivot + 1;
                } else {           
                    optimizedQuicksort2(A, pivot + 1, high);
                    high = pivot-1;
                }
            }
        }
    }

    //Calculate the random numbers between high and low
    static void Randomized1(int arr[], int low, int high){
        Random rand = new Random();
        int pivot = rand.nextInt(high-low)+low;
        
        int temp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;
    }

    static int partition1(int arr[], int low, int high) {
        //Randomly-selected Pivot value
        Randomized1(arr, low, high);
        int pivot = arr[high];

        int i = (low-1); //index of smaller element
        for(int j = low; j < high; j++) {
            //set condition
            if(arr[j] < pivot) {
                i++;
                //perform swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //With Reference to Pivot
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    //arr[] as array, low as starting index, high as ending index
    static void qsort1(int arr[], int low, int high) {
        if(low < high) {
            //p as partition index where pivot is at sorted position
            int p = partition1(arr, low, high);

            //Recursively sort elements partition after partition
            qsort1(arr, low, p-1);
            qsort1(arr, p+1, high);
        }
    }

    static void printResult1(int arr[]) {
        int n = arr.length;
        for(int x = 0; x < n; x++) {
            System.out.print(arr[x] + " ");
        }
    }

    static void printResult2(int arr[]) {
        for(int x = N-NUM; x < N; x++) {
            System.out.print(arr[x] + " ");
        }
    }

    public static void main(String[] args) {
        int operation = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n");
            System.out.println("Please choose type of Quicksort Data Structure desired: ");
            System.out.println("[1] - Random Quicksort");
            System.out.println("[2] - Hybrid Quicksort");
            System.out.println("\n");
            operation = in.nextInt();

            if (operation == 1) {
                int arr[] = {20,30,40,70,80,90,10,50,60};
                long begin1, end1;
                int n = arr.length;
                long t3 = 0;
                System.out.println("Unsorted Array: ");
                printResult1(arr);
                System.out.println("\n");
                
                begin1 = System.nanoTime();
                qsort1(arr, 0, n-1);
                end1 = System.nanoTime();
                t3 += (end1 - begin1);
    
                System.out.println("Sorted Array: ");
                printResult1(arr);

                System.out.println("\n");
                System.out.println("The average time taken by Random Quicksort: " + (t3/n) + " nanoseconds");

                t3 = 0;
            } else if (operation == 2) {
                long t1 = 0, t2 = 0;
                long begin, end, begin2, end2;

                Random value = new Random();
                int[] arr2 = new int[N]; int copydup[] = new int[N]; 
                for (int i = 0; i < NUM; i++) {
                    arr2[i] = value.nextInt(N);
                }

                // perform Quicksort NUM times and take an average
                for (int i = 0; i < NUM; i++) {
                    // generate random input
                    int[] dup = Arrays.copyOf(arr2, N);
 
                    // Perform non-optimized Quicksort on the array
 
                    begin = System.nanoTime();
                    quicksort2(arr2, 0, N-1);
                    end = System.nanoTime();
 
                    // calculate the time taken by non-optimized Quicksort
                    t1 += (end - begin);

                    // Perform optimized Quicksort on the duplicate array
                    begin2 = System.nanoTime();
                    optimizedQuicksort2(dup, 0, N-1);
                    end2 = System.nanoTime();
 
                    // calculate the time taken by optimized Quicksort
                    t2 += (end2 - begin2);
                    copydup[i+(N-NUM)] = dup[i+(N-NUM)];
                    
                }
                
                printResult2(arr2);
                System.out.println();
                System.out.println("The average time taken by the non-optimized Quicksort: " + (t1/NUM) + " nanoseconds");
                System.out.println("\n");
                
                printResult2(copydup);

                System.out.println();
                System.out.println("The average time taken by the optimized Quicksort: " + (t2/NUM) + " nanoseconds");
                t1 = 0; t2 = 0;
            } else if (operation == 3) {
                break;
            } else {
                System.out.println("-- WRONG INPUT --");
                System.out.println("You will be returned to the main menu...");
            }
        } while (operation != 3);
    }
}
