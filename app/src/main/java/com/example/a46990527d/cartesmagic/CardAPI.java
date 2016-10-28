package com.example.a46990527d.cartesmagic;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 46990527d on 18/10/16.
 */

public class CardAPI {

    private final String BASE_URL = "https://api.magicthegathering.io/v1";

    public ArrayList<Card> getCards() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("cards")
                .build();


        try {
            String url = builtUri.toString();
            String JsonResponse = HttpUtils.get(url);
            //creem un objecte Json a partir de l'string de resposta amb el metode
            JSONObject JSONCards = TratarStringRespuesta(JsonResponse);

            return ConvertirEnCarta(JSONCards);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException j) {
            j.printStackTrace();
        }
        return null;
    }

    // A partir de l'String , el convertim a un objecte JSON per poder tractar-lo
    public JSONObject TratarStringRespuesta(String respuesta) throws JSONException {

        JSONObject obj = new JSONObject(respuesta);

        return obj;
    }

    //a Partir de l'objecte JSON rebut (que conte Cards amb Totes les cartes juntes), alimentem el nostre arraylist Card per a interactuar mes endavant
    public ArrayList<Card> ConvertirEnCarta(JSONObject cartas) throws JSONException {

        ArrayList<Card> cards = new ArrayList<>();
        JSONArray JSONCards = cartas.getJSONArray("cards");

        for (int i = 0; i < JSONCards.length(); i++) {
            JSONObject objeto = JSONCards.getJSONObject(i);
            Card Carta = new Card();
            Carta.setName(objeto.getString("name"));
            Carta.setType(objeto.getString("type"));
            Carta.setRarity(objeto.getString("rarity"));
            Carta.setColors(objeto.getString("colors"));
            cards.add(Carta);
        }

        return cards;
    }
}


