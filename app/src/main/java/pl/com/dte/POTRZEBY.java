package pl.com.dte;

import com.google.gson.annotations.SerializedName;

public class POTRZEBY
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
    @SerializedName("Data_Wprowadzenia")
    private String data_wprowadzenia;
    @SerializedName("Priorytet")
    private String priorytet;
    @SerializedName("Status")
    private String status;
    @SerializedName("Data_ZmianyStatusu")
    private String data_zmianystatusu;
    @SerializedName("Wiadomosc_Zwrotna")
    private String wiadomosc_zwrotna;
    @SerializedName("Uwagi")
    private String uwagi;
    @SerializedName("Nadawca")
    private String nadawca;

    public POTRZEBY(String id, String nazwa, String ilosc, String data_wprowadzenia, String priorytet, String status, String data_zmianystatusu, String wiadomosc_zwrotna, String uwagi, String nadawca)
    {
        this.id = id;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.data_wprowadzenia = data_wprowadzenia;
        this.priorytet = priorytet;
        this.status = status;
        this.data_zmianystatusu = data_zmianystatusu;
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

    public String getData_wprowadzenia()
    {
        return data_wprowadzenia;
    }

    public void setData_wprowadzenia(String data_wprowadzenia)
    {
        this.data_wprowadzenia = data_wprowadzenia;
    }

    public String getPriorytet()
    {
        return priorytet;
    }

    public void setPriorytet(String priorytet)
    {
        this.priorytet = priorytet;
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
