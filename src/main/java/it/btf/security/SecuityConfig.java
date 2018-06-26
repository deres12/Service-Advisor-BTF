package it.btf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecuityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	SuccessLoginHandler handler;
	
	/*@Autowired
	  OAuth2ClientContext oauth2ClientContext;*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth_login", "css/**", "js/**", "img/**").permitAll().anyRequest()
				.authenticated().and().oauth2Login().loginPage("/oauth_login").successHandler(handler);
	}

}
