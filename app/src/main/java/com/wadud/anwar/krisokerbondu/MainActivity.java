package com.wadud.anwar.krisokerbondu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    TextView textView;
    private  int check = 0;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;

    private BazarDorFragment bazarDorFragment;
    private MulPataFragment mulPataFragment;
    private BikriBiggaponFragment bikriBiggaponFragment;
    private FosolFragment fosolFragment;
    private JugajugFragment jugajugFragment;
    private KrishiProjuktiFragment krishiProjuktiFragment;
    private MotsoSompodFragment motsoSompodFragment;
    private PraniSompodFragment praniSompodFragment;
    private SongrokkonFragment songrokkonFragment;
    FragmentTransaction fragmentTransaction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout)findViewById(R.id.frame);
        textView = (TextView)findViewById(R.id.mainPataTextView);
        textView.setText(readTextFile("mulpata.txt"));


        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        frameLayout.setVisibility(View.GONE);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
               // menuItem.setChecked(true);
                setTitle(menuItem.getTitle());

                //Closing drawer on item click
                drawerLayout.closeDrawers();
                frameLayout.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){

                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_mulPata:
                        check = 0;
                        mulPataFragment = new MulPataFragment(readTextFile("mulpata.txt"));
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,mulPataFragment);
                        fragmentTransaction.commit();
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.nav_fosol:
                        check = 1;
                       fosolFragment = new FosolFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,fosolFragment);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.nav_prani:
                        check = 2;
                        praniSompodFragment = new PraniSompodFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,praniSompodFragment);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.nav_mas:
                        check = 3;
                        motsoSompodFragment = new MotsoSompodFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,motsoSompodFragment);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.nav_bazarDor:
                        check = 4;
                        bazarDorFragment = new BazarDorFragment();
                       // FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, bazarDorFragment);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.nav_bikri:
                        check = 5;
                        bikriBiggaponFragment = new BikriBiggaponFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,bikriBiggaponFragment);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.nav_jugajug:
                        check = 6;
                        jugajugFragment = new JugajugFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,jugajugFragment);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.nav_songrokkon:
                        check = 7;
                        songrokkonFragment = new SongrokkonFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,songrokkonFragment);
                        fragmentTransaction.commit();
                        return true;

                    case R.id.nav_projukti:
                        check = 1;
                        krishiProjuktiFragment = new KrishiProjuktiFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,krishiProjuktiFragment);
                        fragmentTransaction.commit();
                        return true;

                    default:
                        check = 0;
                        frameLayout.setVisibility(View.GONE);
                        textView.setVisibility(View.VISIBLE);
                        return true;

                }

            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onBackPressed() {
        if(frameLayout.getVisibility() ==View.VISIBLE) {
            if(check == 4){
                bazarDorFragment.onBackPressed();
                if(bazarDorFragment.check == 0)
                    homepage();
            }else  {
                homepage();
            }
        }else{
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            // Yes button clicked
                            finish();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };

           AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog)
                    .setPositiveButton(R.string.yes, dialogClickListener)
                    .setNegativeButton(R.string.no, dialogClickListener).show();


        }

    }
    public void homepage(){
        setTitle(R.string.app_name);
        //navigationView.setCheckedItem(R.id.nav_mulPata);
        frameLayout.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    public String readTextFile(String name) {
        try {
            InputStream inputStream = this.getAssets().open(name);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String textFile = new String(buffer);
            return textFile;
        }catch (IOException e){
            return  "File Could not read";
        }
    }
}
