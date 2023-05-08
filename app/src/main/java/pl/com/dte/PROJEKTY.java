package pl.com.dte;

import com.google.gson.annotations.SerializedName;

public class PROJEKTY
{
    /**
     * W @SerializedName("") należy wpisać dokładną nazwę kolumny z tabeli bazy danych (wielkość liter ma znaczenie)
     * */
    @SerializedName("Id")
    private String id;
    @SerializedName("Osoba_Odpowiedzialna")
    private String osoba_odpowiedzialna;
    @SerializedName("Temat")
    private String temat;
    @SerializedName("Data_Wprowadzenia")
    private String data_wprowadzenia;
    @SerializedName("Data_Zakonczenia")
    private String data_zakonczenia;
    @SerializedName("Stopien_Zaawansowania")
    private String stopien_zaawansowania;
    @SerializedName("Data_Zmiany_Statusu")
    private String data_zmiany_statusu;
    @SerializedName("Uwagi")
    private String uwagi;

    public PROJEKTY(String id, String osoba_odpowiedzialna, String temat, String data_wprowadzenia, String data_zakonczenia, String stopien_zaawansowania, String data_zmiany_statusu, String uwagi)
    {
        this.id = id;
        this.osoba_odpowiedzialna = osoba_odpowiedzialna;
        this.temat = temat;
        this.data_wprowadzenia = data_wprowadzenia;
        this.data_zakonczenia = data_zakonczenia;
        this.stopien_zaawansowania = stopien_zaawansowania;
        this.data_zmiany_statusu = data_zmiany_statusu;
        this.uwagi = uwagi;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getOsoba_odpowiedzialna()
    {
        return osoba_odpowiedzialna;
    }

    public void setOsoba_odpowiedzialna(String osoba_odpowiedzialna)
    {
        this.osoba_odpowiedzialna = osoba_odpowiedzialna;
    }

    public String getTemat()
    {
        return temat;
    }

    public void setTemat(String temat)
    {
        this.temat = temat;
    }

    public String getData_wprowadzenia()
    {
        return data_wprowadzenia;
    }

    public void setData_wprowadzenia(String data_wprowadzenia)
    {
        this.data_wprowadzenia = data_wprowadzenia;
    }

    public String getData_zakonczenia()
    {
        return data_zakonczenia;
    }

    public void setData_zakonczenia(String data_zakonczenia)
    {
        this.data_zakonczenia = data_zakonczenia;
    }

    public String getStopien_zaawansowania()
    {
        return stopien_zaawansowania;
    }

    public void setStopien_zaawansowania(String stopien_zaawansowania)
    {
        this.stopien_zaawansowania = stopien_zaawansowania;
    }

    public String getData_zmiany_statusu()
    {
        return data_zmiany_statusu;
    }

    public void setData_zmiany_statusu(String data_zmiany_statusu)
    {
        this.data_zmiany_statusu = data_zmiany_statusu;
    }

    public String getUwagi()
    {
        return uwagi;
    }

    public void setUwagi(String uwagi)
    {
        this.uwagi = uwagi;
    }
}
