package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.C0448v;
import org.json.JSONException;
import org.json.JSONObject;

class ce extends C0448v<DkUserPurchasedBooksInfo, DkCloudPurchasedBook, String> {
    private ce() {
    }

    public /* synthetic */ Object deserializeCorePropertiesFromJson(String str, Object obj) {
        return m5388b(str, (String) obj);
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m5384a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m5383a(str, (String) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m5385a((DkCloudPurchasedBook) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m5387a((DkUserPurchasedBooksInfo) obj);
    }

    public /* synthetic */ Object serializeItemCorePropertiesToJson(Object obj) {
        return m5389b((DkCloudPurchasedBook) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m5386a((DkCloudPurchasedBook) obj, (String) obj2);
    }

    /* renamed from: a */
    public JSONObject m5387a(DkUserPurchasedBooksInfo dkUserPurchasedBooksInfo) {
        return DkPublic.serializeToJson(dkUserPurchasedBooksInfo);
    }

    /* renamed from: a */
    public DkUserPurchasedBooksInfo m5384a(JSONObject jSONObject) {
        return (DkUserPurchasedBooksInfo) DkPublic.deserializeFromJson(jSONObject, new DkUserPurchasedBooksInfo(), DkUserPurchasedBooksInfo.class);
    }

    /* renamed from: a */
    public String m5385a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        return dkCloudPurchasedBook.getBookUuid();
    }

    /* renamed from: a */
    public String m5386a(DkCloudPurchasedBook dkCloudPurchasedBook, String str) {
        return DkPublic.serializeToJsonText(dkCloudPurchasedBook);
    }

    /* renamed from: a */
    public DkCloudPurchasedBook m5383a(String str, String str2) {
        return (DkCloudPurchasedBook) DkPublic.deserializeFromJsonText(str2, DkCloudPurchasedBook.class);
    }

    /* renamed from: b */
    public DkCloudPurchasedBook m5388b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new DkCloudPurchasedBook(new C0845e(new JSONObject(str2)));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: b */
    public String m5389b(DkCloudPurchasedBook dkCloudPurchasedBook) {
        return new C0845e(dkCloudPurchasedBook).m5475a().toString();
    }
}
