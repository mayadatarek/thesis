import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reviews {
	public static void main (String [] args){
		String fileName= "dataset.csv";
		   File file= new File(fileName);
		   
		   try {
		   Scanner inputStream = new Scanner(file);
		   inputStream.next(); // ignore the first line
		   String [] productArray = new String [getsize(file)];
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
		   for (int k = 0 ; k < productArray.length -1 ; k ++){
			   
		   System.out.println(productArray[k]);
		   }
			   
	   inputStream.close();
		   }catch (FileNotFoundException e ){
		   e.printStackTrace();
	}
		   
		   
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
	}

