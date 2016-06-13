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
	         double distance = 1;
	         for (String st:s){
	                 String [] values = st.split(";");
	                 int i = Integer.parseInt(values[0]);
	                 int f = Integer.parseInt(values[1]);
	                 double trustLevel = Double.parseDouble(values[2]);
	                 if (id == i){
	                     distance = 1;
	                     Friend x = new Friend (f,trustLevel,distance);
	                     friends.add(x);                   
	                 }
	                 else
	                 {
	                     double dista=findInFriends(friends,i);
	                     double distb=findInFriends(friends,f);
	                     Friend x=null;
	                     if(dista!=-1 && distb!=-1) continue;
	                     else if(distb==-1)
	                     {
	                        x = new Friend (f,trustLevel,1+dista);
	                     }
	                     else
	                     {
	                        x = new Friend (i,trustLevel,1+distb);
	                     }
	                     friends.add(x); 
	                 }   
	        }  
	        return friends;                  
	     }

	    private double findInFriends(List<Friend> friends, int f) {
	        for(int i=friends.size()-1;i>=0;i--)
	        {
	            if(friends.get(i).getId()==f) return friends.get(i).getDistance();
	        }
	        return -1;
	    }

}
