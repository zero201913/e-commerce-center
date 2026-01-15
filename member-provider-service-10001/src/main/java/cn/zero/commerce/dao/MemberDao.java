package cn.zero.commerce.dao;

import cn.zero.commerce.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    public Member selectMemberById(Long id);

    public int insertMember(Member member);
}
