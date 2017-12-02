package com.duokan.core.io;

import java.io.IOException;

public class OutputException extends IOException {
    public OutputException(String str) {
        super(str);
    }

    public OutputException(Throwable th) {
        super(th);
    }
}
