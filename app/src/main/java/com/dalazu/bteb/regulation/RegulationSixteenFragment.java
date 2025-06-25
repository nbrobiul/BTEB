package com.dalazu.bteb.regulation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.dalazu.bteb.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

import kotlin.contracts.Returns;


public class RegulationSixteenFragment extends Fragment {

    double number;
    double sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8;
    DecimalFormat Formatter;
    private TextInputLayout tiSemester, tiFirstSemester, tiSecondSemester, tiThirdSemester, tiFourthSemester, tiFifthSemester, tiSixSemester, tiSevenSemester, tiEightSemester;
    private TextInputEditText etFirstSemester, etSecondSemester, etThirdSemester, etFourthSemester, etFifthSemester, etSixSemester, etSevenSemster, etEightSemester;
    private MaterialButton btnGetCgpa;
    private TextView cgpaResult;
    private AutoCompleteTextView etSemester;
    private String[] semesters = {"1", "2", "3", "4", "5", "6", "7", "8"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_regulation_sixteen_fragment, container, false);
        etSemester = view.findViewById(R.id.et_semester);
        tiSemester = view.findViewById(R.id.ti_semester);
        tiFirstSemester = view.findViewById(R.id.ti_first_semester);
        tiSecondSemester = view.findViewById(R.id.ti_second_semester);
        tiThirdSemester = view.findViewById(R.id.ti_third_semester);
        tiFourthSemester = view.findViewById(R.id.ti_fourth_semester);
        tiFifthSemester = view.findViewById(R.id.ti_fifth_semester);
        tiSixSemester = view.findViewById(R.id.ti_six_semester);
        tiSevenSemester = view.findViewById(R.id.ti_seven_semester);
        tiEightSemester = view.findViewById(R.id.ti_eight_semester);

        etFirstSemester = view.findViewById(R.id.et_first_semester);
        etSecondSemester = view.findViewById(R.id.et_second_semester);
        etThirdSemester = view.findViewById(R.id.et_third_semester);
        etFourthSemester = view.findViewById(R.id.et_fourth_semester);
        etFifthSemester = view.findViewById(R.id.et_fifth_semester);
        etSixSemester = view.findViewById(R.id.et_six_semester);
        etSevenSemster = view.findViewById(R.id.et_seven_semester);
        etEightSemester = view.findViewById(R.id.et_eight_semester);

        btnGetCgpa = view.findViewById(R.id.btn_get_cgpa);

        cgpaResult = view.findViewById(R.id.tv_cgpa_result);

