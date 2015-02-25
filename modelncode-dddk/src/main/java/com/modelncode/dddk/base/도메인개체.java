package com.modelncode.dddk.base;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Date;


public class 도메인개체 {
	//Domain or Entity
	//업무개념을 나타내며 도메인 클래스라고 하기도 함.
	//특징 정의
	//1. id(식별자)를 갖는다.
	//2. audit 속성(생성일,생성자,수정일,수정자)을 갖는다.
	

	protected int id;
	
	protected Date 생성일시;
	protected String 생성자;
	protected Date 수정일시;
	protected String 수정자;
	
	protected 도메인개체() {
		this.setId(0);
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(Object id) {
		try {	
			if (id == null)
				this.id = 0;
			else if (id instanceof Integer)
				this.id = (Integer) id;
			else if (id instanceof String)
				this.id = Integer.parseInt((String)id);
			else {
				throw new 잘못된ID유형예외();
			}
		} catch(Exception e) {
			throw new 잘못된ID유형예외();
		}
	}
	
	
	public Date get생성일시() {
		return 생성일시;
	}
	public void set생성일시(Date 생성일시) {
		this.생성일시 = 생성일시;
	}
	public String get생성자() {
		return 생성자;
	}
	public void set생성자(String 생성자) {
		this.생성자 = 생성자;
	}
	public Date get수정일시() {
		return 수정일시;
	}
	public void set수정일시(Date 수정일시) {
		this.수정일시 = 수정일시;
	}
	public String get수정자() {
		return 수정자;
	}
	public void set수정자(String 수정자) {
		this.수정자 = 수정자;
	}
	
//	@PrePersist
//	public void prePersiste() {
//		this.생성일시 = new Date();
//	}
//	
//	@PreUpdate
//	public void preUpdate() {
//		this.수정일시 = new Date();
//	}
	
	public boolean 신규여부() {
		if (this.id == 0) 
			return true;
		return false;
	}
	
	public void 생성시감사컬럼설정(String 사용자) {
		Date 지금 = new Date();
		this.생성일시 = 지금;
		this.수정일시 = 지금;
		this.생성자 = 사용자;
		this.수정자 = 사용자;
	}
	
	public void 변경시감사컬럼설정(String 사용자) {
		Date 지금 = new Date();
		this.수정일시 = 지금;
		this.수정자 = 사용자;
	}
	
		
	/*
	 * Merge not null Value of target object into destination object
	 */
	public static void 융합(Object target, Object destination) throws 개념복사예외 {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(target.getClass());
			 
			// Iterate over all the attributes
			for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
			
				// Only copy writable attributes
				if (descriptor.getWriteMethod() != null) {
				    Object originalValue = descriptor.getReadMethod().invoke(target);
				
				    // Only copy values values where the destination values is null
				    if (originalValue == null) {
				    	Object defaultValue = descriptor.getReadMethod().invoke(destination);
				    	descriptor.getWriteMethod().invoke(target, defaultValue);
				    }
				
				}
			}
		} catch (Throwable ex) {
			throw new 개념복사예외(ex, "Could not copy properties from source to target");
		}
	}
	
	
}
