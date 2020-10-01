const inputs = document.querySelectorAll("input[type=number]");
const elementsToEnable = document.querySelectorAll(".disabled");
const tableBody = document.getElementsByTagName("tbody")[0];
const image = document.getElementById("image");
const btnNewGame = document.getElementById("new-game");
const btnResetGame = document.getElementById("reset-game");
const btnGiveUp = document.getElementById("give-up");
const btnGuess = document.getElementById("guess");
const alert = document.getElementById("alert");
let attempts = 0;
let objetive = [];

for (var i = 0; i < inputs.length; i++) {
    inputs[i].setAttribute("min", "0");
    inputs[i].setAttribute("max", "9");
    inputs[i].addEventListener('keypress', function(event) {
        validateInput(event, this);
    });
    inputs[i].addEventListener('focus', cleanInput);
}

function validateInput(event, input) {
    if (event.key === "e") {
        event.preventDefault();
        return;
    }
    if (input.value.length > 0) {
        event.preventDefault();
    }
}

function cleanInput() {
    this.value = "";
}

function enable(flag) {
    if (flag) {
        elementsToEnable.forEach(element => {
            element.classList.remove("disabled");
        });
    } else {
        elementsToEnable.forEach(element => element.classList.add("disabled"));
    }
}

btnNewGame.addEventListener("click", newGame);

function newGame() {
    objetive = generateRandomNumber(4);
    image.setAttribute("src", "images/homero-playing.jpg");
    inputs.forEach(element => element.value = "");
    alert.classList.add("hidden");
    alert.innerHTML = "";

    btnNewGame.classList.add("disabled");
    tableBody.innerHTML = "";

    enable(true);
}

function generateRandomNumber(size) {
    var array = [size];
    for (var i = 0; i < size;) {
        var number = Number.parseInt(Math.random() * 10);
        if (!array.includes(number)) {
            array[i] = number;
            i++;
        }
    }

    return array;
}

btnGiveUp.addEventListener("click", giveUp);

function giveUp() {
    alert.classList = "alert";
    alert.classList.add("alert-danger");
    alert.innerHTML = `El número era: <b> ${objetive.join(" - ")}</b>`;
    image.setAttribute("src", "images/springfield-boom.jpg");
    enable(false);
    btnNewGame.classList.remove("disabled");
}

btnGuess.addEventListener("click", guess);

function guess() {
    var inputNumbers = [];

    inputs.forEach(element => {
        inputNumbers.push(Number.parseInt(element.value));
    });

    var flag = validateNumbers(inputNumbers);

    if (flag != "") {
        showMessage("danger", flag);
        image.setAttribute("src", "images/homer-oficine.jpg");
    } else {
        attempts++;
        var goodDigits = 0;
        var regularDigits = 0;

        for (var i = 0; i < objetive.length; i++) {
            if (inputNumbers[i] == objetive[i]) {
                goodDigits++;
            } else if (objetive.includes(inputNumbers[i])) {
                regularDigits++;
            }
        }

        addNewAttempt(inputNumbers, goodDigits, regularDigits);

        if (goodDigits == objetive.length) {
            winGame();
        } else {
            showMessage("warning", `No adivinaste, cifras REGULARES: ${regularDigits}, BUENAS: ${goodDigits}`);
            image.setAttribute("src", "images/homero-thinking.png");
        }

    }

}

function validateNumbers(numbers) {
    var flag = "";

    for (var element of numbers) {
        if (Number.isNaN(element)) {
            flag = "Los números ingresados no son válidos, por favor rellene todas las cifras.";
            break;
        }
    }

    if (flag == "") {
        var array = [];
        numbers.forEach(element => {
            if (!array.includes(element)) {
                array.push(element);
            }
        })
        if (array.length < numbers.length) {
            flag = "Las cifras no se deben repetir. Intente nuevamente";
        }
    }

    return flag;
}

function showMessage(type, message) {
    var messageClass = "alert-" + type;
    alert.classList = "alert";
    alert.classList.add(messageClass);
    alert.innerHTML = message;
}

function addNewAttempt(numbers, goodDigits, regularDigits) {
    var newRow = `<tr><td>${numbers.join("")}</td><td>${regularDigits}</td><td>${goodDigits}</td></tr>`;
    tableBody.innerHTML = tableBody.innerHTML + newRow;
}

function winGame() {
    showMessage("success", `Adivinaste el número en ${attempts} intentos!`);
    document.querySelector("tbody tr:last-of-type").classList.add("bg-success");
    image.setAttribute("src", "images/homero-win.png");
    enable(false);
    btnNewGame.classList.remove("disabled");
}

btnResetGame.addEventListener("click", resetGame);

function resetGame() {
    attempts = 0;
    tableBody.innerHTML = "";
    showMessage("warning", "El número a adivinar sigue siendo el mismo.");
    image.setAttribute("src", "images/homero-playing.jpg");
}