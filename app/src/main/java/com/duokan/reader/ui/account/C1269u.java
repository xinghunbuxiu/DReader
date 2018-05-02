package com.duokan.reader.ui.account;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0255g;

/* renamed from: com.duokan.reader.ui.account.u */
class C1269u implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1261m f5978a;

    private C1269u(C1261m c1261m) {
        this.f5978a = c1261m;
    }

    public void onClick(View view) {
        int id = view.getId();
        String str = "";
        if (id == C0255g.account_sina_ll) {
            str = "weibo";
        } else if (id == C0255g.account_yingxiang_ll) {
            str = "yinxiang";
        }
        if (TextUtils.equals("yinxiang", str)) {
            if (this.f5978a.f5963a.isBindAccessToken(this.f5978a.getContext(), "yinxiang")) {
                this.f5978a.m9006a("yinxiang");
            } else if (this.f5978a.f5963a.isBindAccessToken(this.f5978a.getContext(), "evernote")) {
                this.f5978a.m9006a("evernote");
            } else {
                this.f5978a.m9010b("yinxiang");
            }
        } else if (this.f5978a.f5963a.isBindAccessToken(this.f5978a.getContext(), str)) {
            this.f5978a.m9006a(str);
        } else {
            this.f5978a.m9010b(str);
        }
    }
}
