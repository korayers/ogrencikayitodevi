import java.io.Serializable;

public class Ders implements Serializable {
    private String dersKodu;
    private String dersAd;
    private String dersDonem;

    public Ders(String dersKodu, String dersAd, String dersDonem) {
        this.dersKodu = dersKodu;
        this.dersAd = dersAd;
        this.dersDonem = dersDonem;
    }



    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public String getDersDonem() {
        return dersDonem;
    }

    public void setDersDonem(String dersDonem) {
        this.dersDonem = dersDonem;
    }
    public String toCSV() {
        return dersKodu + "," + dersAd + "," + dersDonem ;
    }

    public String toString() {
        return "Ders{" +
                "dersKodu='" + dersKodu + '\'' +
                ", dersAd='" + dersAd + '\'' +
                ", dersDonem='" + dersDonem + '\'' +
                '}';
    }
}
