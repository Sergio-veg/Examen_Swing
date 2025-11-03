package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AñadirUsuario extends JDialog {
    private JPanel ContentLabel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton añadirUsuarioButton;
    private JLabel label1;
    private JLabel label2;

    public AñadirUsuario(JFrame parent) {
        super(parent, "Añadir Usuario", true);

        setContentPane(ContentLabel);
        setModal(true);
        pack();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        label1.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        comboBox2.setSelectedItem("");
        comboBox1.setSelectedItem("");

        añadirUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirUsuario();
            }
        });
    }

    private void añadirUsuario() {
        if (textField1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Error: El correo electrónico es obligatorio",
                    "Error de validación",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String correo = textField1.getText().trim();
        String pais = (String) comboBox2.getSelectedItem();
        String plataforma = (String) comboBox1.getSelectedItem();

        System.out.println("Usuario añadido:");
        System.out.println("  Correo: " + correo);
        System.out.println("  País: " + pais);
        System.out.println("  Plataforma: " + plataforma);

        JOptionPane.showMessageDialog(this,
                "Usuario añadido correctamente:\n" +
                        "Correo: " + correo + "\n" +
                        "País: " + pais + "\n" +
                        "Plataforma: " + plataforma,
                "Usuario Añadido",
                JOptionPane.INFORMATION_MESSAGE);

        textField1.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        AñadirUsuario dialog = new AñadirUsuario(frame);
        dialog.setVisible(true);
        System.exit(0);
    }
}

