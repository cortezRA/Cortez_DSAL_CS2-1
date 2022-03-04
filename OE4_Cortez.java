import java.util.Scanner;

public class OE4_Cortez {
    
    //partition function
    int my_partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = (start-1);

        for(int j = start; j <= end; j++) {
            //if element arr[j] is less than(<) pivot
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return (i+1);
    }

    //quicksort function
    void my_quicksort(int arr[], int s, int e) {
        if(s <= e) {
            int p = my_partition(arr, s, e);
            my_quicksort(arr, s, p-1);
            my_quicksort(arr, p+1, e);
        }
    }

    //display function
    void displayArr(int arr[], int n) {
        for(int x = 0; x < n; x++) {
            if (x != n-1) {
                System.out.print(arr[x] + ", ");
            }
            else {
                System.out.print(arr[x]);
            }
        }
    }

    public static void main(String[] args) {
        int size;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter array size: ");
        size = in.nextInt();
        System.out.println();

        int arr[] = new int[size];
        
        for (int ctr = 0; ctr < size; ctr++) {
            System.out.println("Enter Array Element No# " + (ctr+1) + ": ");
            arr[ctr] = in.nextInt();
        }

        OE4_Cortez a1 = new OE4_Cortez();
        System.out.print("\nUnsorted Array: ");
        a1.displayArr(arr, size);
        a1.my_quicksort(arr, 0, size-1);

        System.out.println();
        System.out.print("Sorted Array: ");
        a1.displayArr(arr, size);

        System.out.println("\nMinimum Value: " + arr[0]);
        System.out.println("Maximum Value: " + arr[size-1]);
    }
}