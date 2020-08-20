package com.release.daotest.SQLite;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.release.daotest.IApplication;
import com.release.daotest.R;
import com.release.daotest.room.AppDatabase;
import com.release.daotest.room.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */

public class SqliteActivity extends AppCompatActivity {
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_age)
    EditText mEtAge;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    public DbManager mDbManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);
        mDbManager = DbManager.getDbManager(this);
    }


    public void addClick(View v) {
        if (!TextUtils.isEmpty(mEtName.getText().toString()) && !TextUtils.isEmpty(mEtAge.getText().toString()) && !TextUtils.isEmpty(mEtPhone.getText().toString())) {
            List<Person> all = mDbManager.selectPersonSQL();
            Person person = new Person();
            person.setId(all.size()+1);
            person.setName(mEtName.getText().toString());
            person.setAge(Integer.valueOf(mEtAge.getText().toString()));
            person.setPhone(Integer.valueOf(mEtPhone.getText().toString()));
            mDbManager.addPersonSQL(person);
        } else
            Toast.makeText(this, "请将信息填全", Toast.LENGTH_SHORT).show();

    }

    public void deleteClick(View v) {
        List<Person> all = mDbManager.selectPersonSQL();
        if (all.size()>0){
            mDbManager.deletePersonSQL(all.size());
        }
    }

    public void updateClick(View v) {
        List<Person> all = mDbManager.selectPersonSQL();
        if (all.size()>0){
            Person person = all.get(all.size() - 1);
            person.setId(all.size());
            person.setName(mEtName.getText().toString());
            person.setAge(Integer.valueOf(mEtAge.getText().toString()));
            person.setPhone(Integer.valueOf(mEtPhone.getText().toString()));
            mDbManager.updatePersonData(person);
        }
    }

    public void selectClick(View v) {
        List<Person> people = mDbManager.selectPersonSQL();
        mTvContent.setText(people.toString());
    }
}
