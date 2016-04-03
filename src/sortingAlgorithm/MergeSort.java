package sortingAlgorithm;

/**
 * Created by Shahida Lucky on 4/3/2016.
 */
public class MergeSort {

    private int[] array;
    private int[] tempMergArray;
    private int length;

    public static void main(String a[]){

        int[] inputArray = {55,83,111,99,77,98,4,2,5,3};
        MergeSort ms = new MergeSort();
        System.out.println("Sorted Array is:");
        ms.sort(inputArray);
        for(int i:inputArray){
            System.out.print(i);
            System.out.print("      ");
        }
    }
    public void sort(int inputArray[]) {

        this.array = inputArray;
        this.length = inputArray.length;
        this.tempMergArray = new int[length];
        doMergeSort(0, length - 1);
    }
    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {

            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {

            tempMergArray[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {

            if (tempMergArray[i] <= tempMergArray[j]) {
                array[k] = tempMergArray[i];
                i++;

            } else {
                array[k] = tempMergArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempMergArray[i];
            k++;
            i++;
        }
    }
}
