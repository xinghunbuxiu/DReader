package com.duokan.reader.ui.general.web;

import com.duokan.c.j;
import com.duokan.core.sys.af;
import com.duokan.core.sys.as;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.ap;

import java.util.concurrent.Semaphore;

class gh implements as {
    final /* synthetic */ c a;
    final /* synthetic */ String b;
    final /* synthetic */ Semaphore c;
    final /* synthetic */ gg d;

    gh(gg ggVar, c cVar, String str, Semaphore semaphore) {
        this.d = ggVar;
        this.a = cVar;
        this.b = str;
        this.c = semaphore;
    }

    public void a() {
        if (f.b().c()) {
            ap apVar = new ap(this.d.b.b.getContext());
            apVar.setOkLabel(j.general__shared__continue);
            apVar.setCancelLabel(j.general__shared__cancel);
            apVar.setTitle(j.bookshelf__book__download_dialog__title);
            apVar.setPrompt(j.bookshelf__book__download_dialog__serial_prompt);
            apVar.open(new gi(this));
            return;
        }
        this.a.a(this.a.f(), this.b, "", "", true, new af(Boolean.valueOf(true)));
        this.c.release();
    }
}
