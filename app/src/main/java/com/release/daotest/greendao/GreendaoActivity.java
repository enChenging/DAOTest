package com.release.daotest.greendao;

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

public class GreendaoActivity extends AppCompatActivity {
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_age)
    EditText mEtAge;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    private StudentDao mStudentDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);
        ButterKnife.bind(this);
        mStudentDao = IApplication.getInstance().mDaoSession.getStudentDao();
    }

    public void addClick(View v) {
        if (!TextUtils.isEmpty(mEtName.getText().toString()) && !TextUtils.isEmpty(mEtAge.getText().toString()) && !TextUtils.isEmpty(mEtPhone.getText().toString())) {
            Student st = new Student();
            st.setName(mEtName.getText().toString());
            st.setAge(Integer.valueOf(mEtAge.getText().toString()));
            st.setPhone(Integer.valueOf(mEtPhone.getText().toString()));
            mStudentDao.insertOrReplace(st);
        } else
            Toast.makeText(this, "请将信息填全", Toast.LENGTH_SHORT).show();

    }

    public void deleteClick(View v) {
        List<Student> all = mStudentDao.loadAll();
        if (all.size() > 0) {
            mStudentDao.delete(all.get(all.size() - 1));
        }
    }

    public void updateClick(View v) {
        List<Student> all = mStudentDao.loadAll();
        if (all.size() > 0) {
            Student st = all.get(all.size() - 1);
            st.setName(mEtName.getText().toString());
            st.setAge(Integer.valueOf(mEtAge.getText().toString()));
            st.setPhone(Integer.valueOf(mEtPhone.getText().toString()));
            mStudentDao.update(st);
        }
    }

    public void selectClick(View v) {
        List<Student> all = mStudentDao.loadAll();
        mTvContent.setText(all.toString());
    }
}
