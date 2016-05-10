import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Start {

	int Id;
	int Pass;
	
	public Start(int i, int p){
		Id=i;
		Pass=p;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPass() {
		return Pass;
	}

	public void setPass(int pass) {
		Pass = pass;
	}
public String Sigin (int i , int p){
	String fileName= "Users.csv";
	   File file= new File(fileName);
	   String message = "";
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next();
	   
	   while (inputStream.hasNext()){	
	  	   String data = inputStream.next();// get line   
	  	 String [] values = data.split(";");
	  	int id = Integer.parseInt(values[0]);
	  	int pass = Integer.parseInt(values[2]);	
	  	if (i == id){
	  	if (p == pass){
	  	 message ="you have SignedIn Correctly";
	  	 break;
	  	}
	  	else {
	   message ="Sorry Incorrect Password";
	  	break;}
	   }
	   }
	  	inputStream.close();
	    
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
 }
	   return message;
	
}
public String[] getMyFriendsList (int id){
	int count = 0;
	String fileName= "conact3.csv";
	   File file= new File(fileName);
	   String [] list = null ;
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next();
	   while (inputStream.hasNext()){	
	  	   String data = inputStream.next();// get line   
	  	 String [] values = data.split(";");
	  	int i = Integer.parseInt(values[0]);
	  	if (i == id){
	  		count ++;
	  	}
	   }
	    int [] myfriends = new int [count];
	    String [] trusts = new String [count];
	    int k =0;
	     list = new String [count];
	    Scanner inputStream2 = new Scanner(file);
		   inputStream2.next();
		   while (inputStream2.hasNext()){	
		  	   String data = inputStream2.next();// get line   
		  	 String [] values = data.split(";");
		  	int i = Integer.parseInt(values[0]);
		  	int i1 = Integer.parseInt(values[1]);
		  	String  trust = values[2];
		  	if (i == id){
		  		myfriends [k] = i1;
		  		trusts [k]= trust;
		  		k ++;
		  	}
		   }
		  for (int z = 0; z < myfriends.length; z++){
			  list [z] = getName(myfriends[z]) + ".Trust Level: " + trusts[z];
		  }  
	   
	  	inputStream.close();
	  	inputStream2.close();
	    
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
}
	return list;   
	   
}

public String [] rankbyPrice (int min , int max) throws FileNotFoundException{
	 String fileName= "dataset.csv";
	   File file= new File(fileName);
	   String [] productArray = new String [getsize(file)];
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next(); // ignore the first line
	   
	   double [] prices = new double [getsize(file)];
	   double [] weight = new double [getsize(file)];
	   int i =0;
	   while (inputStream.hasNext()){	
	   String data = inputStream.next(); //  get the whole line
	   productArray[i] = data;
	   String [] values = data.split(";");
	   double price = Double.parseDouble(values[1]);
	   prices[i] = price;
	   weight[i] = (price-min)/(max-min);
	   i ++;
	   }
	   for (int x = 0 ; x < weight.length -1 ; x ++){
		            int index = x;
		            for (int j = x + 1; j < weight.length; j++)
		                if (weight[j] < weight[index])
		                    index = j;
		      
		            double smallerNumber = weight[index]; 
		            String smaller = productArray[index];
		            double smallprice = prices[index];
		            weight[index] = weight[x];
		            productArray[index] = productArray[x];
		            prices[index] = prices[x];
		            weight[x] = smallerNumber;
		            productArray[x]=smaller;
		            prices[x] = smallprice;
		        
		
	   }   
   inputStream.close();
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
}
	return productArray;   
}

