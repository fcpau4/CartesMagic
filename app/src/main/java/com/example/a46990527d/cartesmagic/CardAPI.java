package com.example.a46990527d.cartesmagic;

import android.net.Uri;

import java.io.IOException;

/**
 * Created by 46990527d on 18/10/16.
 */

public class CardAPI {

    private final String BASE_URL = "https://api.magicthegathering.io/v1/cards";

    String getCards() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("name")
                .appendPath("type")
                .build();
        String url = builtUri.toString();

        try {
            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


