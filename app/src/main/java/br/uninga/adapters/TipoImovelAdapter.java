package br.uninga.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninga.R;
import br.uninga.model.Bairro;
import br.uninga.model.TipoDeImovel;
import br.uninga.view.ListaBairroActivity;
import br.uninga.view.ListaTipoImovelActivity;

public class TipoImovelAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final int resourceId;

    public TipoImovelAdapter(ListaTipoImovelActivity activity, int listaModeloTipoImovel, List<TipoDeImovel> tipoDeImovels){
        super(activity, listaModeloTipoImovel, tipoDeImovels);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloTipoImovel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TipoDeImovel tipoDeImovel = (TipoDeImovel) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdTipoImovelLista);
        txvId.setText(String.valueOf(tipoDeImovel.getId()));

        TextView txvSigla = convertView.findViewById(R.id.txvSiglaTipoImovelLista);
        txvSigla.setText(tipoDeImovel.getSigla());

        TextView txvDescricao = convertView.findViewById(R.id.txvDescricaoTipoImovelLista);
        txvDescricao.setText(tipoDeImovel.getDescricao());

        return convertView;
    }

}
