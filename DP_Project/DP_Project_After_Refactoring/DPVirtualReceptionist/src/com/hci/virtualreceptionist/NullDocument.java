package com.hci.virtualreceptionist;

import com.hci.virtualreceptionist.employee.controller.Document;

public class NullDocument extends Document {
	
	public NullDocument(String etitle, String efile) {
		super(etitle, efile);
	}

	public boolean isNull() {
        return true;
    }
}