package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.util.Log;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.C0529q;
import com.duokan.reader.common.webservices.C0660l;
import com.duokan.reader.domain.micloud.p046a.C1044a;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.duokan.reader.domain.micloud.m */
public class C1072m extends be<C1073n> {
    public C1072m(Context context, C1073n c1073n, C0529q<C1073n> c0529q) {
        super(context, c1073n, c0529q);
    }

    /* renamed from: a */
    protected C0525e mo1491a(ExtendedAuthToken extendedAuthToken) {
        try {
            C1044a c1044a = new C1044a(((C1073n) mo734b()).m8140N(), extendedAuthToken, ((C1073n) mo734b()).m8141O());
            ArrayList arrayList = new ArrayList(10);
            List arrayList2 = new ArrayList(10);
            for (int i = 0; i < ((C1073n) mo734b()).m8253w().size(); i++) {
                if (!((C1073n) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                bi biVar = (bi) ((C1073n) mo734b()).m8253w().get(i);
                arrayList.add(biVar);
                arrayList2.add(biVar.m8154d());
                if (i == ((C1073n) mo734b()).m8253w().size() - 1 || arrayList2.size() == 10) {
                    C0660l a = c1044a.m8021a(arrayList2, ((C1073n) mo734b()).m8254x());
                    if (!a.m3100a()) {
                        return C0525e.m2308a(a.f2214a, a.f2215b, true, false);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((C1073n) mo734b()).m8250a((bi) it.next());
                    }
                    m2261a((long) ((C1073n) mo734b()).m8255y().size(), (long) ((C1073n) mo734b()).m8253w().size());
                    m2277j();
                    arrayList.clear();
                    arrayList2.clear();
                }
            }
            return C0525e.m2309a(0, true, true);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e2) {
            Log.e("micloud", "", e2);
            return C0525e.m2311c(-10008, false, false);
        } catch (Throwable e22) {
            Log.e("micloud", "", e22);
            return C0525e.m2311c(-40001, true, false);
        } catch (Throwable e222) {
            Log.e("micloud", "", e222);
            return C0525e.m2311c(-40003, true, false);
        } catch (Throwable e2222) {
            Log.e("micloud", "", e2222);
            return C0525e.m2311c(-40002, true, false);
        } catch (Throwable e22222) {
            Log.e("micloud", "", e22222);
            return C0525e.m2311c(ay.m8102b(e22222), true, false);
        }
    }
}
