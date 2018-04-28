package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

class am implements as {
    /* renamed from: a */
    final /* synthetic */ String f7583a;
    /* renamed from: b */
    final /* synthetic */ al f7584b;

    am(al alVar, String str) {
        this.f7584b = alVar;
        this.f7583a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (!TextUtils.isEmpty(this.f7583a)) {
            List arrayList = new ArrayList();
            this.f7584b.m11022a(arrayList, new JSONArray(this.f7583a));
            if (arrayList.size() > 0) {
                this.f7584b.m11016a(new an(this, arrayList));
            }
        }
    }
}
