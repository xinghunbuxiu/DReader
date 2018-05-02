package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p027b.p028a.C0320a;
import com.duokan.core.p027b.p028a.C0321b;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import com.mipay.sdk.Mipay;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.r */
public class C0644r extends ac {
    public C0644r(WebSession webSession, al alVar) {
        super(webSession, alVar);
    }

    /* renamed from: a */
    public C0621a<DkSignInInfo> m3001a() {
        boolean z = false;
        JSONObject a = m547a(mo376a(m555a(true, m3000f() + "/checkin/v0/status", new String[0])));
        C0621a<DkSignInInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        if (c0621a.b != 0) {
            return c0621a;
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
        c0621a.f2058a = dkSignInInfo;
        return c0621a;
    }

    /* renamed from: b */
    public C0621a<DkSignInInfo> m3002b() {
        JSONObject a = m547a(mo376a(m555a(true, m3000f() + "/checkin/v0/checkin", new String[0])));
        C0621a<DkSignInInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        if (c0621a.b != 0) {
            return c0621a;
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
            dkSignInInfo.mLottery = optJSONObject.optInt("lottery") == 1;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("gift");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (i = 0; i < optJSONArray2.length(); i++) {
                    optJSONObject = optJSONArray2.getJSONObject(i);
                    DkSignInReward dkSignInReward = new DkSignInReward();
                    dkSignInReward.mName = optJSONObject.optString("name");
                    dkSignInReward.mValue = optJSONObject.optString("value");
                    dkSignInReward.mType = 0;
                    if (optJSONObject.optInt("physical") == 1) {
                        dkSignInInfo.mHasPhysical = true;
                    }
                    dkSignInInfo.mReward.add(dkSignInReward);
                }
            }
        }
        c0621a.f2058a = dkSignInInfo;
        return c0621a;
    }

    /* renamed from: c */
    public C0621a<String> m3003c() {
        JSONObject a = m547a(mo376a(m555a(true, m3000f() + "/checkin/v0/gift_list", new String[0])));
        C0621a<String> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        if (c0621a.b == 0) {
            Object optString = a.optString("data");
            String str = ReaderEnv.get().getTempDirectory().getPath() + "/" + C0366o.m1034b(optString, "md5") + ".jpg";
            if (!TextUtils.isEmpty(optString)) {
                if (!new File(str).exists()) {
                    FileUtil.deleteFile(new File(str));
                    C0321b.m732b(optString, new File(str), new C0320a());
                }
                c0621a.f2058a = str;
            }
        }
        return c0621a;
    }

    /* renamed from: f */
    private String m3000f() {
        return C0641o.m2934i().m2987n();
    }

    /* renamed from: d */
    public C0621a<DkSignInInfo> m3004d() {
        int i = 0;
        JSONObject a = m547a(mo376a(m555a(true, m3000f() + "/checkin/v0/lottery", new String[0])));
        C0621a<DkSignInInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.c = a.optString("msg");
        if (c0621a.b != 0) {
            return c0621a;
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
                dkSignInReward.mType = 2;
                if (jSONObject.optInt("physical") == 1) {
                    dkSignInInfo.mHasPhysical = true;
                }
                arrayList.add(dkSignInReward);
                i++;
            }
        }
        dkSignInInfo.mReward = arrayList;
        c0621a.f2058a = dkSignInInfo;
        return c0621a;
    }
}
