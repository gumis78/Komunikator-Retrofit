package pl.com.dte;

import com.google.gson.annotations.SerializedName;

public class POMYSLY
{
    /**
     * W @SerializedName("") należy wpisać dokładną nazwę kolumny z tabeli bazy danych (wielkość liter ma znaczenie)
     * */

    @SerializedName("Id")
    private String id;
    @SerializedName("Temat")
    private String temat;
    @SerializedName("Uwagi")
    private String uwagi;
    @SerializedName("Nadawca")
    private String osoba_zglaszajaca;
    @SerializedName("Data_Wprowadzenia")
    private String data_wprowadzenia;

    public POMYSLY(String id, String temat, String uwagi, String osoba_zglaszajaca, String data_wprowadzenia)
    {
        this.id = id;
        this.temat = temat;
        this.uwagi = uwagi;
        this.osoba_zglaszajaca = osoba_zglaszajaca;
        this.data_wprowadzenia = data_wprowadzenia;
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

    public String getUwagi()
    {
        return uwagi;
    }

    public void setUwagi(String uwagi)
    {
        this.uwagi = uwagi;
    }

    public String getOsoba_zglaszajaca()
    {
        return osoba_zglaszajaca;
    }

    public void setOsoba_zglaszajaca(String osoba_zglaszajaca)
    {
        this.osoba_zglaszajaca = osoba_zglaszajaca;
    }

    public String getData_wprowadzenia()
    {
        return data_wprowadzenia;
    }

    public void setData_wprowadzenia(String data_wprowadzenia)
    {
        this.data_wprowadzenia = data_wprowadzenia;
    }
}
