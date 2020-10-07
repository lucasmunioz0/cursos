class Componente {
    constructor(selector) {
        let el = document.querySelectorAll(selector);
        this.tag = el.length > 1 ? el : el[0];
    }

    render(data) {
        this.tag.innerText = data;
    }

    on(event, callback) {
        this.tag.addEventListener(event, callback);
    }
}

let form = new Componente("form");
let h1 = new Componente("h1");
let p = new Componente("p");
let span = new Componente("span");

form.on("submit", e => {
    e.preventDefault();
    let val = e.target[0].value;
    h1.render(val);
    p.render(val);
    span.render(val);
})