public class MinHeap {
    private int MAX_CAP;
    private Integer [] heap;
    private int size;
    private int root;
    private final int branchingFactor;

    public MinHeap(int branchingFactor) {
        this.MAX_CAP = 2;
        this.heap    = new Integer[this.MAX_CAP];
        this.size    = 0;
        this.root    = 0;
        this.branchingFactor = branchingFactor;
    }

    /*ADD METHODS*/
    public void add(int inputData) {
        if (this.size == this.MAX_CAP) {resize();}
        this.heap[this.size++] = inputData;
        siftUp(this.size-1);
    }

    private void siftUp(int nodeIndex) {
        if (this.heap[nodeIndex] < this.heap[getParent(nodeIndex)]) {
            swap(nodeIndex, getParent(nodeIndex));
            siftUp(getParent(nodeIndex));
        }
    }

    private int getParent(int nodeIndex) {
        return ((nodeIndex-1)/this.branchingFactor);
    }

    /*REMOVE METHODS*/

    public int remove() {
        if (this.size == 1) {
            Integer tmp = this.heap[0];
            this.heap[0] = null;
            return tmp;
        } else {
            Integer removed = this.heap[0];
            this.heap[0] = this.heap[--this.size];
            this.heap[this.size] = null;
            siftdown(0);
            return removed;
        }
    }

    private void siftdown(int nodeIndex) {
        Integer pointer = this.branchingFactor*nodeIndex+1;
        for (int k = 2; k <= this.branchingFactor; k++) {
            Integer kthChild     = getKthChild(nodeIndex, k);
            if (kthChild < this.size && this.heap[kthChild]!= null && this.heap[pointer] > this.heap[kthChild] ) { pointer = kthChild; }
        }
        if (pointer < this.size && this.heap[nodeIndex] > this.heap[pointer]) {
            swap(nodeIndex, pointer);
            siftdown(pointer);
        }
    }

    /*COMMON METHODS*/
    private void swap(int first, int second) {
        Integer tmp = this.heap[first];
        this.heap[first] = this.heap[second];
        this.heap[second] = tmp;
    }

    /*GLOBAL METHODS*/
    public Integer [] heapSort() {
        int last = this.size;
        Integer [] heapCopyToSort = new Integer[last];
        while (last > 0) {
            int removed = remove();
            heapCopyToSort[heapCopyToSort.length-last--] = removed;
        }
        return heapCopyToSort;
    }

    private Integer getKthChild(int nodeIndex, int kthChild) { return (nodeIndex >= 0 && nodeIndex < this.size ) ? (this.branchingFactor*nodeIndex+kthChild): null;}

    public void printHeap() {
        int cnt = 0;
        while (cnt < this.size) { System.out.print(this.heap[cnt++] + " "); }
    }

    public Integer getMinElement() {
        return (this.size > 0) ? this.heap[0] : null;
    }

    public void printMin() {
        Integer min = getMinElement();
        if (min != null) {System.out.println(min);}
        else {System.out.println("HEAP IS EMPTY");}
    }

    public Integer getSecondMinElement() {
        return heapSort()[1];
    }

    public boolean isElementPresent(Integer element) {
        if (!isEmpty()) {for (int i = 0; i < this.size; i++) {if (element.equals(this.heap[i])) {return true;}}}
        return false;
    }

    public boolean isEmpty() {
        if (this.size == 0) {return true;}
        return false;
    }

    private void resize() {
        this.MAX_CAP *= 2;
        Integer [] tmp = new Integer[this.MAX_CAP];
        for (int i = 0; i < this.size; i++) {tmp[i] = this.heap[i];}
        this.heap = tmp;
    }
}
