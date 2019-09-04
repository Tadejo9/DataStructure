public class QuickSort {

    Integer[] array;
    int size;
    int MAX_CAP;
    public QuickSort() {
        this.MAX_CAP = 64;
        this.array = new Integer[this.MAX_CAP];
        this.size = 0;
    }

    public void add(Integer data) {
        if (this.size == this.MAX_CAP) {resize();}
        this.array[this.size++] = data;
    }

    private void resize() {
        this.MAX_CAP *= 2;
        Integer [] tmp = new Integer[this.MAX_CAP];
        for (int i = 0; i < this.size; i++) {tmp[i] = this.array[i];}
        this.array = tmp;
    }

    public void quickSort() {
        qs(0,this.size-1, this.array);
    }

    private void qs(int left, int right, Integer [] array) {
        if (left >= right) {return;}
        int r = partition(array,left,right);
        qs(left, r-1,array);
        qs(r+1,right,array);
    }

    private int partition(Integer [] array, int left, int right) {
        int pivot = this.array[left];
        int l = left;
        int r = right + 1;
        while (true) {
            do {l++;} while (array[l] < pivot && l < right);
            do { r--; } while (array[r] > pivot);
            if (l >= r) {break;}
            swap(array,l,r);
        }
        swap(array, left, r);
        return r;
    }

    public void printMe() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
    }

    private void swap(Integer [] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
