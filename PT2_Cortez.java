import java.util.Scanner;

public class PT2_Cortez {

    static int f1 = 0, f2 = 1, fn = 0, ctr = 0;
    //Recursion for Fibconacci sequence
    static void myFibonacci(int num) {
        if (ctr == 0) {
            System.out.print(f2);
            ctr++;
        }

        if(num > 0) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
            System.out.print(" " + f2);
            myFibonacci(num-1);
        }
    }

    //Recursion for Factorial Values
    static int myFactorial(int num){
        if (ctr == 0) {
            System.out.print(num + "! = ");
            ctr++;
        }

        if(num == 1) {
            System.out.println (num);
            return 1;
        } else {
            System.out.print(num + " x ");
            return (num*myFactorial(num-1));
        }
    }

    //Recursion for reversing a number
    static void myReverseNum(int num) {
        if(num < 10) {
            System.out.print(num);
            return;
        }
        else {
            System.out.print(num%10);
            myReverseNum(num/10);
        }
    }

    //Recursion for reversing a word
    static String myReverseWord(String word) {
        
        if (word.isEmpty()) {
            return word;
        }
        return myReverseWord(word.substring(1)) + word.charAt(0);
    }

    //Recursion for solving Tower Of Hanoi
    static void TowerOfHanoi(int disks, char src, char dst, char aux) {
        if (disks == 0) {
            return;
        }
        TowerOfHanoi(disks-1, src, aux, dst);
        System.out.print("Disk " + disks + " moved from rod " + src + " to rod " + dst + "\n");
        TowerOfHanoi(disks-1, aux, dst, src);
    }

    //Mutual recursion in determining odd/even numbers
    static int Odd(int num) {
        if (num >= 0) {
            if (num == 1) {
                return 1;
            } else if (num > 0){
                return Even(num-1);
            } else {
                return 0;
            } 
        } else {
            if (num == -1) {
                return 1;
            } else {
                return Even(num+1);
            }
        }
    }

    //Mutual recursion for Odd function
    static int Even(int num) {
        if (num < 0) {
            return Odd(num+1);
        } else {
            return Odd(num-1);
        }  
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int operation = 0; 

        do {
            System.out.println("-- APPLICATION OF RECURSION --");
            System.out.println();
            System.out.println("[1] - Fibonacci");
            System.out.println("[2] - Factorial");
            System.out.println("[3] - Reverse of Number");
            System.out.println("[4] - Reverse of Word");
            System.out.println("[5] - Tower of Hanoi");
            System.out.println("[6] - Odd or Even Number");
            System.out.println("[7] - Exit");
            System.out.println("\nWhat would you like to do?");
            operation = in.nextInt();

            if (operation == 1) {
                int value1 = 0;

                System.out.println("\n\n-- Fibonacci Sequence --");
                System.out.println("\nEnter maximum value of Fibonacci Sequence: ");
                value1 = in.nextInt();
                System.out.println();

                myFibonacci(value1-1);

                System.out.println();
                System.out.println("-- RETURNING TO MAIN MENU --\n\n");    
                f1 = 0; f2 = 1; fn = 0; ctr = 0;     

            } else if (operation == 2) {
                int value2 = 0;

                System.out.println("\n\n-- Factorials --");
                System.out.println("\nEnter factorial value: ");
                value2 = in.nextInt();
                System.out.println();

                System.out.println("Factorial of " + value2 + ": " + myFactorial(value2));

                System.out.println();
                System.out.println("-- RETURNING TO MAIN MENU --\n\n");  
                ctr = 0;

            } else if (operation == 3) {
                int value3 = 0;

                System.out.println("\n\n-- Reverse of a Number --");
                System.out.println("\nEnter number to be reversed: ");
                value3 = in.nextInt();
                System.out.println();

                System.out.print("The reversed number is: ");
                myReverseNum(value3);

                System.out.println("\n");
                System.out.println("-- RETURNING TO MAIN MENU --\n\n");   

            } else if (operation == 4) {
                String value4;
                System.out.println("\n\n-- Reverse of a Word --");
                System.out.println("\nEnter word to be reversed: ");
                value4 = in.next();
                System.out.println();

                System.out.print("The reversed word is: " + myReverseWord(value4));

                System.out.println("\n");
                System.out.println("-- RETURNING TO MAIN MENU --\n\n");

            } else if (operation == 5) {
                int value5 = 0;

                System.out.println ("\n\n-- Tower of Hanoi --");
                System.out.println("\nEnter number of disks: ");
                value5 = in.nextInt();
                System.out.println();

                TowerOfHanoi(value5, 'A', 'C', 'B');

                System.out.println("\n");
                System.out.println("-- RETURNING TO MAIN MENU --\n\n");

            } else if (operation == 6) {
                int value6 = 0;

                System.out.println ("\n\n-- Odd or Even Number --");
                System.out.println("\nEnter a number: ");
                value6 = in.nextInt();
                System.out.println();

                System.out.print(value6);
                if (Odd(value6) == 1) {
                    System.out.print(" is an odd number...");
                } else {
                    System.out.print(" is an even number...");
                }

                System.out.println("\n");
                System.out.println("-- RETURNING TO MAIN MENU --\n\n");

            } else if (operation == 7) {
                break;
            } else {
                System.out.println("\nYou have inputted a wrong number...");
                System.out.println("-- RETURNING TO MAIN MENU --\n\n");
            }
        } while (operation != 7);
    }
}
