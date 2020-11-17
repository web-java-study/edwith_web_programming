var fs = require('fs');
const { resolve } = require('path');

//사용법 
//http://49.236.147.192:9090/swagger-ui.html#/%EC%83%81%ED%92%88%20API/getProductDisplayInfoUsingGET
//json 전송 타입에서의 출력데이터를 붙여넣는다.

//name -- >파일이름을 설정한다.
//data -- >json 전송타입을 data 변수의 형태로 붙여넣는다.

let name = "dto"
var data = `
"categoryId": 0,
"categoryName": "string",
"createDate": "2020-10-25T04:42:39.375Z",
"displayInfoId": 0,
"email": "string",
"homepage": "string",
"modifyDate": "2020-10-25T04:42:39.375Z",
"openingHours": "string",
"placeLot": "string",
"placeName": "string",
"placeStreet": "string",
"productContent": "string",
"productDescription": "string",
"productEvent": "string",
"productId": 0,
"telephone": "string"
	`

let file_name =(name)=>{
	return name+".txt";
}

let check_data = data.replace(/:.+,|:.+"|:.+[0-9]/g, "");
let check2_data = check_data.replace(/"/g, "");
let check3_data = check2_data.replace(/\t/g ,"");

let arr = [];
let variable_arr = [];
let get_set_method = [];

let split_data = check3_data.split("\n"); 
let length = split_data.length;

for(let i=0;i<length;i++){
	if(split_data[i].length==0){
		continue;
	}
	arr.push(split_data[i].trim());
}

let change_arr = (arr)=>{
	let prefix = "private ";
	let type ="";

	let check = [/Id/g,/score/g,/price/g,/Price/g,/Date/g];

	for(let i=0;i<arr.length;i++){
		
		for(let j=0;j<check.length;j++){
			type="String ";
				
			if(arr[i].match(check[j])!=null){
				if(j<=3){	
					type="int ";
				}else if(j==4){
					type="Date ";
				}
				break;
			}
		}
		variable_arr.push(prefix + type + arr[i]+";");
		get_set_method.push(get_set_method_(arr[i],type));
	}
}
	
let get_set_method_ = (data, type)=>{
	let temp;
	temp = "\n"+"public " + type +"get"+data.charAt(0).toUpperCase() + data.substr(1,data.length-1)
		+"(){ \n "
			+"\t"+"return " +data +";"
		+"\n}\n"
	
	temp +="\n"+"public void set"+ data.charAt(0).toUpperCase() + data.substr(1,data.length-1)+"("+type+data+") {\n"
		+"\t"+ "this."+data + "=" +data +";"
	+"\n}"
	return temp;
}

let set_data =()=>{
	let data = "";

	variable_arr.forEach((key)=>{
		data+= key +"\n";
	});

	get_set_method.forEach((key)=>{
		data+=key +"\n";
	});

	data+='\n'+'@Override \n'
		+ 'public String toString() {\n'
		+"\t"+'return "["';

	arr.forEach((key)=>{
		data += '+"'+key+'="'+'+'+key+" "
	})

	data+= '+"]";\n}'

	return data;
}

change_arr(arr);

fs.open(file_name(name),'a', (err,fd)=>{
	if(err) throw err;
	fs.write(fd,set_data(),0,'utf8', (err)=>{
		fs.close(fd,(err) =>{
			if(err) throw err;
		})
		if(err) throw err;
	});
});	

//let file_open = (name)=>{
//	return new Promise((resolve,reject)=>{
//		fs.open(name, 'a',(err, fd)=>{
//			if(err) throw reject(err);
//			resolve(fd);
//		});
//	})
//}

//let file_write = (fd,data)=>{
//	return new Promise((resolve,reject)=>{
//		fs.write(fd,data,0,'utf8', (err)=>{
//			if(err) throw reject(err);
//			resolve(fd);
//		});
//	});
//}

//let file_close = (fd) =>{
//	return new Promise((resolve,reject)=>{
//		fs.close(fd, (err)=>{
//			if(err) throw reject(err);
//			resolve(fd);
//		});
//	});
//}

//file_open(file_name(name))
//.then(fd =>{
//	return file_write(fd,set_data());
//}).then(fd =>{
//	return file_close(fd);
//}).catch(e=>{
//	console.log(e);
//})