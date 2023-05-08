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

public class ReklamacjeFragment extends Fragment implements Contract.ReklamacjeFragment
{
    private ReklamacjePresenter presenter;
    private RecyclerView recyclerView;

    private static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView lp, temat, termin, priorytet, osoba_odpowiedzialna, status, data_zmiany_statusu, wykonana_naprawa, zglaszane_problemy, koszt_ponosi, data_wprowadzenia, osoba_zglaszajaca;

        public MyViewHolder(@NonNull View view)
        {
            super(view);

            lp = view.findViewById(R.id.tvLp);
            temat = view.findViewById(R.id.tvTemat);
            termin = view.findViewById(R.id.tvTermin);
            priorytet = view.findViewById(R.id.tvPriorytet);
            osoba_odpowiedzialna = view.findViewById(R.id.tvOsobaOdpowiedzialna);
            status = view.findViewById(R.id.tvStatus);
            data_zmiany_statusu = view.findViewById(R.id.tvDataZmianyStatusu);
            wykonana_naprawa = view.findViewById(R.id.tvWykonanaNaprawa);
            zglaszane_problemy = view.findViewById(R.id.tvZglaszaneProblemy);
            koszt_ponosi = view.findViewById(R.id.tvKosztPonosi);
            data_wprowadzenia = view.findViewById(R.id.tvDataWprowadzenia);
            osoba_zglaszajaca = view.findViewById(R.id.tvOsobaZglaszajaca);
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {
        private List<REKLAMACJE> lista;

        public MyAdapter(List<REKLAMACJE> lista)
        {
            this.lista = lista;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.row_reklamacje, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
        {
            int priorytet = Integer.parseInt(lista.get(position).getPriorytet());
            int status = Integer.parseInt(lista.get(position).getStatus());
            String wykonana_naprawa = lista.get(position).getWykonana_naprawa();

            //Wypisanie wartości
            holder.lp.setText(String.valueOf(position+1));
            holder.temat.setText(lista.get(position).getTemat());
            holder.termin.setText(lista.get(position).getTermin());
            holder.priorytet.setText(presenter.getPriorytet(priorytet));
            holder.osoba_odpowiedzialna.setText(lista.get(position).getOsoba_odpowiedzialna());
            holder.status.setText(presenter.getStatus(status));
            holder.data_zmiany_statusu.setText(lista.get(position).getData_zmianystatusu());
            holder.wykonana_naprawa.setText(wykonana_naprawa);
            holder.zglaszane_problemy.setText(lista.get(position).getZglaszane_problemy());
            holder.koszt_ponosi.setText(lista.get(position).getKoszt_ponosi());
            holder.data_wprowadzenia.setText(lista.get(position).getData_wprowadzenia());
            holder.osoba_zglaszajaca.setText(lista.get(position).getOsoba_zglaszajaca());

            //-----------------------------------------------------
            //Kolorystyka
            //Priorytet
            if(priorytet == 2)
            {
                holder.lp.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
                holder.temat.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
                holder.termin.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
                holder.priorytet.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
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

            //Wykonana naprawa
            if(!wykonana_naprawa.equals(""))
            {
                if(status == 0)      //gotowe
                    holder.wykonana_naprawa.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                else if(status == 1) //w realizacji
                    holder.wykonana_naprawa.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_yellow));
                else if(status == 2) //przeczytana
                    holder.wykonana_naprawa.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_aqua));
                else if(status == 3) //nowa
                    holder.wykonana_naprawa.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_red));
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
        View view = inflater.inflate(R.layout.fragment_reklamacje, container, false);

        presenter = new ReklamacjePresenter(this);
        presenter.onCreate();

        recyclerView = view.findViewById(R.id.recyclerView);

        return view;
    }

    @Override
    public void showData(List<REKLAMACJE> lista)
    {
        MyAdapter adapter = new MyAdapter(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
