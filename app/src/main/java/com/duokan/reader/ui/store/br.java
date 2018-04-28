package com.duokan.reader.ui.store;

import android.content.res.Configuration;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.dr;
import com.duokan.reader.ui.surfing.al;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class br extends ActivatedController {
    /* renamed from: a */
    private final dr f11380a = new bs(this, getContext());
    /* renamed from: b */
    private final ArrayList<bl> f11381b = new ArrayList();
    /* renamed from: c */
    private final Set<Integer> f11382c = new HashSet();
    /* renamed from: d */
    private final int f11383d = 520;

    public br(IFeature mFeature) {
        super(mFeature);
        this.f11380a.setOnCurrentPageChangedListener(new bt(this));
        setContentView(this.f11380a);
    }

    /* renamed from: a */
    protected void mo2562a() {
    }

    /* renamed from: b */
    protected boolean mo2563b() {
        return true;
    }

    /* renamed from: a */
    public void m15334a(bl blVar, String str) {
        this.f11381b.add(blVar);
        if (!getSubControllers().contains(blVar)) {
            addSubController(blVar);
        }
        this.f11380a.m10518a(str, blVar.getContentView());
    }

    /* renamed from: a */
    public void m15333a(int i, boolean z) {
        int max = Math.max(0, Math.min(i, this.f11381b.size() - 1));
        if (this.f11382c.contains(Integer.valueOf(max))) {
            m15330k();
            return;
        }
        for (int i2 = 0; i2 < this.f11381b.size(); i2++) {
            ActivatedController c0303e = (ActivatedController) this.f11381b.get(i2);
            if (i2 == max) {
                activate(c0303e);
            } else if (c0303e.isActive()) {
                deactivate(c0303e);
            }
        }
        this.f11380a.m10517a(max, z);
    }

    /* renamed from: c */
    public int m15338c() {
        return this.f11380a.getCurrentPageIndex();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            al alVar = (al) getContext().queryFeature(al.class);
            if (alVar != null) {
                alVar.mo2549a(true, "m");
            }
        }
        m15344i();
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        super.onActivityConfigurationChanged(configuration);
        this.f11380a.m10514a();
    }

    /* renamed from: d */
    public void m15339d() {
        this.f11381b.clear();
        this.f11380a.m10526g();
    }

    /* renamed from: e */
    public View m15340e() {
        return this.f11380a.getStatusView();
    }

    /* renamed from: f */
    public View m15341f() {
        return this.f11380a.getTabView();
    }

    /* renamed from: a */
    public void m15332a(int i) {
        int top = m15341f().getTop();
        if (top != i) {
            m15341f().offsetTopAndBottom(i - top);
        }
        m15341f().invalidate();
    }

    /* renamed from: g */
    public int m15342g() {
        return m15341f().getTop();
    }

    /* renamed from: h */
    public int m15343h() {
        return this.f11383d;
    }

    /* renamed from: a */
    public void m15335a(List<Integer> list) {
        for (Integer intValue : list) {
            this.f11380a.m10519b(intValue.intValue());
        }
        this.f11382c.addAll(list);
        if (list.contains(Integer.valueOf(m15338c()))) {
            m15330k();
        } else {
            m15333a(m15338c(), true);
        }
    }

    /* renamed from: b */
    public void m15336b(List<Integer> list) {
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            this.f11380a.m10522c(intValue2);
            this.f11382c.remove(Integer.valueOf(intValue2));
        }
        m15333a(m15338c(), true);
    }

    /* renamed from: k */
    private void m15330k() {
        int i = 0;
        while (i < this.f11381b.size()) {
            if (this.f11382c.contains(Integer.valueOf(i))) {
                i++;
            } else {
                m15333a(i, true);
                return;
            }
        }
    }

    /* renamed from: i */
    public void m15344i() {
        dv.m1921a(this.f11380a, new bu(this));
    }

    /* renamed from: j */
    public bl m15345j() {
        int c = m15338c();
        if (c < 0) {
            c = 0;
        }
        if (this.f11381b.size() == 0) {
            return null;
        }
        return (bl) this.f11381b.get(c);
    }
}
