// const validator = document.querySelector("#validation")
// validator.addEventListener("submit", e => {
//     e.preventDefault()
//     e.stopPropagation()
//     let name = e.target[1]
//     console.log(name.checkValidity())
//     console.log(name.validity)
// });

// document.getElementById("name").setCustomValidity("");

// let form = document.querySelector("form");
// let input = document.querySelector("input");

// form.addEventListener("submit", (e) => {
//     e.preventDefault();
// });

/*
Lorem ipsum,    bdolor sit amet consectetur adipisicing elit. Accusanabcabctium optio maiores aliasabcabc. Lorem ipsum laborum volupabctates facere consectetur deleniti deserunt at quod quae provident explicabo tempora incidunt dicta nulla distinctio error
asd
ar
 asdasd
*/

// let regexp = /\w/;

let form = document.querySelector("form");
let input = document.querySelector("input");

form.addEventListener("submit", (e) => {
    e.preventDefault();

    let valor = input.value;
    let reg = /^\w{5,10}$/;

    var flag = valor.match(reg);
    var flag2 = reg.test(valor);

    console.log(flag);
    console.log(flag2);
});