package com.gs.VeterinaryCare;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
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

    ShapeableImageView profilePicture;
    TextView signInButton;
    boolean isUsrLoggedIn = false;
   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        Toolbar mToolbar = binding.topAppToolBar;
        setSupportActionBar(mToolbar);
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
            signInButton.setOnClickListener(view -> {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                activityResultLauncher.launch(signInIntent);
            });

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case (int)R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;

            case (int) R.id.sign_out_item:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                return true;

            default:    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.removeItem(isUsrLoggedIn ? R.id.sign_in_item : R.id.sign_out_item);
        return super.onPrepareOptionsMenu(menu);
    }



    //Following Code For Google SignIn.
   // @Override // CHECKS FOR LAST SIGNED ACCOUNT
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    //HANDLE THE SIGN_IN PROCESS
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
            Toast.makeText(this, "Account Is Not Logged In", Toast.LENGTH_SHORT).show();
        } else {
            isUsrLoggedIn = true;
            profilePicture = findViewById(R.id.rounded_usr_profile);

            User usr = new User(
                    account.getDisplayName(),
                    account.getEmail(),
                    account.getId(),
                    account.getPhotoUrl());

            Glide.with(this).load(usr.getUsrImage()).into(profilePicture);
            profilePicture.setVisibility(View.VISIBLE);
        }

        invalidateOptionsMenu();
    }

}