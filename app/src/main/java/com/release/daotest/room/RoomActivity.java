package com.release.daotest.room;

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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Mr.release
 * @create 2020/8/19
 * @Describe
 */

public class RoomActivity extends AppCompatActivity {
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_age)
    EditText mEtAge;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    private AppDatabase mDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);
        mDb = IApplication.getInstance().db;
    }

    public void addClick(View v) {
        if (!TextUtils.isEmpty(mEtName.getText().toString()) && !TextUtils.isEmpty(mEtAge.getText().toString()) && !TextUtils.isEmpty(mEtPhone.getText().toString())) {
            User user = new User();
            user.setUsername(mEtName.getText().toString());
            user.setAge(Integer.valueOf(mEtAge.getText().toString()));
            user.setPhone(Integer.valueOf(mEtPhone.getText().toString()));
            mDb.userDao().insert(user);
        } else
            Toast.makeText(this, "请将信息填全", Toast.LENGTH_SHORT).show();

    }

    public void deleteClick(View v) {
        List<User> all = mDb.userDao().getAll();
        if (all.size()>0){
            mDb.userDao().delete(all.get(all.size()-1));
        }
    }

    public void updateClick(View v) {
        List<User> all = mDb.userDao().getAll();
        if (all.size()>0){
            User user = all.get(all.size() - 1);
            user.setUsername(mEtName.getText().toString());
            user.setAge(Integer.valueOf(mEtAge.getText().toString()));
            user.setPhone(Integer.valueOf(mEtPhone.getText().toString()));
            mDb.userDao().updateUsers(user);
        }
    }

    public void selectClick(View v) {
        List<User> all = mDb.userDao().getAll();
        mTvContent.setText(all.toString());
    }
}
