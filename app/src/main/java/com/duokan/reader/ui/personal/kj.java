package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.core.ui.j;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.ui.general.be;

import java.util.LinkedList;
import java.util.List;

class kj implements a {
    final /* synthetic */ LinkedList a;
    final /* synthetic */ j b;
    final /* synthetic */ List c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ kg e;

    kj(kg kgVar, LinkedList linkedList, j jVar, List list, Runnable runnable) {
        this.e = kgVar;
        this.a = linkedList;
        this.b = jVar;
        this.c = list;
        this.d = runnable;
    }

    public void a(Void voidR) {
        if (this.a.size() > 0) {
            DkUserPurchasedFictionsManager.a().a(new kk(this), (String[]) this.a.toArray(new String[0]));
            return;
        }
        this.b.dismiss();
        be.a(this.e.getContext(), String.format(this.e.getString(com.duokan.c.j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.c.size())}), 1).show();
        if (this.d != null) {
            this.d.run();
        }
        this.e.c.a(this.c);
    }

    public void a(int i, String str) {
        this.b.dismiss();
        if (!TextUtils.isEmpty(str)) {
            be.a(this.e.getContext(), (CharSequence) str, 1).show();
        }
        if (this.d != null) {
            this.d.run();
        }
    }
}
