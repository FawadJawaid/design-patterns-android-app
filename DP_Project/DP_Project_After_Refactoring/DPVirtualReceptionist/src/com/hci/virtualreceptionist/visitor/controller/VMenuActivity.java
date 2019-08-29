package com.hci.virtualreceptionist.visitor.controller;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.hci.virtualreceptionist.NullFragment;
import com.hci.virtualreceptionist.R;
import com.hci.virtualreceptionist.visitor.views.FragmentVisitorHomePlay;

@SuppressLint("NewApi")
public class VMenuActivity extends FragmentActivity {

	// The MainLayout which will hold both the sliding menu and our main content
    // Main content will holds our Fragment respectively
    VMenuLayout mainLayout;
    
    private ArrayList<VMenuItem> navDrawerItems;
	private VMenuListAdapter adapter;
	
	
	ImageButton logOutBtn;
	TextView logOutBtnTitle;
	String token;
    
    // ListView menu
    private ListView lvMenu;
    private String[] lvMenuItems;
    private TypedArray menuIcons;
    
    // Menu button
    ImageButton btMenu;
    
    // Title according to fragment
    TextView tvTitle;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inflate the mainLayout
        mainLayout = (VMenuLayout)this.getLayoutInflater().inflate(R.layout.activity_vmenu, null);
        setContentView(mainLayout);
        
        // Init menu
        
        lvMenuItems = getResources().getStringArray(R.array.vmenu_items);
        
		menuIcons = getResources()
				.obtainTypedArray(R.array.vnav_drawer_icons);
        
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
        
        //Intent i = getIntent();
        Intent gameOverintent = getIntent();
        int value = gameOverintent.getIntExtra("gameover", 0);
        
        //token = gameOverintent.getStringExtra("ACCESS");
        
        //Log.v("TOKEN IN MENU", token);
        
        navDrawerItems = new ArrayList<VMenuItem>();

		// adding nav drawer items to array
		// Home
        navDrawerItems.add(new VMenuItem(lvMenuItems[0], 0));
		// Find People
        navDrawerItems.add(new VMenuItem(lvMenuItems[1], 0));
		// Photos
        navDrawerItems.add(new VMenuItem(lvMenuItems[2], 0));
		// Communities, Will add a counter here
        navDrawerItems.add(new VMenuItem(lvMenuItems[3], 0));
		// Pages
        navDrawerItems.add(new VMenuItem(lvMenuItems[4], 0));
		// What's hot, We  will add a counter here
        //navDrawerItems.add(new VMenuItem(lvMenuItems[5], menuIcons.getResourceId(5, -1)));
		
		// Recycle the typed array
		menuIcons.recycle();
        
        /*lvMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lvMenuItems));*/
		
		adapter = new VMenuListAdapter(getApplicationContext(),
				navDrawerItems);
		lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }
            
        });
        
      
        
        // Get menu button
        btMenu = (ImageButton) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });
        
        logOutBtn = (ImageButton) findViewById(R.id.logoutbtn);
        logOutBtnTitle = (TextView) findViewById(R.id.logouttitle);
        logOutBtnTitle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onClickLogout();
				
			}
		});
        
        
        // Add FragmentMenu as the initial fragment       
        FragmentManager fm = VMenuActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        Fragment fragment = new FragmentVisitorHomePlay();
        
        /*if(token!=null){
        Bundle args = new Bundle();
		args.putString("Access Token", token);
		fragment.setArguments(args);}*/
        
        ft.add(R.id.activity_main_content_fragment, fragment);
        ft.commit();
        
        //Intent gameOverintent = getIntent();
        //int value = gameOverintent.getIntExtra("gameover", 0);
        
   
        
    }
        
    private void  onClickLogout() {
    	Intent homeIntent= new Intent(Intent.ACTION_MAIN);
    	homeIntent.addCategory(Intent.CATEGORY_HOME);
    	homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	startActivity(homeIntent);
       
    }

 
    public void toggleMenu(View v){
        mainLayout.toggleMenu();
    }
    
    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = lvMenuItems[position];
        
        FragmentManager fm = VMenuActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        
        VFragmentFactory fac = new VFragmentFactory();    //Simple Factory Method Pattern
        fragment = fac.createFragment(selectedItem);
        

        if(!((NullFragment) fragment).isNull()) {
            // Replace current fragment by this new one
            ft.replace(R.id.activity_main_content_fragment, fragment);
            ft.commit();
        }
        
        // Hide menu anyway
        mainLayout.toggleMenu();
    }
    
    

}
