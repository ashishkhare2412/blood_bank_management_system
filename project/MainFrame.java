import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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


setTitle("Blood Bank Management ");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}