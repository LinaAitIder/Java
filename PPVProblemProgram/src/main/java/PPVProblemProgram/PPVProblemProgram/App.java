package PPVProblemProgram.PPVProblemProgram;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
    		
    		ArrayList<City> CitiesList;
			try {
				CitiesList = readFileList();
				int n = CitiesList.size();
	    		DisplayConsole(CitiesList , n);
	    		double distances[][]=createDistancesTable(CitiesList , n);
				writeDataInFile(distances ,n);

			} catch (Exception e) {
				e.printStackTrace();
			}			
        	
    }
    
    public static ArrayList<City> readFileList() {
    	ArrayList<City> CitiesList = new ArrayList<>();
		String line;
		String[] CityInfo;
    	try { 
    		FileReader fn = new FileReader("C:/Users/hp/eclipse-workspace/PPVProblemProgram/src/main/java/PPVProblemProgram/PPVProblemProgram/v64sys.txt");
    		BufferedReader br = new BufferedReader(fn) ;
			try {
				while((line=br.readLine())!= null) {
					    City city = new City();
						CityInfo =line.split("\\|");
						city.setX(Double.parseDouble(CityInfo[1])) ;
						city.setY(Double.parseDouble(CityInfo[2]));
						CitiesList.add(city);
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return CitiesList;
    }
    
    public static void DisplayConsole(ArrayList<City> CitiesList , int n) {
		for(int row=0;row<n;row++) {
				System.out.println(CitiesList.get(row).x);
				System.out.println(CitiesList.get(row).y);
		}
    }
    
    public static double[][] createDistancesTable(ArrayList<City> CitiesList , int n) {
    	double distances[][] = new double[n][n] ;
		for(int row=0;row<n;row++) {
			for(int col=0;col<n;col++) {
				distances[row][col]=calculateDistance(CitiesList.get(row),CitiesList.get(col));
			}
		}
		return distances;
    }
    
    public static void writeDataInFile(double[][] distances , int n) {
    	try (DataOutputStream din = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("./distances.dat")))) 
    	{
    				for(int row=0;row<n;row++) {
    					for(int col=0;col<n;col++) 
    						din.writeDouble(distances[row][col]);
    					}
    				} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
 
    public static double calculateDistance(City a , City b) {
    	double dx = b.x - a.x;
    	double dy = b.y - a.y;
    	return Math.sqrt(dx*dx+dy*dy);
 
    }
}
