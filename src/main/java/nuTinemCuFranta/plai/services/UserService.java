package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }
}
