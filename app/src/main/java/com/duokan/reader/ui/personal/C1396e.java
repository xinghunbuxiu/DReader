package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.duokan.core.sys.ah;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.bookshelf.hv;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.duokan.reader.ui.personal.e */
public class C1396e extends oa {
    /* renamed from: a */
    private final C1402j f8478a;
    /* renamed from: l */
    private final List<C0800c> f8479l = new ArrayList();
    /* renamed from: m */
    private final View f8480m;

    public C1396e(Context context, hv hvVar) {
        super(context, hvVar);
        this.b.setLeftTitle(getResources().getString(C0258j.personal__personal_settings_view__auto_buy));
        this.c.setVisibility(8);
        this.f.setOnItemClickListener(new C1397f(this));
        this.f8478a = new C1402j();
        setAdapter(this.f8478a);
        this.f8480m = LayoutInflater.from(getContext()).inflate(C0256h.personal__auto_buy_group_title_view, this.f, false);
        this.f.setHatBodyView(this.f8480m);
        this.f8480m.setVisibility(8);
    }

    public void f_() {
        this.f.setPullDownRefreshEnabled(false);
        ah.m871b(new C1399h(this));
    }

    public List<Object> getSelectedItems() {
        return this.f8478a.m9788j();
    }

    /* renamed from: a */
    public void m11715a(List<C0800c> list) {
        this.f8479l.removeAll(list);
        mo1901a(false);
    }

    /* renamed from: a */
    public void mo1901a(boolean z) {
        this.f8480m.setVisibility(this.f8479l.isEmpty() ? 8 : 0);
        super.mo1901a(z);
    }
}
