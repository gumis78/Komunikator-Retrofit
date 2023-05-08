package pl.com.dte;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PotrzebyModel
{
    private EventBus eventBus;

    public PotrzebyModel()
    {
        eventBus = EventBus.getDefault();
    }

    public void getData()
    {
        Retrofit retrofit = MyRetrofit.getRetrofitInstance();
        GetDataService.Potrzeby dataService = retrofit.create(GetDataService.Potrzeby.class);

        Call<List<POTRZEBY>> call = dataService.getData("2");
        call.enqueue(new Callback<List<POTRZEBY>>()
        {
            @Override
            public void onResponse(Call<List<POTRZEBY>> call, Response<List<POTRZEBY>> response)
            {
                if(response.body() != null)
                    eventBus.post(response.body());
            }

            @Override
            public void onFailure(Call<List<POTRZEBY>> call, Throwable t)
            {
                Log.i("LOGGER","error");
            }
        });
    }
}
