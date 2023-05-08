package pl.com.dte;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PomyslyModel
{
    private EventBus eventBus;

    public PomyslyModel()
    {
        eventBus = EventBus.getDefault();
    }

    public void getData()
    {
        Retrofit retrofit = MyRetrofit.getRetrofitInstance();
        GetDataService.Pomysly dataService = retrofit.create(GetDataService.Pomysly.class);
        Call<List<POMYSLY>> call = dataService.getData("6");

        call.enqueue(new Callback<List<POMYSLY>>()
        {
            @Override
            public void onResponse(Call<List<POMYSLY>> call, Response<List<POMYSLY>> response)
            {
                if(response.body() != null)
                    eventBus.post(response.body());
            }

            @Override
            public void onFailure(Call<List<POMYSLY>> call, Throwable t)
            {

            }
        });

    }
}
