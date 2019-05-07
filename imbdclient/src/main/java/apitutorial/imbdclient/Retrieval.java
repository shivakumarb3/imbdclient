package apitutorial.imbdclient;
import java.sql.*;

public class Retrieval  {
	public static void main(String args[])throws Exception
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imbd","root","");
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from movies");  
		while(rs.next())  
		System.out.println(rs.getString(1)); 
		con.close();
		Datamodel d=getDetails("Carmencita");
		System.out.println("rating is"+d.getRate());
		System.out.println("number of votes are"+d.getVotes());
	}
	public static String getId(String Title)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imbd","root","");
		PreparedStatement stmt=con.prepareStatement("select tconst from movies where originaltitle=?");  
		stmt.setString(1,Title);//1 specifies the first parameter in the query  
		ResultSet rs=stmt.executeQuery(); 
		rs.next();
	String res=	rs.getString(1);
	   System.out.println(res);
		  con.close();
		return res;
		
	}
	public static Datamodel getDetails(String Title)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imbd","root","");
	String id=	getId(Title);
	PreparedStatement stmt=con.prepareStatement("select * from rating where tconst=?");
	stmt.setString(1, id);
	ResultSet rs=stmt.executeQuery(); 
	rs.next();
	float rate=rs.getFloat(2);
	System.out.println(rate);
	int votes=rs.getInt(3);
	System.out.println(votes);
	Datamodel d=new Datamodel(rate,votes);
	return d;
		  
		
		
	}
	

}
