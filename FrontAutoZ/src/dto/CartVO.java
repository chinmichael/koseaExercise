package dto;

import java.util.LinkedList;

import action.Crud;

public class CartVO {
	
	private LinkedList<String> codeList = new LinkedList<String>();
	private LinkedList<Integer> numList = new LinkedList<Integer>();
	private String userid;
	
	public CartVO(String userid) {
		this.userid = userid;
	}
	
	public void addCart(String code, int num) {
		
		for(int i = 0; i < codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, numList.get(i) + num);
				return;
			}
		}
		
		codeList.add(code);
		numList.add(num);
	}
	public LinkedList<String> getCodeList() {
		return codeList;
	}
	public LinkedList<Integer> getNumList() {
		return numList;
	}
	
	public void deleteItem(String code) {
		for(int i = 0; i <codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				codeList.remove(i);
				numList.remove(i);
				return;
			}
		}
	}
	
	public void modifyItem(String code, int num) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, num);
				return;
			}
		}
	}
	
	public void saveDB() {
		Crud crud = new Crud();
		for(int i = 0; i <codeList.size(); i++) {
			String code = codeList.get(i);
			Integer num = numList.get(i);
			CartItemVO item = new CartItemVO();
			item.setUserid(userid); item.setCode(code); item.setNum(num);
			item.setSeqno(crud.getMaxSeqnoCart() + 1);
			crud.putCart(item);
		}
	}
}
