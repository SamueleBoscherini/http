const buttonF = document.querySelector('#femmine')
const buttonM = document.querySelector('#maschi')
const input = document.querySelector('#input')
const buttonI = document.querySelector('#invio')
const buttonE = document.querySelector('#eta')
const buttonV = document.querySelector('#voto')
const select = document.querySelector('#hi')
let nome;
let eta;
let sesso;
let voto;
const div = document.querySelector('div')

buttonI.addEventListener('click',()=>{
    div.innerHTML = ''

    studenti.forEach(std =>{
        let name = std.nome
        if(name.includes(input.value)){

            nome = std.nome;
            eta = std.eta;
            voto = std.voto;
        
            if(std.sesso == 'm')
                sesso = "img/male.png"
            else  sesso = "img/female.png"
            init()
        }
    })
})


div.classList.add('container')
div.classList.add('row')
div.classList.add('text-center')
div.classList.add('ps-5')
div.classList.add('ms-5')

function init() {
    const card = `
    <div class="card" style="width: 18rem;">
        <img src="${sesso}" class="card-img-top" alt="">
        <div class="card-body">
            <h5 class="card-title">Nome: ${nome}</h5>
            <p class="card-text">Età: ${eta}</p>
            <p class="card-text">Voto: ${voto}</p>
        </div>
    </div>`

    const container = document.createElement('div')
    container.classList.add('col-4')
    container.innerHTML = card
    div.append(container)
}

function ciclo(x){
    x.forEach(std => {
        nome = std.nome;
        eta = std.eta;
        voto = std.voto;
    
        if(std.sesso == 'm')
            sesso = "img/male.png"
        else  sesso = "img/female.png"
        init()
    
        
    
    });
}

buttonM.addEventListener('click', ()=>{
    div.innerHTML = '';
    studenti.forEach(std => {
        if(std.sesso == 'm')
        {
            nome = std.nome;
            eta = std.eta;
            voto = std.voto;
            sesso = "img/male.png"

            init()
        }
    });
})

buttonF.addEventListener('click', ()=>{
    div.innerHTML = '';
    studenti.forEach(std => {
        if(std.sesso == 'f')
        {
            nome = std.nome;
            eta = std.eta;
            voto = std.voto;
            sesso = "img/female.png"

            init()
        }
    })
})

buttonE.addEventListener('click',()=>{
    div.innerHTML=''
        const copia = studenti.filter((std)=> std.voto > 24)
        ciclo(copia) 
})

buttonV.addEventListener('click', ()=> {
    div.innerHTML = ''
    const nuovo = studenti.find((std)=> std.voto == 18)
    nome = nuovo.nome;
    eta = nuovo.eta;
    voto = nuovo.voto;

    if(nuovo.sesso == 'm')
        sesso = "img/male.png"
    else  sesso = "img/female.png"
    init()
})

ciclo(studenti)

studenti.map((std) => std.nome).forEach( n =>{
    const option = document.createElement('option')
    option.innerHTML = nome
    console.log(option.innerHTML)
    select.append(option)
})






