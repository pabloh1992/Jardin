package com.pablohenao.jardin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.pablohenao.jardin.dummy.DummyContent;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details
 * (if present) is a {@link ItemDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ItemListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ItemListActivity extends FragmentActivity
        implements ItemListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);


        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }

        if (DummyContent.ITEMS.isEmpty()) {
   /*         DummyContent.addItem(new DummyContent.DummyItem("1", getResources().getString(R.string.title_activity_aboutus)));
            DummyContent.addItem(new DummyContent.DummyItem("2", getResources().getString(R.string.title_activity_demografia)));
            DummyContent.addItem(new DummyContent.DummyItem("3", getResources().getString(R.string.title_activity_bares)));
            DummyContent.addItem(new DummyContent.DummyItem("4", getResources().getString(R.string.title_activity_sitios)));
            DummyContent.addItem(new DummyContent.DummyItem("5", getResources().getString(R.string.title_activity_hoteles)));
            DummyContent.addItem(new DummyContent.DummyItem("6", getResources().getString(R.string.main)));
        */
            DummyContent.addItem(new DummyContent.DummyItem("1", getResources().getString(R.string.principal)));
            DummyContent.addItem(new DummyContent.DummyItem("2", getResources().getString(R.string.hoteles)));
            DummyContent.addItem(new DummyContent.DummyItem("3", getResources().getString(R.string.bares)));
            DummyContent.addItem(new DummyContent.DummyItem("4", getResources().getString(R.string.turismo)));
            DummyContent.addItem(new DummyContent.DummyItem("5", getResources().getString(R.string.title_activity_demografia)));
            DummyContent.addItem(new DummyContent.DummyItem("6", getResources().getString(R.string.acerca)));

        }




        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link ItemListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);


    //        Toast.makeText(getBaseContext(), "Entre", Toast.LENGTH_SHORT).show();

            switch(id)
            {
                case "1":
                    FragmentPrincipal fragmentmain = new FragmentPrincipal();
                    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragmentmain).commit();
                    break;
                case "2":
                    FragmentHoteles fragmenthotel = new FragmentHoteles();
                    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragmenthotel).commit();
                    break;
                case "3":
                    FragmentBares fragmentbar = new FragmentBares();
                    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragmentbar).commit();
                    break;
                case "4":
                    FragmentTurismo fragmentsitio = new FragmentTurismo();
                    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragmentsitio).commit();
                    break;
                case "5":
                    FragmentDemografia fragmentdemography = new FragmentDemografia();
                    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragmentdemography).commit();
                    break;
                case "6":
                    FragmentAcerca fragmentabout = new FragmentAcerca();
                    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragmentabout).commit();
                    break;
            }

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Toast.makeText(getBaseContext(), "Else",Toast.LENGTH_SHORT).show();

            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}