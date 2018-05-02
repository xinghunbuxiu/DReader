package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.reader.common.webservices.duokan.DkCloudMessageInfo;
import com.duokan.reader.domain.cloud.push.MessageListCache.DkCloudPushMessagesInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class t {
    static final /* synthetic */ boolean a = (!t.class.desiredAssertionStatus());
    private static t b = null;
    private static final Object c = new Object();
    private MessageListCache d;

    private t() {
    }

    public static void a() {
        b = new t();
    }

    public static t b() {
        return b;
    }

    private MessageListCache h() {
        if (this.d == null) {
            this.d = new MessageListCache();
            this.d.a();
        }
        return this.d;
    }

    protected Pair a(String str, boolean z, DkCloudMessageInfo dkCloudMessageInfo) {
        Pair pair;
        synchronized (c) {
            MessageListCache h = h();
            if (((DkCloudPushMessage) h.queryItem(dkCloudMessageInfo.mMessageId)) == null) {
                DkCloudPushMessage dkCloudPushMessage = new DkCloudPushMessage(str, z, dkCloudMessageInfo);
                h.insertItem(dkCloudPushMessage);
                DkCloudPushMessagesInfo b = h.b();
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(b.mUnReportMessageIds));
                arrayList.add(dkCloudPushMessage.getCloudId());
                b.mUnReportMessageIds = (String[]) arrayList.toArray(new String[0]);
                arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(b.mUnreadBroadcastMessageIds));
                arrayList.add(dkCloudPushMessage.getCloudId());
                b.mUnreadBroadcastMessageIds = (String[]) arrayList.toArray(new String[0]);
                h.updateInfo(b);
                pair = new Pair(dkCloudPushMessage, Boolean.valueOf(true));
            } else {
                pair = new Pair(null, Boolean.valueOf(false));
            }
        }
        return pair;
    }

    protected DkCloudPushMessage a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DkCloudPushMessage dkCloudPushMessage;
        synchronized (c) {
            dkCloudPushMessage = (DkCloudPushMessage) h().queryItem(str);
        }
        return dkCloudPushMessage;
    }

    protected int c() {
        int length;
        synchronized (c) {
            length = 0 + h().b().mUnreadBroadcastMessageIds.length;
        }
        return length;
    }

    protected void d() {
        if (c() > 0) {
            synchronized (c) {
                DkCloudPushMessagesInfo b = h().b();
                b.mUnreadBroadcastMessageIds = new String[0];
                h().updateInfo(b);
            }
        }
    }

    protected String[] e() {
        String[] strArr;
        synchronized (c) {
            strArr = h().b().mUnReportMessageIds;
        }
        return strArr;
    }

    protected void b(String str) {
        if (c() > 0) {
            synchronized (c) {
                DkCloudPushMessagesInfo b = h().b();
                LinkedList linkedList = new LinkedList();
                for (CharSequence charSequence : b.mUnreadBroadcastMessageIds) {
                    if (!TextUtils.equals(charSequence, str)) {
                        linkedList.add(charSequence);
                    }
                }
                b.mUnreadBroadcastMessageIds = (String[]) linkedList.toArray(new String[0]);
                h().updateInfo(b);
            }
        }
    }

    protected void f() {
        synchronized (c) {
            MessageListCache h = h();
            DkCloudPushMessagesInfo b = h.b();
            b.mUnReportMessageIds = new String[0];
            h.updateInfo(b);
        }
    }

    protected DkCloudPushMessage[] a(long j) {
        return (DkCloudPushMessage[]) h().queryItems(new u(this, j), null, null).toArray(new DkCloudPushMessage[0]);
    }

    protected void g() {
        synchronized (c) {
            MessageListCache h = h();
            h.replaceWithItems((Object[]) (DkCloudPushMessage[]) h.queryItems(new v(this), null, null).toArray(new DkCloudPushMessage[0]));
        }
    }

    public void a(List list) {
        synchronized (c) {
            MessageListCache h = h();
            h.replaceWithItems((Object[]) (DkCloudPushMessage[]) h.queryItems(new w(this, list), null, null).toArray(new DkCloudPushMessage[0]));
        }
    }

    protected void a(DkCloudPushMessage dkCloudPushMessage) {
        if (!dkCloudPushMessage.getIsReportMiServer()) {
            dkCloudPushMessage.markReportMiServer();
            DkCloudPushMessage dkCloudPushMessage2 = (DkCloudPushMessage) h().queryItem(dkCloudPushMessage.getCloudId());
            if (a || dkCloudPushMessage2 != null) {
                dkCloudPushMessage2.markReportMiServer();
                h().updateItem(dkCloudPushMessage2);
                z.a().a(dkCloudPushMessage.getMiServerMsgId());
                return;
            }
            throw new AssertionError();
        }
    }
}
