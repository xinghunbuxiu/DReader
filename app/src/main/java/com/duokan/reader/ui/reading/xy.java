package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.reader.ui.general.PagesView;

public class xy extends wl {
    private fo n = null;
    private final View o = findViewById(g.reading__reading_view__chapter_info);
    private final TextView p = ((TextView) findViewById(g.reading__reading_view__chapter_name));
    private final TextView q = ((TextView) findViewById(g.reading__reading_view__chapter_index));

    public xy(Context context, xb xbVar) {
        super(context, xbVar);
    }

    protected fi getFixedPagesView() {
        return null;
    }

    protected fo getFlowPagesView() {
        return this.n;
    }

    public PagesView getShowingPagesView() {
        return this.n;
    }

    public gy getShowingDocPresenter() {
        return this.n;
    }

    public void a() {
        this.n = new xt(getContext());
        this.b.addView(this.n, new LayoutParams(-1, -1));
    }

    public void a(int i, String str, String str2) {
        this.o.setVisibility(i);
        if (!TextUtils.isEmpty(str)) {
            this.p.setVisibility(0);
            this.p.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.q.setVisibility(0);
            this.q.setText(str2);
        }
    }
}
