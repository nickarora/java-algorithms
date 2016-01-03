import java.util.Arrays;
import java.util.ArrayList;

public class BinaryArraySearcher {

  public static void main (String[] args) {

    int[] inputArray = new int[] { 9, 2, 7, 4, 6, 5, 3, 8, 1 };
    int findElement = 1;

    // Binary Search only works on a sorted Array
    // Sorting: O(n log n)
    int[] sortedArray = new MergeSorter().sortArray(inputArray);

    System.out.println("Sorted Input: " + Arrays.toString(sortedArray));
    System.out.println("Finding item " + findElement + "...");

    int index = new BinaryArraySearcher().findRec(sortedArray, findElement);

    if (index >= 0) {
      System.out.println("Item found at index " + index + "!");
    } else {
      System.out.println("Item not found!");
    }
  }

  public int findRec(int[] arr, int target) {

    if (arr.length == 0 || (arr.length == 1 && arr[0] != target)) {
      return -1;
    } else if (arr.length == 1) {
      return 0;
    }

    int mid = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);

    if (target < arr[mid]) {
      return findRec(left, target);
    }

    if (target > arr[mid]) {
      int foundIndex = findRec(right, target);
      if (foundIndex >= 0) {
        return foundIndex + mid;
      } else {
        return foundIndex;
      }
    }

    else {
      return mid;
    }
  }

  public int find(int[] arr, int target) {

    int low = 0;
    int high = arr.length -1;

    while (low <= high) {
      int mid = low + ((high - low) / 2);
      if (target < arr[mid]) high = mid - 1;
      if (target > arr[mid]) low = mid + 1;
      else return mid;
    }

    return -1;
  }

}