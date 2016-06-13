import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RankingBySmartRating implements Ranking {

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o2.getSmartRating(),o1.getSmartRating());
	}

	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<Product, Double>();
		List <Product> product = products;
		for(Product p : product) {
			double x = p.getSmartRating();
			double weight =(1-(x/100));
			result.put(p, weight);
			
		}
		
		Map <Product, Double> sortedmap = new LinkedHashMap<Product, Double>();
		SortMap c = new SortMap();
		sortedmap = c.Sortmap(result);
		return sortedmap;
	
	}
	

}
