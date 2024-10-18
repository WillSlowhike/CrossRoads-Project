import processing.core.PApplet;

public class Sketch extends PApplet {

  Car lmq;
  Car towMater;
  Car upDownCar; // New car instance for up and down movement
  //Car upDownCar2;
  //Car upDownCar3;
  int lives = 3;
  boolean gameOver = false;
    

  Intersection intersection;
  int noCollisionTextX = 633; // Initial X position of the "No Collision" text
  int noCollisionTextY = 100;  // Initial Y position of the "No Collision" text
  
  public void settings() {
    size(800, 800);
  }

  public void setup() {
    lmq = new Car(this, 100, 400, 5);
    towMater = new Car(this, 100, 200, 3);
    upDownCar = new Car(this, 200, 600, 2); 
    intersection = new Intersection(400, 400, 50); 
    
  }

  public void draw() {
      background(124, 150, 0);

      // Draw bounding box for Lightning McQueen
      BoundingBox lmqBox = lmq.makeBoundingBox();
      fill(255, 0, 0, 50); // Semi-transparent red
      rect(lmqBox.getX(), lmqBox.getY(), lmqBox.getWidth(), lmqBox.getHeight());

      // Draw bounding box for Tow Mater
      BoundingBox towMaterBox = towMater.makeBoundingBox();
      fill(183, 65, 14, 50); // Semi-transparent brown
      rect(towMaterBox.getX(), towMaterBox.getY(), towMaterBox.getWidth(), towMaterBox.getHeight());

      //Draw bounding box for upDownCar
      BoundingBox upDownCarBox = upDownCar.makeBoundingBox();
      fill(0, 0, 255, 50);
      rect(upDownCarBox.getX(), upDownCarBox.getY(), upDownCarBox.getWidth(), upDownCarBox.getHeight());


    
    boolean isCollision1 = lmq.collision(towMater);
    boolean isCollision2 = lmq.collision(upDownCar);

    // Display collision notification
    fill(255); // White color for text
    textSize(15); // Set text size
    textAlign(TOP, LEFT);
    if (isCollision1 || isCollision2) {
        text("Collision Detected!", noCollisionTextX, noCollisionTextY); // Display collision notification
    } else {
        text("No Collision", noCollisionTextX, noCollisionTextY); // Display no collision notification
    }

      // Check collision between Lightning McQueen and Tow Mater
      lmq.collision(towMater);
      lmq.collision(upDownCar);
    
    drawRoads();
    intersection.draw(this); 
    
      //Lighting McQueen
      lmq.moveWithArrows();
      lmq.drawIt(255, 0, 0);

      //Tow Mater
      towMater.move();
      towMater.drawIt(183, 65, 14);

      //upDownCar
      upDownCar.moveUpDown();
      upDownCar.drawIt(0, 255, 0);

    if (frameCount % 360 == 0) { //assuming 60 frames per second
        intersection.trafficLight.toggleLight(); 
    }

    if (!gameOver) {
    // Collision detection
    if (lmq.collision(towMater) || lmq.collision(upDownCar)) {
        lives--; // Subtract lives
        if (lives <= 0) {
            gameOver = true; // Set game over state if no lives remaining
        }
      }
    } else {
          displayRestartScreen(); // Display restart screen if game over
      }    
  }

  private void displayLifeCounter() {
      // Display life counter on the screen
      fill(255); // White text
      textSize(20);
      text("Lives: " + lives, 20, 20); // Display life count at (20, 20)
  }

  private void displayRestartScreen() {
      // Display restart screen with message
      background(0); // Black background
      fill(255); // White text
      textAlign(CENTER, CENTER);
      textSize(30);
      text("Game Over! Press 'R' to restart.", width / 2, height / 2);
  }

  public void keyPressed() {
      if (gameOver && key == 'r') {
          restartGame(); // Restart the game if 'R' key is pressed
      }
  }

      private void restartGame() {
          // Reset game state
          lives = 3; // Reset life counter
          gameOver = false; // Reset game over state
          // Reset car positions or any other necessary variables
          lmq = new Car(this, 100, 400, 5);
          towMater = new Car(this, 100, 200, 3);
          upDownCar = new Car(this, 200, 600, 2); 
      }
  
  
  private void drawRoads() {
 
    strokeWeight(5);
    stroke(100);
    line(0, height/2, width, height/2);    
    line(width/2, 0, width/2, height);

    fill(82,82,87);
    //Horizonal Roads
    //rect(200,403,800,50);
    rect(400,203,800,50);
    rect(400,403,800,50);

    //Vertical Roads
    rect(200,403,50,800);
    rect(400,403,50,800);
    rect(600,403,50,800);
    
    
    
  }
}

