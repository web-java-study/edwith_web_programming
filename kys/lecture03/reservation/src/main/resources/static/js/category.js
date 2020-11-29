


// const init = async () => {
//     console.log(2)
//     const response = await fetch('/categorys');
//     console.log(1)
//     if (response.ok && response.status === 200) {
// 		console.log(response.json())
// 	}
// }

const category_ul = document.querySelector('.js_category_ul');
let responseData = null;

const renderCategory = (data) => {
  console.log(data)
  data.map(list => {
    const li = document.createElement('LI');
    const a = document.createElement('A');
    const span = document.createElement('SPAN');
    span.innerText = list.name;
    a.href = `?id=${list.id}`
    a.appendChild(span);
    li.appendChild(a);
    li.classList = 'item';
    a.classList = 'anchor';
    category_ul.appendChild(li);
  })
}

const init = async () => {
  await fetch('/api/categorys')
    .then(res => {
      return res.json();
    })
    .then(data => {
      responseData = data
    })
    .catch(err => {
      console.log('Fetch Error', err);
    })
    renderCategory(responseData.list)
}

init();