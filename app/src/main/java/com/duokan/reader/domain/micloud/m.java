package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.util.Log;

import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.async.work.q;
import com.duokan.reader.common.webservices.j;
import com.duokan.reader.domain.micloud.a.a;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class m extends be {
    public m(Context context, n nVar, q qVar) {
        super(context, nVar, qVar);
    }

    protected e a(ExtendedAuthToken extendedAuthToken) {
        try {
            a aVar = new a(((n) b()).N(), extendedAuthToken, ((n) b()).O());
            ArrayList arrayList = new ArrayList(10);
            List arrayList2 = new ArrayList(10);
            for (int i = 0; i < ((n) b()).w().size(); i++) {
                if (!((n) b()).o()) {
                    return e.b(-2, true, true);
                }
                bi biVar = (bi) ((n) b()).w().get(i);
                arrayList.add(biVar);
                arrayList2.add(biVar.d());
                if (i == ((n) b()).w().size() - 1 || arrayList2.size() == 10) {
                    j a = aVar.a(arrayList2, ((n) b()).x());
                    if (!a.a()) {
                        return e.a(a.a, a.b, true, false);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((n) b()).a((bi) it.next());
                    }
                    a((long) ((n) b()).y().size(), (long) ((n) b()).w().size());
                    j();
                    arrayList.clear();
                    arrayList2.clear();
                }
            }
            return e.a(0, true, true);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e2) {
            Log.e("micloud", "", e2);
            return e.c(-10008, false, false);
        } catch (Throwable e22) {
            Log.e("micloud", "", e22);
            return e.c(-40001, true, false);
        } catch (Throwable e222) {
            Log.e("micloud", "", e222);
            return e.c(-40003, true, false);
        } catch (Throwable e2222) {
            Log.e("micloud", "", e2222);
            return e.c(-40002, true, false);
        } catch (Throwable e22222) {
            Log.e("micloud", "", e22222);
            return e.c(ay.b(e22222), true, false);
        }
    }
}
