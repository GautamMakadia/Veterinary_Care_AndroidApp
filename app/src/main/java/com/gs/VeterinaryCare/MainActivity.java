package com.gs.VeterinaryCare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.gs.VeterinaryCare.DataResource.User;
import com.gs.VeterinaryCare.databinding.ActivityMainBinding;
import com.gs.VeterinaryCare.ui.main.Fav_List;
import com.gs.VeterinaryCare.ui.main.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity {

    TextView signInButton;
    TextView signOutButton;
    ShapeableImageView profilePicture;
    boolean isUsrLoggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Fav_List.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        //Sign In With Google.
        {
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

            GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

            ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                handleSignInResult(task);
            });

            //On Click Sign In Button
            //Launch Google Account Lists
            signInButton = findViewById(R.id.sign_in_item);
            signOutButton = findViewById(R.id.sign_out_item);
            signInButton.setOnClickListener(view -> {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                activityResultLauncher.launch(signInIntent);
            });
        }
    }


    //Following Code For Google SignIn.
    @Override // CHECKS FOR LAST SIGNED ACCOUNT
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    //HANDLE THE SIGNIN PROCESS
    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            updateUI(account);
        }catch (ApiException e){
            updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account) {
        if (account == null) {
            try {
                MenuItem soutitem = (MenuItem) signOutButton;
                soutitem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
            } catch (Exception e){
                Toast.makeText(this, " SignOut Not Removed", Toast.LENGTH_SHORT).show();
            }

        } else {
            isUsrLoggedIn = true;
            profilePicture = findViewById(R.id.rounded_usr_profile);

            User usr = new User(
                    account.getDisplayName(),
                    account.getEmail(),
                    account.getId(),
                    account.getPhotoUrl());

            signInButton.setVisibility(View.GONE);

            Glide.with(this).load(usr.getUsrImage()).into(profilePicture);
            profilePicture.setVisibility(View.VISIBLE);
        }
    }
}