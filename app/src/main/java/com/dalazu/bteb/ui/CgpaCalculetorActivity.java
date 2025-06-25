package com.dalazu.bteb.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.dalazu.bteb.R;
import com.dalazu.bteb.regulation.RegulationSixteenFragment;
import com.dalazu.bteb.regulation.RegulationTenFragment;
import com.dalazu.bteb.regulation.RegulationTwentyTwoFragment;
import com.dalazu.bteb.utils.BaseActivity;
import com.dalazu.bteb.utils.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class CgpaCalculetorActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RegulationTenFragment regTen;
    private RegulationSixteenFragment regSixteen;
    private RegulationTwentyTwoFragment regTwentyTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cgpa_calculetor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupToolbar(R.id.materialToolbar);

        intializeView();
    }

    private void intializeView() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        regTen = new RegulationTenFragment();
        regSixteen = new RegulationSixteenFragment();
        regTwentyTwo = new RegulationTwentyTwoFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);

        viewPagerAdapter.addFragment(regTen, "REG-10");
        viewPagerAdapter.addFragment(regSixteen, "REG-16");
        viewPagerAdapter.addFragment(regTwentyTwo, "REG-22");

        viewPager.setAdapter(viewPagerAdapter);

    }


}