package com.andrew749.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.andrew749.tutorialcardlibrary.TutorialEntry;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<TutorialEntry> entries = new ArrayList<TutorialEntry>();
        entries.add(new TutorialEntry(R.drawable.ic_launcher, "Hello"));
        entries.add(new TutorialEntry(R.drawable.ic_launcher, "Big"));
        entries.add(new TutorialEntry(R.drawable.ic_launcher, "Boy"));
        Intent intent = new Intent(getApplicationContext(), com.andrew749.tutorialcardlibrary.TutorialsCardActivity.class);
        intent.putExtra("entries", entries);

        startActivity(intent);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
