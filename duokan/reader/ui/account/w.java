package com.duokan.reader.ui.account;

import com.duokan.reader.domain.account.oauth.ThirdOAuth.QueryAccountListener;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;

class w implements QueryAccountListener {
    final /* synthetic */ ThirdYinxiang a;
    final /* synthetic */ v b;

    w(v vVar, ThirdYinxiang thirdYinxiang) {
        this.b = vVar;
        this.a = thirdYinxiang;
    }

    public void onQueryAccountOk(String... strArr) {
        String H;
        String makeContent;
        String makeTitle;
        if (this.b.b.a.f != null) {
            H = this.b.b.a.f.H();
            makeContent = this.a.makeContent(this.b.b.a.f, this.b.b.a.g, this.b.b.a.h);
            makeTitle = this.a.makeTitle(this.b.b.a.f.aw(), this.b.b.a.f.B());
        } else {
            H = this.b.b.a.b;
            makeContent = this.a.makeContent(this.b.b.a.b, this.b.b.a.c, this.b.b.a.d, this.b.b.a.e);
            makeTitle = this.a.makeTitle(this.b.b.a.c, this.b.b.a.d);
        }
        this.a.output(H, makeTitle, makeContent, true, new x(this));
    }

    public void onQueryAccountError() {
    }
}
