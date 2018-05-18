package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.core.ui.BaseDialog;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.ui.general.be;
import java.util.LinkedList;
import java.util.List;

class kx implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ LinkedList f8842a;
    /* renamed from: b */
    final /* synthetic */ BaseDialog f8843b;
    /* renamed from: c */
    final /* synthetic */ List f8844c;
    /* renamed from: d */
    final /* synthetic */ Runnable f8845d;
    /* renamed from: e */
    final /* synthetic */ ku f8846e;

    kx(ku kuVar, LinkedList linkedList, BaseDialog dialog, List list, Runnable runnable) {
        this.f8846e = kuVar;
        this.f8842a = linkedList;
        this.f8843b = dialog;
        this.f8844c = list;
        this.f8845d = runnable;
    }

    /* renamed from: a */
    public void m12117a(Void voidR) {
        if (this.f8842a.size() > 0) {
            DkUserPurchasedFictionsManager.m5072a().m5095a(new ky(this), (String[]) this.f8842a.toArray(new String[0]));
            return;
        }
        this.f8843b.dismiss();
        be.m10287a(this.f8846e.getContext(), String.format(this.f8846e.getString(C0258j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.f8844c.size())}), 1).show();
        if (this.f8845d != null) {
            this.f8845d.run();
        }
        this.f8846e.f8834c.m12158a(this.f8844c);
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f8843b.dismiss();
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8846e.getContext(), (CharSequence) str, 1).show();
        }
        if (this.f8845d != null) {
            this.f8845d.run();
        }
    }
}
