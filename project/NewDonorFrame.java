import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
