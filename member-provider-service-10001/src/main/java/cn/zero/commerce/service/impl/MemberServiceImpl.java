package cn.zero.commerce.service.impl;

import cn.zero.commerce.dao.MemberDao;
import cn.zero.commerce.entity.Member;
import cn.zero.commerce.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDao memberDao;

    @Override
    public Member selectMemberById(Long id) {
        return memberDao.selectMemberById(id);
    }

    @Override
    public Integer insertMember(Member member) {
        return memberDao.insertMember(member);
    }
}
