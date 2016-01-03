import java.util.Arrays;

public class BubbleSort {

  public static void  main(String[] args) {

    int[] inputArr = new int[] { 12, 8, 7, 5, 2 };
    System.out.println("Input Array: " + Arrays.toString(inputArr));

    BubbleSort bs = new BubbleSort();
    int[] outputArr = bs.sort(inputArr);

    System.out.println("Sorted Array: " + Arrays.toString(outputArr));
  }

  public int[] sort(int[] inputArr) {
    int[] arr = Arrays.copyOf(inputArr, inputArr.length);

    boolean sorted = false;

    while (!sorted) {
      sorted = true;
      for ( int i = 0; i < arr.length - 1; i++ ) {
        if (arr[i] > arr[i + 1]) {
          sorted = false;
          int tmp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = tmp;
        }
      }
    }

    return arr;
  }

}