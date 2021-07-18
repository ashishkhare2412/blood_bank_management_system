import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginFrame extends JFrame{
Container c;

JButton btnLogin;
JLabel lblUsername , lblPassword;
JTextField txtUsername ;
JPasswordField pass;

LoginFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());


lblUsername = new JLabel("enter username ");
txtUsername = new JTextField(15);
lblPassword = new JLabel("enter password ");
pass = new JPasswordField(15);
btnLogin = new JButton(" login ");

c.add(lblUsername);
c.add(txtUsername);
c.add(lblPassword);
c.add(pass);
c.add(btnLogin);

ActionListener a1 =(ae)->{
String un = txtUsername.getText();
String pw = pass.getText();
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
