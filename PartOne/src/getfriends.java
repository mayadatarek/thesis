import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getfriends {
	public List<Friend> getFriends (int id) throws IOException{
		 
		 List <String> s = new ArrayList<String>();
		 ReadCSV sc = new ReadCSV();
		 s = sc.Readfile();
		 List <Friend> friends = new ArrayList<Friend>();
		 int number = s.size();
		 double distance = 0;
		 for (String st:s){
				 String [] values = st.split(";");
				 int i = Integer.parseInt(values[0]);
				 int f = Integer.parseInt(values[1]);
				 double trustLevel = Double.parseDouble(values[2]);
				 if (id == i){
					 distance = 1;
					 Friend x = new Friend (f,trustLevel,distance);
					 friends.add(x);
					for (int k =0; k < number ; k ++){
						for (String st2 : s){
							int j = Integer.parseInt(values[0]);
							int z = Integer.parseInt(values[1]);
							double trust = Double.parseDouble(values[2]);
							if (j == f && z != id){
								distance = 2;
								Friend x1 = new Friend (z,trust,distance);	
							}
						}
						
					} 
				 }
		 
		 
	 }
		return friends;
			
			
	 }

}
