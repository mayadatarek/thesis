import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RankingByStars implements Ranking {
	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<Product, Double>();
		List <Product> product = products;
		RankingByStars get_max_stars =new RankingByStars();
		double max = get_max_stars.getmax(product);
		
		for(Product p : product) {
			double stars = p.getStars();
			double weight = 0.0;
			if (stars == 5.0){
				weight = 1-((Math.pow(stars,4)*p.getNumberOfReviews())-1)/(max-1);
				
			}else{
				if ((stars >= 4.0) && (stars < 5.0) ){
					weight = 1-((Math.pow(stars,3)*p.getNumberOfReviews())-1)/(max-1);
				} else {		
					if ((stars >= 3.0) && (stars < 4.0) ){
						weight = 1-((Math.pow(stars,2)*p.getNumberOfReviews())-1)/(max-1);	
					}
					else { 
						if ((stars >= 2.0) && (stars < 3.0) ){
							weight = 1-((Math.pow(stars,1)*p.getNumberOfReviews())-1)/(max-1);	
						}
						else 
						{
							weight = 1-((stars*p.getNumberOfReviews())-1)/(max-1);	
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
		double weight = 0;
		double max = 0;
		
		for (Product p : products ){	
			double stars = p.getStars();
			if (stars == 5.0){
				weight = Math.pow(stars,5)*p.getNumberOfReviews();
				
			}else{
				if ((stars >= 4.0) && (stars < 5.0) ){
					weight = Math.pow(stars,4)*p.getNumberOfReviews();
				} else {		
					if ((stars >= 3.0) && (stars < 4.0) ){
						weight = Math.pow(stars,3)*p.getNumberOfReviews();	
					}
					else { 
						if ((stars >= 2.0) && (stars < 3.0) ){
							weight = Math.pow(stars,2)*p.getNumberOfReviews();	
						}
						else 
						{
							weight = stars*p.getNumberOfReviews();	
						}						
					}
				}
			}
			if (max < weight){
				max = weight;	
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