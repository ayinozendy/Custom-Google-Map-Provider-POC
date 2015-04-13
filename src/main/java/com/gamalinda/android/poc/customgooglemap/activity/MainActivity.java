package com.gamalinda.android.poc.customgooglemap.activity;

import android.app.Activity;
import com.gamalinda.android.poc.customgooglemap.R;
import com.gamalinda.android.poc.customgooglemap.map.CustomTileProvider;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.TileOverlayOptions;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;

@EActivity(R.layout.main)
public class MainActivity extends Activity implements OnMapReadyCallback {

    @FragmentById(R.id.map)
    MapFragment mapFragment;

    GoogleMap map;

    UiSettings uiSettings;

    @AfterViews
    void afterViews() {
        mapFragment.getMapAsync(this);
        map = mapFragment.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NONE);

        TileOverlayOptions options = new TileOverlayOptions();
        options.tileProvider(new CustomTileProvider());
        options.zIndex(5);
        map.addTileOverlay(options);

        uiSettings = map.getUiSettings();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(2));
        uiSettings.setZoomControlsEnabled(true);
    }
}
