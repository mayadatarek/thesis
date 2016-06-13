import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface Ranking extends Comparator <Product>{
	 Map<Product, Double> rank(List<Product> products);
	

}
