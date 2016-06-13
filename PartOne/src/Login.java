import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
	
	int login1 (){
		System.out.println("To Sign In ---> Please Enter Your ID: ");
		   Scanner sc = new Scanner(System.in);
		    int username =sc.nextInt();
		    System.out.println("please Enter Your Password:");
		    int password  = sc.nextInt();
		    String y = login2(username , password);
		    if (y == "you have SignedIn Correctly"){
		    	return username;
		    } 
		    else {
		    while (y != "you have SignedIn Correctly"){
		     
		    		System.out.println(y + " please enter your ID Again :");
		    	      username =sc.nextInt();
		    	     System.out.println("please Enter Your Password:");
		    	     password  = sc.nextInt();
		    	     y =  login2(username , password);    	    
		    }
		    }
		    return 0;
	}
	String login2 (int i , int p){
		String fileName= "UserPass.csv";
		   File file= new File(fileName);
		   String message = "";
		   try {
		   Scanner inputStream = new Scanner(file);
		   inputStream.next();
		   
		   while (inputStream.hasNext()){	
		  	   String data = inputStream.next();// get line   
		  	 String [] values = data.split(";");
		  	int id = Integer.parseInt(values[0]);
		  	int pass = Integer.parseInt(values[1]);	
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

}
