import processing.core.PApplet;

public class TrafficLight {
    int x, y; // Coordinates of the traffic light
    int diameter = 30; // Diameter of the traffic light
    int lightColor; // Color of the traffic light (0: red, 1: green)

    public TrafficLight(int x, int y) {
        this.x = x;
        this.y = y;
        this.lightColor = 0; // Start with red light
    }

    public void display(PApplet parent) {
        // Draw the pole
        parent.fill(100);
        parent.rect(x, y, 10, 100);

        // Draw the traffic light
        parent.fill(lightColor == 0 ? parent.color(255, 0, 0) : parent.color(0, 255, 0)); // Red or green light
        parent.ellipseMode(parent.CENTER);
        parent.ellipse(x, y, diameter, diameter);
    }

  
    public void changeLight() {
        // Change the traffic light color
        lightColor = (lightColor + 1) % 2; // Toggle between red (0) and green (1)
    }
  public void toggleLight() {
    changeLight(); // Toggle the traffic light color
  }
}
