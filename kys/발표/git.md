---
title: Git & Github
subtitle: git의 사용법에 대해 알아보기
author: 강용석
presentedAt: 2020-10-04
---


---

# git 이란?
![](https://lovemewithoutall.github.io/assets/images/Git-Logo-2Color.png)  

2005년 탄생
- 빠른속도
- 단순한 구조
- 비선형적 개발 : 동시다발적인 브랜치
- 완벽한 분산

---

# git 을 왜 사용하는가?
- 프로젝트의 버전관리
- 로컬에서 히스토리를 추적하기때문에 네트워크가 연결된 상황이 아니더라도 언제든지 사용가능
- CLI 명령어로 모든걸 할 수 있음
- 스냅샷으로 저장된 상태 그러니까 commit만 되어있었다면 언제든지 원하는 시점으로 되돌아가거나 다시 현재 시점으로 돌아오는것이 가능하다.


---

# git 을 사용하는 방법
git 을 사용할 수 있는 방법에는 크게 두가지가 있는데 CLI 와 GIU 가 있다.  


---

# CLI

## git init : .git 파일 생성
## git add : 변경사항 commit 준비
## git commit : 변경사항 내용과 함께 stage에 올리기 스냅샷찍기
## git status : 현재 상태 확인
## git pull : 리모트의 변경사항 내 로컬로 받아서 merge 하기
## git push : stage에 올라간 변경사항 remote 서버로 업로드


---

# GUI
![](https://www.sourcetreeapp.com/dam/jcr:51aa63f9-8e33-4177-8ef9-54b4bdb09a69/sourcetree_rgb_darkblue_atlassian_1200x630.png)
![](https://zeddrix.com/wp-content/uploads/2020/03/git-960x540.png)


---

# CLI 로 사용하기를 추천
GUI는 개인프로젝트나 간단한 작업관리를 위해서는 사용하기 편하지만 실무에서는 많은 사람들이 협업을 하고 
복잡한 과정들을 거치기 때문에 모든 기능활용이 가능한 CLI 명령어로 사용하기를 추천합니다.
---

# git 사용하기
1. 로컬에 프로젝트 폴더 생성하기
```console
mkdir folderName
cd folderName
```
2. .git 파일 생성하기
```console
git init
```
3. github 리모트 저장소 repo 생성

![alt text](https://i.ibb.co/sJJXmzP/2020-10-02-2-59-55.png)   


---

# git 사용하기
3. github 리모트 저장소 repo 생성

![](https://i.ibb.co/VqfGkfM/2020-10-02-3-11-28.png)
---
# git 사용하기
4. 내 로컬과 리모트 저장소 연결하기

![](https://i.ibb.co/5knWDcV/2020-10-02-3-15-37.png)
---

# 현재 필요한것
- git init
- git status
- git add
- git commit
- git pull
- git push
- git log
- git remote

---
# 실무에서 필요한것
- git rebase
- git merge
- git branch
- git flow
- git checkout
- git reset
- git revert

---
# 이걸 다 외워야 하나?
자주쓰는건 쓰다보면 자동으로 외워지고  
모르면 찾아보면됩니다.  





