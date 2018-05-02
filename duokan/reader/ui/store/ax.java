package com.duokan.reader.ui.store;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.b.i;

import java.util.LinkedList;

class ax {
    String a;
    String b;
    String c;
    LinkedList d;
    float e;
    int f;
    float g;

    private ax() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = new LinkedList();
        this.e = 0.0f;
        this.f = 0;
        this.g = 0.0f;
    }

    public float a() {
        return Float.compare(this.g, 0.0f) == 0 ? this.e / 100.0f : this.g;
    }

    public String a(Context context) {
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        return this.c + (TextUtils.isEmpty(this.b) ? "" : context.getString(i.store__fiction_purchase_view__description) + this.b);
    }
}
