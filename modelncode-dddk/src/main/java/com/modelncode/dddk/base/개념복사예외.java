package com.modelncode.dddk.base;

public class 개념복사예외 extends RuntimeException {
   static final long serialVersionUID = 1;

   public 개념복사예외(Throwable throwable, String msg){
       super(msg, throwable);
   }

   public 개념복사예외(String msg){
       super(msg);
   }

   public 개념복사예외(Throwable throwable){
       super(throwable);
   }
   
}