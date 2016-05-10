
public class Friend {
int id;
double trustlevel;
double distance;
public Friend(int id, double trustlevel, double distance) {
	super();
	this.id = id;
	this.trustlevel = trustlevel;
	this.distance = distance;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getTrustlevel() {
	return trustlevel;
}
public void setTrustlevel(double trustlevel) {
	this.trustlevel = trustlevel;
}
public double getDistance() {
	return distance;
}
public void setDistance(double distance) {
	this.distance = distance;
}
}

