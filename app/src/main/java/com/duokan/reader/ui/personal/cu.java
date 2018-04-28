package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;

class cu implements db {
    /* renamed from: a */
    ja f8430a = null;
    /* renamed from: b */
    final /* synthetic */ db f8431b;
    /* renamed from: c */
    final /* synthetic */ ct f8432c;

    cu(ct ctVar, db dbVar) {
        this.f8432c = ctVar;
        this.f8431b = dbVar;
    }

    /* renamed from: a */
    public boolean mo1896a() {
        this.f8430a = new ja(this.f8432c.f8423a);
        this.f8430a.setCancelOnBack(false);
        this.f8430a.setCancelOnTouchOutside(false);
        this.f8430a.m10843a(this.f8432c.f8423a.getString(C0258j.personal__miaccount_profile_settings_view__uploading_avatar));
        this.f8430a.show();
        return this.f8431b.mo1896a();
    }

    /* renamed from: a */
    public void mo1895a(String str) {
        if (this.f8430a != null) {
            this.f8430a.dismiss();
            this.f8430a = null;
        }
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8432c.f8423a, (CharSequence) str, 0).show();
        }
        this.f8431b.mo1895a(str);
    }

    /* renamed from: b */
    public void mo1897b() {
        if (this.f8430a != null) {
            this.f8430a.dismiss();
            this.f8430a = null;
        }
        this.f8431b.mo1897b();
    }
}
