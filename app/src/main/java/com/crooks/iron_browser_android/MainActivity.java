package com.crooks.iron_browser_android;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button back;
    Button forward;
    Button go;
    EditText addressBar;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back = (Button) findViewById(R.id.back);
        forward = (Button) findViewById(R.id.forward);
        go = (Button) findViewById(R.id.go);
        addressBar = (EditText) findViewById(R.id.addressBar);
        webView = (WebView) findViewById(R.id.webView);

        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        go.setOnClickListener(this);

        webView.setWebViewClient(new WebViewClient() {      //calling an anonymous class by throwing in curly brackets

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                addressBar.setText(url);                    //Setting the address bar to show the new URL as you browse.
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==back){
            webView.goBack();
        }else if(v==forward){
            webView.goForward();
        }else if (v==go){
            String url = addressBar.getText().toString();
            if (!url.startsWith("http")){
                url = "http://" + url;
            }
            webView.loadUrl(url);
        }

    }
}
