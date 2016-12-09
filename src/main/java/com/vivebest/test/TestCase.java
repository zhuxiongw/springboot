package com.vivebest.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vivebest.SpringbootApplication;
import com.vivebest.entity.Admin;
import com.vivebest.mapper.AdminMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringbootApplication.class)
public class TestCase {
	@Autowired
	private AdminMapper adminMapper;
	
	@Before
	public void setUp() {
		adminMapper.deleteAll();
	}
	
	
	@Test
	public void test() throws Exception {

		// 创建三个User，并验证User总数
		adminMapper.save(new Admin(1L, "didi","11111"));
		adminMapper.save(new Admin(2L, "mama","22222"));
		adminMapper.save(new Admin(3L, "kaka","33333"));
		Assert.assertEquals(3, adminMapper.findAll().size());

		// 删除一个User，再验证User总数
		Admin u = adminMapper.findOne(1L);
		adminMapper.delete(u);
		Assert.assertEquals(2, adminMapper.findAll().size());

		// 删除一个User，再验证User总数
		u = adminMapper.findByName("mama");
		adminMapper.delete(u);
		Assert.assertEquals(1, adminMapper.findAll().size());
		

	}

}
