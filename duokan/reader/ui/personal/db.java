package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;

class db implements dh {
    jq a = null;
    final /* synthetic */ dh b;
    final /* synthetic */ da c;

    db(da daVar, dh dhVar) {
        this.c = daVar;
        this.b = dhVar;
    }

    public boolean a() {
        this.a = new jq(this.c.a);
        this.a.setCancelOnBack(false);
        this.a.setCancelOnTouchOutside(false);
        this.a.a(this.c.a.getString(j.personal__miaccount_profile_settings_view__uploading_avatar));
        this.a.show();
        return this.b.a();
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.dismiss();
            this.a = null;
        }
        if (!TextUtils.isEmpty(str)) {
            be.a(this.c.a, (CharSequence) str, 0).show();
        }
        this.b.a(str);
    }

    public void b() {
        if (this.a != null) {
            this.a.dismiss();
            this.a = null;
        }
        this.b.b();
    }
}
