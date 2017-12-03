package com.duokan.reader.ui.reading;

import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.reading.a.w;
import com.duokan.reader.ui.reading.a.z;

public class ls extends ActivatedController implements z {
    private final sh a;
    private final wl b;
    private lx c;
    private w d = new w(this);

    public ls(IFeature featrue, sh shVar, wl wlVar) {
        super(featrue);
        this.a = shVar;
        this.b = wlVar;
        this.d.a(false);
        this.a.a(new lt(this));
    }

    public void a(ah ahVar, Rect rect, lw lwVar) {
        if (this.c != null) {
            if (ahVar == this.c.d()) {
                this.c.c();
                return;
            }
            c();
        }
        this.d.a(true);
        b(ahVar, rect, lwVar);
        if (this.c != null) {
            this.b.addView(this.c.b(), new LayoutParams(-1, -1));
        }
    }

    public boolean a() {
        if (this.c != null) {
            return this.c.f();
        }
        return false;
    }

    public w b() {
        return this.d;
    }

    public void c() {
        a();
    }

    protected boolean onBack() {
        return a();
    }

    protected boolean onShowMenu() {
        if (this.c != null) {
            return this.c.i();
        }
        return false;
    }

    protected boolean onHideMenu() {
        if (this.c != null) {
            return this.c.j();
        }
        return true;
    }

    protected boolean onCheckMenuShowing() {
        if (this.c != null) {
            return this.c.h();
        }
        return false;
    }

    protected void onActivityPaused() {
        if (this.c != null) {
            this.c.g();
        }
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        if (this.c != null) {
            this.c.a(configuration);
        }
    }

    public boolean a(View view, PointF pointF) {
        if (this.c != null) {
            return this.c.a(view, pointF);
        }
        return false;
    }

    public void a(View view, PointF pointF, float f) {
        if (this.c != null) {
            this.c.a(view, pointF, f);
        }
    }

    private void b(ah ahVar, Rect rect, lw lwVar) {
        if (ahVar.d()) {
            this.c = new IFeature(getActivity(), this.a, ahVar, rect, new lu(this, lwVar));
        } else if (ahVar.e()) {
            this.c = new afh(getActivity(), this.a, ahVar, rect, new lv(this, lwVar));
        }
    }
}
