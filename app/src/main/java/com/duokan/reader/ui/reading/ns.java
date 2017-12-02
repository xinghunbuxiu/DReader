package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.core.sys.af;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.ap;

class ns implements OnClickListener {
    final /* synthetic */ nk a;

    ns(nk nkVar) {
        this.a = nkVar;
    }

    public void onClick(View view) {
        c G = this.a.b.G();
        if (G.ai() && !G.aj()) {
            if (G.U()) {
                G.aa();
            } else if (!G.k() || (!G.W() && !G.X())) {
                ((bm) this.a.b).c();
            } else if (f.b().c()) {
                ap apVar = new ap(this.a.getContext());
                apVar.setOkLabel(j.general__shared__continue);
                apVar.setCancelLabel(j.general__shared__cancel);
                apVar.setTitle(j.bookshelf__book__download_dialog__title);
                apVar.setPrompt(j.bookshelf__book__download_dialog__serial_prompt);
                apVar.open(new nt(this, G));
            } else {
                G.a(true, new af(Boolean.valueOf(true)));
            }
            this.a.f();
        }
    }
}
