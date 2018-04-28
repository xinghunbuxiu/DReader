package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.lb;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class ka implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8801a;

    ka(jg jgVar) {
        this.f8801a = jgVar;
    }

    public void onClick(View view) {
        boolean z;
        PersonalPrefs a = PersonalPrefs.m5175a();
        if (PersonalPrefs.m5175a().m5234j()) {
            z = false;
        } else {
            z = true;
        }
        a.m5208a(z);
        this.f8801a.m12047a();
        lb.m4896a().m4919a(false);
    }
}
