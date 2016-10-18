package com.zjn.javaandjs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.wv);
        mWebView.getSettings().setJavaScriptEnabled(true);
        String path = "file:///android_asset/index.html";
        mWebView.loadUrl(path);
        mWebView.addJavascriptInterface(this, "wst");
        findViewById(R.id.btn_calljs).setOnClickListener(this);
        findViewById(R.id.btn_calljs_withparam).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_calljs:
                mWebView.loadUrl("javascript:javacalljs()");
                break;
            case R.id.btn_calljs_withparam:
                String hello = "hello";
                mWebView.loadUrl("javascript:javacalljswithargs('" + hello + "')");
                break;
        }
    }


    /**
     * js调用java方法
     */
    @JavascriptInterface
    public void startFunction() {
        Toast.makeText(this, "js调用java方法（不带参）", Toast.LENGTH_LONG).show();
    }

    /**
     * js调用java方法（带参数）
     *
     * @param str
     */
    @JavascriptInterface
    public void startFunction(String str) {
        Toast.makeText(this, "js调用java方法（带参）：" + str, Toast.LENGTH_LONG).show();
    }


}
