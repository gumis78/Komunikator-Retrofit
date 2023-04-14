package pl.com.dte;

import com.google.gson.annotations.SerializedName;

public class PRODUKCJA
{
    /**
     * W @SerializedName("") należy wpisać dokładną nazwę kolumny z tabeli bazy danych (wielkość liter ma znaczenie)
     * */

    @SerializedName("Id")
    private String id;
    @SerializedName("Nazwa")
    private String nazwa;
    @SerializedName("Ilosc")
    private String ilosc;
    @SerializedName("Priorytet")
    private String priorytet;
    @SerializedName("Data_Wprowadzenia")
    private String data_wprowadzenia;
    @SerializedName("Termin_Wysylki")
    private String termin_wysylki;
    @SerializedName("Status")
    private String status;
    @SerializedName("Data_ZmianyStatusu")
    private String data_zmianystatusu;
    @SerializedName("Etap_Produkcji")
    private String etap_produkcji;
    @SerializedName("Wiadomosc_Zwrotna")
    private String wiadomosc_zwrotna;
    @SerializedName("Uwagi")
    private String uwagi;
    @SerializedName("Nadawca")
    private String nadawca;

    public PRODUKCJA(String id, String nazwa, String ilosc, String priorytet, String data_wprowadzenia, String termin_wysylki, String status, String data_zmianystatusu, String etap_produkcji, String wiadomosc_zwrotna, String uwagi, String nadawca)
    {
        this.id = id;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.priorytet = priorytet;
        this.data_wprowadzenia = data_wprowadzenia;
        this.termin_wysylki = termin_wysylki;
        this.status = status;
        this.data_zmianystatusu = data_zmianystatusu;
        this.etap_produkcji = etap_produkcji;
        this.wiadomosc_zwrotna = wiadomosc_zwrotna;
        this.uwagi = uwagi;
        this.nadawca = nadawca;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public void setNazwa(String nazwa)
    {
        this.nazwa = nazwa;
    }

    public String getIlosc()
    {
        return ilosc;
    }

    public void setIlosc(String ilosc)
    {
        this.ilosc = ilosc;
    }

    public String getPriorytet()
    {
        return priorytet;
    }

    public void setPriorytet(String priorytet)
    {
        this.priorytet = priorytet;
    }

    public String getData_wprowadzenia()
    {
        return data_wprowadzenia;
    }

    public void setData_wprowadzenia(String data_wprowadzenia)
    {
        this.data_wprowadzenia = data_wprowadzenia;
    }

    public String getTermin_wysylki()
    {
        return termin_wysylki;
    }

    public void setTermin_wysylki(String termin_wysylki)
    {
        this.termin_wysylki = termin_wysylki;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getData_zmianystatusu()
    {
        return data_zmianystatusu;
    }

    public void setData_zmianystatusu(String data_zmianystatusu)
    {
        this.data_zmianystatusu = data_zmianystatusu;
    }

    public String getEtap_produkcji()
    {
        return etap_produkcji;
    }

    public void setEtap_produkcji(String etap_produkcji)
    {
        this.etap_produkcji = etap_produkcji;
    }

    public String getWiadomosc_zwrotna()
    {
        return wiadomosc_zwrotna;
    }

    public void setWiadomosc_zwrotna(String wiadomosc_zwrotna)
    {
        this.wiadomosc_zwrotna = wiadomosc_zwrotna;
    }

    public String getUwagi()
    {
        return uwagi;
    }

    public void setUwagi(String uwagi)
    {
        this.uwagi = uwagi;
    }

    public String getNadawca()
    {
        return nadawca;
    }

    public void setNadawca(String nadawca)
    {
        this.nadawca = nadawca;
    }
}

