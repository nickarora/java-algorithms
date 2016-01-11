import java.util.Arrays;
import java.util.ArrayList;

public class MergeSorter<T> {

  public T[] sortArray(T[] arr) {
    ArrayList<T> inputList = new ArrayList<T>();
    for (int i = 0; i < arr.length; i++) { inputList.add(arr[i]); }
    ArrayList<T> sortedList = sort(inputList);
    arr = sortedList.toArray(arr);
    return arr;
  }

  public ArrayList<T> sort(ArrayList<T> inputArr) {

    if (inputArr.size() <= 1) {
      return inputArr;
    }

    ArrayList<T> left = new ArrayList<T>();
    ArrayList<T> right = new ArrayList<T>();

    int midIndex = inputArr.size() / 2;

    left = new ArrayList<T>(inputArr.subList(0, midIndex));
    right = new ArrayList<T>(inputArr.subList(midIndex, inputArr.size()));

    ArrayList<T> mergedLeft = sort(left);
    ArrayList<T> mergedRight = sort(right);
    ArrayList<T> merged = merge(mergedLeft, mergedRight);

    return merged;
  }
  @SuppressWarnings({"unchecked"})
  public ArrayList<T> merge(ArrayList<T> left, ArrayList<T> right) {

    ArrayList<T> merged = new ArrayList<T>();

    while (left.size() > 0 && right.size() > 0) {

      Comparable<T> l = (Comparable<T>) left.get(0);
      Comparable<T> r = (Comparable<T>) right.get(0);

      if (l.compareTo((T) r) <= 0) {
        merged.add(left.remove(0));
      } else {
        merged.add(right.remove(0));
      }
    }

    merged.addAll(left);
    merged.addAll(right);

    return merged;
  }

  public static void main(String[] args) {
    Circle[] circles = new Circle[] {
      new Circle(5),
      new Circle(4),
      new Circle(3),
      new Circle(2),
      new Circle(1)
    };

    MergeSorter<Circle> ms = new MergeSorter<Circle>();
    Object[] sortedArr = ms.sortArray(circles);

    for (int i = 0; i < circles.length; i++) {
      System.out.println(circles[i]);
    }
  }

}