package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.drawable.InsetDrawable;
import android.util.Pair;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.personal.oa;

class afn extends oa {
    /* renamed from: a */
    final /* synthetic */ afm f9641a;

    public afn(afm afm, Context context, hv hvVar) {
        this.f9641a = afm;
        super(context, hvVar);
        this.c.setVisibility(8);
        this.b.setLeftTitle(C0258j.reading__tts_setting_view__title);
        this.f.setRowDivider(new InsetDrawable(new dk(getResources().getColor(C0252d.general__shared__e9e9e9)), AnimUtils.m1932b(getContext(), 3.0f), 0, 0, 0));
        this.f.setPullDownRefreshEnabled(false);
        this.f.setOnItemClickListener(new afo(this, afm));
        this.f.setOnItemLongPressListener(new afp(this, afm));
        setAdapter(new afq(this, afm));
    }

    /* renamed from: c */
    public void mo2231c(int i, int i2) {
        super.mo2231c(i, i2);
        this.f.m9955a(0, 0, 0, AnimUtils.m1932b(getContext(), 50.0f));
    }

    /* renamed from: q */
    public void mo2232q() {
        super.mo2232q();
        this.f.m9955a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void m13518a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.reading__tts_setting_view__delete_multiple);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new afu(this, runnable));
    }

    /* renamed from: a */
    private Pair<Integer, Integer> m13515a(int i) {
        WebLog c = WebLog.init();
        boolean z = this.f9641a.f9639b.isEmpty() && this.f9641a.f9640c.isEmpty();
        c.m762a(z);
        if (this.f9641a.f9640c.isEmpty() || this.f9641a.f9639b.isEmpty()) {
            return new Pair(Integer.valueOf(0), Integer.valueOf(i));
        }
        if (i > this.f9641a.f9639b.size() - 1) {
            return new Pair(Integer.valueOf(1), Integer.valueOf(i - this.f9641a.f9639b.size()));
        }
        return new Pair(Integer.valueOf(0), Integer.valueOf(i));
    }
}
