package com.example.mongorealmapptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    ConnectToRealmApp01 realmAppOne;
    ConnectToRealmApp02 realmAppTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        realmAppOne = new ConnectToRealmApp01();
        realmAppTwo = new ConnectToRealmApp02();

        Button checkButton = findViewById(R.id.Check_button);
        checkButton.setOnClickListener(v -> {
            realmAppOne.RealmApp01(this);
            realmAppTwo.RealmApp02(this);
        });
    }
}