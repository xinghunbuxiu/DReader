package com.duokan.reader.common.webservices.duokan;

import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkShareBook;
import com.mipay.sdk.Mipay;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.u */
public class C0647u extends ac {
    /* renamed from: a */
    static final /* synthetic */ boolean f2178a = (!C0647u.class.desiredAssertionStatus());

    public C0647u(WebSession webSession, C0672a c0672a) {
        super(webSession, c0672a);
    }

    /* renamed from: a */
    public C0627d mo376a(C0624a c0624a) {
        c0624a.m2835a("Accept-Charset", "utf-8");
        return super.mo376a(c0624a);
    }

    /* renamed from: a */
    public C0621a<DkStoreBookDetailInfo> m3033a(String str, boolean z) {
        return m3034a(str, z, null);
    }

    /* renamed from: a */
    public C0621a<DkStoreBookDetailInfo> m3034a(String str, boolean z, String str2) {
        String str3 = m3010a() + "/" + ReaderEnv.get().getAppIdforStore() + "/book/" + str;
        String[] strArr = new String[2];
        strArr[0] = "toc";
        strArr[1] = "" + (z ? 1 : 0);
        C0624a b = m562b(false, str3, strArr);
        m559a(b, str2);
        C0627d a = mo376a(b);
        C0621a<DkStoreBookDetailInfo> c0621a = new C0621a();
        if (a.mo812a() == HttpStatus.SC_NOT_FOUND) {
            c0621a.b = 1;
        } else {
            JSONObject a2 = m548a(a, HTTP.UTF_8);
            c0621a.b = a2.getInt(Mipay.KEY_RESULT);
            if (c0621a.b == 0) {
                c0621a.f2058a = C0647u.m3015c(a2);
            }
        }
        return c0621a;
    }

