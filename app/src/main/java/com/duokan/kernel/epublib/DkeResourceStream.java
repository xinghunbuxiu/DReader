package com.duokan.kernel.epublib;

import java.nio.ByteBuffer;

public interface DkeResourceStream extends Cloneable {
    DkeResourceStream clone();

    void close();

    long getLength();

    boolean isLowQuality();

    boolean isOpen();

    int read(ByteBuffer byteBuffer, long j);
}
