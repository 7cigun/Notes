package ru.gb.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            NotesFragment notesFragment = NotesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes, notesFragment).commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about: {
                getSupportFragmentManager().beginTransaction().replace(R.id.notes, new AboutFragment()).addToBackStack("").commit();
                return true;
            }
            case R.id.action_exit: {
                showAlertDialog();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.notes);
        if (backStackFragment != null && backStackFragment instanceof DescriptionFragment) {
            onBackPressed();
        }
    }

    void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Оцените приложение?")
                .setPositiveButton("Да", (dialogInterface, i) -> {
                    finish();
                    showToast("Переходим в Market");
                })
                .setNegativeButton("Ни за что", (dialogInterface, i) -> {
                    finish();
                    showToast("Очень жаль...");
                })
                .setNeutralButton("Возможно, позже...", (dialogInterface, i) -> {
                    finish();
                    showToast("Будем ждать снова!");
                })
                .show();
    }

    void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}