package me.cocoding.openapi.service.user;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(String stdNum, String password) {
        if (userRepository.findUserByStdNum(stdNum).isPresent()) {
            throw new RuntimeException("이미 가입되어있습니다");
        }



//        User user = User.builder()
//                .email()
    }
}
