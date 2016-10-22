package com.example.a46990527d.cartesmagic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Usuario on 22/10/2016.
 */

public class AdaptadorCartas extends ArrayAdapter<Card> {
    public AdaptadorCartas(Context context, int resource, List<Card> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Card carta = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_cartes_row, parent, false);
        }

        TextView nombre = (TextView) convertView.findViewById(R.id.tvName);
        nombre.setText(carta.getName());

        TextView type = (TextView) convertView.findViewById(R.id.tvType);
        type.setText(carta.getType());



        return convertView;

    }
}