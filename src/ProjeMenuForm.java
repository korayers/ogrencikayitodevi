import javax.swing.*;
import java.awt.*;

public class ProjeMenuForm {
    private JFrame frame;
    private JButton dersKayitButton;
    private JButton ogrenciKayitButton;

    public ProjeMenuForm() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Proje Menü");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.getContentPane().setBackground(new Color(173, 216, 230));

        dersKayitButton = new JButton("Ders Kayıt Formu");
        dersKayitButton.addActionListener(e -> {
            DersKayitForm dersKayitForm = new DersKayitForm();
            dersKayitForm.show();
        });

        dersKayitButton.setBounds(100, 50, 400, 80);
        dersKayitButton.setBackground(new Color(135, 206, 250));
        dersKayitButton.setFont(new Font("Arial", Font.BOLD, 20));

        frame.getContentPane().add(dersKayitButton);

        ogrenciKayitButton = new JButton("Öğrenci Kayıt Formu");
        ogrenciKayitButton.addActionListener(e -> {
            OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm();
            ogrenciKayitForm.show();
        });
        ogrenciKayitButton.setBounds(100, 150, 400, 80);
        ogrenciKayitButton.setBackground(new Color(135, 206, 250));
        ogrenciKayitButton.setFont(new Font("Arial", Font.BOLD, 20));

        frame.getContentPane().add(ogrenciKayitButton);
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            ProjeMenuForm projeMenuForm = new ProjeMenuForm();
            projeMenuForm.show();
        });
    }
}
