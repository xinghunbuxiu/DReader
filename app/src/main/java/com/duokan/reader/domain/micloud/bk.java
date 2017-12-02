package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.util.Log;

import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.async.work.h;
import com.duokan.reader.common.webservices.j;
import com.duokan.reader.domain.micloud.a.a;
import com.duokan.reader.domain.micloud.a.m;
import com.duokan.reader.domain.micloud.a.n;
import com.duokan.reader.domain.micloud.a.o;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import miuipub.date.Calendar;

public class bk extends be {
    private final ad a;

    public bk(Context context, bl blVar, ad adVar) {
        super(context, blVar, new h());
        this.a = adVar;
    }

    protected e a(ExtendedAuthToken extendedAuthToken) {
        return b(extendedAuthToken);
    }

    private e b(ExtendedAuthToken extendedAuthToken) {
        if (!((bl) b()).o()) {
            return e.b(-2, true, true);
        }
        try {
            j a = new a(((bl) b()).N(), extendedAuthToken, ((bl) b()).O()).a();
            o oVar = (o) a.c;
            if (!a.a()) {
                return e.a(a.a, a.b, true, true);
            }
            this.a.a(oVar.a);
            a(0, 100);
            return a(this.a.a(((bl) b()).w()), extendedAuthToken);
        } catch (Throwable e) {
            Log.e("micloud", "", e);
            return e.c(-10008, false, false);
        } catch (Throwable e2) {
            Log.e("micloud", "", e2);
            return e.c(-40001, true, false);
        } catch (Throwable e22) {
            Log.e("micloud", "", e22);
            return e.c(-40003, true, false);
        } catch (Throwable e222) {
            Log.e("micloud", "", e222);
            return e.c(-40002, true, true);
        } catch (Throwable e2222) {
            Log.e("micloud", "", e2222);
            return e.c(ay.b(e2222), true, true);
        }
    }

    private e a(bi biVar, ExtendedAuthToken extendedAuthToken) {
        if (!((bl) b()).o()) {
            return e.b(-2, true, true);
        }
        try {
            j a = new a(((bl) b()).N(), extendedAuthToken, ((bl) b()).O()).a(((bl) b()).w());
            m mVar = (m) a.c;
            if (a.a()) {
                bi biVar2 = mVar.a;
                if (biVar2.g()) {
                    this.a.a(biVar2);
                    Queue linkedList = new LinkedList();
                    linkedList.add(biVar2);
                    Object arrayList = new ArrayList();
                    while (!linkedList.isEmpty()) {
                        if (!((bl) b()).o()) {
                            return e.b(-2, true, true);
                        }
                        bi biVar3 = (bi) linkedList.poll();
                        e a2 = a(extendedAuthToken, biVar3, arrayList);
                        if (a2.b()) {
                            if (((bl) b()).x()) {
                                Collection arrayList2 = new ArrayList(arrayList.size());
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    biVar2 = (bi) it.next();
                                    if (biVar2.f()) {
                                        arrayList2.add(biVar2);
                                    } else if (!((bl) b()).y()) {
                                        arrayList2.add(biVar2);
                                    }
                                }
                                this.a.a(biVar3.l(), arrayList2);
                            } else {
                                this.a.a(biVar3.l(), arrayList);
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    biVar2 = (bi) it2.next();
                                    if (!biVar2.f()) {
                                        linkedList.add(biVar2);
                                    }
                                }
                            }
                            biVar3.o();
                            this.a.a(biVar3);
                        } else if (a2.c != 50202) {
                            return a2;
                        } else {
                            this.a.a(Arrays.asList(new bi[]{biVar3}));
                        }
                    }
                    a(100, 100);
                    return e.a(0, true, true);
                }
                this.a.c(((bl) b()).w());
                if (biVar != null) {
                    this.a.a(Arrays.asList(new bi[]{biVar}));
                }
                a(100, 100);
                return e.a(0, true, true);
            } else if (a.a != 50202) {
                return e.a(a.a, a.b, true, true);
            } else {
                this.a.c(((bl) b()).w());
                if (biVar != null) {
                    this.a.a(Arrays.asList(new bi[]{biVar}));
                }
                a(100, 100);
                return e.a(0, true, true);
            }
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
            return e.c(-40002, true, true);
        } catch (Throwable e22222) {
            Log.e("micloud", "", e22222);
            return e.c(ay.b(e22222), true, true);
        }
    }

    private e a(ExtendedAuthToken extendedAuthToken, bi biVar, List list) {
        list.clear();
        a aVar = new a(((bl) b()).N(), extendedAuthToken, ((bl) b()).O());
        int i = 0;
        while (((bl) b()).o()) {
            try {
                j a = aVar.a(biVar.d(), biVar.l(), i, (int) Calendar.MILLISECOND_OF_SECOND);
                n nVar = (n) a.c;
                if (a.a()) {
                    Iterator it = nVar.a.iterator();
                    while (it.hasNext()) {
                        boolean z;
                        bi biVar2 = (bi) it.next();
                        for (bi d : list) {
                            if (d.d().equals(biVar2.d())) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                        if (!z) {
                            list.add(biVar2);
                        }
                    }
                    if (nVar.a.isEmpty()) {
                        return e.a(0, true, true);
                    }
                    i = list.size();
                } else if (a.a != 50202) {
                    return e.a(a.a, a.b, true, true);
                } else {
                    list.clear();
                    return e.a(50202, a.b, false, false);
                }
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
                return e.c(-40002, true, true);
            } catch (Throwable e22222) {
                Log.e("micloud", "", e22222);
                return e.c(ay.b(e22222), true, true);
            }
        }
        return e.b(-2, true, true);
    }
}
