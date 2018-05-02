package com.duokan.reader.common.cache;

import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.cache.u */
public interface C0447u<TInfo, TItem, TJson> extends C0446p<TItem, TJson>, C0444r<TItem, TJson> {
    TInfo deserializeInfoFromJson(JSONObject jSONObject);

    JSONObject serializeInfoToJson(TInfo tInfo);
}
