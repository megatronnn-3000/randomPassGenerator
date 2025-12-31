import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

class randomPassGUI implements ActionListener {

    JFrame jf;
    JPanel jp, jp2, jp3, jp4;
    JLabel l1, l2;
    JToggleButton b1, b2, b3, b4;
    JTextField tf1, tf2;
    JButton b5;

    randomPassGUI() {
        jf = new JFrame("Password Generator");

        jp = new JPanel(new GridLayout(2, 2, 10, 10));
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        l1 = new JLabel("Random Password Generator");
        l1.setFont(new Font("Arial", Font.BOLD, 16));

        l2 = new JLabel("Password Length:");

        b1 = new JToggleButton("Uppercase");
        b2 = new JToggleButton("Lowercase");
        b3 = new JToggleButton("Numbers");
        b4 = new JToggleButton("Symbols");

        b5 = new JButton("Generate");

        tf1 = new JTextField(15);
        tf1.setEditable(false);

        tf2 = new JTextField("8", 5);

        b5.addActionListener(this);

        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(b4);

        jp2.add(l1);
        jp2.add(tf1);

        jp4.add(l2);
        jp4.add(tf2);

        jf.setLayout(new BorderLayout(10, 10));
        jf.add(jp2, BorderLayout.NORTH);
        jf.add(jp, BorderLayout.CENTER);
        jf.add(jp4, BorderLayout.WEST);
        jf.add(b5, BorderLayout.SOUTH);

        jf.setSize(800, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b5) {
            int length;

            try {
                length = Integer.parseInt(tf2.getText());
                if (length <= 0) throw new NumberFormatException();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jf, "Enter a valid length!");
                return;
            }

            StringBuilder pool = new StringBuilder();

            if (b1.isSelected()) pool.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            if (b2.isSelected()) pool.append("abcdefghijklmnopqrstuvwxyz");
            if (b3.isSelected()) pool.append("0123456789");
            if (b4.isSelected()) pool.append("!@#$%^&*()-_=+[]{};:,.<>?/");

            if (pool.length() == 0) {
                JOptionPane.showMessageDialog(jf, "Select at least one option!");
                return;
            }

            Random random = new Random();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(pool.length());
                password.append(pool.charAt(index));
            }

            tf1.setText(password.toString());
        }
    }

    public static void main(String[] args) {
        new randomPassGUI();
    }
}