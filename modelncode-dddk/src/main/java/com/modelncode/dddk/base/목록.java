package com.modelncode.dddk.base;

import java.util.ArrayList;
import java.util.List;

public class 목록<T> {
	private List<T> list = null;
	
	public 목록() {
		list = new ArrayList<T>();
	}
	
	public int 크기() {
		return list.size();
	}
	
	public boolean 추가(T e) {
		return list.add(e);
	}
	
	public boolean 제거(T e) {
		return list.remove(e);
	}
	
	public T 제거(int 순번) {
		return list.remove(순번);
	}
	
	public List<T> 알맹이목록() {
		return list;
	}
}
