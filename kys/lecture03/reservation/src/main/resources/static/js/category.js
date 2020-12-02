


// const init = async () => {
//     console.log(2)
//     const response = await fetch('/categorys');
//     console.log(1)
//     if (response.ok && response.status === 200) {
// 		console.log(response.json())
// 	}
// }

const category_ul = document.querySelector('.js_category_ul');
const event_count = document.querySelector('.js_count');
let responseData = null;

const renderCategory = (data) => {
  console.log(data)
  data.list.map(list => {
    const li = document.createElement('LI');
    const a = document.createElement('A');
    const span = document.createElement('SPAN');
    span.innerText = list.name;
    a.href = `?category_id=${list.id}`
    a.appendChild(span);
    li.appendChild(a);
    li.classList = 'item';
    a.classList = 'anchor';
    category_ul.appendChild(li);
  })
}

const renderProducts = (data) => {
  console.log(data.list);
  const count = data.list.length;
  event_count.innerText = `${count}개`;
  
}

const callApi = async (url) => {
  const responseData = await fetch(url)
    .then(res => {
      return res.json();
    })
    .then(data => {
      return data
    })
    .catch(err => {
      console.log('Fetch Error', err);
    })
    return responseData;
}

const init = async () => {
  const categorys = await callApi('/api/categorys');
  let products = null
  if (window.location.search) {
    products = await callApi(`/api/products?categoryId=${window.location.search.split('=')[1]}`)
  } else {
    products = await callApi('/api/products')
  }
  renderCategory(categorys);
  renderProducts(products);
}

window.onload = () => {
  init();
}