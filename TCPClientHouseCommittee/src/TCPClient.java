import java.io.*; 
import java.net.*; 
import java.util.Scanner;
class TCPClient { 
	
//4- A function that receives payment details of a tenant from the house committee...
public static String payment_update() {
	String choice;
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter amount to pay, apartment number and date.");
	choice=sc.nextLine();
	return choice;
	
}
//2- A function for the months paid by the tenant by apartment number...
public static String payments_details() {
	String choice;
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter apartment number of the tenant that you want to see payments details");
	choice=sc.nextLine();
	return choice;
}
// A function that give all the option for housecommitee...
public static String housecommitee() {
	String choice,option;
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome to house commitee what option you choose:\n"
	+ "View tenant payments details Press 1.\n"
	+ "Show details of all payments in the building Press 2.\n"
	+ "Update payment to the tenant Press 3.\n"
	+ "View revenue by month Press 4.\n");
	choice=sc.nextLine();
	while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"))
	{
		System.out.println("Please enter correct option:\n"
				+ "View tenant payments details Press 1.\n"
				+ "Show details of all payments in the building Press 2.\n"
				+ "Update payment to the tenant Press 3.\n"
				+ "View revenue by month Press 4.\n");
		choice=sc.nextLine();
	}
	
	return choice;
}
// A function that get the login details to array
public static String[] Login()
	{
		String choice,connection_choice;
		String[] login_deatils=new String[3];
		String[] newpassword=new String[3];
		Scanner sc=new Scanner(System.in); //create scanner object 
		System.out.println("Please enter 1 if are you house committee or 2 if you tenant");
		choice=sc.nextLine();
		while(!choice.equals("1") && !choice.equals("2"))
		{
			System.out.println("Please enter again 1 if are you house committee or 2 if you tenant");
			choice=sc.nextLine();
		}
		System.out.println("Enter 1 for connect with your password and login.\r\n" + 
				           "Enter 2 for Select a new password");
		
		connection_choice=sc.nextLine();
		while(!choice.equals("1") && !choice.equals("2"))
		{
			System.out.println("Please enter again 1 if are you house committee or 2 if you tenant");
			connection_choice=sc.nextLine();
		}
		if(connection_choice.equals("1"))
		{
		login_deatils[0]=choice;
		System.out.println("Please enter User name...");
		login_deatils[1]=sc.nextLine();
		System.out.println("Please enter Password...");
		login_deatils[2]=sc.nextLine();
		}
		else if(connection_choice.equals("2"))
		{
			newpassword[0]="3";
			System.out.println("Please enter your user name");
			newpassword[1]=sc.nextLine();
			System.out.println("Please enter your new password");
			newpassword[2]=sc.nextLine();
			return newpassword;
			
		}
		return login_deatils;
}
                                                                                                                                                                                                                                                                                                                                                                                          
public static void main(String argv[]) 
 { 
		String[] login_deatils= Login();
        String modifiedSentence,choice;        
        try { 
        
        Socket clientSocket = new Socket("localhost", 10000); // Creates a stream socket and connects it to the specified portnumber on the named host. 
        
        
        //Open two Streams, one that sends information to the server. 
        DataOutputStream outToServer = 
          new DataOutputStream(clientSocket.getOutputStream()); 
       //One gets information from the server.
        BufferedReader inFromServer = 
          new BufferedReader(new
          InputStreamReader(clientSocket.getInputStream())); 
        
    	String res="";
		outToServer.writeBytes("0"+" "+ login_deatils[1]+" "+login_deatils[2]+"\n");
		res=inFromServer.readLine().replaceAll("#", "\n");
		//System.out.println(res.length());
		if(res.length()==19)
		{
			System.out.println("Your password is incorrect!!!\n");
			Login();
		}
		else if(res.length()>19)
		{
			System.out.println("Your password is correct!!!\n");
		}
			
		// Loop in order to have a constant connection with the server.
		while(true)
		{
			
			if(login_deatils[0].equals("1"))
			{
				choice=housecommitee();
				switch (choice) {
				case "1":
					choice=payments_details();
					outToServer.writeBytes("1"+" "+ choice+"\n"); 
					System.out.println(inFromServer.readLine().replaceAll("#", "\n"));
					break;
				case "2":
					choice="payment building";
					outToServer.writeBytes("2"+" "+ choice+"\n");
					System.out.println(inFromServer.readLine().replaceAll("#", "\n"));
					break;
			     case "3":
			    	 choice=payment_update();
			    	 outToServer.writeBytes("3"+" "+ choice+"\n");
			    	 System.out.println(inFromServer.readLine());
					break;
			     case "4":
			    	choice="sumByMonths";
			    	outToServer.writeBytes("4"+" "+ choice+"\n");
			    	System.out.println(inFromServer.readLine().replaceAll("#", "\n"));
			 		break;
				default:
					break;
				}	
			}
			else if (login_deatils[0].equals("2")) {
				outToServer.writeBytes("5"+" "+login_deatils[1]+"\n");
				System.out.println(inFromServer.readLine().replaceAll("#", "\n"));
				Login();
				}
			else if (login_deatils[0].equals("3")) {
					//
				System.out.println("6"+" "+login_deatils[1]+" "+login_deatils[2]+"\n");
					outToServer.writeBytes("6"+" "+login_deatils[1]+" "+login_deatils[2]+"\n");
					if(inFromServer.readLine().equals("1"))
					{
						System.out.println("Your password has been changed.\n");
					}
					else
						System.out.println("Your password has not been changed.\n");
					Login();
			}
			
			
		}
        
    }catch ( ConnectException e)
    {
    	System.out.println( " 404 Can't connect to the Server");
    } catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
  } 
}

