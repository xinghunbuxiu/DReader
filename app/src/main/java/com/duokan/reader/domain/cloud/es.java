package com.duokan.reader.domain.cloud;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.C0448v;
import org.json.JSONObject;

class es extends C0448v<DkUserReadingNotesCacheInfo, DkCloudNoteBookInfo, JSONObject> {
    private es() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m5508a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m5507a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m5509a((DkCloudNoteBookInfo) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m5511a((DkUserReadingNotesCacheInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m5510a((DkCloudNoteBookInfo) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public JSONObject m5511a(DkUserReadingNotesCacheInfo dkUserReadingNotesCacheInfo) {
        return DkPublic.serializeToJson(dkUserReadingNotesCacheInfo);
    }

    /* renamed from: a */
    public DkUserReadingNotesCacheInfo m5508a(JSONObject jSONObject) {
        return (DkUserReadingNotesCacheInfo) DkPublic.deserializeFromJson(jSONObject, new DkUserReadingNotesCacheInfo(), DkUserReadingNotesCacheInfo.class);
    }

    /* renamed from: a */
    public String m5509a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        return dkCloudNoteBookInfo.getBookUuid();
    }

    /* renamed from: a */
    public JSONObject m5510a(DkCloudNoteBookInfo dkCloudNoteBookInfo, JSONObject jSONObject) {
        if (dkCloudNoteBookInfo == null) {
            return new JSONObject();
        }
        return dkCloudNoteBookInfo.convertToJson();
    }

    /* renamed from: a */
    public DkCloudNoteBookInfo m5507a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (DkCloudNoteBookInfo.canCreateFromJson(jSONObject)) {
            return DkCloudNoteBookInfo.createFromJson(jSONObject);
        }
        return (DkCloudNoteBookInfo) DkPublic.deserializeFromJsonText(jSONObject.toString(), DkCloudNoteBookInfo.class);
    }
}
