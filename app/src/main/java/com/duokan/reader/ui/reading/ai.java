package com.duokan.reader.ui.reading;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.p024c.C0254f;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.ui.general.gs;
import com.duokan.reader.ui.reading.p054a.C1420a;
import com.duokan.reader.ui.reading.p054a.C1429j;
import com.duokan.reader.ui.reading.p054a.ad;
import com.duokan.reader.ui.reading.p054a.ao;

public class ai extends gs implements to {
    /* renamed from: a */
    boolean f9764a = false;
    /* renamed from: b */
    private FrameLayout f9765b = null;
    /* renamed from: c */
    private ActivatedController f9766c = null;
    /* renamed from: d */
    private wy f9767d;
    /* renamed from: e */
    private su f9768e;
    /* renamed from: f */
    private C1420a f9769f;

    public ai(IFeature mFeature, su suVar, wy wyVar) {
        super(mFeature);
        this.f9767d = wyVar;
        this.f9768e = suVar;
        this.f9769f = new C1420a(suVar);
        this.f9769f.m1607a(false);
        this.f9767d.m13649a(this.f9769f);
        this.f9768e.mo2033a((to) this);
    }

    /* renamed from: a */
    public void mo2198a(su suVar, int i, int i2) {
        if (this.f9768e.mo2106b(16)) {
            if (this.f9765b == null) {
                View imageView = new ImageView(getContext());
                imageView.setImageResource(C0254f.reading__shared__tts_show_menu);
                imageView.setBackgroundResource(C0254f.general__shared__button_circular_48dip);
                imageView.setScaleType(ScaleType.CENTER);
                this.f9765b = new FrameLayout(getContext());
                this.f9765b.setPadding(0, 0, AnimUtils.m1932b(getContext(), 15.0f), AnimUtils.m1932b(getContext(), 30.0f));
                this.f9765b.addView(imageView, new LayoutParams(-2, -2));
                this.f9767d.getPagesFrameView().addView(this.f9765b, new LayoutParams(-2, -2, 85));
                this.f9765b.setOnClickListener(new aj(this));
            }
            this.f9765b.setVisibility(0);
            m13721a();
            return;
        }
        if (this.f9765b != null) {
            this.f9765b.setVisibility(4);
        }
        m13722b();
    }

    /* renamed from: a */
    public void mo2199a(su suVar, ak akVar, ak akVar2) {
    }

    protected boolean onBack() {
        if (super.onBack()) {
            return true;
        }
        if (!AudioPlayer.m3613a().m3641b()) {
            return false;
        }
        this.f9768e.mo2156i();
        return true;
    }

    protected boolean onShowMenu() {
        if (!AudioPlayer.m3613a().m3641b() || this.f9766c != null) {
            return false;
        }
        this.f9766c = new ab(getContext());
        showPopup(this.f9766c);
        AnimUtils.showAnimation(this.f9766c.getContentView(), null);
        return true;
    }

    protected boolean onHideMenu() {
        if (this.f9766c == null) {
            return false;
        }
        this.f9766c.requestDetach();
        return true;
    }

    protected boolean onCheckMenuShowing() {
        return this.f9766c != null;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (!c0303e.contains(this.f9766c)) {
            return super.onRequestDetach(c0303e);
        }
        if (this.f9766c.getContentView().getAnimation() == null) {
            AnimUtils.hideAnimation(this.f9766c.getContentView(), new ak(this));
        }
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: a */
    private void m13721a() {
        if (!this.f9764a) {
            this.f9764a = true;
            this.f9769f.m1607a(true);
            er[] a = this.f9768e.mo2042a(ad.class, C1429j.class, ao.class);
            for (er a2 : a) {
                a2.m1607a(false);
            }
        }
    }

    /* renamed from: b */
    private void m13722b() {
        int i = 0;
        if (this.f9764a) {
            this.f9764a = false;
            this.f9769f.m1607a(false);
            er[] a = this.f9768e.mo2042a(ad.class, C1429j.class, ao.class);
            while (i < a.length) {
                a[i].m1607a(true);
                i++;
            }
        }
    }
}
