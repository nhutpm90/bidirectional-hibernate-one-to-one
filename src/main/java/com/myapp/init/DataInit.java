package com.myapp.init;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.dao.UserDAO;
import com.myapp.dao.UserDetailDAO;
import com.myapp.entity.User;
import com.myapp.entity.UserDetail;

@Component
public class DataInit implements ApplicationRunner {

	@Autowired
	private UserDetailDAO userDetailDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User dbUser = null;
		boolean insertDataOnStartUp = true;
		if (insertDataOnStartUp) {
			User user = new User();
			user.setUsername("USR002");
			user.setPassword("mno@xyz.com");

			dbUser = this.userDAO.save(user);
			System.out.println(this.objectMapper.writeValueAsString(dbUser));
		}

		boolean updateDataOnStartUp = true;
		if (updateDataOnStartUp) {
			User userToUpdate = this.userDAO.findById(dbUser.getId()).orElse(null);
			if(userToUpdate != null) {
				UserDetail userDetail = new UserDetail();
				userDetail.setFirstName("Sammer");
				userDetail.setLastName("Dua");
				userDetail.setEmail("sammer.dua@example.com");
				userDetail.setDob(LocalDate.of(1985, Month.APRIL, 1));
				userDetail.setUser(userToUpdate);
//				userToUpdate.setUserDetail(userDetail);
				
//				this.userDAO.save(userToUpdate);
				this.userDetailDAO.save(userDetail);
			}
		}
	}

}