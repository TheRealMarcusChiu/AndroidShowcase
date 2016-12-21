package com.example.marcuschiu.showcase.background;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcuschiu.showcase.R;

import java.util.HashMap;

public class HttpGetActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private EditText editText;
    private TextView textView;
    private HttpURLConnectionHelper httpURLConnectionHelper;

    //must be unique in activity/fragment
    private int LOADER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_http_get_activity);

        editText = (EditText) findViewById(R.id.url);
        textView = (TextView) findViewById(R.id.response);

        httpURLConnectionHelper = new HttpURLConnectionHelper();
    }

    public void setHttp(View view) {
        editText.setText("http://www.tcgplayer.com/");
    }

    public void setHttps(View view) {
        editText.setText("https://www.google.com/");
    }

    public void go(View view) {
        Bundle bundle = new Bundle();
        String url = editText.getText().toString();
        bundle.putString("URL", url);
        getLoaderManager().initLoader(LOADER_ID, bundle, this);
        LOADER_ID++;
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        Toast.makeText(this, "onCreateLoader", Toast.LENGTH_SHORT).show();
        String url = args.getString("URL");
        return new HttpAsyncTaskLoader(this, HttpRequestMethod.GET, url, new HashMap<String, String>());
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        Toast.makeText(this, "onLoadFinished", Toast.LENGTH_SHORT).show();
        textView.setText(data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        Toast.makeText(this, "onLoaderReset", Toast.LENGTH_SHORT).show();
    }
}
