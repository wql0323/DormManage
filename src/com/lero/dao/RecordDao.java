package com.lero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lero.model.DormBuild;
import com.lero.model.Record;

import static com.lero.util.StringUtil.isNotEmpty;

public class RecordDao {
	public List<Record> recordList(Connection con, Record s_record)throws Exception {
		List<Record> recordList = new ArrayList<>();
		StringBuffer sb = new StringBuffer("select * from t_record t1");
		if(isNotEmpty(s_record.getStuNum())) {
			sb.append(" and t1.stuNum like '%"+s_record.getStuNum()+"%'");
		} else if(isNotEmpty(s_record.getStudentName())) {
			sb.append(" and t1.studentName like '%"+s_record.getStudentName()+"%'");
		}
		if(s_record.getDormBuildId()!=0) {
			sb.append(" and t1.dormBuildId="+s_record.getDormBuildId());
		}
		if(isNotEmpty(s_record.getDate())) {
			sb.append(" and t1.date="+s_record.getDate());
		}
		if(isNotEmpty(s_record.getStartDate())){
			sb.append(" and TO_DAYS(t1.date)>=TO_DAYS('"+s_record.getStartDate()+"')");
		}
		if(isNotEmpty(s_record.getEndDate())){
			sb.append(" and TO_DAYS(t1.date)<=TO_DAYS('"+s_record.getEndDate()+"')");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Record record=new Record();
			record.setRecordId(rs.getInt("recordId"));
			record.setStuNum(rs.getString("stuNum"));
			record.setStudentName(rs.getString("studentName"));
			int dormBuildId = rs.getInt("dormBuildId");
			record.setDormBuildId(dormBuildId);
			record.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
			record.setDormName(rs.getString("dormName"));
			record.setDate(rs.getString("date"));
			record.setDetail(rs.getString("detail"));
			recordList.add(record);
		}
		return recordList;
	}
	
	public List<Record> recordListWithBuild(Connection con, Record s_record, int buildId)throws Exception {
		List<Record> recordList = new ArrayList();
		StringBuffer sb = new StringBuffer("select * from t_record t1");
		if(isNotEmpty(s_record.getStuNum())) {
			sb.append(" and t1.stuNum like '%"+s_record.getStuNum()+"%'");
		} else if(isNotEmpty(s_record.getStudentName())) {
			sb.append(" and t1.studentName like '%"+s_record.getStudentName()+"%'");
		}
		sb.append(" and t1.dormBuildId="+buildId);
		if(isNotEmpty(s_record.getStartDate())){
			sb.append(" and TO_DAYS(t1.date)>=TO_DAYS('"+s_record.getStartDate()+"')");
		}
		if(isNotEmpty(s_record.getEndDate())){
			sb.append(" and TO_DAYS(t1.date)<=TO_DAYS('"+s_record.getEndDate()+"')");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Record record=new Record();
			record.setRecordId(rs.getInt("recordId"));
			record.setStuNum(rs.getString("stuNum"));
			record.setStudentName(rs.getString("studentName"));
			int dormBuildId = rs.getInt("dormBuildId");
			record.setDormBuildId(dormBuildId);
			record.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
			record.setDormName(rs.getString("dormName"));
			record.setDate(rs.getString("date"));
			record.setDetail(rs.getString("detail"));
			recordList.add(record);
		}
		return recordList;
	}
	
	public static List<Record> recordListWithNumber(Connection con, Record s_record, String stuNum)throws Exception {
		List<Record> recordList = new ArrayList<Record>();
		StringBuffer sb = new StringBuffer("select * from t_record t1");
		if(isNotEmpty(stuNum)) {
			sb.append(" and t1.stuNum ="+stuNum);
		} 
		if(isNotEmpty(s_record.getStartDate())){
			sb.append(" and TO_DAYS(t1.date)>=TO_DAYS('"+s_record.getStartDate()+"')");
		}
		if(isNotEmpty(s_record.getEndDate())){
			sb.append(" and TO_DAYS(t1.date)<=TO_DAYS('"+s_record.getEndDate()+"')");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Record record=new Record();
			record.setRecordId(rs.getInt("recordId"));
			record.setStuNum(rs.getString("stuNum"));
			record.setStudentName(rs.getString("studentName"));
			int dormBuildId = rs.getInt("dormBuildId");
			record.setDormBuildId(dormBuildId);
			record.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
			record.setDormName(rs.getString("dormName"));
			record.setDate(rs.getString("date"));
			record.setDetail(rs.getString("detail"));
			recordList.add(record);
		}
		return recordList;
	}
	
