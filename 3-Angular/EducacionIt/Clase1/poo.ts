interface IPersona{
    apellido:string,
    nombre:string,
    edad:number,

    saludar(): void;
};

let pepe:IPersona = { 
    apellido : "Sanchez", 
    nombre: "Pepe", 
    edad: 40, 
    saludar : function() {
        console.log("Hola");
    }
};

class Persona implements IPersona{
    public apellido: string;
    public nombre: string;
    public edad: number;

    constructor(apellido:string, nombre:string, edad:number){
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
    }

    public saludar(){
        console.log("Me llamo " + this.nombre + ", " + this.apellido + " y tengo " + this.edad + " años.");
    }
}

class Empleado extends Persona{
    constructor(apellido:string, nombre:string, edad:number = 20, public cargo:string = "no soy nada"){
        super(apellido, nombre, edad);
    }

    public saludar(){
        super.saludar();
        console.log("y soy " + this.cargo);
    }
}


pepe.saludar();
let maria: Persona = new Persona("Lopez", "Maria", 45);

maria.saludar();

let fernando = new Empleado("Acevedo", "Fernando");
fernando.saludar();