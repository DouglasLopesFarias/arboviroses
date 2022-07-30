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


        return convertView;
    }

}

