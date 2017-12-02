package com.duokan.reader.ui.general;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.duokan.core.sys.t;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ServerSettingActivity extends Activity {
    private TextView a = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new TextView(this);
        this.a.setBackgroundColor(-16777216);
        this.a.setGravity(17);
        this.a.setTextColor(-1);
        this.a.setTextSize(20.0f);
        this.a.setText("正在切换服务器...");
        this.a.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(this.a);
        DkApp.get().runWhenAppReady(new hp(this, getIntent().getData()));
    }

    private void a(String str, int i) {
        this.a.setText(str + "\n" + i + "秒后自动退出～");
        t.a(new hr(this), TimeUnit.SECONDS.toMillis((long) i));
    }

    private void a() {
        File file = new File(ReaderEnv.get().getDatabaseDirectory(), "ImportantListCaches.db");
        File file2 = new File(ReaderEnv.get().getExternalFilesDirectory(), "ImportantListCaches.db");
        if (file.exists()) {
            file.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }
    }
}
