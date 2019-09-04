import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {
    LinkedList<Integer> linkedList;
    Integer[] integerList;
    int size, MAX_CAP;


    public MergeSort() {
        this.linkedList = new LinkedList<>();
        this.size = 0;
        this.MAX_CAP = 1024;
        this.integerList = new Integer[MAX_CAP];
    }

    public void add(Integer data) {this.linkedList.add(data);}
    public void addInteger(Integer data) {
        if (this.size == this.MAX_CAP) {resize();}
        this.integerList[this.size++] = data;
    }

    public void resize() {
        this.MAX_CAP *= 2;
        Integer [] tmp = new Integer[this.MAX_CAP];
        for (int i = 0; i < this.size; i++) {
            tmp[i] = this.integerList[i];
        }
        this.integerList = tmp;
    }
    public Integer remove() {return this.linkedList.remove();}
    public boolean removeElement(Integer element) {return this.linkedList.remove(element);}

    public LinkedList<Integer> mergeSort() {
        return mergeSortRec(this.linkedList);
    }


    private LinkedList<Integer> mergeSortRec(LinkedList<Integer> list) {
        if (list.size() <= 1) {return list;}
        int middle = (list.size() - 1)/2;
        LinkedList<Integer> left = mergeSortRec(generateLL(list,0,middle));
        LinkedList<Integer> right = mergeSortRec(generateLL(list,middle+1,list.size()-1));
        return merge(left,right);
    }



    private LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> merged = new LinkedList<>();
        while (left.size() > 0 && right.size() > 0) {
            if (left.getFirst() > right.getFirst()) {merged.add(right.removeFirst());}
            else {merged.add((left.removeFirst()));}
        }
        if (left.size() == 0) {while (right.size() != 0) {merged.add(right.removeFirst());}}
        else {{while (left.size() != 0) {merged.add(left.removeFirst());}}}

        return merged;
    }

    /*TODO Merge sort with array implementation...think it will eliminate need for generateLL method which is slowing down sorting.
    public Integer[] mergeSortInt() {
        return mergeSortIntRec(this.integerList, 0, this.size);
    }

    private Integer[] mergeSortIntRec(Integer [] list, int startI, int endI) {
        if (endI-startI <= 1) {return list;}
        int middle = (endI-startI)/2;
        Integer[] left = mergeSortIntRec(Arrays.copyOfRange(list,0,middle),0,middle);
        Integer[] right = mergeSortIntRec(Arrays.copyOfRange(list,middle+1,endI), middle+1, endI);
        return mergeInt(left,right);
    }

    private Integer[] mergeInt(Integer [] left, Integer [] right) {
        Integer [] merged = new Integer[left.length+right.length];
        int leftPointer   = 0;
        int rightPointer  = 0;
        int mergedPointer = 0;
        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] > right[rightPointer]) {merged[mergedPointer++] = right[rightPointer++];}
            else {merged[mergedPointer++] = left[leftPointer++];}
        }
        if (leftPointer == left.length) {while (rightPointer++ == right.length) {merged[mergedPointer++] = right[rightPointer];}}
        else {while (rightPointer++ == right.length) {merged[mergedPointer++] = left[leftPointer];}}

        return merged;
    }*/

    private LinkedList<Integer> generateLL(LinkedList<Integer> list, int startI, int endI) {
        LinkedList<Integer> newLL = new LinkedList<>();
        for (int i = startI; i <= endI; i++) {
            newLL.add(list.get(i));
        }
        return newLL;
    }

    public void printList() {
        for (Integer element : this.linkedList) {System.out.print(element + " ");}
    }
}
