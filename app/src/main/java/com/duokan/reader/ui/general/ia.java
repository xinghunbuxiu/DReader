package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.ui.f;

public class ia extends f {
    private dq a = hz.a(this);
    private ib b;

    public ia(Context context) {
        super(context);
        this.a.a(true);
    }

    public void a(String str) {
        this.a.a(str);
    }

    public void a(int i) {
        a(getContext().getResources().getString(i));
    }

    public void b(int i) {
        b(getContext().getString(i));
    }

    public void b(String str) {
        a(a(str, this.a.a().getChildCount() != 0));
    }

    public void a(View view) {
        view.setOnClickListener(new ic(this, this.a.c()));
        this.a.b().setVisibility(8);
        this.a.a().addView(view, new LayoutParams(-1, -2));
    }

    public void a(ib ibVar) {
        this.b = ibVar;
    }

    private View a(String str, boolean z) {
        return this.a.a(str, 0, z);
    }
}
