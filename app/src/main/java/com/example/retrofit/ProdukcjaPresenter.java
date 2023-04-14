package com.example.retrofit;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ProdukcjaPresenter
{
    private Contract.ProdukcjaFragment view;
    private ProdukcjaModel model;
    private EventBus eventBus;

    public ProdukcjaPresenter(Contract.ProdukcjaFragment view)
    {
        this.view = view;
        eventBus = EventBus.getDefault();
        eventBus.register(this);

        model = new ProdukcjaModel();
    }

    public void onCreate()
    {
        //Czytaj dane z bazy
        model.getData();
    }

    //
    public String getPriorytet(int p)
    {
        String ret = "normalny";

        switch(p)
        {
            case 0: ret = "niski"; break;
            case 1: ret = "normalny"; break;
            case 2: ret = "wysoki"; break;
            case 3: ret = "zapłacone"; break;
        }

        return ret;
    }

    //
    public String getStatus(int p)
    {
        String ret = "gotowe";

        switch(p)
        {
            case 0: ret = "gotowe"; break;
            case 1: ret = "w realizacji"; break;
            case 2: ret = "przeczytana"; break;
            case 3: ret = "nowa"; break;
        }

        return ret;
    }

    //
    public String getEtapProdukcji(int p)
    {
        String ret = "produkcja I";

        switch(p)
        {
            case 0: ret = "produkcja I"; break;
            case 1: ret = "programowanie"; break;
            case 2: ret = "produkcja II"; break;
            case 3: ret = "przekazano do wysyłki"; break;
        }

        return ret;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getBusData(List<PRODUKCJA> lista)
    {
        //Wyświetl listę
        view.showData(lista);
    }
}
