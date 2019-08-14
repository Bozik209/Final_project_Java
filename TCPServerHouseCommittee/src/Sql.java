import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Sql {	
	
private static Connection connect;

public static String executequery(PreparedStatement statement)
{
	try {
		ResultSet result = statement.executeQuery();
		return returnToclient(statement,result);
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public static String returnToclient(PreparedStatement statement,ResultSet result) throws SQLException
{
	
	String rtc="";
	ResultSetMetaData meta=(ResultSetMetaData) statement.getMetaData();
	int amount = meta.getColumnCount();
	String name[] = new String[amount+1];
	for(int i = 1;i<=amount;i++) {
	name[i] = meta.getColumnName(i);
	System.out.print(name[i] + " ");
	rtc+=name[i] + " ";
	}
	rtc+="#";
	//System.out.println(amount);
	
	while(result.next()) // take the rows in the result set
	{
		for(int i=1;i<=amount;i++) {
		rtc+=result.getString(i) + "          | ";
		//getString(i) - take the col number i 
		System.out.print("\n"+result.getString(i) + " | ");
	}
		System.out.println("\n------------------------------");
		rtc+="#------------------------------#";
	}
	System.out.println(rtc);
	return rtc;
}
public static void insert_Person(String s1, String s2,String s3,String s4,String s5,int s6){
	     
	String sqlInsert = "insert into javaproject.person(FirstName,LastName,idNumber,UserName,Password,Role) values (?,?,?,?,?,?)";

	try {
		PreparedStatement pst = connect.prepareStatement(sqlInsert);
		pst.setString(1, s1);
		pst.setString(2, s2);
		pst.setString(3, s3);
		pst.setString(4, s4);
		pst.setString(5, s5);
		pst.setInt(6, s6);
		
		pst.execute();
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
//query option 1 - houseCommittee
public static String query_paymentbytenat(String s1) {
	String sqlSelect =  "select sum(payments.paymentSum) as \"payment\" ,MONTH(payments.paymentDate) as \"Paid month\" ,tenant.apartmentNumber\r\n" + 
			"from payments\r\n" + 
			"JOIN tenant ON tenant.id = payments.idTenants\r\n" + 
			"where tenant.apartmentNumber=? \r\n" + 
			"GROUP BY payments.paymentDate;";
	try {
		PreparedStatement statement= connect.prepareStatement(sqlSelect);
		statement.setString(1, s1);
		return executequery(statement);
}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}

//query option 2 - houseCommittee 
public static String all_tenants() {
	String sqlSelect =  "select person.FirstName,person.LastName, payments.paymentSum ,payments.paymentDate ,tenant.apartmentNumber\r\n" + 
			"from person\r\n" + 
		    "INNER JOIN payments ON person.id=payments.idTenants\r\n" + 
			"LEFT JOIN tenant on person.id=tenant.id;";

	try {
		
		PreparedStatement statement= connect.prepareStatement(sqlSelect);
		
		return executequery(statement);
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	
}
// query option 3 - houseCommittee 
// amount to pay=n1,aparment number=n2,date=s3.
public static void update_tenants(int n1, int n2,String s3) {
	String sqlInsert =  "INSERT INTO `javaproject`.`payments`\r\n" + 
			"(`paymentSum`,`idTenants`,`paymentDate`)\r\n" + 
			"VALUES\r\n" + 
			"(?,(select Personid from tenant where apartmentNumber=?),?)\r\n" + 
			";";
	
	try {	
		PreparedStatement pst = connect.prepareStatement(sqlInsert);
		pst.setInt(1, n1);// paymentSum
		pst.setInt(2, n2);// apartmentNumber
		pst.setString(3,s3);// paymentDate
		pst.execute();
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
		
}
//query option 4 - houseCommittee 
public static String monthly_income() {
	String sqlSelect =  "SELECT MONTH(paymentDate),SUM(paymentSum)\r\n" + 
			"FROM payments\r\n" + 
			"GROUP BY MONTH(paymentDate);";
	
	try {
		PreparedStatement statement= connect.prepareStatement(sqlSelect);
		return executequery(statement);
}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
//query option 5 - tenant
public static String payment_of_tenants(String s1) {
	String sqlSelect =  "select person.id,person.FirstName,payments.paymentSum, MONTH(payments.paymentDate)\r\n" + 
			"from payments \r\n" + 
			"INNER JOIN person ON person.UserName=?\r\n" + 
			"GROUP BY MONTH(paymentDate);";
	
	try {
		
		PreparedStatement statement= connect.prepareStatement(sqlSelect);
		statement.setString(1, s1);
		return executequery(statement);
}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	
}
//check password
public static String check_password(String s1,String s2) {
	String sqlSelect="SELECT username,Password FROM javaproject.person WHERE username = ? AND Password = ?;";
	try {
		System.out.print(s1+" "+s2);
		PreparedStatement statement= connect.prepareStatement(sqlSelect);
		statement.setString(1, s1);
		statement.setString(2, s2);
		return executequery(statement);
		
}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
//change password
public static int change_password(String s1,String s2) {
	String sqlupdate="UPDATE javaproject.person SET Password=? WHERE username = ?;";
	try {
		
		PreparedStatement statement= connect.prepareStatement(sqlupdate);
		statement.setString(1, s1);
		statement.setString(2, s2);
		//statement.execute();
		int result = statement.executeUpdate();
		return result;
}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return 0;
}
public static void insert_tenant(int n1,int n2){
    
	String sqlInsert = "insert into javaproject.tenant(`Personid`,`apartmentNumber`) values (?,?)";

	try {
		PreparedStatement pst = connect.prepareStatement(sqlInsert);
		pst.setInt(1, n1);
		pst.setInt(2, n2);
		pst.execute();
	} catch (SQLException e) {
		System.out.println("no such a user name");
		e.printStackTrace();
	}
}
public static void insert_committee(int n1,int n2){
    
	String sqlInsert = "insert into javaproject.committee(`Personid`,`Seniority`) values (?,?)";

	try {
		PreparedStatement pst = connect.prepareStatement(sqlInsert);
		pst.setInt(1, n1);
		pst.setInt(2, n2);
		pst.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void connection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// connect to the driver jar file mysql connector 
			System.out.println("Works");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
public static void ConectingToSQL (){
	
	connection();
	String host = "jdbc:mysql://localhost:3306/javaproject?serverTimezone=UTC";
	String username = "root";//user name
	String password = "";// empty
	
	try {
		 connect = (Connection) DriverManager.getConnection(host, username, password);
	System.out.println("work");
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
}


