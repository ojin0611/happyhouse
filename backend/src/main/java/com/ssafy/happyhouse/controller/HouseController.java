package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/house")
@Api("House Controller API V1")
public class HouseController {
	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	@Autowired
	private HouseMapService houseMapService;
	
	
	// 시작 시, 시도 띄우기
	@GetMapping(value = "/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		List<SidoGugunCodeDto> list = houseMapService.getSido();
		return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
	}
	
	// 시도 코드 받아서 구군 띄우기
	@GetMapping(value = "/gugun/{sidoCode}")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@PathVariable("sidoCode") String sido) throws Exception {
		List<SidoGugunCodeDto> list = houseMapService.getGugunInSido(sido);
		return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
	
	}
	
	// 구군 코드 받아서 동 띄우기
	@GetMapping(value = "/dong/{gugunCode}")
	public ResponseEntity<List<HouseInfoDto>> dong(@PathVariable("gugunCode") String gugun) throws Exception {
		List<HouseInfoDto> list = houseMapService.getDongInGugun(gugun);
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	
	}
	
	// 시군구 코드 다 완성되면 해당 동에 있는 house들 가져오기
	@GetMapping(value = "/apt/{dong}")
	public ResponseEntity<List<HouseInfoDto>> apt(@PathVariable("dong") String dong) throws Exception {
		List<HouseInfoDto> list = houseMapService.getAptInDong(dong);
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	
	}
	
	// 아파트 실거래 정보
	//idx.jsp Line:221 callHouseDealInfo(aptName) method-> google map의 marker 클릭 시 아파트 실거래 정보 출력
	@GetMapping(value = "/deal/{aptName}")
	public ResponseEntity<List<HouseDealDto>> deal(@PathVariable("aptName") String aptName) throws Exception {
		List<HouseDealDto> houseDealList = houseMapService.getAptInfo(aptName);
		/*
		if(houseDealList.size()==0) {
			System.out.println("No data");
		}
		else if(houseDealList.size()>1) {
			System.out.println("More than 1 data");
		}
		*/
		return new ResponseEntity<List<HouseDealDto>>(houseDealList, HttpStatus.OK);
	
	}
}
