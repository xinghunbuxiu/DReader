package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.duokan.core.sys.as;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0255g;
import org.json.JSONObject;

class fp implements as {
    /* renamed from: a */
    final /* synthetic */ boolean f7846a;
    /* renamed from: b */
    final /* synthetic */ JSONObject f7847b;
    /* renamed from: c */
    final /* synthetic */ String f7848c;
    /* renamed from: d */
    final /* synthetic */ String f7849d;
    /* renamed from: e */
    final /* synthetic */ String f7850e;
    /* renamed from: f */
    final /* synthetic */ boolean f7851f;
    /* renamed from: g */
    final /* synthetic */ fo f7852g;

    fp(fo foVar, boolean z, JSONObject jSONObject, String str, String str2, String str3, boolean z2) {
        this.f7852g = foVar;
        this.f7846a = z;
        this.f7847b = jSONObject;
        this.f7848c = str;
        this.f7849d = str2;
        this.f7850e = str3;
        this.f7851f = z2;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7852g.f7845b.f7581b.mInputBoxView != null) {
            View view = (EditText) this.f7852g.f7845b.f7581b.mInputBoxView.findViewById(C0255g.general__web_view__edit);
            TextView textView = (TextView) this.f7852g.f7845b.f7581b.mInputBoxView.findViewById(C0255g.general__web_view__confirm);
            textView.setClickable(false);
            if (this.f7846a) {
                this.f7852g.f7845b.f7581b.mInputFlag = this.f7847b;
                this.f7852g.f7845b.f7581b.mInputBoxView.setVisibility(0);
                this.f7852g.f7845b.f7581b.mInputBoxView.setResizeLayoutForSoftInput(true);
                view.setHint(TextUtils.isEmpty(this.f7848c) ? "" : this.f7848c);
                view.setText(TextUtils.isEmpty(this.f7849d) ? "" : this.f7849d);
                view.addTextChangedListener(new fq(this, textView));
                this.f7852g.f7845b.f7581b.mInputBoxView.setOnTouchListener(new fr(this, view));
                if (!TextUtils.isEmpty(this.f7850e)) {
                    textView.setText(this.f7850e);
                    textView.setOnClickListener(new fs(this, view));
                }
                if (this.f7851f) {
                    AnimUtils.m1915a(view);
                    return;
                }
                return;
            }
            this.f7852g.f7845b.f7581b.mInputBoxView.setVisibility(8);
        }
    }
}
