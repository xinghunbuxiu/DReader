package com.duokan.reader.ui.personal;

import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.push.C0856a;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.social.message.C1148h;
import com.duokan.reader.domain.social.message.au;
import com.duokan.reader.ui.general.ar;
import java.util.ArrayList;

public class cd extends cj implements C0856a, au {
    /* renamed from: a */
    private final bv f8396a;
    /* renamed from: c */
    private final ck f8397c;
    /* renamed from: d */
    private final it f8398d = new it(this);
    /* renamed from: e */
    private final boolean f8399e;

    public cd(IFeature mFeature, boolean z) {
        int i;
        int i2 = 0;
        super(mFeature);
        this.f8399e = z;
        this.f8396a = new ce(this, mFeature);
        this.f8397c = new cf(this, mFeature);
        addSubController(this.f8396a);
        addSubController(this.f8397c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(C0258j.personal__message_center_view__title));
        arrayList.add(getString(C0258j.personal__message_push_view__title));
        this.f8398d.setTabTitles(arrayList);
        arrayList = new ArrayList();
        arrayList.add(this.f8396a.getContentView());
        arrayList.add(this.f8397c.getContentView());
        this.f8398d.setTabViews(arrayList);
        this.f8398d.getPagerView().setOnSelectChangedListener(new cg(this));
        View titleView = this.f8398d.getPagerView().getTitleView();
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        titleView.setVisibility(i);
        ar pagerView = this.f8398d.getPagerView();
        if (!z) {
            i2 = 8;
        }
        pagerView.setTitleBottomLineVisibility(i2);
        setContentView(this.f8398d);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8398d.getPagerView().setSelectIndex(this.f8399e ? 0 : 1);
            if (this.f8399e) {
                m11576c();
            } else {
                m11578d();
            }
            C1148h.m8567a().m8484a((au) this);
            C0857b.m5649a().m5681a((C0856a) this);
            mo1596b();
            mo1594a();
        }
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C1148h.m8567a().m8490b((au) this);
        C0857b.m5649a().m5687b((C0856a) this);
    }

    /* renamed from: b */
    public void mo1596b() {
        this.f8398d.getPagerView().m10234a(0, C1148h.m8567a().m8489b());
    }

    /* renamed from: a */
    public void mo1594a() {
        this.f8398d.getPagerView().m10234a(1, C0857b.m5649a().m5689c());
    }

    /* renamed from: c */
    private void m11576c() {
        deactivate(this.f8397c);
        activate(this.f8396a);
        getContentView().postDelayed(new ch(this), 3000);
    }

    /* renamed from: d */
    private void m11578d() {
        deactivate(this.f8396a);
        activate(this.f8397c);
        getContentView().postDelayed(new ci(this), 3000);
    }
}
