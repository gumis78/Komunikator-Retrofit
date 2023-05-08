package pl.com.dte;

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

public class ProjektyFragment extends Fragment implements Contract.ProjektyFragment
{
    private ProjektyPresenter presenter;
    private RecyclerView recyclerView;

    private static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView lp, osoba_odpowiedzialna, temat, data_wprowadzenia, data_zakonczenia, stopien_zaawansowania, data_zmiany_statusu, uwagi;

        public MyViewHolder(@NonNull View view)
        {
           super(view);

           lp = view.findViewById(R.id.lp);
           osoba_odpowiedzialna = view.findViewById(R.id.osoba_odpowiedzialna);
           temat = view.findViewById(R.id.temat);
           data_wprowadzenia = view.findViewById(R.id.data_wprowadzenia);
           data_zakonczenia = view.findViewById(R.id.data_zakonczenia);
           stopien_zaawansowania = view.findViewById(R.id.stopien_zaawansowania);
           data_zmiany_statusu = view.findViewById(R.id.data_zmiany_statusu);
           uwagi = view.findViewById(R.id.uwagi);
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {
        private List<PROJEKTY> lista;

        public MyAdapter(List<PROJEKTY> lista)
        {
            this.lista = lista;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.row_projekty, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
        {
            int stopien_zaawansowania = Integer.parseInt(lista.get(position).getStopien_zaawansowania());

            holder.lp.setText(String.valueOf(position+1));
            holder.osoba_odpowiedzialna.setText(lista.get(position).getOsoba_odpowiedzialna());
            holder.temat.setText(lista.get(position).getTemat());
            holder.data_wprowadzenia.setText(lista.get(position).getData_wprowadzenia());
            holder.data_zakonczenia.setText(lista.get(position).getData_zakonczenia());
            holder.stopien_zaawansowania.setText(stopien_zaawansowania + "%");
            holder.data_zmiany_statusu.setText(lista.get(position).getData_zmiany_statusu());
            holder.uwagi.setText(lista.get(position).getUwagi());

            if(stopien_zaawansowania == 100)
            {
                holder.lp.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                holder.osoba_odpowiedzialna.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                holder.temat.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                holder.data_wprowadzenia.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                holder.data_zakonczenia.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                holder.stopien_zaawansowania.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                holder.data_zmiany_statusu.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
                holder.uwagi.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.textview_bg_green));
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
        View view = inflater.inflate(R.layout.fragment_projekty, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        presenter = new ProjektyPresenter(this);
        presenter.onCreate();

        return view;
    }

    @Override
    public void showData(List<PROJEKTY> lista)
    {
        MyAdapter adapter = new MyAdapter(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
