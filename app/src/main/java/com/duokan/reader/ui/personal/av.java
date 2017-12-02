package com.duokan.reader.ui.personal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.c.d;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.core.app.x;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.bookshelf.BookActionAssistant;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.bookshelf.BookActionView;
import com.duokan.reader.ui.bookshelf.ab;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.bookshelf.gn;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.eg;
import com.duokan.reader.ui.general.expandable.ViewMode;

import java.util.LinkedList;
import java.util.List;

public class av extends gw {
    private Context a;
    private String c;
    private final eo d;
    private List e = new LinkedList();

    public /* synthetic */ Object d(int i) {
        return h(i);
    }

    public av(Context context) {
        this.a = context;
        this.d = (eo) x.a(context).queryFeature(eo.class);
    }

    public void a(List list) {
        a(list, null);
    }

    public void a(List list, String str) {
        if (list != this.e) {
            this.e.clear();
        }
        this.e = list;
        this.c = str;
        a(false);
    }

    public List n() {
        return this.e;
    }

    public String o() {
        return this.c;
    }

    public int c() {
        return this.e.size();
    }

    public CustomCloudItem h(int i) {
        return (CustomCloudItem) this.e.get(i);
    }

    protected void e(int i) {
    }

    protected boolean e() {
        return true;
    }

    protected void b() {
        this.e.clear();
    }

    protected int k() {
        return 1;
    }

