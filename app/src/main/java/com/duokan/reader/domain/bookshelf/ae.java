package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.micloud.bi;

@SuppressLint({"DefaultLocale"})
public class ae {
    /* renamed from: a */
    public static String m3783a(int i, String str) {
        String str2 = "";
        switch (i) {
            case 0:
                str2 = "__DkBook__";
                break;
            case 1:
                str2 = "__DkSerial__";
                break;
            case 2:
                str2 = "__DkMagazine__";
                break;
            case 3:
                str2 = "__MiCloudBook__";
                break;
            default:
                throw new IllegalArgumentException();
        }
        return str2 + str;
    }

    /* renamed from: a */
    public static String m3786a(bi biVar) {
        return C0366o.m1034b(biVar.m8155e() + "_" + biVar.m8161k(), "md5").toLowerCase();
    }

    /* renamed from: a */
    public static String m3784a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        return dkCloudPurchasedBook.getBookUuid();
    }

    /* renamed from: a */
    public static String m3785a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        return dkCloudPurchasedFiction.getBookUuid();
    }
}
