import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CombinedRanking implements Ranking{
	private Map<Ranking, Double> rankings;

	public CombinedRanking(Map<Ranking, Double> rankings) {
		super();
		this.setRankings(rankings);
	}

	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<Product, Double>();
		Map <Ranking, Double> ranking= rankings;  
		Map.Entry<Ranking, Double> firstList =  ranking.entrySet().iterator().next();
		Map<Product,Double> lists = new HashMap<Product,Double>();
		 lists = (Map<Product, Double>) firstList.getKey().rank(products);
		
		for (Entry<Product,Double> entry: lists.entrySet()){
			Product key = entry.getKey();
			double weight = 0.0;
			for (Entry<Ranking,Double> entry1:ranking.entrySet()){
				Ranking rank = entry1.getKey();
				Map<Product,Double> r = rank.rank(products);
				for (Entry<Product,Double> entry3: r.entrySet()){
					
					weight =+ (r.get(key)*entry1.getValue());
					break;
				}
			}
				
			result.put(key, weight);
		}
		Map <Product, Double> sortedmap = new LinkedHashMap<Product, Double>();
		SortMap sort = new SortMap();
		sortedmap = sort.Sortmap(result);
		return sortedmap;
	}
			

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<Ranking, Double> getRankings() {
		return rankings;
	}

	public void setRankings(Map<Ranking, Double> rankings) {
		this.rankings = rankings;
	}

}
