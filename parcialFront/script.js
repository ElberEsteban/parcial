document.getElementById('climaForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const ciudad = document.getElementById('ciudad').value;
    const pais = document.getElementById('pais').value;
    const clima = document.getElementById('clima').value;
    const temperatura = document.getElementById('temperatura').value;

    const data = {
        ciudad: ciudad,
        pais: pais,
        clima: clima,
        temperatura: parseFloat(temperatura)
    };

    fetch('http://127.0.0.1:60456/ciudad/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        alert('Clima guardado con éxito');
        document.getElementById('climaForm').reset();
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('consultaForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const pais = document.getElementById('consultaPais').value;
    const ciudad = document.getElementById('consultaCiudad').value;

    fetch(`http://127.0.0.1:60456/ciudad/find?pais=${pais}&nombreCiudad=${ciudad}`)
    .then(response => response.json())
    .then(data => {
        const resultDiv = document.getElementById('result');
        
        if (data.ciudad && data.pais && data.clima && data.temperatura !== undefined) {
            resultDiv.innerHTML = `
                <h3>Resultado de la consulta:</h3>
                <p>Ciudad: ${data.ciudad}</p>
                <p>País: ${data.pais}</p>
                <p>Clima: ${data.clima}</p>
                <p>Temperatura: ${data.temperatura}°C</p>
            `;
        } else {
            resultDiv.innerHTML = `
                <h3>Resultado de la consulta:</h3>
                <p>Origen no registrado</p>
            `;
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al consultar el clima');
    });
});