import java.util.Arrays;

public class SelectionSort {

  public static void  main(String[] args) {

    int[] inputArr = new int[] { 12, 8, 7, 5, 2 };
    System.out.println("Input Array: " + Arrays.toString(inputArr));

    SelectionSort ss = new SelectionSort();
    int[] outputArr = ss.sort(inputArr);

    System.out.println("Sorted Array: " + Arrays.toString(outputArr));
  }

  public int[] sort(int[] inputArr) {
    int[] arr = Arrays.copyOf(inputArr, inputArr.length);

    for (int i = 0; i < arr.length - 1; i++) {

      int selectedIndex = -1;

      for (int j = i; j < arr.length; j++) {
        if (selectedIndex == -1 || arr[selectedIndex] > arr[j]) {
          selectedIndex = j;
        }
      }

      if (selectedIndex > -1) {
        int tmp = arr[i];
        arr[i] = arr[selectedIndex];
        arr[selectedIndex] = tmp;
      }

    }

    return arr;
  }

}