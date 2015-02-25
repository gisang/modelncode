package com.modelncode.dddk.base;

public class 잘못된ID유형예외 extends RuntimeException {
	private static final long serialVersionUID = 1;

	private static final String MESSAGE="도메인개체에서 사용하는 ID 유형이 아닙니다.";
	
	public 잘못된ID유형예외(){
       super(MESSAGE);
	}
   
	public 잘못된ID유형예외(String msg){
       super(msg);
	}

}