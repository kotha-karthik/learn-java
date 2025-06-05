import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
// CURD operations in SQL
class SqlConnection
{
	public static void main(String args[]) 
	{
		String name;
		int id;
		double fee;
		try{
			Connection con =DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress;databaseName=studentdb;integratedSecurity=true;encrypt=true;trustServerCertificate=true");
			PreparedStatement pstmt=con.prepareStatement("insert into studentinfo values(?,?,?)");
			Statement	stmt=con.createStatement();
			//create
			for(int i=0;i<2;i++)
			{
				System.out.println("Enter the id:");
				id=Integer.parseInt(System.console().readLine());
				System.out.println("Enter your name:");
				name=System.console().readLine();
				System.out.println("Enter your fee:");
				fee=Double.parseDouble(System.console().readLine());
				
				//stmt.execute("INSERT INTO studentinfo(sno, sname, fee) VALUES (" + id + ", '" + name + "', " + fee + ")");
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setDouble(3,fee);
				pstmt.execute();
			}
			//Read
			
			ResultSet res=stmt.executeQuery("select * from studentinfo");
			while(res.next())
			{
				System.out.println(res.getInt(1)+","+res.getString(2)+","+res.getDouble(3));
			}
			//update
			System.out.println("Enter id to update");
			int updateid=Integer.parseInt(System.console().readLine());
			System.out.println("Enter 1 to update the name\n Enter 2 to update the fee");
			int choice;
			choice=Integer.parseInt(System.console().readLine());
			if(choice==1)
			{
				System.out.println("Enter your name:");
				String updatename=System.console().readLine();
				stmt.executeUpdate("UPDATE studentinfo SET sname = '" + updatename + "' WHERE sno = " + updateid);

			}
			else if(choice==2)
			{
				System.out.println("Enter your fee:");
				Double updatefee=Double.parseDouble(System.console().readLine());
				stmt.executeUpdate("update studentinfo set fee='"+updatefee+"'WHERE sno="+updateid);
			}
			
			//delete
			System.out.println("Enter id to delete row");
			int deleteid=Integer.parseInt(System.console().readLine());
			stmt.execute("delete from studentinfo  where sno="+deleteid);
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

/*
	1. special characters or binary data or large amt of data cant be inserted using statement.
	


*/
