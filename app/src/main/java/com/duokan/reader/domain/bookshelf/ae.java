package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;

import com.duokan.core.sys.o;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.micloud.bi;

@SuppressLint({"DefaultLocale"})
public class ae {
    public static String a(int i, String str) {
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

    public static String a(bi biVar) {
        return o.b(biVar.e() + "_" + biVar.k(), "md5").toLowerCase();
    }

    public static String a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        return dkCloudPurchasedBook.getBookUuid();
    }

    public static String a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        return dkCloudPurchasedFiction.getBookUuid();
    }
}
