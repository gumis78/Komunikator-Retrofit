package pl.com.dte;

import com.google.gson.annotations.SerializedName;

public class REKLAMACJE
{
    /**
     * W @SerializedName("") należy wpisać dokładną nazwę kolumny z tabeli bazy danych (wielkość liter ma znaczenie)
     * */
    @SerializedName("Id")
    private String id;
    @SerializedName("Sprawa")
    private String temat;
    @SerializedName("Termin")
    private String termin;
    @SerializedName("Priorytet")
    private String priorytet;
    @SerializedName("Osoba_Odpowiedzialna")
    private String osoba_odpowiedzialna;
    @SerializedName("Status")
    private String status;
    @SerializedName("Data_ZmianyStatusu")
    private String data_zmianystatusu;
    @SerializedName("Wiadomosc_Zwrotna")
    private String wykonana_naprawa;
    @SerializedName("Uwagi")
    private String zglaszane_problemy;
    @SerializedName("Naprawe_Pokrywa")
    private String koszt_ponosi;
    @SerializedName("Data_Wprowadzenia")
    private String data_wprowadzenia;
    @SerializedName("Osoba_Zglaszajaca")
    private String osoba_zglaszajaca;

    public REKLAMACJE(String id, String temat, String termin, String priorytet, String osoba_odpowiedzialna, String status, String data_zmianystatusu, String wykonana_naprawa, String zglaszane_problemy, String koszt_ponosi, String data_wprowadzenia, String osoba_zglaszajaca)
    {
        this.id = id;
        this.temat = temat;
        this.termin = termin;
        this.priorytet = priorytet;
        this.osoba_odpowiedzialna = osoba_odpowiedzialna;
        this.status = status;
        this.data_zmianystatusu = data_zmianystatusu;
        this.wykonana_naprawa = wykonana_naprawa;
        this.zglaszane_problemy = zglaszane_problemy;
        this.koszt_ponosi = koszt_ponosi;
        this.data_wprowadzenia = data_wprowadzenia;
        this.osoba_zglaszajaca = osoba_zglaszajaca;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTemat()
    {
        return temat;
    }

    public void setTemat(String temat)
    {
        this.temat = temat;
    }

    public String getTermin()
    {
        return termin;
    }

    public void setTermin(String termin)
    {
        this.termin = termin;
    }

    public String getPriorytet()
    {
        return priorytet;
    }

    public void setPriorytet(String priorytet)
    {
        this.priorytet = priorytet;
    }

    public String getOsoba_odpowiedzialna()
    {
        return osoba_odpowiedzialna;
    }

    public void setOsoba_odpowiedzialna(String osoba_odpowiedzialna)
    {
        this.osoba_odpowiedzialna = osoba_odpowiedzialna;
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

    public String getWykonana_naprawa()
    {
        return wykonana_naprawa;
    }

    public void setWykonana_naprawa(String wykonana_naprawa)
    {
        this.wykonana_naprawa = wykonana_naprawa;
    }

    public String getZglaszane_problemy()
    {
        return zglaszane_problemy;
    }

    public void setZglaszane_problemy(String zglaszane_problemy)
    {
        this.zglaszane_problemy = zglaszane_problemy;
    }

    public String getKoszt_ponosi()
    {
        return koszt_ponosi;
    }

    public void setKoszt_ponosi(String koszt_ponosi)
    {
        this.koszt_ponosi = koszt_ponosi;
    }

    public String getData_wprowadzenia()
    {
        return data_wprowadzenia;
    }

    public void setData_wprowadzenia(String data_wprowadzenia)
    {
        this.data_wprowadzenia = data_wprowadzenia;
    }

    public String getOsoba_zglaszajaca()
    {
        return osoba_zglaszajaca;
    }

    public void setOsoba_zglaszajaca(String osoba_zglaszajaca)
    {
        this.osoba_zglaszajaca = osoba_zglaszajaca;
    }
}
