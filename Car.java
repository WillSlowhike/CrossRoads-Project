import processing.core.PApplet;

public class Car extends Vehicle {

  boolean movingRight = true;
  boolean movingUp = true;
  int speed;
  int carWidth = 60; // Instance variable for car width
  int carHeight = 30; // Instance variable for car height

  public Car(PApplet p, int initialX, int initialY, int speed) {
    super(p, initialX, initialY);
    this.speed = speed;
  }

  public void move() {
      if (movingRight) {
          this.x += this.speedX;
      } else {
          this.x -= this.speedX;
      }

      // Check if Mater reaches the right side of the screen
      if (this.x >= parent.width) {
          // Reset Mater's position to the left side of the screen
          this.x = -carWidth; // Place Mater just outside the left side of the screen
      }
    }

  
  public void moveWithArrows() {
    if (parent.keyPressed) {
      if (parent.keyCode == 38) { // UP arrow key
        this.y -= this.speed;
      } else if (parent.keyCode == 40) { // DOWN arrow key
        this.y += this.speed;
      } else if (parent.keyCode == 37) { // LEFT arrow key
        this.x -= this.speed;
      } else if (parent.keyCode == 39) { // RIGHT arrow key
        this.x += this.speed;
      }

      this.x = PApplet.constrain(this.x, 0, parent.width - 60);
      this.y = PApplet.constrain(this.y, 0, parent.height - 30);
    }
  }

  public void drawIt(int r, int g, int b) {
    parent.fill(r, g, b);
    parent.rect(this.x, this.y, 60, 30);

    // Draw eyes
    parent.fill(0); // Black color for eyes
    float eyeSize = 10; // Size of the eyes

    // Left eye or wheels
    float leftEyeX = this.x - 25;
    float leftEyeY = this.y + 20;
    parent.ellipse(leftEyeX, leftEyeY, eyeSize, eyeSize);

    // Right eye or wheels 
    float rightEyeX = this.x + 25;
    float rightEyeY = this.y + 20;
    parent.ellipse(rightEyeX, rightEyeY, eyeSize, eyeSize);
  }

  @Override
  public BoundingBox makeBoundingBox() {
    return new BoundingBox(x, y, carWidth, carHeight);
  }

  public void moveUpDown() {
          if (movingUp) {
              this.y -= this.speed; // Move up
          } else {
              this.y += this.speed; // Move down
          }

          if (this.y <= 0) {
              movingUp = false;
          } else if (this.y >= parent.height - carHeight) {
              movingUp = true;
          }
      }
  }

