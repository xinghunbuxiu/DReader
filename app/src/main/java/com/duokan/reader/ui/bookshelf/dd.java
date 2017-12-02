package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.t;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.common.async.work.e;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.micloud.i;

import java.lang.ref.WeakReference;
import java.util.Iterator;

class dd implements IAsyncWorkProgressListener, it, iv {
    private dd() {
    }

    public void a(i iVar) {
        h(iVar);
    }

    public void b(i iVar) {
    }

    public void c(i iVar) {
        h(iVar);
    }

    public void d(i iVar) {
        h(iVar);
    }

    public void e(i iVar) {
        h(iVar);
    }

    public void f(i iVar) {
        h(iVar);
    }

    public CheckErrorResult a(i iVar, e eVar) {
        return CheckErrorResult.Ignored;
    }

    public void g(i iVar) {
        h(iVar);
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof c) && (i & 72) != 0) {
            Iterator it = cz.d.iterator();
            while (it.hasNext()) {
                cz czVar = (cz) ((WeakReference) it.next()).get();
                if (czVar != null && czVar.getItem() == anVar) {
                    czVar.setItemData(czVar.getItem());
                    return;
                }
            }
        }
    }

    public void a(c cVar) {
        Iterator it = cz.d.iterator();
        while (it.hasNext()) {
            cz czVar = (cz) ((WeakReference) it.next()).get();
            if (czVar != null && (czVar.getItem() == cVar || (czVar.f() && czVar.getBookCategory().c(cVar)))) {
                czVar.q();
            }
        }
    }

    private void h(i iVar) {
        t.b(new de(this, iVar));
    }
}
