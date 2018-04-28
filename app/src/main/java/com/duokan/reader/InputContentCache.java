package com.duokan.reader;

import android.content.ContentValues;
import com.duokan.reader.common.cache.C0444r;
import com.duokan.reader.common.cache.C0446p;
import com.duokan.reader.common.cache.C0448v;
import com.duokan.reader.common.cache.C0449k;
import com.duokan.reader.common.cache.C0577j;
import com.duokan.reader.common.cache.aa;
import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;
import java.io.Serializable;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

public class InputContentCache {

    class CacheItem {
        /* renamed from: a */
        public final String f1455a;
        /* renamed from: b */
        public final JSONObject f1456b;
        /* renamed from: c */
        public final long f1457c;

        public CacheItem(String str, JSONObject jSONObject, long j) {
            this.f1455a = str;
            this.f1456b = jSONObject;
            this.f1457c = j;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", this.f1455a);
                jSONObject.put("content", this.f1456b);
                jSONObject.put("latest_update_time", this.f1457c);
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

    class CacheItemLatestUpdateTimeComparator implements ae<CacheItem> {
        private CacheItemLatestUpdateTimeComparator() {
        }

        public int compare(CacheItem cacheItem, CacheItem cacheItem2) {
            return Long.valueOf(cacheItem.f1457c).compareTo(Long.valueOf(cacheItem2.f1457c)) * -1;
        }

        public ai[] toSortOptions() {
            return new ai[]{new ai("latest_update_time", false)};
        }
    }

    class DkInputContentsCacheHelper extends C0448v<DkInputContentsInfo, CacheItem, JSONObject> {
        /* renamed from: a */
        private static final aa[] f1459a = new aa[]{new aa("latest_update_time", "INTEGER")};

        private DkInputContentsCacheHelper() {
        }

        public JSONObject serializeInfoToJson(DkInputContentsInfo dkInputContentsInfo) {
            return DkPublic.serializeToJson(dkInputContentsInfo);
        }

        public DkInputContentsInfo deserializeInfoFromJson(JSONObject jSONObject) {
            return (DkInputContentsInfo) DkPublic.deserializeFromJson(jSONObject, new DkInputContentsInfo(), DkInputContentsInfo.class);
        }

        public String getUniqueId(CacheItem cacheItem) {
            return cacheItem.f1455a;
        }

        public JSONObject serializeItemToJson(CacheItem cacheItem, JSONObject jSONObject) {
            return cacheItem.toJSONObject();
        }

        public CacheItem deserializeItemFromJson(String str, JSONObject jSONObject) {
            return CacheItem.createFromJSONObject(jSONObject);
        }

        public aa[] getPropertyDefinitions() {
            return f1459a;
        }

        public ContentValues getPropertyValues(CacheItem cacheItem) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("latest_update_time", Long.valueOf(cacheItem.f1457c));
            return contentValues;
        }
    }

    class DkInputContentsInfo implements Serializable {
        private DkInputContentsInfo() {
        }
    }

    class InputContentListCache extends C0449k<DkInputContentsInfo, CacheItem, JSONObject> {
        public InputContentListCache() {
            super("InputContentsCachePrefix_SYSTEM", C0577j.f1885a, new DkInputContentsCacheHelper(), new CacheItemLatestUpdateTimeComparator(), HttpStatus.SC_OK);
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
        return cacheItem.f1456b;
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

    public static <T> void putObject(String str, T t, C0444r<T, JSONObject> c0444r) {
        putJSONObject(str, (JSONObject) c0444r.serializeItemToJson(t, getJSONObject(str)));
    }

    public static <T> T getObject(String str, C0446p<T, JSONObject> c0446p) {
        JSONObject jSONObject = getJSONObject(str);
        if (jSONObject == null) {
            return null;
        }
        return c0446p.deserializeItemFromJson(str, jSONObject);
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
