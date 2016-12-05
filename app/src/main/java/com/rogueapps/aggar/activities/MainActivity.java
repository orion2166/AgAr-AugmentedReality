package com.rogueapps.aggar.activities;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.util.location.BeyondarLocationManager;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.World;
import com.rogueapps.aggar.R;
import com.rogueapps.aggar.controllers.GeoObjectController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnClickBeyondarObjectListener {

    /*-------Variables--------*/
    private Location currentLocation;
    private MiLocationListener milocListener;
    private BeyondarFragmentSupport mBeyondarFragment;
    private World world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        configureARModule();
        configureLocationModule();
        configureSidebar(toolbar);
    }

    private void configureARModule() {
        mBeyondarFragment = (BeyondarFragmentSupport) getSupportFragmentManager().findFragmentById(R.id.beyondarFragment);
        mBeyondarFragment.setMaxDistanceToRender(100);
        mBeyondarFragment.setOnClickBeyondarObjectListener(this);
        world = new World(this);
        world.setDefaultBitmap(R.drawable.vulpix, World.LIST_TYPE_DEFAULT);
        world = GeoObjectController.fillWorld(world);
        mBeyondarFragment.setWorld(world);
    }

    private void configureLocationModule() {
        milocListener = new MiLocationListener();
        BeyondarLocationManager.setLocationManager((LocationManager) getSystemService(Context.LOCATION_SERVICE));
        BeyondarLocationManager.addWorldLocationUpdate(world);
        BeyondarLocationManager.addLocationListener(milocListener);
    }

    private void configureSidebar(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BeyondarLocationManager.disable();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BeyondarLocationManager.enable();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClickBeyondarObject(ArrayList<BeyondarObject> beyondarObjects) {
        BeyondarObject touchedObject = beyondarObjects.get(0);
        TextView view = (TextView) findViewById(R.id.targetText);
        TextView desc = (TextView) findViewById(R.id.textDesc);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        switch((int)touchedObject.getId()){
            case 0:
            case 11:
                view.setText("MSC");
                desc.setText("Popularly known as \"The Living Room of Texas A&M\", the Memorial Student Center (MSC) has been a living memorial, a living room, and a living tradition at Texas A&M University. Dedicated on Muster Day (April 21) in 1951, the MSC was originally dedicated to those Aggies who gave their lives during World Wars I and II, but was later rededicated to all Aggies who have given or will give their lives in wartime.[85] Because the building and grounds are a memorial, those entering the MSC are asked to \"uncover\" (remove their hats) and not walk on the surrounding grass lawns.[86]\n" +
                        "On the main floor of the MSC is the Flagroom, a large, flag-lined room which students use for meetings, visiting, napping, and studying. The MSC also contains a bookstore, a bank, three art galleries, three dining facilities, and two ballrooms, one of which named after Robert Gates. Additionally, the MSC contains many meeting rooms and is the home of numerous student committees \"that provide an array of educational, cultural, recreational and entertainment programs for the Texas A&M community.\"[85]\n" +
                        "In 2007, the Aggie student body voted for $122 million renovations to the Memorial Student Center, allowing it to become fully compliant with both fire code and the Americans with Disabilities Act. The project began in the summer of 2009, requiring the building to remain closed due to the renovations.[87] The renovations increased the size of the building to accommodate the growing school population, and make more efficient use of existing space.[88][89] The MSC reopened on Muster Day, April 21, 2012, 61 years after its original opening.");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.mscpic));
                break;
            case 1:
                view.setText("12 Man Statue");
                desc.setText("On Jan. 2, 1922, the heavily outgunned Aggies were facing the top-ranked Centre College Praying Colonels on the gridiron in the Dixie Classic in Dallas. An Aggie by the name of E. King Gill, a squad player for Texas A&M’s football team, was up in the press box helping reporters identify players on the field below — and what was happening on the field wasn’t pretty.\n" +
                        "The Aggies found themselves plagued by injuries, with their reserves seemingly dwindling with every play. As Texas A&M Coach Dana X. Bible looked across his rapidly emptying bench, he suddenly remembered Gill’s presence in the stands. Bible waved Gill down to the sideline and told him to suit up. Gill ran under the bleachers and put on the uniform of injured running back Heine Weir, who had been knocked out of the game in the first quarter.\n" +
                        "Gill returned to the sideline, where he stood ready to play for the entirety of the game. When the last play was run, the Aggies found that they had pulled off one of the greatest upsets in college football history, winning the game 22-14.\n" +
                        "And Gill remained standing, the only player left on the team’s bench.");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.manstatpic));
                break;
            case 2:
                view.setText("Koldus");
                desc.setText("The John J. Koldus Student Services Building is located in the heart of Aggieland, providing you convenient access to secure parking, food establishments and neighboring views of the Memorial Student Center and Kyle Field. Offering both indoor and outdoor event space, the Koldus Student Services Building is a perfect choice for your next event.");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kolduspic));
                break;
            case 3:
                view.setText("Kyle Field");
                desc.setText("Kyle Field is the football stadium located on the campus of Texas A&M University in College Station, Texas. It has been the home to the Texas A&M Aggie football team in rudimentary form since 1904, and as a complete stadium since 1927. It is known as the \"Home of the 12th Man\". The seating capacity of 102,733 in 2015 makes the stadium the largest in the Southeastern Conference and the fourth largest stadium in the NCAA, fourth largest stadium in the United States, and the fifth largest non-racing stadium in the world. Within the state of Texas, Kyle Field has the largest regular seating capacity, while AT&T Stadium has a larger overall capacity.[3]\n" +
                        "Kyle Field's largest game attendance was 110,631 people when Texas A&M lost to the Ole Miss Rebels with the score of 20–35 on October 11, 2014.[5] This was the largest football game attendance in the state of Texas and SEC history.");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kylepic));
                break;
            case 4:
                view.setText("Rudder Tower");
                desc.setText("Rudder Tower, located next to the Memorial Student Center, is an ideal venue for meetings, trainings, conferences, presentations and retreats.  At 11-stories high, Rudder Tower offers picturesque views of the Texas A&M University campus and surrounding community, providing you a unique and distinctive setting for your next event.");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rudderpic));
                break;
            case 5:
                view.setText("Teague building");
                desc.setText("The center was built in 1967, and is located on Lamar Street, south of the Administration Building. In front of the building is the Exploration in Space sculpture. The center was partly funded by a $1 million grant from NASA. The nuclear engineering department has several offices, classrooms and laboratories in the yellow-brick building. It also houses the statistics department.\n" +
                        "The building is named after Olin E. “Tiger” Teague, class of 1932. Teague was a World War II veteran who participated in the D-Day Normandy invasion. According to the Texas State Historical Association, he is the second most-decorated U.S. combat soldier of WWII. During his 32 years in the U.S. House of Representatives, he was a champion for veterans’ rights and the space program.");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.teaguepic));
                break;
            case 6:
            case 12:
                view.setText("");
                desc.setText("");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rudderevntpic1));
                break;
            case 7:
                view.setText("");
                desc.setText("");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rudderevntpic2));
                break;
            case 8:
                view.setText("");
                desc.setText("");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rudderevent3));
                break;
            case 9:
                view.setText("");
                desc.setText("");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.msceventpic1));
                break;
            case 10:
                view.setText("");
                desc.setText("");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.msceventpic2));
                break;
            default:
                view.setText("");
                desc.setText("");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.side_nav_bar));
                break;
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.openDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*-----------Location Data--------------*/
    private class MiLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location newLocation) {
            currentLocation = newLocation;
            TextView view = (TextView) findViewById(R.id.textView);
            view.setText("----------\nLat = " + currentLocation.getLatitude()
                            + "\nLongitude = " + currentLocation.getLongitude()
                            + "\n----------");
        }

        public void onProviderDisabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Desactivado",
                    Toast.LENGTH_SHORT).show();
        }

        public void onProviderEnabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Activo",
                    Toast.LENGTH_SHORT).show();
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }
}
