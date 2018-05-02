package com.duokan.reader.ui.account;

import com.duokan.core.app.IFeature;

public class cf extends bz {
    public cf(IFeature featrue, String str, String str2, String str3, String str4, String str5, ce ceVar) {
        super(featrue, str, str2, str3, str4, str5, ceVar);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            b();
        }
    }

    protected void a(String str) {
    }

    protected void a() {
        if (this.b.equals("system")) {
            e();
            b(this.e + this.c);
        } else if (this.b.equals("sina")) {
            bn bsVar = new bs(getActivity(), this.c, this.f, this.e, this.h);
            bsVar.setOnShowListener(new cg(this));
            bsVar.show();
        } else {
            c();
        }
    }
}
