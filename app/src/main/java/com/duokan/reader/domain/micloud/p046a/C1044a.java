package com.duokan.reader.domain.micloud.p046a;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0660l;
import com.duokan.reader.domain.micloud.ah;
import com.duokan.reader.domain.micloud.ai;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.a */
public class C1044a {
    /* renamed from: a */
    private String f5154a;
    /* renamed from: b */
    private String f5155b;
    /* renamed from: c */
    private ExtendedAuthToken f5156c;

    public C1044a(String str, ExtendedAuthToken extendedAuthToken, String str2) {
        this.f5154a = str;
        this.f5156c = extendedAuthToken;
        this.f5155b = str2;
    }

    /* renamed from: a */
    public C0660l<C1054k> m8020a(String str, String str2, String str3, String str4, int i, ah ahVar) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file", new Object[]{this.f5155b});
        Map treeMap = new TreeMap();
        treeMap.put("parent_id", str);
        treeMap.put("name", str3);
        treeMap.put("sha1", str4);
        treeMap.put("data", ahVar.m8059a().toString());
        return C0660l.m3099a(m8014b(format, treeMap, i), new C1045b(this, false, str2));
    }

    /* renamed from: a */
    public C0660l<C1053j> m8019a(String str, String str2, int i, ai aiVar) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file/storage", new Object[]{this.f5155b});
        Map treeMap = new TreeMap();
        treeMap.put("upload_id", str);
        treeMap.put("data", aiVar.m8061a().toString());
        return C0660l.m3099a(m8014b(format, treeMap, i), new C1046c(this, false, str2));
    }

    /* renamed from: a */
    public C0660l<C1055l> m8017a(String str, int i) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file/%s/storage", new Object[]{this.f5155b, str});
        Map treeMap = new TreeMap();
        treeMap.put("fileId", str);
        return C0660l.m3099a(m8012a(format, treeMap, i), new C1047d(this, false));
    }

    /* renamed from: a */
    public C0660l<Void> m8021a(List<String> list, boolean z) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/file/batchdelete", new Object[]{this.f5155b});
        Map treeMap = new TreeMap();
        treeMap.put("file_ids", TextUtils.join(",", list));
        treeMap.put("permanent", Boolean.toString(z));
        return C0660l.m3099a(m8014b(format, treeMap, -1), C0660l.f2212d);
    }

    /* renamed from: a */
    public C0660l<C1057n> m8018a(String str, String str2, int i, int i2) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/dir/%s/list", new Object[]{this.f5155b, str});
        Map treeMap = new TreeMap();
        treeMap.put("dirId", str);
        treeMap.put("offset", String.valueOf(i));
        treeMap.put("limit", String.valueOf(i2));
        return C0660l.m3099a(m8012a(format, treeMap, -1), new C1048e(this, false, str2));
    }

    /* renamed from: a */
    public C0660l<C1056m> m8016a(String str) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/info", new Object[]{this.f5155b});
        Map treeMap = new TreeMap();
        treeMap.put(ClientCookie.PATH_ATTR, str);
        return C0660l.m3099a(m8014b(format, treeMap, -1), new C1049f(this, false, str));
    }

    /* renamed from: a */
    public C0660l<C1058o> m8015a() {
        return C0660l.m3099a(m8012a(String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/quota", new Object[]{this.f5155b}), new TreeMap(), -1), new C1050g(this, false));
    }

    /* renamed from: b */
    public C0660l<C1052i> m8022b(String str) {
        String format = String.format("http://sfsapi.micloud.xiaomi.net/mic/sfs/v2/user/ns/%s/dir", new Object[]{this.f5155b});
        Map treeMap = new TreeMap();
        treeMap.put("recursive", "true");
        treeMap.put(ClientCookie.PATH_ATTR, str);
        return C0660l.m3099a(m8014b(format, treeMap, -1), new C1051h(this, false, str));
    }

    /* renamed from: a */
    private JSONObject m8012a(String str, Map<String, String> map, int i) {
        Map map2;
        if (map2 == null) {
            map2 = new TreeMap();
        }
        map2.put("userId", this.f5154a);
        map2.put("ns", this.f5155b);
        if (i > 0) {
            map2.put("retry", Integer.toString(i));
        }
        return new JSONObject(Request.secureGet(str, map2, C1044a.m8011a(this.f5154a, this.f5156c, null)));
    }

    /* renamed from: b */
    private JSONObject m8014b(String str, Map<String, String> map, int i) {
        Map map2;
        if (map2 == null) {
            map2 = new TreeMap();
        }
        map2.put("userId", this.f5154a);
        map2.put("ns", this.f5155b);
        if (i > 0) {
            map2.put("retry", Integer.toString(i));
        }
        return new JSONObject(Request.securePost(str, map2, C1044a.m8011a(this.f5154a, this.f5156c, null)));
    }

    /* renamed from: a */
    private static Map<String, String> m8011a(String str, ExtendedAuthToken extendedAuthToken, Map<String, String> map) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("userId", str);
        map.put("serviceToken", extendedAuthToken.authToken);
        return map;
    }
}
