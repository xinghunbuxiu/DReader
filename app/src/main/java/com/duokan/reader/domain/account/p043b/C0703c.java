package com.duokan.reader.domain.account.p043b;

import android.accounts.Account;
import android.graphics.BitmapFactory;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.C0237c;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.domain.social.p048b.C1135b;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo.Flag;
import com.xiaomi.accountsdk.account.data.XiaomiUserProfile;
import com.xiaomi.passport.data.XMPassportInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.duokan.reader.domain.account.b.c */
public class C0703c extends C0237c {
    public C0703c(WebSession webSession) {
        super(webSession);
    }

    /* renamed from: a */
    public C0621a<bd> m3390a(Account account) {
        C0621a<bd> c0621a = new C0621a();
        List arrayList = new ArrayList();
        arrayList.add(Flag.BASE_INFO);
        arrayList.add(Flag.BIND_ADDRESS);
        XiaomiUserCoreInfo xiaomiUserCoreInfo = XMPassport.getXiaomiUserCoreInfo(XMPassportInfo.build(DkApp.get(), "passportapi"), "reader", arrayList);
        c0621a.b = 0;
        c0621a.c = "";
        c0621a.f2058a = new bd(account.name);
        ((bd) c0621a.f2058a).f2405e = new C1135b();
        ((bd) c0621a.f2058a).f2405e.f5458a = new User();
        ((bd) c0621a.f2058a).f2405e.f5458a.mUserId = xiaomiUserCoreInfo.userId;
        ((bd) c0621a.f2058a).f2405e.f5458a.mNickName = xiaomiUserCoreInfo.userName;
        ((bd) c0621a.f2058a).f2405e.f5458a.mIconUrl = xiaomiUserCoreInfo.avatarAddress;
        ((bd) c0621a.f2058a).f2404d = xiaomiUserCoreInfo.safePhone;
        ((bd) c0621a.f2058a).f2403c = xiaomiUserCoreInfo.emailAddress;
        return c0621a;
    }

    /* renamed from: e */
    public C0621a<String> m3391e(String str) {
        C0621a<String> c0621a = new C0621a();
        c0621a.f2058a = XMPassport.uploadXiaomiUserIcon(XMPassportInfo.build(DkApp.get(), "passportapi"), BitmapFactory.decodeFile(str));
        c0621a.b = 0;
        return c0621a;
    }

    /* renamed from: f */
    public C0621a<Void> m3392f(String str) {
        C0621a<Void> c0621a = new C0621a();
        PassportInfo build = XMPassportInfo.build(DkApp.get(), "passportapi");
        XiaomiUserProfile xiaomiUserProfile = XMPassport.getXiaomiUserProfile(build);
        xiaomiUserProfile.setUserName(str);
        XMPassport.uploadXiaomiUserProfile(build, xiaomiUserProfile);
        c0621a.b = 0;
        return c0621a;
    }
}
