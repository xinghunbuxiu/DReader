package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.domain.account.ab;

import java.util.HashSet;
import java.util.Set;

class gz extends hf {
    b a = new b();
    final ab b = new ab(this.c.d.c());
    final /* synthetic */ PersonalPrefs c;

    gz(PersonalPrefs personalPrefs) {
        this.c = personalPrefs;
        super(personalPrefs);
    }

    protected void onSessionTry() {
        this.a = new o(this, this.b).h(this.c.a(this.c.c()));
    }

    protected void onSessionSucceeded() {
        if (this.a.b == 0 && this.c.a(this.b) && !TextUtils.isEmpty((CharSequence) this.a.a)) {
            Set hashSet = new HashSet();
            for (String str : ((String) this.a.a).split(",")) {
                if (!str.equals("empty")) {
                    hashSet.add(str);
                }
            }
            this.c.a(hashSet, false);
        }
    }

    protected void onSessionFailed() {
    }
}
