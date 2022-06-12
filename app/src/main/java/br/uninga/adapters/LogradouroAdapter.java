package br.uninga.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import br.uninga.R;
import br.uninga.model.Logradouro;
import br.uninga.view.ListaLogradouroActivity;

public class LogradouroAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final int resourceId;

    public LogradouroAdapter(ListaLogradouroActivity activity, int listaModeloLogradouro, List<Logradouro> logradouros){
        super(activity, listaModeloLogradouro, logradouros);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloLogradouro;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Logradouro logradouro = (Logradouro) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdLogradouroLista);
        txvId.setText(String.valueOf(logradouro.getId()));

        TextView txvNome = convertView.findViewById(R.id.txvDescricaoLogradouroLista);
        txvNome.setText(logradouro.getDescricao());

        return convertView;
    }

}
