import processing.core.PApplet;

public abstract class Vehicle {

  int x, y, speedX;
  PApplet parent;

  public Vehicle(PApplet p, int initialX, int initialY) {
    parent = p;
    this.x = initialX;
    this.y = initialY;
    this.speedX = 2; // Initialize speedX
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public abstract void drawIt(int r, int g, int b);

  public abstract void move();

  public abstract BoundingBox makeBoundingBox(); // Abstract method to create a BoundingBox object

  public boolean collision(Vehicle other) {
    // Get bounding boxes for this vehicle and the other vehicle
    BoundingBox box1 = this.makeBoundingBox();
    BoundingBox box2 = other.makeBoundingBox();

    // Check for collision between the two bounding boxes
    if (box1.getX() < box2.getX() + box2.getWidth() &&
        box1.getX() + box1.getWidth() > box2.getX() &&
        box1.getY() < box2.getY() + box2.getHeight() &&
        box1.getY() + box1.getHeight() > box2.getY()) {
      System.out.println("Collision detected!");
      return true;
    } else {
      System.out.println("No collision.");
      return false;
    }
  }
}

// @Override
// public void drawIT(){
// //nothing
// }
