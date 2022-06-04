package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.Member;
import io.getarrays.userservice.repo.RoleRepo;
import io.getarrays.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public Member saveUser(Member member) {
        log.info("Saving new user {} to the db", member.getName());
        return userRepo.save(member);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the db", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String roleName) {
        log.info("Giving role {} to user {}", roleName, username);
        Member member = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        member.getRoles().add(role);
    }

    @Override
    public Member getUser(String username) {
        log.info("fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<Member> getUsers() {
        log.info("fetching all users");
        return userRepo.findAll();
    }
}
