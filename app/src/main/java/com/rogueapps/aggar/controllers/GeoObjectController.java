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
        GeoObject object = GeoObjectController.createGeoObject(0L,30.612543, -96.340518,"MSC", R.drawable.msc);
        GeoObject object1 = GeoObjectController.createGeoObject(1L,30.611939, -96.340210,"12 Man Statue", R.drawable.manst);
        GeoObject object2 = GeoObjectController.createGeoObject(2L,30.612232, -96.339673,"Koldus", R.drawable.koldus);
        GeoObject object3 = GeoObjectController.createGeoObject(3L,30.611450, -96.340349,"Kyle Field", R.drawable.kyle);
        GeoObject object4 = GeoObjectController.createGeoObject(4L,30.612731, -96.340248,"Rudder Tower", R.drawable.ruddertower);
        GeoObject object5 = GeoObjectController.createGeoObject(5L,30.611461, -96.340360,"Kyle Services", R.drawable.kyleservices);
        GeoObject object6 = GeoObjectController.createGeoObject(6L,30.612626, -96.340061,"Event 1", R.drawable.rudderevnt1);
        GeoObject object7 = GeoObjectController.createGeoObject(7L,30.612926,-96.339811,"Event 2", R.drawable.rudderevnt2);
        GeoObject object8 = GeoObjectController.createGeoObject(8L,30.612932,-96.339799,"Event 3", R.drawable.rudderevent3);
        GeoObject object9 = GeoObjectController.createGeoObject(9L,30.612374,-96.340634,"Event 4", R.drawable.mscevent1);
        GeoObject object10 = GeoObjectController.createGeoObject(10L,30.612365,-96.340666,"Event 5", R.drawable.mscevent2);
        GeoObject object11 = GeoObjectController.createGeoObject(0L,30.612789, -96.340312,"rudderuti1", R.drawable.restroom);
        GeoObject object12 = GeoObjectController.createGeoObject(0L,30.612377, -96.340576,"mscresturant", R.drawable.resturant);
        GeoObject object13 = GeoObjectController.createGeoObject(0L,30.612760, -96.340365,"rudderprinter", R.drawable.printer);
//        GeoObject object11 = GeoObjectController.createGeoObject(11L,30.608272, -96.343835,"test", R.drawable.wcg);
//        GeoObject object12 = GeoObjectController.createGeoObject(11L,30.6080015,-96.3432006,"test2", R.drawable.rec);
//        GeoObject object13 = GeoObjectController.createGeoObject(11L,30.607545, -96.342589,"test3", R.drawable.weightroom);
//        GeoObject object14 = GeoObjectController.createGeoObject(11L,30.607458, -96.342683,"test4", R.drawable.racketball);
//        GeoObject object15 = GeoObjectController.createGeoObject(11L,30.608272, -96.343835,"test5", R.drawable.wcg);
//        GeoObject object16 = GeoObjectController.createGeoObject(11L,30.607679, -96.342955,"test6", R.drawable.rec);
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
        world.addBeyondarObject(object12);
        world.addBeyondarObject(object13);
//        world.addBeyondarObject(object14);
//        world.addBeyondarObject(object15);
//        world.addBeyondarObject(object16);

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
