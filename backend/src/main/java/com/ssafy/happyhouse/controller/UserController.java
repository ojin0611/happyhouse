package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.JwtService;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/user")
@Api("User Controller API V1")
public class UserController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<MemberDto> login(@RequestBody MemberDto memberDto, HttpServletResponse res) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		MemberDto loginUser = null;
		try {
			System.out.println(memberDto.getUserid());
			loginUser = userService.login(memberDto);
			String token = ""; 
			// 로그인 성공했다면 토큰을 생성한다.
			if(loginUser != null)
			token = jwtService.create(loginUser);
			// 토큰 정보는 request의 헤더로 보내고 나머지는 Map에 담아주자.
			res.setHeader("jwt-auth-token", token);
			System.out.println(loginUser.getUserid());
			// resultMap.put("auth_token", token);

			resultMap.put("status", true);
			resultMap.put("data", loginUser);
			status = HttpStatus.OK;
		} catch (RuntimeException e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<MemberDto>(loginUser, status);
	}

	@PostMapping("/info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req, @RequestBody Map<String, String> map) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			// 사용자에게 전달할 정보이다.
			String info = userService.getServerInfo();
			// 보너스로 토큰에 담긴 정보도 전달해보자. 서버에서 토큰을 사용하는 방법임을 알 수 있다.
			resultMap.putAll(jwtService.get(req.getHeader("jwt-auth-token")));

			resultMap.put("status", true);
			resultMap.put("info", info);
			resultMap.put("request_body", map);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	@PostMapping("/join")
	public ResponseEntity<Integer> join(@RequestBody MemberDto memberDto) {
		int success = 0;
		HttpStatus status = null;
		try {
			// 사용자에게 전달할 정보이다.
			success = userService.userRegister(memberDto);
			status = HttpStatus.OK;
			// 보너스로 토큰에 담긴 정보도 전달해보자. 서버에서 토큰을 사용하는 방법임을 알 수 있다.
		} catch (RuntimeException e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Integer>(success,status);
	}
}