    protected int f(int i) {
        return c();
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (f() == ViewMode.Edit) {
            if (view == null || (view instanceof CustomCloudItemView)) {
                view = LayoutInflater.from(this.a).inflate(h.bookshelf__custom_cloud_item_simple_view, null);
            }
        } else if (view == null || !(view instanceof CustomCloudItemView)) {
            view = LayoutInflater.from(this.a).inflate(h.bookshelf__custom_cloud_item_view, null);
        }
        a(view, h(i), i);
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.a).inflate(h.personal__custom_cloud_empty_view, viewGroup, false);
    }

    public void a(eg egVar, i iVar, boolean z) {
        if (iVar != null && f() != ViewMode.Edit) {
            for (int i = 0; i < egVar.a(); i++) {
                View a = egVar.a(i);
                if (a != null) {
                    Object tag = a.getTag();
                    if (tag != null && (tag instanceof CustomCloudItem)) {
                        CustomCloudItem customCloudItem = (CustomCloudItem) tag;
                        if (customCloudItem.c()) {
                            continue;
                        } else {
                            i iVar2 = (i) customCloudItem.a();
                            if (iVar.b().equals(iVar2.b())) {
                                if (z) {
                                    d();
                                    return;
                                }
                                ab a2 = BookActionAssistant.a(this.a, iVar2);
                                ((BookActionView) a.findViewById(g.bookshelf__custom_cloud_item_view__action)).a(a2.a, a2.c);
                                DkLabelView dkLabelView;
                                if (a2.a == BookAction.UPLOADING) {
                                    dkLabelView = (DkLabelView) a.findViewById(g.bookshelf__custom_cloud_item_view__split);
                                    DkLabelView dkLabelView2 = (DkLabelView) a.findViewById(g.bookshelf__custom_cloud_item_view__left_attr);
                                    DkLabelView dkLabelView3 = (DkLabelView) a.findViewById(g.bookshelf__custom_cloud_item_view__right_attr);
                                    dkLabelView3.setVisibility(0);
                                    dkLabelView.setVisibility(0);
                                    dkLabelView3.setText(com.duokan.common.i.a(iVar2.M()));
                                    dkLabelView2.setText(String.format(this.a.getString(j.bookshelf__cloud_books_view__uploading_schedule), new Object[]{Math.round(a2.c * 100.0f) + "%"}));
                                    return;
                                } else if (a2.a == BookAction.UPLOAD_FAILED || a2.a == BookAction.UPLOAD_PAUSED) {
                                    DkLabelView dkLabelView4 = (DkLabelView) a.findViewById(g.bookshelf__custom_cloud_item_view__split);
                                    dkLabelView = (DkLabelView) a.findViewById(g.bookshelf__custom_cloud_item_view__left_attr);
                                    ((DkLabelView) a.findViewById(g.bookshelf__custom_cloud_item_view__right_attr)).setVisibility(4);
                                    dkLabelView4.setVisibility(4);
                                    dkLabelView.setText(a2.b);
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

    private void a(View view, CustomCloudItem customCloudItem, int i) {
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(g.bookshelf__custom_cloud_item_view__cover);
        ((DkLabelView) view.findViewById(g.bookshelf__custom_cloud_item_view__name)).setText(ReaderUi.a(com.duokan.common.i.d(customCloudItem.g()), this.c, this.a.getResources().getColor(d.general__shared__ed6c00)));
        c b = customCloudItem.b();
        if (b == null || BookActionAssistant.a(this.a, b).a != BookAction.READ) {
            bookCoverView.setCoverForegroundDrawable(this.a.getResources().getDrawable(gn.b(FileTypeRecognizer.a(customCloudItem.g()))));
        } else {
            bookCoverView.setCover(b);
            bookCoverView.a();
        }
        b(view, customCloudItem, i);
        view.setTag(customCloudItem);
    }

    private void a(Activity activity, i iVar, BookAction bookAction) {
        if (bookAction == BookAction.UPLOADING) {
            iz.a().b(iVar);
        } else {
            ay.b(activity, iVar.C(), new aw(this, activity, bookAction, iVar));
        }
    }

    private void b(View view, CustomCloudItem customCloudItem, int i) {
        ab abVar;
        DkLabelView dkLabelView = (DkLabelView) view.findViewById(g.bookshelf__custom_cloud_item_view__split);
        DkLabelView dkLabelView2 = (DkLabelView) view.findViewById(g.bookshelf__custom_cloud_item_view__left_attr);
        DkLabelView dkLabelView3 = (DkLabelView) view.findViewById(g.bookshelf__custom_cloud_item_view__right_attr);
        BookActionView bookActionView = (BookActionView) view.findViewById(g.bookshelf__custom_cloud_item_view__action);
        CloudItemStatus h = customCloudItem.h();
        dkLabelView2.setVisibility(0);
        dkLabelView3.setVisibility(0);
        dkLabelView.setVisibility(0);
        if (customCloudItem.c()) {
            ab a = BookActionAssistant.a(this.a, customCloudItem.b());
            if (a.a == BookAction.DOWNLOAD_FAILED || a.a == BookAction.DOWNLOAD_PAUSED) {
                dkLabelView3.setVisibility(4);
                dkLabelView.setVisibility(4);
                dkLabelView2.setText(a.b);
                abVar = a;
            } else {
                dkLabelView2.setText(com.duokan.common.i.a(customCloudItem.e()));
                dkLabelView3.setText(ReaderUi.a(this.a, customCloudItem.f(), false));
                abVar = a;
            }
        } else {
            i iVar = (i) customCloudItem.a();
            ab a2 = BookActionAssistant.a(this.a, iVar);
            if (a2.a == BookAction.UPLOAD_FAILED || a2.a == BookAction.UPLOAD_PAUSED) {
                dkLabelView3.setVisibility(4);
                dkLabelView.setVisibility(4);
                dkLabelView2.setText(a2.b);
                abVar = a2;
            } else {
                dkLabelView3.setText(com.duokan.common.i.a(iVar.M()));
                dkLabelView2.setText(String.format(this.a.getString(j.bookshelf__cloud_books_view__uploading_schedule), new Object[]{Math.round(customCloudItem.d() * 100.0f) + "%"}));
                abVar = a2;
            }
        }
        if (f() == ViewMode.Edit) {
            bookActionView.a(BookAction.EDIT, b(0, i));
            return;
        }
        if (h == CloudItemStatus.LOCAL_UPLOADING) {
            if (abVar != null) {
                bookActionView.a(abVar.a, abVar.c);
            }
        } else if (h == CloudItemStatus.CLOUD_DOWNLOADED) {
            bookActionView.setAction(BookAction.READ);
        } else if (h == CloudItemStatus.CLOUD_DOWNLOADING) {
            if (abVar != null) {
                bookActionView.a(abVar.a, abVar.c);
            }
        } else if (h == CloudItemStatus.CLOUD_ONLY || h == CloudItemStatus.CLOUD_BOOKSHELF) {
            bookActionView.setAction(BookAction.DOWNLOAD);
        } else if (h == CloudItemStatus.CONNECTING_SERVER) {
            bookActionView.setAction(BookAction.CONNECTING);
        }
        bookActionView.setOnClickListener(new ay(this, h, customCloudItem, bookActionView));
    }
}
