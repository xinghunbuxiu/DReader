package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.v;

import org.json.JSONException;
import org.json.JSONObject;

class cq extends v {
    private cq() {
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
        return a((DkCloudPurchasedBook) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((DkUserPurchasedBooksInfo) obj);
    }

    public /* synthetic */ Object serializeItemCorePropertiesToJson(Object obj) {
        return b((DkCloudPurchasedBook) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((DkCloudPurchasedBook) obj, (String) obj2);
    }

    public JSONObject a(DkUserPurchasedBooksInfo dkUserPurchasedBooksInfo) {
        return DkPublic.serializeToJson(dkUserPurchasedBooksInfo);
    }

    public DkUserPurchasedBooksInfo a(JSONObject jSONObject) {
        return (DkUserPurchasedBooksInfo) DkPublic.deserializeFromJson(jSONObject, new DkUserPurchasedBooksInfo(), DkUserPurchasedBooksInfo.class);
    }

    public String a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        return dkCloudPurchasedBook.getBookUuid();
    }

    public String a(DkCloudPurchasedBook dkCloudPurchasedBook, String str) {
        return DkPublic.serializeToJsonText(dkCloudPurchasedBook);
    }

    public DkCloudPurchasedBook a(String str, String str2) {
        return (DkCloudPurchasedBook) DkPublic.deserializeFromJsonText(str2, DkCloudPurchasedBook.class);
    }

    public DkCloudPurchasedBook b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new DkCloudPurchasedBook(new e(new JSONObject(str2)));
        } catch (JSONException e) {
            return null;
        }
    }

    public String b(DkCloudPurchasedBook dkCloudPurchasedBook) {
        return new e(dkCloudPurchasedBook).a().toString();
    }
}
