package com.duokan.core.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.duokan.core.sys.UThread;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ui.general.DkLabelView;
import org.apache.http.HttpStatus;

public class PullDownRefreshView extends PullDownRefreshBaseView {
    
    private View f848a;
    
    private ImageView f849b;
    
    private DkLabelView f850c;
    
    private DkLabelView f851d;
    
    private DkLabelView f852e;
    
    private DkLabelView f853f;
    
    private RefreshStyle f854g;
    
    private final ImageView f855h;

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
        this.f854g = RefreshStyle.NORMAL;
        m1293g();
        this.f855h = new ImageView(getContext());
        addView(this.f855h, new LayoutParams(-1, -2));
    }

    public void setRate(float f) {
    }

    
    protected void mo470b() {
        m1297k();
        this.f850c.setVisibility(4);
        this.f851d.setVisibility(4);
        this.f852e.setVisibility(4);
        this.f853f.setVisibility(4);
    }

    
    protected void mo469a(RefreshState refreshState) {
        this.f850c.setVisibility(0);
        if (refreshState == RefreshState.RELEASE_TO_REFRESH) {
            if (this.f854g != RefreshStyle.COMIC) {
                m1295i();
            }
            this.f851d.setVisibility(4);
        } else if (refreshState == RefreshState.REFRESH_DONE) {
            m1297k();
            this.f853f.setVisibility(4);
        }
    }

    
    protected void mo471c() {
        this.f851d.setVisibility(0);
        this.f850c.setVisibility(4);
        if (this.f854g != RefreshStyle.COMIC) {
            m1294h();
        }
    }

    
    protected void mo472d() {
        this.f852e.setVisibility(0);
        this.f851d.setVisibility(4);
        m1296j();
    }

    
    protected void mo473e() {
        m1297k();
        this.f853f.setVisibility(0);
        this.f852e.setVisibility(4);
        UThread.postDelayed(new ca(this), 300);
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        if (this.f854g != refreshStyle) {
            if (refreshStyle == RefreshStyle.COMIC) {
                removeAllViews();
                m1292f();
            } else if (this.f854g == RefreshStyle.COMIC) {
                removeAllViews();
                m1293g();
            }
            this.f854g = refreshStyle;
            if (this.f854g == RefreshStyle.STORE) {
                this.f855h.setImageResource(C0243e.general__shared__refresh_background);
                this.f848a.setPadding(0, AnimUtils.m1932b(getContext(), 10.0f), 0, AnimUtils.m1932b(getContext(), 5.0f));
            } else if (this.f854g == RefreshStyle.COMIC) {
                this.f848a.setPadding(0, 0, 0, 0);
            } else {
                this.f848a.setPadding(0, 0, 0, AnimUtils.m1932b(getContext(), 10.0f));
            }
        }
    }

    
    private void m1292f() {
        this.f848a = LayoutInflater.from(getContext()).inflate(C0245g.general__web_pull_refresh_comic_view, this, false);
        addView(this.f848a);
        this.f849b = (ImageView) findViewById(C0244f.general__web_pull_refresh_view__icon);
        this.f850c = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__pull_down_tip);
        this.f851d = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__release_tip);
        this.f852e = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__refreshing_tip);
        this.f853f = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__refreshed_tip);
    }

    
    private void m1293g() {
        this.f848a = LayoutInflater.from(getContext()).inflate(C0245g.general__web_pull_refresh_view, this, false);
        addView(this.f848a);
        this.f849b = (ImageView) findViewById(C0244f.general__web_pull_refresh_view__icon);
        this.f850c = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__pull_down_tip);
        this.f851d = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__release_tip);
        this.f852e = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__refreshing_tip);
        this.f853f = (DkLabelView) findViewById(C0244f.general__web_pull_refresh_view__refreshed_tip);
    }

    
    private final void m1294h() {
        AnimUtils.startTranslateAnimation(this.f849b, 0.0f, 0.0f, -1.0f, 0.0f, HttpStatus.SC_OK, true, null);
    }

    
    private final void m1295i() {
        AnimUtils.m1961f(this.f849b, null);
    }

    
    private final void m1296j() {
        ((Animatable) this.f849b.getDrawable()).start();
    }

    
    private final void m1297k() {
        this.f849b.getDrawable().setVisible(true, true);
        ((Animatable) this.f849b.getDrawable()).stop();
        this.f849b.clearAnimation();
    }
}
