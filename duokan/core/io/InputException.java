package com.duokan.core.io;

import java.io.IOException;

public class InputException extends IOException {
    public InputException(String str) {
        super(str);
    }

    public InputException(Throwable th) {
        super(th);
    }
}
