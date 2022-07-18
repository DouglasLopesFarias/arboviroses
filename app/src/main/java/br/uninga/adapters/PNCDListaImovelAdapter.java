package br.uninga.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninga.R;
import br.uninga.model.CadPNCD;
import br.uninga.view.ListaPNCDActivity;

public class PNCDListaImovelAdapter extends ArrayAdapter {

    private final LayoutInflater inflater;
    private final int resourceId;

    public PNCDListaImovelAdapter(ListaPNCDActivity activity, int listaModeloPNCD, List<CadPNCD> cadPNCDS){
        super(activity, listaModeloPNCD, cadPNCDS);
        this.inflater = LayoutInflater.from(activity);
        this.resourceId = listaModeloPNCD;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CadPNCD cadPNCD = (CadPNCD) getItem(position);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView txvId = convertView.findViewById(R.id.txvIdPNCDLista);
        txvId.setText(String.valueOf(cadPNCD.getId()));

        TextView txvData = convertView.findViewById(R.id.txvDataPNCDLista);
        txvData.setText(cadPNCD.getData());

        TextView txvHora = convertView.findViewById(R.id.txvHoraPNCDLista);
        txvHora.setText(cadPNCD.getHora());

        TextView txvA1 = convertView.findViewById(R.id.txvA1PNCDLista);
        txvA1.setText(cadPNCD.getA1());

        TextView txvA2 = convertView.findViewById(R.id.txvA2PNCDLista);
        txvA2.setText(cadPNCD.getA2());

        TextView txvBB = convertView.findViewById(R.id.txvBPNCDLista);
        txvBB.setText(cadPNCD.getB());

        TextView txvCC = convertView.findViewById(R.id.txvCPNCDLista);
        txvCC.setText(cadPNCD.getC());

        TextView txvD1 = convertView.findViewById(R.id.txvD1PNCDLista);
        txvD1.setText(cadPNCD.getD1());

        TextView txvD2 = convertView.findViewById(R.id.txvD2PNCDLista);
        txvD2.setText(cadPNCD.getD2());

        TextView txvEE = convertView.findViewById(R.id.txvEPNCDLista);
        txvEE.setText(cadPNCD.getE());

        TextView txvTipo1 = convertView.findViewById(R.id.txvTipo01PNCDLista);
        txvTipo1.setText(cadPNCD.getTipo01());

        TextView txvQuantidade1 = convertView.findViewById(R.id.txvQuantidade01PNCDLista);
        txvQuantidade1.setText(cadPNCD.getQuantidade01());

        TextView txvTipo2 = convertView.findViewById(R.id.txvTipo02PNCDLista);
        txvTipo2.setText(cadPNCD.getTipo02());

        TextView txvQuantidade2 = convertView.findViewById(R.id.txvQuantidade02PNCDLista);
        txvQuantidade2.setText(cadPNCD.getQuantidade02());

        TextView txvTipoImovel = convertView.findViewById(R.id.txvTipoDeImovelPNCDLista);
        txvTipoImovel.setText(cadPNCD.getTipodeImovel());

        TextView txvComplemento = convertView.findViewById(R.id.txvComplementoPNCDLista);
        txvComplemento.setText(cadPNCD.getComplemento());

        TextView txvNumero = convertView.findViewById(R.id.txvNumeroPNCDLista);
        txvNumero.setText(cadPNCD.getNumero());

        TextView txvSequencia = convertView.findViewById(R.id.txvSequenciaPNCDLista);
        txvSequencia.setText(cadPNCD.getSequencia());

        TextView txvNumeroDeMoradores = convertView.findViewById(R.id.txvNumeroDeMoradoresPNCDLista);
        txvNumeroDeMoradores.setText(cadPNCD.getNumerodeMoradores());

        TextView txvtelefoneResidencial = convertView.findViewById(R.id.txvTelefoneResidencialPNCDLista);
        txvtelefoneResidencial.setText(cadPNCD.getTelefoneResidencial());

        TextView txvtelefoneRecado = convertView.findViewById(R.id.txvTelefoneRecadoPNCDLista);
        txvtelefoneRecado.setText(cadPNCD.getTelefoneRecado());

        TextView txvNomeMorador = convertView.findViewById(R.id.txvNomeMoradorPNCDLista);
        txvNomeMorador.setText(cadPNCD.getNomeMorador());

        TextView txvCPF = convertView.findViewById(R.id.txvCPFPNCDLista);
        txvCPF.setText(cadPNCD.getCpf());

        TextView txvDataNascimanto = convertView.findViewById(R.id.txvDataNascimentoPNCDLista);
        txvDataNascimanto.setText(cadPNCD.getDataNascimento());

        TextView txvNumerodoCartaoSus = convertView.findViewById(R.id.txvNumeroDoCartaoSusPNCDLista);
        txvNumerodoCartaoSus.setText(cadPNCD.getNumerodoCartaoSus());

        return convertView;
    }

}

