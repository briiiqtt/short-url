package dev.briiiqtt.shorturl.security;

import dev.briiiqtt.shorturl.member.domain.MemberEntity;
import dev.briiiqtt.shorturl.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LoginService {

    //    private final MemberRepository memberRepository;
    private final MemberDetailsService memberDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String login(String email, String password) {
        MemberDetails memberDetails = memberDetailsService.loadUserByUsername(email);

        if (!passwordEncoder.matches(password, memberDetails.getPassword())) {
            throw new IllegalArgumentException("Password mismatch~!");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                memberDetails.getId(), "", memberDetails.getAuthorities()
        );

        return jwtTokenProvider.createToken(authentication);
    }
}
