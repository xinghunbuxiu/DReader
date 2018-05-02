package com.duokan.reader.domain.bookshelf;

public class ct {
    public int a;
    public String b;
    public int c;
    public cv d;

    public static ct a(int i, String str, String str2) {
        ct ctVar = new ct();
        ctVar.a = i;
        ctVar.b = str;
        ctVar.c = 1;
        cv crVar = new cr();
        crVar.a = str2;
        ctVar.d = crVar;
        return ctVar;
    }

    public static ct a(int i, String str, String str2, String str3) {
        ct ctVar = new ct();
        ctVar.a = i;
        ctVar.b = str;
        ctVar.c = 2;
        cv cuVar = new cu();
        cuVar.a = str2;
        cuVar.b = str3;
        ctVar.d = cuVar;
        return ctVar;
    }

    public static ct a(int i, String str) {
        ct ctVar = new ct();
        ctVar.a = i;
        ctVar.b = str;
        ctVar.c = 3;
        ctVar.d = null;
        return ctVar;
    }
}
