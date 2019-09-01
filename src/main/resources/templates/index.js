let h1 = document.getElementById("expression")
fetch ("https://lanapracticederivatives.herokuapp.com")
    .then(res => {
        h1.innerHTML = res
    })
