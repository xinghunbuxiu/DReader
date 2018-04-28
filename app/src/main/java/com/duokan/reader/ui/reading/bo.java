package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.bookshelf.fp;
import java.util.Arrays;

class bo implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f9881a;
    /* renamed from: b */
    final /* synthetic */ String f9882b;
    /* renamed from: c */
    final /* synthetic */ bn f9883c;

    bo(bn bnVar, int i, String str) {
        this.f9883c = bnVar;
        this.f9881a = i;
        this.f9882b = str;
    }

    public void onClick(View view) {
        if (!this.f9883c.b.mo1994K()) {
            if (this.f9881a == 11) {
                ((fp) this.f9883c.b.mo1992G()).m4483a(null);
            } else if (this.f9881a == 11001) {
                C0709k.m3476a().m3497a(PersonalAccount.class, new bp(this));
            } else {
                if (this.f9881a == 13) {
                    boolean z;
                    if (ee.aX()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    ee.m4397d(z);
                    ((ee) this.f9883c.b.mo1992G()).mo1034b(Arrays.asList(new String[]{this.f9882b}));
                }
                this.f9883c.b.mo2159j(false);
            }
        }
    }
}
