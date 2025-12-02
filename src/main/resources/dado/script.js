const simula = document.querySelector('#simula');
const stop = document.querySelector('#stop');
const immagine = document.querySelector('#immagine');
let controllo = true
let intervallo;
const pulisci = document.querySelector('#clear');
const array = [
    "uno.png",
    "due.png",
    "tre.png",
    "quattro.png",
    "cinque.png",
    "sei.png"
]

function auto(){
    if(controllo){
        intervallo = setInterval(fotoCas,200);
        controllo = false;
    }
}

function fotoCas(){
    const nuovaImmagine = document.createElement('img');
    nuovaImmagine.src = "img/" + array[random()];
    immagine.append(nuovaImmagine);
}

function random(){
    let rand = Math.floor(Math.random() * 6);
    return rand;
}

function stopp(){
    clearInterval(intervallo);
    controllo = true;
}

function clear(){
    immagine.innerHTML = '';
    controllo = true;
}

simula.addEventListener('click', auto);
stop.addEventListener('click', stopp);
pulisci.addEventListener('click', clear);