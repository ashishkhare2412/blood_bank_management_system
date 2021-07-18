
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
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


class LoginFrame extends JFrame{
Container c;

JButton btnLogin;
JLabel lblUsername , lblPassword;
JTextField txtUsername , txtPassword;


LoginFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());


lblUsername = new JLabel("enter username ");
txtUsername = new JTextField(15);
lblPassword = new JLabel("enter password ");
txtPassword = new JTextField(15);
btnLogin = new JButton(" login ");

c.add(lblUsername);
c.add(txtUsername);
c.add(lblPassword);
c.add(txtPassword);
c.add(btnLogin);

ActionListener a1 =(ae)->{
String un = txtUsername.getText();
String pw = txtPassword.getText();
if ((un.equals("admin")) && (pw.equals("admin"))){
	MainFrame m = new MainFrame();
	dispose();}
else
	JOptionPane.showMessageDialog(new JDialog(),"Invalid Input");
};
btnLogin.addActionListener(a1);

setTitle(" WELCOME ");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
} 
}
class MainFrame extends JFrame{
Container c;
JButton btnNewDonor,btnSearchDonor,btnSellBlood,btnSearchBuyer,btnNOBP;

MainFrame(){
c = getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.PAGE_AXIS));


btnNewDonor = new JButton("New Donor");
btnSearchDonor = new JButton("Search Donor");
btnSellBlood = new JButton("Add Recipient");
btnSearchBuyer = new JButton("Search Recipient");
btnNOBP = new JButton("No.Of.Blood Packets available");

btnNewDonor .add(Box.createRigidArea(new Dimension(120,20)));
btnSearchDonor.add(Box.createRigidArea(new Dimension(120,20)));
btnSellBlood.add(Box.createRigidArea(new Dimension(120,20)));
btnSearchBuyer.add(Box.createRigidArea(new Dimension(120,20)));
btnNOBP.add(Box.createRigidArea(new Dimension(200,20)));


Font f = new Font("Calibri" ,Font.BOLD,20);
btnNewDonor.setFont(f);
btnSearchDonor.setFont(f);
btnSellBlood.setFont(f);
btnSearchBuyer.setFont(f);
btnNOBP.setFont(f);


c.add(btnNewDonor);
c.add(Box.createRigidArea(new Dimension(0,10)));
c.add(btnSearchDonor);
c.add(Box.createRigidArea(new Dimension(0,10)));
c.add(btnSellBlood);
c.add(Box.createRigidArea(new Dimension(0,10)));
c.add(btnSearchBuyer);
c.add(Box.createRigidArea(new Dimension(0,10)));
c.add(btnNOBP);

ActionListener a1 = (ae) -> {
NewDonorFrame ndf = new NewDonorFrame();
dispose();
};
btnNewDonor.addActionListener(a1);

ActionListener a2 = (ae) -> {
SearchByFrame sbf = new SearchByFrame();
dispose();
};
btnSearchDonor.addActionListener(a2);

ActionListener a3 = (ae) -> {
SellTo st = new SellTo();
dispose();
};
btnSellBlood.addActionListener(a3);

ActionListener a4 = (ae) -> {
SearchBuyer sb = new SearchBuyer();
dispose();
};
btnSearchBuyer.addActionListener(a4);

ActionListener a5 = (ae) -> {
NOBP sb = new NOBP();
dispose();
};
btnNOBP.addActionListener(a5);


