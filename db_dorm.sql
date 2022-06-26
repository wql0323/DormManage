/*
 Navicat Premium Data Transfer

 Source Server         : SqlServer
 Source Server Type    : SQL Server
 Source Server Version : 15002000
 Source Catalog        : db_dorm
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 15002000
 File Encoding         : 65001

 Date: 07/07/2021 09:41:19
*/


-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_admin]') AND type IN ('U'))
	DROP TABLE [dbo].[t_admin]
GO

CREATE TABLE [dbo].[t_admin] (
  [adminId] int  NOT NULL,
  [userName] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [name] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [sex] nvarchar(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [tel] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_admin] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_admin
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[t_admin] VALUES (N'1', N'admin', N'password', N'王庆龙', N'男', N'15532985280'), (N'2', N'root', N'password', N'朱子杨', N'男', N'15614326606')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for t_dorm
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_dorm]') AND type IN ('U'))
	DROP TABLE [dbo].[t_dorm]
GO

CREATE TABLE [dbo].[t_dorm] (
  [dormId] int  NOT NULL,
  [dormBuildId] int  NULL,
  [dormName] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [dormType] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [dormNumber] int  NULL,
  [dormTel] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_dorm] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_dorm
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[t_dorm] VALUES (N'1260', N'1', N'260', N'男', N'4', N'789456'), (N'1310', N'1', N'310', N'男', N'4', N'123456'), (N'1332', N'1', N'332', N'男', N'4', N'456123'), (N'2201', N'2', N'201', N'女', N'6', N'789456'), (N'2419', N'2', N'419', N'女', N'6', N'123789')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for t_dormbuild
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_dormbuild]') AND type IN ('U'))
	DROP TABLE [dbo].[t_dormbuild]
GO

CREATE TABLE [dbo].[t_dormbuild] (
  [dormBuildId] int  NOT NULL,
  [dormBuildName] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [dormBuildDetail] nvarchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_dormbuild] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_dormbuild
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[t_dormbuild] VALUES (N'1', N'9栋', N'男生9栋'), (N'2', N'15栋', N'女生15栋'), (N'3', N'16栋', N'男生16栋'), (N'4', N'23栋', N'正建宿舍')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for t_dormmanager
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_dormmanager]') AND type IN ('U'))
	DROP TABLE [dbo].[t_dormmanager]
GO

CREATE TABLE [dbo].[t_dormmanager] (
  [dormManId] int  NOT NULL,
  [userName] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [dormBuildId] int  NULL,
  [name] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [sex] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [tel] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_dormmanager] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_dormmanager
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[t_dormmanager] VALUES (N'1', N'manager1', N'manager1', N'1', N'老赵', N'男', N'123456'), (N'2', N'manager2', N'manager2', N'2', N'老钱', N'女', N'123456'), (N'3', N'manager3', N'manager3', N'3', N'老孙', N'男', N'123456'), (N'4', N'manager4', N'manager4', N'4', N'老李', N'男', N'123456')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for t_record
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_record]') AND type IN ('U'))
	DROP TABLE [dbo].[t_record]
GO

CREATE TABLE [dbo].[t_record] (
  [recordId] int  NOT NULL,
  [studentNumber] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [studentName] nvarchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [dormBuildId] int  NULL,
  [dormName] nvarchar(11) COLLATE Chinese_PRC_CI_AS  NULL,
  [date] date  NOT NULL,
  [detail] nvarchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_record] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_record
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[t_record] VALUES (N'1001', N'20194120', N'王庆龙', N'1', N'332', N'2021-07-06', N'无'), (N'1002', N'20193881', N'朱子杨', N'1', N'260', N'2021-07-07', N'缺勤')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for t_student
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[t_student]') AND type IN ('U'))
	DROP TABLE [dbo].[t_student]
GO

