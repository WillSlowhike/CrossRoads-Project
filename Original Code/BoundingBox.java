import processing.core.PApplet;

public class BoundingBox {

  int x, y, boxWidth, boxHeight;

  public BoundingBox(int x, int y, int boxWidth, int boxHeight) {
    this.x = x;
    this.y = y;
    this.boxWidth = boxWidth;
    this.boxHeight = boxHeight;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return boxWidth;
  }

  public int getHeight() {
    return boxHeight;
  }

  public boolean collision(BoundingBox other) {
    // Check if any side of the first box is inside the second box
    if (((x >= other.x && x <= other.x + other.boxWidth) ||
        (x + boxWidth >= other.x && x + boxWidth <= other.x + other.boxWidth))
        &&
        ((y >= other.y && y <= other.y + other.boxHeight) ||
            (y + boxHeight >= other.y && y + boxHeight <= other.y + other.boxHeight))) {
      System.out.println("crash");
      return true;
    }
    System.out.println("didn't crash");
    return false;
  }
}
