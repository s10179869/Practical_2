package sg.edu.np.practical2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser=findViewById((R.id.web));
        browser.setWebViewClient(new WebViewClient());
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);

        final EditText textbox = findViewById(R.id.editText);
        textbox.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent){
                //if the keyevent is a key-down event on the "enter" button
                if((keyevent.getAction() == keyevent.ACTION_DOWN) && (keyCode == keyevent.KEYCODE_ENTER))
                {

                    String url = textbox.getText().toString();
                    browser.loadUrl(url);

                    return true;
                }
                return false;
            }
        });
    }

    public void onClick(View v)
    {
        EditText text = findViewById(R.id.editText);
        String url = text.getText().toString();

        browser.loadUrl(url);
    }
}
