package com.rogueapps.aggar.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.beyondar.android.world.GeoObject;

/**
 * Created by Nahum on 17/11/2016.
 */

public class GeoObjectController {
    public static GeoObject createGeoObject(Long obId, double latitude, double longitude,
                                            String name, int resource){
        GeoObject go = new GeoObject(obId);
        go.setGeoPosition(latitude, longitude);
        go.setName(name);
        go.setImageResource(resource);
        return go;
    }

    public static GeoObject createGeoObject(Long obId, double latitude, double longitude,
                                            String name, String resource){
        GeoObject go = new GeoObject(obId);
        go.setGeoPosition(latitude, longitude);
        go.setName(name);
        Bitmap bitmap = BitmapFactory.decodeFile(resource);
        go.setImageUri(resource);
        return go;
    }

    public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = (earthRadius * c);

        return dist;
    }
}
