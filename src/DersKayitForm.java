import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DersKayitForm {
    private JFrame frame;
    private JTextField dersKoduField;
    private JTextField dersAdField;
    private JTextField dersDonemField;

    public DersKayitForm() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Ders Kayıt Formu");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel() {

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(173, 216, 230)); // Açık Mavi
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        Font labelFont = new Font("Arial", Font.BOLD, 14); // Etiket fontu
        Font buttonFont = new Font("Arial", Font.BOLD, 12); // Buton fontu

        JLabel lblNewLabel = new JLabel("Ders Kodu:");
        lblNewLabel.setBounds(30, 38, 93, 16);
        lblNewLabel.setFont(labelFont);
        contentPane.add(lblNewLabel);

        dersKoduField = new JTextField();
        dersKoduField.setBounds(135, 35, 191, 22);
        contentPane.add(dersKoduField);
        dersKoduField.setColumns(10);

        JLabel lblDersAd = new JLabel("Ders Adı:");
        lblDersAd.setBounds(30, 86, 93, 16);
        lblDersAd.setFont(labelFont);
        contentPane.add(lblDersAd);

        dersAdField = new JTextField();
        dersAdField.setBounds(135, 83, 191, 22);
        contentPane.add(dersAdField);
        dersAdField.setColumns(10);

        JLabel lblDersDonem = new JLabel("Ders Dönemi:");
        lblDersDonem.setBounds(30, 134, 100, 16); // Genişlik artırıldı
        lblDersDonem.setFont(labelFont);
        contentPane.add(lblDersDonem);

        dersDonemField = new JTextField();
        dersDonemField.setBounds(135, 131, 191, 22);
        contentPane.add(dersDonemField);
        dersDonemField.setColumns(10);

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String dersKodu = dersKoduField.getText();
                String dersAd = dersAdField.getText();
                String dersDonem = dersDonemField.getText();

                Ders ders = new Ders(dersKodu, dersAd, dersDonem);

                try {
                    DosyaIO.csvOlustur(ders.toCSV(), "Veriler/dersler.csv");
                    JOptionPane.showMessageDialog(null, "Ders kaydedildi!");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ders kaydedilirken bir hata oluştu: " + e.getMessage());
                }
            }
        });
        kaydetButton.setBounds(135, 192, 150, 30);
        kaydetButton.setFont(buttonFont);
        contentPane.add(kaydetButton);
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
            new DersKayitForm().show();
        });
    }
}
