import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
	
public List<Product> Readcsv (int i )throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
	List <Product> prodp = new ArrayList<Product>();
	String line = reader.readLine();
	getfriends cf = new getfriends();
	List <Friend> f = cf.getFriends(i);
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
			 int friend  = Integer.parseInt(rev[0]);
			 double stars = Double.parseDouble(rev[1]);
			 for (Friend st:f){
				 if (friend == st.getId()){
				 Review k = new Review  (st.getTrustlevel(),stars,st.getDistance());
				 r1.add(k);	
				 break;
				 }
			 }
		 }
         Product x = new Product(id,Name,price,SmartRating,Quality,Stars,numberofReviewers,r1);
         prodp.add(x);	
	}
	reader.close();
	return prodp;
	
}
 public List <String> Readfile () throws IOException{
	 BufferedReader reader = new BufferedReader(new FileReader("Friends.csv"));
		List <String> s  = new ArrayList<String>();
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			String l = line;
			s.add(l);
		}
		return s; 
 }
 
}
