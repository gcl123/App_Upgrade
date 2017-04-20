----------------------------------------------------
-- ===== 软件信息表 tl_app_info =====
----------------------------------------------------
-- id 记录ID  自增长
-- app_code 软件代码
-- app_name 软件名称
-- latest_version 最新版本号
-- limit_version  限制版本号 低于该版本强制升级
-- description  软件描述
-- company_id  所属公司ID
-- var1 ~ var5 冗余字段
-- update_time  更新时间
-- create_time  创建时间
-- remark  备注
CREATE TABLE `tonlan`.`tl_app_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `app_code` VARCHAR(32) NOT NULL,
  `app_name` VARCHAR(100) NOT NULL,
  `latest_version` VARCHAR(32) NOT NULL,
  `limit_version` VARCHAR(32) NOT NULL,
  `description` MEDIUMTEXT NOT NULL,
  `company_id` INT NOT NULL,
  `var1` VARCHAR(100) NULL,
  `var2` VARCHAR(100) NULL,
  `var3` VARCHAR(100) NULL,
  `var4` VARCHAR(100) NULL,
  `var5` VARCHAR(100) NULL,
  `update_time` BITINT(20) NULL,
  `create_time` BITINT(20) NULL,
  `remark` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));


----------------------------------------------------
--   ===== 公司信息表 tl_company_info ======
----------------------------------------------------

--   id 记录ID
--   code 公司代码
--   name 公司名称
--   short_name 公司名称简写
--   mobile 联系电话
--   contact 联系人
--   url 公司网站地址
--   description 公司描述
--   var1 ~ var5 冗余字段
--   update_time 更新时间 (数据库记录更新时间)
--   create_time 创建时间 (数据库记录创建时间)
--   remark 备注


  CREATE TABLE `tonlan`.`tl_company_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(100) NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `short_name` VARCHAR(100) NULL,
  `mobile` VARCHAR(32) NULL,
  `contact` VARCHAR(100) NULL,
  `url` VARCHAR(200) NULL,
  `description` MEDIUMTEXT NULL,
  `var1` VARCHAR(100) NULL,
  `var2` VARCHAR(100) NULL,
  `var3` VARCHAR(100) NULL,
  `var4` VARCHAR(100) NULL,
  `var5` VARCHAR(100) NULL,
  `update_time` BITINT(20) NULL,
  `create_time` BITINT(20) NULL,
  `remark` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));

----------------------------------------------------
--   ===== 版本信息 tl_app_version ======
----------------------------------------------------

--   app_id 和 version 决定软件某版本信息
--   id 记录
--   app_id 软件ID
--   version 版本号
--   update_description 升级说明
--   setup_script 安装脚本
--   status 状态 (0-不可用,默认 1-测试中 9-可用)
--   var1~var5 冗余字段
--   update_time 更新时间
--   create_time 创建时间
--   remark 备注

  CREATE TABLE `tonlan`.`tl_app_version` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `app_id` INT NOT NULL,
  `version` VARCHAR(200) NOT NULL,
  `update_description` MEDIUMTEXT NULL,
  `setup_script` LONGTEXT NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  `var1` VARCHAR(100) NULL,
  `var2` VARCHAR(100) NULL,
  `var3` VARCHAR(100) NULL,
  `var4` VARCHAR(100) NULL,
  `var5` VARCHAR(100) NULL,
  `update_time` BITINT(20) NULL,
  `create_time` BITINT(20) NULL,
  `remark` VARCHAR(200) NULL,
  PRIMARY KEY (`id`, `app_id`));

----------------------------------------------------
--   ===== 文件信息表 tl_file_info ======
----------------------------------------------------

--   id 文件ID
--   app_id 软件ID
--   name 文件名称
--   url 文件路径 (CDN地址或者服务端静态文件路径)
--   md5 文件HASH值
--   size 文件大小
--   type 文件类型 (1-exe 2-dll 3-配置文件)
--   gzip 是否压缩 (0-非压缩 1-压缩)
--   version 文件版本号
--   var1~var5 冗余字段
--   update_time 更新时间
--   create_time 创建时间
--   remark 备注

  CREATE TABLE `tonlan`.`tl_file_info` (
  `id` INT NOT NULL,
  `app_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `url` VARCHAR(200) NOT NULL,
  `md5` MEDIUMTEXT NOT NULL,
  `size` INT NOT NULL,
  `type` INT NOT NULL,
  `gzip` INT NOT NULL,
  `version` VARCHAR(100) NULL,
  `var1` VARCHAR(100) NULL,
  `var2` VARCHAR(100) NULL,
  `var3` VARCHAR(100) NULL,
  `var4` VARCHAR(100) NULL,
  `var5` VARCHAR(100) NULL,
  `update_time` BITINT(20) NULL,
  `create_time` BITINT(20) NULL,
  `remark` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));

----------------------------------------------------
--   ====== 软件文件信息表 tl_app_files ======
----------------------------------------------------
--   app_version_id 不同版本软件ID (对应版本信息表-tl_app_version-的ID)
--   file_id 文件ID (对应文件信息表-tl_file_info-的ID)
--   var1~var5 冗余字段
--   update_time 更新时间
--   create_time 创建时间
--   remark 备注

  CREATE TABLE `tonlan`.`tl_app_files` (
  `app_version_id` INT NOT NULL,
  `file_id` INT NOT NULL,
  `var1` VARCHAR(100) NULL,
  `var2` VARCHAR(100) NULL,
  `var3` VARCHAR(100) NULL,
  `var4` VARCHAR(100) NULL,
  `var5` VARCHAR(100) NULL,
  `update_time` BITINT(20) NULL,
  `create_time` BITINT(20) NULL,
  `remark` VARCHAR(200) NULL,
  PRIMARY KEY (`app_version_id`, `file_id`));


----------------------------------------------------
--   ====== 软件文件信息表 tl_app_files ======
----------------------------------------------------
-- code 指令代码
-- name 指令名称
-- description 指令描述
-- vaild 是否有效 (0-无效 1-有效,默认)
--   var1~var5 冗余字段
--   update_time 更新时间
--   create_time 创建时间
--   remark 备注


CREATE TABLE `tonlan`.`tl_action_info` (
  `code` VARCHAR(32) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` MEDIUMTEXT NULL,
  `vaild` INT NOT NULL DEFAULT 1,
  `var1` VARCHAR(100) NULL,
  `var2` VARCHAR(100) NULL,
  `var3` VARCHAR(100) NULL,
  `var4` VARCHAR(100) NULL,
  `var5` VARCHAR(100) NULL,
  `update_time` BITINT(20) NULL,
  `create_time` BITINT(20) NULL,
  `remark` VARCHAR(200) NULL,
  PRIMARY KEY (`code`));