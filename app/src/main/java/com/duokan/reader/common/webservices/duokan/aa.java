package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.o;
import com.duokan.kernel.filterlib.DkfLib;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.payment.s;
import com.mipay.sdk.Mipay;

import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class aa extends ad {
    static final /* synthetic */ boolean a = (!aa.class.desiredAssertionStatus());
    private final String g;
    private final String h;

    public aa(WebSession webSession, a aVar) {
        super(webSession, aVar);
        if (aVar == null) {
            this.g = "";
            this.h = "";
            return;
        }
        this.g = TextUtils.isEmpty(aVar.c()) ? "" : aVar.c();
        this.h = aVar.c();
    }

    public aa(WebSession webSession, ab abVar) {
        super(webSession, abVar);
        if (abVar == null) {
            this.g = "";
            this.h = "";
            return;
        }
        this.g = TextUtils.isEmpty(abVar.c) ? "" : abVar.c;
        this.h = abVar.e;
    }

    public b a(String str, String str2) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return f(str, str2);
        }
        return h(str, str2);
    }

    public b a(String str, String... strArr) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return b(str, strArr);
        }
        return c(str, strArr);
    }

    public b a(long j) {
        b bVar = new b();
        b c = c(j);
        if (c.b != 0) {
            bVar.a = new DkCloudPurchasedFictionInfo[0];
            bVar.b = c.b;
            bVar.c = c.c;
            return c;
        }
        b e = e(j);
        if (e.b != 0) {
            bVar.a = new DkCloudPurchasedFictionInfo[0];
            bVar.b = e.b;
            bVar.c = e.c;
            return e;
        }
        bVar.a = new DkCloudPurchasedFictionInfo[(((DkCloudPurchasedFictionInfo[]) e.a).length + ((DkCloudPurchasedFictionInfo[]) c.a).length)];
        for (int i = 0; i < ((DkCloudPurchasedFictionInfo[]) bVar.a).length; i++) {
            if (i < ((DkCloudPurchasedFictionInfo[]) c.a).length) {
                ((DkCloudPurchasedFictionInfo[]) bVar.a)[i] = ((DkCloudPurchasedFictionInfo[]) c.a)[i];
            } else {
                ((DkCloudPurchasedFictionInfo[]) bVar.a)[i] = ((DkCloudPurchasedFictionInfo[]) e.a)[i - ((DkCloudPurchasedFictionInfo[]) c.a).length];
            }
        }
        bVar.b = 0;
        bVar.c = "";
        return bVar;
    }

    public b e(String str) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return h(str);
        }
        return i(str);
    }

    public b b(String str, String str2) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return e(str, str2);
        }
        return i(str, str2);
    }

    public static String a(String... strArr) {
        int i;
        int i2 = 0;
        int[] iArr = new int[strArr.length];
        for (i = 0; i < strArr.length; i++) {
            iArr[i] = Integer.valueOf(strArr[i]).intValue();
        }
        Arrays.sort(iArr);
        LinkedList linkedList = new LinkedList();
        i = 0;
        while (i2 < iArr.length) {
            if (i2 == iArr.length - 1 || iArr[i2] + 1 != iArr[i2 + 1]) {
                if (i2 == i) {
                    linkedList.add("" + iArr[i]);
                } else {
                    linkedList.add(iArr[i] + "-" + iArr[i2]);
                }
                i = i2 + 1;
            }
            i2++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String[] f(String str) {
        LinkedList linkedList = new LinkedList();
        for (String split : str.split(",")) {
            try {
                String[] split2 = split.split("-");
                if (split2.length == 1) {
                    linkedList.add(split2[0]);
                } else if (split2.length == 2) {
                    long longValue = Long.valueOf(split2[1]).longValue();
                    for (long longValue2 = Long.valueOf(split2[0]).longValue(); longValue2 <= longValue; longValue2++) {
                        linkedList.add("" + longValue2);
                    }
                }
            } catch (Throwable th) {
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    public b a() {
        JSONObject a = a(a(a(true, b() + "/store/v0/time_limited/get", new String[0])), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = i.a(a, "msg", "");
        if (bVar.b == 0) {
            bVar.a = a;
        }
        return bVar;
    }

    public b a(String str, String str2, String str3) {
        if (!a && str == null) {
            throw new AssertionError();
        } else if (a || str2 != null) {
            JSONObject a = a(a(a(true, b() + "/drm/v0/time_certificate", "local_time", "" + ("" + (System.currentTimeMillis() / 1000)), "book_uuid", str, "book_revision", str2, "magic_id", str3)), HTTP.UTF_8);
            b bVar = new b();
            bVar.b = a.getInt(Mipay.KEY_RESULT);
            bVar.c = a.optString(Mipay.KEY_MESSAGE, "");
            if (bVar.b != 0) {
                return bVar;
            }
            String string = a.getString("cert");
            if (TextUtils.isEmpty(string)) {
                return bVar;
            }
            bVar.a = new z();
            ((z) bVar.a).a = 100;
            Object bytes = this.g.getBytes(HTTP.UTF_8);
            Object bytes2 = r1.getBytes(HTTP.UTF_8);
            Object bytes3 = str.getBytes(HTTP.UTF_8);
            Object bytes4 = str3.getBytes(HTTP.UTF_8);
            Object obj = new byte[((((bytes.length + bytes2.length) + bytes3.length) + bytes4.length) + 4)];
            Arrays.fill(obj, (byte) 0);
            System.arraycopy(bytes, 0, obj, 0, bytes.length);
            System.arraycopy(bytes2, 0, obj, bytes.length + 1, bytes2.length);
            System.arraycopy(bytes3, 0, obj, (bytes.length + bytes2.length) + 2, bytes3.length);
            System.arraycopy(bytes4, 0, obj, ((bytes.length + bytes2.length) + bytes3.length) + 3, bytes4.length);
            ((z) bVar.a).b = o.a(string);
            ((z) bVar.a).c = obj;
            ((z) bVar.a).d = a.getLong("limited_time") * 1000;
            ((z) bVar.a).e = a.optInt("allow_free_read", 1) == 1;
            return bVar;
        } else {
            throw new AssertionError();
        }
    }

    public b a(String str, int i) {
        JSONObject a = a(a(b(true, p.i().y() + "/hs/v2/payment/info", "book_id", str, "price", String.valueOf(i))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = a;
        }
        return bVar;
    }

    public b a(String str, String str2, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("fiction_id");
        arrayList.add(str);
        arrayList.add("chapter_id");
        arrayList.add(str2);
        arrayList.add("pos");
        arrayList.add("" + i);
        arrayList.add("price");
        arrayList.add("" + i2);
        JSONObject a = a(a(b(true, p.i().y() + "/hs/v2/payment/info", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b == 0) {
            bVar.a = a;
        }
        return bVar;
    }

    public b c(String str, String str2) {
        JSONObject a = a(a(a(true, b() + "/store/v0/redeem/single/create", "book_uuid", str2, "payment_name", str, "ch", ReaderEnv.get().getDistChannel())), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        bVar.a = new DkStoreOrderInfo();
        bVar.c = i.b(a, "words");
        ((DkStoreOrderInfo) bVar.a).mPaymentMothodName = str;
        ((DkStoreOrderInfo) bVar.a).mOrderUuid = a.getString("trans_id");
        ((DkStoreOrderInfo) bVar.a).mBookUuid = a.getString("link");
        ((DkStoreOrderInfo) bVar.a).mPrice = (int) Math.round(a.optDouble("price", 0.0d) * 100.0d);
        ((DkStoreOrderInfo) bVar.a).mPaymentEnvelop = URLDecoder.decode(a.optString("payment_envelope"));
        ((DkStoreOrderInfo) bVar.a).mPaymentId = URLDecoder.decode(a.optString("payment_id"));
        ((DkStoreOrderInfo) bVar.a).mPaymentSenderSign = URLDecoder.decode(a.optString("payment_sender_sign"));
        return bVar;
    }

    public b a(int i, int i2, Boolean bool) {
        int i3 = 0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("start");
        arrayList.add(i + "");
        arrayList.add("count");
        arrayList.add(i2 + "");
        if (bool != null) {
            arrayList.add("used");
            arrayList.add(bool + "");
        }
        JSONObject a = a(a(a(true, b() + "/store/v0/redeem/single/list", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        bVar.c = a.getString("more");
        JSONArray jSONArray = a.getJSONArray("items");
        bVar.a = new DkStoreRedeemFundInfo[jSONArray.length()];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (i3 < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3] = new DkStoreRedeemFundInfo();
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mLinkUrl = jSONObject.getString("link");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mStatus = jSONObject.getInt("status");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mBookUuid = jSONObject.getString("book_uuid");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mBookTitle = jSONObject.getString("book_title");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mBookCover = jSONObject.getString("book_cover");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mAuthor = i.b(jSONObject, "book_authors");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mEditor = i.b(jSONObject, "book_editors");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mReceiverId = i.b(jSONObject, "to");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mNickName = i.b(jSONObject, "to_nick");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mIconUrl = i.b(jSONObject, "to_icon");
            ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mWords = jSONObject.optString("words");
            try {
                ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mWordUpdatedTime = simpleDateFormat.parse(jSONObject.getString("words_time"));
            } catch (Exception e) {
                e.printStackTrace();
                ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mWordUpdatedTime = new Date();
            }
            try {
                ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mStatusUpdatedTime = simpleDateFormat.parse(jSONObject.getString("status_time"));
            } catch (Exception e2) {
                e2.printStackTrace();
                ((DkStoreRedeemFundInfo[]) bVar.a)[i3].mStatusUpdatedTime = new Date();
            }
            i3++;
        }
        return bVar;
    }

    public b d(String str, String str2) {
        JSONObject a = a(a(a(true, b() + "/store/v0/redeem/single/update_message", "link", str, "words", str2)), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        return bVar;
    }

    public b g(String str) {
        JSONObject a = a(a(a(true, b() + "/store/v0/redeem/single/get_message", "book_id", str)), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        bVar.a = new DkStoreRedeemBenefitInfo();
        ((DkStoreRedeemBenefitInfo) bVar.a).mOrderUuid = a.getString("order_id");
        ((DkStoreRedeemBenefitInfo) bVar.a).mFromUuid = a.getString("from");
        ((DkStoreRedeemBenefitInfo) bVar.a).mMessage = a.getString(Mipay.KEY_MESSAGE);
        try {
            ((DkStoreRedeemBenefitInfo) bVar.a).mTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(a.getString("time"));
        } catch (Exception e) {
            e.printStackTrace();
            ((DkStoreRedeemBenefitInfo) bVar.a).mTime = new Date();
        }
        return bVar;
    }

    public b a(String str, s sVar, String str2) {
        if (TextUtils.isEmpty(str)) {
            return a(sVar, str2);
        }
        return c(a(true, str, "receipt", str2, "query", sVar.b()));
    }

    public b a(s sVar, String str) {
        if (!a && str == null) {
            throw new AssertionError();
        } else if (TextUtils.equals(sVar.d(), "ALIPAY_MOBILE")) {
            JSONObject a = a(a(a(true, b() + "/store/v0/payment/alipay_mobile_return", new String[0]).c().a(str.getBytes(HTTP.UTF_8)).a()), HTTP.UTF_8);
            b bVar = new b();
            bVar.b = a.getInt(Mipay.KEY_RESULT);
            return bVar;
        } else if (TextUtils.equals(sVar.d(), "WXPAY")) {
            return c(a(true, b() + "/store/v0/payment/wxpay_return", "query", sVar.b()));
        } else {
            return c(a(true, b() + "/store/v0/payment/mipay_return", "receipt", str, "query", sVar.b()));
        }
    }

    private b c(com.duokan.reader.common.webservices.duokan.a.a aVar) {
        JSONObject a = a(a(aVar), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b e(String str, String str2) {
        if (a || str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("payment_name");
            arrayList.add(p.i().k() ? "BC" : "BC_SANDBOX");
            arrayList.add("fiction_id");
            arrayList.add(str);
            arrayList.add("chapter_id");
            arrayList.add(str2);
            arrayList.add("ch");
            arrayList.add(ReaderEnv.get().getDistChannel());
            arrayList.add("auto");
            arrayList.add("1");
            JSONObject jSONObject = new JSONObject(b(a(a(true, b() + "/store/v0/payment/fiction/create", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8));
            b bVar = new b();
            bVar.b = jSONObject.getInt(Mipay.KEY_RESULT);
            bVar.c = jSONObject.optString("msg");
            switch (bVar.b) {
                case 10012:
                case 10013:
                case 10019:
                    bVar.b = 0;
                    break;
            }
            if (bVar.b != 0) {
                return bVar;
            }
            bVar.a = new DkStoreOrderInfo();
            ((DkStoreOrderInfo) bVar.a).mPaymentMothodName = "BC";
            ((DkStoreOrderInfo) bVar.a).mBookUuid = str;
            ((DkStoreOrderInfo) bVar.a).mOrderStatus = DkStoreOrderStatus.UNPAID;
            ((DkStoreOrderInfo) bVar.a).mPrice = (int) Math.round(jSONObject.optDouble("price", 0.0d) * 100.0d);
            ((DkStoreOrderInfo) bVar.a).mOrderUuid = jSONObject.optString("trans_id");
            ((DkStoreOrderInfo) bVar.a).mPaymentEnvelop = URLDecoder.decode(jSONObject.optString("payment_envelope"));
            ((DkStoreOrderInfo) bVar.a).mPaymentId = URLDecoder.decode(jSONObject.optString("payment_id"));
            ((DkStoreOrderInfo) bVar.a).mPaymentSenderSign = URLDecoder.decode(jSONObject.optString("payment_sender_sign"));
            return bVar;
        }
        throw new AssertionError();
    }

    public b b(long j) {
        JSONObject a = a(a(a(true, b() + "/store/v0/payment/book/list2", "st", String.valueOf(j))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        if (a.has("items")) {
            String valueOf;
            JSONArray jSONArray = a.getJSONArray("items");
            if (jSONArray.length() > 0) {
                valueOf = String.valueOf(Boolean.TRUE);
            } else {
                valueOf = String.valueOf(Boolean.FALSE);
            }
            bVar.c = valueOf;
            bVar.a = new DkCloudPurchasedBookInfo[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                long j2;
                boolean z;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i] = new DkCloudPurchasedBookInfo();
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mOrderUuid = jSONObject.getString("order_id");
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mTitle = jSONObject.getString("title");
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mCoverUri = jSONObject.getString("cover");
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mAuthors = jSONObject.getString("authors").split("\r*\n+");
                Object optString = jSONObject.optString("editors");
                if (TextUtils.isEmpty(optString)) {
                    ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mEditors = new String[0];
                } else {
                    ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mEditors = optString.split("\r*\n+");
                }
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mBookUuid = jSONObject.getString("book_id");
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mAd = jSONObject.optInt("MyTask", 0) == 1;
                try {
                    j2 = jSONObject.getLong("time");
                } catch (Exception e) {
                    j2 = System.currentTimeMillis() / 1000;
                }
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].setPurchaseTimeInSeconds(j2);
                try {
                    j2 = jSONObject.getLong("update_time");
                } catch (Exception e2) {
                    j2 = System.currentTimeMillis() / 1000;
                }
                ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mUpdateTime = j2;
                JSONArray optJSONArray = jSONObject.optJSONArray("labels");
                if (optJSONArray == null || optJSONArray.length() < 1) {
                    ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
                } else {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        Object split = optJSONArray.getString(i2).split("-->");
                        if (split.length > 0) {
                            arrayList.add(split);
                        }
                    }
                    if (arrayList.size() > 0) {
                        ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mLabels = (String[][]) arrayList.toArray(new String[0][]);
                    } else {
                        ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
                    }
                }
                try {
                    optString = i.b(jSONObject, "type");
                    ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mType = TextUtils.isEmpty(optString) ? DkStoreBookSourceType.NORMAL : DkStoreBookSourceType.valueOf(optString.toUpperCase());
                } catch (Exception e3) {
                    e3.printStackTrace();
                    ((DkCloudPurchasedBookInfo[]) bVar.a)[i].mType = DkStoreBookSourceType.NORMAL;
                }
                DkCloudPurchasedBookInfo dkCloudPurchasedBookInfo = ((DkCloudPurchasedBookInfo[]) bVar.a)[i];
                if (jSONObject.getInt("status") == 100) {
                    z = true;
                } else {
                    z = false;
                }
                dkCloudPurchasedBookInfo.mIsHide = z;
            }
        } else {
            bVar.a = new DkCloudPurchasedBookInfo[0];
            bVar.c = String.valueOf(Boolean.FALSE);
        }
        return bVar;
    }

    public b h(String str) {
        JSONObject a = a(a(a(true, b() + "/store/v0/payment/fiction/chapter/list", "getScaledTouchSlop", "3", "fiction_id", str)), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        long j;
        bVar.a = new DkCloudPurchasedFictionInfo();
        ((DkCloudPurchasedFictionInfo) bVar.a).mBookUuid = str;
        try {
            j = a.getLong("time");
        } catch (Exception e) {
            Exception exception = e;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            exception.printStackTrace();
            j = currentTimeMillis;
        }
        ((DkCloudPurchasedFictionInfo) bVar.a).setPurchaseTimeInSeconds(j);
        if (a.has("entire") && a.getBoolean("entire")) {
            ((DkCloudPurchasedFictionInfo) bVar.a).mEntire = true;
            ((DkCloudPurchasedFictionInfo) bVar.a).mPaidChapterId = new String[0];
        } else {
            Object string = a.getString("items");
            LinkedList linkedList = new LinkedList();
            if (!TextUtils.equals(string, "[]")) {
                String[] split = string.split(",");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].contains("-")) {
                        String[] split2 = split[i].split("-");
                        for (int intValue = Integer.valueOf(split2[0]).intValue(); intValue <= Integer.valueOf(split2[1]).intValue(); intValue++) {
                            linkedList.addLast(String.valueOf(intValue));
                        }
                    } else if (split[i].matches("[0-9]*")) {
                        linkedList.addLast(split[i]);
                    }
                }
            }
            ((DkCloudPurchasedFictionInfo) bVar.a).mPaidChapterId = (String[]) linkedList.toArray(new String[0]);
        }
        return bVar;
    }

    public b a(boolean z, String... strArr) {
        com.duokan.reader.common.webservices.duokan.a.a a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : strArr) {
            arrayList.add("book_id");
            arrayList.add(obj);
        }
        if (z) {
            a = a(true, b() + "/store/v0/payment/book/hide", (String[]) arrayList.toArray(new String[0]));
        } else {
            a = a(true, b() + "/store/v0/payment/book/reveal", (String[]) arrayList.toArray(new String[0]));
        }
        JSONObject a2 = a(a(a), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a2.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b c(long j) {
        JSONObject a = a(a(a(true, b() + "/store/v0/payment/fiction/list", "getScaledTouchSlop", "3", "TaskHandler", String.valueOf(j))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        if (ManagedApp.get().isDebuggable()) {
            com.duokan.core.diagnostic.a.c().c(LogLevel.INFO, Mipay.KEY_ORDER, "list fictions: " + a.toString());
        }
        JSONArray jSONArray = a.getJSONArray("items");
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            long j2;
            int i2;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo = new DkCloudPurchasedFictionInfo();
            dkCloudPurchasedFictionInfo.mTitle = jSONObject.getString("title");
            dkCloudPurchasedFictionInfo.mCoverUri = jSONObject.getString("cover");
            dkCloudPurchasedFictionInfo.mLatest = jSONObject.getString("latest");
            dkCloudPurchasedFictionInfo.mLatestId = jSONObject.getString("latest_id");
            dkCloudPurchasedFictionInfo.mChapterCount = jSONObject.getInt("chapter_count");
            dkCloudPurchasedFictionInfo.mFinish = jSONObject.optBoolean("finish");
            dkCloudPurchasedFictionInfo.mBookUuid = jSONObject.getString("fiction_id");
            Object optString = jSONObject.optString("authors");
            if (TextUtils.isEmpty(optString)) {
                dkCloudPurchasedFictionInfo.mAuthors = new String[0];
            } else {
                dkCloudPurchasedFictionInfo.mAuthors = optString.split("\r*\n+");
            }
            try {
                j2 = jSONObject.getLong("time");
            } catch (Exception e) {
                e.printStackTrace();
                j2 = System.currentTimeMillis() / 1000;
            }
            dkCloudPurchasedFictionInfo.setPurchaseTimeInSeconds(j2);
            if (jSONObject.has("entire") && jSONObject.getBoolean("entire")) {
                dkCloudPurchasedFictionInfo.mEntire = true;
                dkCloudPurchasedFictionInfo.mPaidChapterId = new String[0];
            } else {
                String[] split = jSONObject.getString("paid").split(",");
                LinkedList linkedList2 = new LinkedList();
                for (i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].contains("-")) {
                        String[] split2 = split[i2].split("-");
                        for (int intValue = Integer.valueOf(split2[0]).intValue(); intValue <= Integer.valueOf(split2[1]).intValue(); intValue++) {
                            linkedList2.addLast(String.valueOf(intValue));
                        }
                    } else {
                        linkedList2.addLast(split[i2]);
                    }
                }
                dkCloudPurchasedFictionInfo.mPaidChapterId = (String[]) linkedList2.toArray(new String[0]);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("labels");
            if (optJSONArray == null || optJSONArray.length() < 1) {
                dkCloudPurchasedFictionInfo.mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
            } else {
                ArrayList arrayList = new ArrayList(optJSONArray.length());
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    Object split3 = optJSONArray.getString(i2).split("-->");
                    if (split3.length > 0) {
                        arrayList.add(split3);
                    }
                }
                if (arrayList.size() > 0) {
                    dkCloudPurchasedFictionInfo.mLabels = (String[][]) arrayList.toArray(new String[0][]);
                } else {
                    dkCloudPurchasedFictionInfo.mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
                }
            }
            linkedList.add(dkCloudPurchasedFictionInfo);
        }
        bVar.a = linkedList.toArray(new DkCloudPurchasedFictionInfo[0]);
        return bVar;
    }

    public b b(boolean z, String... strArr) {
        int i;
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : strArr) {
            if (Long.parseLong(str2) < 10000000) {
                arrayList.add("fiction_id");
                arrayList.add(str2);
            } else {
                arrayList2.add("comic_id");
                arrayList2.add(str2);
            }
        }
        String str3 = b() + "/store/v0/payment/fiction/";
        String str22 = b() + "/store/v0/payment/comic/";
        if (z) {
            str22 = str3 + "hide";
            str = str22 + "hide";
        } else {
            str22 = str3 + "reveal";
            str = str22 + "reveal";
        }
        if (arrayList.isEmpty()) {
            jSONObject = null;
        } else {
            jSONObject = a(a(a(true, str22, (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        }
        if (!arrayList2.isEmpty()) {
            jSONObject2 = a(a(a(true, str, (String[]) arrayList2.toArray(new String[0]))), HTTP.UTF_8);
        }
        b bVar = new b();
        int i2 = jSONObject != null ? jSONObject.getInt(Mipay.KEY_RESULT) : 0;
        if (jSONObject2 != null) {
            i = jSONObject2.getInt(Mipay.KEY_RESULT);
        } else {
            i = 0;
        }
        bVar.b = i + i2;
        return bVar;
    }

    public b f(String str, String str2) {
        int i = 0;
        JSONObject a = a(a(a(true, b() + "/drm/v0/fiction/link", "fiction_id", str, "chapter_id", str2)), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (a.has("urls")) {
            JSONArray jSONArray = a.getJSONArray("urls");
            while (i < jSONArray.length()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(jSONArray.getString(i));
                i++;
            }
        }
        if (a.has("url")) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(a.getString("url"));
        }
        bVar.a = new Pair(stringBuilder.toString(), i.b(a, "sha1"));
        return bVar;
    }

    public b b(String str, String... strArr) {
        JSONObject a = a(a(a(true, b() + "/drm/v0/fiction/multi_link", "fiction_id", str, "chapter_id", a(strArr))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        bVar.a = new HashMap();
        if (bVar.b != 0) {
            return bVar;
        }
        JSONArray jSONArray = a.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("showAnimation");
            StringBuilder stringBuilder = new StringBuilder();
            if (jSONObject.has("urls")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("urls");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('\n');
                    }
                    stringBuilder.append(jSONArray2.getString(i2));
                }
            }
            if (jSONObject.has("url")) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(jSONObject.getString("url"));
            }
            ((Map) bVar.a).put(string, new Pair(stringBuilder.toString(), i.b(jSONObject, "sha1")));
        }
        return bVar;
    }

    public b g(String str, String str2) {
        if (!a && str == null) {
            throw new AssertionError();
        } else if (a || str2 != null) {
            String uuid = UUID.randomUUID().toString();
            JSONObject a = a(a(a(true, b() + "/drm/v0/certificate", "order_uuid", str, "book_uuid", str, "book_revision", str2, "magic_id", uuid)), HTTP.UTF_8);
            b bVar = new b();
            bVar.b = a.getInt(Mipay.KEY_RESULT);
            if (bVar.b == 30000) {
                bVar.b = 0;
            }
            int optInt = a.optInt("v", 1);
            String optString = a.optString("cert");
            if (bVar.b != 0) {
                return bVar;
            }
            if (TextUtils.isEmpty(optString)) {
                return bVar;
            }
            bVar.a = new z();
            ((z) bVar.a).a = optInt;
            Object md5Encode;
            Object md5Encode2;
            Object md5Encode3;
            Object md5Encode4;
            Object obj;
            if (optInt == 1) {
                md5Encode = DkfLib.md5Encode(this.g.getBytes(HTTP.UTF_8));
                md5Encode2 = DkfLib.md5Encode(str.getBytes(HTTP.UTF_8));
                md5Encode3 = DkfLib.md5Encode(str.getBytes(HTTP.UTF_8));
                md5Encode4 = DkfLib.md5Encode(uuid.getBytes(HTTP.UTF_8));
                obj = new byte[(((md5Encode.length + md5Encode2.length) + md5Encode3.length) + md5Encode4.length)];
                System.arraycopy(md5Encode, 0, obj, 0, md5Encode.length);
                System.arraycopy(md5Encode2, 0, obj, md5Encode.length, md5Encode2.length);
                System.arraycopy(md5Encode3, 0, obj, md5Encode.length + md5Encode2.length, md5Encode3.length);
                System.arraycopy(md5Encode4, 0, obj, (md5Encode.length + md5Encode2.length) + md5Encode3.length, md5Encode4.length);
                ((z) bVar.a).b = o.a(optString);
                ((z) bVar.a).c = obj;
            } else if (optInt == 2) {
                md5Encode = this.g.getBytes(HTTP.UTF_8);
                md5Encode2 = str.getBytes(HTTP.UTF_8);
                md5Encode3 = str.getBytes(HTTP.UTF_8);
                md5Encode4 = uuid.getBytes(HTTP.UTF_8);
                obj = new byte[((((md5Encode.length + md5Encode2.length) + md5Encode3.length) + md5Encode4.length) + 4)];
                Arrays.fill(obj, (byte) 0);
                System.arraycopy(md5Encode, 0, obj, 0, md5Encode.length);
                System.arraycopy(md5Encode2, 0, obj, md5Encode.length + 1, md5Encode2.length);
                System.arraycopy(md5Encode3, 0, obj, (md5Encode.length + md5Encode2.length) + 2, md5Encode3.length);
                System.arraycopy(md5Encode4, 0, obj, ((md5Encode.length + md5Encode2.length) + md5Encode3.length) + 3, md5Encode4.length);
                md5Encode4 = optString.getBytes(HTTP.UTF_8);
                ((z) bVar.a).b = new byte[(md5Encode4.length + 1)];
                Arrays.fill(((z) bVar.a).b, (byte) 0);
                System.arraycopy(md5Encode4, 0, ((z) bVar.a).b, 0, md5Encode4.length);
                ((z) bVar.a).c = obj;
            } else {
                bVar.a = null;
            }
            return bVar;
        } else {
            throw new AssertionError();
        }
    }

    public b d(long j) {
        JSONObject a = a(a(a(true, b() + "/store/v0/payment/fiction/hide_list", "getScaledTouchSlop", "3", "TaskHandler", String.valueOf(j))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        JSONArray jSONArray = a.getJSONArray("items");
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            long j2;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo = new DkCloudPurchasedFictionInfo();
            dkCloudPurchasedFictionInfo.mTitle = jSONObject.getString("title");
            dkCloudPurchasedFictionInfo.mCoverUri = jSONObject.getString("cover");
            dkCloudPurchasedFictionInfo.mLatest = jSONObject.getString("latest");
            dkCloudPurchasedFictionInfo.mLatestId = jSONObject.getString("latest_id");
            dkCloudPurchasedFictionInfo.mChapterCount = jSONObject.getInt("chapter_count");
            dkCloudPurchasedFictionInfo.mFinish = jSONObject.optBoolean("finish");
            dkCloudPurchasedFictionInfo.mBookUuid = jSONObject.getString("fiction_id");
            Object optString = jSONObject.optString("authors");
            if (TextUtils.isEmpty(optString)) {
                dkCloudPurchasedFictionInfo.mAuthors = new String[0];
            } else {
                dkCloudPurchasedFictionInfo.mAuthors = optString.split("\r*\n+");
            }
            try {
                j2 = jSONObject.getLong("time");
            } catch (Exception e) {
                e.printStackTrace();
                j2 = System.currentTimeMillis() / 1000;
            }
            dkCloudPurchasedFictionInfo.setPurchaseTimeInSeconds(j2);
            JSONArray optJSONArray = jSONObject.optJSONArray("labels");
            if (optJSONArray == null || optJSONArray.length() < 1) {
                dkCloudPurchasedFictionInfo.mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
            } else {
                ArrayList arrayList = new ArrayList(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    Object split = optJSONArray.getString(i2).split("-->");
                    if (split.length > 0) {
                        arrayList.add(split);
                    }
                }
                if (arrayList.size() > 0) {
                    dkCloudPurchasedFictionInfo.mLabels = (String[][]) arrayList.toArray(new String[0][]);
                } else {
                    dkCloudPurchasedFictionInfo.mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
                }
            }
            linkedList.add(dkCloudPurchasedFictionInfo);
        }
        bVar.a = linkedList;
        return bVar;
    }

    public b h(String str, String str2) {
        int i = 0;
        JSONObject a = a(a(a(true, b() + "/drm/v0/comic/link", "comic_id", str, "chapter_id", str2)), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (a.has("urls")) {
            JSONArray jSONArray = a.getJSONArray("urls");
            while (i < jSONArray.length()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(jSONArray.getString(i));
                i++;
            }
        }
        if (a.has("url")) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(a.getString("url"));
        }
        bVar.a = new Pair(stringBuilder.toString(), i.b(a, "sha1"));
        return bVar;
    }

    public b c(String str, String... strArr) {
        JSONObject a = a(a(a(true, b() + "/drm/v0/comic/multi_link", "comic_id", str, "chapter_id", a(strArr))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        bVar.a = new HashMap();
        if (bVar.b != 0) {
            return bVar;
        }
        JSONArray jSONArray = a.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("showAnimation");
            StringBuilder stringBuilder = new StringBuilder();
            if (jSONObject.has("urls")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("urls");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('\n');
                    }
                    stringBuilder.append(jSONArray2.getString(i2));
                }
            }
            if (jSONObject.has("url")) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(jSONObject.getString("url"));
            }
            ((Map) bVar.a).put(string, new Pair(stringBuilder.toString(), i.b(jSONObject, "sha1")));
        }
        return bVar;
    }

    public b e(long j) {
        JSONObject a = a(a(a(true, b() + "/store/v0/payment/comic/list", "getScaledTouchSlop", "3", "TaskHandler", String.valueOf(j))), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        if (ManagedApp.get().isDebuggable()) {
            com.duokan.core.diagnostic.a.c().c(LogLevel.INFO, Mipay.KEY_ORDER, "list fictions: " + a.toString());
        }
        JSONArray jSONArray = a.getJSONArray("items");
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            long j2;
            int i2;
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo = new DkCloudPurchasedFictionInfo();
            dkCloudPurchasedFictionInfo.mTitle = jSONObject.getString("title");
            dkCloudPurchasedFictionInfo.mCoverUri = jSONObject.getString("cover");
            dkCloudPurchasedFictionInfo.mLatest = jSONObject.getString("latest");
            dkCloudPurchasedFictionInfo.mLatestId = jSONObject.getString("latest_id");
            dkCloudPurchasedFictionInfo.mChapterCount = jSONObject.getInt("chapter_count");
            dkCloudPurchasedFictionInfo.mFinish = jSONObject.optBoolean("finish");
            dkCloudPurchasedFictionInfo.mBookUuid = jSONObject.getString("comic_id");
            dkCloudPurchasedFictionInfo.mTypeId = jSONObject.optString("comic_type_id");
            dkCloudPurchasedFictionInfo.mIsHide = jSONObject.getInt("status") == 100;
            Object optString = jSONObject.optString("authors");
            if (TextUtils.isEmpty(optString)) {
                dkCloudPurchasedFictionInfo.mAuthors = new String[0];
            } else {
                dkCloudPurchasedFictionInfo.mAuthors = optString.split("\r*\n+");
            }
            try {
                j2 = jSONObject.getLong("time");
            } catch (Exception e) {
                e.printStackTrace();
                j2 = System.currentTimeMillis() / 1000;
            }
            dkCloudPurchasedFictionInfo.setPurchaseTimeInSeconds(j2);
            if (jSONObject.has("entire") && jSONObject.getBoolean("entire")) {
                dkCloudPurchasedFictionInfo.mEntire = true;
                dkCloudPurchasedFictionInfo.mPaidChapterId = new String[0];
            } else {
                String[] split = jSONObject.getString("paid").split(",");
                LinkedList linkedList2 = new LinkedList();
                for (i2 = 0; i2 < split.length; i2++) {
                    if (split[i2].contains("-")) {
                        String[] split2 = split[i2].split("-");
                        for (int intValue = Integer.valueOf(split2[0]).intValue(); intValue <= Integer.valueOf(split2[1]).intValue(); intValue++) {
                            linkedList2.addLast(String.valueOf(intValue));
                        }
                    } else {
                        linkedList2.addLast(split[i2]);
                    }
                }
                dkCloudPurchasedFictionInfo.mPaidChapterId = (String[]) linkedList2.toArray(new String[0]);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("labels");
            if (optJSONArray == null || optJSONArray.length() < 1) {
                dkCloudPurchasedFictionInfo.mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
            } else {
                ArrayList arrayList = new ArrayList(optJSONArray.length());
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    Object split3 = optJSONArray.getString(i2).split("-->");
                    if (split3.length > 0) {
                        arrayList.add(split3);
                    }
                }
                if (arrayList.size() > 0) {
                    dkCloudPurchasedFictionInfo.mLabels = (String[][]) arrayList.toArray(new String[0][]);
                } else {
                    dkCloudPurchasedFictionInfo.mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
                }
            }
            linkedList.add(dkCloudPurchasedFictionInfo);
        }
        bVar.a = linkedList.toArray(new DkCloudPurchasedFictionInfo[0]);
        return bVar;
    }

    public b i(String str) {
        JSONObject a = a(a(a(true, b() + "/store/v0/payment/comic/chapter/list", "getScaledTouchSlop", "3", "comic_id", str)), HTTP.UTF_8);
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        long j;
        bVar.a = new DkCloudPurchasedFictionInfo();
        ((DkCloudPurchasedFictionInfo) bVar.a).mBookUuid = str;
        try {
            j = a.getLong("time");
        } catch (Exception e) {
            Exception exception = e;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            exception.printStackTrace();
            j = currentTimeMillis;
        }
        ((DkCloudPurchasedFictionInfo) bVar.a).setPurchaseTimeInSeconds(j);
        if (a.has("entire") && a.getBoolean("entire")) {
            ((DkCloudPurchasedFictionInfo) bVar.a).mEntire = true;
            ((DkCloudPurchasedFictionInfo) bVar.a).mPaidChapterId = new String[0];
        } else {
            Object string = a.getString("items");
            LinkedList linkedList = new LinkedList();
            if (!TextUtils.equals(string, "[]")) {
                String[] split = string.split(",");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].contains("-")) {
                        String[] split2 = split[i].split("-");
                        for (int intValue = Integer.valueOf(split2[0]).intValue(); intValue <= Integer.valueOf(split2[1]).intValue(); intValue++) {
                            linkedList.addLast(String.valueOf(intValue));
                        }
                    } else if (split[i].matches("[0-9]*")) {
                        linkedList.addLast(split[i]);
                    }
                }
            }
            ((DkCloudPurchasedFictionInfo) bVar.a).mPaidChapterId = (String[]) linkedList.toArray(new String[0]);
        }
        return bVar;
    }

    public b i(String str, String str2) {
        if (a || str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("payment_name");
            arrayList.add(p.i().k() ? "BC" : "BC_SANDBOX");
            arrayList.add("comic_id");
            arrayList.add(str);
            arrayList.add("chapter_id");
            arrayList.add(str2);
            arrayList.add("ch");
            arrayList.add(ReaderEnv.get().getDistChannel());
            arrayList.add("auto");
            arrayList.add("1");
            JSONObject jSONObject = new JSONObject(b(a(a(true, b() + "/store/v0/payment/comic/create", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8));
            b bVar = new b();
            bVar.b = jSONObject.getInt(Mipay.KEY_RESULT);
            bVar.c = jSONObject.optString("msg");
            switch (bVar.b) {
                case 10012:
                case 10013:
                case 10019:
                    bVar.b = 0;
                    break;
            }
            if (bVar.b != 0) {
                return bVar;
            }
            bVar.a = new DkStoreOrderInfo();
            ((DkStoreOrderInfo) bVar.a).mPaymentMothodName = "BC";
            ((DkStoreOrderInfo) bVar.a).mBookUuid = str;
            ((DkStoreOrderInfo) bVar.a).mOrderStatus = DkStoreOrderStatus.UNPAID;
            ((DkStoreOrderInfo) bVar.a).mPrice = (int) Math.round(jSONObject.optDouble("price", 0.0d) * 100.0d);
            ((DkStoreOrderInfo) bVar.a).mOrderUuid = jSONObject.optString("trans_id");
            ((DkStoreOrderInfo) bVar.a).mPaymentEnvelop = URLDecoder.decode(jSONObject.optString("payment_envelope"));
            ((DkStoreOrderInfo) bVar.a).mPaymentId = URLDecoder.decode(jSONObject.optString("payment_id"));
            ((DkStoreOrderInfo) bVar.a).mPaymentSenderSign = URLDecoder.decode(jSONObject.optString("payment_sender_sign"));
            return bVar;
        }
        throw new AssertionError();
    }

    protected String b() {
        return p.i().p();
    }
}