public String [] RankbySmartRatings () throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader("dataset.csv"));
 	Map<String, List<String>> map = new TreeMap<String, List<String>>(Collections.reverseOrder());
     String line = reader.readLine();//read header
     String [] valx = new String [map.size()];
     while ((line = reader.readLine()) != null) {
         String key = getField(line);
         List<String> l = map.get(key);
         if (l == null) {
             l = new LinkedList<String>();
             map.put(key, l);
         }
         l.add(line);
     }

     reader.close();
     int i =0;
     List<String> myList = new ArrayList<String>();
     for (List<String> list : map.values()) {
         for (String val : list) {    
         	String[] valo =val.split(";");
         	double r = Double.parseDouble(valo[2]);
         	double weight = (1-(r/100));
         	String s = val;
         	valx [i]= s;
         	i ++;
             myList.add(s + ";"+ weight+"\n");
            // System.out.println(getweight(myList));
       //  }
         }
     }
	return valx;
 }
private static String getField(String line) {
    return line.split(";")[2];
    // extract value i want to sort on
}

public static  List<String> getweightofSmartRating (List <String> myList ){
	 
	 return myList;

	 
}
public static int getsize (File x) throws FileNotFoundException{
	   String fileName= "dataset.csv";
	   File file= new File(fileName);
	   Scanner inputStream = new Scanner(file);
	   inputStream.next();
	   int size = 0;	
	  while (inputStream.hasNext()){
   String data = inputStream.next();
   size++;
		
	     }
	  return size;
	
}


public int [] getidfriends (int id){
	int count = 0;
	String fileName= "conact3.csv";
	   File file= new File(fileName);
	   int [] myfriends = null;
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next();
	   while (inputStream.hasNext()){	
	  	   String data = inputStream.next();// get line   
	  	 String [] values = data.split(";");
	  	int i = Integer.parseInt(values[0]);
	  	if (i == id){
	  		count ++;
	  	}
	   }
	    myfriends = new int [count];
	    int k =0;
	    Scanner inputStream2 = new Scanner(file);
		   inputStream2.next();
		   while (inputStream2.hasNext()){	
		  	   String data = inputStream2.next();// get line   
		  	 String [] values = data.split(";");
		  	int i = Integer.parseInt(values[0]);
		  	int i1 = Integer.parseInt(values[1]);
		  	if (i == id){
		  		myfriends [k] = i1;
		  		k ++;
		  	}
		   }
	   
	  	inputStream.close();
	  	inputStream2.close();
	    
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
}
	return myfriends;   
	   
	
}

public int [] getallidfriends (int id , int q){
	int count = 0;
	String fileName= "conact3.csv";
	   File file= new File(fileName);
	   int [] myfriends = null;
	   int [] friends = getidfriends(id);
	   int [] fof = null;
	   int [] fofof = null;
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next(); 
	   while (inputStream.hasNext()){	
	  	   String data = inputStream.next();// get line   
	  	count ++;
	   }
	    myfriends = new int [count + 5];
	    fof = new int [count];
	    fofof = new int [count];
	    int k =0;
	    for (int y =0; y < friends.length ; y ++){
		  	myfriends [y] = friends [y];
		  	k ++;
		  	}
	    myfriends [k] = 0;
	    k++;
	    
	    Scanner inputStream2 = new Scanner(file);
		   inputStream2.next();
		   int x =0;
		   fofof [0]= 0;
		   int z =1;
		   while (inputStream2.hasNext()){	
		  	   String data = inputStream2.next();// get line   
		  	 String [] values = data.split(";");
		  	int i1 = Integer.parseInt(values[0]);
		  	int i2 = Integer.parseInt(values[1]);  	
		  	for (int d = 0 ; d < friends.length ; d ++ ){
		  		 	if (friends [d] == i1 && i2 != id ){
		  		myfriends [k] = i2;
		  		fof [x]= i2;
		  		x ++;
		  		k++; 
		  	}
		  		 	else if (i1 != id && fof[d] == i1){
		  		 	fofof [z]=	i2;
		  		 	z++;
		  		 	}
		  		
		  		
		   }
		  	
		   }
	  	inputStream.close();
	  	inputStream2.close();
	    
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
}
	 if (q==1 )
		 return myfriends; 
	 else 
		 return fofof;
}
public String [] rankbyQuality () throws FileNotFoundException{
	String fileName= "dataset.csv";
	   File file= new File(fileName);
	   String [] productArray = new String [getsize(file)];
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next(); // ignore the first line
	   
	   double [] qualities = new double [getsize(file)];
	   double [] weight = new double [getsize(file)];
	   int i =0;
	   while (inputStream.hasNext()){	
	   String data = inputStream.next(); //  get the whole line
	   productArray[i] = data;
	   String [] values = data.split(";");
	   double quality = Double.parseDouble(values[3]);
	   qualities[i] = quality;
	   weight[i] = 1-(quality/10);
	   i ++;
	   }
	
	 int x, j;
	 double index1 , index2;
	 String index3;
  for(j = 1; j < qualities.length; j++)    // Start with 1 (not 0)
 {
        index1 = qualities[j];
        index2 = weight[j];
        index3 = productArray[j];
        for(x = j - 1; (x >= 0) && (qualities[x] < index1); x--)   // Smaller values move up
       {
     	   qualities[x+1] = qualities[x];
     	   productArray[x+1] = productArray[x];
     	   weight[x+1] = weight[x];
       }
        qualities[x+1] = index1;    //Put key into its proper location
        weight[x+1] = index2;
        productArray[x+1] = index3;
 }
	   
		   
inputStream.close();
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
}
	return productArray;   
	   
}

