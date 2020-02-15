package anis.zarrouk.mynewsoc.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import anis.zarrouk.mynewsoc.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.activity_main_viewer_pager) ViewPager pager;
    @BindView(R.id.activity_main_tabs) TabLayout tabs;
    @BindView(R.id.activity_main_drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.activity_main_navigation_view) NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.configureToolbar();
        this.configureViewerPagerAndTabs();
        this.configureNavigationView();
        this.configureDrawerLayout();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.toolbar_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void configureToolbar() {
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("My News");
    }


    @Override
    public void onBackPressed() {
        if(this.mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            this.mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void configureViewerPagerAndTabs() {
       pager.setAdapter(new PagerAdapter(getSupportFragmentManager(), 0));
       tabs.setupWithViewPager(pager);
       tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    private void  configureNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(this);
    }
    private void configureDrawerLayout(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,
               toolbar , R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
         switch (menuItem.getItemId()){
             case R.id.activity_main_top_stories:
                 pager.setCurrentItem(0);
                 break;
             case R.id.activity_main_most_popular:
                 pager.setCurrentItem(1);
                 break;
             case R.id.activity_main_business:
                 pager.setCurrentItem(2);
                 break;
             case R.id.activity_main_sports:
                 pager.setCurrentItem(3);
                 break;
             case R.id.activity_main_search:
                 startActivity(new Intent(this, SearchActivity.class));
                 break;
             default:
                 pager.setCurrentItem(0);
                 break;
         }
         this.mDrawerLayout.closeDrawer(GravityCompat.START);
         return true;
    }
}
