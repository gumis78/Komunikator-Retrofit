package pl.com.dte;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ReklamacjeModel
{
    private EventBus eventBus;

    public ReklamacjeModel()
    {
        eventBus = EventBus.getDefault();
    }

    public void getData()
    {
        Retrofit retrofit = MyRetrofit.getRetrofitInstance();
        GetDataService.Reklamacje dataService = retrofit.create(GetDataService.Reklamacje.class);
        Call<List<REKLAMACJE>> call = dataService.getData("4");

        call.enqueue(new Callback<List<REKLAMACJE>>()
        {
            @Override
            public void onResponse(Call<List<REKLAMACJE>> call, Response<List<REKLAMACJE>> response)
            {
                if(response.body() != null)
                    eventBus.post(response.body());
            }

            @Override
            public void onFailure(Call<List<REKLAMACJE>> call, Throwable t)
            {

            }
        });
    }
}
