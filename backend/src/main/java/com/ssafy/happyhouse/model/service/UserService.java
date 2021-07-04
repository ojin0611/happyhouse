package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.MemberDto;

public interface UserService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	
//	REST 
	public List<MemberDto> userList();
	public MemberDto userInfo(String userid);
	public int userModify(MemberDto memberDto);
	public int userDelete(String userid);
	public int userRegister(MemberDto memberDto);
	public String getServerInfo();
}
