package umc.spring.service.MemberService;

import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;

public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    @Override
    public Member JoinMember(MemberRequestDTO.JoinDTO request) {

        Member newMember = MemberConverter.tomember(request);

        return null;
    }
}
