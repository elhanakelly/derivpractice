let h1 = document.getElementById("expression")
fetch ("https://lanaderivativepractice.herokuapp.com")
    .then(res => {
        h1.innerHTML = res
    })
