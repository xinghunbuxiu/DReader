package com.duokan.reader;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;

import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.ad;
import com.duokan.core.app.ae;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.ui.OnDismissListener;
import com.duokan.core.ui.j;
import com.duokan.reader.ui.welcome.r;

public class DkReaderActivity extends BaseActivity {
    @TargetApi(19)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        } else {
            getWindow().addFlags(1024);
        }
        final Intent intent = getIntent();
        if (!TextUtils.equals(intent.getAction(), "android.intent.action.MAIN")) {
            a.c().a(LogLevel.EVENT, "nav", "got an intent(action=%s, data=%s)", intent.getAction(), intent.getData());
        }
        DkApp.get().runWhenAppReady(new Runnable(this) {
            final /* synthetic */ DkReaderActivity b;

            public void run() {
                com.duokan.reader.domain.statistics.a.k().a(intent);
            }
        });
        final Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ DkReaderActivity b;

            public void run() {
                if (!this.b.isFinishing() && !DkRouter.from(this.b).route(intent)) {
                    this.b.startMainActivity();
                }
            }
        };
        if (DkApp.get().isWebAccessEnabled()) {
            anonymousClass2.run();
            return;
        }
        final r rVar = new r(this);
        rVar.open(new ae(this) {
            final /* synthetic */ DkReaderActivity c;

            public void onOk(ad adVar) {
                rVar.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ AnonymousClass3 a;

                    {
                        this.a = r1;
                    }

                    public void onDismiss(j jVar) {
                        com.duokan.reader.domain.statistics.a.k().a("app", 1);
                        com.duokan.reader.domain.statistics.a.k().b();
                        anonymousClass2.run();
                    }
                });
            }
        });
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
}
