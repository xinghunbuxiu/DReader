package com.duokan.reader.ui.general;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.duokan.core.sys.UThread;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class ServerSettingActivity extends Activity {
    /* renamed from: a */
    private TextView f6885a = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6885a = new TextView(this);
        this.f6885a.setBackgroundColor(-16777216);
        this.f6885a.setGravity(17);
        this.f6885a.setTextColor(-1);
        this.f6885a.setTextSize(20.0f);
        this.f6885a.setText("正在切换服务器...");
        this.f6885a.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(this.f6885a);
        DkApp.get().runWhenAppReady(new he(this, getIntent().getData()));
    }

    /* renamed from: a */
    private void m10174a(String str, int i) {
        this.f6885a.setText(str + "\n" + i + "秒后自动退出～");
        UThread.postDelayed(new hg(this), TimeUnit.SECONDS.toMillis((long) i));
    }

    /* renamed from: a */
    private void m10171a() {
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
