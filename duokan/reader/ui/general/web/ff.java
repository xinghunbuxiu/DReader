package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.duokan.core.sys.as;
import com.duokan.core.ui.UTools;

import org.json.JSONObject;

class ff implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ JSONObject b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ boolean f;
    final /* synthetic */ fe g;

    ff(fe feVar, boolean z, JSONObject jSONObject, String str, String str2, String str3, boolean z2) {
        this.g = feVar;
        this.a = z;
        this.b = jSONObject;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = z2;
    }

    public void a() {
        if (this.g.b.pageController.mInputBoxView != null) {
            View view = (EditText) this.g.b.pageController.mInputBoxView.findViewById(g.general__web_view__edit);
            TextView textView = (TextView) this.g.b.pageController.mInputBoxView.findViewById(g.general__web_view__confirm);
            textView.setClickable(false);
            if (this.a) {
                this.g.b.pageController.mInputFlag = this.b;
                this.g.b.pageController.mInputBoxView.setVisibility(0);
                this.g.b.pageController.mInputBoxView.setResizeLayoutForSoftInput(true);
                view.setHint(TextUtils.isEmpty(this.c) ? "" : this.c);
                view.setText(TextUtils.isEmpty(this.d) ? "" : this.d);
                view.addTextChangedListener(new fg(this, textView));
                this.g.b.pageController.mInputBoxView.setOnTouchListener(new fh(this, view));
                if (!TextUtils.isEmpty(this.e)) {
                    textView.setText(this.e);
                    textView.setOnClickListener(new fi(this, view));
                }
                if (this.f) {
                    UTools.PostTask(view);
                    return;
                }
                return;
            }
            this.g.b.pageController.mInputBoxView.setVisibility(8);
        }
    }
}
