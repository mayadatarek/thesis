import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CombinedRanking implements Ranking{
	private Map<Ranking, Double> rankings;

	public CombinedRanking(Map<Ranking, Double> rankings) {
		super();
		this.rankings = rankings;
	}

	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<Product, Double>();
		List <Product> pro = new ArrayList<Product>();
		pro = products;
		RankByTrustLevel t =new RankByTrustLevel();
		RankingByPrice t1 =new RankingByPrice();
		RankingByQuality t2 =new RankingByQuality();
		RankingByStars t3 =new RankingByStars();
		RankingBySmartRating t4 =new RankingBySmartRating();
		Map<Product, Double> k = t.rank(pro);
		Map<Product, Double> k1 = t1.rank(pro);
		Map<Product, Double> k2 = t2.rank(pro);
		Map<Product, Double> k3 = t3.rank(pro);
		Map<Product, Double> k4 = t4.rank(pro);
		double total = 0; 
		for (Entry<Product,Double> entry:k.entrySet()){
			Product p = entry.getKey();
			total = (0.2*entry.getValue()) +(0.2* k1.get(p)) +(0.2* k2.get(p)) 
					+(0.2*k3.get(p)) +(0.2* k4.get(p));	
		result.put(p, total);
		}
		Map <Product, Double> sortedmap = new LinkedHashMap<Product, Double>();
		SortMap c = new SortMap();
		sortedmap = c.Sortmap(result);
		return sortedmap;
	}
			

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
