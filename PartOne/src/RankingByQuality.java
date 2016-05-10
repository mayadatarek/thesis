import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingByQuality implements Ranking {
	
	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<>();
		List <Product> pro = new ArrayList();
		pro = products;
		Collections.sort(pro, new RankingByQuality());
		for(Product p : pro) {
			double x = p.getQuality();
			double weight =1-(x/10);
			result.put(p, weight);
			
		}
		
		return result;
	}

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return 0;
	}






}
