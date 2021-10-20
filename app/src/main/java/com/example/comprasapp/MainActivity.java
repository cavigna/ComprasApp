package com.example.comprasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;

import com.example.comprasapp.databinding.ActivityMainBinding;
import com.example.comprasapp.viewmodel.ComprasViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ComprasViewModel viewModel;
    BottomNavigationView bottomNav;
    FloatingActionButton fb;


    NavController  navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        bottomNav = binding.botomNav;
        fb = binding.fbAgregarCompra;

        viewModel = new ViewModelProvider(this).get(ComprasViewModel.class);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainerView);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        enrutador(bottomNav);
        irFb(fb);

    }

    public void enrutador(BottomNavigationView bottomNav){
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case (R.id.go_to_listFragment):
                    navController.navigate(R.id.listFragment);
                    break;
            }
            return true;
        });
    }

    public void irFb(FloatingActionButton floatingActionButton){
        fb.setOnClickListener(view -> {
            navController.navigate(R.id.action_homeFragment_to_addFragment);
        });
    }
}