import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RankingByPrice implements Ranking {

	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<Product, Double>();
		List <Product> pro =  products;
		Collections.sort(pro, new RankingByPrice());
		Product last_product = pro.get(pro.size() - 1);
		double maximum =last_product.getPrice();
		Product first_product = pro.get(0);
		double minimum =first_product.getPrice();
		for(Product product : pro) {
			double price = product.getPrice();
			double weight =(price-minimum)/(maximum-minimum);
			result.put(product, weight);	
		}
		Map <Product, Double> sortedmap = new LinkedHashMap<Product, Double>();
		SortMap c = new SortMap();
		sortedmap = c.Sortmap(result);
		return sortedmap;
	}

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

	

}
