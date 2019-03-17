package com.zo0okadev.newspulse;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.zo0okadev.newspulse.ui.AppViewModel;
import com.zo0okadev.newspulse.utils.AppRater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AppViewModel appViewModel;
    private NavController navController;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (!isConnected()) {
            Toast.makeText(this, "No internet connection found \n Please check your connection and try again.",
                    Toast.LENGTH_LONG).show();
        }

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        AppRater.launchTracker(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView version = (TextView) navigationView.getMenu().findItem(R.id.nav_app_version).getActionView();
        version.setText(BuildConfig.VERSION_NAME);
        version.setGravity(Gravity.CENTER);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_latest_news, R.id.nav_edition_news, R.id.nav_news_sections, R.id.nav_privacy_policy)
                .setDrawerLayout(drawer)
                .build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);

    }

    private boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }


    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.nav_search).getActionView();
        assert searchManager != null;
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 2) {
                    appViewModel.setSearchQuery(query);
                    navController.navigate(R.id.nav_search_results);
                } else {
                    Toast.makeText(MainActivity.this, "Type more than two letters!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_latest_news) {
            navController.navigate(R.id.nav_latest_news);
        } else if (id == R.id.nav_aus_headlines) {
            appViewModel.setEditionId("aus");
            ((TextView) findViewById(R.id.toolbar_sub_header)).setText(getString(R.string.australia_headlines));
            navController.navigate(R.id.nav_edition_news);
        } else if (id == R.id.nav_uk_headlines) {
            appViewModel.setEditionId("uk");
            ((TextView) findViewById(R.id.toolbar_sub_header)).setText(getString(R.string.uk_headlines));
            navController.navigate(R.id.nav_edition_news);
        } else if (id == R.id.nav_us_headlines) {
            appViewModel.setEditionId("us");
            ((TextView) findViewById(R.id.toolbar_sub_header)).setText(getString(R.string.us_headlines));
            navController.navigate(R.id.nav_edition_news);
        } else if (id == R.id.nav_news_sections) {
            ((TextView) findViewById(R.id.toolbar_sub_header)).setText(getString(R.string.news_sections));
            navController.navigate(R.id.nav_news_sections);
        } else if (id == R.id.nav_rate_app) {
            showRateDialog();
        } else if (id == R.id.nav_feedback) {
            openFeedback();
        } else if (id == R.id.nav_privacy_policy) {
            navController.navigate(R.id.nav_privacy_policy);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openFeedback() {
        Intent feedbackIntent = new Intent(Intent.ACTION_SENDTO);
        feedbackIntent.setData(Uri.parse("mailto:"));
        feedbackIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"enghazemdahab82@gmail.com"});
        feedbackIntent.putExtra(Intent.EXTRA_CC, "hazem09021982@gmail.com");
        String appName = getString(R.string.app_name);
        feedbackIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for " + appName + " Android App");
        String version = BuildConfig.VERSION_NAME;
        feedbackIntent.putExtra(Intent.EXTRA_TEXT, "\n\n----------------------------------\n Device OS: Android \n Device OS version: " +
                Build.VERSION.RELEASE + "\n App Version: " + version + "\n Device Brand: " + Build.BRAND +
                "\n Device Model: " + Build.MODEL + "\n Device Manufacturer: " + Build.MANUFACTURER);
        if (feedbackIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(feedbackIntent, "Choose an Email client: "));
        }
    }

    private void showRateDialog() {
        SharedPreferences sharedPreferences = getSharedPreferences("apprater", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        AppRater.showRateDialog(this, editor);
    }
}
