interface Comida{
    nombre: string,
    calorias: number
}

function showComida(comida: Comida){
    document.getElementById("comida").innerHTML = `Tu ${comida.nombre} tiene ${comida.calorias} calorías.`;
}