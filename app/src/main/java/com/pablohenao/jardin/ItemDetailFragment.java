package com.pablohenao.jardin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
//import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import com.pablohenao.jardin.dummy.DummyContent;


/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        FragmentManager fragmentmanager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            if (mItem.item_name.equals(getResources().getString(R.string.principal))){
                FragmentPrincipal fragmentmain = new FragmentPrincipal();
                fragmentTransaction.replace(android.R.id.content,fragmentmain).commit();
            }else if (mItem.item_name.equals(getResources().getString(R.string.hoteles))){
                FragmentHoteles fragmenthotel = new FragmentHoteles();
                fragmentTransaction.replace(android.R.id.content,fragmenthotel).commit();
            }else if (mItem.item_name.equals(getResources().getString(R.string.bares))){
                FragmentBares fragmentbar = new FragmentBares();
                fragmentTransaction.replace(android.R.id.content,fragmentbar).commit();
            }else if (mItem.item_name.equals(getResources().getString(R.string.turismo))){
                FragmentTurismo fragmentsitio = new FragmentTurismo();
                fragmentTransaction.replace(android.R.id.content,fragmentsitio).commit();
            }else if (mItem.item_name.equals(getResources().getString(R.string.title_activity_demografia))){
                FragmentDemografia fragmentdemography = new FragmentDemografia();
                fragmentTransaction.replace(android.R.id.content,fragmentdemography).commit();
            }else if (mItem.item_name.equals(getResources().getString(R.string.acerca))){
                FragmentAcerca fragmentdemography = new FragmentAcerca();
                fragmentTransaction.replace(android.R.id.content,fragmentdemography).commit();
            }
            else if (mItem.item_name.equals(getResources().getString(R.string.mapa))){
               FragmentMapa fragmentmap = new FragmentMapa();
                fragmentTransaction.replace(android.R.id.content,fragmentmap).commit();

      //          Intent i = new Intent(this, MapActivity.class);
      //          startActivity(i);

            }
        }

        return rootView;
    }
}