package com.duokan.reader.ui.store;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import java.util.LinkedList;

class ax {
    /* renamed from: a */
    String f11333a;
    /* renamed from: b */
    String f11334b;
    /* renamed from: c */
    String f11335c;
    /* renamed from: d */
    LinkedList<String> f11336d;
    /* renamed from: e */
    float f11337e;
    /* renamed from: f */
    int f11338f;
    /* renamed from: g */
    float f11339g;

    private ax() {
        this.f11333a = "";
        this.f11334b = "";
        this.f11335c = "";
        this.f11336d = new LinkedList();
        this.f11337e = 0.0f;
        this.f11338f = 0;
        this.f11339g = 0.0f;
    }

    /* renamed from: a */
    public float m15266a() {
        return Float.compare(this.f11339g, 0.0f) == 0 ? this.f11337e / 100.0f : this.f11339g;
    }

    /* renamed from: a */
    public String m15267a(Context context) {
        if (!TextUtils.isEmpty(this.f11333a)) {
            return this.f11333a;
        }
        return this.f11335c + (TextUtils.isEmpty(this.f11334b) ? "" : context.getString(C0247i.store__fiction_purchase_view__description) + this.f11334b);
    }
}
