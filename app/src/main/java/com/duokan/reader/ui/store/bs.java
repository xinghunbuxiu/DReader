package com.duokan.reader.ui.store;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.dr;
import com.duokan.reader.ui.general.hd;
import java.util.List;

class bs extends dr {
    /* renamed from: c */
    final /* synthetic */ br f11384c;

    bs(br brVar, Context context) {
        this.f11384c = brVar;
        super(context);
    }

    /* renamed from: b */
    protected boolean mo2530b() {
        return this.f11384c.mo2563b();
    }

    /* renamed from: c */
    protected float mo2531c() {
        float f = 0.0f;
        for (Integer intValue : getVisibleViewIndexMap().keySet()) {
            int intValue2 = intValue.intValue();
            f = (((Float) getVisibleViewIndexMap().get(Integer.valueOf(intValue2))).floatValue() * dv.getAlpha(((float) ((bl) this.f11384c.f11381b.get(intValue2)).m15304l()) / ((float) (this.f11384c.f11383d - getTabView().getHeight())))) + f;
        }
        return f;
    }

    /* renamed from: e */
    protected float mo2533e() {
        List visibleList = getVisibleList();
        if (visibleList.size() == 0 || this.b < 0) {
            return 0.0f;
        }
        if (visibleList.size() == 1) {
            return dv.getAlpha(((((float) ((bl) this.f11384c.f11381b.get(((Integer) visibleList.get(0)).intValue())).m15304l()) - ((float) this.f11384c.f11383d)) + ((float) getStatusView().getHeight())) / ((float) getStatusView().getHeight()));
        }
        float c = mo2531c();
        if (c == 1.0f) {
            return c;
        }
        return 0.0f;
    }

    /* renamed from: d */
    protected float mo2532d() {
        List visibleList = getVisibleList();
        if (visibleList.size() == 0 || this.b < 0) {
            return 0.0f;
        }
        float f = 0.0f;
        for (Integer intValue : getVisibleViewIndexMap().keySet()) {
            int intValue2 = intValue.intValue();
            bl blVar = (bl) this.f11384c.f11381b.get(intValue2);
            f = (((Float) getVisibleViewIndexMap().get(Integer.valueOf(intValue2))).floatValue() * dv.getAlpha(((float) (((getTabView().getHeight() + blVar.m15304l()) - (visibleList.size() == 1 ? getTabView().getHeight() / 2 : 0)) - blVar.m15305m())) / ((float) dv.m1932b(getContext(), 12.0f)))) + f;
        }
        return f;
    }

    protected String getSearchKeyWord() {
        int i;
        int i2 = C0258j.store__shared__book_search;
        bl j = this.f11384c.m15345j();
        if (j == null || !(j instanceof ba)) {
            i = i2;
        } else {
            i = C0258j.store__shared__fiction_search;
        }
        CharSequence n = j != null ? j.m15306n() : "";
        if (TextUtils.isEmpty(n)) {
            n = this.f11384c.getString(C0258j.store__shared__default_search);
        }
        return String.format(getResources().getString(i), new Object[]{n});
    }

    /* renamed from: f */
    protected void mo2534f() {
        if (mo2532d() != 0.0f) {
            ((hd) AppContext.getAppContext(getContext()).queryFeature(hd.class)).mo2548a("", this.f11384c.m15345j().m15306n(), "");
        }
    }
}