        Formatter = new DecimalFormat("#0.00");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, semesters);
        etSemester.setThreshold(1);
        etSemester.setAdapter(arrayAdapter);

        etSemester.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String semester = etSemester.getText().toString().trim();
                if (semester.isEmpty()) {
                } else {
                    number = Double.parseDouble(etSemester.getText().toString().trim());
                    if (number == 1) {
                        Toast.makeText(getContext(), "At Least Two Semester Required!", Toast.LENGTH_SHORT).show();
                    } else if (number == 2) {
                        etFirstSemester.setVisibility(View.VISIBLE);
                        etSecondSemester.setVisibility(View.VISIBLE);
                        etThirdSemester.setVisibility(View.GONE);
                        etFourthSemester.setVisibility(View.GONE);
                        etFifthSemester.setVisibility(View.GONE);
                        etSixSemester.setVisibility(View.GONE);
                        etSevenSemster.setVisibility(View.GONE);
                        etEightSemester.setVisibility(View.GONE);
                    } else if (number == 3) {
                        etFirstSemester.setVisibility(View.VISIBLE);
                        etSecondSemester.setVisibility(View.VISIBLE);
                        etThirdSemester.setVisibility(View.VISIBLE);
                        etFourthSemester.setVisibility(View.GONE);
                        etFifthSemester.setVisibility(View.GONE);
                        etSixSemester.setVisibility(View.GONE);
                        etSevenSemster.setVisibility(View.GONE);
                        etEightSemester.setVisibility(View.GONE);

                    } else if (number == 4) {
                        etFirstSemester.setVisibility(View.VISIBLE);
                        etSecondSemester.setVisibility(View.VISIBLE);
                        etThirdSemester.setVisibility(View.VISIBLE);
                        etFourthSemester.setVisibility(View.VISIBLE);
                        etFifthSemester.setVisibility(View.GONE);
                        etSixSemester.setVisibility(View.GONE);
                        etSevenSemster.setVisibility(View.GONE);
                        etEightSemester.setVisibility(View.GONE);

                    } else if (number == 5) {
                        etFirstSemester.setVisibility(View.VISIBLE);
                        etSecondSemester.setVisibility(View.VISIBLE);
                        etThirdSemester.setVisibility(View.VISIBLE);
                        etFourthSemester.setVisibility(View.VISIBLE);
                        etFifthSemester.setVisibility(View.VISIBLE);
                        etSixSemester.setVisibility(View.GONE);
                        etSevenSemster.setVisibility(View.GONE);
                        etEightSemester.setVisibility(View.GONE);

                    } else if (number == 6) {
                        etFirstSemester.setVisibility(View.VISIBLE);
                        etSecondSemester.setVisibility(View.VISIBLE);
                        etThirdSemester.setVisibility(View.VISIBLE);
                        etFourthSemester.setVisibility(View.VISIBLE);
                        etFifthSemester.setVisibility(View.VISIBLE);
                        etSixSemester.setVisibility(View.VISIBLE);
                        etSevenSemster.setVisibility(View.GONE);
                        etEightSemester.setVisibility(View.GONE);

                    } else if (number == 7) {
                        etFirstSemester.setVisibility(View.VISIBLE);
                        etSecondSemester.setVisibility(View.VISIBLE);
                        etThirdSemester.setVisibility(View.VISIBLE);
                        etFourthSemester.setVisibility(View.VISIBLE);
                        etFifthSemester.setVisibility(View.VISIBLE);
                        etSixSemester.setVisibility(View.VISIBLE);
                        etSevenSemster.setVisibility(View.VISIBLE);
                        etEightSemester.setVisibility(View.GONE);

                    } else if (number == 8) {
                        etFirstSemester.setVisibility(View.VISIBLE);
                        etSecondSemester.setVisibility(View.VISIBLE);
                        etThirdSemester.setVisibility(View.VISIBLE);
                        etFourthSemester.setVisibility(View.VISIBLE);
                        etFifthSemester.setVisibility(View.VISIBLE);
                        etSixSemester.setVisibility(View.VISIBLE);
                        etSevenSemster.setVisibility(View.VISIBLE);
                        etEightSemester.setVisibility(View.VISIBLE);

                    }
                }
            }
        });

        btnGetCgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etFirstSemester.getText().toString().isEmpty() || etSecondSemester.getText().toString().isEmpty()) {
                    etFirstSemester.setError("Enter First Semester");
                    etFirstSemester.requestFocus();
                } else {
                    if (etFirstSemester.getVisibility() == View.GONE) {
                        sem1 = 0;
                    } else {
                        sem1 = Double.parseDouble(etFirstSemester.getText().toString().trim());
                    }
                    if (etSecondSemester.getVisibility() == View.GONE) {
                        sem2 = 0;
                    } else {
                        sem2 = Double.parseDouble(etSecondSemester.getText().toString().trim());
                    }
                    if (etThirdSemester.getVisibility() == View.GONE) {
                        sem3 = 0;
                    } else {
                        sem3 = Double.parseDouble(etThirdSemester.getText().toString().trim());

                    }
                    if (etFourthSemester.getVisibility() == View.GONE) {
                        sem4 = 0;
                    } else {
                        sem4 = Double.parseDouble(etFourthSemester.getText().toString().trim());
                    }
                    if (etFifthSemester.getVisibility() == View.GONE) {
                        sem5 = 0;
                    } else {
                        sem5 = Double.parseDouble(etFifthSemester.getText().toString().trim());
                    }
                    if (etSixSemester.getVisibility() == View.GONE) {
                        sem6 = 0;
                    } else {
                        sem6 = Double.parseDouble(etSixSemester.getText().toString().trim());
                    }
                    if (etSevenSemster.getVisibility() == View.GONE) {
                        sem7 = 0;
                    } else {
                        sem7 = Double.parseDouble(etSevenSemster.getText().toString().trim());
                    }
                    if (etEightSemester.getVisibility() == View.GONE) {
                        sem8 = 0;
                    } else {
                        sem8 = Double.parseDouble(etEightSemester.getText().toString().trim());
                    }
                }


                Double total = (sem1 * 5 + sem2 * 5 + sem3 * 5 + sem4 * 15 + sem5 * 15 + sem6 * 20 + sem7 * 25 + sem8 * 10) / 100;
                cgpaResult.setText(Formatter.format(total));
            }
        });
        return view;

    }

}