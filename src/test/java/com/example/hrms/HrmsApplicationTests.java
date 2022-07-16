package com.example.hrms;

import com.example.hrms.dataAccess.JobPositionDao;
import com.example.hrms.entities.concretes.JobPosition;
import com.example.hrms.test.TestCrud;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HrmsApplicationTests implements TestCrud {

	@Autowired
	private  JobPositionDao jobPositionDao;


/*	@Test
	void contextLoads() {
	s
	}
*/

	@Test
	@Override
	public void testCreate() {
		JobPosition jobPosition = JobPosition
				.builder()
				.position_id(58)
				.positionTitle("test position").build();
		jobPositionDao.save(jobPosition);
		assertNotNull(jobPositionDao.findById(1).get());//nesne null ise assertionError hatası göndersin
	}

	@Override
	@Test
	public void testList() {

		List<JobPosition> list=jobPositionDao.findAll();
		assertThat(list).size().isGreaterThan(0);


	}
	@Override
	@Test
	public void testFindById() {
		JobPosition jobPosition=jobPositionDao.findById(1).get();

		assertEquals("test position",jobPosition.getPositionTitle());//test position adında kayıt var mı yok mu

	}
	@Override
	@Test
	public void testUpdate() {
		JobPosition jobPosition=jobPositionDao.findById(1).get();
		jobPosition.setPositionTitle("test position güncellendi");
		jobPositionDao.save(jobPosition);

		assertNotEquals("test position",jobPositionDao.findById(1).get().getPositionTitle());

	}

	@Override
	@Test
	public void testDelete() {
		jobPositionDao.deleteById(1);
		assertThat(jobPositionDao.existsById(1)).isFalse();

	}
}
