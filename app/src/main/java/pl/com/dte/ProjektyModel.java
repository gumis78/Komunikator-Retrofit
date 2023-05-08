package pl.com.dte;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProjektyModel
{
    private EventBus eventBus;

    public ProjektyModel()
    {
        eventBus = EventBus.getDefault();
    }

    //Funkcja odczytuje dane z bazy za pomocą skryptu php
    public void getData()
    {
        Retrofit retrofit = MyRetrofit.getRetrofitInstance();
        GetDataService.Projekty dataService = retrofit.create(GetDataService.Projekty.class);
        Call<List<PROJEKTY>> call = dataService.getData("5");

        call.enqueue(new Callback<List<PROJEKTY>>()
        {
            @Override
            public void onResponse(Call<List<PROJEKTY>> call, Response<List<PROJEKTY>> response)
            {
                if(response.body()!=null)
                    eventBus.post(response.body());
            }

            @Override
            public void onFailure(Call<List<PROJEKTY>> call, Throwable t)
            {

            }
        });
    }
}
