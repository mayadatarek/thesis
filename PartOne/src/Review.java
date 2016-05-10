
public class Review {
	double TrustLevel;
	double review;

	public Review( double trustLevel, double review) {
		super();
		TrustLevel = trustLevel;
		this.review = review;
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
