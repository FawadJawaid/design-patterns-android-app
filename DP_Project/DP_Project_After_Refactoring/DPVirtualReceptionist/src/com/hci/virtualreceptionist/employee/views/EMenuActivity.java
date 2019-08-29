package com.hci.virtualreceptionist.employee.views;

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
import com.hci.virtualreceptionist.employee.controller.EFragmentFactory;
import com.hci.virtualreceptionist.employee.controller.EMenuItem;
import com.hci.virtualreceptionist.employee.controller.EMenuLayout;
import com.hci.virtualreceptionist.employee.controller.EMenuListAdapter;

@SuppressLint("NewApi")
public class EMenuActivity extends FragmentActivity {

	// The MainLayout which will hold both the sliding menu and our main content
    // Main content will holds our Fragment respectively
    EMenuLayout mainLayout;
    
    private ArrayList<EMenuItem> navDrawerItems;
	private EMenuListAdapter adapter;
	
	
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
        mainLayout = (EMenuLayout)this.getLayoutInflater().inflate(R.layout.activity_emenu, null);
        setContentView(mainLayout);
        
        // Init menu
        
        lvMenuItems = getResources().getStringArray(R.array.emenu_items);
        
		menuIcons = getResources()
				.obtainTypedArray(R.array.enav_drawer_icons);
        
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
        
        //Intent i = getIntent();
        Intent gameOverintent = getIntent();
        int value = gameOverintent.getIntExtra("gameover", 0);
        
        //token = gameOverintent.getStringExtra("ACCESS");
        
        //Log.v("TOKEN IN MENU", token);
        
        navDrawerItems = new ArrayList<EMenuItem>();

		// adding nav drawer items to array
		// Home
        navDrawerItems.add(new EMenuItem(lvMenuItems[0],0));
		// Find People
        navDrawerItems.add(new EMenuItem(lvMenuItems[1], 0));
		// Photos
        navDrawerItems.add(new EMenuItem(lvMenuItems[2], 0));
		// Communities, Will add a counter here
        navDrawerItems.add(new EMenuItem(lvMenuItems[3], 0));
		// Pages
        navDrawerItems.add(new EMenuItem(lvMenuItems[4], 0));
        
        navDrawerItems.add(new EMenuItem(lvMenuItems[5], 0));
		
        navDrawerItems.add(new EMenuItem(lvMenuItems[6], 0));
        
        navDrawerItems.add(new EMenuItem(lvMenuItems[7], 0));
	
		// Recycle the typed array
		menuIcons.recycle();
        
        /*lvMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lvMenuItems));*/
		
		adapter = new EMenuListAdapter(getApplicationContext(),
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
        FragmentManager fm = EMenuActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        Fragment fragment = new FragmentEmployeeHome();
        
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
        
    
        FragmentManager fm = EMenuActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        
        EFragmentFactory fac = new EFragmentFactory();     //Simple Factory Method Pattern
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

