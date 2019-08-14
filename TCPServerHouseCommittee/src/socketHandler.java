import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

// create a thread that connect to the client...
public class socketHandler extends Thread  {
    Socket incoming;
    Sql s;
   
    // constructor that get two object.
    socketHandler(Socket _in,Sql s)
    {
        this.incoming=_in;
        this.s=s;
    }


public void run()
{
		int res;
        String choice,resultToclient;
    	BufferedReader inFromClient = null;
        DataOutputStream outToClient = null ;
        try {
        	// s.insert_statement("ooo", "choen", "123456789", "mr.beni","1234",2);
            inFromClient = new  BufferedReader (new InputStreamReader(incoming.getInputStream()));
            
//            choice=inFromClient.readLine();
//            System.out.println(inFromClient.readLine()+" "+"im in from client");
            outToClient = new DataOutputStream(new DataOutputStream(incoming.getOutputStream()));
            
            
            while(true) {
            	
            	choice=inFromClient.readLine();
                
            	switch (choice.charAt(0))
            	{
            	case '0':
            		System.out.println(choice.split(" ")[1]+" "+choice.split(" ")[2]);
					resultToclient= s.check_password(choice.split(" ")[1],choice.split(" ")[2]);
					System.out.println(resultToclient);
					outToClient.writeBytes(resultToclient+"\n");
					break;
				case '1':
					//System.out.println(choice.split(" ")[1]);
					resultToclient= s.query_paymentbytenat(choice.split(" ")[1]);
					//System.out.println(resultToclient);
					outToClient.writeBytes(resultToclient+"\n");
					break;
				case '2':
					//System.out.println(choice.split(" ")[1]);
					resultToclient= s.all_tenants();
					//System.out.println(resultToclient);
					outToClient.writeBytes(resultToclient+"\n");
					break;
		        case '3':
		        	//System.out.println(choice);
		        	//System.out.println(choice.split(" ")[1]);
					s.update_tenants(Integer.parseInt(choice.split(" ")[1]),Integer.parseInt(choice.split(" ")[2]),choice.split(" ")[3]);
					resultToclient="Payment has been updated";
					outToClient.writeBytes(resultToclient+"\n");
					break;
			     case '4':
//			    	System.out.println(choice.split(" ")[1]);
					resultToclient= s.monthly_income();
					//System.out.println(resultToclient);
					outToClient.writeBytes(resultToclient+"\n");
			 		break;
				case '5':
					System.out.println(choice.split(" ")[1]);
					resultToclient= s.payment_of_tenants(choice.split(" ")[1]);
					System.out.println(resultToclient);
					outToClient.writeBytes(resultToclient+"\n");
				case '6':
					System.out.println(choice.split(" ")[1]+choice.split(" ")[2]);
					res=s.change_password(choice.split(" ")[2],choice.split(" ")[1]);
					resultToclient=String.valueOf(res);
					System.out.println(resultToclient);
					outToClient.writeBytes(resultToclient+"\n");
				default:
					break;
            	}
            	
            }
        }
         catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
}
}
 
