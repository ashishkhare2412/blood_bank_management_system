import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class NOBP extends JFrame{
Container c;
JTable tbNOBP;
JButton btnBack,btnSearch;
DefaultTableModel model;
int s1;
int s2;
int s3;
int s4;
int s5;
int s6;
int s7;
int s8;


NOBP(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.LEFT));
String col_names[] = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
//String data[][] = {{"A+","0"},{"A-","0"},{"B+","0"},{"B-","0"},{"O+","0"},{"O-","0"},{"AB+","0"},{"AB-","0"}};
model = new DefaultTableModel(0,8);
tbNOBP = new JTable(model);
model.setColumnIdentifiers(col_names);
btnBack = new JButton("Back");
btnSearch = new JButton("Search");
c.add(new JScrollPane(tbNOBP));
c.add(btnSearch);
c.add(btnBack);

ActionListener a2 = (ae)->{
try{
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	
	
	CallableStatement cstmt = con.prepareCall("{call p1(?,?,?,?,?,?,?,?)}");
	cstmt.registerOutParameter(1,Types.INTEGER);
	cstmt.registerOutParameter(2,Types.INTEGER);
	cstmt.registerOutParameter(3,Types.INTEGER);
	cstmt.registerOutParameter(4,Types.INTEGER);
	cstmt.registerOutParameter(5,Types.INTEGER);
	cstmt.registerOutParameter(6,Types.INTEGER);
	cstmt.registerOutParameter(7,Types.INTEGER);
	cstmt.registerOutParameter(8,Types.INTEGER);
	cstmt.executeUpdate();
	int s1 = cstmt.getInt(1);
	int s2 = cstmt.getInt(2);
	int s3 = cstmt.getInt(3);
	int s4 = cstmt.getInt(4);
	int s5 = cstmt.getInt(5);
	int s6 = cstmt.getInt(6);
	int s7 = cstmt.getInt(7);
	int s8 = cstmt.getInt(8);

	model.addRow(new Object[] {s1,s2,s3,s4,s5,s6,s7,s8} );
	con.close();
	}
	

catch(SQLException se)
{
JOptionPane.showMessageDialog(new JDialog(),"issue"+se);
}
};
btnSearch.addActionListener(a2);

ActionListener a1 = (ae)->{
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

setTitle("NO.OF.Blood Packets ");
setSize(500,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}