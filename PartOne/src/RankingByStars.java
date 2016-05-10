import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class RankingByStars implements Ranking {
	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<Product, Double>();
		List <Product> pro = new ArrayList<Product>();
		pro = products;
		RankingByStars r =new RankingByStars();
		double max = r.getmax(pro);
		
		for(Product p : pro) {
			double x = p.getStars();
			double weight = 0.0;
			if (x == 5.0){
				weight = 1-((Math.pow(x,5)*p.getNumberOfReviews())-1)/(max-1);
				
			}else{
				if ((x >= 4.0) && (x < 5.0) ){
					weight = 1-((Math.pow(x,4)*p.getNumberOfReviews())-1)/(max-1);
				} else {		
					if ((x >= 3.0) && (x < 4.0) ){
						weight = 1-((Math.pow(x,3)*p.getNumberOfReviews())-1)/(max-1);	
					}
					else { 
						if ((x >= 2.0) && (x < 3.0) ){
							weight = 1-((Math.pow(x,2)*p.getNumberOfReviews())-1)/(max-1);	
						}
						else 
						{
							weight = 1-((x*p.getNumberOfReviews())-1)/(max-1);	
						}
						
					}
				}
			}	
			result.put(p, weight);	
		}
		Map <Product, Double> sortedmap = new LinkedHashMap<Product, Double>();
		SortMap c = new SortMap();
		sortedmap = c.Sortmap(result);
		return sortedmap;
	}
	
	public double getmax (List<Product> products){
		double w = 0;
		double max = 0;
		
		for (Product p : products ){	
			double x = p.getStars();
			if (x == 5.0){
				w = Math.pow(x,5)*p.getNumberOfReviews();
				
			}else{
				if ((x >= 4.0) && (x < 5.0) ){
					w = Math.pow(x,4)*p.getNumberOfReviews();
				} else {		
					if ((x >= 3.0) && (x < 4.0) ){
						w = Math.pow(x,3)*p.getNumberOfReviews();	
					}
					else { 
						if ((x >= 2.0) && (x < 3.0) ){
							w = Math.pow(x,2)*p.getNumberOfReviews();	
						}
						else 
						{
							w = x*p.getNumberOfReviews();	
						}						
					}
				}
			}
			if (max < w){
				max = w;	
			}
			
		}
		return max; 
	}

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return 0;
	}
		
	}