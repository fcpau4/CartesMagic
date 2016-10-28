package com.example.a46990527d.cartesmagic;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList<Card> items = new ArrayList<>();
    private AdaptadorCartas adapter;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvCartes = (ListView) view.findViewById(R.id.lvCartes);

        String data = "{\"cards\":[{\"name\":\"Air Elemental\",\"manaCost\":\"{3}{U}{U}\",\"cmc\":5,\"colors\":[\"Blue\"],\"colorIdentity\":[\"U\"],\"type\":\"Creature — Elemental\",\"types\":[\"Creature\"],\"subtypes\":[\"Elemental\"],\"rarity\":\"Uncommon\",\"set\":\"LEA\",\"setName\":\"Limited Edition Alpha\",\"text\":\"Flying\",\"flavor\":\"These spirits of the air are winsome and wild, and cannot be truly contained. Only marginally intelligent, they often substitute whimsy for strategy, delighting in mischief and mayhem.\",\"artist\":\"Richard Thomas\",\"power\":\"4\",\"toughness\":\"4\",\"layout\":\"normal\",\"multiverseid\":94,\"imageUrl\":\"http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=94&type=card\",\"printings\":[\"LEA\",\"LEB\",\"2ED\",\"CED\",\"CEI\",\"3ED\",\"4ED\",\"5ED\",\"PO2\",\"6ED\",\"S99\",\"BRB\",\"BTD\",\"7ED\",\"8ED\",\"9ED\",\"10E\",\"DD2\",\"M10\",\"DPA\",\"ME4\",\"DD3_JVC\"],\"originalText\":\"Flying\",\"originalType\":\"Summon — Elemental\",\"legalities\":[{\"format\":\"Commander\",\"legality\":\"Legal\"},{\"format\":\"Legacy\",\"legality\":\"Legal\"},{\"format\":\"Modern\",\"legality\":\"Legal\"},{\"format\":\"Vintage\",\"legality\":\"Legal\"}],\"id\":\"926234c2fe8863f49220a878346c4c5ca79b6046\"},{\"name\":\"Ancestral Recall\",\"manaCost\":\"{U}\",\"cmc\":1,\"colors\":[\"Blue\"],\"colorIdentity\":[\"U\"],\"type\":\"Instant\",\"types\":[\"Instant\"],\"rarity\":\"Rare\",\"set\":\"LEA\",\"setName\":\"Limited Edition Alpha\",\"text\":\"Target player draws three cards.\",\"artist\":\"Mark Poole\",\"layout\":\"normal\",\"multiverseid\":95,\"imageUrl\":\"http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=95&type=card\",\"reserved\":true,\"printings\":[\"LEA\",\"LEB\",\"2ED\",\"CED\",\"CEI\",\"VMA\"],\"originalText\":\"Draw 3 cards or force opponent to draw 3 cards.\",\"originalType\":\"Instant\",\"legalities\":[{\"format\":\"Commander\",\"legality\":\"Banned\"},{\"format\":\"Legacy\",\"legality\":\"Banned\"},{\"format\":\"Vintage\",\"legality\":\"Restricted\"}],\"id\":\"aa74b7dc3b30b2e7559598f983543755e226811d\"},{\"name\":\"Animate Artifact\",\"manaCost\":\"{3}{U}\",\"cmc\":4,\"colors\":[\"Blue\"],\"colorIdentity\":[\"U\"],\"type\":\"Enchantment — Aura\",\"types\":[\"Enchantment\"],\"subtypes\":[\"Aura\"],\"rarity\":\"Uncommon\",\"set\":\"LEA\",\"setName\":\"Limited Edition Alpha\",\"text\":\"Enchant artifact\\nAs long as enchanted artifact isn't a creature, it's an artifact creature with power and toughness each equal to its converted mana cost.\",\"artist\":\"Douglas Shuler\",\"layout\":\"normal\",\"multiverseid\":96,\"imageUrl\":\"http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=96&type=card\",\"rulings\":[{\"date\":\"2008-08-01\",\"text\":\"This card has been returned to its original functionality. If it is enchanting an artifact that’s already a creature, it won’t change its power and toughness.\"},{\"date\":\"2008-08-01\",\"text\":\"A noncreature permanent that turns into a creature can attack, and its {T} abilities can be activated, only if its controller has continuously controlled that permanent since the beginning of his or her most recent turn. It doesn’t matter how long the permanent has been a creature.\"}],\"printings\":[\"LEA\",\"LEB\",\"2ED\",\"CED\",\"CEI\",\"3ED\",\"4ED\",\"ME4\"],\"originalText\":\"Target artifact is now a creature with both power and toughness equal to its casting cost; target retains all its original abilities as well. This will destroy artifacts with 0 casting cost.\",\"originalType\":\"Enchant Non-Creature Artifact\",\"legalities\":[{\"format\":\"Commander\",\"legality\":\"Legal\"},{\"format\":\"Legacy\",\"legality\":\"Legal\"},{\"format\":\"Vintage\",\"legality\":\"Legal\"}],\"id\":\"9d91ef4896ab4c1a5611d4d06971fc8026dd2f3f\"},{\"name\":\"Animate Dead\",\"manaCost\":\"{1}{B}\",\"cmc\":2,\"colors\":[\"Black\"],\"colorIdentity\":[\"B\"],\"type\":\"Enchantment — Aura\",\"types\":[\"Enchantment\"],\"subtypes\":[\"Aura\"],\"rarity\":\"Uncommon\",\"set\":\"LEA\",\"setName\":\"Limited Edition Alpha\",\"text\":\"Enchant creature card in a graveyard\\nWhen Animate Dead enters the battlefield, if it's on the battlefield, it loses \\\"enchant creature card in a graveyard\\\" and gains \\\"enchant creature put onto the battlefield with Animate Dead.\\\" Return enchanted creature card to the battlefield under your control and attach Animate Dead to it. When Animate Dead leaves the battlefield, that creature's controller sacrifices it.\\nEnchanted creature gets -1/-0.\",\"artist\":\"Anson Maddocks\",\"layout\":\"normal\",\"multiverseid\":48,\"imageUrl\":\"http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=48&type=card\",\"rulings\":[{\"date\":\"2016-06-08\",\"text\":\"Animate Dead is an Aura, albeit with an unusual enchant ability. You target a creature card in a graveyard when you cast it. It enters the battlefield attached to that card. Then it returns that card to the battlefield, and attaches itself to the card again (since the card is a new object on the battlefield). Animate Dead itself never moves into a graveyard during this process.\"},{\"date\":\"2016-06-08\",\"text\":\"If Animate Dead isn’t on the battlefield as its triggered ability resolves, none of its effects happen. The creature card won’t be returned to the battlefield.\"},{\"date\":\"2016-06-08\",\"text\":\"Abilities such as shroud and protection function only on the battlefield unless otherwise specified. A creature card with shroud may be targeted by Animate Dead, and Animate Dead will become attached to the creature that enters the battlefield.\"},{\"date\":\"2016-06-08\",\"text\":\"If the creature put onto the battlefield has protection from black—or if the creature can’t legally be enchanted by Animate Dead for another reason—Animate Dead won’t be able to attach to it. It will be put into the graveyard as a state-based action, causing its delayed triggered ability to trigger. When the trigger resolves, if the creature’s still on the battlefield, its controller will sacrifice it.\"},{\"date\":\"2016-06-08\",\"text\":\"Once the creature is returned to the battlefield, Animate Dead can’t be attached to anything other than it (unless Animate Dead somehow manages to put a different creature onto the battlefield). Attempting to move Animate Dead to another creature won’t work.\"}],\"printings\":[\"LEA\",\"LEB\",\"2ED\",\"CED\",\"CEI\",\"3ED\",\"4ED\",\"5ED\",\"MED\",\"PD3\",\"VMA\",\"EMA\"],\"originalText\":\"Any creature in either player's graveyard comes into play on your side with -1 to its original power. If this enchantment is removed, or at end of game, target creature is returned to its owner's graveyard. Target creature may be killed as normal.\",\"originalType\":\"Enchant Dead Creature\",\"legalities\":[{\"format\":\"Commander\",\"legality\":\"Legal\"},{\"format\":\"Legacy\",\"legality\":\"Legal\"},{\"format\":\"Vintage\",\"legality\":\"Legal\"}],\"id\":\"d8b74ea7f050c8c05588e002f0264643fc90209b\"},{\"name\":\"Animate Wall\",\"manaCost\":\"{W}\",\"cmc\":1,\"colors\":[\"White\"],\"colorIdentity\":[\"W\"],\"type\":\"Enchantment — Aura\",\"types\":[\"Enchantment\"],\"subtypes\":[\"Aura\"],\"rarity\":\"Rare\",\"set\":\"LEA\",\"setName\":\"Limited Edition Alpha\",\"text\":\"Enchant Wall\\nEnchanted Wall can attack as though it didn't have defender.\",\"artist\":\"Dan Frazier\",\"layout\":\"normal\",\"multiverseid\":232,\"imageUrl\":\"http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=232&type=card\",\"rulings\":[{\"date\":\"2007-09-16\",\"text\":\"This is a change from the most recent wording. As was the case in the past, Animate Wall can now enchant only a Wall.\"}],\"printings\":[\"LEA\",\"LEB\",\"2ED\",\"CED\",\"CEI\",\"3ED\",\"4ED\",\"5ED\",\"6ED\",\"MED\"],\"originalText\":\"Target wall can now attack. Target wall's power and toughness are unchanged, even if its power is 0.\",\"originalType\":\"Enchant Wall\",\"legalities\":[{\"format\":\"Commander\",\"legality\":\"Legal\"},{\"format\":\"Legacy\",\"legality\":\"Legal\"},{\"format\":\"Vintage\",\"legality\":\"Legal\"}],\"id\":\"6ba9537d0f1733e4a01927bdf60bfb5122e5a709\"}]}";

        try {
            CardAPI api = new CardAPI();
            JSONObject json = api.TratarStringRespuesta(data);
            items = api.ConvertirEnCarta(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        adapter = new AdaptadorCartas(
                getContext(),
                R.layout.lv_cartes_row,
                items
        );

        lvCartes.setAdapter(adapter);



        return view;
    }

    //agreguem el menuItem refresh al Menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_cartes_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int idmenuitem = item.getItemId();

        if (idmenuitem == R.id.action_Refresh) {
            refresh();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void refresh() {

        RefreshDataTask tarea = new RefreshDataTask();
        tarea.execute();

    }

    //metode que s'executara en segon pla i fara la crida a l'api
    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Card>> {
        @Override
        protected ArrayList<Card> doInBackground(Void... voids) {

            CardAPI api = new CardAPI();
            ArrayList <Card> result = api.getCards();

            Log.d("DEBUG", result.toString());

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Card> respuesta) {
            if (respuesta != null) {
                adapter.clear();
                adapter.addAll(respuesta);
            }
        }
    }
}