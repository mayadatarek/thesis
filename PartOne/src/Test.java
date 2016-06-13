import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
public class Test {

	public void testit () throws IOException{
	    Login log = new Login();
	    int id = log.login1(); 
		ReadCSV r= new ReadCSV();
		List <Product> product =r.Readcsv(id);

		 List<Ranking> rankings = new LinkedList<>();
		Map<Ranking,Double> ranking = new HashMap<Ranking, Double>();
		ranking.put(new RankingByPrice(),0.20);
		ranking.put(new RankingByQuality(),0.20);
		ranking.put(new RankingBySmartRating(),0.20);
		ranking.put(new RankingByStars(),0.20);
		ranking.put(new RankByTrustLevel(),0.20);
	    rankings.add(new RankingByPrice());
	    rankings.add( new RankingByQuality());
	    rankings.add( new RankingBySmartRating());
	    rankings.add( new RankingByStars());
	    rankings.add(new RankByTrustLevel());
	  
	    rankings.add( new CombinedRanking(ranking));
	    
	    
	    System.out.println(" Welcome! " + "\n" + "Please Enter 1, IF YOU WANT TO GET YOUR SOCIAL GRAPH FRIENDS"
  	    + "\n"+ "OR" + "\n" + "PLEASE ENTER 2 TO RANK CARS BASED ON YOUR OWN PREFERENCES");	
	    Scanner sc = new Scanner(System.in);
  	    int request =sc.nextInt();
  	    if (request == 1){
  	    	 getfriends getter=new getfriends();
  	        List<Friend> res= getter.getFriends(id);
  	        for(Friend f: res)
  	        {
  	            System.out.println(f);
  	        }
  	    	
  	    }else {
  	    	System.out.println("Remember: Here are the sequence of the Perefernces that products will be ranked on, So Please take care while writing your FileNames" +
  	            "\n"+ "If you want to change the sequence"+"\n" +
			    "Please Open -Test Class- and edit the sequence" + "\n" + "Rank By Price" +"\n" + "Rank By Quality"
				+ "\n" + "Rank By Smart Rating" + "\n" + "Rank By Reviews" + "\n"+ "Rank By Reviews Of The People In Your Social Graph "
						+ "\n" + "Rank By Price(50%) and Rank By Quality(50%)" );
	    for(Ranking rank : rankings){
				Map<Product,Double> result= new HashMap<>();
				result = rank.rank(product);
				System.out.println("-: Please Enter The Name and The Place of The File That You Want To Get The Products Ranked ON IT, for example:" + "(" + "e:\\" + "\\" + "RankbyPrice.csv" + "):-");
				Scanner scc = new Scanner(System.in);
		  	    String namefile =scc.nextLine();
		  	    
				String Comma_Delma = ";";
				String New_line_Separtoer = "\n";
				String File_Header = "Id;Name;Price;Smart Rating;Quality;Stars;Number of Reviews;Weight";
				
				try {
					FileWriter writer = new FileWriter(namefile);
					writer.append(File_Header);
					for (Entry<Product,Double> entry:result.entrySet()){
						writer.append(New_line_Separtoer);
						 writer.append(Integer.toString(entry.getKey().getId()));
						 writer.append(Comma_Delma);
						 writer.append(entry.getKey().getName());
						 writer.append(Comma_Delma);
						 writer.append(String.valueOf(entry.getKey().getPrice()));
						 writer.append(Comma_Delma);
						 writer.append(String.valueOf(entry.getKey().getSmartRating()));
						 writer.append(Comma_Delma);
						 writer.append(String.valueOf(entry.getKey().getQuality()));
						 writer.append(Comma_Delma);
						 writer.append(String.valueOf(entry.getKey().getStars()));
						 writer.append(Comma_Delma);
						 writer.append(String.valueOf(entry.getKey().getNumberOfReviews()));
						 writer.append(Comma_Delma);
						 writer.append(String.valueOf(entry.getValue()));
						 
					}
						 writer.flush();
						 writer.close();
						 System.out.println("Done");				
				}
				catch (Exception e){
					System.out.println(e.getMessage());
					
				}	
		  	    
	}       
	}
	}
}