    /* renamed from: e */
    public C0621a<DkShareBook> m3040e(String str) {
        JSONObject a = m548a(mo376a(m562b(true, m3010a() + "/lib/book/" + str, new String[0])), HTTP.UTF_8);
        C0621a<DkShareBook> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = m3017d(a.getJSONObject("item"));
        }
        return c0621a;
    }

    /* renamed from: f */
    public C0621a<String[]> m3041f(String str) {
        JSONObject a = m548a(mo376a(m562b(false, m3010a() + "/android/query/hint", "s", Uri.encode(str), "b", "1", "f", "1", "owner", "1")), HTTP.UTF_8);
        C0621a<String[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        JSONArray jSONArray = a.getJSONArray("items");
        c0621a.f2058a = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            ((String[]) c0621a.f2058a)[i] = jSONArray.getString(i);
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<DkStoreAbsBookInfo[]> m3032a(String str, int i, int i2) {
        JSONObject a = m548a(mo376a(m562b(false, m3010a() + "/lib/query", "s", Uri.encode(str), "start", String.valueOf(i), "count", String.valueOf(i2))), HTTP.UTF_8);
        C0621a<DkStoreAbsBookInfo[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b == 0) {
            c0621a.f2058a = m3012a(a.getJSONArray("items"));
        }
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<C0646t[]> m3039b(String str, int i, int i2) {
        JSONObject a = m548a(mo376a(m562b(false, m3010a() + "/" + ReaderEnv.get().getAppIdforStore() + "/book/" + str + "/change_log", "start", "" + i, "page_length", "" + i2)), HTTP.UTF_8);
        C0621a<C0646t[]> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.c = Integer.toString(a.getInt("total"));
        JSONArray jSONArray = a.getJSONArray("items");
        c0621a.f2058a = new C0646t[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            ((C0646t[]) c0621a.f2058a)[i3] = new C0646t();
            ((C0646t[]) c0621a.f2058a)[i3].f2175a = jSONObject.getString("revision");
            ((C0646t[]) c0621a.f2058a)[i3].f2176b = jSONObject.getString("updated");
            ((C0646t[]) c0621a.f2058a)[i3].f2177c = jSONObject.getString("log");
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<String[]> m3037a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        int i = 0;
        while (true) {
            if (i < (strArr.length % 50 == 0 ? 0 : 1) + (strArr.length / 50)) {
                int i2 = i * 50;
                int min = Math.min((i + 1) * 50, strArr.length);
                String[] strArr2 = (String[]) Arrays.copyOfRange(strArr, i2, min);
                JSONArray a = C0611i.m2788a(m548a(mo376a(m555a(false, m3010a() + "/" + ReaderEnv.get().getAppIdforStore() + "/book/check_update", "t", "1", "book_id", TextUtils.join(",", strArr2))), HTTP.UTF_8), "items", null);
                HashMap hashMap = new HashMap();
                for (DkStoreBookInfo dkStoreBookInfo : m3018d(a)) {
                    hashMap.put(dkStoreBookInfo.mBookUuid, dkStoreBookInfo.mRevision);
                }
                while (i2 < min) {
                    String str = (String) hashMap.get(strArr[i2]);
                    if (TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    } else {
                        arrayList.add(str);
                    }
                    i2++;
                }
                i++;
            } else {
                C0621a<String[]> c0621a = new C0621a();
                c0621a.f2058a = arrayList.toArray(new String[0]);
                c0621a.b = 0;
                return c0621a;
            }
        }
    }

    /* renamed from: a */
    public C0621a<DkStoreFictionDetailInfo> m3035a(String str, boolean z, boolean z2, int i, int i2, int i3) {
        return m3036a(str, z, false, z2, i, i2, i3);
    }

    /* renamed from: a */
    public C0621a<DkStoreFictionDetailInfo> m3036a(String str, boolean z, boolean z2, boolean z3, int i, int i2, int i3) {
        Object obj;
        String str2;
        if (Long.parseLong(str) < 10000000) {
            obj = 1;
        } else {
            obj = null;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            arrayList.add("free");
            arrayList.add("1");
        }
        if (z) {
            arrayList.add("toc");
            arrayList.add("0");
        }
        if (z2) {
            arrayList.add("nd");
            arrayList.add("true");
        }
        if (i >= 0 && i2 < 0 && i3 > 0) {
            arrayList.add("start");
            arrayList.add(Long.toString((long) i));
            arrayList.add("count");
            arrayList.add(Long.toString((long) i3));
        } else if (i < 0 && i2 >= 0 && i3 > 0) {
            arrayList.add("end");
            arrayList.add(Long.toString((long) i2));
            arrayList.add("count");
            arrayList.add(Long.toString((long) i3));
        }
        StringBuilder append = new StringBuilder().append(m3010a());
        if (obj != null) {
            str2 = "/fiction/detail/" + str;
        } else {
            str2 = "/comic/detail/" + str;
        }
        C0627d a = mo376a(m562b(false, append.append(str2).toString(), (String[]) arrayList.toArray(new String[0])));
        C0621a<DkStoreFictionDetailInfo> c0621a = new C0621a();
        if (a.mo812a() == HttpStatus.SC_NOT_FOUND) {
            c0621a.b = 1;
            return c0621a;
        }
        JSONObject a2 = m548a(a, HTTP.UTF_8);
        c0621a.b = a2.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        JSONObject jSONObject = a2.getJSONObject("item");
        c0621a.f2058a = new DkStoreFictionDetailInfo();
        ((DkStoreFictionDetailInfo) c0621a.f2058a).mFictionInfo = obj != null ? C0647u.m3023g(jSONObject) : C0647u.m3025h(jSONObject);
        ((DkStoreFictionDetailInfo) c0621a.f2058a).mSummary = jSONObject.optString("content");
        ((DkStoreFictionDetailInfo) c0621a.f2058a).mRights = jSONObject.optString("rights");
        int optInt = jSONObject.optInt("rights_id", -1);
        ((DkStoreFictionDetailInfo) c0621a.f2058a).mRightId = optInt != -1 ? String.valueOf(optInt) : "";
        ((DkStoreFictionDetailInfo) c0621a.f2058a).mAllowFreeRead = jSONObject.optInt("allow_free_read", 1) == 1;
        ((DkStoreFictionDetailInfo) c0621a.f2058a).mFeeMode = jSONObject.optInt("charge_mode", 2);
        if (a2.has("related")) {
            JSONArray optJSONArray = a2.optJSONArray("related");
            ((DkStoreFictionDetailInfo) c0621a.f2058a).mRelatedInfo = obj != null ? m3020e(optJSONArray) : m3027h(optJSONArray);
        }
        if (jSONObject.has("categories")) {
            optJSONArray = jSONObject.getJSONArray("categories");
            ((DkStoreFictionDetailInfo) c0621a.f2058a).mCategories = obj != null ? C0647u.m3022f(optJSONArray) : C0647u.m3030j(optJSONArray);
        }
        if (jSONObject.has("toc")) {
            optJSONArray = jSONObject.getJSONArray("toc");
            ((DkStoreFictionDetailInfo) c0621a.f2058a).mChapterInfo = obj != null ? C0647u.m3024g(optJSONArray) : C0647u.m3029i(optJSONArray);
        }
        return c0621a;
    }

    /* renamed from: g */
    public C0621a<ag> m3042g(String str) {
        C0624a b;
        C0621a<ag> c0621a = new C0621a();
        ArrayList arrayList = new ArrayList();
        arrayList.add("book_id");
        arrayList.add(str);
        arrayList.add("action");
        arrayList.add("user,rank,count");
        if (!(this.e instanceof MiAccount) || this.e.mo839i()) {
            b = m562b(true, C0641o.m2934i().m2987n() + "/discover/reward/list", (String[]) arrayList.toArray(new String[0]));
        } else {
            b = m555a(true, C0641o.m2934i().m2987n() + "/discover/user/reward/list", (String[]) arrayList.toArray(new String[0]));
        }
        JSONObject a = m548a(mo376a(b), HTTP.UTF_8);
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        ag agVar = new ag();
        User user = new User();
        JSONObject optJSONObject = a.optJSONObject("user");
        if (optJSONObject != null) {
            user.mUserId = optJSONObject.optString("user_id", "");
            user.mNickName = optJSONObject.optString("user_nick", "");
            user.mIconUrl = optJSONObject.optString("user_icon", "");
            m561a(user, false);
            agVar.f2108a = user;
            agVar.f2109b = optJSONObject.optInt("reward_count", 0);
            agVar.f2110c = optJSONObject.optInt("rank", -1);
            agVar.f2111d = optJSONObject.optInt("cost_sum", 0);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
            if (optJSONObject2 != null) {
                agVar.f2112e = optJSONObject2.optString("content", "");
                agVar.f2114g = optJSONObject2.optLong("update_time", System.currentTimeMillis());
                agVar.f2113f = optJSONObject2.optInt("like_count");
            }
        }
        JSONArray optJSONArray = a.optJSONArray("rank");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                User user2 = new User();
                user2.mIconUrl = jSONObject.optString("user_icon");
                agVar.f2115h.add(user2);
            }
        }
        agVar.f2116i = a.optInt("count");
        c0621a.f2058a = agVar;
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<LinkedList<af>> m3031a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("item_id");
        arrayList.add(str);
        arrayList.add("item_type");
        arrayList.add(String.valueOf(i));
        JSONObject a = m548a(mo376a(m555a(true, C0641o.m2934i().m2987n() + "/rock/book/recommend/item_broken_rec", (String[]) arrayList.toArray(new String[0]))), HTTP.UTF_8);
        C0621a<LinkedList<af>> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        if (c0621a.b != 0) {
            return c0621a;
        }
        String str2;
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = a.optJSONArray("items");
        if (i == 2) {
            str2 = "fiction_id";
        } else if (i == 6) {
            str2 = "comic_id";
        } else {
            str2 = "book_id";
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            af afVar = new af();
            JSONObject jSONObject = optJSONArray.getJSONObject(i2);
            afVar.f2103b = jSONObject.optString("title", "");
            afVar.f2105d = jSONObject.optString("track_name", "");
            afVar.f2104c = jSONObject.optInt("style_type");
            if (afVar.f2104c == 2 || afVar.f2104c == 3) {
                afVar.f2106e = jSONObject.optString("reason_id", "");
                afVar.f2107f = jSONObject.optString("reason_cover", "");
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
                DkStoreAbsBookInfo dkStoreAbsBookInfo = new DkStoreAbsBookInfo();
                dkStoreAbsBookInfo.mCoverUri = jSONObject2.optString("cover", "");
                dkStoreAbsBookInfo.mTitle = jSONObject2.optString("title", "");
                dkStoreAbsBookInfo.mAuthors = jSONObject2.optString("authors", "").split("\\n");
                dkStoreAbsBookInfo.mSummary = jSONObject2.optString("summary", "");
                dkStoreAbsBookInfo.mBookUuid = jSONObject2.optString(str2);
                CommentBook commentBook = new CommentBook(dkStoreAbsBookInfo);
                commentBook.setBookRate((int) Math.round(jSONObject2.optDouble("score")));
                if (i == 2 || i == 6) {
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("tags");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        commentBook.setTag(optJSONArray3.getString(0));
                    }
                } else {
                    commentBook.setTag(jSONObject2.optString("category_name", ""));
                }
                afVar.f2102a.add(commentBook);
            }
            linkedList.add(afVar);
        }
        c0621a.f2058a = linkedList;
        return c0621a;
    }

    /* renamed from: c */
    private static DkStoreBookDetailInfo m3015c(JSONObject jSONObject) {
        Object b;
        boolean z = false;
        int i = -1;
        int i2 = 1;
        JSONObject jSONObject2 = jSONObject.getJSONObject("book");
        JSONArray optJSONArray = jSONObject.optJSONArray("related");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        DkStoreBookDetailInfo dkStoreBookDetailInfo = new DkStoreBookDetailInfo();
        dkStoreBookDetailInfo.mBookInfo = C0647u.m3021f(jSONObject2);
        dkStoreBookDetailInfo.mRelatedBookInfoes = C0647u.m3014b(optJSONArray);
        dkStoreBookDetailInfo.mSummary = jSONObject2.optString("content");
        dkStoreBookDetailInfo.mCopyright = jSONObject2.optString("rights");
        int optInt = jSONObject2.optInt("right_id", -1);
        dkStoreBookDetailInfo.mCopyrightId = optInt != -1 ? String.valueOf(optInt) : "";
        dkStoreBookDetailInfo.mUpdatedDate = jSONObject2.getString("updated");
        dkStoreBookDetailInfo.mEpubUri = jSONObject2.getString("epub");
        dkStoreBookDetailInfo.mEpubSize = jSONObject2.getLong("epub_size");
        dkStoreBookDetailInfo.mEpubMd5 = jSONObject2.optString("epub_md5");
        dkStoreBookDetailInfo.mTrialUri = jSONObject2.getString("trial");
        dkStoreBookDetailInfo.mTrialMd5 = jSONObject2.optString("trial_md5");
        dkStoreBookDetailInfo.mOpfUri = jSONObject2.optString("opf");
        dkStoreBookDetailInfo.mOpfMD5 = C0611i.m2793b(jSONObject2, "opf_md5");
        dkStoreBookDetailInfo.mSize = jSONObject2.optLong("size_l");
        dkStoreBookDetailInfo.mSizeLowQuality = jSONObject2.optLong("size_s");
        dkStoreBookDetailInfo.mRevision = jSONObject2.getString("revision");
        dkStoreBookDetailInfo.mAllowFreeRead = jSONObject2.optInt("allow_free_read", 1) == 1;
        if (jSONObject2.has("features")) {
            dkStoreBookDetailInfo.mFeatures = C0647u.m3026h(jSONObject2.getString("features"));
        }
        if (jSONObject2.has("categories")) {
            dkStoreBookDetailInfo.mCategories = C0647u.m3016c(jSONObject2.getJSONArray("categories"));
        }
        if (jSONObject2.has("translators")) {
            b = C0611i.m2793b(jSONObject2, "translators");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mTranslators = b.split("\r*\n+");
            }
        }
        if (jSONObject2.has("illustrators")) {
            b = C0611i.m2793b(jSONObject2, "illustrators");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mIllustrators = b.split("\r*\n+");
            }
        }
        if (jSONObject2.has("toc")) {
            dkStoreBookDetailInfo.mToc = C0647u.m3028i(jSONObject2.getString("toc"));
        }
        if (jSONObject2.has("tags")) {
            b = C0611i.m2793b(jSONObject2, "tags");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mTags = b.split("\r*\n+");
            }
        }
        if (jSONObject2.has("district")) {
            b = C0611i.m2793b(jSONObject2, "district");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mDistricts = b.split("\r*\n+");
            }
        }
        dkStoreBookDetailInfo.mWordCount = jSONObject2.optLong("word_count");
        dkStoreBookDetailInfo.mIdentifier = jSONObject2.optString("identifier");
        dkStoreBookDetailInfo.mIssued = jSONObject2.optString("issued");
        dkStoreBookDetailInfo.mSid = jSONObject2.getString("sid");
        dkStoreBookDetailInfo.mAfs = jSONObject2.getString("afs");
        dkStoreBookDetailInfo.mMinKernelVersion = jSONObject2.optString("kernel");
        if (jSONObject2.optInt("ad", 0) != 0) {
            z = true;
        }
        dkStoreBookDetailInfo.mHasAds = z;
        String str = "ad_duration";
        if (!dkStoreBookDetailInfo.mHasAds) {
            i2 = -1;
        }
        dkStoreBookDetailInfo.mAdDuration = jSONObject2.optInt(str, i2);
        str = "ad_time";
        if (dkStoreBookDetailInfo.mHasAds) {
            i = 3;
        }
        dkStoreBookDetailInfo.mAdTime = jSONObject2.optInt(str, i);
        dkStoreBookDetailInfo.mQuality = jSONObject2.getInt("quality");
        return dkStoreBookDetailInfo;
    }

    /* renamed from: a */
    public static DkStoreBookDetailInfo m3009a(JSONObject jSONObject) {
        Object b;
        int i = 1;
        int i2 = -1;
        boolean z = false;
        DkStoreBookDetailInfo dkStoreBookDetailInfo = new DkStoreBookDetailInfo();
        dkStoreBookDetailInfo.mBookInfo = C0647u.m3021f(jSONObject);
        dkStoreBookDetailInfo.mRelatedBookInfoes = new DkStoreAbsBookInfo[0];
        dkStoreBookDetailInfo.mSummary = jSONObject.optString("summary");
        dkStoreBookDetailInfo.mRevision = jSONObject.optString("revision");
        dkStoreBookDetailInfo.mUpdatedDate = jSONObject.optString("updated");
        dkStoreBookDetailInfo.mEpubUri = jSONObject.optString("epub");
        dkStoreBookDetailInfo.mEpubSize = (long) jSONObject.optInt("epub_size");
        dkStoreBookDetailInfo.mEpubMd5 = jSONObject.optString("epub_md5");
        dkStoreBookDetailInfo.mSize = jSONObject.optLong("size_l");
        dkStoreBookDetailInfo.mSizeLowQuality = jSONObject.optLong("size_s");
        dkStoreBookDetailInfo.mRevision = jSONObject.getString("revision");
        dkStoreBookDetailInfo.mSid = jSONObject.getString("sid");
        dkStoreBookDetailInfo.mAfs = jSONObject.getString("afs");
        if (jSONObject.optInt("has_ad", 0) != 0) {
            z = true;
        }
        dkStoreBookDetailInfo.mHasAds = z;
        String str = "ad_duration";
        if (!dkStoreBookDetailInfo.mHasAds) {
            i = -1;
        }
        dkStoreBookDetailInfo.mAdDuration = jSONObject.optInt(str, i);
        str = "ad_time";
        if (dkStoreBookDetailInfo.mHasAds) {
            i2 = 3;
        }
        dkStoreBookDetailInfo.mAdTime = jSONObject.optInt(str, i2);
        dkStoreBookDetailInfo.mQuality = jSONObject.getInt("quality");
        if (jSONObject.has("features")) {
            dkStoreBookDetailInfo.mFeatures = C0647u.m3026h(jSONObject.getString("features"));
        }
        if (jSONObject.has("categories")) {
            dkStoreBookDetailInfo.mCategories = C0647u.m3016c(jSONObject.getJSONArray("categories"));
        }
        if (jSONObject.has("trial")) {
            dkStoreBookDetailInfo.mTrialUri = jSONObject.getString("trial");
        }
        if (jSONObject.has("trial_md5")) {
            dkStoreBookDetailInfo.mTrialMd5 = jSONObject.optString("trial_md5");
        }
        if (jSONObject.has("opf")) {
            dkStoreBookDetailInfo.mOpfUri = jSONObject.getString("opf");
        }
        if (jSONObject.has("opf_md5")) {
            dkStoreBookDetailInfo.mOpfMD5 = jSONObject.optString("opf_md5");
        }
        if (jSONObject.has("toc")) {
            dkStoreBookDetailInfo.mToc = C0647u.m3028i(jSONObject.getString("toc"));
        }
        if (jSONObject.has("word_count")) {
            dkStoreBookDetailInfo.mWordCount = jSONObject.optLong("word_count");
        }
        if (jSONObject.has("identifier")) {
            dkStoreBookDetailInfo.mIdentifier = jSONObject.optString("identifier");
        }
        if (jSONObject.has("issued")) {
            dkStoreBookDetailInfo.mIssued = jSONObject.optString("issued");
        }
        if (jSONObject.has("kernel")) {
            dkStoreBookDetailInfo.mMinKernelVersion = jSONObject.optString("kernel");
        }
        if (jSONObject.has("translators")) {
            b = C0611i.m2793b(jSONObject, "translators");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mTranslators = b.split("\r*\n+");
            }
        }
        if (jSONObject.has("illustrators")) {
            b = C0611i.m2793b(jSONObject, "illustrators");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mIllustrators = b.split("\r*\n+");
            }
        }
        if (jSONObject.has("tags")) {
            b = C0611i.m2793b(jSONObject, "tags");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mTags = b.split("\r*\n+");
            }
        }
        if (jSONObject.has("district")) {
            b = C0611i.m2793b(jSONObject, "district");
            if (!TextUtils.isEmpty(b)) {
                dkStoreBookDetailInfo.mDistricts = b.split("\r*\n+");
            }
        }
        return dkStoreBookDetailInfo;
    }

    /* renamed from: b */
    public static DkStoreFictionDetailInfo m3013b(JSONObject jSONObject) {
        boolean has = jSONObject.has("comic_id");
        DkStoreFictionDetailInfo dkStoreFictionDetailInfo = new DkStoreFictionDetailInfo();
        dkStoreFictionDetailInfo.mFictionInfo = has ? C0647u.m3025h(jSONObject) : C0647u.m3023g(jSONObject);
        dkStoreFictionDetailInfo.mSummary = jSONObject.optString("summary");
        dkStoreFictionDetailInfo.mRights = jSONObject.optString("rights");
        dkStoreFictionDetailInfo.mRightId = jSONObject.optString("rights_id");
        dkStoreFictionDetailInfo.mAllowFreeRead = jSONObject.optInt("allow_free_read", 1) == 1;
        if (jSONObject.has("categories")) {
            dkStoreFictionDetailInfo.mCategories = has ? C0647u.m3030j(jSONObject.getJSONArray("categories")) : C0647u.m3022f(jSONObject.getJSONArray("categories"));
        }
        if (jSONObject.has("toc")) {
            dkStoreFictionDetailInfo.mChapterInfo = has ? C0647u.m3029i(jSONObject.getJSONArray("toc")) : C0647u.m3024g(jSONObject.getJSONArray("toc"));
        }
        return dkStoreFictionDetailInfo;
    }

    /* renamed from: d */
    private DkShareBook m3017d(JSONObject jSONObject) {
        int i;
        DkShareBook dkShareBook = new DkShareBook();
        dkShareBook.mBookUuid = jSONObject.optString("source_id", "");
        dkShareBook.mTitle = jSONObject.optString("title", "");
        dkShareBook.mCoverUri = jSONObject.optString("cover", "");
        dkShareBook.mSummary = jSONObject.optString("description", "");
        dkShareBook.mIntro = jSONObject.optString("intro", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("role");
        List arrayList = new ArrayList();
        for (i = 0; i < optJSONArray.length(); i++) {
            JSONArray jSONArray = optJSONArray.getJSONArray(i);
            if (jSONArray.length() == 2 && jSONArray.getString(0).equals("作者")) {
                arrayList.add(jSONArray.getString(1));
            }
        }
        if (arrayList.size() == 0) {
            for (i = 0; i < optJSONArray.length(); i++) {
                jSONArray = optJSONArray.getJSONArray(i);
                if (jSONArray.length() == 2) {
                    arrayList.add(jSONArray.getString(1));
                }
            }
        }
        dkShareBook.mAuthors = (String[]) arrayList.toArray(new String[0]);
        return dkShareBook;
    }

    /* renamed from: a */
    private DkStoreAbsBookInfo[] m3012a(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                DkStoreAbsBookInfo dkStoreAbsBookInfo = (DkStoreAbsBookInfo) m3019e(jSONArray.getJSONObject(i));
                if (dkStoreAbsBookInfo != null) {
                    linkedList.add(dkStoreAbsBookInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (DkStoreAbsBookInfo[]) linkedList.toArray(new DkStoreAbsBookInfo[0]);
    }

    /* renamed from: e */
    private DkStoreItemInfo m3019e(JSONObject jSONObject) {
        try {
            if (jSONObject.has("id")) {
                DkStoreItemInfo dkStoreAbsBookInfo = new DkStoreAbsBookInfo();
                dkStoreAbsBookInfo.mTitle = jSONObject.getString("title");
                dkStoreAbsBookInfo.mBookUuid = String.valueOf(jSONObject.getLong("id"));
                dkStoreAbsBookInfo.mSummary = C0611i.m2793b(jSONObject, "intro");
                dkStoreAbsBookInfo.mCoverUri = jSONObject.getString("cover");
                JSONArray optJSONArray = jSONObject.optJSONArray("role");
                LinkedList linkedList = new LinkedList();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        linkedList.add(optJSONArray.getJSONArray(i).getString(1));
                    }
                }
                dkStoreAbsBookInfo.mAuthors = (String[]) linkedList.toArray(new String[0]);
                return dkStoreAbsBookInfo;
            } else if (jSONObject.has("book_id")) {
                return C0647u.m3021f(jSONObject);
            } else {
                if (jSONObject.has("fiction_id")) {
                    return C0647u.m3023g(jSONObject);
                }
                if (jSONObject.has("comic_id")) {
                    return C0647u.m3025h(jSONObject);
                }
                DkStoreItemInfo dkStoreBookListInfo;
                if (jSONObject.has("list_id")) {
                    dkStoreBookListInfo = new DkStoreBookListInfo();
                    dkStoreBookListInfo.mListId = jSONObject.getString("list_id");
                    dkStoreBookListInfo.mLabel = jSONObject.getString("label");
                    dkStoreBookListInfo.mDescription = jSONObject.getString("description");
                    try {
                        dkStoreBookListInfo.mUpdatedDate = Date.valueOf(jSONObject.getString("updated"));
                    } catch (Exception e) {
                        dkStoreBookListInfo.mUpdatedDate = new java.util.Date();
                    }
                    dkStoreBookListInfo.mCoverUri = jSONObject.optString("cover");
                    dkStoreBookListInfo.mWeight = jSONObject.optInt("weight");
                    dkStoreBookListInfo.mBookCount = jSONObject.optInt("book_count");
                    dkStoreBookListInfo.mBannerUri = jSONObject.optString("banner");
                    return dkStoreBookListInfo;
                } else if (jSONObject.has("category_id")) {
                    dkStoreBookListInfo = new DkStoreBookCategoryInfo();
                    dkStoreBookListInfo.mCategoryId = jSONObject.getString("category_id");
                    dkStoreBookListInfo.mLabel = jSONObject.getString("label");
                    dkStoreBookListInfo.mDescription = jSONObject.getString("description");
                    dkStoreBookListInfo.mCoverUri = jSONObject.getString("cover");
                    dkStoreBookListInfo.mBookTitles = jSONObject.getString("titles");
                    dkStoreBookListInfo.mBookCount = jSONObject.getInt("book_count");
                    dkStoreBookListInfo.mImage = jSONObject.getString("image");
                    return dkStoreBookListInfo;
                } else {
                    WebLog.init().w(false);
                    return null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: f */
    private static DkStoreBookInfo m3021f(JSONObject jSONObject) {
        String[] strArr;
        boolean z = false;
        DkStoreBookInfo dkStoreBookInfo = new DkStoreBookInfo();
        dkStoreBookInfo.mBookUuid = jSONObject.getString("book_id");
        dkStoreBookInfo.mTitle = jSONObject.getString("title");
        Object optString = jSONObject.optString("authors");
        dkStoreBookInfo.mAuthors = TextUtils.isEmpty(optString) ? new String[0] : optString.split("\r*\n+");
        optString = jSONObject.optString("editors");
        if (TextUtils.isEmpty(optString)) {
            strArr = new String[0];
        } else {
            strArr = optString.split("\r*\n+");
        }
        dkStoreBookInfo.mEditors = strArr;
        dkStoreBookInfo.mDescription = jSONObject.optString("summary");
        dkStoreBookInfo.mPrice = (int) Math.round(jSONObject.optDouble("price") * 100.0d);
        dkStoreBookInfo.mNewPrice = (int) Math.round(jSONObject.optDouble("new_price", jSONObject.optDouble("price")) * 100.0d);
        dkStoreBookInfo.mCoverUri = jSONObject.optString("cover");
        dkStoreBookInfo.mWeight = jSONObject.optInt("weight", 0);
        dkStoreBookInfo.mHasChangeLog = jSONObject.optBoolean("has_change_log");
        dkStoreBookInfo.mAverageScore = (float) jSONObject.optDouble("score", 0.0d);
        dkStoreBookInfo.mScoreCount = jSONObject.optInt("score_count");
        dkStoreBookInfo.mCommentCount = jSONObject.optInt("comment_count");
        dkStoreBookInfo.mLimitedTime = jSONObject.optLong("limited_time", 0) * 1000;
        dkStoreBookInfo.mRevision = C0611i.m2786a(jSONObject, "revision", "");
        dkStoreBookInfo.mSupportTip = jSONObject.optBoolean("allow_reward", false);
        if (jSONObject.has("author_ids")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("author_ids");
            if (optJSONArray != null) {
                LinkedList linkedList = new LinkedList();
                int i;
                for (i = 0; i < optJSONArray.length(); i++) {
                    linkedList.add(optJSONArray.getString(i));
                }
                dkStoreBookInfo.mAuthorIds = (String[]) linkedList.toArray(new String[0]);
            }
        }
        optString = jSONObject.optString("ex");
        if (!TextUtils.isEmpty(optString)) {
            dkStoreBookInfo.mExpandInfo = optString.replace(",", " ");
        }
        if (jSONObject.has("expire")) {
            dkStoreBookInfo.mExpirationDate = new java.util.Date((long) (jSONObject.getDouble("expire") * 1000.0d));
        }
        if (jSONObject.has("platforms")) {
            for (String equalsIgnoreCase : jSONObject.getString("platforms").split("\r*\n+")) {
                if (equalsIgnoreCase.equalsIgnoreCase(DkStoreBookInfo.PLATFORM)) {
                    z = true;
                    break;
                }
            }
            dkStoreBookInfo.mAndroidPlatformValid = z;
        }
        return dkStoreBookInfo;
    }

    /* renamed from: b */
    private static DkStoreAbsBookInfo[] m3014b(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                DkStoreAbsBookInfo dkStoreAbsBookInfo = new DkStoreAbsBookInfo();
                dkStoreAbsBookInfo.mBookUuid = jSONObject.getString("book_id");
                dkStoreAbsBookInfo.mCoverUri = jSONObject.getString("cover");
                dkStoreAbsBookInfo.mTitle = jSONObject.getString("title");
                Object optString = jSONObject.optString("authors");
                dkStoreAbsBookInfo.mAuthors = TextUtils.isEmpty(optString) ? new String[0] : optString.split("\r*\n+");
                dkStoreAbsBookInfo.mSummary = jSONObject.getString("summary");
                linkedList.add(dkStoreAbsBookInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (DkStoreAbsBookInfo[]) linkedList.toArray(new DkStoreAbsBookInfo[0]);
    }

    /* renamed from: c */
    private static DkStoreBookCategoryInfo[] m3016c(JSONArray jSONArray) {
        List linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            DkStoreCategoryInfo dkStoreBookCategoryInfo = new DkStoreBookCategoryInfo();
            C0647u.m3011a(dkStoreBookCategoryInfo, jSONObject);
            if (jSONObject.has("child")) {
                C0647u.m3011a(new DkStoreBookCategoryInfo(), jSONObject.getJSONObject("child"));
                dkStoreBookCategoryInfo.mChildCategoryInfos = new DkStoreBookCategoryInfo[]{r5};
            }
            linkedList.add(dkStoreBookCategoryInfo);
        }
        return (DkStoreBookCategoryInfo[]) linkedList.toArray(new DkStoreBookCategoryInfo[0]);
    }

    /* renamed from: a */
    private static void m3011a(DkStoreCategoryInfo dkStoreCategoryInfo, JSONObject jSONObject) {
        dkStoreCategoryInfo.mCategoryId = jSONObject.getString("category_id");
        dkStoreCategoryInfo.mLabel = jSONObject.getString("label");
    }

    /* renamed from: h */
    private static int[] m3026h(String str) {
        try {
            String[] split = str.split(",");
            int[] iArr = new int[split.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr[i] = Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (Throwable th) {
            return new int[0];
        }
    }

    /* renamed from: d */
    private DkStoreBookInfo[] m3018d(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                DkStoreBookInfo dkStoreBookInfo = (DkStoreBookInfo) m3019e(jSONArray.getJSONObject(i));
                if (dkStoreBookInfo != null) {
                    linkedList.add(dkStoreBookInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (DkStoreBookInfo[]) linkedList.toArray(new DkStoreBookInfo[0]);
    }

    /* renamed from: i */
    private static DkStoreBookTocInfo[] m3028i(String str) {
        DkStoreBookTocInfo dkStoreBookTocInfo = null;
        String[] split = str.split("\n");
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        int i = 0;
        DkStoreBookTocInfo dkStoreBookTocInfo2 = null;
        DkStoreBookTocInfo dkStoreBookTocInfo3 = null;
        while (i < split.length) {
            DkStoreBookTocInfo dkStoreBookTocInfo4;
            if (split[i].startsWith("* ")) {
                if (linkedList2.size() > 0 && dkStoreBookTocInfo3 != null) {
                    dkStoreBookTocInfo3.mChildToc = (DkStoreBookTocInfo[]) linkedList2.toArray(new DkStoreBookTocInfo[0]);
                }
                linkedList2.clear();
                dkStoreBookTocInfo3 = new DkStoreBookTocInfo();
                dkStoreBookTocInfo3.mTitle = split[i].substring(2);
                linkedList.add(dkStoreBookTocInfo3);
            }
            if (split[i].startsWith("*- ")) {
                if (f2178a || dkStoreBookTocInfo3 != null) {
                    dkStoreBookTocInfo3.mPreview = split[i].substring(3);
                } else {
                    throw new AssertionError();
                }
            }
            if (split[i].startsWith("** ")) {
                if (linkedList3.size() > 0 && dkStoreBookTocInfo2 != null) {
                    dkStoreBookTocInfo2.mChildToc = (DkStoreBookTocInfo[]) linkedList3.toArray(new DkStoreBookTocInfo[0]);
                }
                linkedList3.clear();
                dkStoreBookTocInfo2 = new DkStoreBookTocInfo();
                dkStoreBookTocInfo2.mTitle = split[i].substring(3);
                linkedList2.add(dkStoreBookTocInfo2);
            }
            if (split[i].startsWith("**- ")) {
                if (f2178a || dkStoreBookTocInfo2 != null) {
                    dkStoreBookTocInfo2.mPreview = split[i].substring(4);
                } else {
                    throw new AssertionError();
                }
            }
            if (split[i].startsWith("*** ")) {
                dkStoreBookTocInfo4 = new DkStoreBookTocInfo();
                dkStoreBookTocInfo4.mTitle = split[i].substring(4);
                linkedList3.add(dkStoreBookTocInfo4);
            } else {
                dkStoreBookTocInfo4 = dkStoreBookTocInfo;
            }
            if (split[i].startsWith("***- ")) {
                if (f2178a || dkStoreBookTocInfo4 != null) {
                    dkStoreBookTocInfo4.mPreview = split[i].substring(5);
                } else {
                    throw new AssertionError();
                }
            }
            i++;
            dkStoreBookTocInfo = dkStoreBookTocInfo4;
        }
        if (linkedList3.size() > 0 && dkStoreBookTocInfo2 != null) {
            dkStoreBookTocInfo2.mChildToc = (DkStoreBookTocInfo[]) linkedList3.toArray(new DkStoreBookTocInfo[0]);
        }
        if (linkedList2.size() > 0 && dkStoreBookTocInfo3 != null) {
            dkStoreBookTocInfo3.mChildToc = (DkStoreBookTocInfo[]) linkedList2.toArray(new DkStoreBookTocInfo[0]);
        }
        return (DkStoreBookTocInfo[]) linkedList.toArray(new DkStoreBookTocInfo[0]);
    }

    /* renamed from: e */
    private DkStoreFictionInfo[] m3020e(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                DkStoreFictionInfo g = C0647u.m3023g(jSONArray.getJSONObject(i));
                if (g != null) {
                    linkedList.add(g);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (DkStoreFictionInfo[]) linkedList.toArray(new DkStoreFictionInfo[0]);
    }

    /* renamed from: g */
    private static DkStoreFictionInfo m3023g(JSONObject jSONObject) {
        int i;
        int i2 = 0;
        DkStoreFictionInfo dkStoreFictionInfo = new DkStoreFictionInfo();
        dkStoreFictionInfo.mBookUuid = C0650x.m3045a(jSONObject.getString("fiction_id"), jSONObject.optInt("owner", 0), jSONObject.optString("owner_uri", "")).toString();
        dkStoreFictionInfo.mTitle = jSONObject.getString("title");
        Object optString = jSONObject.optString("authors");
        dkStoreFictionInfo.mAuthors = TextUtils.isEmpty(optString) ? new String[0] : optString.split("\r*\n+");
        dkStoreFictionInfo.mSummary = jSONObject.optString("summary");
        dkStoreFictionInfo.mCoverUri = jSONObject.getString("cover");
        dkStoreFictionInfo.mRights = jSONObject.optString("rights");
        dkStoreFictionInfo.mDescription = jSONObject.optString("summary");
        try {
            dkStoreFictionInfo.mUpdated = new java.util.Date(jSONObject.optLong("updated") * 1000);
        } catch (Exception e) {
            dkStoreFictionInfo.mUpdated = new java.util.Date();
        }
        dkStoreFictionInfo.mLatest = jSONObject.optString("latest");
        dkStoreFictionInfo.mLatestId = jSONObject.optString("latest_id");
        dkStoreFictionInfo.mChapterCount = jSONObject.getInt("chapter_count");
        dkStoreFictionInfo.mWordCount = jSONObject.optLong("word_count");
        dkStoreFictionInfo.mFinish = jSONObject.optBoolean("finish");
        dkStoreFictionInfo.mOnSale = jSONObject.optBoolean("on_sale");
        dkStoreFictionInfo.mPageLevel = jSONObject.optInt("level");
        dkStoreFictionInfo.mPrice = jSONObject.optInt("price", -1);
        dkStoreFictionInfo.mSpecial = (float) jSONObject.optDouble("special", -1.0d);
        dkStoreFictionInfo.mHasAds = jSONObject.optInt("has_ad", 0) != 0;
        String str = "ad_time";
        if (dkStoreFictionInfo.mHasAds) {
            i = 3;
        } else {
            i = -1;
        }
        dkStoreFictionInfo.mAdTime = jSONObject.optInt(str, i);
        dkStoreFictionInfo.mSupportTip = jSONObject.optBoolean("allow_reward", false);
        if (jSONObject.has("author_ids")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("author_ids");
            if (optJSONArray != null) {
                LinkedList linkedList = new LinkedList();
                for (i = 0; i < optJSONArray.length(); i++) {
                    linkedList.add(optJSONArray.getString(i));
                }
                dkStoreFictionInfo.mAuthorIds = (String[]) linkedList.toArray(new String[0]);
            }
        }
        if (dkStoreFictionInfo.mHasAds) {
            dkStoreFictionInfo.mPrice = 0;
        }
        if (jSONObject.has("ex")) {
            dkStoreFictionInfo.mClick = jSONObject.optInt("ex", 0);
            dkStoreFictionInfo.mRiseCount = jSONObject.optInt("ex", 0);
        } else {
            dkStoreFictionInfo.mClick = jSONObject.optInt("click", 0);
        }
        if (jSONObject.has("categories")) {
            JSONArray jSONArray = jSONObject.getJSONArray("categories");
            dkStoreFictionInfo.mCategories = new DkStoreFictionCategoryInfo[jSONArray.length()];
            while (i2 < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                dkStoreFictionInfo.mCategories[i2] = new DkStoreFictionCategoryInfo();
                dkStoreFictionInfo.mCategories[i2].mCategoryId = jSONObject2.getString("category_id");
                dkStoreFictionInfo.mCategories[i2].mLabel = jSONObject2.getString("label");
                i2++;
            }
            Arrays.sort(dkStoreFictionInfo.mCategories, new C0648v());
        }
        return dkStoreFictionInfo;
    }

    /* renamed from: f */
    private static DkStoreFictionCategoryInfo[] m3022f(JSONArray jSONArray) {
        List linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            DkStoreCategoryInfo dkStoreFictionCategoryInfo = new DkStoreFictionCategoryInfo();
            C0647u.m3011a(dkStoreFictionCategoryInfo, jSONObject);
            if (jSONObject.has("child")) {
                C0647u.m3011a(new DkStoreFictionCategoryInfo(), jSONObject.getJSONObject("child"));
                dkStoreFictionCategoryInfo.mChildCategoryInfos = new DkStoreFictionCategoryInfo[]{r5};
            }
            linkedList.add(dkStoreFictionCategoryInfo);
        }
        return (DkStoreFictionCategoryInfo[]) linkedList.toArray(new DkStoreFictionCategoryInfo[0]);
    }

    /* renamed from: g */
    private static DkStoreFictionChapterInfo[] m3024g(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!(jSONObject.has("dummy") || jSONObject.has("hidden"))) {
                    DkStoreFictionChapterInfo dkStoreFictionChapterInfo = new DkStoreFictionChapterInfo();
                    dkStoreFictionChapterInfo.mChapterId = jSONObject.getString("chapter_id");
                    dkStoreFictionChapterInfo.mTitle = jSONObject.getString("title");
                    dkStoreFictionChapterInfo.mSha1 = C0611i.m2793b(jSONObject, "html_sha1");
                    dkStoreFictionChapterInfo.mPrice = jSONObject.getInt("price");
                    dkStoreFictionChapterInfo.mBasePrice = jSONObject.optInt("old_price", dkStoreFictionChapterInfo.mPrice);
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
                    dkStoreFictionChapterInfo.mUrl = stringBuilder.toString();
                    try {
                        dkStoreFictionChapterInfo.mUpdatedDate = Date.valueOf(jSONObject.getString("updated"));
                    } catch (Exception e) {
                        dkStoreFictionChapterInfo.mUpdatedDate = new java.util.Date();
                    }
                    dkStoreFictionChapterInfo.mWordCount = jSONObject.getLong("word_count");
                    linkedList.add(dkStoreFictionChapterInfo);
                }
            }
        }
        return (DkStoreFictionChapterInfo[]) linkedList.toArray(new DkStoreFictionChapterInfo[0]);
    }

    /* renamed from: h */
    private DkStoreFictionInfo[] m3027h(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                DkStoreFictionInfo h = C0647u.m3025h(jSONArray.getJSONObject(i));
                if (h != null) {
                    linkedList.add(h);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (DkStoreFictionInfo[]) linkedList.toArray(new DkStoreFictionInfo[0]);
    }

    /* renamed from: h */
    private static DkStoreFictionInfo m3025h(JSONObject jSONObject) {
        boolean z;
        int i;
        int i2 = 0;
        DkStoreFictionInfo dkStoreFictionInfo = new DkStoreFictionInfo();
        dkStoreFictionInfo.mBookUuid = C0650x.m3045a(jSONObject.getString("comic_id"), jSONObject.optInt("owner", 0), jSONObject.optString("owner_uri", "")).toString();
        dkStoreFictionInfo.mTitle = jSONObject.getString("title");
        Object optString = jSONObject.optString("authors");
        dkStoreFictionInfo.mAuthors = TextUtils.isEmpty(optString) ? new String[0] : optString.split("\r*\n+");
        dkStoreFictionInfo.mSummary = jSONObject.optString("summary");
        dkStoreFictionInfo.mCoverUri = jSONObject.getString("cover");
        dkStoreFictionInfo.mRights = jSONObject.optString("rights");
        dkStoreFictionInfo.mDescription = jSONObject.optString("summary");
        try {
            dkStoreFictionInfo.mUpdated = new java.util.Date(jSONObject.optLong("updated") * 1000);
        } catch (Exception e) {
            dkStoreFictionInfo.mUpdated = new java.util.Date();
        }
        dkStoreFictionInfo.mLatest = jSONObject.optString("latest");
        dkStoreFictionInfo.mLatestId = jSONObject.optString("latest_id");
        dkStoreFictionInfo.mChapterCount = jSONObject.getInt("chapter_count");
        dkStoreFictionInfo.mFinish = jSONObject.optBoolean("finish");
        dkStoreFictionInfo.mPageLevel = jSONObject.optInt("level");
        dkStoreFictionInfo.mPrice = jSONObject.optInt("price", -1);
        dkStoreFictionInfo.mTypeId = jSONObject.optString("comic_type_id", "");
        dkStoreFictionInfo.mSpecial = (float) jSONObject.optDouble("special", -1.0d);
        if (jSONObject.optInt("has_ad", 0) != 0) {
            z = true;
        } else {
            z = false;
        }
        dkStoreFictionInfo.mHasAds = z;
        String str = "ad_time";
        if (dkStoreFictionInfo.mHasAds) {
            i = 3;
        } else {
            i = -1;
        }
        dkStoreFictionInfo.mAdTime = jSONObject.optInt(str, i);
        dkStoreFictionInfo.mSupportTip = jSONObject.optBoolean("allow_reward", false);
        if (jSONObject.has("categories")) {
            JSONArray jSONArray = jSONObject.getJSONArray("categories");
            dkStoreFictionInfo.mCategories = new DkStoreFictionCategoryInfo[jSONArray.length()];
            while (i2 < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                dkStoreFictionInfo.mCategories[i2] = new DkStoreFictionCategoryInfo();
                dkStoreFictionInfo.mCategories[i2].mCategoryId = jSONObject2.getString("category_id");
                dkStoreFictionInfo.mCategories[i2].mLabel = jSONObject2.getString("label");
                i2++;
            }
            Arrays.sort(dkStoreFictionInfo.mCategories, new C0649w());
        }
        return dkStoreFictionInfo;
    }

    /* renamed from: i */
    private static DkStoreFictionChapterInfo[] m3029i(JSONArray jSONArray) {
        LinkedList linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!(jSONObject.has("dummy") || jSONObject.has("hidden"))) {
                    DkStoreFictionChapterInfo dkStoreFictionChapterInfo = new DkStoreFictionChapterInfo();
                    dkStoreFictionChapterInfo.mChapterId = jSONObject.getString("chapter_id");
                    dkStoreFictionChapterInfo.mTitle = jSONObject.getString("title");
                    dkStoreFictionChapterInfo.mSha1 = C0611i.m2793b(jSONObject, "json_sha1");
                    dkStoreFictionChapterInfo.mPrice = jSONObject.getInt("price");
                    dkStoreFictionChapterInfo.mBasePrice = jSONObject.optInt("old_price", dkStoreFictionChapterInfo.mPrice);
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
                    dkStoreFictionChapterInfo.mUrl = stringBuilder.toString();
                    try {
                        dkStoreFictionChapterInfo.mUpdatedDate = Date.valueOf(jSONObject.getString("updated"));
                    } catch (Exception e) {
                        dkStoreFictionChapterInfo.mUpdatedDate = new java.util.Date();
                    }
                    linkedList.add(dkStoreFictionChapterInfo);
                }
            }
        }
        return (DkStoreFictionChapterInfo[]) linkedList.toArray(new DkStoreFictionChapterInfo[0]);
    }

    /* renamed from: j */
    private static DkStoreFictionCategoryInfo[] m3030j(JSONArray jSONArray) {
        List linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            DkStoreCategoryInfo dkStoreFictionCategoryInfo = new DkStoreFictionCategoryInfo();
            C0647u.m3011a(dkStoreFictionCategoryInfo, jSONObject);
            if (jSONObject.has("child")) {
                C0647u.m3011a(new DkStoreFictionCategoryInfo(), jSONObject.getJSONObject("child"));
                dkStoreFictionCategoryInfo.mChildCategoryInfos = new DkStoreFictionCategoryInfo[]{r5};
            }
            linkedList.add(dkStoreFictionCategoryInfo);
        }
        return (DkStoreFictionCategoryInfo[]) linkedList.toArray(new DkStoreFictionCategoryInfo[0]);
    }

    /* renamed from: a */
    private String m3010a() {
        return C0641o.m2934i().m2990q();
    }
}
