import java.util.Arrays;

public class InsertionSort {

  public static void  main(String[] args) {

    int[] inputArr = new int[] { 12, 8, 7, 5, 2 };
    System.out.println("Input Array: " + Arrays.toString(inputArr));

    InsertionSort is = new InsertionSort();
    int[] outputArr = is.sort(inputArr);

    System.out.println("Sorted Array: " + Arrays.toString(outputArr));
  }

  public int[] sort(int[] inputArr) {

    int[] arr = new int[inputArr.length];

    for ( int i = 0; i < inputArr.length; i++ ) {
      arr[i] = inputArr[i];

      int j = i - 1;
      while ( j >= 0 ) {

        if ( arr[j] > arr[j + 1] ) {
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }

        j--;
      }
    }

    return arr;
  }

}