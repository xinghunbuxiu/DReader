package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;
import com.duokan.reader.common.p039e.C0606a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;
import com.mipay.sdk.Mipay;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TimeZone;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.w3c.dom.Node;

public class DkSyncService extends ac {

    public enum NoteType {
        DUOKAN_BOOK_NOTE,
        DUOKAN_FICTION_NOTE,
        LOCAL_NOTE
    }

    public DkSyncService(WebSession webSession, C0672a c0672a) {
        super(webSession, c0672a);
    }

    public DkSyncService(WebSession webSession, al alVar) {
        super(webSession, alVar);
    }

    /* renamed from: a */
    public C0621a<Node> m2825a(String str, boolean z) {
        Node a = C0606a.m2776a(m550b(mo376a(m562b(true, m2820b() + m2819a(z) + "/progress", "bookids", m565k(str))), HTTP.UTF_8));
        Node f = C0606a.m2783f(a, "Progress");
        Object f2 = f != null ? C0606a.m2783f(f, "BookInfo") : null;
        a = C0606a.m2783f(a, Mipay.KEY_RESULT);
        C0621a<Node> c0621a = new C0621a();
        if (a != null) {
            c0621a.b = C0606a.m2777b(a, Mipay.KEY_CODE);
            c0621a.c = C0606a.m2780c(a, Mipay.KEY_MESSAGE);
        } else {
            c0621a.b = 0;
            c0621a.f2058a = f2;
        }
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Void> m2823a(String str, String str2, boolean z, int i, int i2, int i3, String str3, JSONObject jSONObject) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("book_id");
        linkedList.add(m565k(str));
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
        JSONObject a = m547a(mo376a(m555a(true, m2820b() + "/progress/upload", (String[]) linkedList.toArray(new String[0]))));
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Node> m2826a(String str, boolean z, long j) {
        Object obj;
        Node a = C0606a.m2776a(m550b(mo376a(m562b(true, m2820b() + m2819a(z) + "/note", "bookids", m565k(str), "currentversions", Long.toString(j))), HTTP.UTF_8));
        Node f = C0606a.m2783f(a, "Reading");
        Node f2 = f != null ? C0606a.m2783f(f, "BookInfo") : null;
        f = f2 != null ? C0606a.m2783f(f2, Mipay.KEY_RESULT) : C0606a.m2783f(a, Mipay.KEY_RESULT);
        C0621a<Node> c0621a = new C0621a();
        c0621a.b = C0606a.m2777b(f, Mipay.KEY_CODE);
        c0621a.c = C0606a.m2780c(f, Mipay.KEY_MESSAGE);
        if (f2 != null) {
            obj = f2;
        } else {
            f = a;
        }
        c0621a.f2058a = obj;
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Node> m2824a(String str, String str2, boolean z, Node node, long j) {
        Object obj;
        Node a = C0606a.m2776a(m550b(mo376a(m555a(true, m2820b() + m2819a(z) + "/note", "bookid", m565k(str), "bookname", str2, ClientCookie.VERSION_ATTR, Long.toString(j), "data", C0606a.m2774a(node))), HTTP.UTF_8));
        Node f = C0606a.m2783f(a, "Reading");
        Node f2 = f != null ? C0606a.m2783f(f, "BookInfo") : null;
        f = f2 != null ? C0606a.m2783f(f2, Mipay.KEY_RESULT) : C0606a.m2783f(a, Mipay.KEY_RESULT);
        C0621a<Node> c0621a = new C0621a();
        c0621a.b = C0606a.m2777b(f, Mipay.KEY_CODE);
        c0621a.c = C0606a.m2780c(f, Mipay.KEY_MESSAGE);
        if (f2 != null) {
            obj = f2;
        } else {
            f = a;
        }
        c0621a.f2058a = obj;
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<Void> m2827a(JSONObject jSONObject) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("ts");
        linkedList.add("" + (System.currentTimeMillis() / 1000));
        linkedList.add("distribution");
        linkedList.add(jSONObject.toString());
        JSONObject a = m547a(mo376a(m555a(true, m2820b() + "/readstat/upload", (String[]) linkedList.toArray(new String[0]))));
        C0621a<Void> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<JSONObject> m2821a() {
        JSONObject a = m547a(mo376a(m555a(true, m2820b() + "/readstat/get", new String[0])));
        C0621a<JSONObject> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_RESULT);
        c0621a.f2058a = a.optJSONObject("data");
        return c0621a;
    }

    /* renamed from: a */
    public C0621a<DkAnnotationsInfo> m2822a(NoteType noteType) {
        C0624a b;
        switch (aa.f2099a[noteType.ordinal()]) {
            case 1:
                b = m562b(true, m2820b() + "/local/note_summary", new String[0]);
                break;
            case 2:
                b = m562b(true, m2820b() + "/duokan/note_summary", "category", "serial");
                break;
            default:
                b = m562b(true, m2820b() + "/duokan/note_summary", new String[0]);
                break;
        }
        JSONObject a = m547a(mo376a(b));
        C0621a<DkAnnotationsInfo> c0621a = new C0621a();
        c0621a.b = a.getInt(Mipay.KEY_CODE);
        c0621a.c = a.getString(Mipay.KEY_MESSAGE);
        if (c0621a.b != 0) {
            return c0621a;
        }
        c0621a.f2058a = new DkAnnotationsInfo();
        ((DkAnnotationsInfo) c0621a.f2058a).mBookCount = a.getInt("book_count");
        ((DkAnnotationsInfo) c0621a.f2058a).mBookmarkCount = a.getInt("total_bookmark_count");
        ((DkAnnotationsInfo) c0621a.f2058a).mCommentCount = a.getInt("total_comment_count");
        JSONObject jSONObject = a.getJSONObject("book_list");
        ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos = new DkAnnotationBookInfo[jSONObject.length()];
        Iterator keys = jSONObject.keys();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (keys.hasNext()) {
            String str = (String) keys.next();
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i] = new DkAnnotationBookInfo();
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mSerial = noteType == NoteType.DUOKAN_FICTION_NOTE;
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mBookUuid = str;
            a = jSONObject.getJSONObject(str);
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mBookName = a.optString("book_title");
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mAuthor = a.optString("author");
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mEditor = a.optString("editor");
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mCoverUrl = a.optString("cover_url");
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mBookmarkCount = a.getInt("bookmark_count");
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mCommentCount = a.getInt("comment_count");
            ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mVersion = a.getLong(ClientCookie.VERSION_ATTR);
            try {
                ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mLastUpdateTime = simpleDateFormat.parse(a.getString("lastupdatetime"));
            } catch (Exception e) {
                ((DkAnnotationsInfo) c0621a.f2058a).mBookInfos[i].mLastUpdateTime = new Date();
            }
            i++;
        }
        return c0621a;
    }

    /* renamed from: b */
    private String m2820b() {
        return C0641o.m2934i().m2988o();
    }

    /* renamed from: a */
    private String m2819a(boolean z) {
        if (z) {
            return "/duokan";
        }
        return "/local";
    }
}
