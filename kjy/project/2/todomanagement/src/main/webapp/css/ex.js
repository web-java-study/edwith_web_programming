function make_sql(){
	for(var i =0; i<18;i++){
		if(i%3==1){
			console.log(`
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', `+i%3+`); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', `+i%3+`);`
			);
		}else if(i%3==2){
			console.log(`
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', `+i%3+`); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', `+i%3+`);`
			);
		}else{
			console.log(`
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', `+3+`); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', `+3+`);`
			);
		}	
	}
	
}

make_sql();
