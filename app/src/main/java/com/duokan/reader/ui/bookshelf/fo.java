package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.TabBarView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.cw;
import org.apache.http.HttpStatus;

public class fo extends FrameLayout {
    /* renamed from: e */
    private static final int f6456e = Color.rgb(194, 194, 194);
    /* renamed from: f */
    private static final int f6457f = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
    /* renamed from: a */
    private ey f6458a;
    /* renamed from: b */
    private DkLabelView f6459b;
    /* renamed from: c */
    private TabBarView f6460c;
    /* renamed from: d */
    private cw f6461d;
    /* renamed from: g */
    private final Drawable f6462g = new fp(this);

    public fo(Context context, Runnable runnable) {
        super(context);
        LayoutInflater.from(context).inflate(C0256h.bookshelf__file_explorer_view, this, true);
        HeaderView headerView = (HeaderView) findViewById(C0255g.bookshelf__file_explorer_view__header);
        headerView.setLeftTitle(getResources().getString(C0258j.bookshelf__file_explorer_view__local_books));
        headerView.setOnBackListener(new fq(this, runnable));
        this.f6459b = (DkLabelView) headerView.findViewById(C0255g.bookshelf__file_explorer_view__select);
        this.f6459b.setVisibility(4);
        this.f6459b.setOnClickListener(new fr(this));
        View inflate = LayoutInflater.from(context).inflate(C0256h.bookshelf__file_explorer_import_view, this.f6461d, false);
        inflate.findViewById(C0255g.bookshelf__file_explorer_import_view__scan).setOnClickListener(new fs(this));
        this.f6458a = new ey(context, runnable);
        this.f6461d = (cw) findViewById(C0255g.bookshelf__file_explorer_view__content);
        this.f6461d.addView(inflate, new LayoutParams(-1, -1));
        this.f6461d.addView(this.f6458a, new LayoutParams(-1, -1));
        this.f6460c = new TabBarView(context);
        String string = getResources().getString(C0258j.bookshelf__file_explorer_view__browser);
        this.f6460c.m1320a(m9623a(getResources().getString(C0258j.bookshelf__file_explorer_view__imported), 0, 2));
        this.f6460c.m1320a(m9623a(string, 1, 2));
        this.f6460c.setBackgroundDrawable(new ft(this));
        ((FrameLayout) findViewById(C0255g.bookshelf__file_explorer_view__tab)).addView(this.f6460c, new LayoutParams(-1, -2));
        this.f6460c.setSelectionChangeListener(new fu(this));
        this.f6461d.setOnFlipListener(new fv(this));
        this.f6461d.setOnScrollListener(new fw(this));
        this.f6458a.setSelectionListener(new fx(this));
    }

    /* renamed from: a */
    protected void m9632a(Canvas canvas) {
        int round;
        int width = this.f6460c.getWidth();
        int height = this.f6460c.getHeight();
        float contentWidth = ((float) this.f6461d.getViewportBounds().left) / ((float) this.f6461d.getContentWidth());
        if (this.f6460c.getChildCount() > 0) {
            round = Math.round(((contentWidth * ((float) (m9629d() - m9631e()))) + ((float) m9631e())) + ((float) ((width / this.f6460c.getTabCount()) / 2)));
        } else {
            round = m9631e();
        }
        canvas.translate((float) round, 0.0f);
        this.f6462g.setBounds(0, 0, width * 2, height);
        this.f6462g.draw(canvas);
        canvas.translate((float) (-round), 0.0f);
    }

    /* renamed from: d */
    private int m9629d() {
        return (-this.f6460c.getWidth()) + this.f6460c.getRight();
    }

    /* renamed from: e */
    private int m9631e() {
        return (-this.f6460c.getWidth()) + this.f6460c.getLeft();
    }

    /* renamed from: a */
    public boolean m9633a() {
        if (this.f6458a.getVisibility() == 0) {
            return this.f6458a.m9591a();
        }
        return false;
    }

    /* renamed from: a */
    private View m9623a(String str, int i, int i2) {
        DkLabelView dkLabelView = (DkLabelView) LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__file_explorer_tab_view, null, false);
        dkLabelView.setPadding(0, dv.m1932b(getContext(), 15.0f), 0, dv.m1932b(getContext(), 15.0f));
        dkLabelView.setText(str);
        return dkLabelView;
    }
}
