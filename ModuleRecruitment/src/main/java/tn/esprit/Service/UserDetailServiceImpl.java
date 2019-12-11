package tn.esprit.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.Class.Recruitment;
import tn.esprit.Class.User;
import tn.esprit.Repository.RecruitmentRepository;
import tn.esprit.Repository.UserRepository;


/**
 * This class is used by spring controller to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository repository) {
		this.repository = repository;
	}


@Bean
public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
/*
public List<Recruitment> findByName(String name) {
	// TODO Auto-generated method stub
return  RecruitmentRepository.findByFullnameLike("%"+name+"%");
}*/
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BCryptPasswordEncoder encoder = passwordEncoder();
        User curruser = repository.findByUsername(username);
        if(curruser == null){
            throw new UsernameNotFoundException("User Name "+username +"Not Found");
        }
        return new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), true, 
        		true, true, true, AuthorityUtils.createAuthorityList(curruser.getRole()));}
    
}