package com.example.retrofit;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdukcjaFragment extends Fragment implements Contract.ProdukcjaFragment
{
    private ProdukcjaPresenter presenter;
    RecyclerView recyclerView;

    private static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView lp, nazwa, ilosc, priorytet, data_wprowadzenia, termin_wysylki, status, data_zmiany_statusu, etap_produkcji, wiadomosc_zwrotna, uwagi;

        public MyViewHolder(@NonNull View item)
        {
            super(item);

            lp = item.findViewById(R.id.tvLp);
            nazwa = item.findViewById(R.id.tvNazwa);
            ilosc = item.findViewById(R.id.tvIlosc);
            priorytet = item.findViewById(R.id.tvPriorytet);
            data_wprowadzenia = item.findViewById(R.id.tvDataWprowadzenia);
            termin_wysylki = item.findViewById(R.id.tvTerminWysylki);
            status = item.findViewById(R.id.tvStatus);
            data_zmiany_statusu = item.findViewById(R.id.tvDataZmianyStatusu);
            etap_produkcji = item.findViewById(R.id.tvEtapProdukcji);
            wiadomosc_zwrotna = item.findViewById(R.id.tvWiadomoscZwrotna);
            uwagi = item.findViewById(R.id.tvUwagi);
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {
        private final List<PRODUKCJA> lista;

        public MyAdapter(List<PRODUKCJA> lista)
        {
            this.lista = lista;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.row_produkcja, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
        {
            int priorytet = Integer.parseInt(lista.get(position).getPriorytet());
            int status = Integer.parseInt(lista.get(position).getStatus());
            int etap_produkcji = Integer.parseInt(lista.get(position).getEtap_produkcji());
            String wiadomosc_zwrotna =lista.get(position).getWiadomosc_zwrotna();

            //Wypisanie wartości
            holder.lp.setText(String.valueOf(position+1));
            holder.nazwa.setText(lista.get(position).getNazwa());
            holder.ilosc.setText(lista.get(position).getIlosc());
            holder.priorytet.setText(presenter.getPriorytet(priorytet));
            holder.data_wprowadzenia.setText(lista.get(position).getData_wprowadzenia());
            holder.termin_wysylki.setText(lista.get(position).getTermin_wysylki());
            holder.status.setText(presenter.getStatus(status));
            holder.data_zmiany_statusu.setText(lista.get(position).getData_zmianystatusu());
            holder.etap_produkcji.setText(presenter.getEtapProdukcji(etap_produkcji));
            holder.wiadomosc_zwrotna.setText(wiadomosc_zwrotna);
            holder.uwagi.setText(lista.get(position).getUwagi());

            //-----------------------------------------------------
            //Kolorystyka
            //Priorytet
            if(priorytet == 2)
            {
              holder.lp.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
              holder.nazwa.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
              holder.ilosc.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
              holder.priorytet.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
            }
            else if (priorytet == 3)
            {
                holder.lp.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_black));
                holder.lp.setTextColor(Color.WHITE);
                holder.nazwa.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_black));
                holder.nazwa.setTextColor(Color.WHITE);
                holder.ilosc.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_black));
                holder.ilosc.setTextColor(Color.WHITE);
                holder.priorytet.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_black));
                holder.priorytet.setTextColor(Color.WHITE);
            }

            //Status
            if(status == 0)      //gotowe
                holder.status.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
            else if(status == 1) //w realizacji
                holder.status.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_yellow));
            else if(status == 2) //przeczytana
                holder.status.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_aqua));
            else if(status == 3) //nowa
                holder.status.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));

            //wizdomość zwrotna
            if(!wiadomosc_zwrotna.equals(""))
                holder.wiadomosc_zwrotna.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_aqua));
        }

        @Override
        public int getItemCount()
        {
            return lista.size();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_produkcja, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        presenter = new ProdukcjaPresenter(this);
        presenter.onCreate();

        return view;
    }

    @Override
    public void showData(List<PRODUKCJA> lista)
    {
        MyAdapter adapter = new MyAdapter(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}

