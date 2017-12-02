package com.duokan.reader.ui.account;

import com.duokan.c.j;
import com.duokan.reader.ui.general.ib;
import com.duokan.reader.ui.general.jq;

class ae implements ib {
    final /* synthetic */ String a;
    final /* synthetic */ z b;

    ae(z zVar, String str) {
        this.b = zVar;
        this.a = str;
    }

    public void a(int i) {
        if (i == 0) {
            jq jqVar;
            boolean z = this.b.a.canAccessTokenSyncToCloud(this.a) && i.f().b();
            if (z) {
                jqVar = new jq(this.b.getContext());
                jqVar.setCancelOnBack(false);
                jqVar.setCancelOnTouchOutside(false);
                jqVar.a(this.b.getContext().getString(j.account__shared__unbinding_sns));
                jqVar.show();
            } else {
                jqVar = null;
            }
            this.b.a.unbindAccessToken(this.b.getContext(), this.a, new af(this, jqVar));
            return;
        }
        this.b.b(this.a);
    }
}
