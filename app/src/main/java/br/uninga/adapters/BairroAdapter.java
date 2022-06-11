package br.uninga.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninga.R;
import br.uninga.model.Bairro;
import br.uninga.view.ListaBairroActivity;

public class BairroAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final int resourceId;

    public BairroAdapter(ListaBairroActivity activity, int listaModeloBairro, List<Bairro> bairros){
        super(activity, listaModeloBairro, bairros);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloBairro;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Bairro bairro = (Bairro) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdBairroLista);
        txvId.setText(String.valueOf(bairro.getId()));

        TextView txvNome = convertView.findViewById(R.id.txvDescricaoBairroLista);
        txvNome.setText(bairro.getDescricao());

        return convertView;
    }
}

