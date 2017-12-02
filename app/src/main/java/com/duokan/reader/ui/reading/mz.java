package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.ui.account.t;
import com.duokan.reader.ui.general.ia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class mz implements oc {
    final /* synthetic */ mx a;

    mz(mx mxVar) {
        this.a = mxVar;
    }

    public void a(List list, List list2) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < list.size()) {
            if (list2.get(i) != null && (i < 1 || list2.get(i) != list2.get(i - 1))) {
                hashMap.put(list.get(i), list2.get(i));
            }
            i++;
        }
        ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).showPopup(new t(this.a.getContext(), this.a.a.G(), hashMap, new ArrayList(list)));
    }

    public void a(List list, ah ahVar) {
        ia iaVar = new ia(this.a.getContext());
        iaVar.b(j.reading__navigation_view__jump);
        iaVar.b(j.reading__navigation_view__delete_bookmark);
        iaVar.a(new na(this, ahVar));
        iaVar.show();
    }

    public void a(List list, ef efVar) {
        ia iaVar = new ia(this.a.getContext());
        iaVar.b(j.reading__navigation_view__jump);
        if (TextUtils.isEmpty(efVar.m())) {
            iaVar.b(j.reading__navigation_view__delete_annotation);
        } else {
            iaVar.b(j.reading__navigation_view__delete_note);
        }
        iaVar.a(new nb(this, efVar));
        iaVar.show();
    }
}
