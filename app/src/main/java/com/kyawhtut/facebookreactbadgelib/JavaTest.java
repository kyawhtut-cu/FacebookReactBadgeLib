package com.kyawhtut.facebookreactbadgelib;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kyawhtut.fbReact.Emoji;
import com.kyawhtut.fbReact.ReactBadge;

public class JavaTest extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReactBadge reactBadge = new ReactBadge(this);
        reactBadge.setReact(Emoji.LIKE);
    }
}
