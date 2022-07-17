package br.uninga.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import br.uninga.R;

import br.uninga.model.Quarteirao;

import br.uninga.view.ListaQuarteiraoActivity;

public class QuarteiraoAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final int resourceId;

    public QuarteiraoAdapter(ListaQuarteiraoActivity activity, int listaModeloQuarteirao, List<Quarteirao> quarteiraos){
        super(activity, listaModeloQuarteirao, quarteiraos);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloQuarteirao;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Quarteirao quarteirao = (Quarteirao) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdQuarteiraoLista);
        txvId.setText(String.valueOf(quarteirao.getId()));

        TextView txvLocalidade = convertView.findViewById(R.id.txvLocalidadeQuarteiraoLista);
        txvLocalidade.setText(quarteirao.getLocalidade());

        TextView txvNumero = convertView.findViewById(R.id.txvNumeroQuarteiraoLista);
        txvNumero.setText(quarteirao.getNumero());

        TextView txvObservacao = convertView.findViewById(R.id.txvObservacaoQuarteiraoLista);
        txvObservacao.setText(quarteirao.getObservacao());

        return convertView;
    }

}
