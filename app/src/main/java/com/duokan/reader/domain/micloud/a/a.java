package com.duokan.reader.domain.micloud.a;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.j;
import com.duokan.reader.domain.micloud.ah;
import com.duokan.reader.domain.micloud.ai;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class a {
    private String a;
    private String b;
    private ExtendedAuthToken c;

    public a(String str, ExtendedAuthToken extendedAuthToken, String str2) {
        this.a = str;
        this.c = extendedAuthToken;
        this.b = str2;
    }

    public j a(String str, String str2, String str3, String str4, int i, ah ahVar) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file", new Object[]{this.b});
        Map treeMap = new TreeMap();
        treeMap.put("parent_id", str);
        treeMap.put("name", str3);
        treeMap.put("sha1", str4);
        treeMap.put("data", ahVar.a().toString());
        return j.a(b(format, treeMap, i), new b(this, false, str2));
    }

    public j a(String str, String str2, int i, ai aiVar) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file/storage", new Object[]{this.b});
        Map treeMap = new TreeMap();
        treeMap.put("upload_id", str);
        treeMap.put("data", aiVar.a().toString());
        return j.a(b(format, treeMap, i), new c(this, false, str2));
    }

    public j a(String str, int i) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file/%s/storage", new Object[]{this.b, str});
        Map treeMap = new TreeMap();
        treeMap.put("fileId", str);
        return j.a(a(format, treeMap, i), new d(this, false));
    }

    public j a(List list, boolean z) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file/batchdelete", new Object[]{this.b});
        Map treeMap = new TreeMap();
        treeMap.put("file_ids", TextUtils.join(",", list));
        treeMap.put("permanent", Boolean.toString(z));
        return j.a(b(format, treeMap, -1), j.d);
    }

    public j a(String str, String str2, int i, int i2) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/dir/%s/list", new Object[]{this.b, str});
        Map treeMap = new TreeMap();
        treeMap.put("dirId", str);
        treeMap.put("offset", String.valueOf(i));
        treeMap.put("limit", String.valueOf(i2));
        return j.a(a(format, treeMap, -1), new e(this, false, str2));
    }

    public j a(String str) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/info", new Object[]{this.b});
        Map treeMap = new TreeMap();
        treeMap.put(ClientCookie.PATH_ATTR, str);
        return j.a(b(format, treeMap, -1), new f(this, false, str));
    }

    public j a() {
        return j.a(a(String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/quota", new Object[]{this.b}), new TreeMap(), -1), new g(this, false));
    }

    public j b(String str) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/dir", new Object[]{this.b});
        Map treeMap = new TreeMap();
        treeMap.put("recursive", "true");
        treeMap.put(ClientCookie.PATH_ATTR, str);
        return j.a(b(format, treeMap, -1), new h(this, false, str));
    }

    private JSONObject a(String str, Map map, int i) {
        if (map == null) {
            map = new TreeMap();
        }
        map.put("userId", this.a);
        map.put("ns", this.b);
        if (i > 0) {
            map.put("retry", Integer.toString(i));
        }
        return new JSONObject(Request.secureGet(str, map, a(this.a, this.c, null)));
    }

    private JSONObject b(String str, Map map, int i) {
        if (map == null) {
            map = new TreeMap();
        }
        map.put("userId", this.a);
        map.put("ns", this.b);
        if (i > 0) {
            map.put("retry", Integer.toString(i));
        }
        return new JSONObject(Request.securePost(str, map, a(this.a, this.c, null)));
    }

    private static Map a(String str, ExtendedAuthToken extendedAuthToken, Map map) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("userId", str);
        map.put("serviceToken", extendedAuthToken.authToken);
        return map;
    }
}
