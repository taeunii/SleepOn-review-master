package bitc.fullstack.sleepon.service;

import bitc.fullstack.sleepon.model.SleepOnUser;
import bitc.fullstack.sleepon.repository.SleepOnUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SleepOnUserService {

    @Autowired
    private SleepOnUserRepository userRepository;

    public void registerUser(SleepOnUser user) throws Exception {
        if (userRepository.existsById(user.getId())) {
            throw new Exception("이미 존재하는 사용자입니다.");
        }
        userRepository.save(user);
    }

    public SleepOnUser authenticate(String id, String pass) {
        SleepOnUser user = userRepository.findById(id).orElse(null);
        if (user != null && user.getPass().equals(pass)) {
            return user;
        }
        return null;
    }
}