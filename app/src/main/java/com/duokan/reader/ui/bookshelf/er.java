package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.duokan.c.j;
import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.HatGridView;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.eh;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class er extends LinearLayout {
    private static final Comparator i = new es();
    private final HatGridView a;
    private final ex b;
    private final DkLabelView c;
    private final String d;
    private String e;
    private final gf f;
    private fb g;
    private Map h = new HashMap();

    public er(Context context, Runnable runnable) {
        super(context);
        setOrientation(1);
        this.b = new ex();
        this.a = new HatGridView(context);
        this.a.setAdapter(this.b);
        this.a.setOnItemClickListener(new et(this));
        eh.a(this.a);
        this.f = new gf(context);
        this.f.setPathGalleryListener(new eu(this));
        View inflate = LayoutInflater.from(context).inflate(h.bookshelf__file_add_view, this, false);
        this.c = (DkLabelView) inflate.findViewById(g.bookshelf__file_add_view__text);
        this.c.setOnClickListener(new ev(this, runnable));
        this.d = getContext().getString(j.import_confirm);
        this.c.setText(String.format(this.d, new Object[]{Integer.valueOf(0)}));
        addView(this.f, new LayoutParams(-1, -2));
        addView(this.a, new LayoutParams(-1, 0, 1.0f));
        addView(inflate, new LayoutParams(-1, -2));
        String lastBrowserPath = getLastBrowserPath();
        this.f.setPath(lastBrowserPath);
        setData(b(lastBrowserPath));
        this.f.setBackgroundColor(getResources().getColor(d.general__shared__ebebeb));
        setBackgroundColor(getResources().getColor(d.general__shared__f7f7f7));
    }

    public void setSelectBrowserFiles(boolean z) {
        this.b.a(z);
    }

    public void setSelectionListener(fb fbVar) {
        this.g = fbVar;
    }

    public boolean a() {
        File parentFile = new File(this.e).getParentFile();
        if (parentFile == null || !parentFile.canRead()) {
            return false;
        }
        this.f.setPath(parentFile.getAbsolutePath());
        setData(b(parentFile.getAbsolutePath()));
        return true;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i && this.a != null) {
            this.a.setNumColumns(eh.a(getContext(), i));
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    private void a(String str) {
        if (this.e != null) {
            if (this.h.containsKey(this.e)) {
                this.h.remove(this.e);
            }
            if (!this.e.contains(str) && this.h.containsKey(str)) {
                this.h.remove(str);
            }
            this.h.put(this.e, Integer.valueOf(this.a.getGridScrollY()));
        }
    }

    private List b(String str) {
        a(str);
        this.e = str;
        List arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, i);
            for (File file : listFiles) {
                if (file.isDirectory() && file.canRead()) {
                    arrayList.add(file);
                } else if (a(file)) {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    private String getLastBrowserPath() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String prefString = ReaderEnv.get().getPrefString(PrivatePref.BOOKSHELF, "file_browser_path", absolutePath);
        if (TextUtils.isEmpty(prefString)) {
            prefString = absolutePath;
        }
        prefString = c(prefString);
        if (TextUtils.isEmpty(prefString)) {
            return c(absolutePath);
        }
        List b = b(prefString);
        if (!new File(prefString).canRead() || b == null || b.isEmpty()) {
            return c(absolutePath);
        }
        return prefString;
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith(File.separator)) {
            str = File.separator + str;
        }
        while (!new File(str).exists()) {
            str = new File(str).getParent();
        }
        return str;
    }

    private void b() {
        ReaderEnv.get().setPrefString(PrivatePref.BOOKSHELF, "file_browser_path", this.e);
        ReaderEnv.get().commitPrefs();
    }

    private boolean a(File file) {
        return (file == null || FileType.UNSUPPORTED == FileTypeRecognizer.a(file.getAbsolutePath())) ? false : true;
    }

    private void a(ImportedFileInfo importedFileInfo) {
        File file = new File(importedFileInfo.c());
        if (file.isDirectory() && file.canRead()) {
            this.f.setPath(file.getAbsolutePath());
            setData(b(file.getAbsolutePath()));
        } else if (file.isFile() && file.canRead()) {
            ((ff) MyContextWrapper.getFeature(getContext()).queryFeature(ff.class)).a(file.getAbsolutePath());
        }
    }

    private void setData(List list) {
        a.a(new ew(this, list), new Void[0]);
    }
}
