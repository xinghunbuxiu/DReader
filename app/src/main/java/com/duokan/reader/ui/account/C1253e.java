package com.duokan.reader.ui.account;

import android.text.Html;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.general.C1329do;
import com.duokan.reader.ui.general.dn;
import com.duokan.reader.ui.general.eu;

/* renamed from: com.duokan.reader.ui.account.e */
public class C1253e extends eu {
    /* renamed from: a */
    private dn f5946a = new C1254f(this);

    public C1253e(IFeature mFeature) {
        super(mFeature);
        m8849a(C0258j.personal__miaccount_change_signature_view__title);
        m8852b(25);
        m8851a(C0709k.m3476a().m3508d().mo836f().mo872b());
        m8850a(this.f5946a);
    }

    /* renamed from: a */
    private void m8989a(String str, C1329do c1329do) {
        C0709k.m3476a().m3508d().mo847a(getContext(), Html.fromHtml(str).toString(), new C1255g(this, c1329do));
    }
}
