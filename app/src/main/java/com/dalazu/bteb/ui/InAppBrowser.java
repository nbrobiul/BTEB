package com.dalazu.bteb.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dalazu.bteb.R;
import com.dalazu.bteb.model.Notice;
import com.dalazu.bteb.utils.BaseActivity;
import com.dalazu.bteb.utils.Constant;

public class InAppBrowser extends BaseActivity {
    private WebView webView;
    private Notice notice;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_in_app_browser);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        notice = (Notice) getIntent().getSerializableExtra(Constant.NOTICE);
        setupToolbar(R.id.materialToolbar);

        dialog = new ProgressDialog(this);

        dialog.setCancelable(false);
        dialog.show();

        getSupportActionBar().setTitle(notice.getTitle());
        webView = findViewById(R.id.web_view);

        String pdfUrl = notice.getPdfurl();

        if (notice.getPdfurl().isEmpty()) {
            dialog.setMessage("Notice Not Found!");
            dialog.setCancelable(true);
        } else {
            dialog.setMessage("Please Wait...");
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                    webView.setWebViewClient(new WebViewClient());
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.loadUrl(pdfUrl);
                }
            }, 2000);
        }

    }
}