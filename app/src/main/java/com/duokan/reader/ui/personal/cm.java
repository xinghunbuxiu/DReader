package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.InsetDrawable;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.dk;

class cm extends oa {
    /* renamed from: a */
    final /* synthetic */ ck f8408a;

    public cm(ck ckVar, Context context, hv hvVar) {
        this.f8408a = ckVar;
        super(context, hvVar);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.f.setRowDivider(new InsetDrawable(new dk(getResources().getColor(C0252d.general__shared__e9e9e9)), dv.m1932b(getContext(), 3.0f), 0, 0, 0));
        setBackgroundColor(getContext().getResources().getColor(C0252d.general__shared__ff6518));
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        int b;
        if (ReaderEnv.get().forHd()) {
            b = dv.m1932b(getContext(), 15.0f);
            this.f.m9955a(b, 0, b, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        } else {
            b = dv.m1932b(getContext(), 10.0f);
            this.f.m9955a(b, 0, b, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        }
        this.f.setOnItemClickListener(new cn(this, ckVar));
        this.f.setOnItemLongPressListener(new co(this, ckVar));
        setAdapter(new cp(this, ckVar));
    }

    /* renamed from: a */
    public void mo1891a() {
        this.f.setPullDownRefreshEnabled(false);
    }

    /* renamed from: b */
    public void mo1892b() {
        this.f.setPullDownRefreshEnabled(true);
    }

    /* renamed from: a */
    private void m11602a(int i, long j) {
        C0857b.m5649a().m5678a(i, j, new cq(this, i, j));
    }

    /* renamed from: a */
    public void m11605a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.personal__message_push_view__delete_multiple);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new cr(this, runnable));
    }
}
