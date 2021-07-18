import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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