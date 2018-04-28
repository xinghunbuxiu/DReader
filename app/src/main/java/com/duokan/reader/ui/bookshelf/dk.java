package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.in;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.micloud.C1068i;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class dk implements IAsyncWorkProgressListener<C1068i>, in, ip {
    private dk() {
    }

    /* renamed from: a */
    public void m9472a(C1068i c1068i) {
        m9467h(c1068i);
    }

    /* renamed from: b */
    public void m9474b(C1068i c1068i) {
    }

    /* renamed from: c */
    public void m9476c(C1068i c1068i) {
        m9467h(c1068i);
    }

    /* renamed from: d */
    public void m9478d(C1068i c1068i) {
        m9467h(c1068i);
    }

    /* renamed from: e */
    public void m9480e(C1068i c1068i) {
        m9467h(c1068i);
    }

    /* renamed from: f */
    public void m9482f(C1068i c1068i) {
        m9467h(c1068i);
    }

    /* renamed from: a */
    public CheckErrorResult m9469a(C1068i c1068i, C0525e c0525e) {
        return CheckErrorResult.Ignored;
    }

    /* renamed from: g */
    public void m9484g(C1068i c1068i) {
        m9467h(c1068i);
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof C0800c) && (i & 72) != 0) {
            Iterator it = de.f6048d.iterator();
            while (it.hasNext()) {
                de deVar = (de) ((WeakReference) it.next()).get();
                if (deVar != null && deVar.getItem() == anVar) {
                    deVar.setItemData(deVar.getItem());
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        Iterator it = de.f6048d.iterator();
        while (it.hasNext()) {
            de deVar = (de) ((WeakReference) it.next()).get();
            if (deVar != null && (deVar.getItem() == c0800c || (deVar.m9118f() && deVar.getBookCategory().m3762c(c0800c)))) {
                deVar.m9109q();
            }
        }
    }

    /* renamed from: h */
    private void m9467h(C1068i c1068i) {
        UThread.post(new dl(this, c1068i));
    }
}