public String [] RankbyReviews () throws FileNotFoundException{
	String fileName= "dataset.csv";
	   File file= new File(fileName);
	    String [] productArray = new String [getsize(file)];
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next(); // ignore the first line
	  
	   double [] stars = new double [getsize(file)];
	   int [] numbers = new int [getsize(file)];
	   double [] weight = new double [getsize(file)];
	   int i =0;
	   while (inputStream.hasNext()){	
	   String data = inputStream.next(); //  get the whole line
	   productArray[i] = data;
	   String [] values = data.split(";");
	   double star = Double.parseDouble(values[4]);
	   int num = Integer.parseInt(values[5]);
	   stars[i] = star;
	   numbers[i]= num;
	   weight[i] = 1-((star-1)/4);
	   i ++;
	   }
	
	 int x, j;
	 double index1 , index2;
	 String index3;
	 int key;
  for(j = 1; j < stars.length; j++)    // Start with 1 (not 0)
 {
        index1 = stars[j];
        index2 = weight[j];
        index3 = productArray[j];
        key = numbers[j];
        for(x = j - 1; (x >= 0) && (stars[x] <= index1); x--)   // Smaller values move up
       {
     	   if (stars[x]== index1){
     		   if (numbers[x]<key){
     			   stars[x+1]=stars[x];
     			   numbers[x+1]=numbers[x];
     			   productArray[x+1]=productArray[x];
     			   weight[x+1]=weight[x];
     			      
     		   }else {
     		   break;
     		    }
     	   }else{
     	   	   
     	   stars[x+1] = stars[x];
     	   productArray[x+1] = productArray[x];
     	   numbers[x+1] = numbers[x];
     	   weight[x+1]=weight[x];
       }}
        stars[x+1] = index1;    //Put key into its proper location
        weight[x+1] = index2;
        productArray[x+1] = index3;
        numbers[x+1]=key;
 } 
inputStream.close();
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
}
	return productArray;   
	   
}
	
 /*Public String [] getProductByFriends (int id){
	String fileName= "ratings.csv";
	   File file= new File(fileName);
	   int Score [] = null ;
	   String [] products = null;
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next();
	   while (inputStream.hasNext()){	
	  	   String data = inputStream.next();// get line   
	  	 String [] values = data.split(";");
	  	int i = Integer.parseInt(values[0]);
}*/

