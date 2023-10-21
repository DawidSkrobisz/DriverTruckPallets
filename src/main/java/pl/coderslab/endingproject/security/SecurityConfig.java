package pl.coderslab.endingproject.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/public/**").permitAll()  // Dostęp publiczny
                .antMatchers("/private/**").authenticated()  // Wymaga uwierzytelnienia
                .antMatchers("/admin/**").hasRole("ADMIN")  // Wymaga roli ADMIN
                .and()
                .formLogin()
                .loginPage("/login")  // Strona logowania
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
