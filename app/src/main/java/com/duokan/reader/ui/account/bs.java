package com.duokan.reader.ui.account;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.c.g;
import com.duokan.core.ui.UTools;

public class bs extends bn {
    private bf e;

    public bs(Activity activity, String str, String str2, String str3, ce ceVar) {
        super(activity, str, str2, ceVar);
        this.e = new bf(getContext(), str2, str3);
        b();
    }

    public void show() {
        super.show();
        UTools.addAnimation(this.e.getReasonEditView());
    }

    protected void a(View view) {
        ((FrameLayout) view.findViewById(g.account__third_share_view__share_content)).addView(this.e, new LayoutParams(-1, -2));
        this.b.setOnClickListener(new bt(this));
    }

    protected void a(cd cdVar) {
        if (!this.c.isShowing()) {
            this.c.open(new bu(this));
        }
        cdVar.a(null, false);
    }

    protected String a() {
        return this.e.getReasonEditView().getText().toString();
    }

    protected void a(String str) {
    }
}
