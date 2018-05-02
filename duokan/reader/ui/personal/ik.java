package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.dn;

do;

class ik implements dn {
    final /* synthetic */ ij a;

    ik(ij ijVar) {
        this.a = ijVar;
    }

    public void a(String str, do doVar) {
        if (TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), this.a.a.getResources().getString(j.personal__personal_redeem_info_view__prompt), 3).show();
            doVar.a("");
        } else if (TextUtils.equals(str, this.a.a.a.getMessage())) {
            doVar.a();
        } else {
            this.a.a.a(str, doVar);
        }
    }
}
