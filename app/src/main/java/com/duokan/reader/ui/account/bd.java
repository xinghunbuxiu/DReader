package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.reader.ui.account.ShareEntranceController.ShareType;

public class bd {
    String a;
    String b;
    String c;
    String[] d;
    Bitmap e;
    ShareType f;

    bd(ShareType shareType, String[] strArr, String str, String str2, Bitmap bitmap, String str3) {
        this.a = str;
        this.c = str2;
        this.d = strArr;
        this.e = bitmap;
        this.f = shareType;
        this.b = str3;
    }
}
