let h1 = document.getElementById("expression")
fetch ("http://localhost:8080")
    .then(res => {
        h1.innerHTML = res
    })
