public class Radix {
    Integer [] array;
    int size;
    int MAX_CAP;

    public Radix() {
        this.size = 0;
        this.MAX_CAP = 128;
        this.array = new Integer[this.MAX_CAP];
    }

    public void add(Integer data) {
        if (this.size == this.MAX_CAP) {resize();}
        this.array[this.size++] = data;
    }

    public void countingSort(int k) {
        Integer [] index = new Integer[10];
        Integer [] places = new Integer[this.size];
        for (int i = 0; i < index.length; i++) {index[i] = 0;} // Create zero array
        for (int i = 0; i < this.size; i++) {index[getKthNumber(this.array[i], k)] += 1;} // Set number of number occurences
        for (int i = 1; i < index.length; i++) {index[i] += index[i-1];} // Sum numbers of occurences


        for (int i = this.size-1; i >= 0; i--) { places[-1 + index[getKthNumber(this.array[i], k)]--] = this.array[i];}
        this.array = places;
    }

    public void radixSort() {
        int maxNbrDigits = determineMaxNbrDigits();
        for (int i = 0 ; i < maxNbrDigits; i++) {countingSort(i);} //TODO; Tukaj je v zanki i < 3, ker še pogledaš v main je največje število trimestno
    }

    private int determineMaxNbrDigits() {
        int maxNbrDigits = 0;
        for (int i = 0; i < this.size; i++) {
            int nbrDigitsIthNumber = (int) Math.log10(this.array[i]) + 1;
            if (nbrDigitsIthNumber > maxNbrDigits) {maxNbrDigits = nbrDigitsIthNumber;}
        }
        return maxNbrDigits;
    }

    private void resize() {
        this.MAX_CAP *= 2;
        Integer [] tmp = new Integer[this.MAX_CAP];
        for (int i = 0; i < this.size; i++) {tmp[i] = this.array[i];}
        this.array = tmp;

    }

    public void printMe() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
    }


    private int getKthNumber(int number, int k) {
        return (int) Math.floor(number/Math.pow(10,k))%10;
    }
}
