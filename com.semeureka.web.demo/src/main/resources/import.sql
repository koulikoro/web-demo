INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`) VALUES (1, NULL, 'ROOT权限', '*');
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (10, NULL, '角色操作权限', 'role:*', 1);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (11, NULL, '添加', 'role:create', 10);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (12, NULL, '删除', 'role:delete', 10);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (13, NULL, '更新', 'role:update', 10);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (14, NULL, '查看', 'role:view', 10);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (20, NULL, '用户操作权限', 'user:*', 1);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (21, NULL, '添加', 'user:create', 20);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (22, NULL, '删除', 'user:delete', 20);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (23, NULL, '更新', 'user:update', 20);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (24, NULL, '查看', 'user:view', 20);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (30, NULL, '机构操作权限', 'organization:*', 1);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (31, NULL, '添加', 'organization:create', 30);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (32, NULL, '删除', 'organization:delete', 30);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (33, NULL, '更新', 'organization:update', 30);
INSERT INTO `t_permission` (`id`, `permission_description`, `permission_name`, `permission_value`, `parent_id`) VALUES (34, NULL, '查看', 'organization:view', 30);
INSERT INTO `t_role` (`id`, `role_description`, `role_name`, `role_value`) VALUES (1, NULL, '系统管理员', 'SYSTEM');
INSERT INTO `t_role_permission` (`role_id`, `permission_id`) VALUES (1, 1);
INSERT INTO `t_organization` (`id`, `create_time`, `organization_name`, `organization_path`, `parent_id`) VALUES (1, SYSDATE(), '总公司', '1/', NULL);
INSERT INTO `t_user` (`id`, `user_account`, `user_locked`, `user_name`, `user_password`, `organization_id`, `create_time`) VALUES (1, 'SYSTEM', 0, '系统管理员', '$shiro1$SHA-256$500000$5cn8YRgZlfVhAbsXTSpmfQ==$vCjyLKZR+p+dKoxR4si0F1BkdF9O7DqdONLahWLLPvE=', 1, SYSDATE());
INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES (1, 1);
