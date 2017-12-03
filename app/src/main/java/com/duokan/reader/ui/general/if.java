package com.duokan.reader.ui.general;

class if implements Runnable{
final /* synthetic */ SpirtMenuController a;

        if(SpirtMenuController spirtMenuController){
        this.a=spirtMenuController;
        }

public void run(){
        this.a.d=MenuState.TOHIDE;
        if(this.a.e!=null){
        this.a.e.run();
        }
        }
        }
