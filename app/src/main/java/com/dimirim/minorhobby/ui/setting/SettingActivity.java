package com.dimirim.minorhobby.ui.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dimirim.minorhobby.R;
import com.dimirim.minorhobby.ui.editprofile.EditProfileActivity;
import com.dimirim.minorhobby.ui.profile.ProfileActivity;

public class SettingActivity extends AppCompatActivity {
    public static final String shared = "Switch";
    ImageButton back; // 뒤로가기
    Button profile_modify; // 프로필수정

    TextView nickname; // 닉네임
    TextView local_situation; //사는 곳

    Button updata_guide; //업데이트 안내
    Button hobbie_tag_add; //취미 및 태그 추가 안내
    Button service_check_guide; //서비스 점검/중단 안내

    Button open_source_license; //오픈소스 라이선스
    Button privacy_policy; // 개인정보 처리방침
    Button company_information; //회사정보

    TextView vs; //버전

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        back = (ImageButton)findViewById(R.id.back);
        profile_modify = (Button)findViewById(R.id.profile_modify);

        // 푸시 알림 상태 저장(앱을 껏다 켜도 ON/OFF 유지)
        Switch push_notification = (Switch) findViewById(R.id.push_notification);
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        @SuppressLint("CommitPrefEdits") final SharedPreferences.Editor editor = sharedPreferences.edit();
        push_notification.setChecked(sharedPreferences.getBoolean(shared,false));

        nickname = (TextView)findViewById(R.id.nickname);
        local_situation = (TextView)findViewById(R.id.local_situation);

        updata_guide = (Button)findViewById(R.id.updata_guide);
        hobbie_tag_add = (Button)findViewById(R.id.hobbie_tag_add);
        service_check_guide = (Button)findViewById(R.id.service_check_guide);

        open_source_license = (Button)findViewById(R.id.open_source_license);
        privacy_policy = (Button)findViewById(R.id.privacy_policy);
        company_information = (Button)findViewById(R.id.company_information);

        vs = (TextView)findViewById(R.id.vs);

        //스위치 리스너(editor 연결 때문에 안으로 넣음)
        push_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치 버튼이 체크되었는지 검사하여 텍스트뷰에 각 경우에 맞게 출력
                if (isChecked){
                    //체크 됐을 때
                    editor.putBoolean(shared,true);
                } else {
                    //체크 안됐을 때
                    editor.putBoolean(shared,false);
                }
                editor.apply();
            }
        });
        SetListener();
    }
    @SuppressLint("SetTextI18n")
    public void SetListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });
        profile_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        updata_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        hobbie_tag_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        service_check_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        open_source_license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        company_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
