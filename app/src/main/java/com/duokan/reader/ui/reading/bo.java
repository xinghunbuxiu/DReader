package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.fv;

import java.util.Arrays;

class bo implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ bn c;

    bo(bn bnVar, int i, String str) {
        this.c = bnVar;
        this.a = i;
        this.b = str;
    }

    public void onClick(View view) {
        if (!this.c.b.K()) {
            if (this.a == 11) {
                ((fv) this.c.b.G()).a(null);
            } else if (this.a == 11001) {
                i.f().a(PersonalAccount.class, new bp(this));
            } else {
                if (this.a == 13) {
                    boolean z;
                    if (ej.aV()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    ej.c(z);
                    ((ej) this.c.b.G()).b(Arrays.asList(new String[]{this.b}));
                }
                this.c.b.j(false);
            }
        }
    }
}
