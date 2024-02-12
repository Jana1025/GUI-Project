import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame implements ActionListener {
    private JTextField txtInput;
    private JLabel lblResult;
    private JRadioButton rbCelsius, rbKelvin;

    public TemperatureConverter() {
        setTitle("Temp Conv");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        txtInput = new JTextField(10);
        panel.add(new JLabel("Enter Fahrenheit: "));
        panel.add(txtInput);

        rbCelsius = new JRadioButton("to Celsius", true);
        rbKelvin = new JRadioButton("to Kelvin", false);
        ButtonGroup selection = new ButtonGroup();
        selection.add(rbCelsius);
        selection.add(rbKelvin);
        panel.add(rbCelsius);
        panel.add(rbKelvin);

	 JButton button1 = new JButton("Show Result");
        button1.addActionListener(this);
        panel.add(button1);

        lblResult = new JLabel(" ");
        panel.add(lblResult);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Show Result")) {
            try {
                double fahrenheit = Double.parseDouble(txtInput.getText());
                double celsius = ((5.0 / 9.0) * (fahrenheit - 32));

                if (rbKelvin.isSelected()) {
                    celsius += 273.15;
                }

                lblResult.setText(String.format("Result: %.2f", celsius));
            } catch (NumberFormatException ex) {
                lblResult.setText("Invalid input!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter());
    }
}