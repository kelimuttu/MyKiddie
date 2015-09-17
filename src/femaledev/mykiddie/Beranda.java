package femaledev.mykiddie;

import mykiddie.tabsswipe.adapter.TabsPagerAdapter;
import femaledev.mykiddie.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Beranda extends FragmentActivity implements
ActionBar.TabListener {
	
	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Tips", "Jadwal" };
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
 
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);       
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
 
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
 
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }
 
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tentang, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
        	    case R.id.tentang:
            	Tentang.Launch(this);
                break;
        }
        return true;
    }
    
    public void changeActivity(View v) {
		Intent it; 
		if(findViewById(R.id.kategori1) == v){
			it = new Intent(this, Kategori1.class);
		} else if(findViewById(R.id.kategori2) == v){
			it = new Intent(this, Kategori2.class);
		} else if(findViewById(R.id.kategori3) == v){
			it = new Intent(this, Kategori3.class);
		} else {
			it = new Intent(this, Beranda.class);
		}
		
		startActivity(it);
	}
    
    public void buatjadwal (View v) {
		Intent it; 
		if(findViewById(R.id.jadwal1) == v){
			it = new Intent(this, DetailJadwal.class);
		} else if(findViewById(R.id.jadwal4) == v){
			it = new Intent(this, DetailJadwal2.class);
		} else {
			it = new Intent(this, Beranda.class);
		}
		
		startActivity(it);
	}
    
}