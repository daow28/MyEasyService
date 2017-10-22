package app.tsc.rotchanan.myeasyservice;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.tsc.rotchanan.myeasyservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Fragment to Activity
        addFragment(savedInstanceState);

        // Setup Drawer Menu
        setupDrawerMenu();

        // Text Controller
        textController();


    } // Main Method

    private void textController() {
        TextView mainTextView = (TextView) findViewById(R.id.txtMainFragment);
        TextView secondTextView = (TextView) findViewById(R.id.txtSecondFragment);
        TextView exitTextView = (TextView) findViewById(R.id.txtExit);

        // For Main Fragment
        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Close Drawer
                drawerLayout.closeDrawers();

            }
        });

        // For Second Fragment
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Close Drawer
                drawerLayout.closeDrawers();

            }
        });

        // For Exit
        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Close Drawer
                drawerLayout.closeDrawers();

            }
        });



    }

    private void setupDrawerMenu() {
        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayout);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, new MainFragment()).commit();
        }
    }

}  // Main Class
