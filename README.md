spring 3 security configuration steps  <br>
Step 1: Create a New Spring Boot Project in Spring Initializr.<br>
Step 2: Create a UserController.<br>
Step 3: Create a SecurityConfig Class.=><br>
        a:public class CustomUser implements UserDetails{}<br>
        b:public class CustomUserDetailsService implements UserDetailsService{}<br> 
        c:public class SecurityConfig => <br>
                  i:- BCryptPasswordEncoder()<br>
                  ii: - getUserDetailsService()<br>
                  iii: - DaoAuthenticationProvider()<br>
                  iv: - SecurityFilterChain(HttpSecurity http)
<>                  
