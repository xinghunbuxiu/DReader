package com.duokan.reader.ui.personal;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.micloud.bi;
import java.util.ArrayList;
import java.util.List;

public class CustomCloudItem {
    /* renamed from: a */
    private final af<C0800c> f8199a = new af();
    /* renamed from: b */
    private final Object f8200b;
    /* renamed from: c */
    private final CloudItemType f8201c;

    enum CloudItemStatus {
        CLOUD_ONLY,
        CLOUD_BOOKSHELF,
        CLOUD_DOWNLOADING,
        CLOUD_DOWNLOADED,
        LOCAL_UPLOADING,
        CONNECTING_SERVER
    }

    enum CloudItemType {
        LOCAL,
        CLOUD
    }

    public CustomCloudItem(is isVar) {
        this.f8200b = isVar;
        this.f8201c = CloudItemType.CLOUD;
    }

    public CustomCloudItem(C1068i c1068i) {
        this.f8200b = c1068i;
        this.f8201c = CloudItemType.LOCAL;
    }

    /* renamed from: a */
    public void m11338a(C0800c c0800c) {
        this.f8199a.mo975a((Object) c0800c);
    }

    /* renamed from: a */
    public Object m11337a() {
        return this.f8200b;
    }

    /* renamed from: b */
    public C0800c m11340b() {
        if (this.f8201c != CloudItemType.CLOUD) {
            return null;
        }
        if (!this.f8199a.m861b()) {
            this.f8199a.mo975a(ai.m3980a().mo968a((is) this.f8200b));
        }
        return (C0800c) this.f8199a.m858a();
    }

    /* renamed from: c */
    public boolean m11341c() {
        return this.f8201c == CloudItemType.CLOUD;
    }

    /* renamed from: d */
    public float m11342d() {
        CloudItemStatus h = m11346h();
        if (h == CloudItemStatus.CLOUD_DOWNLOADING && m11340b() != null) {
            return (m11340b().m4240m() * 1.0f) / 100.0f;
        }
        if (h != CloudItemStatus.LOCAL_UPLOADING) {
            return -1.0f;
        }
        C1068i c1068i = (C1068i) this.f8200b;
        return (((float) c1068i.m8210F()) * 1.0f) / ((float) c1068i.m8207C());
    }

    /* renamed from: e */
    public long m11343e() {
        if (m11341c()) {
            return ((is) this.f8200b).m4684d();
        }
        return ((C1068i) this.f8200b).m8207C();
    }

    /* renamed from: f */
    public long m11344f() {
        if (m11341c()) {
            return ((is) this.f8200b).m4683c();
        }
        return ((C1068i) this.f8200b).m2304s();
    }

    /* renamed from: g */
    public String m11345g() {
        if (m11341c()) {
            return ((is) this.f8200b).m4682b();
        }
        return ((C1068i) this.f8200b).m8230y();
    }

    /* renamed from: h */
    public CloudItemStatus m11346h() {
        if (m11347i()) {
            return CloudItemStatus.CONNECTING_SERVER;
        }
        if (!m11341c()) {
            return CloudItemStatus.LOCAL_UPLOADING;
        }
        if (m11340b() == null) {
            return CloudItemStatus.CLOUD_ONLY;
        }
        if (!m11340b().ao()) {
            return CloudItemStatus.CLOUD_DOWNLOADED;
        }
        if (m11340b().m4233i() == BookState.CLOUD_ONLY) {
            return CloudItemStatus.CLOUD_BOOKSHELF;
        }
        if (m11340b().m4233i() != BookState.NORMAL) {
            return CloudItemStatus.CLOUD_DOWNLOADING;
        }
        return CloudItemStatus.CLOUD_DOWNLOADED;
    }

    /* renamed from: a */
    public void m11339a(boolean z) {
        if (m11341c()) {
            ((is) this.f8200b).m4681a(z);
        }
    }

    /* renamed from: i */
    public boolean m11347i() {
        if (m11341c()) {
            return ((is) this.f8200b).m4688h();
        }
        return false;
    }

    /* renamed from: a */
    public int m11336a(CustomCloudItem customCloudItem) {
        if (m11341c()) {
            if (customCloudItem.m11341c()) {
                return Long.valueOf(m11344f()).compareTo(Long.valueOf(customCloudItem.m11344f())) * -1;
            }
            return 1;
        } else if (customCloudItem.m11341c()) {
            return -1;
        } else {
            return Long.valueOf(m11344f()).compareTo(Long.valueOf(customCloudItem.m11344f())) * -1;
        }
    }

    /* renamed from: a */
    public static List<CustomCloudItem> m11334a(List<CustomCloudItem> list, List<bi> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return list;
        }
        List<CustomCloudItem> arrayList = new ArrayList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.m11341c()) {
                Object obj;
                bi a = ((is) customCloudItem.m11337a()).m4680a();
                for (bi a2 : list2) {
                    if (a2.m8151a(a)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    arrayList.add(customCloudItem);
                }
            } else {
                arrayList.add(customCloudItem);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<CustomCloudItem> m11335b(List<CustomCloudItem> list, List<C1068i> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return list;
        }
        List<CustomCloudItem> arrayList = new ArrayList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.m11341c()) {
                arrayList.add(customCloudItem);
            } else {
                Object obj;
                C1068i c1068i = (C1068i) customCloudItem.m11337a();
                for (C1068i a : list2) {
                    if (a.m8224a(c1068i)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    arrayList.add(customCloudItem);
                }
            }
        }
        return arrayList;
    }
}
