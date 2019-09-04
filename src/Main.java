import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of random numbers in data structure: ");
        int rndNbr = sc.nextInt();

        /*Heap sort with min heap*/
        System.out.println("[MIN-HEAP-SORT]");
        System.out.print("[ADDING]: ");
        long start = System.currentTimeMillis();
        MinHeap mh = new MinHeap(3);
        Random rnd = new Random();
        for (int i = 0; i < rndNbr; i++) {
            mh.add(rnd.nextInt(51));
        }
        System.out.println(((double)(System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.print("[SORTING]: ");
        start = System.currentTimeMillis();
        Integer [] sortedWithHeap = mh.heapSort();
        System.out.println((double)((System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.println("-     -     -     -     -     -     -     -     -     -     -     -");

        /*Merge sort*/
        System.out.println("[MERGE-SORT]");
        System.out.print("[ADDING]: ");
        start = System.currentTimeMillis();
        MergeSort ms = new MergeSort();
        rnd = new Random();
        for (int i = 0; i < rndNbr; i++) {
            ms.add(rnd.nextInt(51));
        }
        System.out.println(((double)(System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.print("[SORTING]: ");
        start = System.currentTimeMillis();
        LinkedList<Integer> sortedWithMergeSort = ms.mergeSort();
        System.out.println((double)((System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.println("-     -     -     -     -     -     -     -     -     -     -     -");

        /*Quick Sort*/
        System.out.println("[QUICK-SORT]");
        System.out.print("[ADDING]: ");
        start = System.currentTimeMillis();
        QuickSort qs = new QuickSort();
        for (int i = 0; i < rndNbr; i++) {
            qs.add(rnd.nextInt(51));
        }
        System.out.println(((double)(System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.print("[SORTING]: ");
        start = System.currentTimeMillis();
        qs.quickSort();
        System.out.println((double)((System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.println("-     -     -     -     -     -     -     -     -     -     -     -");

        /*COUNTING SORT*/
        System.out.println("[COUNTING-SORT]");
        System.out.print("[ADDING]: ");
        start = System.currentTimeMillis();
        Radix cs = new Radix();
        for (int i = 0; i < rndNbr; i++) {
            cs.add(rnd.nextInt(10));
        }
        System.out.println(((double)(System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.print("[SORTING]: ");
        start = System.currentTimeMillis();
        cs.countingSort(0);
        System.out.println((double)((System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.println("-     -     -     -     -     -     -     -     -     -     -     -");

        /*RADIX SORT*/

        System.out.println("[RADIX-SORT]");
        System.out.print("[ADDING]: ");
        start = System.currentTimeMillis();
        Radix rs = new Radix();
        for (int i = 0; i < rndNbr; i++) {
            rs.add(rnd.nextInt(10000));
        }
        System.out.println(((double)(System.currentTimeMillis()-start)/1000) + " seconds");
        System.out.print("[SORTING]: ");
        start = System.currentTimeMillis();
        rs.radixSort();
        System.out.println((double)((System.currentTimeMillis()-start)/1000) + " seconds");
    }
}
