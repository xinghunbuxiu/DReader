package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.v;

import org.json.JSONException;
import org.json.JSONObject;

class ea extends v {
    private ea() {
    }

    public /* synthetic */ Object deserializeCorePropertiesFromJson(String str, Object obj) {
        return b(str, (String) obj);
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (String) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((DkCloudPurchasedFiction) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((DkUserPurchasedFictionsInfo) obj);
    }

    public /* synthetic */ Object serializeItemCorePropertiesToJson(Object obj) {
        return b((DkCloudPurchasedFiction) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((DkCloudPurchasedFiction) obj, (String) obj2);
    }

    public JSONObject a(DkUserPurchasedFictionsInfo dkUserPurchasedFictionsInfo) {
        return DkPublic.serializeToJson(dkUserPurchasedFictionsInfo);
    }

    public DkUserPurchasedFictionsInfo a(JSONObject jSONObject) {
        return (DkUserPurchasedFictionsInfo) DkPublic.deserializeFromJson(jSONObject, new DkUserPurchasedFictionsInfo(), DkUserPurchasedFictionsInfo.class);
    }

    public String a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        return dkCloudPurchasedFiction.getBookUuid();
    }

    public String a(DkCloudPurchasedFiction dkCloudPurchasedFiction, String str) {
        return DkPublic.serializeToJsonText(dkCloudPurchasedFiction);
    }

    public DkCloudPurchasedFiction a(String str, String str2) {
        return (DkCloudPurchasedFiction) DkPublic.deserializeFromJsonText(str2, DkCloudPurchasedFiction.class);
    }

    public DkCloudPurchasedFiction b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new DkCloudPurchasedFiction(new f(new JSONObject(str2)));
        } catch (JSONException e) {
            return null;
        }
    }

    public String b(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        return new f(dkCloudPurchasedFiction).a().toString();
    }
}
