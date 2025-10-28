package com.ecommerce.application.impl;

import com.ecommerce.api.Mailing.MailingService;
import com.ecommerce.domain.dto.daboUserDto;
import com.ecommerce.domain.exception.ApplicationException;
import com.ecommerce.domain.repository.entity.DABOUser;
import com.ecommerce.infrastructure.repository.DABOUserRepository;
//import com.sun.jdi.request.DuplicateRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class DABOUserService {

    private final DABOUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CommonService commonService;
    private final MailingService mailingService;
    private static final Logger logger = LoggerFactory.getLogger(DABOUserService.class);

    @Autowired
    public DABOUserService(DABOUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, CommonService commonService, MailingService mailingService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.commonService = commonService;
        this.mailingService = mailingService;
    }


    public List<DABOUser> list() {
        List<DABOUser> list = userRepository.findAll().stream()
                .sorted((a, b) -> (int) (b.getPoint()-a.getPoint()))
                .collect(Collectors.toList());

        return Optional.of(list)
                .filter(l -> !l.isEmpty())
                .orElseThrow(() -> new ApplicationException("회원 정보를 찾을 수 없습니다."));
    }

    // 닉네임 중복 검사
    public boolean DuplicatedNickname(String nickname) {
        AtomicBoolean available = new AtomicBoolean(true);
        userRepository.findDABOUserByNickname(nickname)
                .ifPresent(found -> available.set(false));
        return available.get();
    }

    // 이메일 중복 검사
    public boolean DuplicatedEmail(String email) {
        AtomicBoolean available = new AtomicBoolean(true);
        userRepository.findDABOUserByEmail(email)
                .ifPresent(found -> available.set(false));
        return available.get();
    }

    public DABOUser get() {
        DABOUser userTemp = commonService.getLoginUser();
        return userRepository.findDABOUserByEmail(userTemp.getEmail())
                .orElseThrow(() -> new ApplicationException("회원 정보를 찾을 수 없습니다."));
    }

    @Transactional
    public DABOUser add(daboUserDto userDto) {
        Optional<DABOUser> sameEmail = userRepository.findDABOUserByEmail(userDto.getEmail());
//        if(sameEmail.isPresent()) throw new DuplicateRequestException();
        DABOUser dabouser = DABOUser.builder()
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                .bloodType(userDto.getBloodType())
                .point(0L)
                .build();
        userRepository.save(dabouser);
        return dabouser;
    }

    @Transactional
    public DABOUser update(daboUserDto userDto) {
        DABOUser user = commonService.getLoginUser();

        DABOUser userUpdate = userRepository.findDABOUserByEmail(user.getEmail())
                .orElseThrow(() -> new ApplicationException("회원 정보를 찾을 수 없습니다."));

        if(userDto.getPassword() != null) userUpdate.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        if(userDto.getBloodType() != null) userUpdate.setBloodType(userDto.getBloodType());
        if(userDto.getNickname() != null) userUpdate.setNickname(userDto.getNickname());

        userRepository.save(userUpdate);

        return userUpdate;
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public DABOUser getUserByEmail(String email) {
        Optional<DABOUser> found = userRepository.findDABOUserByEmail(email);
        if(found.isPresent()){
            return found.get();
        }
        throw new ApplicationException("회원 정보를 찾을 수 없습니다.");
    }

    public DABOUser resetPassword(String email) throws Exception{
        logger.debug("Resetting password for email: {}", email);
        DABOUser user = userRepository.findDABOUserByEmail(email)
                .orElseThrow(() -> new ApplicationException("회원 정보를 찾을 수 없습니다."));
        String newPassword = mailingService.sendSimpleMessage(email);
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userRepository.save(user);
        return user;
    }
}


