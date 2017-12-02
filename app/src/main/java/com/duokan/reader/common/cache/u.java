package com.duokan.reader.common.cache;

import org.json.JSONObject;

public interface u extends p, r {
    Object deserializeInfoFromJson(JSONObject jSONObject);

    JSONObject serializeInfoToJson(Object obj);
}
