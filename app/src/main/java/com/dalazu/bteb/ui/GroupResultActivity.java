package com.dalazu.bteb.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dalazu.bteb.R;
import com.dalazu.bteb.utils.BaseActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class GroupResultActivity extends BaseActivity {
    private TextInputLayout tiStartRoll, tiEndRoll, tiSemester, tiExamYear;
    private TextInputEditText etStartRoll, etEndRoll;
    private AutoCompleteTextView etSemester, etExamYear;
    private MaterialButton btnSearchResult;
    private MaterialCardView resultCard;
    private ImageView imgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_group_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupToolbar(R.id.materialToolbar);

        initialieView();

    }

    private void initialieView() {
        tiStartRoll = findViewById(R.id.ti_start_roll);
        tiEndRoll = findViewById(R.id.ti_end_roll);
        tiSemester = findViewById(R.id.ti_semester);
        tiExamYear = findViewById(R.id.ti_exam_year);

        etStartRoll = findViewById(R.id.et_start_roll);
        etEndRoll = findViewById(R.id.et_end_roll);

        etSemester = findViewById(R.id.et_semester);
        etExamYear = findViewById(R.id.et_exam_year);

        btnSearchResult = findViewById(R.id.btn_search_result);

        resultCard = findViewById(R.id.result_card);

        imgBanner = findViewById(R.id.img_banner);

        String[] exam_semester = getResources().getStringArray(R.array.semester);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, exam_semester);
        etSemester.setText(arrayAdapter.getItem(0).toString(), false);
        etSemester.setAdapter(arrayAdapter);

        String[] exam_year = getResources().getStringArray(R.array.exam_yaer);
        ArrayAdapter arrayAdapter1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, exam_year);
        etExamYear.setText(arrayAdapter1.getItem(0).toString(), false);
        etExamYear.setAdapter(arrayAdapter1);

    }


}