package kr.or.yi.gradle_mybatis_c3p0;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_c3p0.dto.Department;
import kr.or.yi.gradle_mybatis_c3p0.dto.Title;
import kr.or.yi.gradle_mybatis_c3p0.service.TransactionService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionServiceTest extends AbstractTest {
	private static TransactionService service = new TransactionService();
	
	@Test(expected=RuntimeException.class)
	public void test01Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(1);
		title.setTitleName("사원");
		Department department = new Department(6, "H/W개발", 6);
		service.addTtitleDepartment(title, department);
	}
	
	@Test(expected=RuntimeException.class)
	public void test02Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("무기계약");
		Department department = new Department(1, "개발", 6);
		service.addTtitleDepartment(title, department);
	}
	
	@Test
	public void test03Insert() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("무기계약");
		Department department = new Department(6, "H/W개발", 6);
		service.addTtitleDepartment(title, department);
	}
	
	@Test(expected=RuntimeException.class)
	public void test04DeleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(8);
		title.setTitleName("사원");
		Department department = new Department(6, "H/W개발", 6);
		service.removeTitleDepartment(title,department);
	}
	
	@Test(expected=RuntimeException.class)
	public void test05DeleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("무기계약");
		Department department = new Department(10, "개발", 6);
		service.removeTitleDepartment(title,department);
	}
	
	
	public void test06DeleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setTitleNo(7);
		title.setTitleName("무기계약");
		Department department = new Department(6, "H/W개발", 6);
		service.removeTitleDepartment(title,department);
	}
}
