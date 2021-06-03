package com.example.fbusimpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    Button btnSave;
    EditText editItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnSave = (Button) findViewById(R.id.btnSave);
        editItem = (EditText) findViewById(R.id.editItem);
        getSupportActionBar().setTitle("Update Item");

        editItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(EditActivity.this, MainActivity.class);
                i.putExtra(MainActivity.KEY_ITEM_TEXT, editItem.getText().toString());
                i.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getStringArrayExtra(MainActivity.KEY_ITEM_POSITION));
                setResult(RESULT_OK, i);
                finish();
            }
        });



    }
}