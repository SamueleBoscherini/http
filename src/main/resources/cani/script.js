const select = document.querySelector('#s')
const container = document.querySelector('#container')
let responde2 = "";
let imgg = "";
let url = ``;

async function getData(){
    const responde = await fetch("https://dog.ceo/api/breeds/list/all")
    const razza = await responde.json()


    for (const palle in razza.message) {
        const option = document.createElement('option')
        option.innerHTML = palle
        select.append(option)

       
    }    
}

async function evento(x){
    url = `https://dog.ceo/api/breed/${x}/images`
    const responde2 = await fetch(url)
    const imgg = await responde2.json()
    console.log(imgg)
}

select.addEventListener('change',(e) =>{
    evento(e.target.value).then(()=>{
        imgg.message.forEach(imgUrl => {
            const foto = document.createElement('img')
            foto.src = imgUrl
            container.append(foto)
    });
    })
    
})


getData()