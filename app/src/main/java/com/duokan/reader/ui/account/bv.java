package com.duokan.reader.ui.account;

import com.duokan.core.app.IFeature;

public class bv extends bp {
    public bv(IFeature mFeature, String str, String str2, String str3, String str4, String str5, bu buVar) {
        super(mFeature, str, str2, str3, str4, str5, buVar);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            m8881b();
        }
    }

    /* renamed from: a */
    protected void mo1571a(String str) {
    }

    /* renamed from: a */
    protected void mo1570a() {
        if (this.b.equals("system")) {
            m8885e();
            m8882b(this.e + this.c);
        } else if (this.b.equals("weibo")) {
            bd biVar = new bi(getActivity(), this.c, this.f, this.e, this.h);
            biVar.setOnShowListener(new bw(this));
            biVar.show();
        } else {
            m8883c();
        }
    }
}
