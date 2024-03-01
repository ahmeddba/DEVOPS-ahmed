package tn.esprit.foyeruniversiteeya.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.foyeruniversiteeya.entities.User;
        import tn.esprit.foyeruniversiteeya.exception.UserAlreadyExistsException;
        import tn.esprit.foyeruniversiteeya.registration.RegistrationRequest;
        import tn.esprit.foyeruniversiteeya.registration.password.PasswordResetTokenService;
        import tn.esprit.foyeruniversiteeya.registration.token.VerificationToken;
        import tn.esprit.foyeruniversiteeya.registration.token.VerificationTokenRepository;
        import tn.esprit.foyeruniversiteeya.repositories.UserRepository;

        import java.util.Calendar;
        import java.util.List;
        import java.util.Optional;
        import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;
    private final PasswordResetTokenService passwordResetTokenService;


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long idUser) {
        return userRepository.findById(idUser).orElse(null);
    }
    @Override
    public User addUser(User user) {
        validateUserDoesNotExist(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    private void validateUserDoesNotExist(String email) {
        Optional<User> existingUser = findByEmail(email);
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + email + " already exists");
        }
    }
    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    @Override
    public User register(RegistrationRequest request) {
        Optional<User> existingUser = this.findByEmail(request.email());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException(
                    "User with email " + request.email() + " already exists");
        }

        var newUser = new User();
        newUser.setUsername(request.username());
        newUser.setPrenomUser(request.prenomUser());
        newUser.setNomUser(request.nomUser());
        newUser.setCin(request.cin());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        //newUser.setRole(request.role() != null ? request.role() : Role.ETUDIANT);
        newUser.setRole(request.role());
        return userRepository.save(newUser);
    }

    @Override
    public void saveUserVerificationToken(User theUser, String token) {
        var verificationToken = new VerificationToken(token, theUser);
        tokenRepository.save(verificationToken);
    }
    @Override
    public String validateToken(String theToken) {
        VerificationToken token = tokenRepository.findByToken(theToken);
        if(token == null){
            return "Invalid verification token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpirationTime().getTime()-calendar.getTime().getTime())<= 0){
            return "Verification link already expired," +
                    " Please, click the link below to receive a new verification link";
        }
        user.setIsEnabled(true);
        userRepository.save(user);
        return "valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken = tokenRepository.findByToken(oldToken);
        var verificationTokenTime = new VerificationToken();
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationToken.setExpirationTime(verificationTokenTime.getTokenExpirationTime());
        return tokenRepository.save(verificationToken);
    }

    public void changePassword(User theUser, String newPassword) {
        theUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(theUser);
    }

    @Override
    public String validatePasswordResetToken(String token) {
        return passwordResetTokenService.validatePasswordResetToken(token);
    }

    @Override
    public User findUserByPasswordToken(String token) {
        return passwordResetTokenService.findUserByPasswordToken(token).get();
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String passwordResetToken) {
        passwordResetTokenService.createPasswordResetTokenForUser(user, passwordResetToken);
    }
    @Override
    public boolean oldPasswordIsValid(User user, String oldPassword){
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }
}