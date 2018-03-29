package com.example.suhasini.mapsapp;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng vasavi = new LatLng(17.3802491,78.3802947);
        mMap.addMarker(new MarkerOptions().position(vasavi).title("Marker in VCE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vasavi));

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);//Satellite

        LatLng home = new LatLng(17.3912265,78.4259183);
        mMap.addMarker(new MarkerOptions().position(home).title("Marker in Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);//Satellite view
        float [] result = new float[1];
        Location.distanceBetween(vasavi.latitude,vasavi.longitude,home.latitude,home.longitude,result);
        TextView  t = (TextView) findViewById(R.id.distance);
        t.setText(""+result[0]);
    }
}
