package pl.com.dte;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 String BASE_URL = "https://dte.com.pl/script/";

 Dodawanie skryptu php do adresu bazowego: @GET("komunikator.php")  -> https://dte.com.pl/komunikator.php?

 Dodanie parametrów skryptu
 Call<List<PRODUKCJA>> getData(@Query("param1") String p1, @Query("param2") String p2, @Query("param3") String param3)

 Sposób wywołania:
 Call<List<PRODUKCJA>> call = service.getData("parametr1", "parametr2", "parametr3");

 Pasek adresu wygląda wtedy tak:
 //-> https://dte.com.pl/script/komunikator.php?param1=parametr1&param2=parametr2&param3=parametr3
 **/

//Zdefiniowanie endpointów - skryptu i parametrów do odczytu lub zapisu danych
public interface GetDataService
{
    interface Produkcja
    {
        @GET("komunikator.php")
        Call<List<PRODUKCJA>> getData(@Query("param") String param);
    }

    interface Potrzeby
    {
        @GET("komunikator.php")
        Call<List<POTRZEBY>> getData(@Query("param") String param);
    }

    interface Zamowienia
    {
        @GET("komunikator.php")
        Call<List<ZAMOWIENIA>> getData(@Query("param") String param);
    }

    interface Reklamacje
    {
        @GET("komunikator.php")
        Call<List<REKLAMACJE>> getData(@Query("param") String param);
    }

    interface Projekty
    {
        @GET("komunikator.php")
        Call<List<PROJEKTY>> getData(@Query("param") String param);
    }

    interface Pomysly
    {
        @GET("komunikator.php")
        Call<List<POMYSLY>> getData(@Query("param") String param);
    }
}
