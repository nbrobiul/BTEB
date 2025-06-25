package com.dalazu.bteb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dalazu.bteb.utils.Constant;
import com.dalazu.bteb.utils.NoticeAdapter;
import com.dalazu.bteb.R;
import com.dalazu.bteb.model.Notice;
import com.dalazu.bteb.utils.BaseActivity;

import java.util.ArrayList;

public class BtebNoticeActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ArrayList<Notice> noticeList;

    private NoticeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bteb_notice);

        setupToolbar(R.id.materialToolbar);
        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        noticeList = new ArrayList<>();

        noticeList.add(new Notice("BTEB Chairman Resigned!", "What is happening in bteb board.What is happening in bteb board", "20/12/2024", "https://drive.google.com/file/d/1QanUlfr6Ekxc_zBr0KvoNTbct6erh7HX/view?usp=sharing"));
        noticeList.add(new Notice("Result will Publish 20/10/2024 ", "What is happening in bteb board.What is happening in bteb board", "20/12/2024", "https://drive.google.com/file/d/12_o-hN94zdfHkNtpUc_UC9sUWZV4fWRs/view?usp=sharing"));
        noticeList.add(new Notice("50% Student Are Failed in Exam", "What is happening in bteb board.What is happening in bteb board", "20/12/2024", ""));
        noticeList.add(new Notice("100% student failed in lakhipur", "What is happening in bteb board.What is happening in bteb board", "20/12/2024", ""));
        noticeList.add(new Notice("What is happening in Bteb Dhaka Board", "What is happening in bteb board.What is happening in bteb board", "20/12/2024", ""));
        noticeList.add(new Notice("What is going in Cpi polytechnic", "What is happening in bteb board.What is happening in bteb board", "20/12/2024", ""));
        noticeList.add(new Notice("New Education Minister Changing System", "What is happening in bteb board.What is happening in bteb board", "20/12/2024", ""));

        adapter = new NoticeAdapter(noticeList, new NoticeAdapter.OnNoticeClickListener() {
            @Override
            public void onItemClick(Notice notice) {
                if (notice.getPdfurl() != null) {
                    Intent intent = new Intent(BtebNoticeActivity.this, InAppBrowser.class);
                    intent.putExtra(Constant.NOTICE, notice);
                    startActivity(intent);
                }
            }
        });
        recyclerView.setAdapter(adapter);

    }

}