package com.duokan.reader;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;

import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.ae;
import com.duokan.core.app.af;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.p025a.IPermissionsResultListener;
import com.duokan.core.sys.p025a.Permissions;
import com.duokan.core.ui.C0342j;
import com.duokan.core.ui.OnDismissListener;
import com.duokan.reader.domain.account.cn;
import com.duokan.reader.domain.ad.C0768y;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.welcome.C1557r;

public class DkReaderActivity extends BaseActivity implements IPermissionsResultListener {
    @TargetApi(19)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        Permissions.getInstance().setPermissionsResultListener(this, this);
    }

    private void startMainActivity() {
        Intent intent = new Intent(getIntent());
        intent.setComponent(new ComponentName(DkApp.get(), DkApp.get().getMainActivityClass()));
        intent.setFlags(0);
        if (!(DkMainActivity.isAlive() && TextUtils.equals(intent.getAction(), "android.intent.action.MAIN"))) {
            startActivity(intent);
        }
        finish();
    }

    public void onSuccess() {
        C1163a.m8627k().m8642a("app", 1);
        final Intent intent = getIntent();
        if (!TextUtils.equals(intent.getAction(), "android.intent.action.MAIN")) {
            C0328a.m757c().m749a(LogLevel.EVENT, "nav", "got an intent(action=%s, data=%s)", intent.getAction(), intent.getData());
        }
        DkApp.get().runWhenAppReady(new Runnable() {
            public void run() {
                C1163a.m8627k().m8633a(intent);
            }
        });
        final Runnable c04322 = new Runnable() {
            public void run() {
                if (!isFinishing() && !DkRouter.from(DkReaderActivity.this).route(intent)) {
                    startMainActivity();
                }
            }
        };
        if (DkApp.get().isWebAccessEnabled()) {
            if (!(WelcomeDialog.hasShowableSplash() || !TextUtils.equals(getIntent().getAction(), "android.intent.action.MAIN") || cn.m3452b() || cn.m3451a())) {
                C0768y.m3612a(this);
            }
            c04322.run();
            return;
        }
        final C1557r c1557r = new C1557r(this);
        c1557r.open(new af(this) {
            class MyOnDismissListener implements OnDismissListener {
                public void onDismiss(C0342j c0342j) {
                    C1163a.m8627k().m8642a("app", 1);
                    C1163a.m8627k().m8650b();
                    c04322.run();
                }
            }

            public void onOk(ae aeVar) {
                c1557r.setOnDismissListener(new MyOnDismissListener(this));
            }
        });
    }

    public void onFail() {
        finish();
    }
}
