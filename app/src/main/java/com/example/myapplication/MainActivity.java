package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText searchText;
    private TextView displayView;
    private TextView resultsSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchText=(EditText)findViewById(R.id.et_search_box);
        displayView=(TextView)findViewById(R.id.tv_url_display);
        resultsSearchView=(TextView)findViewById(R.id.tv_github_search_results_json);
        }
    private void makeGithubSearchQuery(){
        String githubQuery = searchText.getText().toString();
        URL githubSearchUrl= NetworkUtils.buildUrl(githubQuery);
        displayView.setText(githubSearchUrl.toString());
    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemsThatWasClicked=item.getItemId();
        if(itemsThatWasClicked == R.id.action_search){
            makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
