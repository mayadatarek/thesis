import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
public class Test {

	public static void main(String[] args) throws IOException {
	
		ReadCSV r= new ReadCSV();
		List <Product> product =r.Readcsv(25); 
		CombinedRanking t =new CombinedRanking(null);
		Map<Product, Double> k = t.rank(product);
		for (Entry<Product,Double> entry:k.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());	
	}
	}
}
