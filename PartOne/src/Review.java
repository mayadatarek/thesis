
public class Review {
	double TrustLevel;
	double review;
	Double distance;

	public Review(double trustLevel, double review, Double distance) {
		super();
		TrustLevel = trustLevel;
		this.review = review;
		this.distance = distance;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public double getReview() {
		return review;
	}
	public void setReview(double review) {
		this.review = review;
	}
	public double getTrustLevel() {
		return TrustLevel;
	}
	public void setTrustLevel(double trustLevel) {
		TrustLevel = trustLevel;
	}
	

}
