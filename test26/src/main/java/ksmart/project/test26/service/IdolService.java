package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IdolService {
	@Autowired
	IdolDao idolDao;
	
	//아이돌 조회
	public List<Idol> selectIdolList(){
		return idolDao.selectIdolList();
	}
	
	//아이돌 추가 Action
	public int insertIdol(Idol idol) {
		return idolDao.insertIdol(idol);
	}
	
	//아이돌 수정을 위한 아이디 select
	public Idol selectAndupdateIdol(int idolId) {
		return idolDao.rselectAndupdateIdol(idolId);
	}
	
	//아이돌 수정
	public int updateIdol(Idol idol) {
		return idolDao.updateIdol(idol);
	}
	
	//아이돌 삭제
	public int deleteIdol(Idol idol) {
		return idolDao.deleteIdol(idol);
	}

}
