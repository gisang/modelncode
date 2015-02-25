package com.modelncode.dddk.base;

public class 공통도우미 {
	
	public static int 정수전환(Object 숫자개체) {
		if (숫자개체 == null)
			return 0;
		else if (숫자개체 instanceof Integer == false)
			return 0;
		else
			return (Integer) 숫자개체;
	}
}
