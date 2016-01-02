import java.util.Arrays;
import java.util.ArrayList;

public class BalancedPartition {

  public static void main(String[] args) {
    ArrayList<Integer> inputArray = new ArrayList<Integer>(
      Arrays.asList(9, 2, 7, 4, 6, 5, 3, 8, 1)
      // Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1)
    );

    int partitions = 3;

    BalancedPartition bp = new BalancedPartition();
    bp.partition(inputArray, partitions);
  }

  public void partition(ArrayList<Integer> s, int k) {

    System.out.println( "\n" );
    System.out.println("Input Array: " + s);
    System.out.println("Input Size: " + s.size() + ", Partitions: " + k);

    // Sort input array: O(n log n)
    s = new MergeSort().sort(s);
    int max = s.get(s.size() - 1) * s.size() + 1;
    System.out.println("Sorted Array: " + s);

    // compute prefix sums: O(n)
    ArrayList<Integer> p = new ArrayList<Integer>();
    p.add(0);
    for ( int i = 1; i <= s.size(); i++ ) {
      p.add( p.get(i-1) + s.get(i - 1) );
    }
    System.out.println("Prefixes: " + p);

    // initialize boundary conditions: O(n + k)
    int [][] m = new int [s.size() + 1][k + 1];
    int [][] d = new int [s.size() + 1][k + 1];
    for ( int i = 0; i < m.length; i++ ) {
      m[i][1] = p.get(i);
    }

    for ( int i = 1; i < m[0].length; i++ ) {
      m[1][i] = s.get(0);
    }

    // evaluate main recurrence: O(n^2 * k)
    for (int i = 2; i < s.size() + 1; i++) {
      for (int j = 2; j < (k + 1); j++) {
        m[i][j] = max;
        for ( int x = 1; x <= (i - 1); x++ ) {
          int t = Math.max( m[x][j-1], p.get(i) - p.get(x));
          if ( m[i][j] > t ) {
            m[i][j] = t;
            d[i][j] = x;
          }
        }
      }
    }

    // Output results
    System.out.println( "\n" );
    for ( int i = 0; i < m.length; i++ ) {
      System.out.println( i + ": " + Arrays.toString(m[i]) );
    }

    System.out.println( "\n" );
    for ( int i = 0; i < d.length; i++ ) {
      System.out.println( i + ": " + Arrays.toString(d[i]) );
    }

    System.out.println( "\n" );

    reconstructPartition(s, d, s.size(), k);

  }

  private void reconstructPartition(ArrayList<Integer> s, int[][] d, int n, int k) {
    if (k == 1) {
      ArrayList<Integer> result = new ArrayList<Integer>(s.subList(0, n));
      System.out.println("partition 1: " + result);
    } else {
      reconstructPartition(s, d, d[n][k], k - 1);
      ArrayList<Integer> result = new ArrayList<Integer>(s.subList(d[n][k], n));
      System.out.println("partition " + k + ": " + result);
    }
  }

  /* MergeSort */

  private class MergeSort {

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

}