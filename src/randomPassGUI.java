import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BoxLayout;
import java.awt.Container;
import java.net.URL;
import java.awt.GridLayout;
import java.util.Random;



 class randomPassGUI implements ActionListener {

    JFrame jf;
    JPanel jp;
    JPanel jp2;
    JPanel jp3;
    JPanel jp4;
    JLabel l1;
    JLabel l2;
    JToggleButton b1;
    JToggleButton b2;
    JToggleButton b3;
    JToggleButton b4;
    JTextField tf1;
    JButton b5;
    JTextField tf2;

    

    randomPassGUI(){
        jf = new JFrame();




        jp = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        l1 = new JLabel("Random password Generator");
        l2 = new JLabel("password length");

        b1 = new JToggleButton("UpperCase");
        b1.addActionListener(this);

        b2 = new JToggleButton("LowerCase");
        b2.addActionListener(this);

        b3 = new JToggleButton("Numbers");
        b3.addActionListener(this);

        b4 = new JToggleButton("symbols");
        b4.addActionListener(this);

        b5 = new JButton("generate");
        b5.addActionListener(this);

        tf1 = new JTextField(10);
        tf1.setEditable(false);
        tf1.setBackground(Color.WHITE);
        tf1.setForeground(Color.BLACK);
        tf2 = new JTextField(10);


        jp.setLayout(new GridLayout(2,2,10,10));
        JPanel gridWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gridWrapper.add(jp);

        jp2.setLayout(new BoxLayout(jp2,BoxLayout.PAGE_AXIS));
        jp2.setAlignmentX(Component.CENTER_ALIGNMENT);

        jp4.setLayout(new FlowLayout());
        JPanel topContainer = new JPanel();
        topContainer.setLayout(new BoxLayout(topContainer, BoxLayout.Y_AXIS));

        topContainer.add(jp2);
        topContainer.add(Box.createVerticalStrut(10));
        topContainer.add(jp4);
        topContainer.add(Box.createVerticalStrut(10));


        jp4.setAlignmentX(Component.CENTER_ALIGNMENT);
        gridWrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
        jp3.setAlignmentX(Component.CENTER_ALIGNMENT);

        jp4.add(l2);
        jp4.add(tf2);
        jp3.add(b5);

        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(b4);



        jp2.add(l1);

        jp2.add(tf1);



        jf.add(topContainer, BorderLayout.NORTH);
        jf.getContentPane().add(gridWrapper,BorderLayout.CENTER);
        jf.getContentPane().add(jp3,BorderLayout.SOUTH);



        jf.setSize(400,400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
     @Override
     public void actionPerformed(ActionEvent e) {

     }
    static void main(String[] args) {
        randomPassGUI r = new randomPassGUI();
    }


 }
