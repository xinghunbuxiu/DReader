package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.ui.general.be;

class ky implements C0517a<Void> {
    /* renamed from: a */
    final /* synthetic */ kx f8847a;

    ky(kx kxVar) {
        this.f8847a = kxVar;
    }

    /* renamed from: a */
    public void m12120a(Void voidR) {
        this.f8847a.f8843b.dismiss();
        be.m10287a(this.f8847a.f8846e.getContext(), String.format(this.f8847a.f8846e.getString(C0258j.bookshelf__shared__delete_files_num), new Object[]{Integer.valueOf(this.f8847a.f8844c.size())}), 1).show();
        if (this.f8847a.f8845d != null) {
            this.f8847a.f8845d.run();
        }
        this.f8847a.f8846e.f8834c.m12158a(this.f8847a.f8844c);
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        this.f8847a.f8843b.dismiss();
        if (TextUtils.isEmpty(str)) {
            be.m10286a(this.f8847a.f8846e.getContext(), C0258j.bookshelf__shared__delete_fail, 1).show();
        } else {
            be.m10287a(this.f8847a.f8846e.getContext(), (CharSequence) str, 1).show();
        }
        if (this.f8847a.f8845d != null) {
            this.f8847a.f8845d.run();
        }
    }
}
