import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class SDBDN extends JFrame{
Container c;
JTable tbData;
JLabel lblEntDN;
JTextField txtEntDN;
JButton btnBack,btnSearch;
DefaultTableModel model;
int s1 ;
String s2;
String s3;
String s4;
int s5;
String s6;
String s7;
long s8 ;
SDBDN(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.LEFT));
String col_names[] = {"Donor No.","Donor Name","Blood Group","Sex","Age","Date","City","Mobile"};
model = new DefaultTableModel(0,8);
tbData = new JTable(model);
model.setColumnIdentifiers(col_names);


btnBack = new JButton("Back");
btnSearch = new JButton("Search");
lblEntDN = new JLabel("Enter Donor Name");
txtEntDN = new JTextField(15);

c.add(new JScrollPane(tbData));
c.add(lblEntDN);
c.add(txtEntDN);
c.add(btnSearch);
c.add(btnBack);
tbData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
tbData.getColumnModel().getColumn(1).setPreferredWidth(120);




ActionListener a1 = (ae)->{
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae)->{
try{
	String x = txtEntDN.getText();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	String sql = "select * from New_Donor where Donor_Name = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1,x);
	
	
	
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		s1 = rs.getInt(1);
		s2 = rs.getString(2);
		s3 = rs.getString(3);
		s4 = rs.getString(4);
		s5 = rs.getInt(5);
		s6 = rs.getString(6);
		s7 = rs.getString(7);
		s8 = rs.getLong(8);
		model.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7,s8});
			}
con.close();
	}
catch(SQLException se)
{
	JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
};
btnSearch.addActionListener(a2);


setTitle("Donor Details");
setSize(500,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}