import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RankByTrustLevel implements Ranking{
	@Override
	public Map<Product, Double> rank(List<Product> products) {
		Map<Product, Double> result= new HashMap<Product, Double>();
		List <Product> pro = new ArrayList<Product>();
		pro = products;
        double Finalweight = 0;
		for(Product p : pro) {
			List <Review> review = p.getReviews();
			double total = 0.0;
			double weight = 0.0;
			for (Review r1 : review){
			double x = r1.getTrustLevel();
			if (x == 5.0){
				if (r1.getDistance() == 1){
				weight = ((x * r1.getReview())*5)*2;
				}else{
					weight = (x * r1.getReview())*5;
				}
				
				total = total+ weight;
			}else{
				if ((x >= 4.0) && (x < 5.0) ){
					if (r1.getDistance() == 1){
						weight = ((x * r1.getReview())*4)*2;
					}else{
					weight = ((x * r1.getReview())*4);}
					total = total+ weight;
				} else {		
					if ((x >= 3.0) && (x < 4.0) ){
						if (r1.getDistance() == 1){ weight = ((x * r1.getReview())*3)*2;}
						else{
							weight = ((x * r1.getReview())*3);
						}
						total = total+ weight;
					}
					else { 
						if ((x >= 2.0) && (x < 3.0) ){
							if (r1.getDistance() == 1){weight = ((x * r1.getReview())*2)*2;}
							else{
								weight = ((x * r1.getReview())*2);
							}	
							total = total+ weight;
						}
						else 
						{
							if (r1.getDistance() == 1) {weight = (x * r1.getReview())*2;}
							else {
								weight = x * r1.getReview();
							}
							
							total = total+ weight;
						}
						
					}
				}
			}
			
			Finalweight= total;
			
			}	
			result.put(p, Finalweight);	
			
		}
		List<Entry<Product,Double>> list = new LinkedList<Entry<Product,Double>>(result.entrySet());
		Collections.sort(list, new Comparator<Entry<Product, Double>>()
		{
			public int compare(Entry<Product,Double> o1, Entry<Product, Double>o2){
				return Double.compare(o2.getValue(),o1.getValue());}});
		Map <Product, Double> sortedmap = new LinkedHashMap<Product, Double>();
		double maximum = 0;
		for (Entry<Product,Double> entry : list){
			if (maximum < entry.getValue()){
				maximum = entry.getValue();
				break;
			}
		}
		for (Entry<Product,Double> entry : list){
			double v = 1-((entry.getValue()-1)/(maximum-1));
			sortedmap.put(entry.getKey(), v);
		}
		return sortedmap;
	}

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}