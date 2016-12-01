package com.rogueapps.aggar.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;
import com.rogueapps.aggar.R;

/**
 * Created by Nahum on 17/11/2016.
 */

public class GeoObjectController {
    public static GeoObject createGeoObject(Long obId, double latitude, double longitude,
                                            String name, int resource){
        GeoObject go = new GeoObject(obId);
        go.setGeoPosition(latitude, longitude);
        go.setImageResource(resource);
        go.setName(name);
        return go;
    }

    public static World fillWorld(World world){
        GeoObject object = GeoObjectController.createGeoObject(0L,30.612390,-96.341142,"MSC", R.drawable.msc);
        GeoObject object1 = GeoObjectController.createGeoObject(1L,30.611928,-96.340294,"12 Man Statue", R.drawable.manst);
        GeoObject object2 = GeoObjectController.createGeoObject(2L,30.612173,-96.339522,"Koldus", R.drawable.koldus);
        GeoObject object3 = GeoObjectController.createGeoObject(3L,30.609837,-96.340412,"Kyle Field", R.drawable.kyle);
        GeoObject object4 = GeoObjectController.createGeoObject(4L,30.612898,-96.340166,"Rudder Tower", R.drawable.ruddertower);
        GeoObject object5 = GeoObjectController.createGeoObject(5L,30.617095,-96.336180,"Teague Building", R.drawable.vulpix);

        GeoObject object6 = GeoObjectController.createGeoObject(6L,30.612920,-96.339823,"Event 1", R.drawable.rudderevnt1);
        GeoObject object7 = GeoObjectController.createGeoObject(7L,30.612926,-96.339811,"Event 2", R.drawable.rudderevnt2);
        GeoObject object8 = GeoObjectController.createGeoObject(8L,30.612932,-96.339799,"Event 3", R.drawable.rudderevent3);
        GeoObject object9 = GeoObjectController.createGeoObject(9L,30.612374,-96.340634,"Event 4", R.drawable.mscevent1);
        GeoObject object10 = GeoObjectController.createGeoObject(10L,30.612360,-96.340666,"Event 5", R.drawable.mscevent2);
        GeoObject object11 = GeoObjectController.createGeoObject(11L,30.620543,-96.341800,"test", R.drawable.msc);

        world.addBeyondarObject(object);
        world.addBeyondarObject(object1);
        world.addBeyondarObject(object2);
        world.addBeyondarObject(object3);
        world.addBeyondarObject(object4);
        world.addBeyondarObject(object5);
        world.addBeyondarObject(object6);
        world.addBeyondarObject(object7);
        world.addBeyondarObject(object8);
        world.addBeyondarObject(object9);
        world.addBeyondarObject(object10);
        world.addBeyondarObject(object11);
        return world;
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