CREATE TABLE [dbo].[t_student] (
  [studentId] int  NOT NULL,
  [stuNum] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [name] nvarchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [dormBuildId] int  NULL,
  [dormName] nvarchar(11) COLLATE Chinese_PRC_CI_AS  NULL,
  [sex] nvarchar(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [tel] nvarchar(15) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[t_student] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[t_student] VALUES (N'20193881', N'20193881', N'20193881', N'朱子杨', N'1', N'260', N'男', N'15614326606'), (N'20193911', N'20193911', N'20193911', N'朱思佳', N'2', N'419', N'女', N'1230'), (N'20193913', N'20193913', N'20193913', N'占善清', N'1', N'332', N'男', N'1234567890'), (N'20193948', N'20193948', N'20193948', N'韩慕瑶', N'2', N'419', N'女', N'456123'), (N'20193953', N'20193953', N'20193953', N'孙帅', N'1', N'310', N'男', N'789456'), (N'20193974', N'20193974', N'20193974', N'王赫', N'1', N'332', N'男', N'12345678'), (N'20193976', N'20193976', N'20193976', N'贺滨', N'1', N'260', N'男', N'1234567'), (N'20193984', N'20193984', N'20193984', N'李子怡', N'2', N'201', N'女', N'123456'), (N'20194010', N'20194010', N'20194010', N'方溪', N'1', N'260', N'男', N'123456789'), (N'20194024', N'20194024', N'20194024', N'张紫诺', N'2', N'419', N'女', N'123450'), (N'20194042', N'20194042', N'20194042', N'李向龙', N'1', N'260', N'男', N'12345678'), (N'20194061', N'20194061', N'20194061', N'邢金金', N'2', N'419', N'女', N'123789'), (N'20194095', N'20194095', N'20194095', N'耿亚晶', N'2', N'419', N'女', N'12340'), (N'20194119', N'20194119', N'20194119', N'张相龙', N'1', N'313', N'男', N'123456'), (N'20194120', N'20194120', N'20194120', N'王庆龙', N'1', N'332', N'男', N'15532985280'), (N'20194131', N'20194131', N'20194131', N'贾若曦', N'2', N'201', N'女', N'456789'), (N'20194165', N'20194165', N'20194165', N'李子征', N'1', N'332', N'男', N'123456'), (N'20194169', N'20194169', N'20194169', N'朱佳怡', N'2', N'201', N'女', N'123'), (N'20194171', N'20194171', N'20194171', N'常金悦', N'2', N'419', N'女', N'789123')
GO

COMMIT
GO


-- ----------------------------
-- Primary Key structure for table t_admin
-- ----------------------------
ALTER TABLE [dbo].[t_admin] ADD CONSTRAINT [PK__t_admin__AD0500A6F439B44C] PRIMARY KEY CLUSTERED ([adminId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table t_dorm
-- ----------------------------
ALTER TABLE [dbo].[t_dorm] ADD CONSTRAINT [PK__t_dorm__E9350A474EAB2C60] PRIMARY KEY CLUSTERED ([dormId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table t_dormbuild
-- ----------------------------
ALTER TABLE [dbo].[t_dormbuild] ADD CONSTRAINT [PK__t_dormbu__DBBB9DB528DB42BF] PRIMARY KEY CLUSTERED ([dormBuildId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table t_dormmanager
-- ----------------------------
ALTER TABLE [dbo].[t_dormmanager] ADD CONSTRAINT [PK__t_dormma__AE64DA0863F326D2] PRIMARY KEY CLUSTERED ([dormManId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table t_record
-- ----------------------------
ALTER TABLE [dbo].[t_record] ADD CONSTRAINT [PK__t_record__D825195ED8258E42] PRIMARY KEY CLUSTERED ([recordId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table t_student
-- ----------------------------
ALTER TABLE [dbo].[t_student] ADD CONSTRAINT [PK__t_studen__4D11D63CE7616036] PRIMARY KEY CLUSTERED ([studentId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

