package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gn;

class gz implements Runnable {
    final /* synthetic */ DkSignInInfo a;
    final /* synthetic */ gx b;

    gz(gx gxVar, DkSignInInfo dkSignInInfo) {
        this.b = gxVar;
        this.a = dkSignInInfo;
    }

    public void run() {
        if (!PersonalPrefs.a().r()) {
            a.c().c(LogLevel.EVENT, "resign_event", "no pass through message, notify by client");
            if (this.a == null || this.a.mReward == null || DkApp.get().getRunningState() != RunningState.FOREGROUND) {
                String str = "";
                if (!(this.a == null || this.a.mReward == null)) {
                    String str2 = str;
                    int i = 0;
                    while (i < this.a.mReward.size()) {
                        String str3 = (str2 + "," + ((DkSignInReward) this.a.mReward.get(i)).mValue) + ((DkSignInReward) this.a.mReward.get(i)).mName;
                        i++;
                        str2 = str3;
                    }
                    str = str2;
                }
                kp.a().e();
                kp.a().a(null);
                gn a = gn.a();
                if (!TextUtils.isEmpty(str)) {
                    str = str.substring(1);
                }
                a.b(str);
            } else {
                kp.a().a(this.a.mReward);
            }
            PersonalPrefs.a().f(true);
        }
    }
}
