package dev.briiiqtt.shorturl.security;

import dev.briiiqtt.shorturl.member.domain.MemberEntity;
import dev.briiiqtt.shorturl.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found by:" + username));
        return new MemberDetails(memberEntity);

    }
}
