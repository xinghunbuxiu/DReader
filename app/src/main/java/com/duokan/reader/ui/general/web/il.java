package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.account.ab;
import com.duokan.reader.ui.account.ar;
import com.duokan.reader.ui.account.bu;
import com.duokan.reader.ui.general.be;

class il implements as {
    /* renamed from: a */
    final /* synthetic */ String f7997a;
    /* renamed from: b */
    final /* synthetic */ String f7998b;
    /* renamed from: c */
    final /* synthetic */ String f7999c;
    /* renamed from: d */
    final /* synthetic */ String f8000d;
    /* renamed from: e */
    final /* synthetic */ String f8001e;
    /* renamed from: f */
    final /* synthetic */ ik f8002f;

    il(ik ikVar, String str, String str2, String str3, String str4, String str5) {
        this.f8002f = ikVar;
        this.f7997a = str;
        this.f7998b = str2;
        this.f7999c = str3;
        this.f8000d = str4;
        this.f8001e = str5;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f8002f.f7996b.f7581b.mShareController != null) {
            this.f8002f.f7996b.f7581b.deactivate(this.f8002f.f7996b.f7581b.mShareController);
            this.f8002f.f7996b.f7581b.removeSubController(this.f8002f.f7996b.f7581b.mShareController);
        }
        bu imVar = new im(this);
        if (TextUtils.isEmpty(this.f7998b)) {
            new ab(this.f8002f.f7996b.f7581b.getContext(), false, new in(this, imVar)).show();
        } else if (this.f7998b.equals("weibo") || ThirdWeiXin.isWeiXinInstalled(this.f8002f.f7996b.f7581b.getContext())) {
            this.f8002f.f7996b.f7581b.mShareController = new ar(this.f8002f.f7996b.f7581b.getContext(), this.f7998b, this.f7999c, this.f8000d, this.f8001e, imVar);
            this.f8002f.f7996b.f7581b.addSubController(this.f8002f.f7996b.f7581b.mShareController);
            this.f8002f.f7996b.f7581b.activate(this.f8002f.f7996b.f7581b.mShareController);
        } else {
            be.m10286a(this.f8002f.f7996b.f7581b.getContext(), C0258j.share_name_weixin_not_install, 0).show();
        }
    }
}
