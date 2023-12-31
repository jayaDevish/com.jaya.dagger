package com.jaya.bootcamp.learndagger.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import com.jaya.bootcamp.learndagger.MyApplication;
import com.jaya.bootcamp.learndagger.R;
import com.jaya.bootcamp.learndagger.di.component.DaggerActivityComponent;
import com.jaya.bootcamp.learndagger.di.module.ActivityModule;
import com.jaya.bootcamp.learndagger.ui.home.HomeFragment;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getDependencies();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvData = findViewById(R.id.tv_message);
        tvData.setText(viewModel.getSomeData());

        addHomeFragment();
    }

    private void addHomeFragment() {
        if(getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG) == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit();
        }
    }

    private void getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getApplication()).applicationComponent)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }
}
