package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.InsetDrawable;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.social.message.C1148h;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.dk;
import java.util.ArrayList;

public class bw extends oa {
    /* renamed from: a */
    private final ArrayList<C1151k> f8379a = new ArrayList();
    /* renamed from: l */
    private final hd f8380l = new bx(this);

    public bw(Context context, hv hvVar) {
        super(context, hvVar);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        setAdapter(this.f8380l);
        this.f.setRowDivider(new InsetDrawable(new dk(getResources().getColor(C0252d.general__shared__e9e9e9)), AnimUtils.m1932b(getContext(), 3.0f), 0, 0, 0));
        setBackgroundColor(getContext().getResources().getColor(C0252d.general__shared__ffffff));
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        if (ReaderEnv.get().forHd()) {
            int b = AnimUtils.m1932b(getContext(), 15.0f);
            this.f.m9955a(b, 0, b, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
            return;
        }
        b = AnimUtils.m1932b(getContext(), 10.0f);
        this.f.m9955a(b, 0, b, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
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
    public void m11542a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.personal__message_center_view__delete_multiple);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new ca(this, runnable));
    }

    /* renamed from: a */
    private void m11538a(int i, boolean z) {
        int i2;
        C1148h a = C1148h.m8567a();
        if (z) {
            i2 = 0;
        } else {
            i2 = this.f8379a.size();
        }
        a.m8482a(i2, i, true, new cc(this, z));
    }
}
