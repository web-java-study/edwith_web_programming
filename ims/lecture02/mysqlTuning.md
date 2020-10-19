# MySQL 튜닝

## 1. 데이터베이스 엔진

- **MyiSAM 마이아이삼**
    
    Table Level 테이블 단위 Locking 
    
    -> 한 테이블에서 Update가 되는 동안에는 다른 작업이 불가능

    MySQL 5.5이하 버전의 Default Engine

    많은 접근이 이루어질수록 처리 속도 저하

    트랜잭션 미지원( ex) 커밋, 롤백,,, )

- **InnoDB 이노디비**    

    Row level 행 단위 locking 

    -> DML(insert, update, delete 등)이 빈번히 발생할 때 유리

    트랜잭션 지원 (백업)

    Ibdata 실제로 데이터가 저장되는 공간

## 2. 이중화 솔루션

- **Replication**

    단방향 동기화, Master/ Slave 구성 (1:n)

    다른 서버의 공간에 동일한 데이터를 복제(동기화)

    Master 서버에서만 insert가 가능하다 (Slave에서는 불가능)

    Auto Failover 미지원 -> master로 승격은 수동으로

- **MHA**

    Replication + Auto Failover(MHA manager가 승격시켜줌)

    Master에서만 작업 가능

    Master와 Slave는 하나의 VIP를 공유하고, 다운타임을 최소화시킨다.

- **Galega Cluster 갈레라 클러스터**

    모든 node에서 insert 작업이 가능()

    Table 단위 locking

    