package br.com.api.service;

import br.com.api.entitys.User;
import br.com.api.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public Optional<User> getUserId(Long userId){
        return userRepository.findById(userId);
    }

    public Long getIdUserToken(String token){
        token = token.substring(7, token.length());
        return tokenService.getIdUsuario(token);
    }

    public Optional<User> getUserIdToken(String token){
        return getUserId(getIdUserToken(token));
    }


}
