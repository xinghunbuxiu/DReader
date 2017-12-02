package com.duokan.reader.domain.account.a;

import android.accounts.Account;
import android.graphics.BitmapFactory;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.d;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.bh;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo.Flag;
import com.xiaomi.accountsdk.account.data.XiaomiUserProfile;
import com.xiaomi.passport.data.XMPassportInfo;

import java.util.ArrayList;
import java.util.List;

public class c extends d {
    public c(WebSession webSession) {
        super(webSession);
    }

    public b a(Account account) {
        b bVar = new b();
        List arrayList = new ArrayList();
        arrayList.add(Flag.BASE_INFO);
        arrayList.add(Flag.BIND_ADDRESS);
        XiaomiUserCoreInfo xiaomiUserCoreInfo = XMPassport.getXiaomiUserCoreInfo(XMPassportInfo.build(DkApp.get(), "passportapi"), "reader", arrayList);
        bVar.b = 0;
        bVar.c = "";
        bVar.a = new bh(account.name);
        ((bh) bVar.a).e = new com.duokan.reader.domain.social.b.b();
        ((bh) bVar.a).e.a = new User();
        ((bh) bVar.a).e.a.mUserId = xiaomiUserCoreInfo.userId;
        ((bh) bVar.a).e.a.mNickName = xiaomiUserCoreInfo.userName;
        ((bh) bVar.a).e.a.mIconUrl = xiaomiUserCoreInfo.avatarAddress;
        ((bh) bVar.a).d = xiaomiUserCoreInfo.safePhone;
        ((bh) bVar.a).c = xiaomiUserCoreInfo.emailAddress;
        return bVar;
    }

    public b e(String str) {
        b bVar = new b();
        bVar.a = XMPassport.uploadXiaomiUserIcon(XMPassportInfo.build(DkApp.get(), "passportapi"), BitmapFactory.decodeFile(str));
        bVar.b = 0;
        return bVar;
    }

    public b f(String str) {
        b bVar = new b();
        PassportInfo build = XMPassportInfo.build(DkApp.get(), "passportapi");
        XiaomiUserProfile xiaomiUserProfile = XMPassport.getXiaomiUserProfile(build);
        xiaomiUserProfile.setUserName(str);
        XMPassport.uploadXiaomiUserProfile(build, xiaomiUserProfile);
        bVar.b = 0;
        return bVar;
    }
}
