package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;

import com.duokan.core.b.UrlTools;
import com.duokan.core.sys.o;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.mipay.sdk.Mipay;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class s extends ad {
    public s(r rVar, ab abVar) {
        super((WebSession) rVar, abVar);
    }

    public b a() {
        boolean z = false;
        JSONObject a = a(a(a(true, f() + "/checkin/v0/status", new String[0])));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        if (bVar.b != 0) {
            return bVar;
        }
        JSONObject optJSONObject = a.optJSONObject("data");
        DkSignInInfo dkSignInInfo = new DkSignInInfo();
        if (optJSONObject != null) {
            int i;
            JSONArray optJSONArray = optJSONObject.optJSONArray("status");
            boolean[] zArr = new boolean[optJSONArray.length()];
            for (i = 0; i < optJSONArray.length(); i++) {
                zArr[i] = optJSONArray.getString(i).equals("1");
            }
            dkSignInInfo.mSignStatus = zArr;
            i = optJSONObject.optInt("today");
            if (i < 1) {
                i = 1;
            }
            if (i > 7) {
                i = 7;
            }
            dkSignInInfo.mToday = i;
            if (optJSONObject.optInt("lottery") == 1) {
                z = true;
            }
            dkSignInInfo.mLottery = z;
        }
        bVar.a = dkSignInInfo;
        return bVar;
    }

    public b b() {
        int i = 0;
        JSONObject a = a(a(a(true, f() + "/checkin/v0/checkin", new String[0])));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        if (bVar.b != 0) {
            return bVar;
        }
        JSONObject optJSONObject = a.optJSONObject("data");
        DkSignInInfo dkSignInInfo = new DkSignInInfo();
        if (optJSONObject != null) {
            int i2;
            JSONArray optJSONArray = optJSONObject.optJSONArray("status");
            boolean[] zArr = new boolean[optJSONArray.length()];
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                zArr[i2] = optJSONArray.getString(i2).equals("1");
            }
            dkSignInInfo.mSignStatus = zArr;
            i2 = optJSONObject.optInt("today");
            if (i2 < 1) {
                i2 = 1;
            }
            if (i2 > 7) {
                i2 = 7;
            }
            dkSignInInfo.mToday = i2;
            dkSignInInfo.mLottery = optJSONObject.optInt("lottery") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("gift");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                while (i < optJSONArray2.length()) {
                    JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                    DkSignInReward dkSignInReward = new DkSignInReward();
                    dkSignInReward.mName = jSONObject.optString("name");
                    dkSignInReward.mValue = jSONObject.optString("value");
                    if (jSONObject.optInt("physical") == 1) {
                        dkSignInInfo.mHasPhysical = true;
                    }
                    dkSignInInfo.mReward.add(dkSignInReward);
                    i++;
                }
            }
        }
        bVar.a = dkSignInInfo;
        return bVar;
    }

    public b c() {
        JSONObject a = a(a(a(true, f() + "/checkin/v0/gift_list", new String[0])));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        if (bVar.b == 0) {
            Object optString = a.optString("data");
            String str = ReaderEnv.get().getTempDirectory().getPath() + "/" + o.b(optString, "md5") + ".jpg";
            if (!TextUtils.isEmpty(optString)) {
                if (!new File(str).exists()) {
                    a.d(new File(str));
                    UrlTools.b.b(optString, new File(str), new UrlTools.a());
                }
                bVar.a = str;
            }
        }
        return bVar;
    }

    private String f() {
        return p.i().n();
    }

    public b d() {
        int i = 0;
        JSONObject a = a(a(a(true, f() + "/checkin/v0/lottery", new String[0])));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.c = a.optString("msg");
        if (bVar.b != 0) {
            return bVar;
        }
        JSONArray optJSONArray = a.optJSONArray("data");
        DkSignInInfo dkSignInInfo = new DkSignInInfo();
        dkSignInInfo.mLottery = false;
        List arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            while (i < optJSONArray.length()) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                DkSignInReward dkSignInReward = new DkSignInReward();
                dkSignInReward.mName = jSONObject.optString("name");
                dkSignInReward.mValue = jSONObject.optString("value");
                if (jSONObject.optInt("physical") == 1) {
                    dkSignInInfo.mHasPhysical = true;
                }
                arrayList.add(dkSignInReward);
                i++;
            }
        }
        dkSignInInfo.mReward = arrayList;
        bVar.a = dkSignInInfo;
        return bVar;
    }

    public b a(boolean z) {
        String str;
        if (z) {
            str = "/hs/v3/channel/450";
        } else {
            str = "/hs/v3/channel/460";
        }
        JSONObject a = a(a(b(true, f() + str, new String[0])));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        if (bVar.b != 0) {
            return bVar;
        }
        JSONArray jSONArray = a.getJSONArray("items");
        Object obj = new DkStoreAdInfo[jSONArray.length()];
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object jSONObject = jSONArray.getJSONObject(i);
                DkStoreAdInfo dkStoreAdInfo = new DkStoreAdInfo();
                dkStoreAdInfo.mAdName = jSONObject.getString("ad_name");
                dkStoreAdInfo.mAdType = jSONObject.getString("ad_copy");
                dkStoreAdInfo.mReferenceId = jSONObject.getString("reference_id");
                JSONObject a2 = a(jSONObject);
                dkStoreAdInfo.mBookId = a2.optString("book_id");
                if (TextUtils.isEmpty(dkStoreAdInfo.mBookId)) {
                    dkStoreAdInfo.mBookId = a2.getString("fiction_id");
                }
                dkStoreAdInfo.mCoverUri = a2.getString("cover");
                obj[i] = dkStoreAdInfo;
            }
        }
        bVar.a = obj;
        return bVar;
    }

    private JSONObject a(Object obj) {
        if (obj instanceof JSONArray) {
            obj = ((JSONArray) obj).getJSONObject(0);
        } else {
            JSONObject jSONObject = (JSONObject) obj;
        }
        return (obj.has("book_id") || obj.has("fiction_id")) ? obj : a(obj.get("data"));
    }
}
