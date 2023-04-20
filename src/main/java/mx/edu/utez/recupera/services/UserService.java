package mx.edu.utez.recupera.services;

import mx.edu.utez.recupera.models.User;
import mx.edu.utez.recupera.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Transactional(rollbackFor = {Exception.class})
    public User SaveUser(User user){
        user.setEnabled(true);
        return this.userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id){
        return this.userRepository.findById(id).orElse(null);
    }

    @Transactional(rollbackFor = {Exception.class})
    public User disabledUser(Long id){
        User user = this.userRepository.findById(id).orElse(null);
        if(user != null){
            user.setEnabled(false);
            return this.userRepository.save(user);
        }
        return null;
    }

    @Transactional(rollbackFor = {Exception.class})
    public User enabledUser(Long id){
        User user = this.userRepository.findById(id).orElse(null);
        if(user != null){
            user.setEnabled(true);
            return this.userRepository.save(user);
        }
        return null;
    }
}
