import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SqlConnection
{
	public static void main(String args[])
	{
		try{
			Connection con =DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=studentdb;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
			Statement stmt=con.createStatement();
			stmt.execute("insert into studentinfo values(1006,'ram gopal verma gf',74000)");

			ResultSet res=stmt.executeQuery("select * from studentinfo");
			
			while(res.next())
			{
				System.out.println(res.getInt(1)+","+res.getString(2)+","+res.getDouble(3));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
