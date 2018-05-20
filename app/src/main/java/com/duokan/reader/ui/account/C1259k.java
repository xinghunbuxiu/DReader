package com.duokan.reader.ui.account;

import com.duokan.reader.domain.account.oauth.ThirdOAuth.QueryAccountListener;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;

/* renamed from: com.duokan.reader.ui.account.k */
class C1259k implements QueryAccountListener {
    /* renamed from: a */
    final /* synthetic */ ThirdYinxiang f5960a;
    /* renamed from: b */
    final /* synthetic */ C1258j f5961b;

    C1259k(C1258j c1258j, ThirdYinxiang thirdYinxiang) {
        this.f5961b = c1258j;
        this.f5960a = thirdYinxiang;
    }

    public void onQueryAccountOk(String... strArr) {
        String I;
        String makeContent;
        String makeTitle;
        if (this.f5961b.f5959a.f5955f != null) {
            I = this.f5961b.f5959a.f5955f.getId();
            makeContent = this.f5960a.makeContent(this.f5961b.f5959a.f5955f, this.f5961b.f5959a.f5956g, this.f5961b.f5959a.f5957h);
            makeTitle = this.f5960a.makeTitle(this.f5961b.f5959a.f5955f.ay(), this.f5961b.f5959a.f5955f.m4150C());
        } else {
            I = this.f5961b.f5959a.f5951b;
            makeContent = this.f5960a.makeContent(this.f5961b.f5959a.f5951b, this.f5961b.f5959a.f5952c, this.f5961b.f5959a.f5953d, this.f5961b.f5959a.f5954e);
            makeTitle = this.f5960a.makeTitle(this.f5961b.f5959a.f5952c, this.f5961b.f5959a.f5953d);
        }
        this.f5960a.output(I, makeTitle, makeContent, true, new C1260l(this));
    }

    public void onQueryAccountError() {
    }
}
