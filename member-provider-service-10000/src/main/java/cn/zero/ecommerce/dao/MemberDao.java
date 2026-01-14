package cn.zero.ecommerce.dao;

import cn.zero.ecommerce.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    public Member selectMemberById(Long id);

    public int insertMember(Member member);
}
