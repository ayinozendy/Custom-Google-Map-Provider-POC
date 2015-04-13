package com.gamalinda.android.poc.customgooglemap.map;

import android.util.Log;
import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomTileProvider extends UrlTileProvider {

    private static final String tileUrl = "http://android.gamalinda.com/map-server/tile/?x=%d&y=%d&z=%d";
    public CustomTileProvider() {
        super(512, 512);
    }

    @Override
    public URL getTileUrl(int x, int y, int z) {
        String completeUrl = String.format(tileUrl, x, y, z);

        if (!checkTileExists(x, y, z)) {
            return null;
        }

        try {
            return new URL(completeUrl);
        } catch (MalformedURLException e) {
            Log.e(CustomTileProvider.class.getSimpleName(), "Bad URL", e);
        }

        return null;
    }

    private boolean checkTileExists(int x, int y, int zoom) {
        int minZoom = 0;
        int maxZoom = 3;


        if ((zoom < minZoom || zoom > maxZoom)) {
            return false;
        }

        return true;
    }
}
