package com.release.daotest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.release.daotest.SQLite.SqliteActivity;
import com.release.daotest.greendao.GreendaoActivity;
import com.release.daotest.room.RoomActivity;
/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void roomClick(View v) {
        startActivity(new Intent(this, RoomActivity.class));
    }

    public void greendaoClick(View v) {
        startActivity(new Intent(this, GreendaoActivity.class));
    }

    public void sqliteClick(View v) {
        startActivity(new Intent(this, SqliteActivity.class));
    }
}