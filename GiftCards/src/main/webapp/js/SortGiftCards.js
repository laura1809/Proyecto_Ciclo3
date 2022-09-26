const container = document.getElementById("giftCardsContainer");
const inputSearch = document.getElementById('searchField');
const cards = document.getElementsByTagName('article');
var categoria = new URL(location.href).searchParams.get("categoria");


$(document).ready(function () {
    getTarjetas(categoria);
    searchCard();
    
});

function getTarjetas(categoria) {
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletTarjetaListar",
        data: $.param({
            categoria: categoria
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                sortGiftCards(parsedResult);
            } else {
                console.log("Error recuperando los datos de las tarjetas");
            }
        }
    });
}

const sortGiftCards = (tarjetas) => {
    
    let giftCardHTML ="";
    $.each(tarjetas, function (index, tarjeta) {
        tarjeta = JSON.parse(tarjeta);
        
        giftCardHTML += `
            <article class="mt-12 mx-auto hover:scale-105">
                <button id="${tarjeta.categoria} onclick="location.href='';"">
                    <img src="${tarjeta.ruta_imagen}" alt="Logo de la categoria" id="categorieLogo"
                    class="w-56 h-36 rounded-2xl object-cover "/>
                </button>
                <h2 class="mt-2 text-lg text-center text-slate-200"> ${tarjeta.nombre} </h2>
            </article>
        `;

    });

    $("#giftCardsContainer").html(giftCardHTML);
};

function searchCard(){
    inputSearch.addEventListener('keyup',(event)=>{
        let text = event.target.value;
        let er =new RegExp(text,'i');
        for(let i=0; i<cards.length; i++){
            let valor =cards[i];
            if(er.test(valor.innerText)){
                valor.style.display="block";
            } else {
                valor.style.display="none";
            }
        }
        
    });
}
