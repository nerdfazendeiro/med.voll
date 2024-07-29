package med.voll.api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Habilita a configuração de segurança web personalizada
public class SecurityConfigurations {

    @Bean // indica que o Spring que irá gerenciar o objeto retornado
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable) // Desativa a proteção CSRF
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build(); // Constrói e retorna o filtro de segurança
    }

    @Bean // Serve para exportar uma classe para o Spring, fazendo com que ele consiga carregá-la e realize a sua
    // injeção de dependência em outras classes.
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean // Informa para o Spring que as senhas estão sendo armazenada usando o Algoritmo BCrypt
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
