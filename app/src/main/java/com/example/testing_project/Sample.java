package com.example.testing_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Sample extends AppCompatActivity {


    FirebaseFirestore firestore;
//    EditText editTextName, editTextEmail, editTextPassword, editTextAge;
//    RadioGroup radioGroupGender;
//    RadioButton radioMale, radioFemale;
//    DatePicker datePicker;
//    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firestore = FirebaseFirestore.getInstance();

        Map<String,Object> user = new HashMap<>();
        user.put("firstName","Easy");
        user.put("lastName","Tuto");
        user.put("decription","Subscribe");

        firestore.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();
            }
        });

//        // Initialize views
//        editTextName = findViewById(R.id.editTextName);
//        editTextEmail = findViewById(R.id.editTextEmail);
//        editTextPassword = findViewById(R.id.editTextPassword);
//        editTextAge = findViewById(R.id.editTextAge);
//        radioGroupGender = findViewById(R.id.radioGroupGender);
//        radioMale = findViewById(R.id.radioMale);
//        radioFemale = findViewById(R.id.radioFemale);
//        datePicker = findViewById(R.id.datePicker);
//        submitButton = findViewById(R.id.submitButton);

//        // Set submit button click listener
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Capture form data
//                String name = editTextName.getText().toString();
//                String email = editTextEmail.getText().toString();
//                String password = editTextPassword.getText().toString();
//
//                // Get selected gender
//                String gender = "";
//                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
//                if (selectedGenderId == R.id.radioMale) {
//                    gender = "Male";
//                } else if (selectedGenderId == R.id.radioFemale) {
//                    gender = "Female";
//                }
//
//                // Get date of birth and calculate age
//                int day = datePicker.getDayOfMonth();
//                int month = datePicker.getMonth();
//                int year = datePicker.getYear();
//                int age = calculateAge(year, month, day);
//                editTextAge.setText(String.valueOf(age));
//
//                // Handle form submission (e.g., send data to server, show in log, etc.)
//            }
//        });
    }

//    // Calculate age based on date of birth
//    private int calculateAge(int year, int month, int day) {
//        Calendar dob = Calendar.getInstance();
//        dob.set(year, month, day);
//        Calendar today = Calendar.getInstance();
//        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
//        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
//            age--;
//        }
//        return age;
//    }
}
