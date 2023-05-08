package pl.com.dte;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ReklamacjePresenter
{
    private Contract.ReklamacjeFragment view;
    private ReklamacjeModel model;

    private EventBus eventBus;

    public ReklamacjePresenter(Contract.ReklamacjeFragment view)
    {
        this.view = view;

        eventBus = EventBus.getDefault();
        eventBus.register(this);

        model = new ReklamacjeModel();
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

    @Subscribe (threadMode = ThreadMode.MAIN)
    public void getBusData(List<REKLAMACJE> lista)
    {
        view.showData(lista);
    }
}
