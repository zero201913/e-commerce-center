use e_commerce_db;


-- 创建会员表
CREATE TABLE `member` (
                          `id` BIGINT primary key AUTO_INCREMENT COMMENT '会员ID（主键）',
                          `name` VARCHAR(50) NOT NULL COMMENT '会员姓名',
                          `pwd` VARCHAR(64) NOT NULL COMMENT '密码（建议加密存储，如MD5/SHA256）',
                          `mobile` VARCHAR(20) DEFAULT NULL COMMENT '手机号码',
                          `email` VARCHAR(100) DEFAULT NULL COMMENT '电子邮箱',
                          `gender` TINYINT DEFAULT 0 COMMENT '性别（0：未知，1：男，2：女）',
                          `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          UNIQUE KEY `uk_mobile` (`mobile`),
                          UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员信息表';

-- 插入会员模拟数据（密码使用MD5加密，原始密码均为 123456，MD5密文：e10adc3949ba59abbe56e057f20f883e）
INSERT INTO `member` (name, pwd, mobile, email, gender) VALUES
                                                            ('张三', 'e10adc3949ba59abbe56e057f20f883e', '13800138000', 'zhangsan@example.com', 1),
                                                            ('李四', 'e10adc3949ba59abbe56e057f20f883e', '13900139000', 'lisi@example.com', 1),
                                                            ('王芳', 'e10adc3949ba59abbe56e057f20f883e', '13700137000', 'wangfang@example.com', 2),
                                                            ('赵六', 'e10adc3949ba59abbe56e057f20f883e', '13600136000', 'zhaoliu@example.com', 0),
                                                            ('孙七', 'e10adc3949ba59abbe56e057f20f883e', '13500135000', 'sunqi@example.com', 2);

select *
from member;