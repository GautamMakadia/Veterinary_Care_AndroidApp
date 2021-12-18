package com.gs.VeterinaryCare;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.gs.VeterinaryCare.Adapters.ViewpagerAdapter;
import com.gs.VeterinaryCare.DataResource.User;
import com.gs.VeterinaryCare.databinding.ActivityMainBinding;
import com.gs.VeterinaryCare.ui.main.Fav_List;


public class MainActivity extends AppCompatActivity {

    private ShapeableImageView profilePicture;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInAccount account;
    User usr;
    private ActivityResultLauncher<Intent> activityResultLauncher;
    boolean isUsrLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        AppBarLayout appBarLayout = binding.appBarLayout;
        MaterialToolbar materialToolbar = binding.topAppToolBar;
        setSupportActionBar(materialToolbar);

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), getLifecycle());
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setAdapter(viewpagerAdapter);

        TabLayout tabs = binding.tabs;
        new TabLayoutMediator(tabs, viewPager,(tab, position) -> {
            switch (position){
                case 0 :
                    tab.setText("Animals");
                    break;

                case 1 :
                    tab.setText("Pets");
                    break;

                case 2 :
                    tab.setText("Birds");
                    break;
            }
        }).attach();

        ExtendedFloatingActionButton fab = binding.fab;
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, Fav_List.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);
        });

        profilePicture = binding.roundedUsrProfile;

        setContentView(binding.getRoot());

        //Sign In With Google.
        {
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

            activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                handleSignInResult(task);
            });
        }

        //Fixing Positioning Of Views
        {
            ViewCompat.setOnApplyWindowInsetsListener(appBarLayout, (v, windowInsets) -> {
                Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars());

                appBarLayout.setPadding(insets.left, insets.top, insets.right, insets.bottom);

                return WindowInsetsCompat.CONSUMED;
            });

            ViewCompat.setOnApplyWindowInsetsListener(viewPager, (v, windowInsets) -> {
                Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars());

                viewPager.setPadding(insets.left, insets.top, insets.right, insets.bottom);

                return WindowInsetsCompat.CONSUMED;
            });

            ViewCompat.setOnApplyWindowInsetsListener(fab, (v, windowInsets) -> {
                Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars());

                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
                mlp.leftMargin = insets.left;
                mlp.bottomMargin = insets.bottom + 40;
                mlp.rightMargin = insets.right + 40;
                v.setLayoutParams(mlp);

                return WindowInsetsCompat.CONSUMED;
            });
        }

    }

    protected void onStart() {
        super.onStart();
        account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case (int)R.id.sign_in_item:
                activityResultLauncher.launch(mGoogleSignInClient.getSignInIntent());
                return true;

            case (int)R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;

            case (int) R.id.sign_out_item:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                signOut();
                return true;

            default:    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(isUsrLoggedIn ? R.id.sign_in_item : R.id.sign_out_item);
        return super.onPrepareOptionsMenu(menu);
    }

    // CHECKS FOR LAST SIGNED ACCOUNT
    // HANDLE THE SIGN_IN PROCESS
    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            account = task.getResult(ApiException.class);
            updateUI(account);
        }catch (ApiException e){
            updateUI(null);
        }
    }

    //Updates The UI Based On Whether User Is LoggedIn Or Not.
    protected void updateUI(GoogleSignInAccount account) {
        if (account == null) {
            isUsrLoggedIn = false;
            usr = null;
            profilePicture.setVisibility(View.GONE);
            Toast.makeText(this, "Account Is Not Logged In", Toast.LENGTH_SHORT).show();
        } else {
            isUsrLoggedIn = true;
            usr = new User(
                    account.getDisplayName(),
                    account.getEmail(),
                    account.getId(),
                    account.getPhotoUrl());
            Glide.with(this).load(usr.getUsrImage()).into(profilePicture);
            profilePicture.setVisibility(View.VISIBLE);
            Toast.makeText(this, "LoggedIn SuccessFully", Toast.LENGTH_SHORT).show();
        }
        invalidateOptionsMenu();
    }

    // Method To SIgnOut User From App.
    private void signOut() {
        mGoogleSignInClient.signOut().addOnCompleteListener(OnCompleteListener->{
            isUsrLoggedIn = false;
            updateUI(account);
        });
    }
}