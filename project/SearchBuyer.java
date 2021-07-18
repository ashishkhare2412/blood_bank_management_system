import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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