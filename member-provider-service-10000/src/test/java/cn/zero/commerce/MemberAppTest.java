package cn.zero.commerce;

import cn.zero.commerce.dao.MemberDao;
import cn.zero.commerce.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MemberAppTest {
    @Resource
    private MemberDao memberDao;

    @Test
    public void testSelectMemberById() {
        Member member = memberDao.selectMemberById(1L);
        System.out.println(member);
    }

    @Test
    public void testInsertMember() {
        Member member = new Member(null, "xxx", "xxx", "xxx", "xxx", 1);
        int success = memberDao.insertMember(member);
        System.out.println(success > 0 ? "成功" : "不成功");
    }
}
