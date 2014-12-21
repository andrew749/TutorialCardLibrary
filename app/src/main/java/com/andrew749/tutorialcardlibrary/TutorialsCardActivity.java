package com.andrew749.tutorialcardlibrary;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;


public class TutorialsCardActivity extends Activity implements View.OnClickListener {
    ImageSwitcher switcher;
    Button next, previous;
    int index = 0;
    TextView descriptionText;
    ArrayList<TutorialEntry> entries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.CustomTutorialTheme);
        setContentView(R.layout.tutorials_card);
        this.entries = (ArrayList<TutorialEntry>) getIntent().getSerializableExtra("entries");
        switcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        next = (Button) findViewById(R.id.nextButton);
        descriptionText = (TextView) findViewById(R.id.descriptionText);
        previous = (Button) findViewById(R.id.previousButton);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.
                        FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
                myView.setImageResource(entries.get(index).image);
                return myView;
            }
        });


    }

    public void nextImage() {
        Animation in = AnimationUtils.makeInAnimation(getApplicationContext(), false);
        Animation out = AnimationUtils.makeOutAnimation(getApplicationContext(), false);
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);
        if (index < entries.size() - 1) {
            switcher.setImageResource(entries.get(++index).image);
            descriptionText.setText(entries.get(index).description);
        } else finish();
        if (index == entries.size() - 1)
            next.setText("Finish");
    }

    @Override
    public void finish() {
        super.finish();
    }

    public void previousImage() {
        Animation in = AnimationUtils.makeInAnimation(getApplicationContext(), true);
        Animation out = AnimationUtils.makeOutAnimation(getApplicationContext(), true);
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);
        if (index > 0) {
            switcher.setImageResource(entries.get(--index).image);
            descriptionText.setText(entries.get(index).description);
        }


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.nextButton)
            nextImage();
        else if (id == R.id.previousButton)
            previousImage();
    }
}
