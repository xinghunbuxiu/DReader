package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.android.client.Aes;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.C0366o;
import com.duokan.kernel.filterlib.DkfLib;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.payment.C1089s;
import com.mipay.sdk.Mipay;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.z */
public class C0652z extends ac {
    /* renamed from: a */
    static final /* synthetic */ boolean f2188a = (!C0652z.class.desiredAssertionStatus());
    /* renamed from: g */
    private final String f2189g;
    /* renamed from: h */
    private final String f2190h;

    public C0652z(WebSession webSession, C0672a c0672a) {
        super(webSession, c0672a);
        if (c0672a == null) {
            this.f2189g = "";
            this.f2190h = "";
            return;
        }
        this.f2189g = TextUtils.isEmpty(c0672a.mo833c()) ? "" : c0672a.mo833c();
        this.f2190h = c0672a.mo833c();
    }

    public C0652z(WebSession webSession, al alVar) {
        super(webSession, alVar);
        if (alVar == null) {
            this.f2189g = "";
            this.f2190h = "";
            return;
        }
        this.f2189g = TextUtils.isEmpty(alVar.f2362c) ? "" : alVar.f2362c;
        this.f2190h = alVar.f2364e;
    }

    /* renamed from: a */
    public C0621a<Pair<String, String>> m3058a(String str, String str2) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return m3076f(str, str2);
        }
        return m3080h(str, str2);
    }

    /* renamed from: a */
    public C0621a<Map<String, Pair<String, String>>> m3061a(String str, String... strArr) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return m3065b(str, strArr);
        }
        return m3070c(str, strArr);
    }

    /* renamed from: a */
    public C0621a<DkCloudPurchasedFictionInfo[]> m3054a(long j) {
        C0621a<DkCloudPurchasedFictionInfo[]> c0621a = new C0621a();
        C0621a<DkCloudPurchasedFictionInfo[]> c = m3068c(j);
        if (c.b != 0) {
            c0621a.f2058a = new DkCloudPurchasedFictionInfo[0];
            c0621a.b = c.b;
            c0621a.c = c.c;
            return c;
        }
        C0621a<DkCloudPurchasedFictionInfo[]> e = m3073e(j);
        if (e.b != 0) {
            c0621a.f2058a = new DkCloudPurchasedFictionInfo[0];
            c0621a.b = e.b;
            c0621a.c = e.c;
            return e;
        }
        c0621a.f2058a = new DkCloudPurchasedFictionInfo[(((DkCloudPurchasedFictionInfo[]) e.f2058a).length + ((DkCloudPurchasedFictionInfo[]) c.f2058a).length)];
        for (int i = 0; i < ((DkCloudPurchasedFictionInfo[]) c0621a.f2058a).length; i++) {
            if (i < ((DkCloudPurchasedFictionInfo[]) c.f2058a).length) {
                ((DkCloudPurchasedFictionInfo[]) c0621a.f2058a)[i] = ((DkCloudPurchasedFictionInfo[]) c.f2058a)[i];
            } else {
                ((DkCloudPurchasedFictionInfo[]) c0621a.f2058a)[i] = ((DkCloudPurchasedFictionInfo[]) e.f2058a)[i - ((DkCloudPurchasedFictionInfo[]) c.f2058a).length];
            }
        }
        c0621a.b = 0;
        c0621a.c = "";
        return c0621a;
    }

    /* renamed from: e */
    public C0621a<DkCloudPurchasedFictionInfo> m3074e(String str) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return m3079h(str);
        }
        return m3081i(str);
    }

    /* renamed from: b */
    public C0621a<DkStoreOrderInfo> m3064b(String str, String str2) {
        if (((long) Integer.valueOf(str).intValue()) < 10000000) {
            return m3075e(str, str2);
        }
        return m3082i(str, str2);
    }

    /* renamed from: a */
    public static String m3048a(String... strArr) {
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

    /* renamed from: f */
    public static String[] m3050f(String str) {
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

    /* renamed from: a */
    public C0621a<JSONObject> m3052a() {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/time_limited/get", new String[0])), HTTP.UTF_8);
        C0621a<JSONObject> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = C0611i.m2786a(a, "msg", "");
        if (c0621a.b == 0) {
            c0621a.f2058a = a;
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<C0651y> m3060a(String str, String str2, String str3) {
        if (!f2188a && str == null) {
            throw new AssertionError();
        } else if (f2188a || str2 != null) {
            JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/drm/v0/time_certificate", "local_time", "" + ("" + (System.currentTimeMillis() / 1000)), "book_uuid", str, "book_revision", str2, "magic_id", str3)), HTTP.UTF_8);
            C0621a<C0651y> c0621a = new C0621a();
            c0621a.b = a.getInt(Mipay.KEY_RESULT);
            c0621a.c = a.optString(Mipay.KEY_MESSAGE, "");
            if (c0621a.b != 0) {
                return c0621a;
            }
            String string = a.getString("cert");
            if (TextUtils.isEmpty(string)) {
                return c0621a;
            }
            c0621a.f2058a = new C0651y();
            ((C0651y) c0621a.f2058a).f2183a = 100;
            Object bytes = this.f2189g.getBytes(HTTP.UTF_8);
            Object bytes2 = r1.getBytes(HTTP.UTF_8);
            Object bytes3 = str.getBytes(HTTP.UTF_8);
            Object bytes4 = str3.getBytes(HTTP.UTF_8);
            Object obj = new byte[((((bytes.length + bytes2.length) + bytes3.length) + bytes4.length) + 4)];
            Arrays.fill(obj, (byte) 0);
            System.arraycopy(bytes, 0, obj, 0, bytes.length);
            System.arraycopy(bytes2, 0, obj, bytes.length + 1, bytes2.length);
            System.arraycopy(bytes3, 0, obj, (bytes.length + bytes2.length) + 2, bytes3.length);
            System.arraycopy(bytes4, 0, obj, ((bytes.length + bytes2.length) + bytes3.length) + 3, bytes4.length);
            ((C0651y) c0621a.f2058a).f2184b = C0366o.m1033a(string);
            ((C0651y) c0621a.f2058a).f2185c = obj;
            ((C0651y) c0621a.f2058a).f2186d = a.getLong("limited_time") * 1000;
            ((C0651y) c0621a.f2058a).f2187e = a.optInt("allow_free_read", 1) == 1;
            return c0621a;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public C0621a<JSONObject> m3056a(String str, int i) {
        JSONObject a = m547a(mo376a(m562b(true, C0641o.m2934i().m2998y() + "/hs/v2/payment/info", "book_id", str, "price", String.valueOf(i))));
        C0621a<JSONObject> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = a;
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<JSONObject> m3059a(String str, String str2, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("fiction_id");
        arrayList.add(str);
        arrayList.add("chapter_id");
        arrayList.add(str2);
        arrayList.add("pos");
        arrayList.add("" + i);
        arrayList.add("price");
        arrayList.add("" + i2);
        JSONObject a = m547a(mo376a(m562b(true, C0641o.m2934i().m2998y() + "/hs/v2/payment/info", (String[]) arrayList.toArray(new String[0]))));
        C0621a<JSONObject> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = a;
        }
        return c0621a;
    }

    /* renamed from: c */
    public C0621a<DkStoreOrderInfo> m3069c(String str, String str2) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/redeem/single/create", "book_uuid", str2, "payment_name", str, "ch", ReaderEnv.get().getDistChannel())), HTTP.UTF_8);
        C0621a<DkStoreOrderInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.f2058a = new DkStoreOrderInfo();
        c0621a.c = C0611i.m2793b(a, "words");
        ((DkStoreOrderInfo) c0621a.f2058a).mPaymentMothodName = str;
        ((DkStoreOrderInfo) c0621a.f2058a).mOrderUuid = a.getString("trans_id");
        ((DkStoreOrderInfo) c0621a.f2058a).mBookUuid = a.getString("link");
        ((DkStoreOrderInfo) c0621a.f2058a).mPrice = (int) Math.round(a.optDouble("price", 0.0d) * 100.0d);
        ((DkStoreOrderInfo) c0621a.f2058a).mPaymentEnvelop = URLDecoder.decode(a.optString("payment_envelope"));
        ((DkStoreOrderInfo) c0621a.f2058a).mPaymentId = URLDecoder.decode(a.optString("payment_id"));
        ((DkStoreOrderInfo) c0621a.f2058a).mPaymentSenderSign = URLDecoder.decode(a.optString("payment_sender_sign"));
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<DkStoreRedeemFundInfo[]> m3053a(int i, int i2, Boolean bool) {
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
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/redeem/single/list", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<DkStoreRedeemFundInfo[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.c = a.getString("more");
        JSONArray jSONArray = a.getJSONArray("items");
        c0621a.f2058a = new DkStoreRedeemFundInfo[jSONArray.length()];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (i3 < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3] = new DkStoreRedeemFundInfo();
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mLinkUrl = jSONObject.getString("link");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mStatus = jSONObject.getInt("status");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mBookUuid = jSONObject.getString("book_uuid");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mBookTitle = jSONObject.getString("book_title");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mBookCover = jSONObject.getString("book_cover");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mAuthor = C0611i.m2793b(jSONObject, "book_authors");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mEditor = C0611i.m2793b(jSONObject, "book_editors");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mReceiverId = C0611i.m2793b(jSONObject, "to");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mNickName = C0611i.m2793b(jSONObject, "to_nick");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mIconUrl = C0611i.m2793b(jSONObject, "to_icon");
            ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mWords = jSONObject.optString("words");
            try {
                ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mWordUpdatedTime = simpleDateFormat.parse(jSONObject.getString("words_time"));
            } catch (Exception e) {
                e.printStackTrace();
                ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mWordUpdatedTime = new Date();
            }
            try {
                ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mStatusUpdatedTime = simpleDateFormat.parse(jSONObject.getString("status_time"));
            } catch (Exception e2) {
                e2.printStackTrace();
                ((DkStoreRedeemFundInfo[]) c0621a.f2058a)[i3].mStatusUpdatedTime = new Date();
            }
            i3++;
        }
        return c0621a;
    }

    /* renamed from: d */
    public C0621a<Void> m3072d(String str, String str2) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/redeem/single/update_message", "link", str, "words", str2)), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        return c0621a;
    }

    /* renamed from: g */
    public C0621a<DkStoreRedeemBenefitInfo> m3077g(String str) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/redeem/single/get_message", "book_id", str)), HTTP.UTF_8);
        C0621a<DkStoreRedeemBenefitInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.f2058a = new DkStoreRedeemBenefitInfo();
        ((DkStoreRedeemBenefitInfo) c0621a.f2058a).mOrderUuid = a.getString("order_id");
        ((DkStoreRedeemBenefitInfo) c0621a.f2058a).mFromUuid = a.getString("from");
        ((DkStoreRedeemBenefitInfo) c0621a.f2058a).mMessage = a.getString(Mipay.KEY_MESSAGE);
        try {
            ((DkStoreRedeemBenefitInfo) c0621a.f2058a).mTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(a.getString("time"));
        } catch (Exception e) {
            e.printStackTrace();
            ((DkStoreRedeemBenefitInfo) c0621a.f2058a).mTime = new Date();
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Void> m3057a(String str, C1089s c1089s, String str2) {
        if (TextUtils.isEmpty(str)) {
            return m3055a(c1089s, str2);
        }
        return m3049c(m555a(true, str, "receipt", str2, "query", c1089s.mo1502b()));
    }

    /* renamed from: a */
    public C0621a<Void> m3055a(C1089s c1089s, String str) {
        if (!f2188a && str == null) {
            throw new AssertionError();
        } else if (TextUtils.equals(c1089s.mo1504d(), "ALIPAY_MOBILE")) {
            JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/payment/alipay_mobile_return", new String[0]).m2838c().m2855a(str.getBytes(HTTP.UTF_8)).m2851a()), HTTP.UTF_8);
            C0621a<Void> c0621a = new C0621a();
            c0621a.b = a.getInt(Mipay.KEY_RESULT);
            return c0621a;
        } else if (TextUtils.equals(c1089s.mo1504d(), "WXPAY")) {
            return m3049c(m555a(true, m3067b() + "/store/v0/payment/wxpay_return", "query", c1089s.mo1502b()));
        } else {
            return m3049c(m555a(true, m3067b() + "/store/v0/payment/mipay_return", "receipt", str, "en_query", m3051l(c1089s.mo1502b())));
        }
    }

    /* renamed from: c */
    private C0621a<Void> m3049c(C0624a c0624a) {
        JSONObject a = m548a(mo376a(c0624a), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: l */
    private String m3051l(String str) {
        String str2 = "wNTzqnGwKXs7n5HjylipCt-R5GUWxhBA";
        str2 = null;
        try {
            str2 = Base64.encodeToString(Aes.encrypt(str, "wNTzqnGwKXs7n5HjylipCt-R5GUWxhBA", "\u0000"), 2).replace("+", "-").replace("/", "_").replace("=", ".");
        } catch (Throwable th) {
        }
        return str2;
    }

    /* renamed from: e */
    public C0621a<DkStoreOrderInfo> m3075e(String str, String str2) {
        if (f2188a || str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("payment_name");
            arrayList.add(C0641o.m2934i().m2984k() ? "BC" : "BC_SANDBOX");
            arrayList.add("fiction_id");
            arrayList.add(str);
            arrayList.add("chapter_id");
            arrayList.add(str2);
            arrayList.add("ch");
            arrayList.add(ReaderEnv.get().getDistChannel());
            arrayList.add("auto");
            arrayList.add("1");
            JSONObject jSONObject = new JSONObject(m550b(mo376a(m555a(true, m3067b() + "/store/v0/payment/fiction/create", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8));
            C0621a<DkStoreOrderInfo> c0621a = new C0621a();
            c0621a.b = jSONObject.getInt(Mipay.KEY_RESULT);
            c0621a.c = jSONObject.optString("msg");
            switch (c0621a.b) {
                case 10012:
                case 10013:
                case 10019:
                    c0621a.b = 0;
                    break;
            }
            if (c0621a.b != 0) {
                return c0621a;
            }
            c0621a.f2058a = new DkStoreOrderInfo();
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentMothodName = "BC";
            ((DkStoreOrderInfo) c0621a.f2058a).mBookUuid = str;
            ((DkStoreOrderInfo) c0621a.f2058a).mOrderStatus = DkStoreOrderStatus.UNPAID;
            ((DkStoreOrderInfo) c0621a.f2058a).mPrice = (int) Math.round(jSONObject.optDouble("price", 0.0d) * 100.0d);
            ((DkStoreOrderInfo) c0621a.f2058a).mOrderUuid = jSONObject.optString("trans_id");
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentEnvelop = URLDecoder.decode(jSONObject.optString("payment_envelope"));
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentId = URLDecoder.decode(jSONObject.optString("payment_id"));
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentSenderSign = URLDecoder.decode(jSONObject.optString("payment_sender_sign"));
            return c0621a;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public C0621a<DkCloudPurchasedBookInfo[]> m3063b(long j) {
        JSONObject a = m547a(mo376a(m555a(true, m3067b() + "/store/v0/payment/book/list2", "st", String.valueOf(j))));
        C0621a<DkCloudPurchasedBookInfo[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        if (a.has("items")) {
            String valueOf;
            JSONArray jSONArray = a.getJSONArray("items");
            if (jSONArray.length() > 0) {
                valueOf = String.valueOf(Boolean.TRUE);
            } else {
                valueOf = String.valueOf(Boolean.FALSE);
            }
            c0621a.c = valueOf;
            c0621a.f2058a = new DkCloudPurchasedBookInfo[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                long j2;
                boolean z;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i] = new DkCloudPurchasedBookInfo();
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mOrderUuid = jSONObject.getString("order_id");
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mTitle = jSONObject.getString("title");
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mCoverUri = jSONObject.getString("cover");
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mAuthors = jSONObject.getString("authors").split("\r*\n+");
                Object optString = jSONObject.optString("editors");
                if (TextUtils.isEmpty(optString)) {
                    ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mEditors = new String[0];
                } else {
                    ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mEditors = optString.split("\r*\n+");
                }
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mBookUuid = jSONObject.getString("book_id");
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mAd = jSONObject.optInt("ad", 0) == 1;
                try {
                    j2 = jSONObject.getLong("time");
                } catch (Exception e) {
                    j2 = System.currentTimeMillis() / 1000;
                }
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].setPurchaseTimeInSeconds(j2);
                try {
                    j2 = jSONObject.getLong("update_time");
                } catch (Exception e2) {
                    j2 = System.currentTimeMillis() / 1000;
                }
                ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mUpdateTime = j2;
                JSONArray optJSONArray = jSONObject.optJSONArray("labels");
                if (optJSONArray == null || optJSONArray.length() < 1) {
                    ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
                } else {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        Object split = optJSONArray.getString(i2).split("-->");
                        if (split.length > 0) {
                            arrayList.add(split);
                        }
                    }
                    if (arrayList.size() > 0) {
                        ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mLabels = (String[][]) arrayList.toArray(new String[0][]);
                    } else {
                        ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mLabels = (String[][]) Array.newInstance(String.class, new int[]{0, 0});
                    }
                }
                try {
                    optString = C0611i.m2793b(jSONObject, "type");
                    ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mType = TextUtils.isEmpty(optString) ? DkStoreBookSourceType.NORMAL : DkStoreBookSourceType.valueOf(optString.toUpperCase());
                } catch (Exception e3) {
                    e3.printStackTrace();
                    ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i].mType = DkStoreBookSourceType.NORMAL;
                }
                DkCloudPurchasedBookInfo dkCloudPurchasedBookInfo = ((DkCloudPurchasedBookInfo[]) c0621a.f2058a)[i];
                if (jSONObject.getInt("status") == 100) {
                    z = true;
                } else {
                    z = false;
                }
                dkCloudPurchasedBookInfo.mIsHide = z;
            }
        } else {
            c0621a.f2058a = new DkCloudPurchasedBookInfo[0];
            c0621a.c = String.valueOf(Boolean.FALSE);
        }
        return c0621a;
    }

    /* renamed from: h */
    public C0621a<DkCloudPurchasedFictionInfo> m3079h(String str) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/payment/fiction/chapter/list", "d", "3", "fiction_id", str)), HTTP.UTF_8);
        C0621a<DkCloudPurchasedFictionInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        long j;
        c0621a.f2058a = new DkCloudPurchasedFictionInfo();
        ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mBookUuid = str;
        try {
            j = a.getLong("time");
        } catch (Exception e) {
            Exception exception = e;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            exception.printStackTrace();
            j = currentTimeMillis;
        }
        ((DkCloudPurchasedFictionInfo) c0621a.f2058a).setPurchaseTimeInSeconds(j);
        if (a.has("entire") && a.getBoolean("entire")) {
            ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mEntire = true;
            ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mPaidChapterId = new String[0];
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
            ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mPaidChapterId = (String[]) linkedList.toArray(new String[0]);
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Void> m3062a(boolean z, String... strArr) {
        C0624a a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : strArr) {
            arrayList.add("book_id");
            arrayList.add(obj);
        }
        if (z) {
            a = m555a(true, m3067b() + "/store/v0/payment/book/hide", (String[]) arrayList.toArray(new String[0]));
        } else {
            a = m555a(true, m3067b() + "/store/v0/payment/book/reveal", (String[]) arrayList.toArray(new String[0]));
        }
        JSONObject a2 = m548a(mo376a(a), HTTP.UTF_8);
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a2.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: c */
    public C0621a<DkCloudPurchasedFictionInfo[]> m3068c(long j) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/payment/fiction/list", "d", "3", "t", String.valueOf(j))), HTTP.UTF_8);
        C0621a<DkCloudPurchasedFictionInfo[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        if (ManagedApp.get().isDebuggable()) {
            WebLog.init().c(LogLevel.INFO, Mipay.KEY_ORDER, "list fictions: " + a.toString());
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
        c0621a.f2058a = linkedList.toArray(new DkCloudPurchasedFictionInfo[0]);
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<Void> m3066b(boolean z, String... strArr) {
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
        String str3 = m3067b() + "/store/v0/payment/fiction/";
        String str22 = m3067b() + "/store/v0/payment/comic/";
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
            jSONObject = m548a(mo376a(m555a(true, str22, (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        }
        if (!arrayList2.isEmpty()) {
            jSONObject2 = m548a(mo376a(m555a(true, str, (String[]) arrayList2.toArray(new String[0]))), HTTP.UTF_8);
        }
        C0621a<Void> c0621a = new C0621a();
        int i2 = jSONObject != null ? jSONObject.getInt(Mipay.KEY_RESULT) : 0;
        if (jSONObject2 != null) {
            i = jSONObject2.getInt(Mipay.KEY_RESULT);
        } else {
            i = 0;
        }
        c0621a.b = i + i2;
        return c0621a;
    }

    /* renamed from: f */
    public C0621a<Pair<String, String>> m3076f(String str, String str2) {
        int i = 0;
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/drm/v0/fiction/link", "fiction_id", str, "chapter_id", str2)), HTTP.UTF_8);
        C0621a<Pair<String, String>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
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
        c0621a.f2058a = new Pair(stringBuilder.toString(), C0611i.m2793b(a, "sha1"));
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<Map<String, Pair<String, String>>> m3065b(String str, String... strArr) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/drm/v0/fiction/multi_link", "fiction_id", str, "chapter_id", C0652z.m3048a(strArr))), HTTP.UTF_8);
        C0621a<Map<String, Pair<String, String>>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        c0621a.f2058a = new HashMap();
        if (c0621a.b != 0) {
            return c0621a;
        }
        JSONArray jSONArray = a.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("c");
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
            ((Map) c0621a.f2058a).put(string, new Pair(stringBuilder.toString(), C0611i.m2793b(jSONObject, "sha1")));
        }
        return c0621a;
    }

    /* renamed from: g */
    public C0621a<C0651y> m3078g(String str, String str2) {
        if (!f2188a && str == null) {
            throw new AssertionError();
        } else if (f2188a || str2 != null) {
            String uuid = UUID.randomUUID().toString();
            JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/drm/v0/certificate", "order_uuid", str, "book_uuid", str, "book_revision", str2, "magic_id", uuid)), HTTP.UTF_8);
            C0621a<C0651y> c0621a = new C0621a();
            c0621a.b = a.getInt(Mipay.KEY_RESULT);
            if (c0621a.b == 30000) {
                c0621a.b = 0;
            }
            int optInt = a.optInt("v", 1);
            String optString = a.optString("cert");
            if (c0621a.b != 0) {
                return c0621a;
            }
            if (TextUtils.isEmpty(optString)) {
                return c0621a;
            }
            c0621a.f2058a = new C0651y();
            ((C0651y) c0621a.f2058a).f2183a = optInt;
            Object md5Encode;
            Object md5Encode2;
            Object md5Encode3;
            Object md5Encode4;
            Object obj;
            if (optInt == 1) {
                md5Encode = DkfLib.md5Encode(this.f2189g.getBytes(HTTP.UTF_8));
                md5Encode2 = DkfLib.md5Encode(str.getBytes(HTTP.UTF_8));
                md5Encode3 = DkfLib.md5Encode(str.getBytes(HTTP.UTF_8));
                md5Encode4 = DkfLib.md5Encode(uuid.getBytes(HTTP.UTF_8));
                obj = new byte[(((md5Encode.length + md5Encode2.length) + md5Encode3.length) + md5Encode4.length)];
                System.arraycopy(md5Encode, 0, obj, 0, md5Encode.length);
                System.arraycopy(md5Encode2, 0, obj, md5Encode.length, md5Encode2.length);
                System.arraycopy(md5Encode3, 0, obj, md5Encode.length + md5Encode2.length, md5Encode3.length);
                System.arraycopy(md5Encode4, 0, obj, (md5Encode.length + md5Encode2.length) + md5Encode3.length, md5Encode4.length);
                ((C0651y) c0621a.f2058a).f2184b = C0366o.m1033a(optString);
                ((C0651y) c0621a.f2058a).f2185c = obj;
            } else if (optInt == 2) {
                md5Encode = this.f2189g.getBytes(HTTP.UTF_8);
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
                ((C0651y) c0621a.f2058a).f2184b = new byte[(md5Encode4.length + 1)];
                Arrays.fill(((C0651y) c0621a.f2058a).f2184b, (byte) 0);
                System.arraycopy(md5Encode4, 0, ((C0651y) c0621a.f2058a).f2184b, 0, md5Encode4.length);
                ((C0651y) c0621a.f2058a).f2185c = obj;
            } else {
                c0621a.f2058a = null;
            }
            return c0621a;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    public C0621a<List<DkCloudPurchasedFictionInfo>> m3071d(long j) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/payment/fiction/hide_list", "d", "3", "t", String.valueOf(j))), HTTP.UTF_8);
        C0621a<List<DkCloudPurchasedFictionInfo>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
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
        c0621a.f2058a = linkedList;
        return c0621a;
    }

    /* renamed from: h */
    public C0621a<Pair<String, String>> m3080h(String str, String str2) {
        int i = 0;
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/drm/v0/comic/link", "comic_id", str, "chapter_id", str2)), HTTP.UTF_8);
        C0621a<Pair<String, String>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
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
        c0621a.f2058a = new Pair(stringBuilder.toString(), C0611i.m2793b(a, "sha1"));
        return c0621a;
    }

    /* renamed from: c */
    public C0621a<Map<String, Pair<String, String>>> m3070c(String str, String... strArr) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/drm/v0/comic/multi_link", "comic_id", str, "chapter_id", C0652z.m3048a(strArr))), HTTP.UTF_8);
        C0621a<Map<String, Pair<String, String>>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        c0621a.f2058a = new HashMap();
        if (c0621a.b != 0) {
            return c0621a;
        }
        JSONArray jSONArray = a.getJSONArray("data");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("c");
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
            ((Map) c0621a.f2058a).put(string, new Pair(stringBuilder.toString(), C0611i.m2793b(jSONObject, "sha1")));
        }
        return c0621a;
    }

    /* renamed from: e */
    public C0621a<DkCloudPurchasedFictionInfo[]> m3073e(long j) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/payment/comic/list", "d", "3", "t", String.valueOf(j))), HTTP.UTF_8);
        C0621a<DkCloudPurchasedFictionInfo[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        if (ManagedApp.get().isDebuggable()) {
            WebLog.init().c(LogLevel.INFO, Mipay.KEY_ORDER, "list fictions: " + a.toString());
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
        c0621a.f2058a = linkedList.toArray(new DkCloudPurchasedFictionInfo[0]);
        return c0621a;
    }

    /* renamed from: i */
    public C0621a<DkCloudPurchasedFictionInfo> m3081i(String str) {
        JSONObject a = m548a(mo376a(m555a(true, m3067b() + "/store/v0/payment/comic/chapter/list", "d", "3", "comic_id", str)), HTTP.UTF_8);
        C0621a<DkCloudPurchasedFictionInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        long j;
        c0621a.f2058a = new DkCloudPurchasedFictionInfo();
        ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mBookUuid = str;
        try {
            j = a.getLong("time");
        } catch (Exception e) {
            Exception exception = e;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            exception.printStackTrace();
            j = currentTimeMillis;
        }
        ((DkCloudPurchasedFictionInfo) c0621a.f2058a).setPurchaseTimeInSeconds(j);
        if (a.has("entire") && a.getBoolean("entire")) {
            ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mEntire = true;
            ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mPaidChapterId = new String[0];
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
            ((DkCloudPurchasedFictionInfo) c0621a.f2058a).mPaidChapterId = (String[]) linkedList.toArray(new String[0]);
        }
        return c0621a;
    }

    /* renamed from: i */
    public C0621a<DkStoreOrderInfo> m3082i(String str, String str2) {
        if (f2188a || str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("payment_name");
            arrayList.add(C0641o.m2934i().m2984k() ? "BC" : "BC_SANDBOX");
            arrayList.add("comic_id");
            arrayList.add(str);
            arrayList.add("chapter_id");
            arrayList.add(str2);
            arrayList.add("ch");
            arrayList.add(ReaderEnv.get().getDistChannel());
            arrayList.add("auto");
            arrayList.add("1");
            JSONObject jSONObject = new JSONObject(m550b(mo376a(m555a(true, m3067b() + "/store/v0/payment/comic/create", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8));
            C0621a<DkStoreOrderInfo> c0621a = new C0621a();
            c0621a.b = jSONObject.getInt(Mipay.KEY_RESULT);
            c0621a.c = jSONObject.optString("msg");
            switch (c0621a.b) {
                case 10012:
                case 10013:
                case 10019:
                    c0621a.b = 0;
                    break;
            }
            if (c0621a.b != 0) {
                return c0621a;
            }
            c0621a.f2058a = new DkStoreOrderInfo();
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentMothodName = "BC";
            ((DkStoreOrderInfo) c0621a.f2058a).mBookUuid = str;
            ((DkStoreOrderInfo) c0621a.f2058a).mOrderStatus = DkStoreOrderStatus.UNPAID;
            ((DkStoreOrderInfo) c0621a.f2058a).mPrice = (int) Math.round(jSONObject.optDouble("price", 0.0d) * 100.0d);
            ((DkStoreOrderInfo) c0621a.f2058a).mOrderUuid = jSONObject.optString("trans_id");
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentEnvelop = URLDecoder.decode(jSONObject.optString("payment_envelope"));
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentId = URLDecoder.decode(jSONObject.optString("payment_id"));
            ((DkStoreOrderInfo) c0621a.f2058a).mPaymentSenderSign = URLDecoder.decode(jSONObject.optString("payment_sender_sign"));
            return c0621a;
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    public C0621a<JSONObject> m3083j(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("trans_id");
        arrayList.add(str);
        JSONObject jSONObject = new JSONObject(m550b(mo376a(m555a(true, m3067b() + "/store/v0/payment/tts/list", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8));
        C0621a<JSONObject> c0621a = new C0621a();
        c0621a.b = jSONObject.getInt(Mipay.KEY_RESULT);
        c0621a.c = jSONObject.optString("msg");
        if (c0621a.b == 0) {
            c0621a.f2058a = jSONObject.optJSONObject("items");
        }
        return c0621a;
    }

    /* renamed from: b */
    protected String m3067b() {
        return C0641o.m2934i().m2989p();
    }
}
