package com.duokan.reader.ui.reading;

import com.duokan.core.io.C0336a;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import java.io.File;
import java.util.Locale;

final class ks extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f10527a;

    ks(al alVar) {
        this.f10527a = alVar;
    }

    protected void onSessionTry() {
        try {
            File cacheDir = DkApp.get().getCacheDir();
            File file = new File(cacheDir, "hang_ad");
            File file2 = new File(cacheDir, "hang_ad.tmp");
            String format = String.format(Locale.US, C0641o.m2934i().m2996w() + "?user_type=%d&device_id=%s&app_id=%s&build=%d&channel=%s", new Object[]{Integer.valueOf(PersonalPrefs.m5175a().m5210b()), ReaderEnv.get().getDeviceId(), ReaderEnv.get().getAppId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel()});
            ac acVar = new ac((WebSession) this, this.f10527a);
            C0336a.m793f(file2);
            if (acVar.m549a(format, file2, true)) {
                file2.renameTo(file);
            }
            for (kx kxVar : kn.m14564b(file)) {
                if (!kxVar.f10539g.exists()) {
                    acVar.m549a(kxVar.f10540h, kxVar.f10539g, true);
                }
            }
        } finally {
            kn.f10514b = kn.m14577i();
        }
    }

    protected void onSessionSucceeded() {
        kn.f10513a = null;
    }

    protected void onSessionFailed() {
        kn.f10513a = null;
    }
}
