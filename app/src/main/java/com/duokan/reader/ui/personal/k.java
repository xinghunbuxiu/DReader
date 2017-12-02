package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.io.a;
import com.duokan.reader.ReaderEnv;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class k extends e {
    private m a = new m(getContext());

    public k(y yVar) {
        super(yVar);
        this.a.setStorages(a());
        setContentView(this.a);
    }

    private l[] a() {
        LinkedList linkedList = new LinkedList();
        try {
            String canonicalPath = ReaderEnv.get().getSecondaryFilesDirectory().getParentFile().getCanonicalPath();
            File[] fileArr = (File[]) a.b(getContext()).toArray(new File[0]);
            for (File file : fileArr) {
                l lVar = new l(this);
                lVar.a = file.getName();
                lVar.b = file.getAbsolutePath();
                lVar.c = file.getTotalSpace();
                lVar.d = file.getFreeSpace();
                lVar.e = file.getCanonicalPath().equalsIgnoreCase(canonicalPath);
                linkedList.add(lVar);
            }
            return (l[]) linkedList.toArray(new l[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return (l[]) linkedList.toArray(new l[0]);
        }
    }
}
