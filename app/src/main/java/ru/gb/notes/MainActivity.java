package ru.gb.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            NotesFragment notesFragment = new NotesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes, notesFragment).commit();
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                DescriptionFragment descriptionFragment = new DescriptionFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.description, descriptionFragment).commit();
            }
        }

    }
}