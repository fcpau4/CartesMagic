package com.example.a46990527d.cartesmagic;

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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayList items;
    private ArrayAdapter<String> adapter;

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

        String[] data = {"carta 1", "carta 2", "carta 3", "carta 4", "carta 5", "carta 6",};

        items = new ArrayList<>(Arrays.asList(data));

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_cartes_row,
                R.id.tvCartes,
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

        CardAPI api = new CardAPI();
        String result = api.getCards().toString();

        Log.d("DEBUG", result);
    }




}
