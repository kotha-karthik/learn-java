import java.sql.*;
class CallableStatementDemo
{
	public static void main(String[] args)
	{
		Connection con;
		CallableStatement cs;
		ResultSet res;
		try
		{
			con = DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=pratice;integratedSecurity=true;encrypt=true;trustServerCertificate=true");

			cs=con.prepareCall("{call AllRec}");
			res=cs.executeQuery();
			while(res.next())
			{
				System.out.println(res.getInt(1)+","+res.getString(2)+","+res.getDouble(3));
			}
			res.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
