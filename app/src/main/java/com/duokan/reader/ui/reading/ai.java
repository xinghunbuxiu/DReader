package com.duokan.reader.ui.reading;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.ui.general.hd;
import com.duokan.reader.ui.reading.a.a;
import com.duokan.reader.ui.reading.a.ad;
import com.duokan.reader.ui.reading.a.ao;
import com.duokan.reader.ui.reading.a.j;

public class ai extends hd implements tb {
    boolean a = false;
    private FrameLayout b = null;
    private ActivatedController c = null;
    private wl d;
    private sh e;
    private a f;

    public ai(IFeature featrue, sh shVar, wl wlVar) {
        super(featrue);
        this.d = wlVar;
        this.e = shVar;
        this.f = new a(shVar);
        this.f.a(false);
        this.d.a(this.f);
        this.e.a((tb) this);
    }

    public void a(sh shVar, int i, int i2) {
        if (this.e.b(16)) {
            if (this.b == null) {
                View imageView = new ImageView(getContext());
                imageView.setImageResource(f.reading__shared__tts_show_menu);
                imageView.setBackgroundResource(f.general__shared__button_circular_48dip);
                imageView.setScaleType(ScaleType.CENTER);
                this.b = new FrameLayout(getContext());
                this.b.setPadding(0, 0, UTools.getMinimumHeight(getContext(), 15.0f), UTools.getMinimumHeight(getContext(), 30.0f));
                this.b.addView(imageView, new LayoutParams(-2, -2));
                this.d.getPagesFrameView().addView(this.b, new LayoutParams(-2, -2, 85));
                this.b.setOnClickListener(new aj(this));
            }
            this.b.setVisibility(0);
            a();
            return;
        }
        if (this.b != null) {
            this.b.setVisibility(4);
        }
        b();
    }

    public void a(sh shVar, ak akVar, ak akVar2) {
    }

    protected boolean onBack() {
        if (super.onBack()) {
            return true;
        }
        if (!AudioPlayer.a().b()) {
            return false;
        }
        this.e.i();
        return true;
    }

    protected boolean onShowMenu() {
        if (!AudioPlayer.a().b() || this.c != null) {
            return false;
        }
        this.c = new ab(getContext());
        showPopup(this.c);
        UTools.closeAnimation(this.c.getContentView(), null);
        return true;
    }

    protected boolean onHideMenu() {
        if (this.c == null) {
            return false;
        }
        this.c.requestDetach();
        return true;
    }

    protected boolean onCheckMenuShowing() {
        return this.c != null;
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (!activatedControllerVar.contains(this.c)) {
            return super.onRequestDetach(activatedControllerVar);
        }
        if (this.c.getContentView().getAnimation() == null) {
            UTools.c(this.c.getContentView(), new ak(this));
        }
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void a() {
        if (!this.a) {
            this.a = true;
            this.f.a(true);
            er[] a = this.e.a(ad.class, j.class, ao.class);
            for (er a2 : a) {
                a2.a(false);
            }
        }
    }

    private void b() {
        int i = 0;
        if (this.a) {
            this.a = false;
            this.f.a(false);
            er[] a = this.e.a(ad.class, j.class, ao.class);
            while (i < a.length) {
                a[i].a(true);
                i++;
            }
        }
    }
}
