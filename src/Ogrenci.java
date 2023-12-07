import java.io.Serializable;

public class Ogrenci implements Serializable {
    private String ogrenciNo;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String ogrenciBolum;
    private String ogrenciDersler;

    public Ogrenci(String ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum, String ogrenciDersler) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.ogrenciBolum = ogrenciBolum;
        this.ogrenciDersler = ogrenciDersler;
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public void setOgrenciAd(String ogrenciAd) {
        this.ogrenciAd = ogrenciAd;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public void setOgrenciSoyad(String ogrenciSoyad) {
        this.ogrenciSoyad = ogrenciSoyad;
    }

    public String getOgrenciBolum() {
        return ogrenciBolum;
    }

    public void setOgrenciBolum(String ogrenciBolum) {
        this.ogrenciBolum = ogrenciBolum;
    }

    public String getOgrenciDersler() {
        return ogrenciDersler;
    }

    public void setOgrenciDersler(String ogrenciDersler) {
        this.ogrenciDersler = ogrenciDersler;
    }

    public String toCSV() {
        return ogrenciNo + "," + ogrenciAd + "," + ogrenciSoyad + "," + ogrenciBolum + "," + ogrenciDersler;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "ogrenciNo='" + ogrenciNo + '\'' +
                ", ogrenciAd='" + ogrenciAd + '\'' +
                ", ogrenciSoyad='" + ogrenciSoyad + '\'' +
                ", ogrenciBolum='" + ogrenciBolum + '\'' +
                ", ogrenciDersler='" + ogrenciDersler + '\'' +
                '}';
    }
}
