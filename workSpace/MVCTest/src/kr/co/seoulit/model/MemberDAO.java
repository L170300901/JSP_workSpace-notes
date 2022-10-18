package kr.co.seoulit.model;

import java.sql.*;
import java.util.*;

import kr.co.seoulit.util.DBUtil;

public class MemberDAO {
	private static MemberDAO instance;
	private MemberDAO(){}
	public static MemberDAO getInstance(){
		if(instance==null)
			instance=new MemberDAO();
		return instance;
	}
	public void deleteMember(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("delete from member where id=?");
					
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch(SQLException sqle) {
			System.out.println("MemberDAO:deleteMember:SQLException");
			throw new RuntimeException(sqle.getMessage());			
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( con != null ){ con.close(); con=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}		
	}
	public void updateMember(Member member){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("update member set ");
			query.append("pw=?,addr=?,tel=? where id=?");
					
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getAddr());
			pstmt.setString(3, member.getTel());
			pstmt.setString(4, member.getId());
			pstmt.executeUpdate();
		} catch(SQLException sqle) {
			System.out.println("MemberDAO:updateMember:SQLException");
			throw new RuntimeException(sqle.getMessage());			
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( con != null ){ con.close(); con=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public void insertMember(Member member){
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("insert into member values");
			insertQuery.append("(?, ?, ?, ?)");		
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getTel());
			
			pstmt.executeUpdate();
		} catch(SQLException sqle) {
			System.out.println("MemberDAO:insertMember:SQLException");
			throw new RuntimeException(sqle.getMessage());			
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( con != null ){ con.close(); con=null;	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	public ArrayList<Member> selectMemberList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer listQuery = new StringBuffer();
			listQuery.append("select * from member");	
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(listQuery.toString());
			rs = pstmt.executeQuery();
			ArrayList<Member> v=new ArrayList<Member>();

			while(rs.next()){
				Member member=new Member();
				member.setId(rs.getString("id"));
				v.add(member);
			}
			return v;
		} catch(SQLException sqle) {
			System.out.println("MemberDAO:selectMemberList:SQLException");
			throw new RuntimeException(sqle.getMessage());			
		} finally {
			try{
			if ( rs != null ){rs.close(); rs=null; }
			if ( pstmt != null ){ pstmt.close(); pstmt=null; }
			if ( con != null ){ con.close(); con=null;	}
			}catch(Exception e){
			throw new RuntimeException(e.getMessage());
			}
		}
	}

	public Member selectMember(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			StringBuffer selectQuery = new StringBuffer();
			selectQuery.append("select * from member where id=?");
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(selectQuery.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;

			if(rs.next()){
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
			}
			
			return member;	
		} catch(SQLException sqle) {
			throw new RuntimeException(sqle.getMessage());		
		} finally {
			try{
			if ( rs != null ){rs.close();}			
			if ( pstmt != null ){pstmt.close();}			
			if ( con != null ){con.close();	}
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}			
	}	

}
