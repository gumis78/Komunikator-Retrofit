package pl.com.dte;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class PomyslyPresenter
{
    private Contract.PomyslyFragment view;
    private PomyslyModel model;
    private EventBus eventBus;

    public PomyslyPresenter(Contract.PomyslyFragment view)
    {
        this.view = view;
        model = new PomyslyModel();

        eventBus = EventBus.getDefault();
        eventBus.register(this);
    }

    public void onCreate()
    {
        model.getData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getBusData(List<POMYSLY> lista)
    {
        view.showData(lista);
    }
}
