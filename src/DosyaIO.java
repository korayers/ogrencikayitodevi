import java.io.*;

public class DosyaIO {

    public static void seriOlustur(String veri, String dosyaAdi) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dosyaAdi, true))) {
            writer.println(veri); // Yeni satır
            System.out.println("Dosya oluşturuldu: " + dosyaAdi);
        } catch (IOException e) {
            throw new IOException("Dosya oluşturulurken bir hata oluştu.", e);
        }
    }

    public static Object seriOku(String dosyaAdi) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dosyaAdi))) {
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void csvOlustur(String veri, String dosyaAdi) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dosyaAdi, true))) {
            writer.println(veri); // Yeni satır
            System.out.println("Dosya oluşturuldu: " + dosyaAdi);
        } catch (IOException e) {
            throw new IOException("Dosya oluşturulurken bir hata oluştu.", e);
        }
    }

    public static String[] csvOku(String dosyaAdi) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String line = reader.readLine();
            if (line != null) {
                return line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
