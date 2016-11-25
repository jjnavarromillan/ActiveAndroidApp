package com.example.proharvesting.activeandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextFirstName;
    EditText editTextLastName;
    Button buttonAdd;
    TextView textViewMessage;
    EmployeeItemAdapter employeeItemAdapter;
    ListView ListViewEmployees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        ActiveAndroid.initialize(this);

    }
    public void initComponents(){
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
        ListViewEmployees = (ListView) findViewById(R.id.ListViewEmployees);
        viewList();

    }

    public void addEmployee(View view) {
        if(!editTextFirstName.getText().toString().toString().equals("") && !editTextLastName.getText().toString().toString().equals("")){

            Employee employee =  new Employee();
            employee.FirstName = editTextFirstName.getText().toString();
            employee.LastName = editTextLastName.getText().toString();
            employee.save();
            editTextFirstName.setText("");
            editTextLastName.setText("");
            textViewMessage.setText("Employee Added "+employee.FirstName + " "+ employee.LastName + " => total Employees "+Employee.getAllEmployees().size());
            viewList();

        }
        else {
            textViewMessage.setText("Must add FirstName and LastName");
        }
    }
    public void viewList(){
        employeeItemAdapter = new EmployeeItemAdapter(this,Employee.getAllEmployees());
        ListViewEmployees.setAdapter(employeeItemAdapter);

    }
}
