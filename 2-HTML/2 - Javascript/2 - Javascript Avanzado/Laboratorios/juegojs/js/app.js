var inputs = document.querySelectorAll(".game-input input");
var alert = document.querySelector(".message");
var image = document.getElementById("img");
var list = document.getElementById("list-attempts");
var objetive = [];
var attempt = 0;

inputs.forEach(element => {
    element.setAttribute('min', "0");
    element.setAttribute('max', "9");
    element.addEventListener("keypress", function(e) {
        if (e.target.value.length === 1) {
            e.preventDefault();
        }
    });
});

document.getElementById("btnNewGame").addEventListener('click', newGame);
document.getElementById("btnResetGame").addEventListener('click', resetGame);
document.getElementById("btnGiveUp").addEventListener('click', giveUp);
document.getElementById("btnTryLuck").addEventListener('click', tryLuck);

function newGame() {
    objetive = generateRandomNumber(4);
    alert.classList.add("hidden");
    document.getElementById("btnResetGame").removeAttribute("disabled");
    document.getElementById("btnGiveUp").removeAttribute("disabled");
    document.getElementById("btnTryLuck").removeAttribute("disabled");
    image.classList = "img-new-game";
    list.innerHTML = "";

    enabledInputs(true);
}

function resetGame() {
    // objetivo = generateRandomNumber(4);
    // console.log(objetivo.split(" - "));
    // alert.classList.add("hidden");
}

function giveUp() {
    alert.classList.remove("hidden");
    alert.classList.remove("win-game");
    alert.classList.add("error");
    alert.innerHTML = `El número mágico era: ${objetive.join(" - ")}`;
    document.getElementById("btnResetGame").setAttribute("disabled", "disabled");
    document.getElementById("btnGiveUp").setAttribute("disabled", "disabled");
    document.getElementById("btnTryLuck").setAttribute("disabled", "disabled");
    enabledInputs(false);
    image.classList = "img-give-up";
}

function generateRandomNumber(size) {
    var numbers = [size];

    for (var i = 0; i < size;) {
        var randomNumber = Number.parseInt(Math.random() * 10);

        if (!numbers.includes(randomNumber)) {
            numbers[i] = randomNumber;
            i++;
        }
    }

    return numbers;
};

function validateInput() {
    var flag = "";

    for (var element of inputs) {
        if (element.value.length === 0) {
            flag = "Los números ingresados no son válidos, por favor rellene todas las cifras.";
            break;
        }
    }

    if (flag === "") {
        var checkRepeted = [];
        inputs.forEach(element => {
            if (!checkRepeted.includes(element.value)) {
                checkRepeted.push(element.value);
            }
        })

        if (checkRepeted.length < inputs.length) {
            flag = "Las cifras no deben repetirse, intente nuevamente.";
        }
    }

    // inputs.forEach(element => {
    //     if (element.value.length === 0) {
    //         flag = false;
    //         return flag;
    //     }
    // });

    return flag;
}

function tryLuck() {
    var flag = validateInput();

    if (flag !== "") {
        error(flag);
        image.classList = "img-wrong-input";
        return;
    }
    attempt++;

    var inputNumbers = getInputNumbers();

    var goodDigit = 0;
    var regularDigit = 0;

    for (var i = 0; i < objetive.length; i++) {
        if (inputNumbers[i] === objetive[i]) {
            goodDigit++;
        } else if (objetive.includes(inputNumbers[i])) {
            regularDigit++;
        }
    }

    if (goodDigit === objetive.length) {
        winGame();
    } else {
        showAttempt(goodDigit, regularDigit, inputNumbers.join(" - "));
    }

    console.log(`Regular digit: ${regularDigit} - Good Digit: ${goodDigit}`);
}

function error(message) {
    alert.classList.remove("hidden");
    alert.classList.remove("warning");
    alert.classList.add("error");
    alert.innerHTML = message;
}

function getInputNumbers() {
    var array = [];
    inputs.forEach(element => array.push(Number.parseInt(element.value)));

    console.log(array.join(" - "));

    return array;
}

function winGame() {
    image.classList = "img-win-game";
    alert.innerHTML = `Lograste salvar Springfield en ${attempt} ${attempt === 1? "intento" : "intentos"}, ¡FELICIDADES!`;
    alert.classList.remove("hidden");
    alert.classList.remove("error");
    alert.classList.add("win-game");

    document.getElementById("btnResetGame").setAttribute("disabled", "disabled");
    document.getElementById("btnGiveUp").setAttribute("disabled", "disabled");
    document.getElementById("btnTryLuck").setAttribute("disabled", "disabled");
    enabledInputs(false);
}

function showAttempt(goodDigit, regularDigit, inputNumber) {
    alert.classList.remove("hidden");
    alert.classList.remove("error");
    alert.classList.add("warning");
    alert.innerHTML = `No lograste adivinar el número. Cifras Regulares: ${regularDigit} - Cifras Buenas: ${goodDigit}`;
    var newItem = `<li><span>${inputNumber}</span>(Regular: ${regularDigit} - Buenas: ${goodDigit})</li>`;
    list.innerHTML = list.innerHTML + newItem;
    image.classList = "img-new-game";
}

function enabledInputs(flag) {
    if (flag) {
        inputs.forEach(element => {
            element.removeAttribute("disabled");
            element.value = "";
        });
    } else {
        inputs.forEach(element => element.setAttribute("disabled", "disabled"));
    }
}