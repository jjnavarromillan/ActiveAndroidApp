package com.example.proharvesting.activeandroidapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


//employee_item
public class EmployeeItemAdapter extends BaseAdapter {

    private Activity activity;
    private List<Employee> employeeList;
    private static LayoutInflater inflater=null;
    public EmployeeItemAdapter(Activity activity, List<Employee> employeeList) {
        this.activity = activity;
        this.employeeList=employeeList;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return employeeList.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolderRowContact{
        public TextView textViewID;
        public TextView textViewFirstName;
        public TextView textViewLastName;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        ViewHolderRowContact holder;
        if(convertView==null){
            vi = inflater.inflate(R.layout.employee_item, null);
            holder = new ViewHolderRowContact();
            holder.textViewID=(TextView)vi.findViewById(R.id.textViewID);
            holder.textViewFirstName=(TextView)vi.findViewById(R.id.textViewFirstName);
            holder.textViewLastName=(TextView)vi.findViewById(R.id.textViewLastName);
            vi.setTag( holder );
        }
        else
            holder=(ViewHolderRowContact)vi.getTag();
        holder.textViewID.setText(""+employeeList.get(position).getId());
        holder.textViewFirstName.setText(""+employeeList.get(position).FirstName);
        holder.textViewLastName.setText(""+employeeList.get(position).LastName);
        return vi;
    }
}
