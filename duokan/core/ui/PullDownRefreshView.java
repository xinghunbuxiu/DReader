package com.duokan.core.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ui.general.DkLabelView;

import org.apache.http.HttpStatus;

public class PullDownRefreshView extends PullDownRefreshBaseView {
    private View a;
    private ImageView b;
    private DkLabelView c;
    private DkLabelView d;
    private DkLabelView e;
    private DkLabelView f;
    private RefreshStyle g;
    private final ImageView h;

    public enum RefreshStyle {
        NORMAL,
        STORE,
        COMIC
    }

    public PullDownRefreshView(Context context) {
        this(context, null);
    }

    public PullDownRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = RefreshStyle.NORMAL;
        g();
        this.h = new ImageView(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, UTools.getMinimumHeight(getContext(), 10.0f), 0, 0);
        addView(this.h, layoutParams);
    }

    public void setRate(float f) {
    }

    protected void b() {
        k();
        this.c.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(4);
        this.f.setVisibility(4);
    }

    protected void a(RefreshState refreshState) {
        this.c.setVisibility(0);
        if (refreshState == RefreshState.RELEASE_TO_REFRESH) {
            if (this.g != RefreshStyle.COMIC) {
                i();
            }
            this.d.setVisibility(4);
        } else if (refreshState == RefreshState.REFRESH_DONE) {
            k();
            this.f.setVisibility(4);
        }
    }

    protected void c() {
        this.d.setVisibility(0);
        this.c.setVisibility(4);
        if (this.g != RefreshStyle.COMIC) {
            h();
        }
    }

    protected void d() {
        this.e.setVisibility(0);
        this.d.setVisibility(4);
        j();
    }

    protected void e() {
        k();
        this.f.setVisibility(0);
        this.e.setVisibility(4);
        TaskHandler.postDelayed(new ca(this), 300);
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        if (this.g != refreshStyle) {
            if (refreshStyle == RefreshStyle.COMIC) {
                removeAllViews();
                f();
            } else if (this.g == RefreshStyle.COMIC) {
                removeAllViews();
                g();
            }
            this.g = refreshStyle;
            if (this.g == RefreshStyle.STORE) {
                this.h.setImageResource(e.general__shared__refresh_background);
                this.a.setPadding(0, UTools.getMinimumHeight(getContext(), 10.0f), 0, UTools.getMinimumHeight(getContext(), 5.0f));
            } else if (this.g == RefreshStyle.COMIC) {
                this.a.setPadding(0, 0, 0, 0);
            } else {
                this.a.setPadding(0, 0, 0, UTools.getMinimumHeight(getContext(), 10.0f));
            }
        }
    }

    private void f() {
        this.a = LayoutInflater.from(getContext()).inflate(g.general__web_pull_refresh_comic_view, this, false);
        addView(this.a);
        this.b = (ImageView) findViewById(f.general__web_pull_refresh_view__icon);
        this.c = (DkLabelView) findViewById(f.general__web_pull_refresh_view__pull_down_tip);
        this.d = (DkLabelView) findViewById(f.general__web_pull_refresh_view__release_tip);
        this.e = (DkLabelView) findViewById(f.general__web_pull_refresh_view__refreshing_tip);
        this.f = (DkLabelView) findViewById(f.general__web_pull_refresh_view__refreshed_tip);
    }

    private void g() {
        this.a = LayoutInflater.from(getContext()).inflate(g.general__web_pull_refresh_view, this, false);
        addView(this.a);
        this.b = (ImageView) findViewById(f.general__web_pull_refresh_view__icon);
        this.c = (DkLabelView) findViewById(f.general__web_pull_refresh_view__pull_down_tip);
        this.d = (DkLabelView) findViewById(f.general__web_pull_refresh_view__release_tip);
        this.e = (DkLabelView) findViewById(f.general__web_pull_refresh_view__refreshing_tip);
        this.f = (DkLabelView) findViewById(f.general__web_pull_refresh_view__refreshed_tip);
    }

    private final void h() {
        UTools.addAnimation(this.b, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_OK, true, null);
    }

    private final void i() {
        UTools.f(this.b, null);
    }

    private final void j() {
        ((Animatable) this.b.getDrawable()).start();
    }

    private final void k() {
        this.b.getDrawable().setVisible(true, true);
        ((Animatable) this.b.getDrawable()).stop();
        this.b.clearAnimation();
    }
}
