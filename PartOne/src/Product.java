import java.util.List;

public class Product  {
int id;
String Name;
double price;
double SmartRating;
double Quality;
double Stars;
double NumberOfReviews;
List<Review> Reviews;
public Product(int id, String name, double price, double smartRating, double quality, double stars, double numberOfReviews,
		List<Review> reviews) {
	super();
	this.id = id;
	Name = name;
	this.price = price;
	SmartRating = smartRating;
	Quality = quality;
	Stars = stars;
	NumberOfReviews = numberOfReviews;
	Reviews = reviews;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getSmartRating() {
	return SmartRating;
}
public void setSmartRating(double smartRating) {
	SmartRating = smartRating;
}
public double getQuality() {
	return Quality;
}
public void setQuality(double quality) {
	Quality = quality;
}
public double getStars() {
	return Stars;
}
public void setStars(double stars) {
	Stars = stars;
}
public double getNumberOfReviews() {
	return NumberOfReviews;
}
public void setNumberOfReviews(double numberOfReviews) {
	NumberOfReviews = numberOfReviews;
}
public List<Review> getReviews() {
	return Reviews;
}
public void setReviews(List<Review> reviews) {
	Reviews = reviews;
}
public String toString (){
			
	return "Product [Id= "+ id + ",Name=" + Name + ",Price =" + price + ", Samrt Rating=" +
SmartRating + ",Quality ="+ Quality +", Stars="+ Stars +", Numberof Reviews=" + NumberOfReviews + "]";
}





}
