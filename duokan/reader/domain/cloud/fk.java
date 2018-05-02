package com.duokan.reader.domain.cloud;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.v;

import org.json.JSONObject;

class fk extends v {
    private fk() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((DkCloudNoteBookInfo) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((DkUserReadingNotesCacheInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((DkCloudNoteBookInfo) obj, (JSONObject) obj2);
    }

    public JSONObject a(DkUserReadingNotesCacheInfo dkUserReadingNotesCacheInfo) {
        return DkPublic.serializeToJson(dkUserReadingNotesCacheInfo);
    }

    public DkUserReadingNotesCacheInfo a(JSONObject jSONObject) {
        return (DkUserReadingNotesCacheInfo) DkPublic.deserializeFromJson(jSONObject, new DkUserReadingNotesCacheInfo(), DkUserReadingNotesCacheInfo.class);
    }

    public String a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        return dkCloudNoteBookInfo.getBookUuid();
    }

    public JSONObject a(DkCloudNoteBookInfo dkCloudNoteBookInfo, JSONObject jSONObject) {
        if (dkCloudNoteBookInfo == null) {
            return new JSONObject();
        }
        return dkCloudNoteBookInfo.convertToJson();
    }

    public DkCloudNoteBookInfo a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (DkCloudNoteBookInfo.canCreateFromJson(jSONObject)) {
            return DkCloudNoteBookInfo.createFromJson(jSONObject);
        }
        return (DkCloudNoteBookInfo) DkPublic.deserializeFromJsonText(jSONObject.toString(), DkCloudNoteBookInfo.class);
    }
}
