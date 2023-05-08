package pl.com.dte;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProdukcjaModel
{
    private EventBus eventBus;

    public ProdukcjaModel()
    {
        eventBus = EventBus.getDefault();
    }

    //Funkcja odczytuje dane z bazy za pomocą skryptu php
    public void getData()
    {
        //Obiekt Retrofit
        Retrofit retrofit = MyRetrofit.getRetrofitInstance();

        //Utwórz uchwyt dla interfejsu dataService
        GetDataService.Produkcja dataService = retrofit.create(GetDataService.Produkcja.class);

        //pobranie danych (czyli uruchomienie skryptu z parametrem, tu: komunikator.php?param=1)
        Call<List<PRODUKCJA>> call = dataService.getData("1");

        //Callback reagujacy na odczyt danych zwróconych przez skrypt
        call.enqueue(new Callback<List<PRODUKCJA>>()
        {
            @Override
            public void onResponse(Call<List<PRODUKCJA>> call, Response<List<PRODUKCJA>> response)
            {
                //Przekaż do presentera listę danych z bazy (jeśli są jakieś wyniki)
                if(response.body() != null)
                    eventBus.post(response.body());
            }

            @Override
            public void onFailure(Call<List<PRODUKCJA>> call, Throwable t)
            {
                Log.i("LOGGER","error");
            }
        });
    }
}
