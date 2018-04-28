package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.ui.account.C1256h;
import com.duokan.reader.ui.general.hp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class nj implements om {
    /* renamed from: a */
    final /* synthetic */ nh f10678a;

    nj(nh nhVar) {
        this.f10678a = nhVar;
    }

    /* renamed from: a */
    public void mo2452a(List<? extends C0798a> list, List<C0901g> list2) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < list.size()) {
            if (list2.get(i) != null && (i < 1 || list2.get(i) != list2.get(i - 1))) {
                hashMap.put(list.get(i), list2.get(i));
            }
            i++;
        }
        ((ReaderFeature) this.f10678a.getContext().queryFeature(ReaderFeature.class)).showPopup(new C1256h(this.f10678a.getContext(), this.f10678a.f10667a.mo1992G(), hashMap, new ArrayList(list)));
    }

    /* renamed from: a */
    public void mo2450a(List<? extends C0798a> list, ah ahVar) {
        hp hpVar = new hp(this.f10678a.getContext());
        hpVar.m9769b(C0258j.reading__navigation_view__jump);
        hpVar.m9769b(C0258j.reading__navigation_view__delete_bookmark);
        hpVar.m9767a(new nk(this, ahVar));
        hpVar.show();
    }

    /* renamed from: a */
    public void mo2451a(List<? extends C0798a> list, ea eaVar) {
        hp hpVar = new hp(this.f10678a.getContext());
        hpVar.m9769b(C0258j.reading__navigation_view__jump);
        if (TextUtils.isEmpty(eaVar.m4384m())) {
            hpVar.m9769b(C0258j.reading__navigation_view__delete_annotation);
        } else {
            hpVar.m9769b(C0258j.reading__navigation_view__delete_note);
        }
        hpVar.m9767a(new nl(this, eaVar));
        hpVar.show();
    }
}
