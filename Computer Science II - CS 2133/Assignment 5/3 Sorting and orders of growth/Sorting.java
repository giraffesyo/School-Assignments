//MergeSort is doing O(n log n) steps, we are doubling the size of our array which we have to go through for each
//time that we have to merge
//each time we have to do a merge it does n steps. So we're doing n work, for each merge, and we do log n merges total.
//This runs much faster than the bubbleSort algorithm especially for larger sets of information, as we can see from
//this assignment, the Merge sort only increases its runtime an arbitrary amount, where Bubble sort starts to
//take crazy high amounts of time. That is because bubble swap is running O(n^2) so the time it takes for larger
//data sets exponentially increases (with the number of items in the collection)
//Due to this exponential increase of time required to sort, it is only useful for smaller collections


import java.util.Arrays;

public class Sorting {

    static double[] Array1;
    static double[] Array2;
    static int ARRAY_LENGTH = 1;

    static int stage = 0;
    static long MergeTime;

    public static void main(String[] args) {
        try {


            while (true) {
                ARRAY_LENGTH *= 10;
                generateArrays();
                stage = 0;
                bubbleSort();
                MergeTime = System.currentTimeMillis();
                stage = 1;
                mergeSort(Array2);
                System.out.println("Merge sort took " + (System.currentTimeMillis() - MergeTime) + " ms to execute");
            }
        } catch (OutOfMemoryError e) {
            if(stage == 0)
                System.out.println("Bubble sort used up all the memory with array size of " + ARRAY_LENGTH);
            else if (stage == 1)
            {
                System.out.println("Merge sort used up all the memory with array size of " + ARRAY_LENGTH);
            }

        }
    }


    public static void generateArrays() {
        Array1 = new double[ARRAY_LENGTH];

        for (int i = 0; i < Array1.length; i++) {
            Array1[i] = Math.random();
        }

        Array2 = Arrays.copyOf(Array1, ARRAY_LENGTH);

    }

    public static void bubbleSort() {

        long Time = System.currentTimeMillis();

        double tmp;
        for (int i = 0; i < Array1.length - 1; i++) {
            if (Time + 20000 <= System.currentTimeMillis()) {
                System.out.println("Bubble sort ran out of time with Array length of " + Array1.length);
                System.exit(0);
            }
            for (int j = 0; j < Array1.length - 1 - i; j++) {
                if (Array1[j] > Array1[j + 1]) {
                    tmp = Array1[j];
                    Array1[j] = Array1[j + 1];
                    Array1[j + 1] = tmp;
                }
            }
        }

        System.out.println("Bubble sort took " + (System.currentTimeMillis() - Time) + " ms to execute");
    }


    static double[] mergeSort(double[] array) {

        if (MergeTime + 20000 <= System.currentTimeMillis()) {
            System.out.println("Merge sort ran out of time with an array length of " + ARRAY_LENGTH);
            System.exit(0);
        }

        if (array.length <= 1) {
            return array;
        }

        int middle = array.length / 2;

        double[] left = new double[middle];
        double[] right = new double[array.length - middle];
        double result[];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        int x = 0;
        for (int i = middle; i < array.length; i++) {
            if (x < right.length) {
                right[x] = array[i];
                x++;
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);


        return result;
    }

    static double[] merge(double[] left, double[] right) {
        int newLength = left.length + right.length;
        int Left = 0, Right = 0, nextIndex = 0;
        double[] newArray = new double[newLength];

        while (Left < left.length || Right < right.length) {
            if (Left < left.length && Right < right.length) {
                if (left[Left] <= right[Right]) {
                    newArray[nextIndex] = left[Left];
                    Left++;
                    nextIndex++;
                } else {
                    newArray[nextIndex] = right[Right];
                    Right++;
                    nextIndex++;
                }
            } else if (Left < left.length) {
                newArray[nextIndex] = left[Left];
                Left++;
                nextIndex++;
            } else if (Right < right.length) {
                newArray[nextIndex] = right[Right];
                Right++;
                nextIndex++;
            }
        }
        return newArray;
    }
}

