package com.duokan.reader.ui.account.p050a;

import android.content.Context;
import com.duokan.core.app.ag;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.UserAccount;

/* renamed from: com.duokan.reader.ui.account.a.i */
public class C1244i extends C1240e {
    public C1244i(Context context, C0672a c0672a, C0420b c0420b) {
        super(context, c0672a, c0420b, new C1246k());
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        mo1564b();
        if (this.b != null && (this.b instanceof UserAccount)) {
            ((UserAccount) this.b).mo851u();
        }
        if (C0709k.m3476a().m3501b().equals(AccountType.XIAO_MI)) {
            C0709k.m3476a().m3493a(new C1245j(this));
        } else {
            C0709k.m3476a().m3504b(null);
        }
    }
}
