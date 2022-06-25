package com.example.quiztutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firedata extends AppCompatActivity {
    Spinner mySpinner;
    String[] countryName;
    DatabaseReference databaseReference;
    EditText f_name,l_name;
    Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firedata);
        mySpinner=findViewById(R.id.mySpinerID);
        countryName=getResources().getStringArray(R.array.countryName);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.sample_spinner_layout,R.id.textViewSampleId,countryName);
        mySpinner.setAdapter(adapter);
        databaseReference= FirebaseDatabase.getInstance().getReference("StudentName");
        f_name=findViewById(R.id.edit_name);
        l_name=findViewById(R.id.edit_position);
        toastButton = findViewById(R.id.submit);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Firedata.this,"Thank you!",Toast.LENGTH_LONG).show();
            }
        });


    }


    public void SubmitFunction(View view) {
        String id=f_name.getText().toString();
        String name=l_name.getText().toString();
        databaseReference.child(id).setValue(name);



    }
}
