package com.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class UserDAO {
	Connection con = null;              // DB 연결하는 객체.
	PreparedStatement pstmt = null;     // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;                // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                  // 쿼리문을 저장할 객체.

	// 싱글톤 방식으로 BoardDAO 객체를 만들자.
	// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로 
	//       기본생성자의 접근제어자를  private 으로 선언을 해야 함.
	// 2단계 : 정적 멤버로 선언을 해야 함 - static 으로 선언을 한다는 의미.
	private static UserDAO instance = null;
	
	// 3단계 : 외부에서 객체 생성을 하지 못하게 접근을 제어 - private 기본 생성자를 만듬.
	private UserDAO() { }
	
	// 4단계 : 기본 생성자 대신에 싱긑턴 객체를 return을 해 주는 getInstance()
	//        메서드를 만들어서 여기에 접근하게 하는 방법
	
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}  // getInstance() 메서드 end
	
	// DB 연동하는 작업을 진행하는 메서드 - DBCP방식으로 연결 진행
	public void openConn() {
		
		
		try {
			// 1단계 : JNDI 서버 객체 생성.
//			Context ctx = new InitialContext();
//			
//			// 2단계 : lookup() 메서드를 이용하여 매칭되는 커넥션을 찾는다.
//			DataSource ds = 
//				(DataSource)ctx.lookup("jdbc/Mysqles");
			
			
			Context context = new InitialContext();

			Context envContext = (Context)context.lookup("java:comp/env"); 

			DataSource ds = (DataSource)envContext.lookup("jdbc/Mysqles");


			// 3단계 : DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  // openConn() 메서드 end
	
	
	// DB에 연결된 객체를 종료하는 메서드 
	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {
		
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} // closeConn() 메서드 end 
	
		
	// 회원가입
		public int InsertUser(UserDTO dto){
	    
	    int result = 0;
		
		
	    try {
			openConn();
			
			sql = "insert into member values(?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn(rs,pstmt,con);
		}
		   return result;
		
		}
		
	// 로그인 확인
		public int Login(String id, String pwd) {
			int result = 0;
			
			try {
				openConn();
				sql="select count(*) from member where id = ? and pwd = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt(1); 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
		
	// 마이페이지
		public List<UserDTO> getUser(String id){
	           List<UserDTO> list = new ArrayList<>();
	            try {

	                openConn();

	                sql="select * from member where id = ?";
	                pstmt = con.prepareStatement(sql);
	                pstmt.setString(1, id);
	                
	                rs = pstmt.executeQuery();

	                while(rs.next()) {
	                    UserDTO dto = new UserDTO();
	                    dto.setId(rs.getString("id"));
	                    dto.setName(rs.getString("name"));
	                    dto.setAge(Integer.parseInt(rs.getString("age")));
	                    dto.setPhone(rs.getString("phone"));
	                    dto.setEmail(rs.getString("email"));

	                    list.add(dto);

	                }
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }finally {
	                closeConn(rs,pstmt,con);
	            }
	            return list;
		}
		
	// 마이페이지 업데이트
		public int updateUser(String name, int age, String phone, String email, String id){
			 int result = 0;
	            try {

	                openConn();

	                sql="update member SET name = ?, age = ?, phone = ?, email = ? where id = ?";
	                pstmt = con.prepareStatement(sql);
	                pstmt.setString(1, name);
	                pstmt.setInt(2, age);
	                pstmt.setString(3, phone);
	                pstmt.setString(4, email);
	                pstmt.setString(5, id);
	                
	                result = pstmt.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						closeConn(rs,pstmt,con);
					}
					   return result;
					
					}
		
	// 비밀번호 업데이트
		public int updatePwd(String pwd, String id, String oldpwd) {
			 int result = 0;
	            try {

	                openConn();

	                sql="update member SET pwd = ? where id = ? and pwd = ?";
	                pstmt = con.prepareStatement(sql);
	                pstmt.setString(1, pwd);
	                pstmt.setString(2, id);
	                pstmt.setString(3, oldpwd);
	                
	                result = pstmt.executeUpdate();
	                
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						closeConn(rs,pstmt,con);
					}
					   return result;
					
					}
		
// 비밀번호 얻어오기
	public String selectPwd(String id) {
		String result = "";
		try {
			openConn();
			sql="select pwd from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
// 회원 탈퇴
	public int deleteUser(String id) {
		int result = 0;
        try {

            openConn();

            sql="delete from member where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            
            result = pstmt.executeUpdate();
            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeConn(rs,pstmt,con);
			}
			   return result;
			
		}
	}

