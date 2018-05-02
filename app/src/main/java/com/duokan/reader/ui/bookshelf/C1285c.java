package com.duokan.reader.ui.bookshelf;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.sys.ah;
import com.duokan.p024c.C0257i;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.OnBookShelfTypeChangedListener;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.bookshelf.iq;
import com.duokan.reader.domain.bookshelf.lb;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.general.LoadingCircleView;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.ui.bookshelf.c */
public class C1285c extends dn implements OnBookShelfTypeChangedListener, ip, iq, cy {
    /* renamed from: a */
    private final C1290g f6237a = new C1290g(getContext());
    /* renamed from: b */
    private final FrameLayout f6238b;
    /* renamed from: c */
    private final LoadingCircleView f6239c;
    /* renamed from: d */
    private boolean f6240d = false;

    public C1285c(IFeature mFeature) {
        super(mFeature);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.f6237a);
        this.f6238b = new FrameLayout(getContext());
        this.f6238b.setBackgroundColor(-1);
        this.f6238b.setClickable(true);
        this.f6239c = new LoadingCircleView(getContext());
        this.f6238b.addView(this.f6239c, new LayoutParams(-2, -2, 17));
        this.f6238b.setVisibility(4);
        frameLayout.addView(this.f6238b, new ViewGroup.LayoutParams(-1, -1));
        setContentView(frameLayout);
    }

    public int[] getVisibleItemIndices() {
        return this.f6237a.getVisibleItemIndices();
    }

    /* renamed from: a */
    public Rect mo1661a(int i) {
        return this.f6237a.mo1661a(i);
    }

    public int getItemCount() {
        return this.f6237a.getItemCount();
    }

    /* renamed from: b */
    public de mo1670b(int i) {
        return this.f6237a.mo1670b(i);
    }

    public de getDraggingItemView() {
        return this.f6237a.getDraggingItemView();
    }

    /* renamed from: c */
    public an mo1671c(int i) {
        return this.f6237a.mo1671c(i);
    }

    /* renamed from: a */
    public void mo1668a(an anVar, boolean z) {
        this.f6237a.mo1668a(anVar, z);
    }

    /* renamed from: a */
    public void mo1666a(an anVar, int i) {
        this.f6237a.mo1666a(anVar, i);
    }

    /* renamed from: a */
    public void mo1665a(aa aaVar, an anVar) {
        this.f6237a.mo1665a(aaVar, anVar);
    }

    /* renamed from: a */
    public void mo1667a(an anVar, an anVar2, int i) {
        this.f6237a.mo1667a(anVar, anVar2, i);
    }

    /* renamed from: a */
    public void mo1664a(Rect rect) {
        this.f6237a.mo1664a(rect);
    }

    public boolean d_() {
        return this.f6237a.d_();
    }

    public boolean e_() {
        return this.f6237a.e_();
    }

    /* renamed from: a */
    public void mo1662a(int i, int i2) {
        this.f6237a.mo1662a(i, i2);
    }

    /* renamed from: a */
    public void mo1663a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f6237a.mo1663a(i, i2, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.f6237a.getContentScrollY();
    }

    /* renamed from: a */
    public boolean mo1669a(int i, de deVar) {
        return this.f6237a.mo1669a(i, deVar);
    }

    /* renamed from: a */
    public void m9343a(an anVar) {
        this.f6237a.m9680a(anVar);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ReaderEnv.get().addOnBookShelfTypeChangedListener(this);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((cw) getContext().queryFeature(cw.class)).m9437a((cy) this);
        ai.m3980a().m3889a((ip) this);
        ai.m3980a().m3890a((iq) this);
        if (z) {
            lb.m4896a().m4922b(false);
        } else if (PersonalPrefs.m5175a().m5237m()) {
            lb.m4896a().m4922b(true);
        }
        if (this.f6237a != null) {
            this.f6237a.m9699f();
            this.f6237a.m9702i();
            if (z) {
                m9330a(ReaderEnv.get().getBookShelfType());
            }
        }
        if (this.f6237a != null && this.f6237a.getItemsCount() >= 10) {
            ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.CREATE_BOOK_CATEGORY);
        }
        if (!ai.m3980a().m3930g() && ReaderEnv.get().needAddNewbieBook()) {
            ReaderEnv.get().setNeedAddNewbieBook(false);
            if (C0709k.m3476a().m3507c()) {
                ai.m3980a().mo973a(true, true);
            }
        }
        if (ReaderEnv.get().needAddNewbieBook() && ai.m3980a().m3930g()) {
            ReaderEnv.get().setNeedAddNewbieBook(false);
            this.f6240d = true;
            this.f6238b.setVisibility(0);
            ah.m871b(new C1286d(this));
            return;
        }
        this.f6239c.clearAnimation();
    }

    protected void onDeactive() {
        super.onDeactive();
        if (this.f6237a != null) {
            this.f6237a.m9700g();
        }
        ((cw) getContext().queryFeature(cw.class)).m9442b(this);
        ai.m3980a().m3912b((ip) this);
        ai.m3980a().m3913b((iq) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ReaderEnv.get().removeOnBookShelfTypeChangedListener(this);
    }

    public void onItemsChanged() {
        if (!this.f6240d) {
            this.f6237a.m9696c();
        }
    }

    public void onItemChanged(an anVar, int i) {
        if ((i & -705) != 0 && !this.f6240d) {
            this.f6237a.m9696c();
        }
    }

    public void onBookShelfTypeChanged(BookShelfType bookShelfType) {
        mo1663a(0, 0, 0, null, null);
        m9330a(bookShelfType);
    }

    /* renamed from: c */
    public void mo1672c() {
        this.f6237a.m9696c();
    }

    /* renamed from: a */
    private void m9330a(BookShelfType bookShelfType) {
        if (BookShelfType.Tradition == bookShelfType) {
            this.f6237a.m9701h();
        }
        this.f6237a.m9696c();
    }

    /* renamed from: d */
    private int m9336d() {
        int g = PersonalPrefs.m5175a().m5229g();
        if (g == 1) {
            return C0257i.male_newbie_books;
        }
        if (g == 2) {
            return C0257i.female_newbie_books;
        }
        return C0257i.newbie_books;
    }

    /* renamed from: a */
    private boolean m9333a(File file, ai aiVar, LinkedHashMap<String, Integer> linkedHashMap) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return false;
        }
        try {
            List arrayList = new ArrayList(linkedHashMap.size());
            List arrayList2 = new ArrayList();
            for (String str : linkedHashMap.keySet()) {
                JSONObject jSONObject = new JSONObject(DkPublic.readFile(new File(file + "/BookInfos/" + str, "detail.json")));
                int optInt = jSONObject.optInt("free", 0);
                if (((Integer) linkedHashMap.get(str)).intValue() == 0) {
                    DkStoreBookDetail dkStoreBookDetail = new DkStoreBookDetail(C0647u.m3009a(jSONObject.getJSONObject("book")));
                    arrayList.add(dkStoreBookDetail);
                    if (optInt == 1) {
                        arrayList2.add(dkStoreBookDetail);
                    }
                } else if (((Integer) linkedHashMap.get(str)).intValue() == 1) {
                    DkStoreFictionDetail dkStoreFictionDetail = new DkStoreFictionDetail(C0647u.m3013b(jSONObject.getJSONObject("item")));
                    arrayList.add(dkStoreFictionDetail);
                    if (optInt == 1) {
                        arrayList2.add(dkStoreFictionDetail);
                    }
                    DkPublic.unzipRawResource(ManagedApp.get(), C0257i.raw__shared__serial_book_files, new File(file + "/Cloud/" + str));
                } else {
                    DkStoreFictionDetail dkStoreFictionDetail2 = new DkStoreFictionDetail(C0647u.m3013b(jSONObject.getJSONObject("item")));
                    arrayList.add(dkStoreFictionDetail2);
                    if (optInt == 1) {
                        arrayList2.add(dkStoreFictionDetail2);
                    }
                }
            }
            return aiVar.m3903a(arrayList, arrayList2);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public void m9347a(boolean z) {
        this.f6237a.setHeaderViewEnable(z);
    }
}
