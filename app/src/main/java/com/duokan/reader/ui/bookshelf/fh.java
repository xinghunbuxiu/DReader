package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.ui.TabBarView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.cw;

import org.apache.http.HttpStatus;

public class fh extends FrameLayout {
    private static final int e = Color.rgb(194, 194, 194);
    private static final int f = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
    private er a;
    private DkLabelView b;
    private TabBarView c;
    private cw d;
    private final Drawable g = new fi(this);

    public fh(Context context, Runnable runnable) {
        super(context);
        LayoutInflater.from(context).inflate(h.bookshelf__file_explorer_view, this, true);
        HeaderView headerView = (HeaderView) findViewById(g.bookshelf__file_explorer_view__header);
        headerView.setLeftTitle(getResources().getString(j.bookshelf__file_explorer_view__local_books));
        headerView.setOnBackListener(new fj(this, runnable));
        this.b = (DkLabelView) headerView.findViewById(g.bookshelf__file_explorer_view__select);
        this.b.setVisibility(4);
        this.b.setOnClickListener(new fk(this));
        View inflate = LayoutInflater.from(context).inflate(h.bookshelf__file_explorer_import_view, this.d, false);
        inflate.findViewById(g.bookshelf__file_explorer_import_view__scan).setOnClickListener(new fl(this));
        this.a = new er(context, runnable);
        this.d = (cw) findViewById(g.bookshelf__file_explorer_view__content);
        this.d.addView(inflate, new LayoutParams(-1, -1));
        this.d.addView(this.a, new LayoutParams(-1, -1));
        this.c = new TabBarView(context);
        String string = getResources().getString(j.bookshelf__file_explorer_view__browser);
        this.c.a(a(getResources().getString(j.bookshelf__file_explorer_view__imported), 0, 2));
        this.c.a(a(string, 1, 2));
        this.c.setBackgroundDrawable(new fm(this));
        ((FrameLayout) findViewById(g.bookshelf__file_explorer_view__tab)).addView(this.c, new LayoutParams(-1, -2));
        this.c.setSelectionChangeListener(new fn(this));
        this.d.setOnFlipListener(new fo(this));
        this.d.setOnScrollListener(new fp(this));
        this.a.setSelectionListener(new fq(this));
    }

    protected void a(Canvas canvas) {
        int round;
        int width = this.c.getWidth();
        int height = this.c.getHeight();
        float contentWidth = ((float) this.d.getViewportBounds().left) / ((float) this.d.getContentWidth());
        if (this.c.getChildCount() > 0) {
            round = Math.round(((contentWidth * ((float) (d() - e()))) + ((float) e())) + ((float) ((width / this.c.getTabCount()) / 2)));
        } else {
            round = e();
        }
        canvas.translate((float) round, 0.0f);
        this.g.setBounds(0, 0, width * 2, height);
        this.g.draw(canvas);
        canvas.translate((float) (-round), 0.0f);
    }

    private int d() {
        return (-this.c.getWidth()) + this.c.getRight();
    }

    private int e() {
        return (-this.c.getWidth()) + this.c.getLeft();
    }

    public boolean a() {
        if (this.a.getVisibility() == 0) {
            return this.a.a();
        }
        return false;
    }

    private View a(String str, int i, int i2) {
        DkLabelView dkLabelView = (DkLabelView) LayoutInflater.from(getContext()).inflate(h.bookshelf__file_explorer_tab_view, null, false);
        dkLabelView.setPadding(0, UTools.closeAnimation(getContext(), 15.0f), 0, UTools.closeAnimation(getContext(), 15.0f));
        dkLabelView.setText(str);
        return dkLabelView;
    }
}
