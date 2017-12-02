package com.duokan.reader;

import android.content.ContentValues;

import com.duokan.reader.common.cache.aa;
import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;
import com.duokan.reader.common.cache.j;
import com.duokan.reader.common.cache.k;
import com.duokan.reader.common.cache.p;
import com.duokan.reader.common.cache.r;
import com.duokan.reader.common.cache.v;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class InputContentCache {

    class CacheItem {
        public final String a;
        public final JSONObject b;
        public final long c;

        public CacheItem(String str, JSONObject jSONObject, long j) {
            this.a = str;
            this.b = jSONObject;
            this.c = j;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", this.a);
                jSONObject.put("content", this.b);
                jSONObject.put("latest_update_time", this.c);
            } catch (JSONException e) {
            }
            return jSONObject;
        }

        public static CacheItem createFromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new CacheItem(jSONObject.optString("key"), jSONObject.optJSONObject("content"), jSONObject.optLong("latest_update_time"));
        }
    }

    class CacheItemLatestUpdateTimeComparator implements ae {
        private CacheItemLatestUpdateTimeComparator() {
        }

        public int compare(CacheItem cacheItem, CacheItem cacheItem2) {
            return Long.valueOf(cacheItem.c).compareTo(Long.valueOf(cacheItem2.c)) * -1;
        }

        public ai[] toSortOptions() {
            return new ai[]{new ai("latest_update_time", false)};
        }
    }

    class DkInputContentsCacheHelper extends v {
        private static final aa[] a = new aa[]{new aa("latest_update_time", "INTEGER")};

        private DkInputContentsCacheHelper() {
        }

        public JSONObject serializeInfoToJson(DkInputContentsInfo dkInputContentsInfo) {
            return DkPublic.serializeToJson(dkInputContentsInfo);
        }

        public DkInputContentsInfo deserializeInfoFromJson(JSONObject jSONObject) {
            return (DkInputContentsInfo) DkPublic.deserializeFromJson(jSONObject, new DkInputContentsInfo(), DkInputContentsInfo.class);
        }

        public String getUniqueId(CacheItem cacheItem) {
            return cacheItem.a;
        }

        public JSONObject serializeItemToJson(CacheItem cacheItem, JSONObject jSONObject) {
            return cacheItem.toJSONObject();
        }

        public CacheItem deserializeItemFromJson(String str, JSONObject jSONObject) {
            return CacheItem.createFromJSONObject(jSONObject);
        }

        public aa[] getPropertyDefinitions() {
            return a;
        }

        public ContentValues getPropertyValues(CacheItem cacheItem) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("latest_update_time", Long.valueOf(cacheItem.c));
            return contentValues;
        }
    }

    class DkInputContentsInfo implements Serializable {
        private DkInputContentsInfo() {
        }
    }

    class InputContentListCache extends k {
        public InputContentListCache() {
            super("InputContentsCachePrefix_SYSTEM", j.a, new DkInputContentsCacheHelper(), new CacheItemLatestUpdateTimeComparator(), HttpStatus.SC_OK);
        }

        public void upgradeVersion() {
            upgradeVersion(0);
        }
    }

    private InputContentCache() {
    }

    public static void putJSONObject(String str, JSONObject jSONObject) {
        obtainListCache().insertItem(new CacheItem(str, jSONObject, System.currentTimeMillis()));
    }

    public static JSONObject getJSONObject(String str) {
        CacheItem cacheItem = (CacheItem) obtainListCache().queryItem(str);
        if (cacheItem == null) {
            return null;
        }
        return cacheItem.b;
    }

    public static void putText(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("text", str2);
        } catch (JSONException e) {
        }
        putJSONObject(str, jSONObject);
    }

    public static String getText(String str) {
        JSONObject jSONObject = getJSONObject(str);
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("text");
    }

    public static void putObject(String str, Object obj, r rVar) {
        putJSONObject(str, (JSONObject) rVar.serializeItemToJson(obj, getJSONObject(str)));
    }

    public static Object getObject(String str, p pVar) {
        JSONObject jSONObject = getJSONObject(str);
        if (jSONObject == null) {
            return null;
        }
        return pVar.deserializeItemFromJson(str, jSONObject);
    }

    public static void remove(String str) {
        obtainListCache().deleteItemWithKey(str);
    }

    private static InputContentListCache obtainListCache() {
        InputContentListCache inputContentListCache = new InputContentListCache();
        inputContentListCache.upgradeVersion();
        return inputContentListCache;
    }
}
