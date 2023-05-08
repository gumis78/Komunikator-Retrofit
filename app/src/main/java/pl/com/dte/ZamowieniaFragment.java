package pl.com.dte;

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

public class ZamowieniaFragment extends Fragment implements Contract.ZamowieniaFragment
{
    private ZamowieniaPresenter presenter;
    private RecyclerView recyclerView;

    private static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView lp, nazwa, ilosc, dostawca, priorytet, status, data_zmiany_statusu, wiadomosc_zwrotna, uwagi, data_wprowadzenia;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            lp = itemView.findViewById(R.id.tvLp);
            nazwa = itemView.findViewById(R.id.tvNazwa);
            ilosc = itemView.findViewById(R.id.tvIlosc);
            dostawca = itemView.findViewById(R.id.tvDostawca);
            priorytet = itemView.findViewById(R.id.tvPriorytet);
            status = itemView.findViewById(R.id.tvStatus);
            data_zmiany_statusu = itemView.findViewById(R.id.tvDataZmianyStatusu);
            wiadomosc_zwrotna = itemView.findViewById(R.id.tvWiadomoscZwrotna);
            uwagi = itemView.findViewById(R.id.tvUwagi);
            data_wprowadzenia = itemView.findViewById(R.id.tvDataWprowadzenia);
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {
        List<ZAMOWIENIA> lista;

        public MyAdapter(List<ZAMOWIENIA> lista)
        {
            this.lista = lista;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.row_zamowienia, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
        {
            int priorytet = Integer.parseInt(lista.get(position).getPriorytet());
            int status = Integer.parseInt(lista.get(position).getStatus());
            String wiadomosc_zwrotna = lista.get(position).getWiadomosc_zwrotna();

            //Wypisanie wartości
            holder.lp.setText(String.valueOf(position+1));
            holder.nazwa.setText(lista.get(position).getNazwa());
            holder.ilosc.setText(lista.get(position).getIlosc());
            holder.dostawca.setText(lista.get(position).getDostawca());
            holder.priorytet.setText(presenter.getPriorytet(priorytet));
            holder.status.setText(presenter.getStatus(status));
            holder.data_zmiany_statusu.setText(lista.get(position).getData_zmianystatusu());
            holder.wiadomosc_zwrotna.setText(lista.get(position).getWiadomosc_zwrotna());
            holder.uwagi.setText(lista.get(position).getUwagi());
            holder.data_wprowadzenia.setText(lista.get(position).getData_wprowadzenia());

            //-----------------------------------------------------
            //Kolorystyka
            //Priorytet
            if(priorytet == 2)
            {
                holder.lp.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
                holder.nazwa.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
                holder.ilosc.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
                holder.dostawca.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
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
                holder.dostawca.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_black));
                holder.dostawca.setTextColor(Color.WHITE);
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
            {
                if(status == 0)      //gotowe
                    holder.wiadomosc_zwrotna.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                else if(status == 1) //w realizacji
                    holder.wiadomosc_zwrotna.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_yellow));
                else if(status == 2) //przeczytana
                    holder.wiadomosc_zwrotna.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_aqua));
                else if(status == 3) //nowa
                    holder.wiadomosc_zwrotna.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
            }
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
        View view = inflater.inflate(R.layout.fragment_zamowienia, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        presenter = new ZamowieniaPresenter(this);
        presenter.onCreate();

        return view;
    }

    @Override
    public void showData(List<ZAMOWIENIA> lista)
    {
        MyAdapter adapter = new MyAdapter(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
