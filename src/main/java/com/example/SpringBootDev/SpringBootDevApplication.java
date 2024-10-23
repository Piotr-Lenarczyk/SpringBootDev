package com.example.SpringBootDev;

import com.example.SpringBootDev.dao.AccountDAO;
import com.example.SpringBootDev.dao.MembershipDAO;
import com.example.SpringBootDev.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDevApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			beforeAdvice(accountDAO, membershipDAO);
			System.exit(0);
		};
	}

	private void beforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		accountDAO.addAccount(account, false);
		accountDAO.noop();

        accountDAO.getName();
        accountDAO.getServiceCode();
        accountDAO.setName("name");
        accountDAO.setServiceCode("serviceCode");

		membershipDAO.addMembership();
		System.out.println(membershipDAO.skip());
	}
}
