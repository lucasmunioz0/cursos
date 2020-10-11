let items = [
    "Comida chicos 1","Comida chicos 2","Comida chicos 3","Comida chicos 4","Comida chicos 5","Comida chicos 6",
]

class Menu{
    constructor(public items: Array<string>, 
                public paginas: number, 
                public display: string = "Menu"){}
    
    listar(): void{
        let ul = `<h1>${this.display}</h1><ul>`;
        this.items.forEach(item => {
            ul += `<li>${item}</li>`;
            console.log(item);
        });
        document.getElementById("listado").innerHTML = `${ul}</ul>`;
    }
}

class MenuChicos extends Menu{
    constructor(
        public items: Array<string>,
        public paginas: number
    ){
        super(items, paginas, "Menu de Chicos");
    }
}

function show(mensaje: string){
    document.getElementById("showItems").innerHTML = mensaje;
}

