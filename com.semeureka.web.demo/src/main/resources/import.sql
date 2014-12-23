
INSERT INTO `t_organization` (`id`, `create_time`, `organization_name`, `organization_path`, `update_time`, `parent_id`) VALUES (1, '2014-12-22 21:39:38', '总公司', '1/', NULL, NULL);
INSERT INTO `t_organization` (`id`, `create_time`, `organization_name`, `organization_path`, `update_time`, `parent_id`) VALUES (2, '2014-12-23 20:10:02', '子分司一', '1/2/', NULL, 1);
INSERT INTO `t_organization` (`id`, `create_time`, `organization_name`, `organization_path`, `update_time`, `parent_id`) VALUES (3, '2014-12-23 20:10:08', '子分司二', '1/3/', NULL, 1);

INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (1, 'SHIRO演示系统', NULL, NULL, NULL, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (2, '<span class="glyphicon glyphicon-stats"></span> 模块一', NULL, NULL, 1, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (3, '<span class="glyphicon glyphicon-stats"></span> 模块二', NULL, NULL, 1, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (4, '<span class="glyphicon glyphicon-cog"></span> 系统模块', NULL, NULL, 1, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (5, '系统配置', NULL, NULL, 4, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (6, '用户配置', '/user', 'user:view', 5, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (7, '机构配置', '/organization', 'organization:view', 5, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (8, '角色配置', '/role', 'role:view', 5, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (9, '资源配置', '/resource', 'resource:view', 5, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (10, '添加用户', '/user/create', 'user:create', 6, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (11, '删除用户', '/user/delete/*', 'user:delete', 6, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (12, '修改用户', '/user/update/*', 'user:update', 6, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (13, '添加机构', '/organization/create', 'organization:create', 7, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (14, '删除机构', '/organization/delete/*', 'organization:delete', 7, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (15, '修改机构', '/organization/update/*', 'organization:update', 7, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (16, '添加角色', '/role/create', 'role:create', 8, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (17, '删除角色', '/role/delete/*', 'role:delete', 8, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (18, '修改角色', '/role/update/*', 'role:update', 8, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (19, '添加资源', '/resource/create', 'resource:create', 9, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (20, '删除资源', '/resource/delete/*', 'resource:delete', 9, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (21, '修改资源', '/resource/update/*', 'resource:update', 9, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (26, '其它', NULL, NULL, 4, 0);
INSERT INTO `t_resource` (`id`, `resource_name`, `resource_path`, `resource_permission`, `parent_id`, `resource_hidden`) VALUES (27, '风格样式设置', '/theme', 'theme', 26, 0);

INSERT INTO `t_role` (`id`, `role_description`, `role_name`, `role_value`) VALUES (1, NULL, '系统管理员', NULL);

INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 6);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 7);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 8);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 9);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 10);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 11);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 12);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 13);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 14);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 15);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 16);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 17);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 18);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 19);
INSERT INTO `t_role_resource` (`role_id`, `resource_id`) VALUES (1, 27);

INSERT INTO `t_user` (`id`, `user_account`, `create_time`, `user_locked`, `user_name`, `user_password`, `update_time`, `organization_id`) VALUES (1, 'system', '2014-12-22 21:39:38', 0, '超级管理员', '$shiro1$SHA-256$500000$5cn8YRgZlfVhAbsXTSpmfQ==$vCjyLKZR+p+dKoxR4si0F1BkdF9O7DqdONLahWLLPvE=', '2014-12-23 14:14:06', NULL);
INSERT INTO `t_user` (`id`, `user_account`, `create_time`, `user_locked`, `user_name`, `user_password`, `update_time`, `organization_id`) VALUES (3, 'admin', '2014-12-23 20:10:22', 0, '系统管理员', '$shiro1$SHA-256$500000$tEflCtKRHRIS8KBScNPTyA==$UIyJNWQTgPcwlNvl1c12b5BgKH2pTPa0Q3D/l7pixwE=', NULL, 1);

INSERT INTO `t_user_role` (`user_id`, `role_id`) VALUES (3, 1);

