package com.duokan.reader.ui.bookshelf;

import com.duokan.c.j;
import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.jq;

import java.util.List;

class bs implements ac {
    final /* synthetic */ ap a;
    final /* synthetic */ int b;
    final /* synthetic */ List c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ Runnable e;
    final /* synthetic */ bk f;

    bs(bk bkVar, ap apVar, int i, List list, Runnable runnable, Runnable runnable2) {
        this.f = bkVar;
        this.a = apVar;
        this.b = i;
        this.c = list;
        this.d = runnable;
        this.e = runnable2;
    }

    public void a(ab abVar) {
        ah.b(new bt(this, this.a.isChecked(this.b), jq.a(this.f.getContext(), null, this.f.getString(j.importing))));
    }

    public void b(ab abVar) {
        this.a.dismiss();
        TaskHandler.PostTask(this.e);
    }
}
