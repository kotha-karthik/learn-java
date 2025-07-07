/*
$ transactions : is a set of statements which are exectued as a group. if all statements execution is success then the transactions is success if any one of the statement execution failed then we need to cancel the transactions.
		--on success we use to commit the chnages to the database.
		
		--on failure we use to roll back the changes made to the database.
*/
import java.sql.*;
import java.sql.*;
import java.util.Scanner;

class TransactionsDemo {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Connect to the database
            con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost\\sqlexpress;databaseName=pratice;integratedSecurity=true;encrypt=true;trustServerCertificate=true"
            );

            con.setAutoCommit(false);  // Start transaction default true so we need to keep false

            // Input details
            System.out.println("Enter debitor account number:");
            int debit = sc.nextInt();

            System.out.println("Enter creditor account number:");
            int credit = sc.nextInt();

            System.out.println("Enter amount to transfer:");
            double amount = sc.nextDouble();

           
            ps = con.prepareStatement("UPDATE bank SET amount = amount - ? WHERE accno = ? AND amount >= ?");
            ps.setDouble(1, amount);
            ps.setInt(2, debit);
            ps.setDouble(3, amount);
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                
                ps = con.prepareStatement("UPDATE bank SET amount = amount + ? WHERE accno = ?");
                ps.setDouble(1, amount);
                ps.setInt(2, credit);
                rowsUpdated = ps.executeUpdate();

                if (rowsUpdated > 0) {
                    con.commit();
                    System.out.println("Transaction Successful.");
                } else {
                    System.out.println("Crediting failed. Rolling back...");
                    con.rollback();
                }
            } else {
                System.out.println("Debiting failed. Rolling back...");
                con.rollback();
            }

        } catch (Exception ex) {
            try {
                if (con != null) con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) 
					ps.close();
                if (con != null) 
					con.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
