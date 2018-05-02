package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;
import android.util.Pair;
import com.duokan.reader.common.webservices.duokan.DkCloudMessageInfo;
import com.duokan.reader.domain.cloud.push.MessageListCache.DkCloudPushMessagesInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.domain.cloud.push.q */
public class C0872q {
    /* renamed from: a */
    static final /* synthetic */ boolean f4145a = (!C0872q.class.desiredAssertionStatus());
    /* renamed from: b */
    private static C0872q f4146b = null;
    /* renamed from: c */
    private static final Object f4147c = new Object();
    /* renamed from: d */
    private MessageListCache f4148d;

    private C0872q() {
    }

    /* renamed from: a */
    public static void m5708a() {
        f4146b = new C0872q();
    }

    /* renamed from: b */
    public static C0872q m5709b() {
        return f4146b;
    }

    /* renamed from: h */
    private MessageListCache m5710h() {
        if (this.f4148d == null) {
            this.f4148d = new MessageListCache();
            this.f4148d.m5638a();
        }
        return this.f4148d;
    }

    /* renamed from: a */
    protected Pair<DkCloudPushMessage, Boolean> m5711a(String str, boolean z, DkCloudMessageInfo dkCloudMessageInfo) {
        Pair<DkCloudPushMessage, Boolean> pair;
        synchronized (f4147c) {
            MessageListCache h = m5710h();
            if (((DkCloudPushMessage) h.queryItem(dkCloudMessageInfo.mMessageId)) == null) {
                DkCloudPushMessage dkCloudPushMessage = new DkCloudPushMessage(str, z, dkCloudMessageInfo);
                h.insertItem(dkCloudPushMessage);
                DkCloudPushMessagesInfo b = h.m5639b();
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

    /* renamed from: a */
    protected DkCloudPushMessage m5712a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DkCloudPushMessage dkCloudPushMessage;
        synchronized (f4147c) {
            dkCloudPushMessage = (DkCloudPushMessage) m5710h().queryItem(str);
        }
        return dkCloudPushMessage;
    }

    /* renamed from: c */
    protected int m5717c() {
        int length;
        synchronized (f4147c) {
            length = 0 + m5710h().m5639b().mUnreadBroadcastMessageIds.length;
        }
        return length;
    }

    /* renamed from: d */
    protected void m5718d() {
        if (m5717c() > 0) {
            synchronized (f4147c) {
                DkCloudPushMessagesInfo b = m5710h().m5639b();
                b.mUnreadBroadcastMessageIds = new String[0];
                m5710h().updateInfo(b);
            }
        }
    }

    /* renamed from: e */
    protected String[] m5719e() {
        String[] strArr;
        synchronized (f4147c) {
            strArr = m5710h().m5639b().mUnReportMessageIds;
        }
        return strArr;
    }

    /* renamed from: b */
    protected void m5716b(String str) {
        if (m5717c() > 0) {
            synchronized (f4147c) {
                DkCloudPushMessagesInfo b = m5710h().m5639b();
                LinkedList linkedList = new LinkedList();
                for (CharSequence charSequence : b.mUnreadBroadcastMessageIds) {
                    if (!TextUtils.equals(charSequence, str)) {
                        linkedList.add(charSequence);
                    }
                }
                b.mUnreadBroadcastMessageIds = (String[]) linkedList.toArray(new String[0]);
                m5710h().updateInfo(b);
            }
        }
    }

    /* renamed from: f */
    protected void m5720f() {
        synchronized (f4147c) {
            MessageListCache h = m5710h();
            DkCloudPushMessagesInfo b = h.m5639b();
            b.mUnReportMessageIds = new String[0];
            h.updateInfo(b);
        }
    }

    /* renamed from: a */
    protected DkCloudPushMessage[] m5715a(long j) {
        return (DkCloudPushMessage[]) m5710h().queryItems(new C0873r(this, j), null, null).toArray(new DkCloudPushMessage[0]);
    }

    /* renamed from: g */
    protected void m5721g() {
        synchronized (f4147c) {
            MessageListCache h = m5710h();
            h.replaceWithItems((Object[]) (DkCloudPushMessage[]) h.queryItems(new C0874s(this), null, null).toArray(new DkCloudPushMessage[0]));
        }
    }

    /* renamed from: a */
    public void m5714a(List<DkCloudPushMessage> list) {
        synchronized (f4147c) {
            MessageListCache h = m5710h();
            h.replaceWithItems((Object[]) (DkCloudPushMessage[]) h.queryItems(new C0875t(this, list), null, null).toArray(new DkCloudPushMessage[0]));
        }
    }

    /* renamed from: a */
    protected void m5713a(DkCloudPushMessage dkCloudPushMessage) {
        if (!dkCloudPushMessage.getIsReportMiServer()) {
            dkCloudPushMessage.markReportMiServer();
            DkCloudPushMessage dkCloudPushMessage2 = (DkCloudPushMessage) m5710h().queryItem(dkCloudPushMessage.getCloudId());
            if (f4145a || dkCloudPushMessage2 != null) {
                dkCloudPushMessage2.markReportMiServer();
                m5710h().updateItem(dkCloudPushMessage2);
                C0880y.m5742a().m5752a(dkCloudPushMessage.getMiServerMsgId());
                return;
            }
            throw new AssertionError();
        }
    }
}
