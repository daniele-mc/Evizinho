package Evizinhotest2.example.securingWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import Evizinhotest2.model.User;
import Evizinhotest2.repository.UserRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository ur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = ur.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return user;
	}

}
