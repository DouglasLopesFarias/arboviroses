package br.uninga.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninga.R;
import br.uninga.model.QuarteiroesVistoria;
import br.uninga.view.ListaQuarteiroesPNCD;

public class QuarteiroesVistoriaAdapter extends ArrayAdapter {


    private final LayoutInflater inflater;
    private final int resourceId;

    public QuarteiroesVistoriaAdapter(ListaQuarteiroesPNCD activity, int listaModeloQuarteiroesVistoria, List<QuarteiroesVistoria> quarteiroesVistoriaList){
        super(activity, listaModeloQuarteiroesVistoria, quarteiroesVistoriaList);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloQuarteiroesVistoria;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        QuarteiroesVistoria quarteiroesVistoria = (QuarteiroesVistoria) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdQuarteiroesVistoriaLista);
        txvId.setText(String.valueOf(quarteiroesVistoria.getId()));

        TextView txvLocalidade = convertView.findViewById(R.id.txvLocalidadeQuarteiroesVistoriaLista);
        txvLocalidade.setText(quarteiroesVistoria.getLocalidade());

        TextView txvNumero = convertView.findViewById(R.id.txvNumeroQuarteiroesVistoriaLista);
        txvNumero.setText(quarteiroesVistoria.getNumero());

        TextView txvObservacao = convertView.findViewById(R.id.txvObservacaoQuarteiroesVistoriaLista);
        txvObservacao.setText(quarteiroesVistoria.getObservacao());

        return convertView;
    }

}
