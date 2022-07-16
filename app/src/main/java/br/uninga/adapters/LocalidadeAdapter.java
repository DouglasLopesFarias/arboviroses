package br.uninga.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninga.R;
import br.uninga.model.Localidade;
import br.uninga.view.ListaLocalidadeActivity;

public class LocalidadeAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final int resourceId;

    public LocalidadeAdapter(ListaLocalidadeActivity activity, int listaModeloLocalidade, List<Localidade> localidades){
        super(activity, listaModeloLocalidade, localidades);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloLocalidade;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Localidade localidade = (Localidade) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdLocalidadeLista);
        txvId.setText(String.valueOf(localidade.getId()));

        TextView txvDescricao = convertView.findViewById(R.id.txvDescricaoLocalidadeLista);
        txvDescricao.setText(localidade.getDescricao());

        TextView txvCategoria = convertView.findViewById(R.id.txvCategoriaLocalidadeLista);
        txvCategoria.setText(localidade.getCategoria());

        TextView txvZona = convertView.findViewById(R.id.txvZonaLocalidadeLista);
        txvZona.setText(localidade.getDescricao());

        TextView txvExtrato = convertView.findViewById(R.id.txvExtratoLocalidadeLista);
        txvExtrato.setText(localidade.getDescricao());

        return convertView;
    }

}
