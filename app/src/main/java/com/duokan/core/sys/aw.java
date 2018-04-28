package com.duokan.core.sys;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicReference;

class aw extends RandomAccessFile {
    /* renamed from: a */
    public final String f667a;
    /* renamed from: b */
    public final AtomicReference<Thread> f668b = new AtomicReference();
    /* renamed from: c */
    public int f669c = 0;

    public aw(File file, String str) {
        super(file, str);
        this.f667a = str;
    }
}
