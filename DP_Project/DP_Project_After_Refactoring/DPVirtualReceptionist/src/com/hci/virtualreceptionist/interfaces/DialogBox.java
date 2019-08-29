package com.hci.virtualreceptionist.interfaces;

import android.app.FragmentManager;

public interface DialogBox {

	public void show(FragmentManager manager, String tag);  //Strategy Pattern
	
}
