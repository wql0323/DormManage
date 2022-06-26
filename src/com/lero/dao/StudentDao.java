package com.lero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lero.model.DormBuild;
import com.lero.model.Student;
import com.lero.util.StringUtil;

public class StudentDao {


	
	public List<Student> studentList(Connection con, Student s_student)throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		StringBuffer sb = new StringBuffer("select * from t_student t1");
		if(StringUtil.isNotEmpty(s_student.getName())) {
			sb.append(" and t1.name like '%"+s_student.getName()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getStuNum())) {
			sb.append(" and t1.stuNum like '%"+s_student.getStuNum()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getDormName())) {
			sb.append(" and t1.dormName like '%"+s_student.getDormName()+"%'");
		}
		if(s_student.getDormBuildId()!=0) {
			sb.append(" and t1.dormBuildId="+s_student.getDormBuildId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Student student=new Student();
			student.setStudentId(rs.getInt("studentId"));
			int dormBuildId = rs.getInt("dormBuildId");
			student.setDormBuildId(dormBuildId);
			student.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
			student.setDormName(rs.getString("dormName"));
			student.setName(rs.getString("name"));
			student.setSex(rs.getString("sex"));
			student.setStuNum(rs.getString("stuNum"));
			student.setTel(rs.getString("tel"));
			student.setPassword(rs.getString("password"));
			student.setRecordCount(rs.getInt("recordCount"));
		    studentList.add(student);
		}
		return studentList;
	}
	
	public static Student getNameById(Connection con, String studentNumber, int dormBuildId)throws Exception {
		String sql = "select * from t_student t1 where t1.stuNum=? and t1.dormBuildId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, studentNumber);
		pstmt.setInt(2, dormBuildId);
		ResultSet rs=pstmt.executeQuery();
		Student student = new Student();
		if(rs.next()) {
			student.setName(rs.getString("name"));
			student.setDormBuildId(rs.getInt("dormBuildId"));
			student.setDormName(rs.getString("dormName"));
		}
		return student;
	}
	
	public boolean haveNameByNumber(Connection con, String studentNumber)throws Exception {
		String sql = "select * from t_student t1 where t1.stuNum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, studentNumber);
		ResultSet rs=pstmt.executeQuery();
		Student student = new Student();
		if(rs.next()) {
			student.setName(rs.getString("name"));
			student.setDormBuildId(rs.getInt("dormBuildId"));
			student.setDormName(rs.getString("dormName"));
			return true;
		}
		return false;
	}
	
	public List<Student> studentListWithBuild(Connection con, Student s_student, int buildId)throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		StringBuffer sb = new StringBuffer("select * from t_student t1");
		if(StringUtil.isNotEmpty(s_student.getName())) {
			sb.append(" and t1.name like '%"+s_student.getName()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getStuNum())) {
			sb.append(" and t1.stuNum like '%"+s_student.getStuNum()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getDormName())) {
			sb.append(" and t1.dormName like '%"+s_student.getDormName()+"%'");
		}
		sb.append(" and t1.dormBuildId="+buildId);
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Student student=new Student();
			student.setStudentId(rs.getInt("studentId"));
			int dormBuildId = rs.getInt("dormBuildId");
			student.setDormBuildId(dormBuildId);
			student.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
			student.setDormName(rs.getString("dormName"));
			student.setName(rs.getString("name"));
			student.setSex(rs.getString("sex"));
			student.setStuNum(rs.getString("stuNum"));
			student.setTel(rs.getString("tel"));
			student.setPassword(rs.getString("password"));
			student.setRecordCount(rs.getInt("recordCount"));
			studentList.add(student);
		}
		return studentList;
	}

	public List<DormBuild> dormBuildList(Connection con)throws Exception {
		List<DormBuild> dormBuildList = new ArrayList<DormBuild>();
		String sql = "select * from t_dormBuild";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			DormBuild dormBuild=new DormBuild();
			dormBuild.setDormBuildId(rs.getInt("dormBuildId"));
			dormBuild.setDormBuildName(rs.getString("dormBuildName"));
			dormBuild.setDetail(rs.getString("dormBuildDetail"));
			dormBuildList.add(dormBuild);
		}
		return dormBuildList;
	}
	
	/*public int studentCount(Connection con, Student s_student)throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from t_student t1");
		if(StringUtil.isNotEmpty(s_student.getName())) {
			sb.append(" and t1.name like '%"+s_student.getName()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getStuNum())) {
			sb.append(" and t1.stuNum like '%"+s_student.getStuNum()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getDormName())) {
			sb.append(" and t1.dormName like '%"+s_student.getDormName()+"%'");
		}
		if(s_student.getDormBuildId()!=0) {
			sb.append(" and t1.dormBuildId="+s_student.getDormBuildId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}*/
	
	public Student studentShow(Connection con, String studentId)throws Exception {
		String sql = "select * from t_student t1 where t1.studentId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, studentId);
		ResultSet rs=pstmt.executeQuery();
		Student student = new Student();
		if(rs.next()) {
			student.setStudentId(rs.getInt("studentId"));
			int dormBuildId = rs.getInt("dormBuildId");
			student.setDormBuildId(dormBuildId);
			student.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
			student.setDormName(rs.getString("dormName"));
			student.setName(rs.getString("name"));
			student.setSex(rs.getString("sex"));
			student.setStuNum(rs.getString("stuNum"));
			student.setTel(rs.getString("tel"));
			student.setPassword(rs.getString("password"));
			student.setRecordCount(rs.getInt("recordCount"));
		}
		return student;
	}
	
	public int studentAdd(Connection con, Student student)throws Exception {
		String sql = "insert into t_student values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(student.getStuNum()));
		pstmt.setString(2, student.getStuNum());
		pstmt.setString(3, student.getPassword());
		pstmt.setString(4, student.getName());
		pstmt.setInt(5, student.getDormBuildId());
		pstmt.setString(6, student.getDormName());
		pstmt.setString(7, student.getSex());
		pstmt.setString(8, student.getTel());
		return pstmt.executeUpdate();
	}
	
	public int studentDelete(Connection con, String studentId)throws Exception {
		String sql = "delete from t_student where studentId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, studentId);
		return pstmt.executeUpdate();
	}
	
	public int studentUpdate(Connection con, Student student)throws Exception {
		String sql = "update t_student set stuNum=?,password=?,name=?,dormBuildId=?,dormName=?,sex=?,tel=? where studentId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNum());
		pstmt.setString(2, student.getPassword());
		pstmt.setString(3, student.getName());
		pstmt.setInt(4, student.getDormBuildId());
		pstmt.setString(5, student.getDormName());
		pstmt.setString(6, student.getSex());
		pstmt.setString(7, student.getTel());
		pstmt.setInt(8, student.getStudentId());
		return pstmt.executeUpdate();
	}
	public int studentUpdateORAdd(Connection con,Student student) throws Exception{
		int r=0; //接受返回值
		String sql = "select * from t_student t1 where t1.studentId = ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,student.getStudentId());
		ResultSet rs= pstmt.executeQuery();
		/*
		通过判断studentId是否存在，选择调用函数的类型
		如果studentId已经存在，rs.next()为true，选择更新函数
		如果studentId不存在，rs.next()为false，选择添加函数
		 */
		if(rs.next()){
			r=studentUpdate(con,student);
		}
		else{
			r=studentAdd(con,student);
		}
		return r;

	}
	
}
