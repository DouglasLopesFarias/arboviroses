package br.uninga.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninga.R;
import br.uninga.model.Imovel;
import br.uninga.view.ListaImovelActivity;

public class ImovelAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final int resourceId;

    public ImovelAdapter(ListaImovelActivity activity, int listaModeloImovel, List<Imovel> imovels){
        super(activity, listaModeloImovel, imovels);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloImovel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Imovel imovel = (Imovel) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdImovelLista);
        txvId.setText(String.valueOf(imovel.getId()));

        TextView txvLocalidade = convertView.findViewById(R.id.txvLocalidadeImovelLista);
        txvLocalidade.setText(imovel.getLocalidade());

        TextView txvQuarteirao = convertView.findViewById(R.id.txvQuarteiraoImovelLista);
        txvQuarteirao.setText(imovel.getQuarteirao());

        TextView txvLogradouro = convertView.findViewById(R.id.txvLogradouroImovelLista);
        txvLogradouro.setText(imovel.getLogradouro());

        TextView txvNumero = convertView.findViewById(R.id.txvNumeroImovelLista);
        txvNumero.setText(imovel.getNumero());

        TextView txvBairro = convertView.findViewById(R.id.txvBairroImovelLista);
        txvBairro.setText(imovel.getBairro());

        TextView txvTipoImovel = convertView.findViewById(R.id.txvtipoImovelImovelLista);
        txvTipoImovel.setText(imovel.getTipoImovel());

        TextView txvComplemento = convertView.findViewById(R.id.txvComplementoImovelLista);
        txvComplemento.setText(imovel.getComplemento());

        TextView txvSequencia = convertView.findViewById(R.id.txvSequenciaImovelLista);
        txvSequencia.setText(imovel.getSequencia());

        TextView txvTelefoneResidencial = convertView.findViewById(R.id.txvTelefoneResidencialImovelLista);
        txvTelefoneResidencial.setText(imovel.getTelefoneResidencial());

        TextView txvTelefoneRecado = convertView.findViewById(R.id.txvTelefoneRecadoImovelLista);
        txvTelefoneRecado.setText(imovel.getTelefoneRecado());

        TextView txvObservacao = convertView.findViewById(R.id.txvObservacaoImovelLista);
        txvObservacao.setText(imovel.getObservacao());

        return convertView;
    }

}
