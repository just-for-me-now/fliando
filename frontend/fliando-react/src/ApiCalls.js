document.addEventListener("DOMContentLoaded", () => {

        const originAddress = "http://localhost:8084/origins";

        fetch(originAddress).then(response => {
            return response.json();
        }).then(data => {

            let originSelect = document.getElementById("origin");
            data.data.forEach(element => {
                let option = document.createElement("option");
                option.setAttribute("value", element.name);
                originSelect.appendChild(option);

                let textOrigin = document.createTextNode(element["name"]);
                option.appendChild(textOrigin);
            });
        }
        ).catch(() => {
            console.log('Error');
        });
    })