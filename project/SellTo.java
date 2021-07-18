import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
