package pl.com.dte;

import java.util.List;

public interface Contract
{
    interface ProdukcjaFragment
    {
        void showData(List<PRODUKCJA> lista);
    }

    interface PotrzebyFragment
    {
        void showData(List<POTRZEBY> lista);
    }

    interface ZamowieniaFragment
    {
        void showData(List<ZAMOWIENIA> lista);
    }

    interface ReklamacjeFragment
    {
        void showData(List<REKLAMACJE> lista);
    }

    interface ProjektyFragment
    {
        void showData(List<PROJEKTY> lista);
    }

    interface PomyslyFragment
    {
        void showData(List<POMYSLY> lista);
    }
}
