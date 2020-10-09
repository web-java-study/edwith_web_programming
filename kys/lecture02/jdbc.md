# JDBC (Java Database Connectivity)
자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API  
자바를 이용한 데이터베이스 접속과 SQL 문장의 실행 그리고 실행결과로 얻어진 데이터의 핸들링을 제공하는 방법과 절차에 관한 규약

## try-width-resource
자바7 부터 지원하고 이 구문을 사용하면 자원을 쉽게 해제 할 수 있다.

**기존 try-catch-finally**
```java
try {
    Class.forName("com.mysql.jdbc.Driver");
    
    conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
    
    String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";
    
    ps = conn.prepareStatement(sql);
    
    ps.setInt(1, role.getRoleId());
    ps.setString(2, role.getDescription());
    
    insertCount = ps.executeUpdate();
    
} catch (Exception e) {
    e.printStackTrace();
} finally {
    // 반듯이 실행되야 하는 코드 작성 - 연결되었던 것들을 닫아주는 코드가 필요 
    // 각 객체별로 close(); 라는 메소드를 실행해 주면 된다. 
    // close() 를 수행 하다가도 예외사항이 발생 할 수 있기 때문에 역시 try~carch 구문으로 작성한다.
    // 값이 존재할때만 close를 발생 시키도록 분기처리 
    // 닫을 때에는 열렸던 순서와 반대 순서로 닫아주어야 한다.
    
    if (ps != null) {
        try {
            ps.close();	
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    if (conn != null) {
        try {
            conn.close();	
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
```

**새로운 사용법 try with resource**
```java
try {
    Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}

String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";

try (
    Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
    PreparedStatement ps = conn.prepareStatement(sql)
) {
    
    ps.setInt(1, role.getRoleId());
    ps.setString(2, role.getDescription());
    
    insertCount = ps.executeUpdate();
    
} catch (Exception e) {
    e.printStackTrace();
}
```

훨씬 적은 코드로 실행과 예외처리를 한꺼번에 수행하는것이 가능하다.


# DTO (Data Transfer Object)
Value Object 라고도 불린다.  

자바 클래스에서 오로지 정보를 보관하고 전달하는 역할로 생성된 클래스

### Role 이라는 클래스 객체 생성
해당 클래스는 roleId 와 description 의 정보를 담고있는 클래스 객체이다.  
정보를 묶어서 전달하고 사용하고 여러 메소드에서 요청이 들어올때마다 재사용이 가능하다.  


```java
public class Role {
	//	컬럼 두개를 담을 공간을 확보 
	// private 클래스 내에서만 접근가능
	// public 모든 클래스에서 접근 가능
	private Integer roleId;
	private String description;
	
	// 내부의 데이터를 담아서 내보낼 객체 생성 
	public Role(Integer roleId, String description) {
		super();
		this.roleId = roleId;
		this.description = description;
	}
	
	// 데이터를 꺼내고 넣는 부분을 수행해야 하기 때문에 getter 와 setter 메소드 필요 
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// 값들이 제대로 들어있나 확인하기 위한 출력용 toString
	// @override 하위클래스의 해당 메소드가 상위 클래스의 메소드를 덮어버릴떄 사용 
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
}
```
위와 같은 형식으로 원칙을 지켜 만드는것을 자바빈 이라고도 부른다.