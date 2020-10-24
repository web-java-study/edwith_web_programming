/**
 * 
 */



const getTodoList = async () => {
	const response = await fetch('/todo/todos');
	if (response.ok && response.status === 200) {
		return response.json();
	}
	alert(response.status);
}

const viewList = (data) => {
	const todo = document.querySelector('.TODO');
	const doing = document.querySelector('.DOING');
	const done = document.querySelector('.DONE');
	
	data && data.map(item => {
		const h3 = document.createElement('H3');
		const li = document.createElement('LI');
		const p = document.createElement('P');
		const btn = document.createElement('BUTTON');
		
		h3.innerText = item.title;
		btn.innerText = '=>';
		p.innerText = `등록날짜 ${item.regdate} ${item.name} 우선순위 ${item.sequence}`;
		
		btn.classList.add('move');
		btn.setAttribute('title', item.type);
		h3.classList.add('title');
		
		li.appendChild(h3);
		li.appendChild(p);
		item.type !== 'DONE' && li.appendChild(btn);
		switch(item.type) {
			case 'TODO':
				todo.appendChild(li);
				break;
			case 'DOING':
				doing.appendChild(li);
				break;
			case 'DONE':
				done.appendChild(li);
				break;
			default:
				break;
		}
	})
}

const moveItem = async () => {
	const moveBtn = document.querySelectorAll('.move');
	[...moveBtn].map(btn => {
		btn.addEventListener('click', (e) => {
			const body = {
				title: e.target.previousSibling.previousSibling.innerText,
				type: e.target.title === 'TODO' ? 'DOING' : 'DONE'
			}

			fetch('/todo/update', {
				method: 'POST',
				body: JSON.stringify(body),
				headers:{
				    'Content-Type': 'application/json'
				  }
			})
			.then(res => {
				console.log(res)
				if (res.ok) {
					console.log('이동완료');
					location.reload(true);
				}
			})
			.catch(err => console.log(err))
		})
	})
}

const moveToPage = (target, url) => {
	if (target) {
		target.addEventListener('click', () => {
			location.href = url;
		})	
	}
}

const init = async () => {
	const data = await getTodoList();
	const move_write_btn = document.querySelector('.move_write_btn');
	const registerUrl = "/todo/registerTodo.jsp";
	moveToPage(move_write_btn, registerUrl);
	viewList(data);
	moveItem();
}

init();