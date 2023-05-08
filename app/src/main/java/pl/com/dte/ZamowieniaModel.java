package pl.com.dte;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ZamowieniaModel
{
    private EventBus eventBus;

    public ZamowieniaModel()
    {
        eventBus = EventBus.getDefault();
    }

    public void getData()
    {
        Retrofit retrofit = MyRetrofit.getRetrofitInstance();
        GetDataService.Zamowienia dataService = retrofit.create(GetDataService.Zamowienia.class);
        Call<List<ZAMOWIENIA>> call = dataService.getData("3");
        call.enqueue(new Callback<List<ZAMOWIENIA>>()
        {
            @Override
            public void onResponse(Call<List<ZAMOWIENIA>> call, Response<List<ZAMOWIENIA>> response)
            {
                if(response.body() != null)
                    eventBus.post(response.body());
            }

            @Override
            public void onFailure(Call<List<ZAMOWIENIA>> call, Throwable t)
            {

            }
        });
    }
}
