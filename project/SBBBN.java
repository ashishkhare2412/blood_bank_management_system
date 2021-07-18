import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class SBBBN extends JFrame{
Container c;
JTable tbData;
JLabel lblEntName;
JTextField txtEntName;
JButton btnBack,btnSearch;
DefaultTableModel model;
int s1;
String s2;
String s3;
String s4;
String s5;
long s6;
SBBBN(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.LEFT));
String col_names[] = {"Recipient No.","Recipient Name","Blood Group","Date","Address","Mobile"};
model = new DefaultTableModel(0,6);
tbData = new JTable(model);
model.setColumnIdentifiers(col_names);


btnBack = new JButton("Back");
btnSearch = new JButton("Search");
lblEntName = new JLabel("Enter Recipient Name.");
txtEntName = new JTextField(15);



c.add(new JScrollPane(tbData));
c.add(lblEntName);
c.add(txtEntName);
c.add(btnSearch);
c.add(btnBack);
tbData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
tbData.getColumnModel().getColumn(1).setPreferredWidth(120);
tbData.getColumnModel().getColumn(5).setPreferredWidth(150);
ActionListener a1 = (ae)->{
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae)->{
try{
	String x = txtEntName.getText();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	String sql = "select * from SellTo where Recipient_Name = ? ";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1,x);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		s1 = rs.getInt(1);
		s2 = rs.getString(2);
		s3 = rs.getString(3);
		s4 = rs.getString(4);
		s5 = rs.getString(5);
		s6 = rs.getLong(6);
		model.addRow(new Object[] {s1,s2,s3,s4,s5,s6});
	}
	con.close();
}
catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
};
btnSearch.addActionListener(a2);

setTitle("Recipient Details");
setSize(550,550);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}