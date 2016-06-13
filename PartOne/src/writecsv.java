import java.io.FileWriter;
import java.util.Map;
import java.util.Map.Entry;

public class writecsv {
	
public void writeCsv (Map<Product,Double> result, String sfilename){
	String Comma_Delma = ",";
	String New_line_Separtoer = "\n";
	String File_Header = "Id, Name,Price,Smart Rating, Quality, Stars, Number of Reviews";
	
	try {
		FileWriter writer = new FileWriter(sfilename);
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
			 writer.append(String.valueOf(entry.getKey().getNumberOfReviews()));
		}
			 writer.flush();
			 writer.close();
			 System.out.print("Done");
			 
			 
			 
			
		
	}
	catch (Exception e){
		System.out.println(e.getMessage());
		
	}
		



}
}

