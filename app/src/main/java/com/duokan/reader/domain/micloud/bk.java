package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.util.Log;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.C0530h;
import com.duokan.reader.common.webservices.C0660l;
import com.duokan.reader.domain.micloud.p046a.C1044a;
import com.duokan.reader.domain.micloud.p046a.C1056m;
import com.duokan.reader.domain.micloud.p046a.C1057n;
import com.duokan.reader.domain.micloud.p046a.C1058o;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bk extends be<bl> {
    /* renamed from: a */
    private final ad f5254a;

    public bk(Context context, bl blVar, ad adVar) {
        super(context, blVar, new C0530h());
        this.f5254a = adVar;
    }

    /* renamed from: a */
    protected C0525e mo1491a(ExtendedAuthToken extendedAuthToken) {
        return m8171b(extendedAuthToken);
    }

    /* renamed from: b */
    private C0525e m8171b(ExtendedAuthToken extendedAuthToken) {
        if (!((bl) mo734b()).m2300o()) {
            return C0525e.m2310b(-2, true, true);
        }
        try {
            C0660l a = new C1044a(((bl) mo734b()).m8140N(), extendedAuthToken, ((bl) mo734b()).m8141O()).m8015a();
            C1058o c1058o = (C1058o) a.f2216c;
            if (!a.m3100a()) {
                return C0525e.m2308a(a.f2214a, a.f2215b, true, true);
            }
            this.f5254a.mo1483a(c1058o.f5180a);
            m2261a(0, 100);
            return m8169a(this.f5254a.mo1480a(((bl) mo734b()).m8175w()), extendedAuthToken);
        } catch (Throwable e) {
            Log.e("micloud", "", e);
            return C0525e.m2311c(-10008, false, false);
        } catch (Throwable e2) {
            Log.e("micloud", "", e2);
            return C0525e.m2311c(-40001, true, false);
        } catch (Throwable e22) {
            Log.e("micloud", "", e22);
            return C0525e.m2311c(-40003, true, false);
        } catch (Throwable e222) {
            Log.e("micloud", "", e222);
            return C0525e.m2311c(-40002, true, true);
        } catch (Throwable e2222) {
            Log.e("micloud", "", e2222);
            return C0525e.m2311c(ay.m8102b(e2222), true, true);
        }
    }

    /* renamed from: a */
    private C0525e m8169a(bi biVar, ExtendedAuthToken extendedAuthToken) {
        if (!((bl) mo734b()).m2300o()) {
            return C0525e.m2310b(-2, true, true);
        }
        try {
            C0660l a = new C1044a(((bl) mo734b()).m8140N(), extendedAuthToken, ((bl) mo734b()).m8141O()).m8016a(((bl) mo734b()).m8175w());
            C1056m c1056m = (C1056m) a.f2216c;
            if (a.m3100a()) {
                bi biVar2 = c1056m.f5178a;
                if (biVar2.m8157g()) {
                    this.f5254a.mo1482a(biVar2);
                    Queue linkedList = new LinkedList();
                    linkedList.add(biVar2);
                    Object arrayList = new ArrayList();
                    while (!linkedList.isEmpty()) {
                        if (!((bl) mo734b()).m2300o()) {
                            return C0525e.m2310b(-2, true, true);
                        }
                        bi biVar3 = (bi) linkedList.poll();
                        C0525e a2 = m8170a(extendedAuthToken, biVar3, arrayList);
                        if (a2.m2313b()) {
                            if (((bl) mo734b()).m8176x()) {
                                Collection arrayList2 = new ArrayList(arrayList.size());
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    biVar2 = (bi) it.next();
                                    if (biVar2.m8156f()) {
                                        arrayList2.add(biVar2);
                                    } else if (!((bl) mo734b()).m8177y()) {
                                        arrayList2.add(biVar2);
                                    }
                                }
                                this.f5254a.mo1484a(biVar3.m8162l(), arrayList2);
                            } else {
                                this.f5254a.mo1484a(biVar3.m8162l(), arrayList);
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    biVar2 = (bi) it2.next();
                                    if (!biVar2.m8156f()) {
                                        linkedList.add(biVar2);
                                    }
                                }
                            }
                            biVar3.m8165o();
                            this.f5254a.mo1482a(biVar3);
                        } else if (a2.f1775c != 50202) {
                            return a2;
                        } else {
                            this.f5254a.mo1485a(Arrays.asList(new bi[]{biVar3}));
                        }
                    }
                    m2261a(100, 100);
                    return C0525e.m2309a(0, true, true);
                }
                this.f5254a.mo1487c(((bl) mo734b()).m8175w());
                if (biVar != null) {
                    this.f5254a.mo1485a(Arrays.asList(new bi[]{biVar}));
                }
                m2261a(100, 100);
                return C0525e.m2309a(0, true, true);
            } else if (a.f2214a != 50202) {
                return C0525e.m2308a(a.f2214a, a.f2215b, true, true);
            } else {
                this.f5254a.mo1487c(((bl) mo734b()).m8175w());
                if (biVar != null) {
                    this.f5254a.mo1485a(Arrays.asList(new bi[]{biVar}));
                }
                m2261a(100, 100);
                return C0525e.m2309a(0, true, true);
            }
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
            return C0525e.m2311c(-40002, true, true);
        } catch (Throwable e22222) {
            Log.e("micloud", "", e22222);
            return C0525e.m2311c(ay.m8102b(e22222), true, true);
        }
    }

    /* renamed from: a */
    private C0525e m8170a(ExtendedAuthToken extendedAuthToken, bi biVar, List<bi> list) {
        list.clear();
        C1044a c1044a = new C1044a(((bl) mo734b()).m8140N(), extendedAuthToken, ((bl) mo734b()).m8141O());
        int i = 0;
        while (((bl) mo734b()).m2300o()) {
            try {
                C0660l a = c1044a.m8018a(biVar.m8154d(), biVar.m8162l(), i, 1000);
                C1057n c1057n = (C1057n) a.f2216c;
                if (a.m3100a()) {
                    Iterator it = c1057n.f5179a.iterator();
                    while (it.hasNext()) {
                        boolean z;
                        bi biVar2 = (bi) it.next();
                        for (bi d : list) {
                            if (d.m8154d().equals(biVar2.m8154d())) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                        if (!z) {
                            list.add(biVar2);
                        }
                    }
                    if (c1057n.f5179a.isEmpty()) {
                        return C0525e.m2309a(0, true, true);
                    }
                    i = list.size();
                } else if (a.f2214a != 50202) {
                    return C0525e.m2308a(a.f2214a, a.f2215b, true, true);
                } else {
                    list.clear();
                    return C0525e.m2308a(50202, a.f2215b, false, false);
                }
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
                return C0525e.m2311c(-40002, true, true);
            } catch (Throwable e22222) {
                Log.e("micloud", "", e22222);
                return C0525e.m2311c(ay.m8102b(e22222), true, true);
            }
        }
        return C0525e.m2310b(-2, true, true);
    }
}
