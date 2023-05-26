package com.example.workeatwork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class Account extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;



    ImageView profilepic;
    TextView name, Nname, Npassword;
    Button save;
    Uri imageUri;

    FirebaseStorage storage;
    StorageReference storageRef;
    FirebaseUser user;
    FirebaseAuth mAuth;
    String imageUrl;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        profilepic = findViewById(R.id.profilepic);
        name = findViewById(R.id.name);
        //update
        Nname = findViewById(R.id.newname);
        Npassword = findViewById(R.id.newpassword);
        save = findViewById(R.id.btnsave);

        name.setText(user.getDisplayName());
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        findViewById(R.id.profilepic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });


        findViewById(R.id.btnsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();

                //new
                String newName = Nname.getText().toString();
                String newPassword = Npassword.getText().toString();

                if (newName.isEmpty()) {
                    Snackbar.make(findViewById(android.R.id.content), "Please enter a name and password.", Snackbar.LENGTH_LONG).show();
                } else {
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(newName)
                            .build();

                    user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Snackbar.make(findViewById(android.R.id.content), "User profile updated.", Snackbar.LENGTH_LONG).show();
                                saveUsernameInSharedPreferences(newName);
                                name.setText(newName);
                               //finish();
                            }
                        }
                    });
                }

                if (!newPassword.isEmpty()) {
                    user.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Snackbar.make(findViewById(android.R.id.content), "Password updated.", Snackbar.LENGTH_LONG).show();
                            } else {
                                Snackbar.make(findViewById(android.R.id.content), "Failed to update password.", Snackbar.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }

        });

    }

    private void saveUsernameInSharedPreferences(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.apply();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            imageUri = data.getData();
            profilepic.setImageURI(imageUri);

            Intent intent = new Intent(Account.this, Homepage.class);
            intent.putExtra("profile_image_uri", imageUri.toString());
            startActivity(intent);
        }
    }
    private void saveChanges() {
        if (imageUri != null) {
            StorageReference fileReference = storageRef.child("images/" + UUID.randomUUID().toString());

            fileReference.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUrl = fileReference.getDownloadUrl();
                            downloadUrl.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    imageUrl = uri.toString();
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(name.getText().toString())
                                            .setPhotoUri(Uri.parse(imageUrl))
                                            .build();

                                    user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                                            if(task.isSuccessful()) {
                                                Snackbar.make(findViewById(android.R.id.content), "User profile updated.", Snackbar.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Snackbar.make(findViewById(android.R.id.content), "Error: " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                        }
                    });
        }

    }





    //for open filechooser
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

    }



   //for save change




  /*  public void openLogin(View view) {
        Intent intent = new Intent(Account.this, Login.class);
        startActivity(intent);
    }

    public void openHomepage(View view) {
        Intent intent = new Intent(Account.this, Homepage.class);
        startActivity(intent);
    }*/
}