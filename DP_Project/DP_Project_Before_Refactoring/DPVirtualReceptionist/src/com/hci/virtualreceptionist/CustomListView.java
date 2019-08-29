package com.hci.virtualreceptionist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
 
public class CustomListView {
 
 MyCustomAdapter dataAdapter = null;
 Context cont = null;
 
 public CustomListView(Context context)
 {
	 this.cont = context;
 }
 
 public void displayListView() {
 
  /**
   * 
   * Bad Smell = Long Method (Temp with Query)
   * makeEmployee()	 
   *
   **/
	 
	 
  //Array list of countries
  ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
  Employee Employee = new Employee("Software Engineer","ABC",false); // Refactored
  EmployeeList.add(Employee);
  Employee = new Employee("Tester","DEF",true);
  EmployeeList.add(Employee);
  Employee = new Employee("QA","GHI",false);
  EmployeeList.add(Employee);                                        // Refactored  
  
 
  /**
   * Bad Smell = Long Method (Extract Method)
   * onClickLisItem() and
   * settingList() created
   */
  
  //create an ArrayAdaptar from the String Array
  dataAdapter = new MyCustomAdapter(cont,                                      //Refactored
    R.layout.custom_listview, EmployeeList);
  ListView listView = (ListView) ((Activity)cont).findViewById(R.id.listView1);
  // Assign adapter to ListView
  listView.setAdapter(dataAdapter);                                            //Refactored  
 
 
  listView.setOnItemClickListener(new OnItemClickListener() {                  //Refactored
   public void onItemClick(AdapterView<?> parent, View view,
     int position, long id) {
    // When clicked, show a toast with the TextView text
    Employee Employee = (Employee) parent.getItemAtPosition(position);
    Toast.makeText(cont,
      "Clicked on Row: " + Employee.getName(), 
      Toast.LENGTH_LONG).show();
   }
  });                                                                          //Refactored   
 
 }
 
 private class MyCustomAdapter extends ArrayAdapter<Employee> {
 
  private ArrayList<Employee> EmployeeList;
 
  public MyCustomAdapter(Context context, int textViewResourceId, 
    ArrayList<Employee> EmployeeList) {
   super(context, textViewResourceId, EmployeeList);
   this.EmployeeList = new ArrayList<Employee>();
   this.EmployeeList.addAll(EmployeeList);
  }
 
  private class ViewHolder {
   TextView code;
   CheckBox name;
  }
 
  /**
   * Bad Smell = Long Method (Extract Method)
   * listItemDecorator(View convertView) created
   */
  
  
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
 
   ViewHolder holder = null;                                                //Refactored
   Log.v("ConvertView", String.valueOf(position));
 
   if (convertView == null) {
   LayoutInflater vi = (LayoutInflater)cont.getSystemService(
     Context.LAYOUT_INFLATER_SERVICE);
   convertView = vi.inflate(R.layout.custom_listview, null);
 
   holder = new ViewHolder();
   holder.code = (TextView) convertView.findViewById(R.id.code);
   holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
   convertView.setTag(holder);
 
    holder.name.setOnClickListener( new View.OnClickListener() {  
     public void onClick(View v) {  
      CheckBox cb = (CheckBox) v ;  
      Employee Employee = (Employee) cb.getTag();  
      Toast.makeText(cont,
       "Clicked on Checkbox: " + cb.getText() +
       " is " + cb.isChecked(), 
       Toast.LENGTH_LONG).show();
      Employee.setSelected(cb.isChecked());
     }  
    });  
   } 
   else {
    holder = (ViewHolder) convertView.getTag();                                //Refactored
   }
 
   Employee Employee = EmployeeList.get(position);
   holder.code.setText(" (" +  Employee.getDesignation() + ")");
   holder.name.setText(Employee.getName());
   holder.name.setChecked(Employee.isSelected());
   holder.name.setTag(Employee);
 
   return convertView;
 
  }
 
 }
 
}

