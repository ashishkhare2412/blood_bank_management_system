import java.sql.*;
import javax.swing.*;
class DbHandler{
public static void addDonor(int Donor_No , String Donor_Name, String Blood_Group,String Sex,int Age,String Date,String City,long Mobile){
try{
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	String sql = "insert into New_Donor values(?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1,Donor_No);
	pstmt.setString(2,Donor_Name);
	pstmt.setString(3,Blood_Group);
	pstmt.setString(4,Sex);
	pstmt.setInt(5,Age);
	pstmt.setString(6,Date);
	pstmt.setString(7,City);
	pstmt.setLong(8,Mobile);
	pstmt.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(),"record inserted ");
	con.close();
}
catch(SQLException se)
{
	JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}

}


public static void addRecipient(int Recipient_No , String Recipient_Name, String Blood_Group,String Date,String Address,long Mobile){
try{
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	String sql = "insert into SellTo values(?,?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1,Recipient_No);
	pstmt.setString(2,Recipient_Name);
	pstmt.setString(3,Blood_Group);
	pstmt.setString(4,Date);
	pstmt.setString(5,Address);
	pstmt.setLong(6,Mobile);
	pstmt.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(),"record inserted ");
	con.close();
}
catch(SQLException se)
{
	JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
}
}