setTitle("Daily Attendance Tracker ");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class NewDonorFrame extends JFrame{
Container c;
JLabel lblDonorNo,lblDonorName,lblBloodGroup,lblSex,lblAge,lblDate,lblCity,lblMobile;
JTextField txtDonorNo,txtDonorName,txtAge,txtDate,txtCity,txtMobile;
JComboBox cbBloodGroup,cbSex;
JButton btnBack,btnSave;
NewDonorFrame(){
c = getContentPane();
GridLayout f  = new GridLayout(10,1);
c.setLayout(f);
String Sex1[] = {"Male","Female"};
cbSex = new JComboBox(Sex1);
String BloodGroup[] = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
cbBloodGroup = new JComboBox(BloodGroup);
btnBack = new JButton("Back");
btnSave = new JButton("Save");
lblDonorNo = new JLabel("Donor No.");
lblDonorName = new JLabel("Donor Name");
lblBloodGroup = new JLabel("Blood Group");
lblSex = new JLabel("Sex");
lblAge = new JLabel("Age");
lblDate = new JLabel("Date(yyyy-mm-dd)->");
lblCity = new JLabel("City");
lblMobile = new JLabel("Mobile");
txtDonorNo = new JTextField(5);
txtDonorName = new JTextField(15);
txtAge = new JTextField(5);
txtDate = new JTextField(10);
txtCity = new JTextField(10);
txtMobile = new JTextField(15);
c.add(lblDonorNo);
c.add(txtDonorNo);
c.add(lblDonorName);
c.add(txtDonorName);
c.add(lblBloodGroup);
c.add(cbBloodGroup);
c.add(lblSex);
c.add(cbSex);
c.add(lblAge);
c.add(txtAge);
c.add(lblDate);
c.add(txtDate);
c.add(lblCity);
c.add(txtCity);
c.add(lblMobile);
c.add(txtMobile);
c.add(btnBack);
c.add(btnSave);

ActionListener a1 = (ae)->{
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae)->{
int Donor_No = Integer.parseInt(txtDonorNo.getText());
String Donor_Name = txtDonorName.getText();
int index = cbBloodGroup.getSelectedIndex();
String Blood_Group = (String)cbBloodGroup.getItemAt(index);
int index1 = cbSex.getSelectedIndex();
String Sex = (String)cbSex.getItemAt(index1);
int Age = Integer.parseInt(txtAge.getText());
String Date = txtDate.getText();
String City = txtCity.getText();
long Mobile = Long.parseLong(txtMobile.getText());

DbHandler db = new DbHandler();
db.addDonor(Donor_No,Donor_Name,Blood_Group,Sex,Age,Date,City,Mobile);
};
btnSave.addActionListener(a2);

setTitle("New Donor");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

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
class SBBBNo extends JFrame{
Container c;
JTable tbData;
JLabel lblEntRno;
JTextField txtEntRno;
JButton btnBack,btnSearch;
DefaultTableModel model;
int s1;
String s2;
String s3;
String s4;
String s5;
long s6;
SBBBNo(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.LEFT));
String col_names[] = {"Recipient No.","Recipient Name","Blood Group","Date","Address","Mobile"};
model = new DefaultTableModel(0,6);
tbData = new JTable(model);
model.setColumnIdentifiers(col_names);


btnBack = new JButton("Back");
btnSearch = new JButton("Search");
lblEntRno = new JLabel("Enter Recipient No.");
txtEntRno = new JTextField(15);




c.add(new JScrollPane(tbData));
c.add(lblEntRno);
c.add(txtEntRno);
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
	int x = Integer.parseInt(txtEntRno.getText());
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	String sql = "select * from SellTo where Recipient_No = ? ";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1,x);
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

class SDBDGNo extends JFrame{
Container c;
JTable tbData;
JLabel lblEntDBG;
JComboBox cbBloodGroup;
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
SDBDGNo(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.LEFT));
String col_names[] = {"Donor No.","Donor Name","Blood Group","Sex","Age","Date","City","Mobile"};
model = new DefaultTableModel(0,8);
tbData = new JTable(model);
model.setColumnIdentifiers(col_names);

String BloodGroup[] = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
cbBloodGroup = new JComboBox(BloodGroup);
btnBack = new JButton("Back");
btnSearch = new JButton("Search");
lblEntDBG = new JLabel("Blood Group ");


c.add(new JScrollPane(tbData));
c.add(lblEntDBG);
c.add(cbBloodGroup);
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

	int index = cbBloodGroup.getSelectedIndex();
	String x = (String)cbBloodGroup.getItemAt(index);
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	String sql = "select * from New_Donor where Blood_Group = ?";
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
class SDBDNo extends JFrame{
Container c;
JTable tbData;
JLabel lblEntDno;
JTextField txtEntDno;
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
SDBDNo(){
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.LEFT));
String col_names[] = {"Donor No.","Donor Name","Blood Group","Sex","Age","Date","City","Mobile"};
model = new DefaultTableModel(0,8);
tbData = new JTable(model);
model.setColumnIdentifiers(col_names);


btnBack = new JButton("Back");
btnSearch = new JButton("Search");
lblEntDno = new JLabel("Enter Donor No.");
txtEntDno = new JTextField(15);

c.add(new JScrollPane(tbData));
c.add(lblEntDno);
c.add(txtEntDno);
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
	int x = Integer.parseInt(txtEntDno.getText());
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","abc456");
	String sql = "select * from New_Donor where Donor_No = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1,x);
	
	
	
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
class SearchBuyer extends JFrame{
Container c;
JLabel lblHead;
JRadioButton rbNo,rbName;
JButton btnSubmit,btnBack;

SearchBuyer(){
c = getContentPane();
c.setLayout(new FlowLayout());

lblHead = new JLabel("Search Recipient By ");
lblHead.setFont(new Font("Courier",Font.BOLD,20));
rbNo = new JRadioButton("Recipient No.",true);
rbName = new JRadioButton("Recipient Name");
btnSubmit = new JButton("Submit");
btnBack = new JButton("Back");

ButtonGroup bg = new ButtonGroup();
bg.add(rbNo);
bg.add(rbName);

c.add(lblHead);
c.add(rbNo);
c.add(rbName);
c.add(btnBack);
c.add(btnSubmit);


ActionListener a1 = (ae)->{
if (rbNo.isSelected()){
	SBBBNo sbbno = new SBBBNo();
	dispose(); 
}
else {
	SBBBN sbbn = new SBBBN();
	dispose();
}
};
btnSubmit.addActionListener(a1);

ActionListener a2 = (ae)->{
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a2);

setTitle("Search Buyer By ");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class SearchByFrame extends JFrame{
Container c;
JRadioButton rbDonorNo,rbGroupNo,rbDonorName;
JButton btnSubmit,btnBack;

SearchByFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());

rbDonorNo = new JRadioButton("Donor No.",true);
rbGroupNo = new JRadioButton("Blood Group No:-");
rbDonorName = new JRadioButton("Donor Name");
btnSubmit = new JButton("Submit");
btnBack = new JButton("Back");

ButtonGroup bg = new ButtonGroup();
bg.add(rbDonorNo);
bg.add(rbGroupNo);
bg.add(rbDonorName);


c.add(rbDonorNo);
c.add(rbGroupNo);
c.add(rbDonorName);
c.add(btnBack);
c.add(btnSubmit);

ActionListener a1 = (ae)->{
if (rbDonorNo.isSelected()){
	SDBDNo sbdn = new SDBDNo();
	dispose(); 
}
else if (rbGroupNo.isSelected()){
	SDBDGNo sdbg = new SDBDGNo();
	dispose();
}
else if (rbDonorName.isSelected()){
	SDBDN sdbn = new SDBDN();
	dispose();
}
else
	;

};
btnSubmit.addActionListener(a1);

ActionListener a2 = (ae)->{
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a2);

setTitle("Search By ");
setLocationRelativeTo(null);
setSize(300,300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class SellTo extends JFrame{
Container c;
JLabel lblHead,lblBlank,lblRecipientNo,lblRecipientName,lblBloodGroup,lblDate,lblAddress,lblMobile;
JTextField txtRecipientNo,txtRecipientName,txtDate,txtAddress,txtMobile;
JComboBox cbBloodGroup;
JButton btnBack,btnSubmit;
SellTo(){
c = getContentPane();
GridLayout g  = new GridLayout(10,1);
c.setLayout(g);
String BloodGroup[] = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
cbBloodGroup = new JComboBox(BloodGroup);



btnBack = new JButton("Back");
btnSubmit = new JButton("Submit");
lblHead = new JLabel("Blood Recipient Details");
lblHead.setFont(new Font("Courier",Font.BOLD,12));
lblBlank = new JLabel(" ");
lblRecipientNo = new JLabel("Recipient No.");
lblRecipientName = new JLabel("Recipient Name");
lblBloodGroup = new JLabel("Blood Group");
lblDate = new JLabel("Date(yyyy-mm-dd)->");
lblAddress = new JLabel("Address");
txtRecipientNo = new JTextField(5);
txtRecipientName = new JTextField(15);
txtDate = new JTextField(10);
txtAddress = new JTextField(10);
lblMobile = new JLabel("Mobile");
txtMobile = new JTextField(15);

Font f = new Font("Calibri" ,Font.BOLD,20);
lblHead.setFont(f);
lblBlank.setFont(f);
lblRecipientNo.setFont(f);
lblRecipientName.setFont(f);
lblBloodGroup.setFont(f);
lblDate.setFont(f);
lblAddress.setFont(f);
lblMobile.setFont(f);

c.add(lblHead);
c.add(lblBlank);
c.add(lblBlank);
c.add(lblRecipientNo);
c.add(txtRecipientNo);
c.add(lblRecipientName);
c.add(txtRecipientName);
c.add(lblBloodGroup);
c.add(cbBloodGroup);
c.add(lblDate);
c.add(txtDate);
c.add(lblAddress);
c.add(txtAddress);
c.add(lblMobile);
c.add(txtMobile);
c.add(btnBack);
c.add(btnSubmit);

ActionListener a1 = (ae)->{
MainFrame mf = new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae)->{
int Recipient_No = Integer.parseInt(txtRecipientNo.getText());
String Recipient_Name = txtRecipientName.getText();
int index = cbBloodGroup.getSelectedIndex();
String Blood_Group = (String)cbBloodGroup.getItemAt(index);
String Date = txtDate.getText();
String Address = txtAddress.getText();
long Mobile = Long.parseLong(txtMobile.getText());

DbHandler db = new DbHandler();
db.addRecipient(Recipient_No,Recipient_Name,Blood_Group,Date,Address,Mobile);
};
btnSubmit.addActionListener(a2);

setTitle("Recipient Detail ");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class Bms{
public static void main(String args[]){
LoginFrame l = new LoginFrame();
}
}

