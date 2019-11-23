package com.kyawhtut.facebookreactbadgelib;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.kyawhtut.fbReact.Emoji;
import com.kyawhtut.fbReact.ReactBadge;

public class JavaTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReactBadge reactBadge = new ReactBadge(this);

        reactBadge.setReactCount(1);
        reactBadge.setReact(Emoji.LOVE);
        reactBadge.animationDuration = 500;
        reactBadge.setAnimationEnabled(true);
        reactBadge.setNumberConvertEnabled(true);
        reactBadge.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        reactBadge.setTextSize(24f);
        reactBadge.show();
        reactBadge.clear();
    }
}
