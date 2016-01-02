import java.util.Arrays;

public class ApproxStringMatch {

  public static void main(String[] args) {

    String pattern = "abcdefghijkl";
    String text = "bcdeffghixkl";
    ApproxStringMatch asm = new ApproxStringMatch();

    int dist = asm.editDistance(pattern, text);
    boolean match = asm.evaluateDist(pattern, dist);
    System.out.println("changes: " + dist + "\nfuzzy match? " + match + "\n");

  }

  public boolean evaluateDist(String pattern, int dist) {
    int maxDist = Math.round(pattern.length()/3);
    return (dist <= maxDist);
  }

  public int editDistance(String pattern, String text) {

    System.out.println("\npattern: " + pattern + "\ntext: " + text);

    int[][] d = new int[pattern.length() + 1][text.length() + 1];

    for ( int i = 0; i < d.length; i++ ) {
      d[i][0] = i;
    }

    for (int i = 0; i < d[0].length; i++ ) {
      d[0][i] = i;
    }

    for (int i = 1; i < d.length; i++) {
      for (int j = 1; j < d[0].length; j++) {
        d[i][j] = minOfThree(
          d[i-1][j-1] + matchCost(pattern.charAt(i-1), text.charAt(j-1)),
          d[i-1][j] + 1,
          d[i][j-1] + 1
        );
      }
    }

    // System.out.println("\n");
    // for ( int i = 0; i < d.length; i++ ) { System.out.println( Arrays.toString(d[i]) ); }
    // System.out.println("\n");

    return d[d.length - 1][d[0].length - 1];

  }

  private int minOfThree(int a, int b, int c) {
    int firstMin = Math.min(a, b);
    int secondMin = Math.min(firstMin, c);
    return secondMin;
  }

  private int matchCost(char s, char t) {
    if (s == t) { return 0; }
    return 1;
  }

}