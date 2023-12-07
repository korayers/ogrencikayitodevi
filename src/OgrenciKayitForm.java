import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OgrenciKayitForm {
    private JFrame frame;
    private JTextField ogrenciNoField;
    private JTextField ogrenciAdField;
    private JTextField ogrenciSoyadField;
    private JTextField ogrenciBolumField;
    private JComboBox<String> derslerComboBox;

    public OgrenciKayitForm() {
        initialize();
        initializeDerslerComboBox();
    }

    private void initialize() {
        frame = new JFrame("Öğrenci Kayıt Formu");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2)); // 5 satır, 2 sütunlu bir düzen
        panel.setBackground(new Color(173, 216, 230)); // Açık Mavi

        Font labelFont = new Font("Arial", Font.BOLD, 14); // Etiket fontu

        JLabel ogrenciNoLabel = new JLabel("Öğrenci No:");
        ogrenciNoLabel.setFont(labelFont);
        panel.add(ogrenciNoLabel);

        ogrenciNoField = new JTextField();
        panel.add(ogrenciNoField);

        JLabel ogrenciAdLabel = new JLabel("Öğrenci Adı:");
        ogrenciAdLabel.setFont(labelFont);
        panel.add(ogrenciAdLabel);

        ogrenciAdField = new JTextField();
        panel.add(ogrenciAdField);

        JLabel ogrenciSoyadLabel = new JLabel("Öğrenci Soyadı:");
        ogrenciSoyadLabel.setFont(labelFont);
        panel.add(ogrenciSoyadLabel);

        ogrenciSoyadField = new JTextField();
        panel.add(ogrenciSoyadField);

        JLabel ogrenciBolumLabel = new JLabel("Bölüm:");
        ogrenciBolumLabel.setFont(labelFont);
        panel.add(ogrenciBolumLabel);

        ogrenciBolumField = new JTextField();
        panel.add(ogrenciBolumField);

        JLabel derslerLabel = new JLabel("Dersler:");
        derslerLabel.setFont(labelFont);
        panel.add(derslerLabel);

        derslerComboBox = new JComboBox<>();
        derslerComboBox.setForeground(Color.BLACK); // Yazı rengini siyah yapma
        panel.add(derslerComboBox);

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                kaydetButtonActionPerformed(arg0);
            }
        });
        kaydetButton.setBackground(new Color(135, 206, 250)); // Mavi
        kaydetButton.setForeground(Color.BLACK); // Yazı rengini siyah yapma
        kaydetButton.setPreferredSize(new Dimension(200, 40)); // 200 genişlik, 40 yükseklik
        kaydetButton.setFont(new Font("Arial", Font.BOLD, 16)); // 16 büyüklük, kalın font

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(kaydetButton, BorderLayout.SOUTH);
    }

    private void initializeDerslerComboBox() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Veriler/dersler.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dersBilgileri = line.split(",");
                derslerComboBox.addItem(dersBilgileri[0]); // Ders adını ComboBox'a ekleyin
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dersler dosyası bulunamadı veya açılamadı: " + e.getMessage());
        }
    }

    private void kaydetButtonActionPerformed(ActionEvent arg0) {
        String ogrenciNo = ogrenciNoField.getText();
        String ogrenciAd = ogrenciAdField.getText();
        String ogrenciSoyad = ogrenciSoyadField.getText();
        String ogrenciBolum = ogrenciBolumField.getText();
        String ogrenciDersler = (String) derslerComboBox.getSelectedItem();

        Ogrenci ogrenci = new Ogrenci(ogrenciNo, ogrenciAd, ogrenciSoyad, ogrenciBolum, ogrenciDersler);

        try {
            DosyaIO.csvOlustur(ogrenci.toCSV(), "Veriler/ogrenciler.csv");
            JOptionPane.showMessageDialog(null, "Öğrenci kaydedildi!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Öğrenci kaydedilirken bir hata oluştu!");
        }
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
            new OgrenciKayitForm().show();
        });
    }
}
