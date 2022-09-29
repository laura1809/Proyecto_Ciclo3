const container = document.getElementById("categoriesContainer");

const categories = {
    "Comida": "https://res.cloudinary.com/dn1k0drir/image/upload/v1663687099/GIft%20Card/Food_qp0q0u.jpg",
    "Música": "https://res.cloudinary.com/dn1k0drir/image/upload/v1663687098/GIft%20Card/Music_lg9fvl.jpg",
    "Streaming": "https://res.cloudinary.com/dn1k0drir/image/upload/v1663687098/GIft%20Card/Streaming_zolkeu.jpg",
    "Videojuegos": "https://res.cloudinary.com/dn1k0drir/image/upload/v1663688565/GIft%20Card/Videogames_cdwxfd.jpg",
    "Ropa": "https://res.cloudinary.com/dn1k0drir/image/upload/v1663687098/GIft%20Card/Cloth_jbytnc.jpg"
};

let categorieHTML;


const sortCategories = () => {
    for (let key in categories) {
        categorieHTML = `
            <article class="mt-12 mx-auto hover:scale-105">
                <button id='${key}' onclick='paginaCategoria(this)'>
                    <img src="${categories[key]}" alt="Logo de la categoria" id="categorieLogo"
                    class="w-56 h-36 rounded-2xl object-cover" />
                </button>
                <h2 class="mt-2 text-lg text-center text-slate-200"> ${key} </h2>
            </article>
        `;

        container.innerHTML += categorieHTML;
    }
};

sortCategories();

function paginaCategoria(valor){
    let categoria = valor.id;
    document.location.href = "CardSelection.html?categoria=" + categoria;
    
};