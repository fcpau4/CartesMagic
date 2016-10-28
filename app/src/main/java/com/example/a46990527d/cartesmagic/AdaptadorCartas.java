package com.example.a46990527d.cartesmagic;

import com.bumptech.glide.Glide;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.a46990527d.cartesmagic.R.id.ivImatge;

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

        TextView rarity = (TextView) convertView.findViewById(R.id.tvRarity);
        rarity.setText(carta.getRarity());

        TextView colors = (TextView) convertView.findViewById(R.id.tvColors);
        colors.setText(carta.getColors());

        ImageView image = (ImageView) convertView.findViewById(R.id.ivImatge);
        Glide.with(getContext()).load(carta.getImageUrl()).into(image);





        return convertView;

    }
}