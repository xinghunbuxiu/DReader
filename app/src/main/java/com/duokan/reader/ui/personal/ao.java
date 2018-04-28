package com.duokan.reader.ui.personal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.common.C0267i;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.ah;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.bookshelf.gu;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ef;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.LinkedList;
import java.util.List;

public class ao extends hd {
    /* renamed from: a */
    private Context f8270a;
    /* renamed from: c */
    private String f8271c;
    /* renamed from: d */
    private final ei f8272d;
    /* renamed from: e */
    private List<CustomCloudItem> f8273e = new LinkedList();

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return m11418h(i);
    }

    public ao(Context context) {
        this.f8270a = context;
        this.f8272d = (ei) AppContext.getAppContext(context).queryFeature(ei.class);
    }

    /* renamed from: a */
    public void m11409a(List<CustomCloudItem> list) {
        m11410a((List) list, null);
    }

    /* renamed from: a */
    public void m11410a(List<CustomCloudItem> list, String str) {
        if (list != this.f8273e) {
            this.f8273e.clear();
        }
        this.f8273e = list;
        this.f8271c = str;
        m8785a(false);
    }

    /* renamed from: n */
    public List<CustomCloudItem> m11420n() {
        return this.f8273e;
    }

    /* renamed from: o */
    public String m11421o() {
        return this.f8271c;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8273e.size();
    }

    /* renamed from: h */
    public CustomCloudItem m11418h(int i) {
        return (CustomCloudItem) this.f8273e.get(i);
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        return true;
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8273e.clear();
    }

    /* renamed from: k */
    protected int mo1867k() {
        return 1;
    }

    /* renamed from: f */
    protected int mo1866f(int i) {
        return mo506c();
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (mo1714f() == ViewMode.Edit) {
            if (view == null || (view instanceof CustomCloudItemView)) {
                view = LayoutInflater.from(this.f8270a).inflate(C0256h.bookshelf__custom_cloud_item_simple_view, null);
            }
        } else if (view == null || !(view instanceof CustomCloudItemView)) {
            view = LayoutInflater.from(this.f8270a).inflate(C0256h.bookshelf__custom_cloud_item_view, null);
        }
        m11403a(view, m11418h(i), i);
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f8270a).inflate(C0256h.personal__custom_cloud_empty_view, viewGroup, false);
    }

    /* renamed from: a */
    public void m11408a(ef efVar, C1068i c1068i, boolean z) {
        if (c1068i != null && mo1714f() != ViewMode.Edit) {
            for (int i = 0; i < efVar.mo1791a(); i++) {
                View a = efVar.mo1792a(i);
                if (a != null) {
                    Object tag = a.getTag();
                    if (tag != null && (tag instanceof CustomCloudItem)) {
                        CustomCloudItem customCloudItem = (CustomCloudItem) tag;
                        if (customCloudItem.m11341c()) {
                            continue;
                        } else {
                            C1068i c1068i2 = (C1068i) customCloudItem.m11337a();
                            if (c1068i.m2285b().equals(c1068i2.m2285b())) {
                                if (z) {
                                    mo1691d();
                                    return;
                                }
                                ah a2 = BookActionAssistant.m9056a(this.f8270a, c1068i2);
                                ((BookActionView) a.findViewById(C0255g.bookshelf__custom_cloud_item_view__action)).m9063a(a2.f6093a, a2.f6095c);
                                DkLabelView dkLabelView;
                                if (a2.f6093a == BookAction.UPLOADING) {
                                    dkLabelView = (DkLabelView) a.findViewById(C0255g.bookshelf__custom_cloud_item_view__split);
                                    DkLabelView dkLabelView2 = (DkLabelView) a.findViewById(C0255g.bookshelf__custom_cloud_item_view__left_attr);
                                    DkLabelView dkLabelView3 = (DkLabelView) a.findViewById(C0255g.bookshelf__custom_cloud_item_view__right_attr);
                                    dkLabelView3.setVisibility(0);
                                    dkLabelView.setVisibility(0);
                                    dkLabelView3.setText(C0267i.m599a(c1068i2.m8217M()));
                                    dkLabelView2.setText(String.format(this.f8270a.getString(C0258j.bookshelf__cloud_books_view__uploading_schedule), new Object[]{Math.round(a2.f6095c * 100.0f) + "%"}));
                                    return;
                                } else if (a2.f6093a == BookAction.UPLOAD_FAILED || a2.f6093a == BookAction.UPLOAD_PAUSED) {
                                    DkLabelView dkLabelView4 = (DkLabelView) a.findViewById(C0255g.bookshelf__custom_cloud_item_view__split);
                                    dkLabelView = (DkLabelView) a.findViewById(C0255g.bookshelf__custom_cloud_item_view__left_attr);
                                    ((DkLabelView) a.findViewById(C0255g.bookshelf__custom_cloud_item_view__right_attr)).setVisibility(4);
                                    dkLabelView4.setVisibility(4);
                                    dkLabelView.setText(a2.f6094b);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m11403a(View view, CustomCloudItem customCloudItem, int i) {
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(C0255g.bookshelf__custom_cloud_item_view__cover);
        ((DkLabelView) view.findViewById(C0255g.bookshelf__custom_cloud_item_view__name)).setText(ReaderUi.m10156a(C0267i.m611d(customCloudItem.m11345g()), this.f8271c, this.f8270a.getResources().getColor(C0252d.general__shared__ed6c00)));
        C0800c b = customCloudItem.m11340b();
        if (b == null || BookActionAssistant.m9055a(this.f8270a, b).f6093a != BookAction.READ) {
            bookCoverView.setCoverForegroundDrawable(this.f8270a.getResources().getDrawable(gu.m9743b(FileTypeRecognizer.m567a(customCloudItem.m11345g()))));
        } else {
            bookCoverView.setCover(b);
            bookCoverView.m9919a();
        }
        m11406b(view, customCloudItem, i);
        view.setTag(customCloudItem);
    }

    /* renamed from: a */
    private void m11402a(Activity activity, C1068i c1068i, BookAction bookAction) {
        if (bookAction == BookAction.UPLOADING) {
            it.m4692a().m4729b(c1068i);
        } else {
            be.m9189b(activity, c1068i.m8207C(), new ap(this, activity, bookAction, c1068i));
        }
    }

    /* renamed from: b */
    private void m11406b(View view, CustomCloudItem customCloudItem, int i) {
        ah ahVar;
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(C0255g.bookshelf__custom_cloud_item_view__split);
        DkLabelView dkLabelView2 = (DkLabelView) view.findViewById(C0255g.bookshelf__custom_cloud_item_view__left_attr);
        DkLabelView dkLabelView3 = (DkLabelView) view.findViewById(C0255g.bookshelf__custom_cloud_item_view__right_attr);
        BookActionView bookActionView = (BookActionView) view.findViewById(C0255g.bookshelf__custom_cloud_item_view__action);
        CloudItemStatus h = customCloudItem.m11346h();
        dkLabelView2.setVisibility(0);
        dkLabelView3.setVisibility(0);
        dkLabelView.setVisibility(0);
        if (customCloudItem.m11341c()) {
            ah a = BookActionAssistant.m9055a(this.f8270a, customCloudItem.m11340b());
            if (a.f6093a == BookAction.DOWNLOAD_FAILED || a.f6093a == BookAction.DOWNLOAD_PAUSED) {
                dkLabelView3.setVisibility(4);
                dkLabelView.setVisibility(4);
                dkLabelView2.setText(a.f6094b);
                ahVar = a;
            } else {
                dkLabelView2.setText(C0267i.m599a(customCloudItem.m11343e()));
                dkLabelView3.setText(ReaderUi.m10159a(this.f8270a, customCloudItem.m11344f(), false));
                ahVar = a;
            }
        } else {
            C1068i c1068i = (C1068i) customCloudItem.m11337a();
            ah a2 = BookActionAssistant.m9056a(this.f8270a, c1068i);
            if (a2.f6093a == BookAction.UPLOAD_FAILED || a2.f6093a == BookAction.UPLOAD_PAUSED) {
                dkLabelView3.setVisibility(4);
                dkLabelView.setVisibility(4);
                dkLabelView2.setText(a2.f6094b);
                ahVar = a2;
            } else {
                dkLabelView3.setText(C0267i.m599a(c1068i.m8217M()));
                dkLabelView2.setText(String.format(this.f8270a.getString(C0258j.bookshelf__cloud_books_view__uploading_schedule), new Object[]{Math.round(customCloudItem.m11342d() * 100.0f) + "%"}));
                ahVar = a2;
            }
        }
        if (mo1714f() == ViewMode.Edit) {
            bookActionView.m9064a(BookAction.EDIT, mo1713b(0, i));
            return;
        }
        if (h == CloudItemStatus.LOCAL_UPLOADING) {
            if (ahVar != null) {
                bookActionView.m9063a(ahVar.f6093a, ahVar.f6095c);
            }
        } else if (h == CloudItemStatus.CLOUD_DOWNLOADED) {
            bookActionView.setAction(BookAction.READ);
        } else if (h == CloudItemStatus.CLOUD_DOWNLOADING) {
            if (ahVar != null) {
                bookActionView.m9063a(ahVar.f6093a, ahVar.f6095c);
            }
        } else if (h == CloudItemStatus.CLOUD_ONLY || h == CloudItemStatus.CLOUD_BOOKSHELF) {
            bookActionView.setAction(BookAction.DOWNLOAD);
        } else if (h == CloudItemStatus.CONNECTING_SERVER) {
            bookActionView.setAction(BookAction.CONNECTING);
        }
        bookActionView.setOnClickListener(new ar(this, h, customCloudItem, bookActionView));
    }
}
