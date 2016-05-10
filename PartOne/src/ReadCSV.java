import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
	
public List<Product> Readcsv () throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader("dataset.csv"));
	List <Product> prodp = new ArrayList<Product>();
	String line = reader.readLine();
	while ((line = reader.readLine()) != null) {
		 String [] values = line.split(";");
		 
		 int id = Integer.parseInt(values[0]);
		 String Name = (values[1]);
		 double price = Double.parseDouble(values[2]);
		 double SmartRating = Double.parseDouble(values[3]);
		 double Quality = Double.parseDouble(values[4]);
		 double Stars = Double.parseDouble(values[5]);
		 double numberofReviewers = Double.parseDouble(values[6]);
		 String Reviews = (values[7]);
		 String[] parts = Reviews.split("-");
		 int number = parts.length;
		 List <Review> r1 = new ArrayList();
		 for (String part : parts){ 
			 String [] rev = part.split(",");
			 double TrustLevel = Double.parseDouble(rev[0]);
			 double stars = Double.parseDouble(rev[1]);
			 Review k = new Review (TrustLevel, stars);
			 r1.add(k);	 
		 }
         Product x = new Product(id,Name,price,SmartRating,Quality,Stars,numberofReviewers,r1);
         prodp.add(x);	
	}
	reader.close();
	return prodp;
	
}

}
