var hamburguesa: string = "Hamburguesa";
var calorias: number = 300;
var saborRico: boolean = true;

function informar(comida: string, calorias: number){
    document.getElementById("informar").innerHTML = `Tu ${comida} tiene ${calorias} calorias`;
}

informar(hamburguesa, calorias);

class Menu{
    items: Array<string>;
    hide: boolean = true;
    display: string = '';

    constructor(list_items: Array<string>){
        this.items = list_items;
    }

    listar():void{
        if(this.hide){
            this.display = "<h3>Nuestro menú para hoy:</h3>";
            this.display +=  "<ul>";
            this.items.forEach(element => {
                this.display += `<li>${element}</li>`
            });
            this.display += "</ul>";
            this.hide = false;
        }else{
            this.display = '';
            this.hide = true;
        }
        document.getElementById("menu").innerHTML = this.display;
    }
}

let menu: Menu = new Menu(['Plato 1', 'Plato 2', 'Plato 3']);


function listar(){
    menu.listar();
}

function listarChicos(){
    menuChicos.listar();
}

class MenuChicos extends Menu{
    display: string = '';

    constructor(list_items: Array<string>){
        super(list_items);
    }

    listar():void{
        if(this.hide){
            this.display = '<h3>Nuestro menu especial para los chicos</h3>';
            this.display += "<ul>";
            this.items.forEach(e => {
                this.display += `<li>${e}</li>`
            });
            this.display += "</ul>";
            this.hide = false;
        }else{
            this.display = '';
            this.hide = true;
        }
        
        document.getElementById("menuChicos").innerHTML = this.display;
    }
}

let menuChicos: Menu = new MenuChicos(['Plato Chico 1', 'Plato Chico 2', 'Plato Chico 3']);

interface MenuEmpleado{
    nombre: string;
    calorias: number;
}

function obtenerMenuEmpleado(comida: MenuEmpleado):void{
    let display = `<p>El Menú de los emplññeados tienen ${comida.calorias} calorías. Y está compuesta por ${comida.nombre}</p>`;
    document.getElementById("menuEmpleados").innerHTML = display;
}

const helado = {
    nombre: "helado",
    calorias: 300
}

function mostrarMenuEmpleado(){
    obtenerMenuEmpleado(helado);
}
