package com.duokan.reader.ui.personal;

import android.view.View;

import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.cloud.push.a;
import com.duokan.reader.domain.social.message.az;
import com.duokan.reader.domain.social.message.h;
import com.duokan.reader.ui.general.ar;

import java.util.ArrayList;

public class ck extends cq implements a, az {
    private final cc a;
    private final cr c;
    private final ig d = new ig(this);
    private final boolean e;

    public ck(IFeature featrue, boolean z) {
        int i;
        int i2 = 0;
        super(featrue);
        this.e = z;
        this.a = new cl(this, featrue);
        this.c = new cm(this, featrue);
        addSubController(this.a);
        addSubController(this.c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(j.personal__message_center_view__title));
        arrayList.add(getString(j.personal__message_push_view__title));
        this.d.setTabTitles(arrayList);
        arrayList = new ArrayList();
        arrayList.add(this.a.getContentView());
        arrayList.add(this.c.getContentView());
        this.d.setTabViews(arrayList);
        this.d.getPagerView().setOnSelectChangedListener(new cn(this));
        View titleView = this.d.getPagerView().getTitleView();
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        titleView.setVisibility(i);
        ar pagerView = this.d.getPagerView();
        if (!z) {
            i2 = 8;
        }
        pagerView.setTitleBottomLineVisibility(i2);
        setContentView(this.d);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.d.getPagerView().setSelectIndex(this.e ? 0 : 1);
            if (this.e) {
                c();
            } else {
                d();
            }
            h.a().a((az) this);
            b.a().a((a) this);
            b();
            a();
        }
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        h.a().b((az) this);
        b.a().b((a) this);
    }

    public void b() {
        this.d.getPagerView().a(0, h.a().b());
    }

    public void a() {
        this.d.getPagerView().a(1, b.a().c());
    }

    private void c() {
        deactivate(this.c);
        activate(this.a);
        getContentView().postDelayed(new co(this), 3000);
    }

    private void d() {
        deactivate(this.a);
        activate(this.c);
        getContentView().postDelayed(new cp(this), 3000);
    }
}
