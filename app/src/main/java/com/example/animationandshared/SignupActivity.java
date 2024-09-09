package com.example.animationandshared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SignupActivity extends AppCompatActivity {


    Button submit;
    EditText pass, User;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        submit = findViewById(R.id.submit);
        pass = findViewById(R.id.password);
        User = findViewById(R.id.username);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Name = User.getText().toString().trim();
                String Password = pass.getText().toString().trim();

                database(Name, Password);
                getdatabase();


                Toast.makeText(SignupActivity.this, "Account created Successfully", Toast.LENGTH_SHORT).show();
            }


        });


    }

    private void database(String Name, String Password) {
        ModelUser modeluser = new ModelUser(Name, Password);
        db.collection("Teacher").add(modeluser)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(SignupActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignupActivity.this, "Error adding data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getdatabase() {
        db.collection("Teacher").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    List<String> list = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        list.add(document.getId());
                    }
                    Toast.makeText(SignupActivity.this, "Documents: " + list.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupActivity.this, "Error getting documents: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignupActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

              Intent i = new Intent(SignupActivity.this, LoginActivity.class);
              startActivity(i);
              finish();
    }

}