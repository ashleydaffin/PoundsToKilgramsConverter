/*
* Name: Ashley Daffin
* Date: 5 Feb 2021
* Purpose: Create simple GUI that
*          converts a weight in lbs to kilograms. 
*          If input is invalid, an error message is displayed. 
 */

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PoundsToKilgramsGUI extends JFrame implements ActionListener {

    private final JTextField tfWeightInPounds;
    private final JTextField tfWeightInKilograms;
    private final JButton btnConvertToKilograms;

    PoundsToKilgramsGUI() {

        //create container
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(0, 1));

        //add components
        contentPane.add(new JLabel("Weight in pounds: "));
        tfWeightInPounds = new JTextField(20);
        tfWeightInPounds.setEditable(true);
        contentPane.add(tfWeightInPounds);

        btnConvertToKilograms = new JButton("Convert to Kilograms");
        contentPane.add(btnConvertToKilograms);

        contentPane.add(new JLabel("Weight in kilograms: "));
        tfWeightInKilograms = new JTextField(20);
        tfWeightInKilograms.setEditable(false);
        contentPane.add(tfWeightInKilograms);

        btnConvertToKilograms.addActionListener(this);

        setTitle("Pound to Kilogram Converter");
        setSize(400, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // actionPerformed for btnConvertToKilograms
    //create instance of WeightConverter class to use poundsToKilograms()
    @Override
    public void actionPerformed(ActionEvent evt) {

        //try/catch to catch a number that is not a double
        try {
            double num1, num2;
            WeightConverter convert = new WeightConverter();
            num1 = Double.parseDouble(tfWeightInPounds.getText());
            num2 = convert.convertPoundsToKilograms(num1);
            tfWeightInKilograms.setText(String.valueOf(num2));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public static void main(String[] args) {
        //
        SwingUtilities.invokeLater(() -> {
            PoundsToKilgramsGUI week4new = new PoundsToKilgramsGUI();
        });
    }
}
