package pl.com.dte;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ProjektyPresenter
{
    private Contract.ProjektyFragment view;
    private ProjektyModel model;

    private EventBus eventBus;

    public ProjektyPresenter(Contract.ProjektyFragment view)
    {
        this.view = view;
        model = new ProjektyModel();

        eventBus = EventBus.getDefault();
        eventBus.register(this);
    }

    public void onCreate()
    {
        //Czytaj dane z bazy
        model.getData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getBusData(List<PROJEKTY> lista)
    {
        view.showData(lista);
    }
}
