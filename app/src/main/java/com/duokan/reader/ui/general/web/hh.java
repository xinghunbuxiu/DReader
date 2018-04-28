package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.bookshelf.lb;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.ft;

class hh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ DkSignInInfo f7927a;
    /* renamed from: b */
    final /* synthetic */ hf f7928b;

    hh(hf hfVar, DkSignInInfo dkSignInInfo) {
        this.f7928b = hfVar;
        this.f7927a = dkSignInInfo;
    }

    public void run() {
        if (!PersonalPrefs.m5175a().m5242r()) {
            String str;
            C0328a.m757c().m752c(LogLevel.EVENT, "resign_event", "no pass through message, notify by client");
            String str2 = "";
            if (this.f7927a == null || this.f7927a.mReward == null) {
                lb.m4896a().m4918a(null);
                str = str2;
            } else {
                lb.m4896a().m4918a(this.f7927a.mReward);
                str = str2;
                int i = 0;
                while (i < this.f7927a.mReward.size()) {
                    String str3 = (str + "," + ((DkSignInReward) this.f7927a.mReward.get(i)).mValue) + ((DkSignInReward) this.f7927a.mReward.get(i)).mName;
                    i++;
                    str = str3;
                }
            }
            if (DkApp.get().getRunningState() != RunningState.FOREGROUND) {
                ft a = ft.m5575a();
                if (!TextUtils.isEmpty(str)) {
                    str = str.substring(1);
                }
                a.m5586b(str);
            }
            PersonalPrefs.m5175a().m5228f(true);
        }
    }
}
