package com.duokan.reader.ui.surfing;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.general.web.StorePageController;

class r implements ac {
    final /* synthetic */ String a;
    final /* synthetic */ f b;

    r(f fVar, String str) {
        this.b = fVar;
        this.a = str;
    }

    public void a(ab abVar) {
        a();
        if (!TextUtils.isEmpty(this.a)) {
            ((ReaderFeature) MyContextWrapper.getFeature(this.b.getContext()).queryFeature(ReaderFeature.class)).navigate(this.a, null, true, null);
        }
    }

    public void b(ab abVar) {
        a();
    }

    private void a() {
        Editor edit = PersonalPrefs.a().t().edit();
        edit.remove(StorePageController.PAY_CONTINUE);
        edit.apply();
    }
}