public double [] getQualityweight () throws FileNotFoundException {
	String fileName= "dataset.csv";
	   File file= new File(fileName);
	   double [] weight = new double [getsize(file)];
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next(); // ignore the first line
	   String [] productArray = new String [getsize(file)];
	   double [] qualities = new double [getsize(file)];
	   
	   double [] w = new double [getsize(file)];
	   int i =0;
	   while (inputStream.hasNext()){	
	   String data = inputStream.next(); //  get the whole line
	   productArray[i] = data;
	   String [] values = data.split(";");
	   double quality = Double.parseDouble(values[3]);
	   qualities[i] = quality;
	   weight[i] = 1-(quality/10);
	   i ++;
	   }

	   inputStream.close();
   }catch (FileNotFoundException e ){
   e.printStackTrace();
}
return weight;	
}

public String getName (int id){
	

	String fileName= "Users.csv";
	   File file= new File(fileName);
	   String Nam = "";
	   try {
	   Scanner inputStream = new Scanner(file);
	   inputStream.next();
	   while (inputStream.hasNext()){	
	  	   String data = inputStream.next();// get line   
	  	 String [] values = data.split(";");
	  	 int i = Integer.parseInt(values[0]);
	     String name = values[1];
	  if (i == id){
		  Nam = name;
		  break;
	  }
	   }
	  	inputStream.close();
	    
	   }catch (FileNotFoundException e ){
	   e.printStackTrace();
}
	   return Nam;
	
	
}
	public static void main(String[] args) throws IOException {
		 System.out.println("To Sign In ---> Please Enter Your ID: ");
	  	   Scanner sc = new Scanner(System.in);
	  	    int id =sc.nextInt();
	  	    System.out.println("please Enter Your Password:");
	  	    int pass  = sc.nextInt();
	  	    Start x = new Start (id,pass);
	  	    String y = x.Sigin(id , pass);
	  	    if (y == "you have SignedIn Correctly"){
	  	    	
	  	    } 
	  	    else {
	  	    while (y != "you have SignedIn Correctly"){
	  	     
	  	    		System.out.println(y + " please enter your ID Again :");
	  	    	      id =sc.nextInt();
	  	    	     System.out.println("please Enter Your Password:");
	  	    	     pass  = sc.nextInt();
	  	    	     y =  x.Sigin(id , pass);    	    
	  	    }
	  	    }
	  	 
	  	System.out.println(" **You have SignedIn Correctly** "
	  			+"\n"+ " -Get My Friend List (1)" + "\n" + " -Rank Products by price (2)" + "\n" 
	  			+ " -Rank Products by Quality (3)"+"\n"
	  			+ " -Rank Products by reviews (4)" +"\n" 
	  			+ "Please Enter the number of the list you want to get:");
	  	int order =sc.nextInt();
	  	if ( order == 1){
	  	String [] list = x.getMyFriendsList(id);
	  	for (int i = 0; i < list.length ; i ++){
	  		System.out.println(list[i]);
	  	}
	  	}	else if ( order == 2){
	  		System.out.println("Please Enter the minimum price you want to get : ");
	  		int min =sc.nextInt();
	  		System.out.println(" Please Enter the Maximum price :");
	  		int max =sc.nextInt();
	  		String [] products = x.rankbyPrice(min, max);
	  		System.out.println("Name;Price;SmartRating;Quality;ProductRating;NumberOfReviews");
	  		for (int i = 0; i < products.length ; i ++){
		  		System.out.println(products[i]);
		  	}
	  		
	  	}
	  	else if ( order == 3){
	  		String [] products = x.rankbyQuality();
	  		System.out.println("Name;Price;SmartRating;Quality;ProductRating;NumberOfReviews");
	  		for (int i = 0; i < products.length ; i ++){
		  		System.out.println(products[i]);
		  	}
	  	}
	  	else if ( order == 4){
	  		String [] products = x.RankbyReviews();
	  		System.out.println("Name;Price;SmartRating;Quality;ProductRating;NumberOfReviews");
	  		for (int i = 0; i < products.length ; i ++){
		  		System.out.println(products[i]);
	}
}
	}
}

	  	
	  
	  	    



