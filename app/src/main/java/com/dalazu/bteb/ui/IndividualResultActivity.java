package com.dalazu.bteb.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dalazu.bteb.R;
import com.dalazu.bteb.api.ApiClient;
import com.dalazu.bteb.api.ServiceGenerator;
import com.dalazu.bteb.model.Result;
import com.dalazu.bteb.utils.BaseActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndividualResultActivity extends BaseActivity {


    private TextInputLayout tiBoardRoll, tiSemester, tiExamYear;
    private TextInputEditText etBoardRoll;
    private AutoCompleteTextView etSemester, etYear;
    private MaterialButton btnSearchResult;
    private ProgressBar progressBar;
    private MaterialCardView resultCard;
    private ImageView imgBanner;
    private TextView tvRoll, tvSemester, tvYear, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_individual_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        setupToolbar(R.id.materialToolbar);
        initializeView();

    }

    private void initializeView() {
        tiBoardRoll = findViewById(R.id.ti_board_roll);
        tiSemester = findViewById(R.id.ti_semester);
        tiExamYear = findViewById(R.id.ti_exam_year);
        etBoardRoll = findViewById(R.id.et_board_roll);
        etSemester = findViewById(R.id.et_semester);
        etYear = findViewById(R.id.et_exam_year);
        progressBar = findViewById(R.id.progress_bar);
        btnSearchResult = findViewById(R.id.btn_search_result);
        resultCard = findViewById(R.id.result_card);
        imgBanner = findViewById(R.id.img_banner);
        tvRoll = findViewById(R.id.tv_roll);
        tvSemester = findViewById(R.id.tv_semester);
        tvYear = findViewById(R.id.tv_exam_year);
        tvResult = findViewById(R.id.tv_result);

        String[] exam_semester = getResources().getStringArray(R.array.semester);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, exam_semester);
        etSemester.setText(arrayAdapter.getItem(0).toString(), false);
        etSemester.setAdapter(arrayAdapter);

        String[] exam_year = getResources().getStringArray(R.array.exam_yaer);
        ArrayAdapter arrayAdapter1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, exam_year);
        etYear.setText(arrayAdapter1.getItem(0).toString(), false);
        etYear.setAdapter(arrayAdapter1);

        btnSearchResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String boardroll = etBoardRoll.getText().toString().trim();
                int semester = Integer.parseInt(etSemester.getText().toString().trim());
                int year = Integer.parseInt(etYear.getText().toString().trim());

                ApiClient apiClient = ServiceGenerator.createService(ApiClient.class);
                apiClient.getResult(year, semester, boardroll).enqueue(new Callback<List<Result>>() {
                    @Override
                    public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                        if (response.isSuccessful()) {

                            List<Result> results = response.body();

                            if (results != null && !results.isEmpty()) {
                                for (Result result : results) {
                                    tvRoll.setText("Board Roll: " + result.getRoll());
                                    tvSemester.setText("Semester: " + String.valueOf(result.getSemester()));
                                    tvYear.setText("Exam Year: " + String.valueOf(result.getYear()));

                                    if ("passed".equals(result.getStatus())) {
                                        if (result.getResult() instanceof String) {
                                            String cgpa = (String) result.getResult();
                                            tvResult.setText("CGPA: " + cgpa);
                                        }
                                    } else if ("failed".equals(result.getStatus())) {
                                        if (result.getResult() instanceof List) {
                                            @SuppressWarnings("unchecked")
                                            List<String> failedSubjects = (List<String>) result.getResult();
                                            tvResult.setText("Failed Subjects: " + failedSubjects.toString());
                                        }
                                    }
                                    resultCard.setVisibility(View.VISIBLE);
                                }
                            } else {
                                Toast.makeText(IndividualResultActivity.this, "No results found!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(IndividualResultActivity.this, "Failed to fetch results!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Result>> call, Throwable throwable) {
                    }
                });
            }
        });
    }
}
