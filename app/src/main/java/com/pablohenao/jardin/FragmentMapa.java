package com.pablohenao.jardin;


        import android.app.Fragment;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.google.android.gms.maps.CameraUpdate;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.MapFragment;
        import com.google.android.gms.maps.MapView;
        import com.google.android.gms.maps.MapsInitializer;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;


public class FragmentMapa extends Fragment{

    private MapView mMapView;
    private GoogleMap mMap;
    private Bundle mBundle;
    private final LatLng LOCATION_JARDIN = new LatLng(5.599371642893394, -75.81937819719315);
    private CameraUpdate cameraUpdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_mapa, container, false);

        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            // TODO handle this situation
        }

        mMapView = (MapView) inflatedView.findViewById(R.id.map);
        mMapView.onCreate(mBundle);
        setUpMapIfNeeded(inflatedView);

        return inflatedView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = savedInstanceState;
    }

    private void setUpMapIfNeeded(View inflatedView) {
        if (mMap == null) {
            mMap = ((MapView) inflatedView.findViewById(R.id.map)).getMap();

            if (mMap != null) {
                mMap.addMarker(new MarkerOptions().position(LOCATION_JARDIN).title("Jardin").snippet("Parque")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                cameraUpdate= CameraUpdateFactory.newLatLngZoom(LOCATION_JARDIN, 16);
                mMap.animateCamera(cameraUpdate);
            }
        }
    }
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(5.599371642893394, -75.81937819719315)).title("Jardin"));
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }





}