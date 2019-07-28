function fetchAllRecipes() {
    fetch('http://localhost:8080/all-recipes')
        .then(function(response) {
            return response.json();
        })
        .then(function(recipes) {
            console.log(JSON.stringify(recipes));
            for (var i = 0; i < recipes.length; i++) {
                document.getElementById('recipes').innerHTML += '<td>' + recipes[i].name + '</td>';
                console.log(recipes[i].name);
            }
        });
}

function fetchScheduleRecipes() {
    var days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]

    fetch('http://localhost:8080/weekly-recipes')
        .then(function(response) {
            return response.json();
        })
        .then(function(recipes) {
            console.log(JSON.stringify(recipes));
            for (var i = 0; i < recipes.length; i++) {
                document.getElementById('recipes').innerHTML += '<tr> <th scope="row">' + days[i] + '</th> <td>' + recipes[i].name + '</td> </tr>';
                console.log(document.getElementById('recipes').innerHTML);
                console.log(recipes[i].name);
            }
        });
}

function submitRecipe(data) {
    console.log(data);
}

document.getElementById('new-recipe').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('click');
  });