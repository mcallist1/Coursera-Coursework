import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
   
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int pointCount = 0;
        for (Point p : s.getPoints()) {
            pointCount ++;
        }
        return pointCount;
    }

    public double getAverageLength(Shape s) {
        // Assuming that shape has at least 2 points for this exercise
        int numOfSides = -1;
        int numPoints = getNumPoints(s);
        double averageLength;
        
        if(numPoints > 2){
            numOfSides = numPoints;
        }
        else if(numPoints == 2){
            numOfSides = 1;
        }
        
        averageLength = getPerimeter(s)/numOfSides;
        
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        
        double largestSide = 0.0; 
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
            double dist = prevPt.distance(currPt);
            
            if(dist > largestSide){
                largestSide = dist;
            }
            
            prevPt = currPt;
        
        }
        return largestSide;
    }
    
    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        double x;
        for (Point currPt : s.getPoints()) {
            x = currPt.getX();
            if(x > largestX){
                largestX = x;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = 0.0;
        double perim;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            perim = getPerimeter(s);
            
            if(perim > largestPerim){
                largestPerim = perim;
            }
            
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        
        double largestPerim = 0.0;
        double perim;
        String temp = "";
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            
            FileResource fr = new FileResource(f);
            
            Shape s = new Shape(fr);
            perim = getPerimeter(s);
            
            if(perim > largestPerim){
                largestPerim = perim;
                temp = f.getName();
            }
            
        }

        return temp;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("Perimeter = " + length);
        System.out.println("Points = " + numPoints);
        System.out.println("Average Length = " + avLength);
        System.out.println("Largest Side = " + largestSide);
        System.out.println("Largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter from multiple files = " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
      
        String fileWithLargestPerimeter = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter = " + fileWithLargestPerimeter);

    }
       
    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        int pointNum = getNumPoints(triangle);
        
        System.out.println("perimeter = "+peri);
        //System.out.println("num of points  = "+pointNum);
        
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
