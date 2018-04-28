package com.duokan.reader.ui.bookshelf;

class gb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ga f6498a;

    gb(ga gaVar) {
        this.f6498a = gaVar;
    }

    public void run() {
        if (this.f6498a.f6497a.f6475c != null && !this.f6498a.f6497a.f6476d.contains(this.f6498a.f6497a.f6475c)) {
            this.f6498a.f6497a.f6476d.add(this.f6498a.f6497a.f6475c);
            this.f6498a.f6497a.f6474b.m9728a(this.f6498a.f6497a.f6476d);
        }
    }
}
