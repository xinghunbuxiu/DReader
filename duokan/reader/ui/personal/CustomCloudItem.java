package com.duokan.reader.ui.personal;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iy;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.i;

import java.util.ArrayList;
import java.util.List;

public class CustomCloudItem {
    private final af a = new af();
    private final Object b;
    private final CloudItemType c;

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

    public CustomCloudItem(iy iyVar) {
        this.b = iyVar;
        this.c = CloudItemType.CLOUD;
    }

    public CustomCloudItem(i iVar) {
        this.b = iVar;
        this.c = CloudItemType.LOCAL;
    }

    public void a(c cVar) {
        this.a.a((Object) cVar);
    }

    public Object a() {
        return this.b;
    }

    public c b() {
        if (this.c != CloudItemType.CLOUD) {
            return null;
        }
        if (!this.a.b()) {
            this.a.a(ai.a().a((iy) this.b));
        }
        return (c) this.a.a();
    }

    public boolean c() {
        return this.c == CloudItemType.CLOUD;
    }

    public float d() {
        CloudItemStatus h = h();
        if (h == CloudItemStatus.CLOUD_DOWNLOADING && b() != null) {
            return (b().m() * 1.0f) / 100.0f;
        }
        if (h != CloudItemStatus.LOCAL_UPLOADING) {
            return -1.0f;
        }
        i iVar = (i) this.b;
        return (((float) iVar.F()) * 1.0f) / ((float) iVar.C());
    }

    public long e() {
        if (c()) {
            return ((iy) this.b).d();
        }
        return ((i) this.b).C();
    }

    public long f() {
        if (c()) {
            return ((iy) this.b).c();
        }
        return ((i) this.b).s();
    }

    public String g() {
        if (c()) {
            return ((iy) this.b).b();
        }
        return ((i) this.b).y();
    }

    public CloudItemStatus h() {
        if (i()) {
            return CloudItemStatus.CONNECTING_SERVER;
        }
        if (!c()) {
            return CloudItemStatus.LOCAL_UPLOADING;
        }
        if (b() == null) {
            return CloudItemStatus.CLOUD_ONLY;
        }
        if (!b().am()) {
            return CloudItemStatus.CLOUD_DOWNLOADED;
        }
        if (b().i() == BookState.CLOUD_ONLY) {
            return CloudItemStatus.CLOUD_BOOKSHELF;
        }
        if (b().i() != BookState.NORMAL) {
            return CloudItemStatus.CLOUD_DOWNLOADING;
        }
        return CloudItemStatus.CLOUD_DOWNLOADED;
    }

    public void a(boolean z) {
        if (c()) {
            ((iy) this.b).a(z);
        }
    }

    public boolean i() {
        if (c()) {
            return ((iy) this.b).h();
        }
        return false;
    }

    public int a(CustomCloudItem customCloudItem) {
        if (c()) {
            if (customCloudItem.c()) {
                return Long.valueOf(f()).compareTo(Long.valueOf(customCloudItem.f())) * -1;
            }
            return 1;
        } else if (customCloudItem.c()) {
            return -1;
        } else {
            return Long.valueOf(f()).compareTo(Long.valueOf(customCloudItem.f())) * -1;
        }
    }

    public static List a(List list, List list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return list;
        }
        List arrayList = new ArrayList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.c()) {
                Object obj;
                bi a = ((iy) customCloudItem.a()).a();
                for (bi a2 : list2) {
                    if (a2.a(a)) {
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

    public static List b(List list, List list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return list;
        }
        List arrayList = new ArrayList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.c()) {
                arrayList.add(customCloudItem);
            } else {
                Object obj;
                i iVar = (i) customCloudItem.a();
                for (i a : list2) {
                    if (a.a(iVar)) {
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