	public List<DormBuild> dormBuildList(Connection con)throws Exception {
		List<DormBuild> dormBuildList = new ArrayList<DormBuild>();
		String sql = "select * from t_dormBuild";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			DormBuild dormBuild = new DormBuild();
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
	public Record recordShow(Connection con, String recordId)throws Exception {
		String sql = "select * from t_record t1 where t1.recordId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, recordId);
		ResultSet rs=pstmt.executeQuery();
		Record record = new Record();
		if(rs.next()) {
			record.setRecordId(rs.getInt("recordId"));
			record.setStuNum(rs.getString("stuNum"));
			record.setStudentName(rs.getString("studentName"));
			int dormBuildId = rs.getInt("dormBuildId");
			record.setDormBuildId(dormBuildId);
			record.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
			record.setDormName(rs.getString("dormName"));
			record.setDate(rs.getString("date"));
			record.setDetail(rs.getString("detail"));
		}
		return record;
	}
	
	public int recordAdd(Connection con, Record record)throws Exception {
		String sql = "insert into t_record values(?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, record.getRecordId());
		pstmt.setString(2, record.getStuNum());
		pstmt.setString(3, record.getStudentName());
		pstmt.setInt(4, record.getDormBuildId());
		pstmt.setString(5, record.getDormName());
		pstmt.setString(6, record.getDate());
		pstmt.setString(7, record.getDetail());
		String sql1="update t_student set recordCount = (SELECT COUNT(*) FROM t_record t WHERE t.stuNum=?) WHERE t_student.stuNum=?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, record.getStuNum());
		pstmt1.setString(2, record.getStuNum());
		int add=pstmt.executeUpdate();
		int update =pstmt1.executeUpdate();
		return add;
	}
	
	public int recordDelete(Connection con, String recordId)throws Exception {
		String sql = "delete from t_record where recordId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, recordId);
		String sql1="update t_student set recordCount = (SELECT COUNT(*) FROM t_record t WHERE t.stuNum in (SELECT stuNum from t_record WHERE recordId =?)) WHERE t_student.stuNum in (SELECT stuNum from t_record WHERE recordId =?)";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, recordId);
		pstmt1.setString(2, recordId);
		int delete =pstmt.executeUpdate();
		int update =pstmt1.executeUpdate();

		return delete;
	}

	public int recordUpdate(Connection con, Record record)throws Exception {
		String sql = "update t_record set stuNum=?,studentName=?,dormBuildId=?,dormName=?,detail=? where recordId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, record.getStuNum());
		pstmt.setString(2, record.getStudentName());
		pstmt.setInt(3, record.getDormBuildId());
		pstmt.setString(4, record.getDormName());
		pstmt.setString(5, record.getDetail());
		pstmt.setInt(6, record.getRecordId());
		String sql1="update t_student set recordCount = (SELECT COUNT(*) FROM t_record t WHERE t.stuNum=?) WHERE t_student.stuNum=?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, record.getStuNum());
		pstmt1.setString(2, record.getStuNum());
		int Update =pstmt.executeUpdate();
		int update =pstmt1.executeUpdate();
		return Update;
	}
	public int recordUpdateORAdd(Connection con, Record record)throws Exception
	{
		int r=0;  //接受返回值
		String sql="select * from t_record t1 where t1.recordId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, record.getRecordId());
		ResultSet rs=pstmt.executeQuery();

		/*
		 * 通过判断recordId是否已经存在，判断调用函数的类型
		 * 如果recordId已经存在，rs.next()为true，调用更新函数，
		 * 如果recordId不存在，rs.next()为false。调用添加函数，
		 */

		if(rs.next()) {
			r = recordUpdate(con, record);
		}
		else{
			r = recordAdd(con, record);
		}
		return r;
	}

	
}
