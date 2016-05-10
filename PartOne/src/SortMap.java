import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMap {
	public Map<Product,Double> Sortmap (Map<Product, Double> result)
	{
		List<Entry<Product,Double>> list = new LinkedList<Entry<Product,Double>>(result.entrySet());
		Collections.sort(list, new Comparator<Entry<Product, Double>>()
		{
			public int compare(Entry<Product,Double> o1, Entry<Product, Double>o2){
				return Double.compare(o1.getValue(),o2.getValue());
			}
		});
		
		Map <Product, Double> sortedmap = new LinkedHashMap<Product, Double>();
		for (Entry<Product,Double> entry : list){
			sortedmap.put(entry.getKey(), entry.getValue());
		}
		
		
		return sortedmap;
}
}