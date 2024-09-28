const buttons = document.querySelectorAll("#opcions button");

buttons.forEach((button) => {
    button.addEventListener("click", () => {
        buttons.forEach((b) => b.classList.remove("selected"));
            button.classList.add("selected");
    });
});
