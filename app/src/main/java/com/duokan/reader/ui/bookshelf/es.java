package com.duokan.reader.ui.bookshelf;

import android.os.AsyncTask;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.C0613k;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.ui.general.ak;

class es implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ C0613k f6404a;
    /* renamed from: b */
    final /* synthetic */ eq f6405b;

    es(eq eqVar, C0613k c0613k) {
        this.f6405b = eqVar;
        this.f6404a = c0613k;
    }

    /* renamed from: a */
    public void m9567a(Void voidR) {
        this.f6404a.m2796a(Integer.valueOf(((Integer) this.f6404a.m2795a()).intValue() + 1));
        if (((Integer) this.f6404a.m2795a()).intValue() == 3) {
            m9564a();
        }
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
    }

    /* renamed from: a */
    private void m9564a() {
        ak akVar = new ak(this.f6405b.m9559b());
        akVar.setExtraContentResource(C0245g.bookroom__clear_invalid_book_view);
        akVar.addButtonView(this.f6405b.m9559b().getString(C0247i.general__shared__stop), this.f6405b.m9559b().getResources().getColor(C0241c.general__shared__c1));
        AsyncTask etVar = new et(this, akVar);
        akVar.setOnButtonClickedListener(new eu(this, etVar, akVar));
        etVar.execute(new Void[0]);
    }
}
