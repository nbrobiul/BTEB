package com.dalazu.bteb.utils;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dalazu.bteb.R;
import com.google.android.material.appbar.MaterialToolbar;

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    //   toolbar On back pressed icon start
    public void setupToolbar(int id) {
        MaterialToolbar toolbar = (MaterialToolbar) findViewById(id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    //   toolbar On back pressed icon end
}
