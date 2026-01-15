package cn.zero.commerce.service;

import cn.zero.commerce.entity.Member;

public interface MemberService {
    public Member selectMemberById(Long id);

    public Integer insertMember(Member member);
}
