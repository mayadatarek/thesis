import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingByPrice implements Ranking {

	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<>();
		List <Product> pro = new ArrayList();
		pro = products;
		Collections.sort(pro, new RankingByPrice());
		Product ma = pro.get(pro.size() - 1);
		double max =ma.getPrice();
		Product mi = pro.get(0);
		double min =mi.getPrice();
		for(Product p : pro) {
			double x = p.getPrice();
			double weight =(x-min)/(max-min);
			result.put(p, weight);
			
		}
		
		return result;
	}

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

	

}
