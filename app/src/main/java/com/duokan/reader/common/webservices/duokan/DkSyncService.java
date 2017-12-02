package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.mipay.sdk.Mipay;

import org.apache.http.cookie.ClientCookie;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.w3c.dom.Node;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TimeZone;

public class DkSyncService extends ad {

    public enum NoteType {
        DUOKAN_BOOK_NOTE,
        DUOKAN_FICTION_NOTE,
        LOCAL_NOTE
    }

    public DkSyncService(WebSession webSession, a aVar) {
        super(webSession, aVar);
    }

    public DkSyncService(WebSession webSession, ab abVar) {
        super(webSession, abVar);
    }

    public b a(String str, boolean z) {
        Node a = com.duokan.reader.common.e.a.a(b(a(b(true, b() + a(z) + "/progress", "bookids", j(str))), HTTP.UTF_8));
        Node f = com.duokan.reader.common.e.a.f(a, "Progress");
        Object f2 = f != null ? com.duokan.reader.common.e.a.f(f, "BookInfo") : null;
        a = com.duokan.reader.common.e.a.f(a, Mipay.KEY_RESULT);
        b bVar = new b();
        if (a != null) {
            bVar.b = com.duokan.reader.common.e.a.b(a, Mipay.KEY_CODE);
            bVar.c = com.duokan.reader.common.e.a.c(a, Mipay.KEY_MESSAGE);
        } else {
            bVar.b = 0;
            bVar.a = f2;
        }
        return bVar;
    }

    public b a(String str, String str2, boolean z, int i, int i2, int i3, String str3, JSONObject jSONObject) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("book_id");
        linkedList.add(j(str));
        linkedList.add("book_name");
        linkedList.add(str2);
        linkedList.add("duokan");
        linkedList.add(z ? "1" : "0");
        linkedList.add("percent");
        linkedList.add("" + i);
        linkedList.add("time");
        linkedList.add("" + i2);
        linkedList.add("word_count");
        linkedList.add("" + i3);
        if (!TextUtils.isEmpty(str3)) {
            linkedList.add("trace_id");
            linkedList.add(str3);
        }
        linkedList.add("data");
        linkedList.add(jSONObject.toString());
        JSONObject a = a(a(a(true, b() + "/progress/upload", (String[]) linkedList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b a(String str, boolean z, long j) {
        Object obj;
        Node a = com.duokan.reader.common.e.a.a(b(a(b(true, b() + a(z) + "/note", "bookids", j(str), "currentversions", Long.toString(j))), HTTP.UTF_8));
        Node f = com.duokan.reader.common.e.a.f(a, "Reading");
        Node f2 = f != null ? com.duokan.reader.common.e.a.f(f, "BookInfo") : null;
        f = f2 != null ? com.duokan.reader.common.e.a.f(f2, Mipay.KEY_RESULT) : com.duokan.reader.common.e.a.f(a, Mipay.KEY_RESULT);
        b bVar = new b();
        bVar.b = com.duokan.reader.common.e.a.b(f, Mipay.KEY_CODE);
        bVar.c = com.duokan.reader.common.e.a.c(f, Mipay.KEY_MESSAGE);
        if (f2 != null) {
            obj = f2;
        } else {
            f = a;
        }
        bVar.a = obj;
        return bVar;
    }

    public b a(String str, String str2, boolean z, Node node, long j) {
        Object obj;
        Node a = com.duokan.reader.common.e.a.a(b(a(a(true, b() + a(z) + "/note", "bookid", j(str), "bookname", str2, ClientCookie.VERSION_ATTR, Long.toString(j), "data", com.duokan.reader.common.e.a.a(node))), HTTP.UTF_8));
        Node f = com.duokan.reader.common.e.a.f(a, "Reading");
        Node f2 = f != null ? com.duokan.reader.common.e.a.f(f, "BookInfo") : null;
        f = f2 != null ? com.duokan.reader.common.e.a.f(f2, Mipay.KEY_RESULT) : com.duokan.reader.common.e.a.f(a, Mipay.KEY_RESULT);
        b bVar = new b();
        bVar.b = com.duokan.reader.common.e.a.b(f, Mipay.KEY_CODE);
        bVar.c = com.duokan.reader.common.e.a.c(f, Mipay.KEY_MESSAGE);
        if (f2 != null) {
            obj = f2;
        } else {
            f = a;
        }
        bVar.a = obj;
        return bVar;
    }

    public b a(JSONObject jSONObject) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("ts");
        linkedList.add("" + (System.currentTimeMillis() / 1000));
        linkedList.add("distribution");
        linkedList.add(jSONObject.toString());
        JSONObject a = a(a(a(true, b() + "/readstat/upload", (String[]) linkedList.toArray(new String[0]))));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        return bVar;
    }

    public b a() {
        JSONObject a = a(a(a(true, b() + "/readstat/get", new String[0])));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_RESULT);
        bVar.a = a.optJSONObject("data");
        return bVar;
    }

    public b a(NoteType noteType) {
        com.duokan.reader.common.webservices.duokan.a.a b;
        switch (ab.a[noteType.ordinal()]) {
            case 1:
                b = b(true, b() + "/local/note_summary", new String[0]);
                break;
            case 2:
                b = b(true, b() + "/duokan/note_summary", "category", "serial");
                break;
            default:
                b = b(true, b() + "/duokan/note_summary", new String[0]);
                break;
        }
        JSONObject a = a(a(b));
        b bVar = new b();
        bVar.b = a.getInt(Mipay.KEY_CODE);
        bVar.c = a.getString(Mipay.KEY_MESSAGE);
        if (bVar.b != 0) {
            return bVar;
        }
        bVar.a = new DkAnnotationsInfo();
        ((DkAnnotationsInfo) bVar.a).mBookCount = a.getInt("book_count");
        ((DkAnnotationsInfo) bVar.a).mBookmarkCount = a.getInt("total_bookmark_count");
        ((DkAnnotationsInfo) bVar.a).mCommentCount = a.getInt("total_comment_count");
        JSONObject jSONObject = a.getJSONObject("book_list");
        ((DkAnnotationsInfo) bVar.a).mBookInfos = new DkAnnotationBookInfo[jSONObject.length()];
        Iterator keys = jSONObject.keys();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (keys.hasNext()) {
            String str = (String) keys.next();
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i] = new DkAnnotationBookInfo();
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mSerial = noteType == NoteType.DUOKAN_FICTION_NOTE;
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mBookUuid = str;
            a = jSONObject.getJSONObject(str);
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mBookName = a.optString("book_title");
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mAuthor = a.optString("author");
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mEditor = a.optString("editor");
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mCoverUrl = a.optString("cover_url");
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mBookmarkCount = a.getInt("bookmark_count");
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mCommentCount = a.getInt("comment_count");
            ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mVersion = a.getLong(ClientCookie.VERSION_ATTR);
            try {
                ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mLastUpdateTime = simpleDateFormat.parse(a.getString("lastupdatetime"));
            } catch (Exception e) {
                ((DkAnnotationsInfo) bVar.a).mBookInfos[i].mLastUpdateTime = new Date();
            }
            i++;
        }
        return bVar;
    }

    private String b() {
        return p.i().o();
    }

    private String a(boolean z) {
        if (z) {
            return "/duokan";
        }
        return "/local";
    }
}
