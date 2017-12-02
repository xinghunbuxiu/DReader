package com.duokan.reader.ui.account;

import android.text.Html;

import com.duokan.c.j;
import com.duokan.core.app.y;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.*;
import com.duokan.reader.ui.general.dn;
import com.duokan.reader.ui.general.ew;

do;

public class q extends ew {
    private dn a = new r(this);

    public q(y yVar) {
        super(yVar);
        a(j.personal__miaccount_change_signature_view__title);
        b(25);
        a(i.f().c().f().b());
        a(this.a);
    }

    private void a(String str, do doVar) {
        i.f().c().a(getContext(), Html.fromHtml(str).toString(), new s(this, doVar));
    }
}
