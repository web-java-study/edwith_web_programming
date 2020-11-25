


const init = async () => {
    console.log(2)
    const response = await fetch('/categorys');
    console.log(1)
    if (response.ok && response.status === 200) {
		console.log(response.json())
	}
}

init();