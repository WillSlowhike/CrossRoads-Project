import processing.core.PApplet;

public class Intersection {
    int x, y; // Coordinates of the intersection
    int size; // Size of the intersection
    TrafficLight trafficLight; // Traffic light at the intersection

    public Intersection(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.trafficLight = new TrafficLight(x, y); // Initialize a traffic light at the intersection
    }

    public void draw(PApplet parent) {
        // Draw intersection as a square
        parent.fill(150);
        parent.rectMode(parent.CENTER);
        parent.rect(x, y, size, size);

        // Draw traffic light
        trafficLight.display(parent);
    }
  
  public void toggleTrafficLight() {
      trafficLight.toggleLight();
  }
}
