package model;

import java.util.ArrayList;

public class Produkt {

    private String navn;
    private double pris;
    private String str;
    private ArrayList<StedPris> stedPriser;

    /**
     * Constructor
     *
     * @param navn
     * @param pris
     * @param str
     */
    protected Produkt(String navn, double pris, String str) { // Skal vaere private?
        this.navn = navn;
        this.pris = pris;
        this.str = str;
        stedPriser = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    /**
     * Tilfoejer en stedpris til arraylisten af stedpriser paa dette produkt.
     *
     * @param sp
     */
    public void addStedPris(StedPris sp) {
        stedPriser.add(sp);
    }

    /**
     *
     * @return en ny arraylist af produktets stedpriser
     */
    public ArrayList<StedPris> getStedPriser() {
        return new ArrayList<>(stedPriser);
    }

    /**
     * Returnerer stedprisen som double paa salgstedet i parameteren, hvis salgsstedet er i
     * arraylisten. Ellers return 0
     *
     * @param sted
     * @return
     */
    public double getStedPrisPris(SalgSted sted) {
        double stedPris = 0;
        for (int i = 0; i < stedPriser.size(); i++) {
            if (stedPriser.get(i).getSted() == sted) {
                stedPris = stedPriser.get(i).getPris();
            }
        }
        return stedPris;
    }

    /**
     * Returnerer stedprisen paa salgssedet i parameteren, hvis salgsstedet er i
     * arraylisten. Ellers return null
     *
     * @param sted
     * @return
     */
    public StedPris stedPris(SalgSted sted) {
        for (int i = 0; i < stedPriser.size(); i++) {
            if (stedPriser.get(i).getSted() == sted) {
                return stedPriser.get(i);
            }
        }
        return null;

    }

    /**
     * Fjerner stedprisen fra arraylisten, hvis salgsstedet i parameteren eksisterer
     * i arraylisten
     *
     * @param sted
     */
    public void removeStedPris(SalgSted sted) {
        for (int i = 0; i < stedPriser.size(); i++) {
            if (stedPriser.get(i).getSted() == sted) {
                stedPriser.remove(i);
            }
        }
    }

    public String toStringSted(SalgSted sted) {
        double stedPris = 0;
        for (int i = 0; i < stedPriser.size(); i++) {
            if (stedPriser.get(i).getSted() == sted) {
                stedPris = stedPriser.get(i).getPris();
            }
        }
        return navn + ", " + str + ", " + Double.toString(stedPris) + "kr.";
    }

    @Override
    public String toString() {
        return navn + ", " + str + ".";
    }

}
