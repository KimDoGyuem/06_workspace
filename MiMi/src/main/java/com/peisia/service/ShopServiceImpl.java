package com.peisia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peisia.dto.WealthDto;
import com.peisia.mapper.ShopMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class ShopServiceImpl implements ShopService{

	@Setter(onMethod_ = @Autowired)
	private ShopMapper mapper;

	@Override
	public void buyGold() {
		mapper.buyGold();
	}

	@Transactional	//트랜잭션 처리함
	@Override
	public void buyDice() {
		////	아래 2개 함수는 하나의 트랜잭션으로 묶어 처리해야하는 함수
		////	예를들어 돈이 9만원이 있고 다이스를 1개 구매하면(10만원으로 설정했음)
		////	다이스1개가 유저에게 추가되면 안됨.
		////	참고로 돈은 9만원인 상태에서 10만원 차감시 -1만원이되는데 이 처리는
		////	디비에 해당 테이블 칼럼이 unsigned 설정되어 음수가 안되게 설정했고
		////	음수가 되는 업데이트 시도 시 실패하여 익셉션이 발생함.
		////
		////	root-context.xml쪽에 트랜잭션 설정을 안하면
		////	위에 @Transactional 어노테이션 자체는 에러가 안나지만
		////	적용이 안되니 주의하고
		////	적용이 안된 상태에서 9만원인데 다이스 1개 구매하는 상황 발생 시
		////	위에 말한 테이블 칼럼 조건 때문에 익셉션은 발생하지만
		////	유저가 보유한 다이스의 수는 1 증가처리됨.(공짜로 산거. 문제발생)
		mapper.buyDice(); //다이스박스가 1개 추가되어 디비에 저장되는 함수(매퍼 거쳐서)
		mapper.payGold(); //위 다이스박스를 1개 구매가격을 보유 골드에서 차감시키는 함수(매퍼 거쳐서)
	}

	@Override
	public WealthDto getWealth() {
		return mapper.getWealth();
	}

	@Override
	public void payGold() {
		mapper.payGold();
	}

}