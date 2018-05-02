package com.duokan.reader.domain.social.message;

class as implements aa {
    final /* synthetic */ int[] a;
    final /* synthetic */ aa b;
    final /* synthetic */ ar c;

    as(ar arVar, int[] iArr, aa aaVar) {
        this.c = arVar;
        this.a = iArr;
        this.b = aaVar;
    }

    public void a(boolean z) {
        boolean z2 = true;
        int[] iArr = this.a;
        iArr[0] = iArr[0] + 1;
        if (z) {
            iArr = this.a;
            iArr[1] = iArr[1] + 1;
        }
        if (this.a[0] == this.c.a.size()) {
            aa aaVar = this.b;
            if (this.a[1] != this.c.a.size()) {
                z2 = false;
            }
            aaVar.a(z2);
        }
    }
}
