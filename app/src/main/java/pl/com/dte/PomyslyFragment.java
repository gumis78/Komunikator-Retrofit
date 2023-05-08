package pl.com.dte;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PomyslyFragment extends Fragment implements Contract.PomyslyFragment
{
    private PomyslyPresenter presenter;
    private RecyclerView recyclerView;

    private static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView lp, temat, uwagi, osoba_zglaszajaca, data_wprowadzenia;

        public MyViewHolder(@NonNull View view)
        {
            super(view);

            lp = view.findViewById(R.id.tvLp);
            temat = view.findViewById(R.id.tvTemat);
            uwagi = view.findViewById(R.id.tvUwagi);
            osoba_zglaszajaca = view.findViewById(R.id.tvOsobaZglaszajaca);
            data_wprowadzenia = view.findViewById(R.id.tvDataWprowadzenia);
        }
    }

    private class MyAdapter extends  RecyclerView.Adapter<MyViewHolder>
    {
        private List<POMYSLY> lista;

        public MyAdapter(List<POMYSLY> lista)
        {
            this.lista = lista;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.row_pomysly, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
        {
            holder.lp.setText(String.valueOf(position + 1));
            holder.temat.setText(lista.get(position).getTemat());
            holder.uwagi.setText(lista.get(position).getUwagi());
            holder.osoba_zglaszajaca.setText(lista.get(position).getOsoba_zglaszajaca());
            holder.data_wprowadzenia.setText(lista.get(position).getData_wprowadzenia());
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
        View view = inflater.inflate(R.layout.fragment_pomysly, container, false);

        presenter = new PomyslyPresenter(this);
        presenter.onCreate();

        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void showData(List<POMYSLY> lista)
    {
        MyAdapter adapter = new MyAdapter(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
