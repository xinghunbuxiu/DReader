package com.duokan.reader.ui.reading;

import com.duokan.core.io.a;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.cloud.PersonalPrefs;

import java.io.File;
import java.util.Locale;

final class ki extends WebSession {
    final /* synthetic */ ab a;

    ki(ab abVar) {
        this.a = abVar;
    }

    protected void onSessionTry() {
        try {
            File cacheDir = DkApp.get().getCacheDir();
            File file = new File(cacheDir, "hang_ad");
            File file2 = new File(cacheDir, "hang_ad.tmp");
            String format = String.format(Locale.US, p.i().w() + "?user_type=%d&device_id=%s&app_id=%s&build=%d&channel=%s", new Object[]{Integer.valueOf(PersonalPrefs.a().b()), ReaderEnv.get().getDeviceId(), ReaderEnv.get().getAppId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel()});
            ad adVar = new ad((WebSession) this, this.a);
            a.d(file2);
            if (adVar.a(format, file2, true)) {
                file2.renameTo(file);
            }
            for (kn knVar : kd.b(file)) {
                if (!knVar.g.exists()) {
                    adVar.a(knVar.h, knVar.g, true);
                }
            }
        } finally {
            kd.b = kd.i();
        }
    }

    protected void onSessionSucceeded() {
        kd.a = null;
    }

    protected void onSessionFailed() {
        kd.a = null;
    }
}
