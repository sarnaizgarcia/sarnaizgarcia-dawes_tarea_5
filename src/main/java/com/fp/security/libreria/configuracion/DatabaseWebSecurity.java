package com.fp.security.libreria.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password,enabled from Usuarios where username=?")
				.authoritiesByUsernameQuery("select u.username, p.descripcion from Usuario_Perfiles up"
						+ " inner join Usuarios u on u.username = up.username "
						+ " inner join Perfiles p on p.id_perfil = up.id_Perfil where u.username=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
//		 Los recursos estÃ¡ticos no requieren autenticaciÃ³n
				.antMatchers("/bootstrap/**", "/images/**", "/css/**", "js/**").permitAll()

				// Las vistas pÃºblicas no requieren autenticaciÃ³n
				.antMatchers("/", "/login", "/search", "/registro", "/app/producto/verUno/**").permitAll()

				// Asignar permisos a URLs por ROLES
				.antMatchers("/app/producto/**").hasAnyAuthority("ROL_ADMON")
				.antMatchers("/app/usuarios/**").hasAnyAuthority("ROL_ADMON")
				.antMatchers("/app/perfiles/**").hasAnyAuthority("ROL_ADMON").antMatchers("/app/tipos/**")
				.hasAnyAuthority("ROL_ADMON")

				// Todas las demÃ¡s URLs de la AplicaciÃ³n requieren autenticaciÃ³n
				.anyRequest().authenticated()

				// El formulario de Login no requiere autenticacion
				.and().formLogin().permitAll();
	}

}
