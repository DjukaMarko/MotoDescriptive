package com.example.motodescriptive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settings:
                startNewActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void startNewActivity() {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);

    }
}