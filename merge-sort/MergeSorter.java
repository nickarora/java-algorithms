import java.util.Arrays;
import java.util.ArrayList;

public class MergeSorter {

  public static void main(String[] args) {
    ArrayList<Integer> inputArray = new ArrayList<Integer>(
      Arrays.asList(9, 2, 7, 4, 6, 5, 3, 8, 1)
    );

    System.out.println("Input: " + inputArray);
    ArrayList<Integer> sortedArray = new MergeSorter().sort(inputArray);
    System.out.println("Sorted: " + sortedArray);
  }

  public ArrayList<Integer> sort(ArrayList<Integer> inputArr) {

    if (inputArr.size() <= 1) {
      return inputArr;
    }

    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();

    int midIndex = inputArr.size() / 2;

    left = new ArrayList<Integer>(inputArr.subList(0, midIndex));
    right = new ArrayList<Integer>(inputArr.subList(midIndex, inputArr.size()));

    ArrayList<Integer> mergedLeft = sort(left);
    ArrayList<Integer> mergedRight = sort(right);
    ArrayList<Integer> merged = merge(mergedLeft, mergedRight);

    return merged;
  }

  public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {

    ArrayList<Integer> merged = new ArrayList<Integer>();

    while (left.size() > 0 && right.size() > 0) {
      if (left.get(0) <= right.get(0)) {
        merged.add(left.remove(0));
      } else {
        merged.add(right.remove(0));
      }
    }

    merged.addAll(left);
    merged.addAll(right);

    return merged;
  }

}