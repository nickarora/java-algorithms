public class Circle implements Comparable<Circle> {

  private float radius;

  public Circle(int radius){
    this.radius = radius;
  }

  public Circle() {
    this(1);
  }

  @Override
  public int compareTo(Circle other) {
    if (this.radius > other.radius) return 1;
    if (this.radius == other.radius) return 0;
    return -1;
  }

  @Override
  public String toString() {
    return "This Circle is of radius: " + this.radius;
  }

  public void draw(int x, int y) {
    // draw circle
  }

}