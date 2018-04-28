package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.be;
import java.util.LinkedList;

class bd implements C0666x {
    /* renamed from: a */
    final /* synthetic */ LinkedList f6156a;
    /* renamed from: b */
    final /* synthetic */ ao f6157b;

    bd(ao aoVar, LinkedList linkedList) {
        this.f6157b = aoVar;
        this.f6156a = linkedList;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f6157b.f6121a.mo1656b((C0800c[]) this.f6156a.toArray(new C0800c[0]));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        String string = this.f6157b.getString(C0258j.bookshelf__general_shared__upload_need_account);
        if (TextUtils.isEmpty(str)) {
            Object str2 = string;
        }
        be.m10287a(this.f6157b.getContext(), str2, 0).show();
    }
}
