package com.duokan.reader.ui.bookshelf;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.sys.ah;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import com.duokan.reader.ReaderEnv.OnBookShelfTypeChangedListener;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.bookshelf.iw;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.general.LoadingCircleView;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class c extends dg implements OnBookShelfTypeChangedListener, iv, iw, ct {
    private final g a = new g(getContext());
    private final FrameLayout b;
    private final LoadingCircleView c;
    private boolean d = false;

    public c(IFeature featrue) {
        super(featrue);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.a);
        this.b = new FrameLayout(getContext());
        this.b.setBackgroundColor(-1);
        this.b.setClickable(true);
        this.c = new LoadingCircleView(getContext());
        this.b.addView(this.c, new LayoutParams(-2, -2, 17));
        this.b.setVisibility(4);
        frameLayout.addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        setContentView(frameLayout);
    }

    public int[] getVisibleItemIndices() {
        return this.a.getVisibleItemIndices();
    }

    public Rect a(int i) {
        return this.a.a(i);
    }

    public int getItemCount() {
        return this.a.getItemCount();
    }

    public cz b(int i) {
        return this.a.b(i);
    }

    public cz getDraggingItemView() {
        return this.a.getDraggingItemView();
    }

    public an c(int i) {
        return this.a.c(i);
    }

    public void a(an anVar, boolean z) {
        this.a.a(anVar, z);
    }

    public void a(an anVar, int i) {
        this.a.a(anVar, i);
    }

    public void a(aa aaVar, an anVar) {
        this.a.a(aaVar, anVar);
    }

    public void a(an anVar, an anVar2, int i) {
        this.a.a(anVar, anVar2, i);
    }

    public void a(Rect rect) {
        this.a.a(rect);
    }

    public boolean c_() {
        return this.a.c_();
    }

    public boolean d_() {
        return this.a.d_();
    }

    public void a(int i, int i2) {
        this.a.a(i, i2);
    }

    public void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.a.a(i, i2, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.a.getContentScrollY();
    }

    public boolean a(int i, cz czVar) {
        return this.a.a(i, czVar);
    }

    public void a(an anVar) {
        this.a.a(anVar);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ReaderEnv.get().addOnBookShelfTypeChangedListener(this);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((cr) getContext().queryFeature(cr.class)).a((ct) this);
        ai.a().a((iv) this);
        ai.a().a((iw) this);
        if (z) {
            kp.a().b(false);
        } else if (PersonalPrefs.a().m()) {
            kp.a().b(true);
        }
        if (this.a != null) {
            this.a.i();
            if (z) {
                a(ReaderEnv.get().getBookShelfType());
            }
        }
        if (this.a != null && this.a.getItemsCount() >= 10) {
            ((p) getContext().queryFeature(p.class)).a(getContext(), UserInput.CREATE_BOOK_CATEGORY);
        }
        if (!ai.a().g() && ReaderEnv.get().needAddNewbieBook()) {
            ReaderEnv.get().setNeedAddNewbieBook(false);
            if (i.f().b()) {
                ai.a().a(true, true);
            }
        }
        if (ReaderEnv.get().needAddNewbieBook() && ai.a().g()) {
            ReaderEnv.get().setNeedAddNewbieBook(false);
            this.d = true;
            this.b.setVisibility(0);
            ah.b(new d(this));
            return;
        }
        this.c.clearAnimation();
    }

    protected void onDeactive() {
        super.onDeactive();
        ((cr) getContext().queryFeature(cr.class)).b(this);
        ai.a().b((iv) this);
        ai.a().b((iw) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ReaderEnv.get().removeOnBookShelfTypeChangedListener(this);
    }

    public void onItemsChanged() {
        if (!this.d) {
            this.a.e();
        }
    }

    public void onItemChanged(an anVar, int i) {
        if ((i & -705) != 0 && !this.d) {
            this.a.e();
        }
    }

    public void onBookShelfTypeChanged(BookShelfType bookShelfType) {
        a(0, 0, 0, null, null);
        a(bookShelfType);
    }

    public void c() {
        this.a.e();
    }

    private void a(BookShelfType bookShelfType) {
        if (BookShelfType.Tradition == bookShelfType) {
            this.a.h();
        }
        this.a.e();
    }

    private int d() {
        int g = PersonalPrefs.a().g();
        if (g == 1) {
            return com.duokan.c.i.male_newbie_books;
        }
        if (g == 2) {
            return com.duokan.c.i.female_newbie_books;
        }
        return com.duokan.c.i.newbie_books;
    }

    private boolean a(File file, ai aiVar, LinkedHashMap linkedHashMap) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return false;
        }
        try {
            List arrayList = new ArrayList(linkedHashMap.size());
            for (String str : linkedHashMap.keySet()) {
                JSONObject jSONObject = new JSONObject(DkPublic.readFile(new File(file + "/BookInfos/" + str, "detail.json")));
                if (((Integer) linkedHashMap.get(str)).intValue() == 0) {
                    arrayList.add(new DkStoreBookDetail(v.a(jSONObject.getJSONObject("book"))));
                } else if (((Integer) linkedHashMap.get(str)).intValue() == 1) {
                    arrayList.add(new DkStoreFictionDetail(v.b(jSONObject.getJSONObject("item"))));
                    DkPublic.unzipRawResource(ManagedApp.get(), com.duokan.c.i.raw__shared__serial_book_files, new File(file + "/Cloud/" + str));
                } else {
                    arrayList.add(new DkStoreFictionDetail(v.b(jSONObject.getJSONObject("item"))));
                }
            }
            return aiVar.c(arrayList);
        } catch (Throwable th) {
            return false;
        }
    }

    public void a(boolean z) {
        this.a.setHeaderViewEnable(z);
    }
}
