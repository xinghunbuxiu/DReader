package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.C0448v;
import org.json.JSONException;
import org.json.JSONObject;

class dl extends C0448v<DkUserPurchasedFictionsInfo, DkCloudPurchasedFiction, String> {
    private dl() {
    }

    public /* synthetic */ Object deserializeCorePropertiesFromJson(String str, Object obj) {
        return m5447b(str, (String) obj);
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m5443a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m5442a(str, (String) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m5444a((DkCloudPurchasedFiction) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m5446a((DkUserPurchasedFictionsInfo) obj);
    }

    public /* synthetic */ Object serializeItemCorePropertiesToJson(Object obj) {
        return m5448b((DkCloudPurchasedFiction) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m5445a((DkCloudPurchasedFiction) obj, (String) obj2);
    }

    /* renamed from: a */
    public JSONObject m5446a(DkUserPurchasedFictionsInfo dkUserPurchasedFictionsInfo) {
        return DkPublic.serializeToJson(dkUserPurchasedFictionsInfo);
    }

    /* renamed from: a */
    public DkUserPurchasedFictionsInfo m5443a(JSONObject jSONObject) {
        return (DkUserPurchasedFictionsInfo) DkPublic.deserializeFromJson(jSONObject, new DkUserPurchasedFictionsInfo(), DkUserPurchasedFictionsInfo.class);
    }

    /* renamed from: a */
    public String m5444a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        return dkCloudPurchasedFiction.getBookUuid();
    }

    /* renamed from: a */
    public String m5445a(DkCloudPurchasedFiction dkCloudPurchasedFiction, String str) {
        return DkPublic.serializeToJsonText(dkCloudPurchasedFiction);
    }

    /* renamed from: a */
    public DkCloudPurchasedFiction m5442a(String str, String str2) {
        return (DkCloudPurchasedFiction) DkPublic.deserializeFromJsonText(str2, DkCloudPurchasedFiction.class);
    }

    /* renamed from: b */
    public DkCloudPurchasedFiction m5447b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new DkCloudPurchasedFiction(new C0846f(new JSONObject(str2)));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: b */
    public String m5448b(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        return new C0846f(dkCloudPurchasedFiction).m5530a().toString();
    }
}
